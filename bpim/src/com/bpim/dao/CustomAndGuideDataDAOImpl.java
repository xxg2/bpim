package com.bpim.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.bpim.common.DBConnUtil;
import com.bpim.common.PropertyConstants;
import com.bpim.entity.CustomAndGuideData;
import com.bpim.form.SearchDataCondition;

/**
 * author Delgado
 */
public class CustomAndGuideDataDAOImpl implements CustomAndGuideDataDAO {

	private static String searchGovermentGuidePriceSql = "SELECT * FROM GOVERNMENT_GUIDE_DATA WHERE 1=1";
	private static String searchCustomPriceSql = "SELECT * FROM USER_CUSTOM_DATA WHERE 1=1";
	private static String searchBothSql = "SELECT   *   FROM( #govermentSign#  "
			+ "UNION  ALL  #customSign#)A   ORDER   BY  RECORD_DATE DESC";
	private static String countSearchGovermentGuidePriceSql = "SELECT count(*) FROM GOVERNMENT_GUIDE_DATA WHERE 1=1";
	private static String countSearchCustomPriceSql = "SELECT count(*) FROM USER_CUSTOM_DATA WHERE 1=1";
	private static String countSearchBothSql = "SELECT  count(*)  FROM( #govermentSign#  "
			+ "UNION  ALL  #customSign#)A   ORDER   BY  RECORD_DATE DESC";
	private static String govermentSign = "#govermentSign#";
	private static String customSign = "#customSign#";
	private static String deleteCustomDataSql = "DELETE FROM USER_CUSTOM_DATA WHERE ID=?";
	private static String deleteGuideDataSql = "DELETE FROM GOVERNMENT_GUIDE_DATA WHERE AREA like ? AND RECORD_DATE = ?";
	private static String queryGuideDataSql = "SELECT * FROM USER_CUSTOM_DATA WHERE ID = ?";
	private static String updateGuideDataSql = "UPDATE USER_CUSTOM_DATA SET RECORD_DATE = ?, RECORD_MODEL = ?, RECORD_GROSS= ?, RECORD_TOTAL_PRICE = ?, RECORD_PERCENT = ?, RECORD_PRICE = ?, RECORD_UNIT = ?, RECORD_MODIFY_DATE=? WHERE ID = ?";

	private static String queryAvgGuidePriceSql = "SELECT AVG(RECORD_PRICE) FROM GOVERNMENT_GUIDE_DATA WHERE 1=1 ";
	private static String queryMaxGuidePriceSql = "SELECT MAX(RECORD_PRICE) FROM GOVERNMENT_GUIDE_DATA WHERE 1=1";
	private static String queryMinGuidePriceSql = "SELECT MIN(RECORD_PRICE) FROM GOVERNMENT_GUIDE_DATA WHERE 1=1 ";

	private static String queryAvgCustomValueSql = "SELECT AVG(RECORD_PRICE) FROM USER_CUSTOM_DATA WHERE 1=1";
	private static String queryMaxCustomValueSql = "SELECT MAX(RECORD_PRICE) FROM USER_CUSTOM_DATA WHERE 1=1";
	private static String queryMinCustomValueSql = "SELECT MIN(RECORD_PRICE) FROM USER_CUSTOM_DATA WHERE 1=1";

	int i = 1;

	public List<CustomAndGuideData> searchGovermentGuidePrice(
			SearchDataCondition condition) throws SQLException {
		String sql = searchGovermentGuidePriceSql;
		condition.setUserInfoId((long) 0);
		return searchGuidePrice(sql, condition, PropertyConstants.GOVGUIDEPRICE);
	}

