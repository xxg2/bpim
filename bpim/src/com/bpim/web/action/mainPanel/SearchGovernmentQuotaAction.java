package com.bpim.web.action.mainPanel;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.bpim.common.Constants;
import com.bpim.entity.GovernmentQuota;
import com.bpim.form.SearchDataCondition;
import com.bpim.helper.PageTools;
import com.bpim.helper.ParamTools;
import com.bpim.service.GovernmentQuotaService;
import com.bpim.service.GovernmentQuotaServiceImpl;
import com.bpim.web.action.ActionSupportBase;

/**
 * author Delgado
 */
public class SearchGovernmentQuotaAction extends ActionSupportBase {
	/**
	 * 
	 */
	private static final long serialVersionUID = -251531175570040393L;
	SearchDataCondition condition = new SearchDataCondition();
	GovernmentQuotaService service = new GovernmentQuotaServiceImpl();
	List<GovernmentQuota> datas = new ArrayList<GovernmentQuota>();
	private PageTools page;
	
	public PageTools getPage() {
		return page;
	}

	public void setPage(PageTools page) {
		this.page = page;
	}

	public String searchGovernmentQuota() {
		try {
			int pageNo = ParamTools.getIntParameter(request,
					Constants.PARA_PAGE_NO, 1);
			int pageSize = ParamTools.getIntParameter(request,
					Constants.PARA_PAGE_SIZE, 0);
			PageTools page = new PageTools(pageNo, pageSize);
			condition.setRowCount(pageNo);
			condition.setPageSize(pageSize);
			datas = service.searchGovernmentQuota(condition, page);
			if (datas != null && datas.size() > 0) {
				this.page = page;
			} else {
				super.addNotFoundErrorMsg();
				return SUCCESS;
			}
		} catch (SQLException e) {
			LOG.error(e);
		}
		return SUCCESS;
	}

	/**
	 * @return the condition
	 */
	public SearchDataCondition getCondition() {
		return condition;
	}

	/**
	 * @param condition the condition to set
	 */
	public void setCondition(SearchDataCondition condition) {
		this.condition = condition;
	}

	/**
	 * @return the datas
	 */
	public List<GovernmentQuota> getDatas() {
		return datas;
	}

	/**
	 * @param datas the datas to set
	 */
	public void setDatas(List<GovernmentQuota> datas) {
		this.datas = datas;
	}

	
}
