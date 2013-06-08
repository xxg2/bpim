package com.bpim.service;

import java.sql.SQLException;
import java.util.List;

import com.bpim.entity.UserInfo;
import com.bpim.helper.PageTools;

public interface UserInfoService {
	List<UserInfo> findAll() throws Exception;
	
	public List<UserInfo> listPage(UserInfo userInfo, PageTools page) throws Exception;
	
	public UserInfo getByLogin(UserInfo userInfo) throws Exception;
	
	public String updatePassword(UserInfo userInfo) throws Exception;

	public void register(UserInfo userInfo) throws SQLException;

	Boolean checkUserName(String userName) throws SQLException;

	UserInfo getUserInfo(Long userId) throws SQLException;

	void modifyUserInfo(UserInfo userInfo) throws SQLException;

	void changePassword(UserInfo userInfo, String newPassword) throws SQLException;
	
	public String initialPassword(UserInfo userInfo) throws Exception;

}