	private List<CustomAndGuideData> searchGuidePrice(String sql,
			SearchDataCondition condition, String type) throws SQLException {
		StringBuilder sb = new StringBuilder(sql);
		sql = getSql(sb, condition);
		sql = sql + " LIMIT ?, ?";
		PreparedStatement stat = DBConnUtil.getPrepareStatement(sql.toString());
		i = 1;
		stat = setStatValue(stat, condition);
		stat.setInt(i, condition.getStartRow());
		stat.setInt(i + 1, condition.getPageSize());
		ResultSet result = stat.executeQuery();
		List<CustomAndGuideData> datas = new ArrayList<CustomAndGuideData>();
		while (result.next()) {
			CustomAndGuideData data = new CustomAndGuideData();
			data.setArea(result.getString("AREA"));

			data.setId(result.getLong("ID"));
			data.setQuotaClass(result.getString("GOVERNMENT_QUOTA_CLASS"));
			data.setRecordModel(result.getString("RECORD_MODEL"));
			data.setRecordGross(result.getDouble("RECORD_GROSS"));
			data.setRecordImportDate(result.getTimestamp("RECORD_IMPORT_DATE"));
			data.setRecordName(result.getString("RECORD_NAME"));
			data.setRecordNum(result.getString("RECORD_NUM"));
			data.setRecordPrice(result.getDouble("RECORD_PRICE"));
			data.setRecordTotalPrice(result.getDouble("RECORD_TOTAL_PRICE"));
			data.setRecordPercent(result.getDouble("RECORD_PERCENT"));
			data.setRecordDate(result.getTimestamp("RECORD_DATE"));
			data.setRecordType(result.getString("RECORD_TYPE"));
			data.setRecordUnit(result.getString("RECORD_UNIT"));
			data.setUserInfoId(result.getLong("USER_INFO_ID"));
			data.setRecordSource(type);
			datas.add(data);
		}
		return datas;
	}
	
	public List<CustomAndGuideData> searchCustomPrice(
			SearchDataCondition condition) throws SQLException {
		String sql = searchCustomPriceSql;
		return searchCustomPrice(sql, condition, PropertyConstants.CUSTDEFINEDPRICE);
	}

	private List<CustomAndGuideData> searchCustomPrice(String sql,
			SearchDataCondition condition, String type) throws SQLException {
		StringBuilder sb = new StringBuilder(sql);
		sql = getSql(sb, condition);
		sql = sql + " LIMIT ?, ?";
		PreparedStatement stat = DBConnUtil.getPrepareStatement(sql.toString());
		i = 1;
		stat = setStatValue(stat, condition);
		stat.setInt(i, condition.getStartRow());
		stat.setInt(i + 1, condition.getPageSize());
		ResultSet result = stat.executeQuery();
		List<CustomAndGuideData> datas = new ArrayList<CustomAndGuideData>();
		while (result.next()) {
			CustomAndGuideData data = new CustomAndGuideData();
			data.setArea(result.getString("AREA"));

			data.setId(result.getLong("ID"));
			data.setRecordModel(result.getString("RECORD_MODEL"));
			data.setRecordGross(result.getDouble("RECORD_GROSS"));
			data.setRecordImportDate(result.getTimestamp("RECORD_IMPORT_DATE"));
			data.setRecordName(result.getString("RECORD_NAME"));
			data.setRecordNum(result.getString("RECORD_NUM"));
			data.setRecordPrice(result.getDouble("RECORD_PRICE"));
			data.setRecordTotalPrice(result.getDouble("RECORD_TOTAL_PRICE"));
			data.setRecordPercent(result.getDouble("RECORD_PERCENT"));
			data.setRecordDate(result.getTimestamp("RECORD_DATE"));
			data.setRecordType(result.getString("RECORD_TYPE"));
			data.setRecordUnit(result.getString("RECORD_UNIT"));
			data.setUserInfoId(result.getLong("USER_INFO_ID"));
			data.setRecordSource(type);
			datas.add(data);
		}
		return datas;
	}

	private String getSql(StringBuilder sql, SearchDataCondition condition) {
		if (!StringUtils.isEmpty(condition.getRecordType())
				&& !"0".equals(condition.getRecordType())) {
			sql.append(" AND RECORD_TYPE = ?");
		}
		if (!StringUtils.isEmpty(condition.getRecordCode())) {
			sql.append(" AND RECORD_NUM = ?");
		}
		if (!StringUtils.isEmpty(condition.getRecordName())) {
			sql.append(" AND RECORD_NAME = ?");
		}
		if (!StringUtils.isEmpty(condition.getRecordUnit())) {
			sql.append(" AND RECORD_UNIT = ?");
		}
		if (!StringUtils.isEmpty(condition.getQuotaClass())
				&& !"0".equals(condition.getQuotaClass())) {
			sql.append(" AND GOVERNMENT_QUOTA_CLASS = ?");
		}
		if ((!"".equals(condition.getDataDateAfter()))
				&& null != condition.getDataDateAfter()
				&& (!"0".equals(condition.getDataDateAfter()))) {
			sql.append(" AND RECORD_DATE >= ?");
		}
		if ((!"".equals(condition.getDataDateBefore()))
				&& null != condition.getDataDateBefore()) {
			sql.append(" AND RECORD_DATE <= ?");
		}
		if (condition.getUserInfoId() > 0) {
			sql.append(" AND USER_INFO_ID = ?");
		}
		sql.append(" ORDER BY RECORD_DATE DESC");
		return sql.toString();
	}

