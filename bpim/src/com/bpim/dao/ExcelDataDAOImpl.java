package com.bpim.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.bpim.common.DBConnUtil;
import com.bpim.common.PropertyConstants;
import com.bpim.entity.CustomAndGuideData;
import com.bpim.entity.UserProjectUploadData;

/**
 * author Delgado
 */
public class ExcelDataDAOImpl implements ExcelDataDAO {
	static ExcelDataDAOImpl excelDataDAOImpl = new ExcelDataDAOImpl();

	public static ExcelDataDAO getInstance() {
		return excelDataDAOImpl;
	}

	private static final String insertProjectDataSql = "INSERT INTO USER_PROJECT_DATA(DATA_TYPE, AREA , PROJECT_DATE, USER_INFO_ID, "
			+ "PROJECT_NAME,PROJECT_SUB_NAME,GOVERNMENT_QUOTA_NUM ,"
			+ "GOVERNMENT_QUOTA_NAME,GOVERNMENT_QUOTA_TYPE ,GOVERNMENT_QUOTA_GROSS ,"
			+ "GOVERNMENT_QUOTA_TOTAL_PRICE,RECORD_NAME ,RECORD_NUM ,RECORD_TYPE ,RECORD_UNIT,"
			+ "RECORD_PRICE,RECORD_TOTAL_GROSS,RECORD_TOTAL_PRICE,RECORD_IMPORT_DATE, GOVERNMENT_QUOTA_UNIT,GOVERNMENT_QUOTA_PRICE ) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	private static final String insertCustomDataSql = "INSERT INTO USER_CUSTOM_DATA(AREA,USER_INFO_ID ," +
			"RECORD_NAME ,RECORD_NUM ,RECORD_MODEL ,RECORD_TYPE,RECORD_UNIT ," +
			"RECORD_PRICE,RECORD_GROSS ,RECORD_TOTAL_PRICE ,RECORD_PERCENT,RECORD_DATE, RECORD_IMPORT_DATE" +
			" ) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";

	private static final String insertGuideDataSql = "INSERT INTO GOVERNMENT_GUIDE_DATA(AREA,USER_INFO_ID ," +
	"RECORD_NAME ,RECORD_NUM ,RECORD_MODEL ,RECORD_TYPE,RECORD_UNIT ," +
	"RECORD_PRICE,RECORD_GROSS ,RECORD_TOTAL_PRICE ,RECORD_PERCENT,RECORD_DATE, RECORD_IMPORT_DATE" +
	" ) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
	public void importUserProjectDataToDB(
			List<UserProjectUploadData> dataList) throws SQLException {
		PreparedStatement stat = DBConnUtil.getPrepareStatement(insertProjectDataSql);
		for (UserProjectUploadData data : dataList) {
			stat.setString(1, data.getDataType());
			stat.setString(2, data.getArea());
			stat.setTimestamp(3, data.getProjectDate());
			stat.setLong(4, data.getUserInfoId());
			stat.setString(5, data.getProjectName());
			stat.setString(6, data.getProjectSubName());
			stat.setString(7, data.getGovernmentQuotaNum());
			stat.setString(8, data.getGovernmentQuotaName());
			stat.setString(9, data.getGovernmentQuotaType());
			stat.setDouble(10, data.getGovernmentQuotaGross());
			stat.setDouble(11, data.getGovernmentQuotaTotalPrice());
			stat.setString(12, data.getRecordName());
			stat.setString(13, data.getRecordNum());
			stat.setString(14, data.getRecordType());
			stat.setString(15, data.getRecordUnit());
			stat.setDouble(16, data.getRecordPrice());
			stat.setDouble(17, data.getRecordTotalGross());
			stat.setDouble(18, data.getRecordTotalPrice());
			stat.setTimestamp(19, data.getRecordImportDate());
			stat.setString(20, data.getGovernmentQuotaUnit());
			stat.setDouble(21, data.getGovernmentQuotaPrice());
			stat.execute();
		}
	}
	
	public void importCustomProjectDataToDB(List<CustomAndGuideData> dataList,String type) throws SQLException {
		String sql = "";
		if(PropertyConstants.USERDEFINEDPRICE.equals(type)){
			sql = insertCustomDataSql;
		}else if(PropertyConstants.GOVGUIDEPRICE.equals(type)){
			sql = insertGuideDataSql;
		}
		PreparedStatement stat = DBConnUtil.getPrepareStatement(sql);
		for (CustomAndGuideData data : dataList) {
			stat.setString(1, data.getArea());
			stat.setLong(2, data.getUserInfoId());
			stat.setString(3, data.getRecordName());
			stat.setString(4, data.getRecordNum());
			stat.setString(5, data.getRecordModel());
			stat.setString(6, data.getRecordType());
			stat.setString(7, data.getRecordUnit());
			stat.setDouble(8, data.getRecordPrice());
			stat.setDouble(9, data.getRecordGross());
			stat.setDouble(10, data.getRecordTotalPrice());
			stat.setDouble(11, data.getRecordPercent());
			stat.setTimestamp(12, data.getRecordDate());
			stat.setTimestamp(13, data.getRecordImportDate());
			stat.execute();
		}
	}

}
