package com.bpim.web.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bpim.common.Constants;
import com.bpim.entity.UserInfo;
import com.bpim.helper.StringTools;
import com.bpim.service.MessageService;
import com.bpim.service.MessageServiceImpl;
import com.bpim.service.UserInfoService;
import com.bpim.service.UserInfoServiceImpl;

/**
 * @author Bo.Cui
 * 
 */
public class LoginAction extends ActionSupportBase {

	private static final long serialVersionUID = -3478893903449925988L;

	private static final Log LOG = LogFactory.getLog(LoginAction.class);

	private UserInfoService userInfoService = new UserInfoServiceImpl();
	private MessageService messageService = new MessageServiceImpl();

	private String validateCode;
	private String username;
	private String password;

	public static Map<String, List> userSessionMap = new HashMap<String, List>();

	public String getValidateCode() {
		return validateCode;
	}

	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String execute() throws Exception {
		// String validateCode = request.getParameter("validateCode");
		String vCode = (String) session.remove(Constants.VALIDATE_IMG);
		if (vCode == null) {
			return ERROR;
		}
		if (vCode != null && !vCode.equals(validateCode)) {
			super.addFieldError("validateCode", super.getText("验证码输入错误"));
			return INPUT;
		}
		// String userName = request.getParameter("username");
		// String password = request.getParameter("password");
		UserInfo userInfo = new UserInfo();
		userInfo.setUserName(username);
		userInfo.setPassword(StringTools.md5(password));
		userInfo = userInfoService.getByLogin(userInfo);
		if (userInfo == null) {
			super.addFieldError("name", "用户名或密码错误,请重新输入");
			return INPUT;
		} else if (userInfo.getExpireDate().getTime() < System
				.currentTimeMillis()) {
			super.addFieldError("name", "用户已过期,请充值后再登录");
			return INPUT;
		}
		int messageCount = messageService.getNewMessageAcount(userInfo.getId());
		session.put(Constants.LOGIN_USER_NAME, username);
		session.put(Constants.LOGIN_USER_ID, userInfo.getId());
		session.put(Constants.LOGIN_EXPIRE_DATE, userInfo.getExpireDate());
		session.put(Constants.NEW_MESSAGE_COUNT, messageCount);
		session.put(Constants.USER_LOGIN_TIME, new Date().getTime());
		saveUserSession(session);
		return SUCCESS;
	}

	private String findClient_IPAddr() {
		String ip = request.getHeader("X-Forwarded-For");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	private void saveUserSession(Map session) {

		String userid = String.valueOf((Long) session
				.get(Constants.LOGIN_USER_ID));

		if (null == userSessionMap.get(userid)) {
			List userSessionList = new ArrayList();
			userSessionList.add(session);
			userSessionMap.put(userid, userSessionList);
		} else {
			userSessionMap.get(userid).add(session);
		}
	}

}