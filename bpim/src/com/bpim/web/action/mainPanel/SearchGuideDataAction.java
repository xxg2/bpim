package com.bpim.web.action.mainPanel;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bpim.common.Constants;
import com.bpim.entity.CustomAndGuideData;
import com.bpim.form.SearchDataCondition;
import com.bpim.helper.PageTools;
import com.bpim.helper.ParamTools;
import com.bpim.service.CustomAndGuideDataService;
import com.bpim.service.CustomAndGuideDataServiceImpl;
import com.bpim.web.action.ActionSupportBase;

/**
 * author Delgado
 */
public class SearchGuideDataAction extends ActionSupportBase {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7089426128848244942L;
	SearchDataCondition condition = new SearchDataCondition();
	CustomAndGuideDataService service = new CustomAndGuideDataServiceImpl();
	List<CustomAndGuideData> datas = new ArrayList<CustomAndGuideData>();
	private PageTools page;
	
	public PageTools getPage() {
		return page;
	}

	public void setPage(PageTools page) {
		this.page = page;
	}

	public String searchGuideData() {
		try {
			int pageNo = ParamTools.getIntParameter(request,
					Constants.PARA_PAGE_NO, 1);
			int pageSize = ParamTools.getIntParameter(request,
					Constants.PARA_PAGE_SIZE, 0);
			PageTools page = new PageTools(pageNo, pageSize);
			condition.setUserInfoId((Long) session.get(Constants.LOGIN_USER_ID));
			condition.setRowCount(pageNo);
			condition.setPageSize(pageSize);
			setQueryProjectDate(condition);
			datas = service.searchCustomAndGuideData(condition, page);
			if (datas != null && datas.size() > 0) {
				this.page = page;
			} else {
				super.addNotFoundErrorMsg();
				return SUCCESS;
			}
		} catch (ParseException e) {
			LOG.error(e);
		} catch (SQLException e) {
			LOG.error(e);
		}
		return SUCCESS;
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
	 * @return the datas
	 */
	public List<CustomAndGuideData> getDatas() {
		return datas;
	}

	/**
	 * @param datas the datas to set
	 */
	public void setDatas(List<CustomAndGuideData> datas) {
		this.datas = datas;
	}

}
