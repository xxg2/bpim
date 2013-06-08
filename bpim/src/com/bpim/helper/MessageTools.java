package com.bpim.helper;

import java.sql.SQLException;
import java.util.TimerTask;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bpim.service.MessageService;
import com.bpim.service.MessageServiceImpl;

/**
 * author Delgado
 */
public class MessageTools extends TimerTask {
	  private static final Log LOG = LogFactory.getLog(MessageTools.class);
	  public void run() {
	     MessageService service = new MessageServiceImpl();
	     try {
			service.sendSystemMessage();
		} catch (SQLException e) {
			LOG.error(e);
		}
	  }
}
