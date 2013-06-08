package com.bpim.web.action.mainPanel;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bpim.common.Constants;
import com.bpim.entity.PersonalQuotaAnalyseData;
import com.bpim.entity.PersonalRecordAnalyseData;
import com.bpim.form.SearchDataCondition;
import com.bpim.service.PersonalAnalyseService;
import com.bpim.service.PersonalAnalyseServiceImpl;
import com.bpim.web.action.ActionSupportBase;

/**
 * author Delgado
 */
public class PersonalAnalyseAction extends ActionSupportBase {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8678674422829693192L;
	SearchDataCondition condition = new SearchDataCondition();
	PersonalAnalyseService service = new PersonalAnalyseServiceImpl();
	PersonalRecordAnalyseData data = new PersonalRecordAnalyseData();
	List<PersonalRecordAnalyseData> datas = new ArrayList<PersonalRecordAnalyseData>();
	PersonalQuotaAnalyseData companyQuota = new PersonalQuotaAnalyseData();
	
	String msg = "";

	public String personalRecordAnalyse() {
		try {
			condition
					.setUserInfoId((Long) session.get(Constants.LOGIN_USER_ID));
			setQueryProjectDate(condition);
			condition.setArea(getArea(condition.getProvice(),
					condition.getCity()));
			msg = validateRecordCondition();
			data = service.personalRecordAnalyse(condition);
		} catch (ParseException e) {
			LOG.error(e);
		} catch (SQLException e) {
			LOG.error(e);
		}
		return SUCCESS;
	}

	public String personalQuotaAnalyse() {
		try {
			condition
					.setUserInfoId((Long) session.get(Constants.LOGIN_USER_ID));
			setQueryProjectDate(condition);
			condition.setArea(getArea(condition.getProvice(),
					condition.getCity()));
			msg = validateQuotaCondition();
			datas = service.personalQuotaAnalyse(condition);
			companyQuota = service.getCompanyQuotaByCondtion(condition,datas);
		} catch (ParseException e) {
			LOG.error(e);
		} catch (SQLException e) {
			LOG.error(e);
		}
		return SUCCESS;
	}

	private String validateQuotaCondition() {
		if ("".equals(condition.getQuotaClass())
				|| "0".equals(condition.getQuotaClass())) {
			return "定额类别不能为空";
		}
		if ("".equals(condition.getQuotaNum())
				&& "".equals(condition.getQuotaName())) {
			return "定额编号和名称至少输入一个";
		}
		if ("".equals(condition.getArea())
				|| "0".equals(condition.getProvice())) {
			return "省市不能为空";
		}
		return "";
	}

	private String validateRecordCondition() {
		if ("".equals(condition.getRecordName())) {
			return "工料机名称不能为空";
		}
		if ("".equals(condition.getRecordUnit())) {
			return "单位不能为空";
		}
		if ("".equals(condition.getArea())
				|| "0".equals(condition.getProvice())) {
			return "省市不能为空";
		}
		return "";
	}

	private String getArea(String provice, String city) {
		if (null == city || "0".equals(city) || "".equals(city)) {
			return provice;
		}
		return provice + " " + city;
	}

	private void setQueryProjectDate(SearchDataCondition condition)
			throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		if (!"0".equals(condition.getFromYear())) {
			Date afterProjectDate = sdf.parse(condition.getFromYear() + "-"
					+ condition.getFromMonth());
			condition.setProjectDateAfter(new Timestamp(afterProjectDate
					.getTime()));
		}

		if (!"0".equals(condition.getToYear())
				&& !"0".equals(condition.getToMonth())) {
			Date beforeProjectDate = sdf.parse(condition.getToYear() + "-"
					+ condition.getToMonth());
			condition.setProjectDateBefore(new Timestamp(beforeProjectDate
					.getTime()));
		} else if (!"0".equals(condition.getToYear())
				&& "0".equals(condition.getToMonth())) {
			Date beforeProjectDate = sdf
					.parse(condition.getToYear() + "-" + 12);
			condition.setProjectDateBefore(new Timestamp(beforeProjectDate
					.getTime()));
		} else {
			condition.setProjectDateBefore(new Timestamp(new Date().getTime()));
		}

	}

	/**
	 * @return the condition
	 */
	public SearchDataCondition getCondition() {
		return condition;
	}

	/**
	 * @param condition
	 *            the condition to set
	 */
	public void setCondition(SearchDataCondition condition) {
		this.condition = condition;
	}

	/**
	 * @return the data
	 */
	public PersonalRecordAnalyseData getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(PersonalRecordAnalyseData data) {
		this.data = data;
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg
	 *            the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * @return the datas
	 */
	public List<PersonalRecordAnalyseData> getDatas() {
		return datas;
	}

	/**
	 * @param datas the datas to set
	 */
	public void setDatas(List<PersonalRecordAnalyseData> datas) {
		this.datas = datas;
	}

	/**
	 * @return the companyQuota
	 */
	public PersonalQuotaAnalyseData getCompanyQuota() {
		return companyQuota;
	}

	/**
	 * @param companyQuota the companyQuota to set
	 */
	public void setCompanyQuota(PersonalQuotaAnalyseData companyQuota) {
		this.companyQuota = companyQuota;
	}


	
}
