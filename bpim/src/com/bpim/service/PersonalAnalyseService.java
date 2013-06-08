package com.bpim.service;

import java.sql.SQLException;
import java.util.List;

import com.bpim.entity.GovernmentQuota;
import com.bpim.entity.PersonalQuotaAnalyseData;
import com.bpim.entity.PersonalRecordAnalyseData;
import com.bpim.form.SearchDataCondition;

/**
 * author Delgado
 */
public interface PersonalAnalyseService {

	PersonalRecordAnalyseData personalRecordAnalyse(
			SearchDataCondition condition) throws SQLException;

	List<PersonalRecordAnalyseData> personalQuotaAnalyse(SearchDataCondition condition) throws SQLException;

	PersonalQuotaAnalyseData getCompanyQuotaByCondtion(SearchDataCondition condition, List<PersonalRecordAnalyseData> datas) throws SQLException;

}

