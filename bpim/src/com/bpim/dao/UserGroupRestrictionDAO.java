package com.bpim.dao;

import java.sql.SQLException;
import java.util.List;

import com.bpim.entity.UserInfo;

public interface UserGroupRestrictionDAO {
List<UserInfo> findAll() throws SQLException;
	
	UserInfo get(UserInfo userInfo) throws SQLException;
	
	boolean getByLogin(UserInfo userInfo) throws SQLException;
	
	void save(UserInfo userInfo) throws SQLException;
	
	void update(UserInfo userInfo) throws SQLException;
	
	void delete(Long id) throws SQLException;
	
	boolean updatePassword(UserInfo userInfo) throws SQLException;
	
	List<UserInfo> findByCount(UserInfo userInfo) throws SQLException;
	
	int getRowCount(UserInfo userInfo) throws SQLException;
}