	public List<CustomAndGuideData> searchBoth(SearchDataCondition condition)
			throws SQLException {
		String sql = searchBothSql;
		SearchDataCondition governMentCondition = condition;
		governMentCondition.setUserInfoId((long) 0);
		String governMentSql = getSql(new StringBuilder(
				searchGovermentGuidePriceSql), governMentCondition);
		String customSql = getSql(new StringBuilder(searchCustomPriceSql),
				condition);
		sql = sql.replaceAll(govermentSign, governMentSql);
		sql = sql.replaceAll(customSign, customSql);
		sql = sql + " LIMIT ?, ?";
		PreparedStatement stat = DBConnUtil.getPrepareStatement(sql.toString());
		i = 1;
		stat = setStatValue(stat, governMentCondition);
		stat = setStatValue(stat, condition);
		stat.setInt(i, condition.getStartRow());
		stat.setInt(i + 1, condition.getPageSize());
		ResultSet result = stat.executeQuery();
		List<CustomAndGuideData> datas = new ArrayList<CustomAndGuideData>();
		while (result.next()) {
			CustomAndGuideData data = new CustomAndGuideData();
			data.setArea(result.getString("AREA"));
			data.setId(result.getLong("ID"));
			data.setRecordModel(result.getString("RECORD_MODEL"));
			data.setRecordGross(result.getDouble("RECORD_GROSS"));
			data.setRecordImportDate(result.getTimestamp("RECORD_IMPORT_DATE"));
			data.setRecordName(result.getString("RECORD_NAME"));
			data.setRecordNum(result.getString("RECORD_NUM"));
			data.setRecordPrice(result.getDouble("RECORD_PRICE"));
			data.setRecordTotalPrice(result.getDouble("RECORD_TOTAL_PRICE"));
			data.setRecordPercent(result.getDouble("RECORD_PERCENT"));
			data.setRecordDate(result.getTimestamp("RECORD_DATE"));
			data.setRecordType(result.getString("RECORD_TYPE"));
			data.setRecordUnit(result.getString("RECORD_UNIT"));
			data.setUserInfoId(result.getLong("USER_INFO_ID"));
			if (data.getUserInfoId() == 0) {
				data.setRecordSource(PropertyConstants.GOVGUIDEPRICE);
			} else {
				data.setRecordSource(PropertyConstants.CUSTDEFINEDPRICE);
			}
			datas.add(data);
		}
		return datas;
	}

	private PreparedStatement setStatValue(PreparedStatement stat,
			SearchDataCondition condition) throws SQLException {
		if (!StringUtils.isEmpty(condition.getRecordType())
				&& !"0".equals(condition.getRecordType())) {
			stat.setString(i, condition.getRecordType());
			i++;
		}
		if (!StringUtils.isEmpty(condition.getRecordCode())) {
			stat.setString(i, condition.getRecordCode());
			i++;
		}
		if (!StringUtils.isEmpty(condition.getRecordName())) {
			stat.setString(i, condition.getRecordName());
			i++;
		}
		if (!StringUtils.isEmpty(condition.getRecordUnit())) {
			stat.setString(i, condition.getRecordUnit());
			i++;
		}
		if (!StringUtils.isEmpty(condition.getQuotaClass())
				&& !"0".equals(condition.getQuotaClass())) {
			stat.setString(i, condition.getQuotaClass());
			i++;
		}
		if ((!"".equals(condition.getDataDateAfter()))
				&& null != condition.getDataDateAfter()
				&& (!"0".equals(condition.getDataDateAfter()))) {
			stat.setTimestamp(i, condition.getDataDateAfter());
			i++;
		}
		if ((!"".equals(condition.getDataDateBefore()))
				&& null != condition.getDataDateBefore()) {
			stat.setTimestamp(i, condition.getDataDateBefore());
			i++;
		}
		if (condition.getUserInfoId() > 0) {
			stat.setLong(i, condition.getUserInfoId());
			i++;
		}
		return stat;
	}

	public int countSearchGovermentGuidePrice(SearchDataCondition condition)
			throws SQLException {
		String sql = countSearchGovermentGuidePriceSql;
		condition.setUserInfoId((long) 0);
		return countSearchGuideOrCustomPrice(sql, condition);
	}

