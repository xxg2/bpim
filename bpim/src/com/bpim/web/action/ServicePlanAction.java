package com.bpim.web.action;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bpim.common.Constants;
import com.bpim.entity.ServicePlan;
import com.bpim.entity.UserInfo;
import com.bpim.helper.PageTools;
import com.bpim.helper.ParamTools;
import com.bpim.service.ServicePlanServiceImpl;
import com.bpim.service.UserInfoService;

public class ServicePlanAction extends ActionSupportBase {
	private static final long serialVersionUID = -5620230655376038210L;

	private static final Log LOG = LogFactory.getLog(LoginAction.class);

	private ServicePlanServiceImpl servicePlanServiceImpl = new ServicePlanServiceImpl();
	
	private List<ServicePlan> servicePlans;

	public List<ServicePlan> getServicePlans() {
		return servicePlans;
	}

	public void setServicePlans(List<ServicePlan> servicePlans) {
		this.servicePlans = servicePlans;
	}

	public String listServicePlans() {
		try {
			servicePlans = servicePlanServiceImpl.findAll();
			if (servicePlans == null || servicePlans.size() == 0) {
				super.addNotFoundErrorMsg();
				return SUCCESS;
			}
		} catch (Exception ex) {
			LOG.error("UserInfoAction error: ", ex);
			super.addErrorMsg(ex.getMessage());
			ex.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}
}
