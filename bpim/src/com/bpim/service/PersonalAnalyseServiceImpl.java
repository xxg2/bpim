package com.bpim.service;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.List;

import com.bpim.common.DBConnUtil;
import com.bpim.common.PropertyConstants;
import com.bpim.dao.CustomAndGuideDataDAO;
import com.bpim.dao.CustomAndGuideDataDAOImpl;
import com.bpim.dao.GovernmentQuotaDAO;
import com.bpim.dao.GovernmentQuotaDAOImpl;
import com.bpim.dao.UserProjectDataOperatingDAO;
import com.bpim.dao.UserProjectDataOperatingDAOImpl;
import com.bpim.entity.PersonalQuotaAnalyseData;
import com.bpim.entity.PersonalRecordAnalyseData;
import com.bpim.form.SearchDataCondition;

/**
 * author Delgado
 */
public class PersonalAnalyseServiceImpl implements PersonalAnalyseService {

	UserProjectDataOperatingDAO userDataDAO = new UserProjectDataOperatingDAOImpl();
	CustomAndGuideDataDAO customAndGuideDAO = new CustomAndGuideDataDAOImpl();
	GovernmentQuotaDAO governmentQuotaDAO = new GovernmentQuotaDAOImpl();
	DecimalFormat df = new DecimalFormat(PropertyConstants.DECIMALFORMAT);

	public PersonalRecordAnalyseData personalRecordAnalyse(
			SearchDataCondition condition) throws SQLException {
		DBConnUtil.getConnection();
		DBConnUtil.startTransaction(true);
		Double avgPrice = userDataDAO.getAvgValueByCondition(condition);
		Double maxPrice = userDataDAO.getMaxValueByCondition(condition);
		Double minPrice = userDataDAO.getMinValueByCondition(condition);

		SearchDataCondition tempCondition = condition;
		tempCondition.setUserInfoId((long) 0);
		Double avgGuidePrice = customAndGuideDAO
				.getAvgGuidePriceValueByCondition(tempCondition);
		Double maxGuidePrice = customAndGuideDAO
				.getMaxGuidePriceValueByCondition(tempCondition);
		Double minGuidePrice = customAndGuideDAO
				.getMinGuidePriceValueByCondition(tempCondition);

		Double avgCustomPrice = customAndGuideDAO
				.getAvgCustomPriceValueByCondition(condition);
		Double maxCustomPrice = customAndGuideDAO
				.getMaxCustomPriceValueByCondition(condition);
		Double minCustomPrice = customAndGuideDAO
				.getMinCustomPriceValueByCondition(condition);

		PersonalRecordAnalyseData data = new PersonalRecordAnalyseData();

		data.setRecordName(condition.getRecordName());

		data.setUserRecordAvg(Double.valueOf(df.format(avgPrice)));
		data.setUserRecordMax(Double.valueOf(df.format(maxPrice)));
		data.setUserRecordMin(Double.valueOf(df.format(minPrice)));

		data.setGovernmentGuideAvg(Double.valueOf(df.format(avgGuidePrice)));
		data.setGovernmentGuideMax(Double.valueOf(df.format(maxGuidePrice)));
		data.setGovernmentGuideMin(Double.valueOf(df.format(minGuidePrice)));

		data.setUserCustomAvg(Double.valueOf(df.format(avgCustomPrice)));
		data.setUserCustomMax(Double.valueOf(df.format(maxCustomPrice)));
		data.setUserCustomMin(Double.valueOf(df.format(minCustomPrice)));
		DBConnUtil.close();
		return data;
	}

	public List<PersonalRecordAnalyseData> personalQuotaAnalyse(
			SearchDataCondition condition) throws SQLException {
		DBConnUtil.getConnection();
		List<PersonalRecordAnalyseData> projectDatas = userDataDAO
				.getUserProjectDataByQuota(condition);
		projectDatas = userDataDAO
		.getAvgValueByNameAndUnit(projectDatas,condition);
		for (PersonalRecordAnalyseData data : projectDatas) {
			condition.setRecordName(data.getRecordName());
			condition.setRecordUnit(data.getRecordUnit());

			Double totalPriceOfProjcetPrice = Double.valueOf(df.format(data
					.getUserRecordAvg() * data.getUserRecordGrossAvg()));
			data.setTotalPriceOfProjcetPrice(totalPriceOfProjcetPrice);

			Double recordGrossOfGovernmentQuota = governmentQuotaDAO
					.getRecordGrossOfGovernmentQuota(condition);
			data.setRecordGrossOfGovernmentQuota(recordGrossOfGovernmentQuota);
			Double totalPriceOfGovernmentQuota = Double.valueOf(df.format(data
					.getUserRecordAvg() * recordGrossOfGovernmentQuota));
			data.setTotalPriceOfGovernmentQuota(totalPriceOfGovernmentQuota);

			Double avgGuidePrice = customAndGuideDAO
					.getAvgGuidePriceValueByCondition(condition);
			data.setGovernmentGuideAvg(Double.valueOf(df.format(avgGuidePrice)));
			Double totalPriceOfGuidePrice = Double.valueOf(df
					.format(avgGuidePrice * data.getUserRecordGrossAvg()));
			data.setTotalPriceOfGuidePrice(totalPriceOfGuidePrice);

			Double avgCustomPrice = customAndGuideDAO
					.getAvgCustomPriceValueByCondition(condition);
			data.setUserCustomAvg(avgCustomPrice);
			Double totalPriceOfCustomPrice = Double.valueOf(df
					.format(avgCustomPrice * data.getUserRecordGrossAvg()));
			data.setTotalPriceOfCustomPrice(totalPriceOfCustomPrice);
		}
		DBConnUtil.close();
		return projectDatas;
	}

	public PersonalQuotaAnalyseData getCompanyQuotaByCondtion(
			SearchDataCondition condition, List<PersonalRecordAnalyseData> datas)
			throws SQLException {
		DBConnUtil.getConnection();
		PersonalQuotaAnalyseData companyQuota = new PersonalQuotaAnalyseData();
		companyQuota = userDataDAO.getCompanyQuotaByCondtion(condition);
		Double totalUserProjcetPrice = 0.00;
		Double totalGovernmentQuotaPrice = 0.00;
		Double totalGovernmentGuidePrice = 0.00;
		Double totalUserCustomPrice = 0.00;
		for (PersonalRecordAnalyseData record : datas) {
			totalUserProjcetPrice = totalUserProjcetPrice
					+ record.getTotalPriceOfProjcetPrice();
			totalGovernmentQuotaPrice = totalGovernmentQuotaPrice
					+ record.getTotalPriceOfGovernmentQuota();
			totalGovernmentGuidePrice = totalGovernmentGuidePrice
					+ record.getTotalPriceOfGuidePrice();
			totalUserCustomPrice = totalUserCustomPrice
					+ record.getTotalPriceOfCustomPrice();
		}
		companyQuota.setTotalGovernmentGuidePrice(Double.valueOf(df
				.format(totalGovernmentGuidePrice)));
		companyQuota.setTotalGovernmentQuotaPrice(Double.valueOf(df
				.format(totalGovernmentQuotaPrice)));
		companyQuota.setTotalUserCustomPrice(Double.valueOf(df
				.format(totalUserCustomPrice)));
		companyQuota.setTotalUserProjcetPrice(Double.valueOf(df
				.format(totalUserProjcetPrice)));
		DBConnUtil.close();
		return companyQuota;
	}

}
