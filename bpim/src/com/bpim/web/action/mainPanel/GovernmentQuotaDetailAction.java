package com.bpim.web.action.mainPanel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bpim.entity.GovernmentQuota;
import com.bpim.entity.GovernmentQuotaRecord;
import com.bpim.service.GovernmentQuotaService;
import com.bpim.service.GovernmentQuotaServiceImpl;
import com.bpim.web.action.ActionSupportBase;

/**
 * author Delgado
 */
public class GovernmentQuotaDetailAction extends ActionSupportBase {

	private static final long serialVersionUID = 6638298297294518090L;
	GovernmentQuotaService service = new GovernmentQuotaServiceImpl();
	List<GovernmentQuotaRecord> datas = new ArrayList<GovernmentQuotaRecord>();
	GovernmentQuota quota = new GovernmentQuota();

	public String viewGovernmentQuotaDetail() {
		try {
			String id = request.getParameter("id");
			datas = service.viewGovernmentQuotaDetail(Long.valueOf(id));
			quota = service.getQuotaById(Long.valueOf(id));
		} catch (SQLException e) {
			LOG.error(e);
		}
		return SUCCESS;
	}

	/**
	 * @return the datas
	 */
	public List<GovernmentQuotaRecord> getDatas() {
		return datas;
	}

	/**
	 * @param datas the datas to set
	 */
	public void setDatas(List<GovernmentQuotaRecord> datas) {
		this.datas = datas;
	}

	/**
	 * @return the quota
	 */
	public GovernmentQuota getQuota() {
		return quota;
	}

	/**
	 * @param quota the quota to set
	 */
	public void setQuota(GovernmentQuota quota) {
		this.quota = quota;
	}

	
}
