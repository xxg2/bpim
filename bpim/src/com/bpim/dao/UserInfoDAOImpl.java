package com.bpim.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.bpim.common.DBConnUtil;
import com.bpim.entity.UserInfo;

public class UserInfoDAOImpl implements UserInfoDAO {

	private static UserInfoDAOImpl userInfoDAOImpl = new UserInfoDAOImpl();

	private static final String FINDALLSQL = "SELECT ID, USER_NAME, USER_PASSWORD, REGISTER_DATE, EXPIRE_DATE, EMAIL, COMPANY, PHONE, LAST_PAY_DATE, SERVICE_PLAN_ID, QUESTION, ANSWER FROM USER_INFO";
	private static final String GETBYLOGINSQL = "SELECT ID, USER_NAME, USER_PASSWORD, EXPIRE_DATE, QUESTION, ANSWER FROM USER_INFO WHERE USER_NAME = ? AND USER_PASSWORD = ?";
	private static final String UPDATESQL = "UPDATE USER_INFO SET SERVICE_PLAN_ID = ? WHERE ID = ?";
	private static final String GETBYIDSQL = "SELECT ID, USER_NAME, USER_PASSWORD, REGISTER_DATE, EXPIRE_DATE, EMAIL, COMPANY, PHONE, LAST_PAY_DATE, SERVICE_PLAN_ID, QUESTION, ANSWER FROM USER_INFO WHERE ID = ?";
	private static final String GETBYNAMESQL = "SELECT ID, USER_NAME, USER_PASSWORD, REGISTER_DATE, EXPIRE_DATE, EMAIL, COMPANY, PHONE, LAST_PAY_DATE, SERVICE_PLAN_ID, QUESTION, ANSWER FROM USER_INFO WHERE USER_NAME = ?";
	private static final String UPDATEEXPIREDATESQL = "UPDATE USER_INFO SET EXPIRE_DATE = ? WHERE ID = ?";
	private static final String REGISTERSQL = "insert into USER_INFO(USER_NAME,USER_PASSWORD,REGISTER_DATE,EXPIRE_DATE,EMAIL,COMPANY,LAST_PAY_DATE,PHONE, QUESTION,ANSWER)values(?,?,?,?,?,?,?,?,?,?)";
	private static final String FINDBYUSERNAME = "select * from USER_INFO where USER_NAME = ?";
	private static final String FINDBYID = "select * from USER_INFO where ID = ?";
	private static final String UPDATEUSER = "update USER_INFO set EMAIL=?, COMPANY=?, PHONE=?,  QUESTION=?, ANSWER=? where USER_NAME=? ";
	private static final String UPDATEUSERBYPASS = "update USER_INFO set USER_PASSWORD=? where ID=? ";
	
	public static UserInfoDAOImpl getInstance() {
		return userInfoDAOImpl;
	}

	private ServicePlanDAO servicePlanDAO = ServicePlanDAOImpl.getInstance();

	private UserInfoDAOImpl() {
	}

	public List<UserInfo> findAll() throws SQLException {
		ResultSet result = DBConnUtil.getStatement(FINDALLSQL);
		UserInfo userInfo;
		List<UserInfo> list = new ArrayList<UserInfo>();
		while (result.next()) {
			userInfo = new UserInfo();
			userInfo.setId(result.getLong("ID"));
			userInfo.setUserName(result.getString("USER_NAME"));
			userInfo.setPassword(result.getString("USER_PASSWORD"));
			userInfo.setRegisterDate(result.getTimestamp("REGISTER_DATE"));
			userInfo.setExpireDate(result.getTimestamp("EXPIRE_DATE"));
			userInfo.setEmail(result.getString("EMAIL"));
			userInfo.setCompany(result.getString("COMPANY"));
			userInfo.setPhone(result.getString("PHONE"));
			userInfo.setLastPayDate(result.getTimestamp("LAST_PAY_DATE"));
			userInfo.setQuestion(result.getString("QUESTION"));
			userInfo.setAnswer(result.getString("ANSWER"));
			// ServicePlan servicePlan = new ServicePlan();
			userInfo.setServicePlanId(result.getLong("SERVICE_PLAN_ID"));
			userInfo.setServicePlans(servicePlanDAO.findAll());
			list.add(userInfo);
		}
		return list;
	}

