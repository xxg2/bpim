package com.bpim.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.bpim.common.DBConnUtil;
import com.bpim.common.ExcelTitleUtil;
import com.bpim.common.PropertyConstants;
import com.bpim.dao.ExcelDataDAO;
import com.bpim.dao.ExcelDataDAOImpl;
import com.bpim.entity.CustomAndGuideData;
import com.bpim.entity.UserProjectUploadData;
import com.bpim.web.action.LoginAction;

/**
 * author Delgado
 */
public class ExcelDataServiceImpl implements ExcelDataService {
	private static final Log LOG = LogFactory.getLog(ExcelDataServiceImpl.class);
	private ExcelDataDAO excelDataDAO = ExcelDataDAOImpl.getInstance();
	private static final int version2003 = 2003;
	private static final int version2007 = 2007;
	private static int version = version2003;
	private String msg = "";

	public String processUserProjectData(File uploadUserProjectData,
			String area, Timestamp projectDate,
			String uploadUserProjectDataType,
			String uploadUserProjectDataInput, Long userId) throws IOException {
		Sheet sheet = getWb(uploadUserProjectData, uploadUserProjectDataInput);
		Row row = null;
		Cell cell = null;
		Cell numCell = null;
		Cell priceCell = null;
		Cell firstCell = null;
		int count_row = sheet.getLastRowNum();
		int submitRowNumber = 0;
		List<UserProjectUploadData> dataList = new ArrayList<UserProjectUploadData>();
		Hashtable<String, Integer> tableTitleTable = getTableTitle(sheet,
				ExcelTitleUtil.userProjectDataTitleSet);
		msg = checkTableTitle(tableTitleTable,
				ExcelTitleUtil.userProjectDataTitleSet);
		if (!"".equals(msg)) {
			return msg;
		}

		String projectName = getProjectName(uploadUserProjectDataInput);
		String projectSubName = "";
		String governmentQuotaNum = "";
		String governmentQuotaName = "";
		String governmentQuotaType = "";
		String governmentQuotaUnit = "";
		Double governmentQuotaPrice = 0.00;
		Double governmentQuotaGross = 0.00;
		Double governmentQuotaTotalPrice = 0.00;

		String recordType = "";
		for (int i = 0; i <= count_row; i++) {
			try {
				row = sheet.getRow(i);

				// 过滤不合法数据,如果不是工料机，则是小项目名称
				int recordNumIndex = tableTitleTable
						.get(ExcelTitleUtil.recordNum);
				numCell = row.getCell(recordNumIndex);
				int recordPriceIndex = tableTitleTable
						.get(ExcelTitleUtil.recordPrice);
				priceCell = row.getCell(recordPriceIndex);
				if (isBlank(numCell) && isBlank(priceCell)) {
					String temp = row.getCell(
							tableTitleTable.get(ExcelTitleUtil.recordName))
							.getStringCellValue();
					if (ExcelTitleUtil.subType.contains(temp)) {
						recordType = temp;
						continue;
					} else if (!"".equals(temp)) {
						projectSubName = temp;
						continue;
					}
				}

				// 过滤表头行
				if (ExcelTitleUtil.recordNum.equals(numCell
						.getStringCellValue())) {
					continue;
				}

				// 找到定额数据
				firstCell = row.getCell(0);
				if (!isBlank(firstCell)) {
					if (!"".equals(trim(row.getCell(
							tableTitleTable.get(ExcelTitleUtil.recordNum))
							.getStringCellValue()))) {
						governmentQuotaNum = trim(row.getCell(
								tableTitleTable.get(ExcelTitleUtil.recordNum))
								.getStringCellValue());
					}
					if (!"".equals(trim(row.getCell(
							tableTitleTable.get(ExcelTitleUtil.recordName))
							.getStringCellValue()))) {
						governmentQuotaName = trim(row.getCell(
								tableTitleTable.get(ExcelTitleUtil.recordName))
								.getStringCellValue());
					}
					if (!"".equals(trim(row.getCell(
							tableTitleTable.get(ExcelTitleUtil.recordClasses))
							.getStringCellValue()))) {
						governmentQuotaType = trim(row.getCell(
								tableTitleTable
										.get(ExcelTitleUtil.recordClasses))
								.getStringCellValue());
					}
					if (!"".equals(row.getCell(
							tableTitleTable.get(ExcelTitleUtil.recordUnit))
							.getStringCellValue())) {
						governmentQuotaUnit = row
								.getCell(
										tableTitleTable
												.get(ExcelTitleUtil.recordUnit))
								.getStringCellValue();
					}
					if (!"".equals(row.getCell(
							tableTitleTable.get(ExcelTitleUtil.recordPrice))
							.getNumericCellValue())) {
						governmentQuotaPrice = row
								.getCell(
										tableTitleTable
												.get(ExcelTitleUtil.recordPrice))
								.getNumericCellValue();
					}
					if (!"".equals(row.getCell(
							tableTitleTable.get(ExcelTitleUtil.recordGross))
							.getNumericCellValue())) {
						governmentQuotaGross = row
								.getCell(
										tableTitleTable
												.get(ExcelTitleUtil.recordGross))
								.getNumericCellValue();
					}
					if (!"".equals(row.getCell(
							tableTitleTable
									.get(ExcelTitleUtil.recordTotalPrice))
							.getNumericCellValue())) {
						governmentQuotaTotalPrice = row.getCell(
								tableTitleTable
										.get(ExcelTitleUtil.recordTotalPrice))
								.getNumericCellValue();
					}

					continue;
				}

				// 处理正式数据
				msg = checkProjectDataRecord(row, i, tableTitleTable);
				if (!"".equals(msg)) {
					return msg;
				}

				UserProjectUploadData data = new UserProjectUploadData();
				data.setArea(area);
				data.setProjectName(projectName);
				data.setProjectDate(projectDate);
				data.setProjectSubName(projectSubName);
				data.setUserInfoId(userId);
				data.setDataType(uploadUserProjectDataType);
				data.setGovernmentQuotaGross(governmentQuotaGross);
				data.setGovernmentQuotaName(governmentQuotaName);
				data.setGovernmentQuotaNum(governmentQuotaNum);
				data.setGovernmentQuotaUnit(governmentQuotaUnit);
				data.setGovernmentQuotaPrice(governmentQuotaPrice);
				data.setGovernmentQuotaTotalPrice(governmentQuotaTotalPrice);
				data.setGovernmentQuotaType(governmentQuotaType);
				data.setRecordImportDate(new Timestamp(new Date().getTime()));

				data.setRecordName(trim(row.getCell(
						tableTitleTable.get(ExcelTitleUtil.recordName))
						.getStringCellValue()));
				data.setRecordNum(trim(row.getCell(
						tableTitleTable.get(ExcelTitleUtil.recordNum))
						.getStringCellValue()));
				data.setRecordPrice(row.getCell(
						tableTitleTable.get(ExcelTitleUtil.recordPrice))
						.getNumericCellValue());
				data.setRecordUnit(row.getCell(
						tableTitleTable.get(ExcelTitleUtil.recordUnit))
						.getStringCellValue());
				data.setRecordTotalGross(row.getCell(
						tableTitleTable.get(ExcelTitleUtil.recordGross))
						.getNumericCellValue());
				data.setRecordTotalPrice(row.getCell(
						tableTitleTable.get(ExcelTitleUtil.recordTotalPrice))
						.getNumericCellValue());
				data.setRecordType(recordType);
				submitRowNumber++;
				dataList.add(data);

			} catch (Exception e) {
				LOG.error(e);
				msg = PropertyConstants.THE + (i + 1) + PropertyConstants.WRONGNUMBER;
				return msg;
			}
		}

		if (dataList.size() > 0) {
			try {
				DBConnUtil.getConnection();
				DBConnUtil.startTransaction(false);
				excelDataDAO.importUserProjectDataToDB(dataList);
				DBConnUtil.endTransaction();
				DBConnUtil.close();
			} catch (SQLException e) {
				LOG.error(e);
				msg = PropertyConstants.IMPORTERROR;
				return msg;
			}
		}
		msg = submitRowNumber + PropertyConstants.TOTLEIMPORT;
		return msg;
	}

