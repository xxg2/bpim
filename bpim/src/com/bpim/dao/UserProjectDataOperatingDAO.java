package com.bpim.dao;

import java.sql.SQLException;
import java.util.List;

import com.bpim.entity.GovernmentQuota;
import com.bpim.entity.PersonalQuotaAnalyseData;
import com.bpim.entity.PersonalRecordAnalyseData;
import com.bpim.entity.UserProjectUploadData;
import com.bpim.form.SearchDataCondition;

/**
 * author Delgado
 */
public interface UserProjectDataOperatingDAO {

	List<UserProjectUploadData> searchProjectDataByCondition(
			SearchDataCondition condition) throws SQLException;

	int getRowCount(SearchDataCondition condition) throws SQLException;

	void deleteData(String id) throws SQLException;

	UserProjectUploadData viewProjectDataDetail(String id)
			throws NumberFormatException, SQLException;

	void modifyProjectData(UserProjectUploadData data) throws SQLException;

	Double getAvgValueByCondition(SearchDataCondition condition)
			throws SQLException;

	Double getMaxValueByCondition(SearchDataCondition condition)
			throws SQLException;

	Double getMinValueByCondition(SearchDataCondition condition)
			throws SQLException;

	List<PersonalRecordAnalyseData> getUserProjectDataByQuota(
			SearchDataCondition condition) throws SQLException;

	PersonalQuotaAnalyseData getCompanyQuotaByCondtion(SearchDataCondition condition) throws SQLException;

	List<PersonalRecordAnalyseData> getAvgValueByNameAndUnit(
			List<PersonalRecordAnalyseData> projectDatas, SearchDataCondition condition) throws SQLException;

}
