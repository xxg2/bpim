package com.bpim.dao;

import java.sql.SQLException;
import java.util.List;

import com.bpim.entity.GovernmentQuota;
import com.bpim.entity.GovernmentQuotaRecord;
import com.bpim.form.SearchDataCondition;

/**
 * author Delgado
 */
public interface GovernmentQuotaDAO {

	void deleteGovernmentQuota() throws SQLException;

	Long importGovernmentQuota(GovernmentQuota data) throws SQLException;
	
	void importGovernmentQuotaRecord(List<GovernmentQuotaRecord> datas) throws SQLException;

	List<GovernmentQuota> searchGovernmentQuota(SearchDataCondition condition) throws SQLException;
	
	int countSearchGovernmentQuota(SearchDataCondition condition) throws SQLException;

	List<GovernmentQuotaRecord> searchGovernmentQuotaRecord(Long id) throws SQLException;

	GovernmentQuota getQuotaById(Long id) throws SQLException;

	Double getRecordGrossOfGovernmentQuota(SearchDataCondition condition) throws SQLException;
}

