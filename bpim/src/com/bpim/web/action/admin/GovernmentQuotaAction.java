package com.bpim.web.action.admin;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bpim.service.CustomAndGuideDataService;
import com.bpim.service.CustomAndGuideDataServiceImpl;
import com.bpim.service.GovernmentQuotaService;
import com.bpim.service.GovernmentQuotaServiceImpl;
import com.bpim.web.action.ActionSupportBase;
import com.bpim.web.action.LoginAction;

public class GovernmentQuotaAction extends ActionSupportBase {
	private static final long serialVersionUID = -1781372665512868821L;

	private String msg = "删除成功";

	private static final Log LOG = LogFactory
			.getLog(GovernmentQuotaAction.class);

	private GovernmentQuotaService service = new GovernmentQuotaServiceImpl();

	public String deleteGovernmentQuota() {
		try {
			service.deleteGovernmentQuota();
		} catch (SQLException e) {
			msg = "删除失败";
			LOG.error(e);
		}

		return SUCCESS;
	}

	public String importGovernmentQuota() {
		try {
			msg = service.importGovernmentQuota(request);
		} catch (IOException e) {
			LOG.error(e);
			msg = "文件夹未找到";
		} catch (SQLException e) {
			LOG.error(e);
			msg = "数据库异常";
		}
		return SUCCESS;
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

}