	private String checkProjectDataRecord(Row row, int i,
			Hashtable<String, Integer> tableTitleTable) {
		if (isBlank(row.getCell(tableTitleTable.get(ExcelTitleUtil.recordUnit)))
				&& isBlank(row.getCell(tableTitleTable
						.get(ExcelTitleUtil.recordPrice)))
				&& isBlank(row.getCell(tableTitleTable
						.get(ExcelTitleUtil.recordGross)))) {
			// 这种情况是其他费用
		} else if (isBlank(row.getCell(tableTitleTable
				.get(ExcelTitleUtil.recordName)))) {
			return PropertyConstants.THE + (i + 1) + PropertyConstants.LINE + ExcelTitleUtil.recordName + PropertyConstants.NOTNULL;
		} else if (isBlank(row.getCell(tableTitleTable
				.get(ExcelTitleUtil.recordUnit)))) {
			return PropertyConstants.THE + (i + 1) + PropertyConstants.LINE + ExcelTitleUtil.recordUnit + PropertyConstants.NOTNULL;
		} else if (trim(
				row.getCell(tableTitleTable.get(ExcelTitleUtil.recordName))
						.getStringCellValue()).length() > 50) {
			return PropertyConstants.THE + (i + 1) + PropertyConstants.LINE + ExcelTitleUtil.recordName + PropertyConstants.LESSTHANFIFTY;
		} else if (trim(
				row.getCell(tableTitleTable.get(ExcelTitleUtil.recordUnit))
						.getStringCellValue()).length() > 10) {
			return PropertyConstants.THE + (i + 1) + PropertyConstants.LINE + ExcelTitleUtil.recordUnit + PropertyConstants.LESSTHANTEN;
		} else if (row.getCell(tableTitleTable.get(ExcelTitleUtil.recordPrice))
				.getNumericCellValue() > 9999999999999.00) {
			return PropertyConstants.THE + (i + 1) + PropertyConstants.LINE + ExcelTitleUtil.recordPrice
					+ PropertyConstants.LESSTHANTHIRTING;
		} else if (row.getCell(tableTitleTable.get(ExcelTitleUtil.recordGross))
				.getNumericCellValue() > 9999999999999.00) {
			return PropertyConstants.THE + (i + 1) + PropertyConstants.LINE + ExcelTitleUtil.recordGross
					+ PropertyConstants.LESSTHANTHIRTING;
		} else if (row.getCell(
				tableTitleTable.get(ExcelTitleUtil.recordTotalPrice))
				.getNumericCellValue() > 9999999999999.00) {
			return PropertyConstants.THE + (i + 1) + PropertyConstants.LINE + ExcelTitleUtil.recordTotalPrice
					+ PropertyConstants.LESSTHANTHIRTING;
		}
		return "";
	}

