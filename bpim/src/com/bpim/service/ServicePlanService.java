package com.bpim.service;

import java.sql.SQLException;
import java.util.List;

import com.bpim.entity.ServicePlan;

public interface ServicePlanService {
	List<ServicePlan> findAll() throws SQLException;
	boolean update(ServicePlan servicePlan) throws SQLException;
	boolean insert(ServicePlan servicePlan) throws SQLException;
	boolean deleteData(ServicePlan servicePlan) throws SQLException;
	ServicePlan get(ServicePlan servicePlan) throws SQLException;
}