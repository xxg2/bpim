/**
 * Created on 2007-8-15 下午05:33:32
 * Title: LogoutAction.java <br/>
 * Description: <br/>
 * Copyright: Copyright (c) 2007 <br/>
 * @author Zongming.Zhong
 * @version Revision: 1.0 
 */
package com.bpim.web.action;

import com.bpim.common.Constants;

/**
 * @author Zongming.Zhong
 * 
 */
public class LogoutAction extends ActionSupportBase {

	private static final long serialVersionUID = -1781372665512868821L;


	public String execute() throws Exception {
		session.remove(Constants.LOGIN_USER_NAME);
		session.remove(Constants.LOGIN_USER_ID);
		session.remove(Constants.LOGIN_EXPIRE_DATE);
		return SUCCESS;
	}
}
