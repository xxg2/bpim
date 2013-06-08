package com.bpim.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bpim.common.DBConnUtil;
import com.bpim.entity.CustomAndGuideData;
import com.bpim.entity.GovernmentQuota;
import com.bpim.entity.GovernmentQuotaRecord;
import com.bpim.entity.PersonalRecordAnalyseData;
import com.bpim.form.SearchDataCondition;
import com.bpim.helper.PageTools;

/**
 * author Delgado
 */
public class GovernmentQuotaDAOImpl implements GovernmentQuotaDAO {

	String deleteSql = "DELETE FROM GOVERNMENT_QUOTA";
	String deleteRecordSql = "DELETE FROM GOVERNMENT_QUOTA_RECORD";
	String insertParentSql = "INSERT INTO GOVERNMENT_QUOTA(AREA,GOVERNMENT_QUOTA_CLASS,GOVERNMENT_QUOTA_NUM ,GOVERNMENT_QUOTA_NAME,"
			+ "GOVERNMENT_QUOTA_TYPE,GOVERNMENT_QUOTA_UNIT ,GOVERNMENT_QUOTA_AMOUNT, GOVERNMENT_QUOTA_MODEL) VALUES(?,?,?,?,?,?,?,?)";
	String insertRecordSql = "INSERT INTO GOVERNMENT_QUOTA_RECORD(GOVERNMENT_QUOTA_ID, RECORD_NAME ,RECORD_NUM ,RECORD_MODEL ,"
			+ "RECORD_TYPE,RECORD_UNIT,RECORD_AMOUNT) values(?,?,?,?,?,?,?)";
	String getLastInsertIdSql = "SELECT LAST_INSERT_ID()";

	String queryGovernmentQuota = "SELECT * FROM GOVERNMENT_QUOTA WHERE 1=1";
	String countQueryGovernmentQuota = "SELECT count(*) FROM GOVERNMENT_QUOTA WHERE 1=1";
	String queryGovernmentQuotaRecord = "SELECT * FROM GOVERNMENT_QUOTA_RECORD WHERE GOVERNMENT_QUOTA_ID = ?";
	String queryGovernmentQuotaById = "SELECT * FROM GOVERNMENT_QUOTA WHERE ID = ?";
	int i = 1;
	
	String queryRecordGrossOfGovernmentQuotaSql = "SELECT A.RECORD_AMOUNT FROM GOVERNMENT_QUOTA_RECORD A, GOVERNMENT_QUOTA B " +
			"WHERE 1=1 AND A.GOVERNMENT_QUOTA_ID = B.ID AND B.AREA LIKE ? " +
			"AND A.RECORD_UNIT =? AND A.RECORD_NAME=? AND B.GOVERNMENT_QUOTA_CLASS LIKE ? ";
	
	public List<GovernmentQuota> searchGovernmentQuota(SearchDataCondition condition) throws SQLException {
		String sql = getQuerySql (queryGovernmentQuota,condition);
		sql = sql + " ORDER BY GOVERNMENT_QUOTA_NUM LIMIT ?,?";
		PreparedStatement stat = DBConnUtil.getPrepareStatement(sql);
		setConditionValue(stat,condition);
		stat.setInt(i, condition.getStartRow());
		stat.setInt(i+1,condition.getPageSize());
		ResultSet result = stat.executeQuery();
		List<GovernmentQuota> datas = new ArrayList<GovernmentQuota>();
		while (result.next()) {
			GovernmentQuota data = new GovernmentQuota();
			data.setArea(result.getString("AREA"));
			data.setId(result.getLong("ID"));
			data.setGovernmentQuotaClass(result.getString("GOVERNMENT_QUOTA_CLASS"));
			data.setGovernmentQuotaNum(result.getString("GOVERNMENT_QUOTA_NUM"));
			data.setGovernmentQuotaName(result.getString("GOVERNMENT_QUOTA_NAME"));
			data.setGovernmentQuotaModel(result.getString("GOVERNMENT_QUOTA_MODEL"));
			data.setGovernmentQuotaAmount(result.getDouble("GOVERNMENT_QUOTA_AMOUNT"));
			data.setGovernmentQuotaType(result.getString("GOVERNMENT_QUOTA_TYPE"));
			data.setGovernmentQuotaUnit(result.getString("GOVERNMENT_QUOTA_UNIT"));
			datas.add(data);
		}
		return datas;
	}
	

