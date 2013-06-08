package com.bpim.service;

import java.sql.SQLException;
import java.util.List;

import com.bpim.entity.UserMessage;
import com.bpim.helper.PageTools;

/**
 * author Delgado
 */
public interface MessageService {
	void sendSystemMessage() throws SQLException;
	int getNewMessageAcount(Long userId) throws SQLException;
	List<UserMessage> getAllMessageByUserId(long userId) throws SQLException;
	UserMessage getMessageDetalById(Long id) throws SQLException;
	List<UserMessage> listPage(UserMessage userMessage, PageTools page) throws Exception;
}

