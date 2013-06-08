package com.bpim.dao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import com.bpim.entity.UserInfo;

/*
 * author Tom
 */

public interface UserInfoDAO {
	List<UserInfo> findAll() throws SQLException;
	
	UserInfo get(UserInfo userInfo) throws SQLException;
	
	UserInfo getByLogin(UserInfo userInfo) throws SQLException;
	
	void save(UserInfo userInfo) throws SQLException;
	
	boolean update(UserInfo userInfo) throws SQLException;
	
	void delete(Long id) throws SQLException;
	
	boolean updatePassword(UserInfo userInfo) throws SQLException;
	
	List<UserInfo> findByCount(UserInfo userInfo) throws SQLException;
	
	int getRowCount(UserInfo userInfo) throws SQLException;

	void register(UserInfo userInfo) throws SQLException;

	Boolean checkUserName(String userName) throws SQLException;

	UserInfo getUserInfo(Long userId) throws SQLException;

	void modifyUserInfo(UserInfo userInfo) throws SQLException;

	void changePassword(UserInfo userInfo, String newPassword) throws SQLException;
	
	boolean updateExpireDate(UserInfo userInfo) throws SQLException;
	
	UserInfo getByName(UserInfo userInfo) throws SQLException;
	
	boolean initialPassword(UserInfo userInfo) throws SQLException;

}