	public int countSearchGovernmentQuota(SearchDataCondition condition) throws SQLException {
		String sql = getQuerySql (countQueryGovernmentQuota,condition);
		PreparedStatement stat = DBConnUtil.getPrepareStatement(sql);
		setConditionValue(stat,condition);
		ResultSet result = stat.executeQuery();
		int value = 0;
		if (result.next()) {
			value = result.getInt(1);
		}
		return value;
	}
	
	private void setConditionValue(PreparedStatement stat,
			SearchDataCondition condition) throws SQLException {
		i = 1;
		if(null!= condition.getProvice()&&!"".equals(condition.getProvice())&&!"0".equals(condition.getProvice())){
			stat.setString(i, condition.getProvice());
			i++;
		}
		if(null!= condition.getQuotaClass()&&!"".equals(condition.getQuotaClass())&&!"0".equals(condition.getQuotaClass())){
			stat.setString(i, condition.getQuotaClass());
			i++;
		}
		if(null!= condition.getQuotaNum()&&!"".equals(condition.getQuotaNum())){
			stat.setString(i, "%" + condition.getQuotaNum() + "%");
			i++;
		}
		if(null!= condition.getQuotaName()&&!"".equals(condition.getQuotaName())){
			stat.setString(i, "%" + condition.getQuotaName() + "%");
			i++;
		}
	}
	
	private String getQuerySql(String sql, SearchDataCondition condition) {
		StringBuilder sqlSb = new StringBuilder(sql);
		if(null!= condition.getProvice()&&!"".equals(condition.getProvice())&&!"0".equals(condition.getProvice())){
			sqlSb.append(" AND AREA = ?");
		}
		if(null!= condition.getQuotaClass()&&!"".equals(condition.getQuotaClass())&&!"0".equals(condition.getQuotaClass())){
			sqlSb.append(" AND GOVERNMENT_QUOTA_CLASS = ?");
		}
		if(null!= condition.getQuotaNum()&&!"".equals(condition.getQuotaNum())){
			sqlSb.append(" AND GOVERNMENT_QUOTA_NUM like ?");
		}
		if(null!= condition.getQuotaName()&&!"".equals(condition.getQuotaName())){
			sqlSb.append(" AND GOVERNMENT_QUOTA_NAME like ?");
		}
		return sqlSb.toString();
	}

	
	public void deleteGovernmentQuota() throws SQLException {
		PreparedStatement stat1 = DBConnUtil.getPrepareStatement(deleteRecordSql);
		stat1.execute();
		PreparedStatement stat2 = DBConnUtil.getPrepareStatement(deleteSql);
		stat2.execute();
	}

	public void importGovernmentQuotaRecord(List<GovernmentQuotaRecord> records)
			throws SQLException {
		PreparedStatement stat = DBConnUtil
				.getPrepareStatement(insertRecordSql);
		for (GovernmentQuotaRecord record : records) {
			stat.setLong(1, record.getGovernmentQuotaId());
			stat.setString(2, record.getRecordName());
			stat.setString(3, record.getRecordNum());
			stat.setString(4, record.getRecordModel());
			stat.setString(5, record.getRecordType());
			stat.setString(6, record.getRecordUnit());
			stat.setDouble(7, record.getRecordAmount());
			stat.execute();
		}
	}

	public Long importGovernmentQuota(GovernmentQuota data) throws SQLException {
		PreparedStatement stat = DBConnUtil
				.getPrepareStatement(insertParentSql);
		stat.setString(1, data.getArea());
		stat.setString(2, data.getGovernmentQuotaClass());
		stat.setString(3, data.getGovernmentQuotaNum());
		stat.setString(4, data.getGovernmentQuotaName());
		stat.setString(5, data.getGovernmentQuotaType());
		stat.setString(6, data.getGovernmentQuotaUnit());
		stat.setDouble(7, data.getGovernmentQuotaAmount());
		stat.setString(8, data.getGovernmentQuotaModel());
		stat.execute();
		PreparedStatement queryStat = DBConnUtil
				.getPrepareStatement(getLastInsertIdSql);
		Long lastInsertId = null;
		ResultSet rs = queryStat.executeQuery();
		if (rs.next()) {
			lastInsertId = rs.getLong(1);
		}
		return lastInsertId;
	}


