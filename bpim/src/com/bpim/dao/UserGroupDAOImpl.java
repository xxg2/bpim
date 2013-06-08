package com.bpim.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bpim.common.DBConnUtil;
import com.bpim.entity.UserGroup;

public class UserGroupDAOImpl implements UserGroupDAO {
	private static final String FINDALLSQL = "SELECT ID, GROUP_NAME, GROUP_LEADER_ID, GROUP_DESCRIPTION FROM USER_GROUP";
	private static final String GETBYUSERIDSQL = "SELECT ID, GROUP_NAME, GROUP_LEADER_ID, GROUP_DESCRIPTION FROM USER_GROUP WHERE GROUP_LEADER_ID = ?";
	
	public List<UserGroup> findAll() throws SQLException {
		ResultSet result = DBConnUtil.getStatement(FINDALLSQL);
		DBConnUtil.close();
		UserGroup userGroup;
		List<UserGroup> list = new ArrayList<UserGroup>();
		while(result.next()) {
			userGroup = new UserGroup();
			userGroup.setId(result.getLong("ID"));
			userGroup.setGroupName(result.getString("GROUP_NAME"));
			userGroup.setGroupLeaderId(result.getLong("GROUP_LEADER_ID"));
			userGroup.setGroupDescription(result.getString("GROUP_DESCRIPTION"));
			list.add(userGroup);
		}
		return list;
	}

	public List<UserGroup> getByUserID(UserGroup userGroup) throws SQLException {
		PreparedStatement stet = DBConnUtil.getPrepareStatement(GETBYUSERIDSQL);
		stet.setLong(1, userGroup.getGroupLeaderId());
		ResultSet result = stet.executeQuery();
		DBConnUtil.close();
		List<UserGroup> list = new ArrayList<UserGroup>();
		UserGroup userGroup1;
		while(result.next()) {
			userGroup1 = new UserGroup();
			userGroup1.setId(result.getLong("ID"));
			userGroup1.setGroupName(result.getString("GROUP_NAME"));
			userGroup1.setGroupLeaderId(result.getLong("GROUP_LEADER_ID"));
			userGroup1.setGroupDescription(result.getString("GROUP_DESCRIPTION"));
			list.add(userGroup);
		}
		return list;
	}
}