	public int countSearchCustomPrice(SearchDataCondition condition)
			throws SQLException {
		String sql = countSearchCustomPriceSql;
		return countSearchGuideOrCustomPrice(sql, condition);
	}

	public int countSearchBoth(SearchDataCondition condition)
			throws SQLException {
		String sql = countSearchBothSql;
		SearchDataCondition governMentCondition = condition;
		governMentCondition.setUserInfoId((long) 0);
		String governMentSql = getSql(new StringBuilder(
				searchGovermentGuidePriceSql), governMentCondition);
		String customSql = getSql(new StringBuilder(searchCustomPriceSql),
				condition);
		sql = sql.replaceAll(govermentSign, governMentSql);
		sql = sql.replaceAll(customSign, customSql);
		PreparedStatement stat = DBConnUtil.getPrepareStatement(sql.toString());
		i = 1;
		stat = setStatValue(stat, governMentCondition);
		stat = setStatValue(stat, condition);
		ResultSet result = stat.executeQuery();
		result.last();
		int count = result.getInt(result.getRow());
		return count;
	}

	private int countSearchGuideOrCustomPrice(String sql,
			SearchDataCondition condition) throws SQLException {
		StringBuilder sb = new StringBuilder(sql);
		sql = getSql(sb, condition);
		PreparedStatement stat = DBConnUtil.getPrepareStatement(sql.toString());
		i = 1;
		stat = setStatValue(stat, condition);
		ResultSet result = stat.executeQuery();
		result.last();
		int count = result.getInt(result.getRow());
		return count;
	}

	public void deleteCustomData(String id) throws NumberFormatException,
			SQLException {
		PreparedStatement stat = DBConnUtil
				.getPrepareStatement(deleteCustomDataSql);
		stat.setLong(1, Long.valueOf(id));
		stat.execute();
	}

	public void deleteGuideData(Timestamp dataDate, String provice)
			throws SQLException {
		PreparedStatement stat = DBConnUtil
				.getPrepareStatement(deleteGuideDataSql);
		stat.setString(1, "%" + provice + "%");
		stat.setTimestamp(2, dataDate);
		stat.execute();
	}

	public CustomAndGuideData queryCustomDataDetail(String id)
			throws SQLException {
		PreparedStatement stat = DBConnUtil
				.getPrepareStatement(queryGuideDataSql);
		stat.setLong(1, Long.valueOf(id));
		ResultSet result = stat.executeQuery();
		CustomAndGuideData data = new CustomAndGuideData();
		if (result.next()) {
			data.setArea(result.getString("AREA"));
			data.setId(result.getLong("ID"));
			data.setRecordModel(result.getString("RECORD_MODEL"));
			data.setRecordGross(result.getDouble("RECORD_GROSS"));
			data.setRecordImportDate(result.getTimestamp("RECORD_IMPORT_DATE"));
			data.setRecordModifyDate(result.getTimestamp("RECORD_MODIFY_DATE"));
			data.setRecordName(result.getString("RECORD_NAME"));
			data.setRecordNum(result.getString("RECORD_NUM"));
			data.setRecordPrice(result.getDouble("RECORD_PRICE"));
			data.setRecordTotalPrice(result.getDouble("RECORD_TOTAL_PRICE"));
			data.setRecordPercent(result.getDouble("RECORD_PERCENT"));
			data.setRecordDate(result.getTimestamp("RECORD_DATE"));
			data.setRecordType(result.getString("RECORD_TYPE"));
			data.setRecordUnit(result.getString("RECORD_UNIT"));
			data.setUserInfoId(result.getLong("USER_INFO_ID"));
		}
		return data;
	}

	public void updateCustomData(CustomAndGuideData data) throws SQLException {
		PreparedStatement stat = DBConnUtil
				.getPrepareStatement(updateGuideDataSql);
		stat.setTimestamp(1, data.getRecordDate());
		stat.setString(2, data.getRecordModel());
		stat.setDouble(3, data.getRecordGross());
		stat.setDouble(4, data.getRecordTotalPrice());
		stat.setDouble(5, data.getRecordPercent());
		stat.setDouble(6, data.getRecordPrice());
		stat.setString(7, data.getRecordUnit());
		stat.setTimestamp(8, data.getRecordModifyDate());
		stat.setLong(9, data.getId());
		stat.executeUpdate();
	}

