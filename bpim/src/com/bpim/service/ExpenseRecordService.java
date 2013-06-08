package com.bpim.service;

import java.util.List;

import com.bpim.entity.ExpenseRecord;
import com.bpim.entity.UserInfo;
import com.bpim.helper.PageTools;

public interface ExpenseRecordService {
	List<ExpenseRecord> findAll() throws Exception;
	
	List<ExpenseRecord> listPage(ExpenseRecord expenseRecord, PageTools page) throws Exception;
	
	boolean insertRepenseRecord(UserInfo userInfo) throws Exception;
}
