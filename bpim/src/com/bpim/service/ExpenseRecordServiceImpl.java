package com.bpim.service;

import java.sql.Timestamp;
import java.util.List;

import com.bpim.common.DBConnUtil;
import com.bpim.dao.ExpenseRecordDAO;
import com.bpim.dao.ExpenseRecordDAOImpl;
import com.bpim.dao.ServicePlanDAO;
import com.bpim.dao.ServicePlanDAOImpl;
import com.bpim.dao.UserInfoDAO;
import com.bpim.dao.UserInfoDAOImpl;
import com.bpim.entity.ExpenseRecord;
import com.bpim.entity.ServicePlan;
import com.bpim.entity.UserInfo;
import com.bpim.helper.PageTools;

public class ExpenseRecordServiceImpl implements ExpenseRecordService {
	
	private ExpenseRecordDAO expenseRecordDAO = ExpenseRecordDAOImpl.getInstance();
	private ServicePlanDAO servicePlanDAO = ServicePlanDAOImpl.getInstance();
	private UserInfoDAO userInfoDAO = UserInfoDAOImpl.getInstance();

	public List<ExpenseRecord> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ExpenseRecord> listPage(ExpenseRecord expenseRecord, PageTools page)
			throws Exception {
		DBConnUtil.getConnection();
		if (page != null) {
			if (page.getRecordCount() == 0) {
				int count = expenseRecordDAO.getRowCount(expenseRecord);
				page.setRecordCount(count);
			}
			expenseRecord.setStartRow(page.getPageStartRow());
			expenseRecord.setPageSize(page.getPageSize());
		}
		List<ExpenseRecord> expenseRecords = expenseRecordDAO.findByCount(expenseRecord);
		DBConnUtil.close();
		return expenseRecords;
	}

	public boolean insertRepenseRecord(UserInfo userInfo) throws Exception {
		DBConnUtil.getConnection();
		UserInfo info = userInfoDAO.get(userInfo);
		ExpenseRecord expenseRecord = new ExpenseRecord();
		expenseRecord.setUserId(userInfo.getId());
		expenseRecord.setExpireDate(info.getExpireDate());
		ServicePlan servicePlan = new ServicePlan();
		servicePlan.setId(userInfo.getServicePlanId());
		servicePlan = servicePlanDAO.get(servicePlan);
		if(servicePlan == null) {
			DBConnUtil.close();
			return false;
		} else {
			DBConnUtil.startTransaction(false);
			expenseRecord.setDevice(servicePlan);
			Timestamp date = expenseRecordDAO.save(expenseRecord);
			boolean flag = false;
			if(date != null) {
				UserInfo newUserInfo = new UserInfo();
				newUserInfo.setId(userInfo.getId());
				newUserInfo.setExpireDate(date);
				flag = userInfoDAO.updateExpireDate(newUserInfo);
			}
			DBConnUtil.endTransaction();
			DBConnUtil.close();
			return flag;
		}
	}
}
