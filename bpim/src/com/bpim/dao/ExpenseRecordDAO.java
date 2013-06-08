package com.bpim.dao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import com.bpim.entity.ExpenseRecord;
import com.bpim.entity.UserInfo;

public interface ExpenseRecordDAO {
	List<ExpenseRecord> findAll() throws SQLException;
	
	Timestamp save(ExpenseRecord expenseRecord) throws SQLException;
	
	boolean update(ExpenseRecord expenseRecord) throws SQLException;
	
	List<ExpenseRecord> findByCount(ExpenseRecord expenseRecord) throws SQLException;
	
	int getRowCount(ExpenseRecord expenseRecord) throws SQLException;
}
