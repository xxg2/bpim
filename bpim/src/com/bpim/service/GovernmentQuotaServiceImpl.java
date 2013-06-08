package com.bpim.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

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
import com.bpim.dao.GovernmentQuotaDAO;
import com.bpim.dao.GovernmentQuotaDAOImpl;
import com.bpim.entity.GovernmentQuota;
import com.bpim.entity.GovernmentQuotaRecord;
import com.bpim.enums.ExcelType;
import com.bpim.form.SearchDataCondition;
import com.bpim.helper.PageTools;

/**
 * author Delgado
 */
public class GovernmentQuotaServiceImpl implements GovernmentQuotaService {
	GovernmentQuotaDAO dao = new GovernmentQuotaDAOImpl();
	private static final Log LOG = LogFactory
			.getLog(ExcelDataServiceImpl.class);
	private static final int version2003 = 2003;
	private static final int version2007 = 2007;
	private static int version = version2003;
	private static String path = "WEB-INF/governmentQuota/";
	private String msg = "";

	public void deleteGovernmentQuota() throws SQLException {
		dao.deleteGovernmentQuota();
	}

	public String importGovernmentQuota(HttpServletRequest request)
			throws IOException, SQLException {
		String folderPath = request.getSession().getServletContext().getRealPath(path);
		LOG.error(folderPath);
		File file = new File(folderPath);
		File[] subFile = file.listFiles();
		String governmentQuotaClass = "";
		String governmentQuotaType = "";
		String governmentQuotaNum = "";
		String governmentQuotaName = "";
		String governmentQuotaModel = "";
		String governmentQuotaUnit = "";
		Double governmentQuotaAmount = 0.00;
		String area = PropertyConstants.SHANGHAI;

		Long id = null;
		String recordUnit = "";
		String recordType = "";

		int submitRowNumber = 0;
		int quotaRowNumber = 0;
		Row row;
		int numIndex;
		int nameIndex;
		int modelIndex;
		int unitIndex;
		int amountIndex;

		Cell numCell;
		Cell nameCell;
		Cell modelCell;
		Cell unitCell;
		Cell amountCell;
		Cell firstCell;

		for (int i = 0; i < subFile.length; i++) {
			String fileName = subFile[i].getName();
			File excelFile = new File(folderPath + fileName);
			Sheet sheet = getWb(excelFile, fileName);
			governmentQuotaClass = getClassFromName(fileName);
			int count_row = sheet.getLastRowNum();
			Hashtable<String, Integer> tableTitleTable = getTableTitle(sheet,
					ExcelTitleUtil.governmentQuotaTitleSet);
			for (int j = 0; j <= count_row; j++) {
				try {
					DBConnUtil.getConnection();
					DBConnUtil.startTransaction(false);
					List<GovernmentQuotaRecord> records = new LinkedList<GovernmentQuotaRecord>();
					numIndex = tableTitleTable.get(ExcelTitleUtil.recordNum);
					nameIndex = tableTitleTable.get(ExcelTitleUtil.recordName);
					modelIndex = tableTitleTable
							.get(ExcelTitleUtil.recordModel);
					unitIndex = tableTitleTable.get(ExcelTitleUtil.recordUnit);
					amountIndex = tableTitleTable
							.get(ExcelTitleUtil.recordAmount);
					// int priceIndex =
					// tableTitleTable.get(ExcelTitleUtil.recordPrice);
					// int totalPriceIndex =
					// tableTitleTable.get(ExcelTitleUtil.recordTotalPrice);

					row = sheet.getRow(j);
					numCell = row.getCell(numIndex);
					nameCell = row.getCell(nameIndex);
					modelCell = row.getCell(modelIndex);
					unitCell = row.getCell(unitIndex);
					amountCell = row.getCell(amountIndex);
					firstCell = row.getCell(0);

					// 过滤无效数据
					if (isBlank(numCell) && isBlank(nameCell)) {
						continue;
					}
					// 取得定额类型
					else if (isBlank(numCell) && !isBlank(nameCell)
							&& isBlank(unitCell) && isBlank(amountCell)) {
						governmentQuotaType = nameCell.getStringCellValue();
					}
					// 取得定额名称，编号
					else if (!isBlank(firstCell)) {
						governmentQuotaNum = numCell.getStringCellValue();
						governmentQuotaName = nameCell.getStringCellValue();
						governmentQuotaModel = modelCell.getStringCellValue();
						governmentQuotaUnit = unitCell.getStringCellValue();
						governmentQuotaAmount = amountCell
								.getNumericCellValue();
						GovernmentQuota data = new GovernmentQuota();
						data.setArea(area);
						data.setGovernmentQuotaAmount(governmentQuotaAmount);
						data.setGovernmentQuotaClass(governmentQuotaClass);
						data.setGovernmentQuotaModel(governmentQuotaModel);
						data.setGovernmentQuotaName(governmentQuotaName);
						data.setGovernmentQuotaNum(governmentQuotaNum);
						data.setGovernmentQuotaType(governmentQuotaType);
						data.setGovernmentQuotaUnit(governmentQuotaUnit);
						id = dao.importGovernmentQuota(data);
						quotaRowNumber++;
					}
					// 处理正式数据
					else if (isNumber(amountCell)) {
						GovernmentQuotaRecord record = new GovernmentQuotaRecord();
						record.setGovernmentQuotaId(id);
						record.setRecordModel(modelCell.getStringCellValue());
						record.setRecordName(nameCell.getStringCellValue());
						record.setRecordNum(numCell.getStringCellValue());
						record.setRecordAmount(amountCell.getNumericCellValue());
						recordUnit = unitCell.getStringCellValue();
						if ("".equals(recordUnit)) {
							recordUnit = PropertyConstants.UNKNOW;
						}
						record.setRecordUnit(recordUnit);
						recordType = getType(recordUnit);
						if (null == recordType) {
							LOG.error(PropertyConstants.FILE + fileName + PropertyConstants.THE + (j + 1)
									+ PropertyConstants.UNKNOWDEP + recordUnit);
							recordType = ExcelType.MATERIAL.toString();
							// return msg = "文件" + fileName + "第" + (j+1) +
							// "行未知工料机单位";
						}
						record.setRecordType(recordType);
						records.add(record);
						submitRowNumber++;
						if (records.size() > 0) {
							try {
								dao.importGovernmentQuotaRecord(records);
							} catch (SQLException e) {
								LOG.error(e);
								msg = PropertyConstants.IMPORTERROR;
								return msg;
							}
						}
					}
					DBConnUtil.endTransaction();
					DBConnUtil.close();
				} catch (Exception e) {
					LOG.error(e);
					DBConnUtil.close();
					return msg = PropertyConstants.FILE + fileName + PropertyConstants.THE + (j + 1) + PropertyConstants.LINE + PropertyConstants.WRONG;
				}
			}
		}

		msg = quotaRowNumber + PropertyConstants.TOTLEQUOTA + submitRowNumber + PropertyConstants.TOTLEIMPORT;
		return msg;
	}

