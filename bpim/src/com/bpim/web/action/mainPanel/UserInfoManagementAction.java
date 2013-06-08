package com.bpim.web.action.mainPanel;

import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bpim.common.Constants;
import com.bpim.entity.UserInfo;
import com.bpim.helper.StringTools;
import com.bpim.service.UserInfoService;
import com.bpim.service.UserInfoServiceImpl;
import com.bpim.web.action.ActionSupportBase;

/**
 * @author Delgado
 * 
 */
public class UserInfoManagementAction extends ActionSupportBase {

	private static final long serialVersionUID = -3478893903449925988L;

	private static final Log LOG = LogFactory.getLog(UserInfoManagementAction.class);
	
	private UserInfoService userInfoService = new UserInfoServiceImpl();
	private UserInfo userInfo = new UserInfo();
	private String msg;

	public String getUserDetailInfo(){
		Long userId = (Long) session.get(Constants.LOGIN_USER_ID);
		try {
			userInfo = userInfoService.getUserInfo(userId);
		} catch (SQLException e) {
			LOG.error("register error:" + e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	public String modifyUserInfo(){
		userInfo.setUserName(request.getParameter("userName"));
		userInfo.setEmail(request.getParameter("mailAddress"));
		userInfo.setPhone(request.getParameter("mobile"));
		userInfo.setCompany(request.getParameter("company"));
		userInfo.setQuestion(request.getParameter("question"));
		userInfo.setAnswer(request.getParameter("answer"));
		try {
			userInfoService.modifyUserInfo(userInfo);
		} catch (SQLException e) {
			msg = "操作失败";
			LOG.error("modifyUserInfo error:" + e);
			return ERROR;
		}
		msg = "操作成功";
		return SUCCESS;
	}
	
	public String changePassword(){
		Long userId = (Long) session.get(Constants.LOGIN_USER_ID);
		try {
			userInfo.setId(userId);
			String currentPassword = StringTools.md5(request.getParameter("currentPassword"));
			UserInfo currentUserInfo = userInfoService.getUserInfo(userId);
			if(currentPassword.equals(currentUserInfo.getPassword())){
				String newPassword = StringTools.md5(request.getParameter("password"));
				userInfoService.changePassword(userInfo,newPassword);
			}else{
				msg = "当前密码错误，重新输入";
				return SUCCESS;
			}
		} catch (SQLException e) {
			msg = "操作失败";
			LOG.error("modifyUserInfo error:" + e);
			return ERROR;
		}
		msg = "操作成功";
		return SUCCESS;
	}
	

	/**
	 * @return the userInfo
	 */
	public UserInfo getUserInfo() {
		return userInfo;
	}

	/**
	 * @param userInfo the userInfo to set
	 */
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	
}
