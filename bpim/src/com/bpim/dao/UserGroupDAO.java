package com.bpim.dao;

import java.sql.SQLException;
import java.util.List;

import com.bpim.entity.UserGroup;

public interface UserGroupDAO {
	List<UserGroup> findAll() throws SQLException;
	
	List<UserGroup> getByUserID(UserGroup userGroup) throws SQLException;
}
