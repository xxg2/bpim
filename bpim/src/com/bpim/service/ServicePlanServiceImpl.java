package com.bpim.service;

import java.sql.SQLException;
import java.util.List;

import com.bpim.common.DBConnUtil;
import com.bpim.dao.ServicePlanDAO;
import com.bpim.dao.ServicePlanDAOImpl;
import com.bpim.entity.ServicePlan;

public class ServicePlanServiceImpl implements ServicePlanService {
	private ServicePlanDAO servicePlanDAO = ServicePlanDAOImpl.getInstance();
	public List<ServicePlan> findAll() throws SQLException {
		DBConnUtil.getConnection();
		List<ServicePlan> userInfos = servicePlanDAO.findAll();
		DBConnUtil.close();
		return userInfos;
	}

	public boolean update(ServicePlan servicePlan) throws SQLException {
		DBConnUtil.getConnection();
		DBConnUtil.startTransaction(true);
		boolean isUpdated = servicePlanDAO.update(servicePlan);
		DBConnUtil.close();
		return isUpdated;
	}

	public boolean insert(ServicePlan servicePlan) throws SQLException {
		DBConnUtil.getConnection();
		DBConnUtil.startTransaction(true);
		boolean isInserted = servicePlanDAO.insert(servicePlan);
		DBConnUtil.close();
		return !isInserted;
	}
	
	public boolean deleteData(ServicePlan servicePlan) throws SQLException {
		DBConnUtil.getConnection();
		DBConnUtil.startTransaction(true);
		boolean isInserted = servicePlanDAO.delete(servicePlan);
		DBConnUtil.close();
		return !isInserted;
	}

	public ServicePlan get(ServicePlan servicePlan) throws SQLException {
		DBConnUtil.getConnection();
		ServicePlan servicePlan1 = servicePlanDAO.get(servicePlan);
		DBConnUtil.close();
		return servicePlan1;
	}
}