	private String getType(String recordUnit) {
		if (ExcelTitleUtil.peopleUnitSet.contains(recordUnit)) {
			return ExcelType.MENWORK.toString();
		} else if (ExcelTitleUtil.machineUnitSet.contains(recordUnit)) {
			return ExcelType.MACHINE.toString();
		} else {
			return ExcelType.MATERIAL.toString();
		}
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
				if (null != cell && cell.getCellType() == cell.CELL_TYPE_STRING) {
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

	private String getClassFromName(String fileName) {
		int index = fileName.indexOf("(");
		return fileName.substring(0, index);
	}

	private Sheet getWb(File peopleData, String fileName) throws IOException {
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

	private Boolean isBlank(Cell cell) {
		return cell.getCellType() == cell.CELL_TYPE_BLANK;
	}

	private Boolean isString(Cell cell) {
		return cell.getCellType() == cell.CELL_TYPE_STRING;
	}

	private Boolean isNumber(Cell cell) {
		return cell.getCellType() == cell.CELL_TYPE_NUMERIC;
	}

	
	public List<GovernmentQuota> searchGovernmentQuota(
			SearchDataCondition condition, PageTools page) throws SQLException {
		DBConnUtil.getConnection();
		if (page != null) {
			if (page.getRecordCount() == 0) {
				int count = dao.countSearchGovernmentQuota(condition);
				page.setRecordCount(count);
			}
			condition.setStartRow(page.getPageStartRow());
			condition.setPageSize(page.getPageSize());
		}
		List<GovernmentQuota> list = dao.searchGovernmentQuota(condition);
		DBConnUtil.close();
		return list;
	}

	public List<GovernmentQuotaRecord> viewGovernmentQuotaDetail(Long id) throws SQLException {
		DBConnUtil.getConnection();
		List<GovernmentQuotaRecord> list = dao.searchGovernmentQuotaRecord(id);
		DBConnUtil.close();
		return list;
	}

	public GovernmentQuota getQuotaById(Long id) throws SQLException {
		DBConnUtil.getConnection();
		GovernmentQuota data = dao.getQuotaById(id);
		DBConnUtil.close();
		return data;
	}
}
