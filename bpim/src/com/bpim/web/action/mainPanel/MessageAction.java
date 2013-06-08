package com.bpim.web.action.mainPanel;

import java.sql.SQLException;
import java.util.List;

import com.bpim.common.Constants;
import com.bpim.entity.UserMessage;
import com.bpim.helper.PageTools;
import com.bpim.helper.ParamTools;
import com.bpim.service.MessageService;
import com.bpim.service.MessageServiceImpl;
import com.bpim.web.action.ActionSupportBase;

/**
 * author Delgado
 */
public class MessageAction extends ActionSupportBase{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3815436285076932635L;

	private PageTools page;
	
	private List<UserMessage> userMessages;
	private UserMessage userMessage;
	private MessageService service = new MessageServiceImpl();
	
	public String getAllMessage(){
		long userId = (Long) session.get(Constants.LOGIN_USER_ID);
		try {
			int pageNo = ParamTools.getIntParameter(request,
					Constants.PARA_PAGE_NO, 1);
			int pageSize = ParamTools.getIntParameter(request,
					Constants.PARA_PAGE_SIZE, 0);
			PageTools page = new PageTools(pageNo, pageSize);
			//userMessages = service.getAllMessageByUserId(userId);
			UserMessage userMessage = new UserMessage();
			userMessage.setReceiverId(userId);
			userMessage.setRowCount(pageNo);
			userMessage.setPageSize(pageSize);
			userMessages = service.listPage(userMessage, page);
			if (userMessages != null && userMessages.size() > 0) {
				this.page = page;
			} else {
				super.addNotFoundErrorMsg();
				return SUCCESS;
			}
			int newMessageCount = service.getNewMessageAcount(userId);
			session.put(Constants.NEW_MESSAGE_COUNT, newMessageCount);
		} catch (SQLException e) {
			LOG.error(e);
		} catch (Exception e) {
			LOG.error(e);
		}
		return SUCCESS;
	}
	
	public String viewMessageDetail(){
		Long id = Long.valueOf(request.getParameter("id"));
		try {
			userMessage = service.getMessageDetalById(id);
			int newMessageCount = service.getNewMessageAcount(id);
			session.put(Constants.NEW_MESSAGE_COUNT, newMessageCount);
		} catch (SQLException e) {
			LOG.error(e);
		}
		return SUCCESS;
	}
	

	/**
	 * @return the userMessages
	 */
	public List<UserMessage> getUserMessages() {
		return userMessages;
	}

	/**
	 * @param userMessages the userMessages to set
	 */
	public void setUserMessages(List<UserMessage> userMessages) {
		this.userMessages = userMessages;
	}
	public PageTools getPage() {
		return page;
	}
	public void setPage(PageTools page) {
		this.page = page;
	}

	/**
	 * @return the userMessage
	 */
	public UserMessage getUserMessage() {
		return userMessage;
	}

	/**
	 * @param userMessage the userMessage to set
	 */
	public void setUserMessage(UserMessage userMessage) {
		this.userMessage = userMessage;
	}
	
}

