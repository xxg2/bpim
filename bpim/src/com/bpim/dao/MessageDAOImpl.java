package com.bpim.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bpim.common.DBConnUtil;
import com.bpim.common.PropertyConstants;
import com.bpim.entity.UserMessage;

/**
 * author Delgado
 */
public class MessageDAOImpl implements MessageDAO {

	private static final String DELETEENTITY = "DELETE FROM USER_MESSAGE WHERE ID = ?";
	private static final String FINDALLBYID = "SELECT * FROM USER_MESSAGE WHERE ID = ?";
	private static final String UPDATEBYID = "UPDATE USER_MESSAGE SET READED = ? WHERE ID = ?";
	private static final String FINDCOUNT = "SELECT count(*) FROM USER_MESSAGE WHERE RECEIVER_ID = ?";
	private static final String FINDPAGEBYRECEIVERID = "SELECT * FROM USER_MESSAGE WHERE RECEIVER_ID = ? ORDER BY SEND_TIME DESC LIMIT ?, ?";
	
	public void sendSystemMessage() throws SQLException {
		Timestamp tenDaysRemind = new Timestamp(new Date().getTime()+86400000*10);
		Timestamp nineDaysRemind = new Timestamp(new Date().getTime()+86400000*9);
		Timestamp threeDaysRemind = new Timestamp(new Date().getTime()+86400000*3);
		Timestamp twoDaysRemind = new Timestamp(new Date().getTime()+86400000*2);
		String queryWeekRemindSql = "SELECT * FROM USER_INFO WHERE EXPIRE_DATE > ? AND EXPIRE_DATE < ?";
		String weekRemindSql = "INSERT INTO USER_MESSAGE(RECEIVER_ID, SENDER_ID, MESSAGE_CONTENT, READED, USER_INFO_ID,SENDER_NAME,SEND_TIME) VALUES(?,?,?,?,?,?,?)";
		String queryThreeDaysRemindSql = "SELECT * FROM USER_INFO WHERE EXPIRE_DATE > ? AND EXPIRE_DATE < ?";
		String threeDaysRemindSql = "INSERT INTO USER_MESSAGE(RECEIVER_ID, SENDER_ID, MESSAGE_CONTENT, READED, USER_INFO_ID,SENDER_NAME,SEND_TIME) VALUES(?,?,?,?,?,?,?)";
		PreparedStatement queryWeekRemind = DBConnUtil
		.getPrepareStatement(queryWeekRemindSql);
		queryWeekRemind.setTimestamp(1, nineDaysRemind);
		queryWeekRemind.setTimestamp(2, tenDaysRemind);
		ResultSet result1 = queryWeekRemind.executeQuery();
		PreparedStatement weekRemindStet = DBConnUtil
		.getPrepareStatement(weekRemindSql);
		while(result1.next()){
			Long id = result1.getLong("ID");
			weekRemindStet.setLong(1,id);
			weekRemindStet.setLong(2, 0);
			weekRemindStet.setString(3, PropertyConstants.ACCOUNTOVERTHINTENDAY);
			weekRemindStet.setBoolean(4, false);
			weekRemindStet.setLong(5, id);
			weekRemindStet.setString(6, PropertyConstants.MANAGER);
			weekRemindStet.setTimestamp(7, new Timestamp(new Date().getTime()));
			weekRemindStet.execute();
		}
		
		PreparedStatement queryThreeDaysRemind = DBConnUtil
		.getPrepareStatement(queryThreeDaysRemindSql);
		queryThreeDaysRemind.setTimestamp(1, twoDaysRemind);
		queryThreeDaysRemind.setTimestamp(2, threeDaysRemind);
		ResultSet result2 = queryThreeDaysRemind.executeQuery();
		PreparedStatement threeDaysRemindStet = DBConnUtil
		.getPrepareStatement(threeDaysRemindSql);
		while(result2.next()){
			Long id = result2.getLong("ID");
			threeDaysRemindStet.setLong(1,id);
			threeDaysRemindStet.setLong(2, 0);
			threeDaysRemindStet.setString(3, PropertyConstants.ACCOUNTOVERTHINTHREEDAY);
			threeDaysRemindStet.setBoolean(4, false);
			threeDaysRemindStet.setLong(5, id);
			threeDaysRemindStet.setString(6, PropertyConstants.MANAGER);
			threeDaysRemindStet.setTimestamp(7, new Timestamp(new Date().getTime()));
			threeDaysRemindStet.execute();
		}
	}

