package com.bpim.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.bpim.common.Constants;
import com.bpim.common.DBConnUtil;
import com.bpim.entity.ExpenseRecord;
import com.bpim.entity.UserInfo;

public class ExpenseRecordDAOImpl implements ExpenseRecordDAO {

	private static ExpenseRecordDAOImpl expenseRecordDAOImpl = new ExpenseRecordDAOImpl();

	private static final String FINDALLSQL = "SELECT ID, USER_INFO_ID, MONEY, PAY_DATE, EXPIRE_DATE FROM EXPENSE_RECORD";
	private static final String REGISTERSQL = "INSERT INTO EXPENSE_RECORD (USER_INFO_ID, MONEY, PAY_DATE, EXPIRE_DATE)values(?,?,now(),?)";
	
	private UserInfoDAO userInfoDAO = UserInfoDAOImpl.getInstance();

	public static ExpenseRecordDAOImpl getInstance() {
		return expenseRecordDAOImpl;
	}

	private ExpenseRecordDAOImpl() {
	}

	public List<ExpenseRecord> findAll() throws SQLException {
		ResultSet result = DBConnUtil.getStatement(FINDALLSQL);
		ExpenseRecord expenseRecord;
		List<ExpenseRecord> list = new ArrayList<ExpenseRecord>();
		while (result.next()) {
			expenseRecord = new ExpenseRecord();
			expenseRecord.setId(result.getLong("ID"));
			expenseRecord.setUserId(result.getLong("USER_INFO_ID"));
			expenseRecord.setMoney(result.getFloat("MONEY"));
			expenseRecord.setPayDate(result.getTimestamp("PAY_DATE"));
			expenseRecord.setExpireDate(result.getTimestamp("EXPIRE_DATE"));
			expenseRecord.setPayDateTmp(result.getTimestamp("PAY_DATE"));
			expenseRecord.setExpireDateTmp(result.getTimestamp("EXPIRE_DATE"));
			UserInfo userInfo = new UserInfo();
			userInfo.setId(expenseRecord.getUserId());
			expenseRecord.setUserInfo(userInfoDAO.get(userInfo));
			list.add(expenseRecord);
		}
		return list;
	}

	public Timestamp save(ExpenseRecord expenseRecord) throws SQLException {
		PreparedStatement stet = DBConnUtil.getPrepareStatement(REGISTERSQL);
		stet.setLong(1, expenseRecord.getUserId());
		stet.setFloat(2, expenseRecord.getDevice().getMoney());
		Timestamp date;
		try {
			date = parse(expenseRecord.getExpireDate(), expenseRecord.getDevice().getPayDate());
		} catch (Exception e) {
			return null;
		}
		stet.setTimestamp(3, date);
		int result = stet.executeUpdate();
		if(result>0) {
			return date;
		}
		return null;
	}

	private Timestamp parse(Timestamp date, int addDay) throws Exception {
		SimpleDateFormat format = new SimpleDateFormat(Constants.DATEFORMAT);
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(date.getTime());
		c.add(Calendar.DATE, addDay);
		return Timestamp.valueOf(format.format(c.getTime()));
	}

	public boolean update(ExpenseRecord expenseRecord) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	public List<ExpenseRecord> findByCount(ExpenseRecord expenseRecord)
			throws SQLException {
		StringBuffer findByCountSql = new StringBuffer(
				"SELECT ID, USER_INFO_ID, MONEY, PAY_DATE, EXPIRE_DATE FROM EXPENSE_RECORD WHERE 1=1");
		if (expenseRecord != null
				&& !StringUtils.isEmpty(expenseRecord.getSelection())) {
			if ("1".equals(expenseRecord.getSelection())) {
				findByCountSql
						.append(" AND DATE_SUB(CURDATE(), INTERVAL 7 DAY) <= DATE(PAY_DATE)");
			} else if ("2".equals(expenseRecord.getSelection())) {
				findByCountSql
						.append(" AND DATE_SUB(CURDATE(), INTERVAL 1 MONTH) <= DATE(PAY_DATE)");
			}
		}
		findByCountSql.append(" ORDER BY PAY_DATE DESC LIMIT ?, ?");
		PreparedStatement stet = DBConnUtil.getPrepareStatement(findByCountSql
				.toString());
		stet.setInt(1, expenseRecord.getStartRow());
		stet.setInt(2, expenseRecord.getPageSize());
		ResultSet result = stet.executeQuery();
		List<ExpenseRecord> list = new ArrayList<ExpenseRecord>();
		ExpenseRecord expenseRecord1;
		while (result.next()) {
			expenseRecord1 = new ExpenseRecord();
			expenseRecord1.setId(result.getLong("ID"));
			expenseRecord1.setUserId(result.getLong("USER_INFO_ID"));
			expenseRecord1.setMoney(result.getFloat("MONEY"));
			expenseRecord1.setPayDate(result.getTimestamp("PAY_DATE"));
			expenseRecord1.setExpireDate(result.getTimestamp("EXPIRE_DATE"));
			expenseRecord1.setPayDateTmp(result.getTimestamp("PAY_DATE"));
			expenseRecord1.setExpireDateTmp(result.getTimestamp("EXPIRE_DATE"));
			expenseRecord1.setSelection(expenseRecord.getSelection());
			UserInfo userInfo = new UserInfo();
			userInfo.setId(expenseRecord1.getUserId());
			expenseRecord1.setUserInfo(userInfoDAO.get(userInfo));
			list.add(expenseRecord1);
		}
		return list;
	}

	public int getRowCount(ExpenseRecord expenseRecord) throws SQLException {
		StringBuffer sql = new StringBuffer(
				"SELECT COUNT(*) FROM EXPENSE_RECORD WHERE 1=1");
		if (expenseRecord != null
				&& !StringUtils.isEmpty(expenseRecord.getSelection())) {
			if ("1".equals(expenseRecord.getSelection())) {
				sql.append(" AND DATE_SUB(CURDATE(), INTERVAL 7 DAY) <= DATE(PAY_DATE)");
			} else if ("2".equals(expenseRecord.getSelection())) {
				sql.append(" AND DATE_SUB(CURDATE(), INTERVAL 1 MONTH) <= DATE(PAY_DATE)");
			}
			sql.append(" ORDER BY PAY_DATE DESC");
		}
		PreparedStatement stet = DBConnUtil.getPrepareStatement(sql.toString());
		ResultSet result = stet.executeQuery();
		result.last();
		int results = result.getInt(result.getRow());
		return results;
	}
}
