package com.bpim.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.bpim.common.DBConnUtil;
import com.bpim.common.PropertyConstants;
import com.bpim.dao.UserInfoDAO;
import com.bpim.dao.UserInfoDAOImpl;
import com.bpim.entity.UserInfo;
import com.bpim.helper.PageTools;

public class UserInfoServiceImpl implements UserInfoService {
	private UserInfoDAO userInfoDAO = UserInfoDAOImpl.getInstance();
	
	public List<UserInfo> listPage(UserInfo userInfo, PageTools page) throws Exception {
		DBConnUtil.getConnection();
		if (page != null) {
			if (page.getRecordCount() == 0) {
				int count = userInfoDAO.getRowCount(userInfo);
				page.setRecordCount(count);
			}
			userInfo.setStartRow(page.getPageStartRow());
			userInfo.setPageSize(page.getPageSize());
		}
		List<UserInfo> userInfos = userInfoDAO.findByCount(userInfo);
		DBConnUtil.close();
		return userInfos;
	}
	
	public List<UserInfo> findAll() throws Exception {
		DBConnUtil.getConnection();
		List<UserInfo> userInfos = userInfoDAO.findAll();
		DBConnUtil.close();
		return userInfos;
	}
	
	public UserInfo getByLogin(UserInfo userInfo) throws Exception {
		DBConnUtil.getConnection();
		UserInfo userInfo1 = userInfoDAO.getByLogin(userInfo);
		DBConnUtil.close();
		return userInfo1;
	}
	
	public UserInfo getByName(UserInfo userInfo) throws Exception {
		DBConnUtil.getConnection();
		if(StringUtils.isBlank(userInfo.getUserName())) {
			return userInfo;
		}
		UserInfo userInfo1 = userInfoDAO.getByName(userInfo);
		DBConnUtil.close();
		return userInfo1;
	}
	
	public boolean update(UserInfo userInfo) throws Exception {
		DBConnUtil.getConnection();
		DBConnUtil.startTransaction(true);
		boolean flag = userInfoDAO.update(userInfo);
		DBConnUtil.close();
		return flag;
	}

	public String updatePassword(UserInfo userInfo) throws Exception {
		DBConnUtil.getConnection();
		DBConnUtil.startTransaction(true);
		String pass = ""+(long)(Math.random()*(999999-100000+1)+100000);
		userInfo.setPassword(pass);
		boolean isUpdated = userInfoDAO.updatePassword(userInfo);
		DBConnUtil.close();
		if(isUpdated) {
			return pass;
		} else {
			return PropertyConstants.UPDATEPASSFAILED;
		}
	}
	
	public String initialPassword(UserInfo userInfo) throws Exception {
		DBConnUtil.getConnection();
		DBConnUtil.startTransaction(true);
		String pass = ""+(long)(Math.random()*(999999-100000+1)+100000);
		userInfo.setPassword(pass);
		boolean isUpdated = userInfoDAO.initialPassword(userInfo);
		DBConnUtil.close();
		if(isUpdated) {
			return pass;
		} else {
			return null;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(""+(long)(Math.random()*(999999-100000+1)+100000));
	}

	public void register(UserInfo userInfo) throws SQLException {
		DBConnUtil.getConnection();
		DBConnUtil.startTransaction(true);
		userInfoDAO.register(userInfo);
		DBConnUtil.close();
	}

	public Boolean checkUserName(String userName) throws SQLException {
		DBConnUtil.getConnection();
		Boolean valid = userInfoDAO.checkUserName(userName);
		DBConnUtil.close();
		return valid;
	}

	public UserInfo getUserInfo(Long userId) throws SQLException {
		DBConnUtil.getConnection();
		UserInfo userInfo = userInfoDAO.getUserInfo(userId);
		DBConnUtil.close();
		return userInfo;
	}

	public void modifyUserInfo(UserInfo userInfo) throws SQLException {
		DBConnUtil.getConnection();
		DBConnUtil.startTransaction(true);
		userInfoDAO.modifyUserInfo(userInfo);
		DBConnUtil.close();
	}

	public void changePassword(UserInfo userInfo, String newPassword) throws SQLException {
		DBConnUtil.getConnection();
		DBConnUtil.startTransaction(true);
		userInfoDAO.changePassword(userInfo, newPassword);
		DBConnUtil.close();
	}

}