	public List<UserInfo> findByCount(UserInfo userInfo1) throws SQLException {
		StringBuffer findByCountSql = new StringBuffer("SELECT ID, USER_NAME, USER_PASSWORD, REGISTER_DATE, EXPIRE_DATE, EMAIL, COMPANY, PHONE, LAST_PAY_DATE, SERVICE_PLAN_ID, QUESTION, ANSWER FROM USER_INFO WHERE 1=1");
		if(userInfo1 != null) {
			if(!StringUtils.isEmpty(userInfo1.getUserName())) {
				findByCountSql.append(" AND USER_NAME LIKE ?");
			}
			if (userInfo1.isCheckExpire()) {
				findByCountSql.append(" AND now() > EXPIRE_DATE");
			}
			findByCountSql.append(" ORDER BY ID DESC LIMIT ?, ?");
		}
		PreparedStatement stet = DBConnUtil.getPrepareStatement(findByCountSql
				.toString());
		if (!StringUtils.isEmpty(userInfo1.getUserName())) {
			stet.setString(1, "%" + userInfo1.getUserName() + "%");
			stet.setInt(2, userInfo1.getStartRow());
			stet.setInt(3, userInfo1.getPageSize());
		} else {
			stet.setInt(1, userInfo1.getStartRow());
			stet.setInt(2, userInfo1.getPageSize());
		}

		ResultSet result = stet.executeQuery();
		List<UserInfo> list = new ArrayList<UserInfo>();
		UserInfo userInfo;
		while (result.next()) {
			userInfo = new UserInfo();
			userInfo.setId(result.getLong("ID"));
			userInfo.setUserName(result.getString("USER_NAME"));
			userInfo.setRegisterDate(result.getTimestamp("REGISTER_DATE"));
			userInfo.setRegisterDateTmp(result.getTimestamp("REGISTER_DATE"));
			userInfo.setExpireDate(result.getTimestamp("EXPIRE_DATE"));
			userInfo.setExpireDateTmp(result.getTimestamp("EXPIRE_DATE"));
			userInfo.setEmail(result.getString("EMAIL"));
			userInfo.setCompany(result.getString("COMPANY"));
			userInfo.setPhone(result.getString("PHONE"));
			userInfo.setLastPayDate(result.getTimestamp("LAST_PAY_DATE"));
			userInfo.setQuestion(result.getString("QUESTION"));
			userInfo.setAnswer(result.getString("ANSWER"));
			userInfo.setServicePlanId(result.getLong("SERVICE_PLAN_ID"));
			userInfo.setServicePlans(servicePlanDAO.findAll());
			list.add(userInfo);
		}
		return list;
	}

	public int getRowCount(UserInfo userInfo) throws SQLException {
		StringBuffer sql = new StringBuffer("SELECT COUNT(*) FROM USER_INFO WHERE 1=1");
		if(userInfo != null) {
			if(!StringUtils.isEmpty(userInfo.getUserName())) {
				sql.append(" AND USER_NAME LIKE ?");
			}
			if (userInfo.isCheckExpire()) {
				sql.append(" AND now() > EXPIRE_DATE");
			}
		}
		PreparedStatement stet = DBConnUtil.getPrepareStatement(sql.toString());
		if (!StringUtils.isEmpty(userInfo.getUserName())) {
			stet.setString(1, "%" + userInfo.getUserName() + "%");
		}
		ResultSet result = stet.executeQuery();
		result.last();
		int results = result.getInt(result.getRow());
		return results;
	}

	public UserInfo getByLogin(UserInfo userInfo) throws SQLException {
		PreparedStatement stet = DBConnUtil.getPrepareStatement(GETBYLOGINSQL);
		stet.setString(1, userInfo.getUserName());
		stet.setString(2, userInfo.getPassword());
		ResultSet result = stet.executeQuery();
		while (result.next()) {
			userInfo.setExpireDate(result.getTimestamp("EXPIRE_DATE"));
			userInfo.setId(result.getLong("ID"));
			return userInfo;
		}
		return null;
	}