	public int getNewMessageAcount(Long userId) throws SQLException {
		String querySql = "SELECT count(*) FROM USER_MESSAGE WHERE READED = ? AND RECEIVER_ID = ?";
		PreparedStatement stat = DBConnUtil
		.getPrepareStatement(querySql);
		stat.setBoolean(1, false);
		stat.setLong(2, userId);
		ResultSet result = stat.executeQuery();
		result.last();
		int results = result.getInt(result.getRow());
		return results;
	}

	public List<UserMessage> getAllMessageByUserId(long userId) throws SQLException {
		String querySql = "SELECT * FROM USER_MESSAGE WHERE RECEIVER_ID = ? ORDER BY SEND_TIME DESC";
		PreparedStatement stat = DBConnUtil
		.getPrepareStatement(querySql);
		stat.setLong(1, userId);
		ResultSet result = stat.executeQuery();
		List<UserMessage> list = new ArrayList<UserMessage>();
		while (result.next()) {
			UserMessage userMessage = new UserMessage();
			userMessage.setId(result.getLong("ID"));
			userMessage.setMessageContent(result.getString("MESSAGE_CONTENT"));
			userMessage.setReceiverId(result.getLong("RECEIVER_ID"));
			userMessage.setSenderId(result.getLong("SENDER_ID"));
			userMessage.setReaded(result.getBoolean("READED"));
			userMessage.setSenderName(result.getString("SENDER_NAME"));
			userMessage.setSendTime(result.getTimestamp("SEND_TIME"));
			list.add(userMessage);
		}
		return list;
	}

	public void deleteMessage(Long id) throws SQLException {
		PreparedStatement stat = DBConnUtil.getPrepareStatement(DELETEENTITY);
		stat.setLong(1, id);
		stat.execute();
	}

	public UserMessage getMessageDetalById(Long id) throws SQLException {
		PreparedStatement stat = DBConnUtil.getPrepareStatement(FINDALLBYID);
		stat.setLong(1, id);
		ResultSet result = stat.executeQuery();
		UserMessage userMessage = new UserMessage();
		while (result.next()) {
			userMessage.setId(result.getLong("ID"));
			userMessage.setMessageContent(result.getString("MESSAGE_CONTENT"));
			userMessage.setReceiverId(result.getLong("RECEIVER_ID"));
			userMessage.setSenderId(result.getLong("SENDER_ID"));
			userMessage.setReaded(result.getBoolean("READED"));
			userMessage.setSenderName(result.getString("SENDER_NAME"));
			userMessage.setSendTime(result.getTimestamp("SEND_TIME"));
		}
		return userMessage;
	}

	public void updateMessageToReaded(Long id) throws SQLException {
		PreparedStatement stat = DBConnUtil
		.getPrepareStatement(UPDATEBYID);
		stat.setBoolean(1, true);
		stat.setLong(2, id);
		stat.executeUpdate();
	}

	public int getRowCount(UserMessage userMessage) throws SQLException {
		PreparedStatement stat = DBConnUtil.getPrepareStatement(FINDCOUNT);
		stat.setLong(1, userMessage.getReceiverId());
		ResultSet result = stat.executeQuery();
		result.last();
		int results = result.getInt(result.getRow());
		return results;
	}

	public List<UserMessage> findByCount(UserMessage userMessage1) throws SQLException {
		PreparedStatement stet = DBConnUtil.getPrepareStatement(FINDPAGEBYRECEIVERID);
		stet.setLong(1, userMessage1.getReceiverId());
		stet.setInt(2, userMessage1.getStartRow());
		stet.setInt(3, userMessage1.getPageSize());
		ResultSet result = stet.executeQuery();
		List<UserMessage> list = new ArrayList<UserMessage>();
		while (result.next()) {
			UserMessage userMessage = new UserMessage();
			userMessage.setId(result.getLong("ID"));
			userMessage.setMessageContent(result.getString("MESSAGE_CONTENT"));
			userMessage.setReceiverId(result.getLong("RECEIVER_ID"));
			userMessage.setSenderId(result.getLong("SENDER_ID"));
			userMessage.setReaded(result.getBoolean("READED"));
			userMessage.setSenderName(result.getString("SENDER_NAME"));
			userMessage.setSendTime(result.getTimestamp("SEND_TIME"));
			list.add(userMessage);
		}
		return list;
	}
}