	private String getProjectName(String uploadUserProjectDataInput) {
		while (uploadUserProjectDataInput.indexOf("\\") > -1) {
			uploadUserProjectDataInput = uploadUserProjectDataInput.substring(
					uploadUserProjectDataInput.indexOf("\\") + 1,
					uploadUserProjectDataInput.length());
		}
		int dotIndex = uploadUserProjectDataInput.indexOf(".");
		return uploadUserProjectDataInput.substring(0, dotIndex);
	}

	private Boolean isBlank(Cell cell) {
		return cell.getCellType() == cell.CELL_TYPE_BLANK;
	}

	private Boolean isString(Cell cell) {
		return cell.getCellType() == cell.CELL_TYPE_STRING;
	}

	private Boolean isNumber(Cell cell) {
		return cell.getCellType() == cell.CELL_TYPE_NUMERIC;
	}

	private String checkTableTitle(Hashtable<String, Integer> tableTitleTable,
			Set<String> set) {
		Iterator<String> i = set.iterator();
		String orgTitle;
		while (i.hasNext()) {
			Boolean exist = false;
			orgTitle = i.next();
			Object index = tableTitleTable.get(orgTitle);
			if (index != null && (Integer) index > -1) {
				exist = true;
				continue;
			} else {
				return orgTitle + PropertyConstants.CHANNELNOTEXIST;
			}
		}
		return "";
	}

	private Hashtable<String, Integer> getTableTitle(Sheet sheet,
			Set<String> set) {
		Row row;
		Cell cell;
		String title = "";
		Hashtable<String, Integer> titleMappings = new Hashtable<String, Integer>();
		try {
			row = sheet.getRow(3);
			int cellCount = row.getLastCellNum();
			for (int i = 0; i <= cellCount; i++) {
				cell = row.getCell(i);
				if (null!= cell && cell.getCellType() == cell.CELL_TYPE_STRING) {
					title = trim(cell.getStringCellValue());
					if (set.contains(title)) {
						titleMappings.put(title, i);
					}
				}
			}
		} catch (Exception e) {
			LOG.error(e);
			msg = PropertyConstants.ANALYSISFAILED;
		}
		return titleMappings;
	}

	private Sheet getWb(File peopleData, String fileName) throws IOException{
		Workbook wb = null;
		if (fileName.endsWith(PropertyConstants.XLSSUFFIX))
			version = version2003;
		else if (fileName.endsWith(PropertyConstants.XLSXSUFFIX))
			version = version2007;
		InputStream stream = null;
		if (version == version2003) {
			stream = new FileInputStream(peopleData);
			wb = (Workbook) new HSSFWorkbook(stream);
		} else if (version == version2007) {
			wb = (Workbook) new XSSFWorkbook(peopleData.getAbsolutePath());
		}
		return wb.getSheetAt(0);
	}

	public static String trim(String Str) {
		String newstr = Str.replaceAll("　", "  ");
		newstr = newstr.trim();
		newstr = newstr.replaceAll("  ", "　");
		return newstr;
	}

