package com.bpim.web.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.bpim.common.Constants;
import com.opensymphony.xwork2.ActionSupport;

public class ActionSupportBase extends ActionSupport implements
		ServletRequestAware, ServletResponseAware, SessionAware {

	private static final long serialVersionUID = 7565312467700060959L;

	protected HttpServletRequest request;

	protected HttpServletResponse response;

	protected Map session;

	protected static String COM_RESULT = "comresult";
	
	protected static String REQUIRED_DATA = "requireddata";
	
	protected static String MODIFY = "modify";

	protected static String DELETE = "delete";

	protected static String VIEW = "view";

	protected static String NO_RESULT = "noresult";

	protected static String NOT_MODIFY = "notmodify";

	protected static String NO_OPTION = "nooption";					// 缺少必填选项

	protected void addErrorMsg(String operation) {
		super.addFieldError(Constants.ERROR_MSG, super.getText(operation)
				+ super.getText(Constants.FAIL));
	}

	protected void addSaveErrorMsg() {
		addErrorMsg(Constants.OPERATE_ADD);
	}

	protected void addUpdateErrorMsg() {
		addErrorMsg(Constants.OPERATE_UPDATE);
	}

	protected void addDeleteErrorMsg() {
		addErrorMsg(Constants.OPERATE_DELETE);
	}

	protected void addNotFoundErrorMsg() {
		super.addFieldError(Constants.ERROR_MSG, super
				.getText(Constants.NOT_FOUND));
	}

	protected void addUnknowErrorMsg() {
		super.addFieldError(Constants.ERROR_MSG, super
				.getText(Constants.UNKNOW_ERROR));
	}

	protected void addParamErrorMsg() {
		super.addFieldError(Constants.ERROR_MSG, super.getText(Constants.PARAM)
				+ super.getText(Constants.ERROR));
	}
	
	protected void addResultMsg(String msg) {
		//super.addActionMessage(msg);
		request.setAttribute("msg", msg);
//		super.addFieldError(Constants.RESULT_MSG, msg);
	}
	
	protected void addResultMsgUnknowError() {
		addResultMsg("error:" + getText(Constants.UNKNOW_ERROR));
	}
	
	protected void addResultMsgSuccess() {
		addResultMsg("success");
	}

	protected String getReturnString() {
		String ac = request.getParameter("ac");
		if (StringUtils.isBlank(ac)
				|| (!ac.equals(VIEW) && !ac.equals(MODIFY) && !ac
						.equals(DELETE))) {
			addParamErrorMsg();
			return ERROR;
		}
		return ac;
	}

	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		request = arg0;
	}

	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		response = arg0;
	}

	public void setSession(Map arg0) {
		// TODO Auto-generated method stub
		session = arg0;
	}
}
