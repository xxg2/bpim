package com.bpim.service;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import com.bpim.entity.CustomAndGuideData;
import com.bpim.form.SearchDataCondition;
import com.bpim.helper.PageTools;

/**
 * author Delgado
 */
public interface CustomAndGuideDataService {

	List<CustomAndGuideData> searchCustomAndGuideData(SearchDataCondition condition, PageTools page) throws SQLException;

	void deleteGuideData(Timestamp dataDate, String provice) throws SQLException;

	void updateCustomData(CustomAndGuideData data) throws SQLException;

	CustomAndGuideData queryCustomDataDetail(String id) throws SQLException;

}