	private ResultSet getExecuteResult(String tempSql,
			SearchDataCondition condition) throws SQLException {
		StringBuilder sb = new StringBuilder(tempSql);
		if ((!"".equals(condition.getRecordType()))
				&& null != condition.getRecordType()
				&& (!"0".equals(condition.getRecordType()))) {
			sb.append(" AND RECORD_TYPE = ?");
		}
		if ((!"".equals(condition.getRecordModel()))
				&& null != condition.getRecordModel()) {
			sb.append(" AND RECORD_MODEL = ?");
		}
		if ((!"".equals(condition.getDataDateAfter()))
				&& null != condition.getDataDateAfter()
				&& (!"0".equals(condition.getDataDateAfter()))) {
			sb.append(" AND RECORD_DATE >= ?");
		}
		if ((!"".equals(condition.getDataDateBefore()))
				&& null != condition.getDataDateBefore()) {
			sb.append(" AND RECORD_DATE <= ?");
		}
		if ((!"".equals(condition.getRecordUnit()))
				&& null != condition.getRecordUnit()) {
			sb.append(" AND RECORD_UNIT = ?");
		}
		if ((!"".equals(condition.getRecordName()))
				&& null != condition.getRecordName()) {
			sb.append(" AND RECORD_NAME = ?");
		}
		if ((!"".equals(condition.getUserInfoId()))
				&& null != condition.getUserInfoId()
				&& (0 != condition.getUserInfoId())) {
			sb.append(" AND USER_INFO_ID = ?");
		}
		PreparedStatement stat = DBConnUtil.getPrepareStatement(sb.toString());
		int i = 1;
		if ((!"".equals(condition.getRecordType()))
				&& null != condition.getRecordType()
				&& (!"0".equals(condition.getRecordType()))) {
			stat.setString(i, condition.getRecordType());
			i++;
		}
		if ((!"".equals(condition.getRecordModel()))
				&& null != condition.getRecordModel()) {
			stat.setString(i, condition.getRecordModel());
			i++;
		}
		if ((!"".equals(condition.getDataDateAfter()))
				&& null != condition.getDataDateAfter()
				&& (!"0".equals(condition.getDataDateAfter()))) {
			stat.setTimestamp(i, condition.getDataDateAfter());
			i++;
		}
		if ((!"".equals(condition.getDataDateBefore()))
				&& null != condition.getDataDateBefore()) {
			stat.setTimestamp(i, condition.getDataDateBefore());
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
		if ((!"".equals(condition.getUserInfoId()))
				&& null != condition.getUserInfoId()
				&& (0 != condition.getUserInfoId())) {
			stat.setLong(i, condition.getUserInfoId());
			i++;
		}
		ResultSet result = stat.executeQuery();
		return result;
	}

	public Double getAvgGuidePriceValueByCondition(SearchDataCondition condition)
			throws SQLException {
		ResultSet result = getExecuteResult(queryAvgGuidePriceSql, condition);
		Double value = 0.00;
		if (result.next()) {
			value = result.getDouble(1);
		}
		return value;
	}

	public Double getMaxGuidePriceValueByCondition(SearchDataCondition condition)
			throws SQLException {
		ResultSet result = getExecuteResult(queryMaxGuidePriceSql, condition);
		Double value = 0.00;
		if (result.next()) {
			value = result.getDouble(1);
		}
		return value;
	}

	public Double getMinGuidePriceValueByCondition(SearchDataCondition condition)
			throws SQLException {
		ResultSet result = getExecuteResult(queryMinGuidePriceSql, condition);
		Double value = 0.00;
		if (result.next()) {
			value = result.getDouble(1);
		}
		return value;
	}

	public Double getAvgCustomPriceValueByCondition(
			SearchDataCondition condition) throws SQLException {
		ResultSet result = getExecuteResult(queryAvgCustomValueSql, condition);
		Double value = 0.00;
		if (result.next()) {
			value = result.getDouble(1);
		}
		return value;
	}

	public Double getMaxCustomPriceValueByCondition(
			SearchDataCondition condition) throws SQLException {
		ResultSet result = getExecuteResult(queryMaxCustomValueSql, condition);
		Double value = 0.00;
		if (result.next()) {
			value = result.getDouble(1);
		}
		return value;
	}

	public Double getMinCustomPriceValueByCondition(
			SearchDataCondition condition) throws SQLException {
		ResultSet result = getExecuteResult(queryMinCustomValueSql, condition);
		Double value = 0.00;
		if (result.next()) {
			value = result.getDouble(1);
		}
		return value;
	}

}
