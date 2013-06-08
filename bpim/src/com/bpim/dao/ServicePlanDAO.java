package com.bpim.dao;

import java.sql.SQLException;
import java.util.List;

import com.bpim.entity.ServicePlan;

public interface ServicePlanDAO {
	List<ServicePlan> findAll() throws SQLException;
	boolean update(ServicePlan servicePlan) throws SQLException;
	boolean insert(ServicePlan servicePlan) throws SQLException;
	boolean delete(ServicePlan servicePlan) throws SQLException;
	ServicePlan get(ServicePlan servicePlan) throws SQLException;
}
