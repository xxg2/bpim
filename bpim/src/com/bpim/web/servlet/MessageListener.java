package com.bpim.web.servlet;

import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.bpim.helper.MessageTools;

/**
 * author Delgado
 */
public class MessageListener implements ServletContextListener {
	private Timer timer = null;

	  public void contextInitialized(ServletContextEvent event) {
	    timer = new Timer(true);
	    //设置任务计划，启动和间隔时间
	    timer.schedule(new MessageTools(), 0, 86400000);
	  }

	  public void contextDestroyed(ServletContextEvent event) {
	    timer.cancel();
	  }
	  
}