	public void save(UserInfo userInfo) {
		// TODO Auto-generated method stub

	}

	public boolean update(UserInfo userInfo) throws SQLException {
		PreparedStatement stet = DBConnUtil.getPrepareStatement(UPDATESQL);
		stet.setLong(1, userInfo.getServicePlanId());
		stet.setLong(2, userInfo.getId());
		int result = stet.executeUpdate();
		if (result > 0) {
			return true;
		}
		return false;
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	public UserInfo get(UserInfo userInfo) throws SQLException {
		PreparedStatement stet = DBConnUtil.getPrepareStatement(GETBYIDSQL);
		stet.setLong(1, userInfo.getId());
		ResultSet result = stet.executeQuery();
		UserInfo newUserInfo = new UserInfo();
		while (result.next()) {
			newUserInfo.setId(result.getLong("ID"));
			newUserInfo.setUserName(result.getString("USER_NAME"));
			newUserInfo.setPassword(result.getString("USER_PASSWORD"));
			newUserInfo.setRegisterDate(result.getTimestamp("REGISTER_DATE"));
			newUserInfo.setExpireDate(result.getTimestamp("EXPIRE_DATE"));
			newUserInfo.setEmail(result.getString("EMAIL"));
			newUserInfo.setCompany(result.getString("COMPANY"));
			newUserInfo.setPhone(result.getString("PHONE"));
			newUserInfo.setLastPayDate(result.getTimestamp("LAST_PAY_DATE"));
			newUserInfo.setQuestion(result.getString("QUESTION"));
			newUserInfo.setAnswer(result.getString("ANSWER"));
			// ServicePlan servicePlan = new ServicePlan();
			newUserInfo.setServicePlanId(result.getLong("SERVICE_PLAN_ID"));
			newUserInfo.setServicePlans(servicePlanDAO.findAll());
		}
		return newUserInfo;
	}
	
	public UserInfo getByName(UserInfo userInfo) throws SQLException {
		PreparedStatement stet = DBConnUtil.getPrepareStatement(GETBYNAMESQL);
		stet.setString(1, userInfo.getUserName());
		ResultSet result = stet.executeQuery();
		UserInfo newUserInfo = new UserInfo();
		while (result.next()) {
			newUserInfo.setId(result.getLong("ID"));
			newUserInfo.setUserName(result.getString("USER_NAME"));
			newUserInfo.setPassword(result.getString("USER_PASSWORD"));
			newUserInfo.setRegisterDate(result.getTimestamp("REGISTER_DATE"));
			newUserInfo.setExpireDate(result.getTimestamp("EXPIRE_DATE"));
			newUserInfo.setEmail(result.getString("EMAIL"));
			newUserInfo.setCompany(result.getString("COMPANY"));
			newUserInfo.setPhone(result.getString("PHONE"));
			newUserInfo.setLastPayDate(result.getTimestamp("LAST_PAY_DATE"));
			newUserInfo.setQuestion(result.getString("QUESTION"));
			newUserInfo.setAnswer(result.getString("ANSWER"));
			// ServicePlan servicePlan = new ServicePlan();
			newUserInfo.setServicePlanId(result.getLong("SERVICE_PLAN_ID"));
			newUserInfo.setServicePlans(servicePlanDAO.findAll());
		}
		return newUserInfo;
	}

	public boolean updatePassword(UserInfo userInfo) throws SQLException {
		String updatePasswordSql = "UPDATE USER_INFO SET USER_PASSWORD = MD5(?) WHERE ID = ?";
		PreparedStatement stet = DBConnUtil
				.getPrepareStatement(updatePasswordSql);
		stet.setString(1, userInfo.getPassword());
		stet.setLong(2, userInfo.getId());
		int result = stet.executeUpdate();
		if (result > 0) {
			return true;
		}
		return false;
	}
	
	public boolean initialPassword(UserInfo userInfo) throws SQLException {
		String updatePasswordSql = "UPDATE USER_INFO SET USER_PASSWORD = MD5(?) WHERE USER_NAME = ? AND ANSWER = ?";
		PreparedStatement stet = DBConnUtil
				.getPrepareStatement(updatePasswordSql);
		stet.setString(1, userInfo.getPassword());
		stet.setString(2, userInfo.getUserName());
		stet.setString(3, userInfo.getAnswer());
		int result = stet.executeUpdate();
		if (result > 0) {
			return true;
		}
		return false;
	}
	
	public boolean updateExpireDate(UserInfo userInfo) throws SQLException {
		PreparedStatement stet = DBConnUtil
				.getPrepareStatement(UPDATEEXPIREDATESQL);
		stet.setTimestamp(1, userInfo.getExpireDate());
		stet.setLong(2, userInfo.getId());
		int result = stet.executeUpdate();
		if (result > 0) {
			return true;
		}
		return false;
	}

	public void register(UserInfo userInfo) throws SQLException {
		PreparedStatement stet = DBConnUtil.getPrepareStatement(REGISTERSQL);
		stet.setString(1, userInfo.getUserName());
		stet.setString(2, userInfo.getPassword());
		stet.setTimestamp(3, userInfo.getRegisterDate());
		stet.setTimestamp(4, userInfo.getExpireDate());
		stet.setString(5, userInfo.getEmail());
		stet.setString(6, userInfo.getCompany());
		stet.setTimestamp(7, userInfo.getLastPayDate());
		stet.setString(8, userInfo.getPhone());
		stet.setString(9, userInfo.getQuestion());
		stet.setString(10, userInfo.getAnswer());
		stet.execute();
	}

	public Boolean checkUserName(String userName) throws SQLException {
		PreparedStatement stet = DBConnUtil.getPrepareStatement(FINDBYUSERNAME);
		stet.setString(1, userName);
		ResultSet result = stet.executeQuery();
		if (result.next()) {
			return false;
		}
		return true;
	}

	public UserInfo getUserInfo(Long userId) throws SQLException {
		PreparedStatement stet = DBConnUtil.getPrepareStatement(FINDBYID);
		stet.setLong(1, userId);
		ResultSet result = stet.executeQuery();
		result.next();
		UserInfo userInfo = new UserInfo();
		userInfo.setId(result.getLong("ID"));
		userInfo.setUserName(result.getString("USER_NAME"));
		userInfo.setPassword(result.getString("USER_PASSWORD"));
		userInfo.setRegisterDate(result.getTimestamp("REGISTER_DATE"));
		userInfo.setRegisterDateTmp(result.getTimestamp("REGISTER_DATE"));
		userInfo.setExpireDate(result.getTimestamp("EXPIRE_DATE"));
		userInfo.setExpireDateTmp(result.getTimestamp("EXPIRE_DATE"));
		userInfo.setEmail(result.getString("EMAIL"));
		userInfo.setCompany(result.getString("COMPANY"));
		userInfo.setPhone(result.getString("PHONE"));
		userInfo.setLastPayDate(result.getTimestamp("LAST_PAY_DATE"));
		userInfo.setQuestion(result.getString("QUESTION"));
		userInfo.setAnswer(result.getString("ANSWER"));
		userInfo.setServicePlanId(result.getLong("SERVICE_PLAN_ID"));
		return userInfo;

	}

	public void modifyUserInfo(UserInfo userInfo) throws SQLException {
		PreparedStatement stet = DBConnUtil.getPrepareStatement(UPDATEUSER);
		stet.setString(1, userInfo.getEmail());
		stet.setString(2, userInfo.getCompany());
		stet.setString(3, userInfo.getPhone());
		stet.setString(4, userInfo.getQuestion());
		stet.setString(5, userInfo.getAnswer());
		stet.setString(6, userInfo.getUserName());
		stet.executeUpdate();
	}

	public void changePassword(UserInfo userInfo, String newPassword) throws SQLException {
		PreparedStatement stet = DBConnUtil.getPrepareStatement(UPDATEUSERBYPASS);
		stet.setString(1, newPassword);
		stet.setLong(2, userInfo.getId());
		stet.executeUpdate();
	}

}