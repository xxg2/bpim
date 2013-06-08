package com.bpim.dao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import com.bpim.entity.CustomAndGuideData;
import com.bpim.form.SearchDataCondition;

/**
 * author Delgado
 */
public interface CustomAndGuideDataDAO {

	List<CustomAndGuideData> searchGovermentGuidePrice(
			SearchDataCondition condition) throws SQLException;

	List<CustomAndGuideData> searchCustomPrice(SearchDataCondition condition)
			throws SQLException;

	List<CustomAndGuideData> searchBoth(SearchDataCondition condition)
			throws SQLException;

	int countSearchGovermentGuidePrice(SearchDataCondition condition)
			throws SQLException;

	int countSearchCustomPrice(SearchDataCondition condition)
			throws SQLException;

	int countSearchBoth(SearchDataCondition condition) throws SQLException;

	void deleteCustomData(String id) throws NumberFormatException, SQLException;

	void deleteGuideData(Timestamp dataDate, String provice)
			throws SQLException;

	CustomAndGuideData queryCustomDataDetail(String id) throws SQLException;

	void updateCustomData(CustomAndGuideData data) throws SQLException;

	Double getAvgGuidePriceValueByCondition(SearchDataCondition condition)
			throws SQLException;

	Double getMaxGuidePriceValueByCondition(SearchDataCondition condition)
			throws SQLException;

	Double getMinGuidePriceValueByCondition(SearchDataCondition condition)
			throws SQLException;

	Double getAvgCustomPriceValueByCondition(SearchDataCondition condition)
			throws SQLException;

	Double getMaxCustomPriceValueByCondition(SearchDataCondition condition)
			throws SQLException;

	Double getMinCustomPriceValueByCondition(SearchDataCondition condition)
			throws SQLException;
}
