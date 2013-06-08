package com.bpim.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.bpim.common.DBConnUtil;
import com.bpim.entity.PersonalQuotaAnalyseData;
import com.bpim.entity.PersonalRecordAnalyseData;
import com.bpim.entity.UserProjectUploadData;
import com.bpim.form.SearchDataCondition;

/**
 * author Delgado
 */
public class UserProjectDataOperatingDAOImpl implements
		UserProjectDataOperatingDAO {
	private static String sqlBuilder = "SELECT * FROM USER_PROJECT_DATA WHERE 1=1";
	private static String countBuilder = "SELECT COUNT(*) FROM USER_PROJECT_DATA WHERE 1=1";
	private static String deleteDataSql = "DELETE FROM USER_PROJECT_DATA WHERE ID=?";
	private static String modifyDataSql = "UPDATE USER_PROJECT_DATA SET PROJECT_SUB_NAME=?,GOVERNMENT_QUOTA_NUM =?,"
			+ "GOVERNMENT_QUOTA_NAME=?,GOVERNMENT_QUOTA_TYPE =?,GOVERNMENT_QUOTA_GROSS =?,"
			+ "GOVERNMENT_QUOTA_TOTAL_PRICE=?,RECORD_NAME =?,RECORD_NUM =?,RECORD_TYPE =?,RECORD_UNIT=?,"
			+ "RECORD_PRICE=?,RECORD_TOTAL_GROSS=?,RECORD_TOTAL_PRICE=?,RECORD_MODIFY_DATE=?,PROJECT_DATE=? WHERE ID=?";

	private static String avgUserProjectDataSqlBuilder = "SELECT AVG(RECORD_PRICE) FROM USER_PROJECT_DATA WHERE 1=1";
	private static String maxUserProjectDataSqlBuilder = "SELECT MAX(RECORD_PRICE) FROM USER_PROJECT_DATA WHERE 1=1";
	private static String minUserProjectDataSqlBuilder = "SELECT MIN(RECORD_PRICE) FROM USER_PROJECT_DATA WHERE 1=1";

	private static String getRecordByQuotaSql = "SELECT DISTINCT(RECORD_NAME),RECORD_UNIT,CASE RECORD_TYPE WHEN '人工' THEN 1 WHEN '材料' THEN 2 WHEN '机械' THEN 3 END AS DEF_ORDER " +
			"FROM USER_PROJECT_DATA WHERE 1=1";
	
	private static String avgRecordByNameAndUnit = "SELECT AVG(RECORD_PRICE) AS AVG_PRICE ,AVG(RECORD_TOTAL_GROSS) AS AVG_GROSS, AVG(RECORD_TOTAL_PRICE) AVG_GROSS " +
	"FROM USER_PROJECT_DATA WHERE RECORD_UNIT=?  AND RECORD_NAME=?"; 
	
	private static String queryCompanyQuotaByCondtionSql = "SELECT AREA , GOVERNMENT_QUOTA_NUM,GOVERNMENT_QUOTA_NAME," +
			"GOVERNMENT_QUOTA_UNIT,GOVERNMENT_QUOTA_GROSS FROM USER_PROJECT_DATA WHERE AREA LIKE ? AND GOVERNMENT_QUOTA_TYPE = ? ";
	
	public List<UserProjectUploadData> searchProjectDataByCondition(
			SearchDataCondition condition) throws SQLException {

		StringBuilder sql = new StringBuilder(sqlBuilder);
		if ((!"".equals(condition.getRecordUnit()))
				&& null != condition.getRecordUnit()) {
			sql.append(" AND RECORD_UNIT=?");
		}
		if ((!"".equals(condition.getDataType()))
				&& null != condition.getDataType()
				&& (!"0".equals(condition.getDataType()))) {
			sql.append(" AND DATA_TYPE=?");
		}
		if ((!"".equals(condition.getRecordName()))
				&& null != condition.getRecordName()) {
			sql.append(" AND RECORD_NAME=?");
		}
		if ((!"".equals(condition.getQuotaNum()))
				&& null != condition.getQuotaNum()) {
			sql.append(" AND GOVERNMENT_QUOTA_NUM=?");
		}
		if ((!"".equals(condition.getRecordType()) && (!"0".equals(condition
				.getRecordType()))) && null != condition.getRecordType()) {
			sql.append(" AND RECORD_TYPE=?");
		}
		if ((!"".equals(condition.getQuotaName()))
				&& null != condition.getQuotaName()) {
			sql.append(" AND GOVERNMENT_QUOTA_NAME=?");
		}
		if ((!"".equals(condition.getProjectName()))
				&& null != condition.getProjectName()) {
			sql.append(" AND PROJECT_NAME like ?");
		}
		if ((!"".equals(condition.getDataDateAfter()))
				&& null != condition.getDataDateAfter()) {
			sql.append(" AND PROJECT_DATE >= ?");
		}
		if ((!"".equals(condition.getDataDateBefore()))
				&& null != condition.getDataDateBefore()) {
			sql.append(" AND PROJECT_DATE <= ?");
		}
		if (condition.getUserInfoId() != 0) {
			sql.append(" AND USER_INFO_ID=?");
		}
		sql.append(" ORDER BY RECORD_IMPORT_DATE DESC");
		sql.append(" LIMIT ?, ?");
		PreparedStatement stat = DBConnUtil.getPrepareStatement(sql.toString());
		int i = 1;

		if ((!"".equals(condition.getRecordUnit()))
				&& null != condition.getRecordUnit()) {
			stat.setString(i, condition.getRecordUnit());
			i++;
		}
		if ((!"".equals(condition.getDataType()) && (!"0".equals(condition
				.getDataType()))) && null != condition.getDataType()) {
			stat.setString(i, condition.getDataType());
			i++;
		}
		if ((!"".equals(condition.getRecordName()))
				&& null != condition.getRecordName()) {
			stat.setString(i, condition.getRecordName());
			i++;
		}
		if ((!"".equals(condition.getQuotaNum()))
				&& null != condition.getQuotaNum()) {
			stat.setString(i, condition.getQuotaNum());
			i++;
		}
		if ((!"".equals(condition.getRecordType()) && (!"0".equals(condition
				.getRecordType()))) && null != condition.getRecordType()) {
			stat.setString(i, condition.getRecordType());
			i++;
		}
		if ((!"".equals(condition.getQuotaName()))
				&& null != condition.getQuotaName()) {
			stat.setString(i, condition.getQuotaName());
			i++;
		}
		if ((!"".equals(condition.getProjectName()))
				&& null != condition.getProjectName()) {
			stat.setString(i, "%" + condition.getProjectName() + "%");
			i++;
		}
		if ((!"".equals(condition.getDataDateAfter()))
				&& null != condition.getDataDateAfter()) {
			stat.setTimestamp(i, condition.getDataDateAfter());
			i++;
		}
		if ((!"".equals(condition.getDataDateBefore()))
				&& null != condition.getDataDateBefore()) {
			stat.setTimestamp(i, condition.getDataDateBefore());
			i++;
		}
		if (condition.getUserInfoId() != 0) {
			stat.setLong(i, condition.getUserInfoId());
			i++;
		}
		stat.setInt(i, condition.getStartRow());
		stat.setInt(i + 1, condition.getPageSize());
		ResultSet result = stat.executeQuery();
		List<UserProjectUploadData> datas = new ArrayList<UserProjectUploadData>();
		while (result.next()) {
			UserProjectUploadData data = new UserProjectUploadData();
			data.setArea(result.getString("AREA"));
			data.setGovernmentQuotaGross(result
					.getDouble("GOVERNMENT_QUOTA_GROSS"));
			data.setGovernmentQuotaName(result
					.getString("GOVERNMENT_QUOTA_NAME"));
			data.setGovernmentQuotaNum(result.getString("GOVERNMENT_QUOTA_NUM"));
			data.setGovernmentQuotaTotalPrice(result
					.getDouble("GOVERNMENT_QUOTA_TOTAL_PRICE"));
			data.setGovernmentQuotaType(result
					.getString("GOVERNMENT_QUOTA_TYPE"));
			data.setId(result.getLong("ID"));
			data.setProjectDate(result.getTimestamp("PROJECT_DATE"));
			data.setProjectName(result.getString("PROJECT_NAME"));
			data.setProjectSubName(result.getString("PROJECT_SUB_NAME"));
			data.setRecordImportDate(result.getTimestamp("RECORD_IMPORT_DATE"));
			data.setRecordName(result.getString("RECORD_NAME"));
			data.setRecordNum(result.getString("RECORD_NUM"));
			data.setRecordPrice(result.getDouble("RECORD_PRICE"));
			data.setRecordTotalGross(result.getDouble("RECORD_TOTAL_GROSS"));
			data.setRecordTotalPrice(result.getDouble("RECORD_TOTAL_PRICE"));
			data.setRecordType(result.getString("RECORD_TYPE"));
			data.setRecordUnit(result.getString("RECORD_UNIT"));
			data.setUserInfoId(result.getLong("USER_INFO_ID"));
			datas.add(data);
		}
		return datas;
	}

	public int getRowCount(SearchDataCondition condition) throws SQLException {
		StringBuilder sql = new StringBuilder(countBuilder);
		if ((!"".equals(condition.getRecordUnit()))
				&& null != condition.getRecordUnit()) {
			sql.append(" AND RECORD_UNIT=?");
		}
		if ((!"".equals(condition.getDataType()))
				&& null != condition.getDataType()
				&& (!"0".equals(condition.getDataType()))) {
			sql.append(" AND DATA_TYPE=?");
		}
		if ((!"".equals(condition.getRecordName()))
				&& null != condition.getRecordName()) {
			sql.append(" AND RECORD_NAME=?");
		}
		if ((!"".equals(condition.getQuotaNum()))
				&& null != condition.getQuotaNum()) {
			sql.append(" AND GOVERNMENT_QUOTA_NUM=?");
		}
		if ((!"".equals(condition.getRecordType()) && (!"0".equals(condition
				.getRecordType()))) && null != condition.getRecordType()) {
			sql.append(" AND RECORD_TYPE=?");
		}
		if ((!"".equals(condition.getQuotaName()))
				&& null != condition.getQuotaName()) {
			sql.append(" AND GOVERNMENT_QUOTA_NAME=?");
		}
		if ((!"".equals(condition.getProjectName()))
				&& null != condition.getProjectName()) {
			sql.append(" AND PROJECT_NAME like ?");
		}
		if ((!"".equals(condition.getDataDateAfter()))
				&& null != condition.getDataDateAfter()) {
			sql.append(" AND PROJECT_DATE >= ?");
		}
		if ((!"".equals(condition.getDataDateBefore()))
				&& null != condition.getDataDateBefore()) {
			sql.append(" AND PROJECT_DATE <= ?");
		}
		if (condition.getUserInfoId() != 0) {
			sql.append(" AND USER_INFO_ID=?");
		}
		sql.append(" ORDER BY RECORD_IMPORT_DATE DESC");
		PreparedStatement stat = DBConnUtil.getPrepareStatement(sql.toString());
		int i = 1;

		if ((!"".equals(condition.getRecordUnit()))
				&& null != condition.getRecordUnit()) {
			stat.setString(i, condition.getRecordUnit());
			i++;
		}
		if ((!"".equals(condition.getDataType()) && (!"0".equals(condition
				.getDataType()))) && null != condition.getDataType()) {
			stat.setString(i, condition.getDataType());
			i++;
		}
		if ((!"".equals(condition.getRecordName()))
				&& null != condition.getRecordName()) {
			stat.setString(i, condition.getRecordName());
			i++;
		}
		if ((!"".equals(condition.getQuotaNum()))
				&& null != condition.getQuotaNum()) {
			stat.setString(i, condition.getQuotaNum());
			i++;
		}
		if ((!"".equals(condition.getRecordType()) && (!"0".equals(condition
				.getRecordType()))) && null != condition.getRecordType()) {
			stat.setString(i, condition.getRecordType());
			i++;
		}
		if ((!"".equals(condition.getQuotaName()))
				&& null != condition.getQuotaName()) {
			stat.setString(i, condition.getQuotaName());
			i++;
		}
		if ((!"".equals(condition.getProjectName()))
				&& null != condition.getProjectName()) {
			stat.setString(i, "%" + condition.getProjectName() + "%");
			i++;
		}
		if ((!"".equals(condition.getDataDateAfter()))
				&& null != condition.getDataDateAfter()) {
			stat.setTimestamp(i, condition.getDataDateAfter());
			i++;
		}
		if ((!"".equals(condition.getDataDateBefore()))
				&& null != condition.getDataDateBefore()) {
			stat.setTimestamp(i, condition.getDataDateBefore());
			i++;
		}
		if (condition.getUserInfoId() != 0) {
			stat.setLong(i, condition.getUserInfoId());
			i++;
		}
		ResultSet result = stat.executeQuery();
		result.last();
		int results = result.getInt(result.getRow());
		return results;
	}

	public void deleteData(String id) throws SQLException {
		PreparedStatement stat = DBConnUtil.getPrepareStatement(deleteDataSql);
		stat.setLong(1, Long.valueOf(id));
		stat.execute();
	}

	public UserProjectUploadData viewProjectDataDetail(String id)
			throws NumberFormatException, SQLException {
		String sql = sqlBuilder + " AND ID=?";
		PreparedStatement stat = DBConnUtil.getPrepareStatement(sql);
		stat.setLong(1, Long.valueOf(id));
		ResultSet result = stat.executeQuery();
		UserProjectUploadData data = new UserProjectUploadData();
		while (result.next()) {
			data.setArea(result.getString("AREA"));
			data.setDataType(result.getString("DATA_TYPE"));
			data.setGovernmentQuotaGross(result
					.getDouble("GOVERNMENT_QUOTA_GROSS"));
			data.setGovernmentQuotaName(result
					.getString("GOVERNMENT_QUOTA_NAME"));
			data.setGovernmentQuotaNum(result.getString("GOVERNMENT_QUOTA_NUM"));
			data.setGovernmentQuotaTotalPrice(result
					.getDouble("GOVERNMENT_QUOTA_TOTAL_PRICE"));
			data.setGovernmentQuotaType(result
					.getString("GOVERNMENT_QUOTA_TYPE"));
			data.setId(result.getLong("ID"));
			data.setProjectDate(result.getTimestamp("PROJECT_DATE"));
			data.setProjectName(result.getString("PROJECT_NAME"));
			data.setProjectSubName(result.getString("PROJECT_SUB_NAME"));
			data.setRecordImportDate(result.getTimestamp("RECORD_IMPORT_DATE"));
			data.setRecordName(result.getString("RECORD_NAME"));
			data.setRecordNum(result.getString("RECORD_NUM"));
			data.setRecordPrice(result.getDouble("RECORD_PRICE"));
			data.setRecordTotalGross(result.getDouble("RECORD_TOTAL_GROSS"));
			data.setRecordTotalPrice(result.getDouble("RECORD_TOTAL_PRICE"));
			data.setRecordType(result.getString("RECORD_TYPE"));
			data.setRecordUnit(result.getString("RECORD_UNIT"));
			data.setUserInfoId(result.getLong("USER_INFO_ID"));
			data.setRecordModifyDate(result.getTimestamp("RECORD_MODIFY_DATE"));
		}
		return data;
	}

	public void modifyProjectData(UserProjectUploadData data)
			throws SQLException {
		PreparedStatement stat = DBConnUtil.getPrepareStatement(modifyDataSql);
		stat.setString(1, data.getProjectSubName());
		stat.setString(2, data.getGovernmentQuotaNum());
		stat.setString(3, data.getGovernmentQuotaName());
		stat.setString(4, data.getGovernmentQuotaType());
		stat.setDouble(5, data.getGovernmentQuotaGross());
		stat.setDouble(6, data.getGovernmentQuotaTotalPrice());
		stat.setString(7, data.getRecordName());
		stat.setString(8, data.getRecordNum());
		stat.setString(9, data.getRecordType());
		stat.setString(10, data.getRecordUnit());
		stat.setDouble(11, data.getRecordPrice());
		stat.setDouble(12, data.getRecordTotalGross());
		stat.setDouble(13, data.getRecordTotalPrice());
		stat.setTimestamp(14, data.getRecordModifyDate());
		stat.setTimestamp(15, data.getProjectDate());
		stat.setLong(16, data.getId());
		stat.executeUpdate();
	}

	public Double getAvgValueByCondition(SearchDataCondition condition)
			throws SQLException {
		StringBuilder sql = new StringBuilder(avgUserProjectDataSqlBuilder);
		ResultSet result = getResult(sql, condition);
		Double value = null;
		if (result.next()) {
			value = result.getDouble(1);
		}
		return value;
	}

	private ResultSet getResult(StringBuilder sql, SearchDataCondition condition)
			throws SQLException {
		if ((!"".equals(condition.getArea())) && null != condition.getArea()) {
			sql.append(" AND AREA LIKE ?");
		}
		if ((!"".equals(condition.getRecordType()))
				&& null != condition.getRecordType()
				&& (!"0".equals(condition.getRecordType()))) {
			sql.append(" AND RECORD_TYPE = ?");
		}
		if ((!"".equals(condition.getDataDateAfter()))
				&& null != condition.getDataDateAfter()) {
			sql.append(" AND PROJECT_DATE >= ?");
		}
		if ((!"".equals(condition.getDataDateBefore()))
				&& null != condition.getDataDateBefore()) {
			sql.append(" AND PROJECT_DATE <= ?");
		}
		if ((!"".equals(condition.getRecordModel()))
				&& null != condition.getRecordModel()) {
			sql.append(" AND RECORD_MODEL=?");
		}
		if ((!"".equals(condition.getRecordUnit()))
				&& null != condition.getRecordUnit()) {
			sql.append(" AND RECORD_UNIT=?");
		}
		if ((!"".equals(condition.getRecordName()))
				&& null != condition.getRecordName()) {
			sql.append(" AND RECORD_NAME=?");
		}
		if (condition.getUserInfoId() != 0) {
			sql.append(" AND USER_INFO_ID=?");
		}
		PreparedStatement stat = DBConnUtil.getPrepareStatement(sql.toString());
		int i = 1;

		if ((!"".equals(condition.getArea())) && null != condition.getArea()) {
			stat.setString(i, "%" + condition.getArea() + "%");
			i++;
		}
		if ((!"".equals(condition.getRecordType()))
				&& null != condition.getRecordType()
				&& (!"0".equals(condition.getRecordType()))) {
			stat.setString(i, condition.getRecordType());
			i++;
		}
		if ((!"".equals(condition.getDataDateAfter()))
				&& null != condition.getDataDateAfter()) {
			stat.setTimestamp(i, condition.getDataDateAfter());
			i++;
		}
		if ((!"".equals(condition.getDataDateBefore()))
				&& null != condition.getDataDateBefore()) {
			stat.setTimestamp(i, condition.getDataDateBefore());
			i++;
		}
		if ((!"".equals(condition.getRecordModel()))
				&& null != condition.getRecordModel()) {
			stat.setString(i, condition.getRecordModel());
			i++;
		}
		if ((!"".equals(condition.getRecordUnit()))
				&& null != condition.getRecordUnit()) {
			stat.setString(i, condition.getRecordUnit());
			i++;
		}
		if ((!"".equals(condition.getRecordName()))
				&& null != condition.getRecordName()) {
			stat.setString(i, condition.getRecordName());
			i++;
		}
		if (condition.getUserInfoId() != 0) {
			stat.setLong(i, condition.getUserInfoId());
			i++;
		}

		ResultSet result = stat.executeQuery();
		return result;

	}

	public Double getMaxValueByCondition(SearchDataCondition condition)
			throws SQLException {
		StringBuilder sql = new StringBuilder(maxUserProjectDataSqlBuilder);
		ResultSet result = getResult(sql, condition);
		Double value = null;
		if (result.next()) {
			value = result.getDouble(1);
		}
		return value;
	}

	public Double getMinValueByCondition(SearchDataCondition condition)
			throws SQLException {
		StringBuilder sql = new StringBuilder(minUserProjectDataSqlBuilder);
		ResultSet result = getResult(sql, condition);
		Double value = null;
		if (result.next()) {
			value = result.getDouble(1);
		}
		return value;
	}

	public List<PersonalRecordAnalyseData> getUserProjectDataByQuota(
			SearchDataCondition condition) throws SQLException {
		StringBuilder sql = new StringBuilder(getRecordByQuotaSql);
		if ((!"".equals(condition.getArea())) && null != condition.getArea()) {
			sql.append(" AND AREA LIKE ?");
		}
		if ((!"".equals(condition.getQuotaClass())
				&& !"0".equals(condition.getQuotaClass()) && null != condition
				.getQuotaClass())) {
			sql.append(" AND GOVERNMENT_QUOTA_TYPE = ?");
		}
		if ((!"".equals(condition.getDataDateAfter()))
				&& null != condition.getDataDateAfter()) {
			sql.append(" AND PROJECT_DATE >= ?");
		}
		if ((!"".equals(condition.getDataDateBefore()))
				&& null != condition.getDataDateBefore()) {
			sql.append(" AND PROJECT_DATE <= ?");
		}
		if ((!"".equals(condition.getQuotaNum()))
				&& null != condition.getQuotaNum()) {
			sql.append(" AND GOVERNMENT_QUOTA_NUM=?");
		}
		if ((!"".equals(condition.getQuotaName()))
				&& null != condition.getQuotaName()) {
			sql.append(" AND GOVERNMENT_QUOTA_NAME=?");
		}
		if (condition.getUserInfoId() != 0) {
			sql.append(" AND USER_INFO_ID=?");
		}
		sql.append( " ORDER BY DEF_ORDER " );
		PreparedStatement stat = DBConnUtil.getPrepareStatement(sql.toString());
		int i = 1;
		if ((!"".equals(condition.getArea())) && null != condition.getArea()) {
			stat.setString(i, "%" + condition.getArea() + "%");
			i++;
		}
		if ((!"".equals(condition.getQuotaClass())
				&& !"0".equals(condition.getQuotaClass()) && null != condition
				.getQuotaClass())) {
			stat.setString(i, condition.getQuotaClass());
			i++;
		}
		if ((!"".equals(condition.getDataDateAfter()))
				&& null != condition.getDataDateAfter()) {
			stat.setTimestamp(i, condition.getDataDateAfter());
			i++;
		}
		if ((!"".equals(condition.getDataDateBefore()))
				&& null != condition.getDataDateBefore()) {
			stat.setTimestamp(i, condition.getDataDateBefore());
			i++;
		}
		if ((!"".equals(condition.getQuotaNum()))
				&& null != condition.getQuotaNum()) {
			stat.setString(i, condition.getQuotaNum());
			i++;
		}
		if ((!"".equals(condition.getQuotaName()))
				&& null != condition.getQuotaName()) {
			stat.setString(i, condition.getQuotaName());
			i++;
		}
		if (condition.getUserInfoId() != 0) {
			stat.setLong(i, condition.getUserInfoId());
			i++;
		}
		List<PersonalRecordAnalyseData> datas = new ArrayList<PersonalRecordAnalyseData>();
		ResultSet rs = stat.executeQuery();
		while (rs.next()) {
			PersonalRecordAnalyseData data = new PersonalRecordAnalyseData();
			data.setRecordName(rs.getString("RECORD_NAME"));
			data.setRecordUnit(rs.getString("RECORD_UNIT"));
			datas.add(data);
		}
		return datas;
	}

	public PersonalQuotaAnalyseData getCompanyQuotaByCondtion(
			SearchDataCondition condition) throws SQLException {
		StringBuilder sql = new StringBuilder(queryCompanyQuotaByCondtionSql);
		if ((!"".equals(condition.getQuotaNum()))
				&& null != condition.getQuotaNum()) {
			sql.append(" AND GOVERNMENT_QUOTA_NUM=?");
		}
		if ((!"".equals(condition.getQuotaName()))
				&& null != condition.getQuotaName()) {
			sql.append(" AND GOVERNMENT_QUOTA_NAME=?");
		}
		if (condition.getUserInfoId() != 0) {
			sql.append(" AND USER_INFO_ID=?");
		}
		PreparedStatement stat = DBConnUtil.getPrepareStatement(sql.toString());
		stat.setString(1, "%" + condition.getArea()+ "%" );
		stat.setString(2, condition.getQuotaClass());
		int i = 3;
		if ((!"".equals(condition.getQuotaNum()))
				&& null != condition.getQuotaNum()) {
			stat.setString(i, condition.getQuotaNum());
			i++;
		}
		if ((!"".equals(condition.getQuotaName()))
				&& null != condition.getQuotaName()) {
			stat.setString(i, condition.getQuotaName());
			i++;
		}
		if (condition.getUserInfoId() != 0) {
			stat.setLong(i, condition.getUserInfoId());
		}
		ResultSet rs = stat.executeQuery();
		PersonalQuotaAnalyseData data = new PersonalQuotaAnalyseData();
		while (rs.next()) {
			data.setArea(rs.getString("AREA"));
			data.setGovernmentQuotaName(rs.getString("GOVERNMENT_QUOTA_NAME"));
			data.setGovernmentQuotaNum(rs.getString("GOVERNMENT_QUOTA_NUM"));
			data.setGovernmentQuotaUnit(rs.getString("GOVERNMENT_QUOTA_UNIT"));
			data.setGovernmentQuotaAmount(rs.getDouble("GOVERNMENT_QUOTA_GROSS"));
		}
		return data;
	}

	public List<PersonalRecordAnalyseData> getAvgValueByNameAndUnit(
			List<PersonalRecordAnalyseData> projectDatas, SearchDataCondition condition) throws SQLException {
		
		List<PersonalRecordAnalyseData> datas = new ArrayList<PersonalRecordAnalyseData>();
		for(PersonalRecordAnalyseData data : projectDatas){
			StringBuilder sql = new StringBuilder(avgRecordByNameAndUnit);
			if ((!"".equals(condition.getArea())) && null != condition.getArea()) {
				sql.append(" AND AREA LIKE ?");
			}
			if ((!"".equals(condition.getQuotaClass())
					&& !"0".equals(condition.getQuotaClass()) && null != condition
					.getQuotaClass())) {
				sql.append(" AND GOVERNMENT_QUOTA_TYPE = ?");
			}
			if ((!"".equals(condition.getDataDateAfter()))
					&& null != condition.getDataDateAfter()) {
				sql.append(" AND PROJECT_DATE >= ?");
			}
			if ((!"".equals(condition.getDataDateBefore()))
					&& null != condition.getDataDateBefore()) {
				sql.append(" AND PROJECT_DATE <= ?");
			}
			if ((!"".equals(condition.getQuotaNum()))
					&& null != condition.getQuotaNum()) {
				sql.append(" AND GOVERNMENT_QUOTA_NUM=?");
			}
			if ((!"".equals(condition.getQuotaName()))
					&& null != condition.getQuotaName()) {
				sql.append(" AND GOVERNMENT_QUOTA_NAME=?");
			}
			if (condition.getUserInfoId() != 0) {
				sql.append(" AND USER_INFO_ID=?");
			}
			PreparedStatement stat = DBConnUtil.getPrepareStatement(sql.toString());
			stat.setString(1, data.getRecordUnit());
			stat.setString(2, data.getRecordName());
			int i = 3;
			if ((!"".equals(condition.getArea())) && null != condition.getArea()) {
				stat.setString(i, "%" + condition.getArea() + "%");
				i++;
			}
			if ((!"".equals(condition.getQuotaClass())
					&& !"0".equals(condition.getQuotaClass()) && null != condition
					.getQuotaClass())) {
				stat.setString(i, condition.getQuotaClass());
				i++;
			}
			if ((!"".equals(condition.getDataDateAfter()))
					&& null != condition.getDataDateAfter()) {
				stat.setTimestamp(i, condition.getDataDateAfter());
				i++;
			}
			if ((!"".equals(condition.getDataDateBefore()))
					&& null != condition.getDataDateBefore()) {
				stat.setTimestamp(i, condition.getDataDateBefore());
				i++;
			}
			if ((!"".equals(condition.getQuotaNum()))
					&& null != condition.getQuotaNum()) {
				stat.setString(i, condition.getQuotaNum());
				i++;
			}
			if ((!"".equals(condition.getQuotaName()))
					&& null != condition.getQuotaName()) {
				stat.setString(i, condition.getQuotaName());
				i++;
			}
			if (condition.getUserInfoId() != 0) {
				stat.setLong(i, condition.getUserInfoId());
				i++;
			}
			ResultSet rs = stat.executeQuery();
			rs.next();
			DecimalFormat df = new DecimalFormat("#.00");
			Double userRecordAvg = Double.valueOf(df.format(rs.getDouble("AVG_PRICE")));
			data.setUserRecordAvg(userRecordAvg);
			Double userRecordGrossAvg = Double.valueOf(df.format(rs.getDouble("AVG_GROSS")));
			data.setUserRecordGrossAvg(userRecordGrossAvg);
			Double userTotalPriceAvg = Double.valueOf(df.format(rs.getDouble("AVG_GROSS")));
			data.setTotalPriceOfProjcetPrice(userTotalPriceAvg);
			datas.add(data);
		}
		return datas;
	}
}
