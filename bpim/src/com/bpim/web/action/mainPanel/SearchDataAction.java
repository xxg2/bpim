package com.bpim.web.action.mainPanel;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.bpim.common.Constants;
import com.bpim.entity.UserProjectUploadData;
import com.bpim.form.SearchDataCondition;
import com.bpim.helper.PageTools;
import com.bpim.helper.ParamTools;
import com.bpim.service.UserProjectDataOperatingService;
import com.bpim.service.UserProjectDataOperatingServiceImpl;
import com.bpim.web.action.ActionSupportBase;

/**
 * author Delgado
 */
public class SearchDataAction extends ActionSupportBase {
	private static final long serialVersionUID = 9119524384016813638L;
	private List<UserProjectUploadData> datas;
	private String fromYear;
	private String fromMonth;
	private String toYear;
	private String toMonth;
	private String projectName;
	private String recordType;
	private String quotaNum;
	private String quotaName;
	private String recordName;
	private String recordUnit;
	private String dataType;
	private PageTools page;

	public PageTools getPage() {
		return page;
	}

	public void setPage(PageTools page) {
		this.page = page;
	}

	UserProjectDataOperatingService service = new UserProjectDataOperatingServiceImpl();

	public String searchUserProjectData() {
		try {
			int pageNo = ParamTools.getIntParameter(request,
					Constants.PARA_PAGE_NO, 1);
			int pageSize = ParamTools.getIntParameter(request,
					Constants.PARA_PAGE_SIZE, 0);
			PageTools page = new PageTools(pageNo, pageSize);
			SearchDataCondition condition = new SearchDataCondition();
			condition.setUserInfoId((Long) session.get(Constants.LOGIN_USER_ID));
			condition.setRowCount(pageNo);
			condition.setPageSize(pageSize);
			setQueryProjectDate(condition);
			condition.setDataType(dataType);
			condition.setProjectName(projectName);
			condition.setQuotaName(quotaName);
			condition.setQuotaNum(quotaNum);
			condition.setRecordType(recordType);
			condition.setRecordName(recordName);
			condition.setRecordUnit(recordUnit);
			datas = service.searchProjectDataByCondition(condition, page);
			if (datas != null && datas.size() > 0) {
				this.page = page;
			} else {
				super.addNotFoundErrorMsg();
				return SUCCESS;
			}
		} catch (ParseException e) {
			LOG.error(e);
			e.printStackTrace();
		} catch (Exception ex) {
			LOG.error("UserInfoAction error: ", ex);
			super.addErrorMsg(ex.getMessage());
			ex.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}

	private void setQueryProjectDate(SearchDataCondition condition)
			throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		if ( !"0".equals(fromYear)) {
			Date afterProjectDate = sdf.parse(fromYear + "-" + fromMonth);
			condition.setProjectDateAfter(new Timestamp(afterProjectDate
					.getTime()));
		}
		
		
		if ( !"0".equals(toYear)
				&& !"0".equals(toMonth)) {
			Date beforeProjectDate = sdf.parse(toYear + "-" + toMonth);
			condition.setProjectDateBefore(new Timestamp(beforeProjectDate
					.getTime()));
		}else if(!"0".equals(toYear) && "0".equals(toMonth)){
			Date beforeProjectDate = sdf.parse(toYear + "-" + 12);
			condition.setProjectDateBefore(new Timestamp(beforeProjectDate
					.getTime()));
		}else{
			condition.setProjectDateBefore(new Timestamp(new Date()
					.getTime()));
		}

	}

	/**
	 * @return the datas
	 */
	public List<UserProjectUploadData> getDatas() {
		return datas;
	}

	/**
	 * @param datas
	 *            the datas to set
	 */
	public void setDatas(List<UserProjectUploadData> datas) {
		this.datas = datas;
	}

	/**
	 * @return the fromYear
	 */
	public String getFromYear() {
		return fromYear;
	}

	/**
	 * @param fromYear
	 *            the fromYear to set
	 */
	public void setFromYear(String fromYear) {
		this.fromYear = fromYear;
	}

	/**
	 * @return the fromMonth
	 */
	public String getFromMonth() {
		return fromMonth;
	}

	/**
	 * @param fromMonth
	 *            the fromMonth to set
	 */
	public void setFromMonth(String fromMonth) {
		this.fromMonth = fromMonth;
	}

	/**
	 * @return the toYear
	 */
	public String getToYear() {
		return toYear;
	}

	/**
	 * @param toYear
	 *            the toYear to set
	 */
	public void setToYear(String toYear) {
		this.toYear = toYear;
	}

	/**
	 * @return the toMonth
	 */
	public String getToMonth() {
		return toMonth;
	}

	/**
	 * @param toMonth
	 *            the toMonth to set
	 */
	public void setToMonth(String toMonth) {
		this.toMonth = toMonth;
	}

	/**
	 * @return the projectName
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * @param projectName
	 *            the projectName to set
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	

	/**
	 * @return the recordType
	 */
	public String getRecordType() {
		return recordType;
	}

	/**
	 * @param recordType the recordType to set
	 */
	public void setRecordType(String recordType) {
		this.recordType = recordType;
	}

	/**
	 * @return the quotaNum
	 */
	public String getQuotaNum() {
		return quotaNum;
	}

	/**
	 * @param quotaNum
	 *            the quotaNum to set
	 */
	public void setQuotaNum(String quotaNum) {
		this.quotaNum = quotaNum;
	}

	/**
	 * @return the quotaName
	 */
	public String getQuotaName() {
		return quotaName;
	}

	/**
	 * @param quotaName
	 *            the quotaName to set
	 */
	public void setQuotaName(String quotaName) {
		this.quotaName = quotaName;
	}

	/**
	 * @return the recordName
	 */
	public String getRecordName() {
		return recordName;
	}

	/**
	 * @param recordName
	 *            the recordName to set
	 */
	public void setRecordName(String recordName) {
		this.recordName = recordName;
	}

	/**
	 * @return the recordUnit
	 */
	public String getRecordUnit() {
		return recordUnit;
	}

	/**
	 * @param recordUnit
	 *            the recordUnit to set
	 */
	public void setRecordUnit(String recordUnit) {
		this.recordUnit = recordUnit;
	}

	/**
	 * @return the dataType
	 */
	public String getDataType() {
		return dataType;
	}

	/**
	 * @param dataType
	 *            the dataType to set
	 */
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

}
