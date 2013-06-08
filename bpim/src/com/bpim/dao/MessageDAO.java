package com.bpim.dao;

import java.sql.SQLException;
import java.util.List;

import com.bpim.entity.UserInfo;
import com.bpim.entity.UserMessage;

/**
 * author Delgado
 */
public interface MessageDAO {

	void sendSystemMessage() throws SQLException;

	int getNewMessageAcount(Long userId) throws SQLException;

	List<UserMessage> getAllMessageByUserId(long userId) throws SQLException;

	void deleteMessage(Long id) throws SQLException;

	UserMessage getMessageDetalById(Long id) throws SQLException;

	void updateMessageToReaded(Long id) throws SQLException;

	int getRowCount(UserMessage userMessage) throws SQLException;
	
	List<UserMessage> findByCount(UserMessage userMessage) throws SQLException;
}

