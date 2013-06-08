package com.bpim.service;

import java.sql.SQLException;
import java.util.List;

import com.bpim.common.DBConnUtil;
import com.bpim.common.PropertyConstants;
import com.bpim.dao.MessageDAO;
import com.bpim.dao.MessageDAOImpl;
import com.bpim.entity.UserMessage;
import com.bpim.helper.PageTools;

/**
 * author Delgado
 */
public class MessageServiceImpl implements MessageService {
	MessageDAO dao = new MessageDAOImpl();

	public void sendSystemMessage() throws SQLException {
		DBConnUtil.getConnection();
		DBConnUtil.startTransaction(true);
		dao.sendSystemMessage();
		DBConnUtil.close();
	}

	public int getNewMessageAcount(Long userId) throws SQLException {
		DBConnUtil.getConnection();
		int count = dao.getNewMessageAcount(userId);
		DBConnUtil.close();
		return count;
	}

	public List<UserMessage> getAllMessageByUserId(long userId)
			throws SQLException {
		DBConnUtil.getConnection();
		List<UserMessage> list = dao.getAllMessageByUserId(userId);
		DBConnUtil.close();
		return list;
	}

	public String deleteMessage(Long id) throws SQLException {
		String msg = PropertyConstants.DELETESUCCESS;
		DBConnUtil.getConnection();
		DBConnUtil.startTransaction(true);
		dao.deleteMessage(id);
		DBConnUtil.close();
		return msg;
	}

	public String deleteMessages(String[] ids) throws SQLException {
		String msg = "删除成功";
		DBConnUtil.getConnection();
		DBConnUtil.startTransaction(true);
		for (int i = 0; i < ids.length; i++) {
			dao.deleteMessage(Long.valueOf(ids[i]));
		}
		DBConnUtil.close();
		return msg;
	}

	public UserMessage getMessageDetalById(Long id) throws SQLException {
		DBConnUtil.getConnection();
		DBConnUtil.startTransaction(true);
		UserMessage userMessage = dao.getMessageDetalById(id);
		dao.updateMessageToReaded(id);
		DBConnUtil.close();
		return userMessage;
	}

	public List<UserMessage> listPage(UserMessage userMessage, PageTools page)
			throws Exception {
		DBConnUtil.getConnection();
		if (page != null) {
			if (page.getRecordCount() == 0) {
				int count = dao.getRowCount(userMessage);
				page.setRecordCount(count);
			}
			userMessage.setStartRow(page.getPageStartRow());
			userMessage.setPageSize(page.getPageSize());
		}
		List<UserMessage> userInfos = dao.findByCount(userMessage);
		DBConnUtil.close();
		return userInfos;
	}
}