	public String processUserCustomData(File uploadUserCustomData, String area,
			String uploadUserCustomDataInput, Long userId,String type) throws IOException {
		Sheet sheet = getWb(uploadUserCustomData, uploadUserCustomDataInput);
		Row row = null;
		int count_row = sheet.getLastRowNum();
		int submitRowNumber = 0;
		List<CustomAndGuideData> dataList = new ArrayList<CustomAndGuideData>();
		Hashtable<String, Integer> tableTitleTable = getTableTitle(sheet,
				ExcelTitleUtil.userCustomDataTitleSet);
		msg = checkTableTitle(tableTitleTable,
				ExcelTitleUtil.userCustomDataTitleSet);
		if (!"".equals(msg)) {
			return msg;
		}

		for (int i = 0; i <= count_row; i++) {
			try {
				row = sheet.getRow(i);

				if (!validateCustomData(row, tableTitleTable)) {
					continue;
				}

				CustomAndGuideData data = new CustomAndGuideData();
				data.setArea(area);
				data.setUserInfoId(userId);
				data.setRecordImportDate(new Timestamp(new Date().getTime()));

				if(trim(row.getCell(
						tableTitleTable.get(ExcelTitleUtil.recordName))
						.getStringCellValue()).length()>30){
					System.out.print(i);
				}
				data.setRecordName(trim(row.getCell(
						tableTitleTable.get(ExcelTitleUtil.recordName))
						.getStringCellValue()));
				data.setRecordNum(trim(row.getCell(
						tableTitleTable.get(ExcelTitleUtil.recordCode))
						.getStringCellValue()));
				data.setRecordModel(trim(row.getCell(
						tableTitleTable.get(ExcelTitleUtil.recordModel))
						.getStringCellValue()));
				data.setRecordType(trim(row.getCell(
						tableTitleTable.get(ExcelTitleUtil.recordType))
						.getStringCellValue()));
				data.setRecordPrice(row.getCell(
						tableTitleTable.get(ExcelTitleUtil.recordPrice))
						.getNumericCellValue());
				data.setRecordUnit(row.getCell(
						tableTitleTable.get(ExcelTitleUtil.recordUnit))
						.getStringCellValue());
				data.setRecordTotalPrice(row.getCell(
						tableTitleTable.get(ExcelTitleUtil.recordTotalPrice))
						.getNumericCellValue());
				data.setRecordGross(row.getCell(
						tableTitleTable.get(ExcelTitleUtil.recordAmount))
						.getNumericCellValue());
				data.setRecordPercent(row.getCell(
						tableTitleTable.get(ExcelTitleUtil.recordPercent))
						.getNumericCellValue());
				String dataDate = row.getCell(
						tableTitleTable.get(ExcelTitleUtil.recordGuideDate))
						.getStringCellValue();
				SimpleDateFormat sdf = new SimpleDateFormat("yy-MM");
				Date temp = sdf.parse(dataDate);
				data.setRecordDate(new Timestamp(temp.getTime()));
				submitRowNumber++;
				dataList.add(data);

			} catch (Exception e) {
				LOG.error(e);
				msg = PropertyConstants.THE + (i + 1) + PropertyConstants.WRONGNUMBER;
				return msg;
			}
		}

		if (dataList.size() > 0) {
			try {
				DBConnUtil.getConnection();
				DBConnUtil.startTransaction(false);
				excelDataDAO.importCustomProjectDataToDB(dataList,type);
				DBConnUtil.endTransaction();
				DBConnUtil.close();
			} catch (SQLException e) {
				LOG.error(e);
				msg = PropertyConstants.IMPORTERROR;
				return msg;
			}
		}
		msg = submitRowNumber + PropertyConstants.TOTLEIMPORT;
		return msg;
	}

	private boolean validateCustomData(Row row,
			Hashtable<String, Integer> tableTitleTable) {
		// 过滤不合法数据
		if (isBlank(row.getCell(tableTitleTable.get(ExcelTitleUtil.recordName)))
				|| isBlank(row.getCell(tableTitleTable
						.get(ExcelTitleUtil.recordCode)))
				|| isBlank(row.getCell(tableTitleTable
						.get(ExcelTitleUtil.recordUnit)))
				|| isBlank(row.getCell(tableTitleTable
						.get(ExcelTitleUtil.recordPrice)))
				|| isBlank(row.getCell(tableTitleTable
						.get(ExcelTitleUtil.recordAmount)))
				|| isBlank(row.getCell(tableTitleTable
						.get(ExcelTitleUtil.recordType)))
				|| isBlank(row.getCell(tableTitleTable
						.get(ExcelTitleUtil.recordGuideDate)))
						||isString(row.getCell(tableTitleTable.get(ExcelTitleUtil.recordPrice)))) {
			return false;
		}
		return true;
	}
}
