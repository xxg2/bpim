package com.bpim.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.bpim.entity.GovernmentQuota;
import com.bpim.entity.GovernmentQuotaRecord;
import com.bpim.form.SearchDataCondition;
import com.bpim.helper.PageTools;

/**
 * author Delgado
 */
public interface GovernmentQuotaService {

	void deleteGovernmentQuota() throws SQLException;

	String importGovernmentQuota(HttpServletRequest request) throws IOException, SQLException;

	List<GovernmentQuota> searchGovernmentQuota(SearchDataCondition condition,
			PageTools page) throws SQLException;

	List<GovernmentQuotaRecord> viewGovernmentQuotaDetail(Long id) throws SQLException;

	GovernmentQuota getQuotaById(Long id) throws SQLException;
}

