package com.bpim.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bpim.common.DBConnUtil;
import com.bpim.entity.CustomAndGuideData;
import com.bpim.entity.GovernmentFile;
import com.bpim.form.SearchDataCondition;

/**
 * author Delgado
 */
public class GovernmentFileDAOImpl implements GovernmentFileDAO {
	String queryGovernmentFileCountSQL = "SELECT COUNT(*) FROM GOVERNMENT_FILE WHERE 1=1 ";
	String queryGovernmentFileSQL = "SELECT * FROM GOVERNMENT_FILE WHERE 1=1 ";

	public int searchGovernmentFileCount(SearchDataCondition condition)
			throws SQLException {
		String sql = getquerySql(queryGovernmentFileCountSQL, condition, false);
		ResultSet result = getQueryResult(sql, condition, false);
		result.last();
		int results = result.getInt(result.getRow());
		return results;
	}

	public List<GovernmentFile> searchGovernmentFile(
			SearchDataCondition condition) throws SQLException {
		String sql = getquerySql(queryGovernmentFileSQL, condition, true);
		ResultSet result = getQueryResult(sql, condition, true);
		List<GovernmentFile> datas = new ArrayList<GovernmentFile>();
		while (result.next()) {
			GovernmentFile data = new GovernmentFile();
			data.setId(result.getLong("ID"));
			data.setArea(result.getString("AREA"));
			data.setEffective(result.getBoolean("EFFECTIVE"));
			data.setFileEffectiveDate(result
					.getTimestamp("FILE_EFFECTIVE_DATE"));
			data.setFilePublishDate(result.getTimestamp("FILE_PUBLISH_DATE"));
			data.setFileSubType(result.getString("FILE_SUB_TYPE"));
			data.setFileTitle(result.getString("FILE_TITLE"));
			data.setFileType(result.getString("FILE_TYPE"));
			datas.add(data);
		}
		return datas;
	}

	private String getquerySql(String sql, SearchDataCondition condition,
			boolean isQuery) {
		StringBuilder sqlSb = new StringBuilder(sql);
		if (condition.getFilePublishDateFrom() != null) {
			sqlSb.append(" AND FILE_PUBLISH_DATE >= ?");
		}
		if (condition.getFilePublishDateTo() != null) {
			sqlSb.append(" AND FILE_PUBLISH_DATE < ?");
		}
		if (condition.getFileEffectiveDateFrom() != null) {
			sqlSb.append(" AND FILE_EFFECTIVE_DATE >= ?");
		}
		if (condition.getFileEffectiveDateTo() != null) {
			sqlSb.append(" AND FILE_EFFECTIVE_DATE < ?");
		}
		if (condition.getFileSubType() != null
				&& !"0".equals(condition.getFileSubType())) {
			sqlSb.append(" AND FILE_SUB_TYPE = ?");
		}
		if (condition.getFileType() != null
				&& !"0".equals(condition.getFileType())) {
			sqlSb.append(" AND FILE_TYPE = ?");
		}
		if (condition.getKeyword() != null) {
			sqlSb.append(" AND SOURCE_CODE LIKE ?");
		}
		if (condition.getFileName() != null) {
			sqlSb.append(" AND FILE_TITLE LIKE ?");
		}
		if (isQuery) {
			sqlSb.append(" LIMIT ?, ?");
		}
		return sqlSb.toString();
	}

	private ResultSet getQueryResult(String sql, SearchDataCondition condition,
			boolean isQuery) throws SQLException {
		PreparedStatement stat = DBConnUtil.getPrepareStatement(sql);
		int i = 1;
		if (condition.getFilePublishDateFrom() != null) {
			stat.setTimestamp(i, condition.getFilePublishDateFrom());
			i++;
		}
		if (condition.getFilePublishDateTo() != null) {
			stat.setTimestamp(i, condition.getFilePublishDateTo());
			i++;
		}
		if (condition.getFileEffectiveDateFrom() != null) {
			stat.setTimestamp(i, condition.getFileEffectiveDateFrom());
			i++;
		}
		if (condition.getFileEffectiveDateTo() != null) {
			stat.setTimestamp(i, condition.getFileEffectiveDateTo());
			i++;
		}
		if (condition.getFileSubType() != null
				&& !"0".equals(condition.getFileSubType())) {
			stat.setString(i, condition.getFileSubType());
			i++;
		}
		if (condition.getFileType() != null
				&& !"0".equals(condition.getFileType())) {
			stat.setString(i, condition.getFileType());
			i++;
		}
		if (condition.getKeyword() != null) {
			stat.setString(i, "%" + condition.getKeyword() + "%");
			i++;
		}
		if (condition.getFileName() != null) {
			stat.setString(i, "%" + condition.getFileName() + "%");
			i++;
		}
		if (isQuery) {
			stat.setInt(i, condition.getStartRow());
			i++;
			stat.setInt(i, condition.getPageSize());
		}
		return stat.executeQuery();
	}

	public void importGovernmentFile(GovernmentFile data) throws SQLException {
		PreparedStatement stet = DBConnUtil
				.getPrepareStatement("INSERT INTO GOVERNMENT_FILE(FILE_TITLE, FILE_TYPE, FILE_SUB_TYPE, AREA, SOURCE_CODE, FILE_PUBLISH_DATE, FILE_EFFECTIVE_DATE, EFFECTIVE)VALUES(?,?,?,?,?,?,?,?)");
		stet.setString(1, data.getFileTitle());
		stet.setString(2, data.getFileType());
		stet.setString(3, data.getFileSubType());
		stet.setString(4, data.getArea());
		stet.setString(5, data.getSourceCode());
		stet.setTimestamp(6, data.getFilePublishDate());
		stet.setTimestamp(7, data.getFileEffectiveDate());
		stet.setBoolean(8, data.getEffective());
		stet.execute();
	}

	public String viewGovernmentFile(Long id) throws SQLException {
		PreparedStatement stet = DBConnUtil
				.getPrepareStatement("SELECT SOURCE_CODE FROM GOVERNMENT_FILE WHERE ID = ?");
		stet.setLong(1, id);
		ResultSet result = stet.executeQuery();
		String sourceCode = "";
		while (result.next()) {
			sourceCode = result.getString("SOURCE_CODE");
		}
		return sourceCode;
	}

}
