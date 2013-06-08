package com.bpim.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bpim.common.DBConnUtil;
import com.bpim.entity.ServicePlan;

public class ServicePlanDAOImpl implements ServicePlanDAO {
	
	private static ServicePlanDAOImpl servicePlanDAOImpl = new ServicePlanDAOImpl();
	
	private static final String FINDALLSQL = "SELECT ID, SERVICE_NAME, MONEY, PAY_DATE, REMARK FROM SERVICE_PLAN";
	private static final String UPDATESQL = "UPDATE SERVICE_PLAN SET SERVICE_NAME = ?, MONEY = ?, PAY_DATE = ?, REMARK = ? WHERE ID = ?";
	private static final String INSERTSQL = "INSERT INTO SERVICE_PLAN(SERVICE_NAME, MONEY, PAY_DATE, REMARK) VALUES(?, ?, ?, ?)";
	private static final String DELETESQL = "DELETE FROM SERVICE_PLAN WHERE ID = ?";
	private static final String GETSQL = "SELECT ID, SERVICE_NAME, MONEY, PAY_DATE, REMARK FROM SERVICE_PLAN WHERE ID = ?";
	
	private ServicePlanDAOImpl() {}
	
	public static ServicePlanDAOImpl getInstance() {
		return servicePlanDAOImpl;
	}
	
	public List<ServicePlan> findAll() throws SQLException {
		ResultSet result = DBConnUtil.getStatement(FINDALLSQL);
		ServicePlan servicePlan;
		List<ServicePlan> list = new ArrayList<ServicePlan>();
		while(result.next()) {
			servicePlan = new ServicePlan();
			servicePlan.setId(result.getLong("ID"));
			servicePlan.setServiceName(result.getString("SERVICE_NAME"));
			servicePlan.setMoney(result.getFloat("MONEY"));
			servicePlan.setPayDate(result.getInt("PAY_DATE"));
			servicePlan.setRemark(result.getString("REMARK"));
			list.add(servicePlan);
		}
		return list;
	}
	
	public static void main(String[] args) {
		ServicePlan servicePlan = new ServicePlan();
		servicePlan.setId(1l);
		ServicePlanDAOImpl dao = ServicePlanDAOImpl.getInstance();
		try {
			dao.delete(servicePlan);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean update(ServicePlan servicePlan) throws SQLException {
		PreparedStatement stet = DBConnUtil.getPrepareStatement(UPDATESQL);
		stet.setString(1, servicePlan.getServiceName());
		stet.setFloat(2, servicePlan.getMoney());
		stet.setInt(3, servicePlan.getPayDate());
		stet.setString(4, servicePlan.getRemark());
		stet.setLong(5, servicePlan.getId());
		int result = stet.executeUpdate();
		if(result>0) {
			return true;
		}
		return false;
	}

	public boolean insert(ServicePlan servicePlan) throws SQLException {
		PreparedStatement stet = DBConnUtil.getPrepareStatement(INSERTSQL);
		stet.setString(1, servicePlan.getServiceName());
		stet.setFloat(2, servicePlan.getMoney());
		stet.setInt(3, servicePlan.getPayDate());
		stet.setString(4, servicePlan.getRemark());
		boolean flag = stet.execute();
		return flag;
	}

	public boolean delete(ServicePlan servicePlan) throws SQLException {
		PreparedStatement stet = DBConnUtil.getPrepareStatement(DELETESQL);
		stet.setLong(1, servicePlan.getId());
		boolean flag = stet.execute();
		return flag;
	}
	
	

	public ServicePlan get(ServicePlan servicePlan) throws SQLException {
		PreparedStatement stet = DBConnUtil.getPrepareStatement(GETSQL);
		stet.setLong(1, servicePlan.getId());
		ResultSet result = stet.executeQuery();
		ServicePlan servicePlan1 = new ServicePlan();
		if(result.next()) {
			servicePlan1.setId(result.getLong("ID"));
			servicePlan1.setServiceName(result.getString("SERVICE_NAME"));
			servicePlan1.setMoney(result.getFloat("MONEY"));
			servicePlan1.setPayDate(result.getInt("PAY_DATE"));
			servicePlan1.setRemark(result.getString("REMARK"));
		}
		return servicePlan1;
	}
}