	public List<GovernmentQuotaRecord> searchGovernmentQuotaRecord(Long id) throws SQLException {
		PreparedStatement stat = DBConnUtil.getPrepareStatement(queryGovernmentQuotaRecord);
		stat.setLong(1, id);
		ResultSet result = stat.executeQuery();
		List<GovernmentQuotaRecord> datas = new ArrayList<GovernmentQuotaRecord>();
		while (result.next()) {
			GovernmentQuotaRecord data = new GovernmentQuotaRecord();
			data.setId(result.getLong("ID"));
			data.setRecordAmount(result.getDouble("RECORD_AMOUNT"));
			data.setRecordModel(result.getString("RECORD_MODEL"));
			data.setRecordName(result.getString("RECORD_NAME"));
			data.setRecordNum(result.getString("RECORD_NUM"));
			data.setRecordType(result.getString("RECORD_TYPE"));
			data.setRecordUnit(result.getString("RECORD_UNIT"));
			datas.add(data);
		}
		return datas;
	}


	public GovernmentQuota getQuotaById(Long id) throws SQLException {
		PreparedStatement stat = DBConnUtil.getPrepareStatement(queryGovernmentQuotaById);
		stat.setLong(1, id);
		ResultSet result = stat.executeQuery();
		GovernmentQuota data = new GovernmentQuota();
		while (result.next()) {
			data.setArea(result.getString("AREA"));
			data.setId(result.getLong("ID"));
			data.setGovernmentQuotaClass(result.getString("GOVERNMENT_QUOTA_CLASS"));
			data.setGovernmentQuotaNum(result.getString("GOVERNMENT_QUOTA_NUM"));
			data.setGovernmentQuotaName(result.getString("GOVERNMENT_QUOTA_NAME"));
			data.setGovernmentQuotaModel(result.getString("GOVERNMENT_QUOTA_MODEL"));
			data.setGovernmentQuotaAmount(result.getDouble("GOVERNMENT_QUOTA_AMOUNT"));
			data.setGovernmentQuotaType(result.getString("GOVERNMENT_QUOTA_TYPE"));
			data.setGovernmentQuotaUnit(result.getString("GOVERNMENT_QUOTA_UNIT"));
			data.setGovernmentQuotaDesc(result.getString("GOVERNMENT_QUOTA_DESC"));
		}
		return data;
	}

	public Double getRecordGrossOfGovernmentQuota(SearchDataCondition condition) throws SQLException {
		StringBuilder sql = new StringBuilder(queryRecordGrossOfGovernmentQuotaSql);
		if ((!"".equals(condition.getQuotaNum()))
				&& null != condition.getQuotaNum()) {
			sql.append(" AND GOVERNMENT_QUOTA_NUM=?");
		}
		if ((!"".equals(condition.getQuotaName()))
				&& null != condition.getQuotaName()) {
			sql.append(" AND GOVERNMENT_QUOTA_NAME=?");
		}
		PreparedStatement stat = DBConnUtil.getPrepareStatement(sql.toString());
		stat.setString(1, "%" + condition.getArea() +  "%");
		stat.setString(2,  condition.getRecordUnit());
		stat.setString(3,  condition.getRecordName());
		stat.setString(4, "%" + condition.getQuotaClass() +  "%");
		int i = 5;
		if ((!"".equals(condition.getQuotaNum()))
				&& null != condition.getQuotaNum()) {
			stat.setString(i, condition.getQuotaNum());
			i++;
		}
		if ((!"".equals(condition.getQuotaName()))
				&& null != condition.getQuotaName()) {
			stat.setString(i, condition.getQuotaName());
		}
		ResultSet rs = stat.executeQuery();
		Double amount = 0.00;
		if(rs.next()){
			amount = rs.getDouble(1);
		}
		return amount;
	}
}
