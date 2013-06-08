package com.bpim.helper;

/**
 * <p>Title: DB Family</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Huasheng, Hangzhou</p>
 * @author Weijia.Sun
 * @version 0.9
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

// import com.huasheng.app.APP_CONSTANT;

public class CheckValidate {
	public CheckValidate(HttpServletRequest request) {
		try {
			m_request = request;
			m_session = m_request.getSession(true);
			// m_request.setCharacterEncoding(APP_CONSTANT.ENCODING_TYPE); //
		} catch (Exception ex) {
		}
		m_iValidate = 0;
	}

	public int check() {
		// Get the token, if it exists
		String stoken = m_request.getParameter("__token");
		String stored_value = null;
		String value = m_request.getParameter("__num");
		// Remove stored token from session
		synchronized (this) {
			stored_value = (String) m_session.getAttribute(stoken);

			// Remove token from session
			// so others can't use it,
			// then get the number posted by the user
			if (stored_value != null) {
				m_session.removeAttribute(stoken);
			}
		}

		// If the token is not there,
		// it has already been "consumed"
		if (stored_value == null) {
			return 2; // you can't use that form more than once
		} else {
			if (stored_value.equals(value)) {
				return 0; // "You copied the number correctly
			} else {
				return 1; // That wasn't the original number
			}
		}
	}

	/**
	 * 
	 * @param stoken
	 *            session name
	 * @return 0,2
	 */
	public int checkImage(String stoken) {
		// Get the token, if it exists
		String stored_value = null;
		String value = m_request.getParameter("__num");//
		// Remove stored token from session
		synchronized (this) {
			stored_value = (String) m_session.getAttribute(stoken);

			// Remove token from session
			// so others can't use it,
			// then get the number posted by the user
			if (stored_value != null) {
				m_session.removeAttribute(stoken);
			}
		}

		// If the token is not there,
		// it has already been "consumed"
		if (stored_value == null) {
			return 2; // you can't use that form more than once
		} else {
			if (stored_value.equals(value)) {
				return 0; // "You copied the number correctly
			} else {
				return 1; // That wasn't the original number
			}
		}
	}

	private HttpServletRequest m_request = null;

	private HttpSession m_session = null;

	private int m_iValidate;

	private int m_iToken;

}
