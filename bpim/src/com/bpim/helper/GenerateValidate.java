package com.bpim.helper;

import java.awt.image.BufferedImage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

public class GenerateValidate {
	private static Logger logger = Logger.getLogger(GenerateValidate.class);
	
	public GenerateValidate(HttpServletRequest request) {
		try {
			m_request = request;
			m_session = m_request.getSession(true);
			// m_request.setCharacterEncoding(APP_CONSTANT.ENCODING_TYPE); //
		} catch (Exception ex) {
			logger.error(ex);
		}
		m_strValidate = new String("");
	}

	public void genValidate() {
		GenerateCode objGenerateCode = new GenerateCode(4);
		m_strToken = objGenerateCode.getToken();
		m_strValidate = objGenerateCode.getCode();
		m_session.setAttribute(m_strToken, String.valueOf(m_strValidate));// 写入会话
	}

	public String getValidateValue() {
		return m_strValidate;
	}

	public String getValidateForm() {
		String str = new String();
		str = "<input type=\"hidden\" name=\"__token\" value=\"";
		str += m_strToken;
		str += "\">";
		str += "<input type=\"text\" name=\"__num\" size=\"10\">";
		return str;
	}

	/**
	 * 生成验证的图片
	 * 
	 * @param token
	 *            String 写入会话的session名称为 CheckValidate.checkImage()方法验证
	 */
	public void genValidateImage(String token) {
		GenerateCode objGenerateCode = new GenerateCode(4);
		m_strValidate = objGenerateCode.getCode();
		m_session.setAttribute(token, m_strValidate);// 写入会话
	}

	/**
	 * 取图片请用此方法
	 * 
	 * @return BufferedImage
	 */
	public BufferedImage getValidateImage() {
		GenerateImage objImage = new GenerateImage();
		return objImage.creatImage(m_strValidate);// 生成图片,2004-10-15
	}

	private HttpServletRequest m_request = null;

	private HttpSession m_session = null;

	private String m_strValidate;

	private String m_strToken;

}
