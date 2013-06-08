package com.bpim.web.action.login;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bpim.common.Constants;
import com.bpim.entity.UserInfo;
import com.bpim.helper.ParamTools;
import com.bpim.helper.StringTools;
import com.bpim.service.UserInfoService;
import com.bpim.service.UserInfoServiceImpl;
import com.bpim.web.action.ActionSupportBase;

/**
 * @author Delgado
 * 
 */
public class RegisterAction extends ActionSupportBase {

	private static final long serialVersionUID = -3478893903449925988L;

	private static final Log LOG = LogFactory.getLog(RegisterAction.class);

	private UserInfoService userInfoService = new UserInfoServiceImpl();
	private UserInfo userInfo = new UserInfo();
	private String validateCode;

	public String getValidateCode() {
		return validateCode;
	}

	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}

	public String register() {

		try {
			String vCode = (String) session.remove(Constants.VALIDATE_IMG);
			if (vCode == null) {
				return ERROR;
			}
			if (vCode != null && !vCode.equals(validateCode)) {
				super.addFieldError("validateCode", super.getText("验证码输入错误"));
				return SUCCESS;
			}
			Boolean valid = userInfoService.checkUserName(request
					.getParameter("userName"));
			if (valid) {
				userInfo.setUserName(request.getParameter("userName"));
				userInfo.setPassword(StringTools.md5(request.getParameter("password")));
				userInfo.setEmail(request.getParameter("mailAddress"));
				userInfo.setPhone(request.getParameter("mobile"));
				userInfo.setCompany(request.getParameter("company"));
				userInfo.setQuestion(request.getParameter("question"));
				userInfo.setAnswer(request.getParameter("answer"));
				userInfo.setRegisterDate(new Timestamp(new Date().getTime()));
				String probation = ParamTools.getProperty(request, Constants.PROBATION);
				long probationTime = 1000 * 60 * 60 * 24 * Long.valueOf(probation);
				userInfo.setExpireDate(new Timestamp(new Date().getTime()
						+ probationTime));
				userInfoService.register(userInfo);
				userInfo.setPassword(request.getParameter("password"));
			} else {
				userInfo.setUserName("用户名已存在");
				userInfo.setPassword("");
				return SUCCESS;
			}
		} catch (SQLException e) {
			LOG.error("register error:" + e);
			return ERROR;
		} catch (IOException e) {
			LOG.error("register error:" + e);
			return ERROR;
		}

		return SUCCESS;
	}

	/**
	 * @return the userInfo
	 */
	public UserInfo getUserInfo() {
		return userInfo;
	}

	/**
	 * @param userInfo
	 *            the userInfo to set
	 */
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

}
