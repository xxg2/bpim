package com.ryxx.tools;

import java.util.List;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.apache.log4j.Logger;

import com.ryxx.constants.AllConstants;

public class EmailTools {
	private static Logger logger = Logger.getLogger(EmailTools.class);

	public static void send(List<String> emailAddress, String title,
			String content) throws EmailException {
		SimpleEmail email = new SimpleEmail();
		email.setTLS(true);
		email.setHostName(AllConstants.SMTP);
		email.setAuthentication(AllConstants.MAIL_USER_NAME,
				AllConstants.MAIL_PASSWORD);
		try {
			for (String address : emailAddress) {
				email.addTo(address);
			}
			email.setFrom(AllConstants.MAIL_DISPLAY_NAME); 
			email.setSubject(title); 
			email.setCharset(AllConstants.MAIL_CHAR_SET); 
			email.setContent(content, "text/html");
			email.send();
		} catch (EmailException e) {
			logger.error(e);
			String emailAddresses = "";
			for (String address : emailAddress) {
				emailAddresses = emailAddresses + " " + address;
			}
			throw new EmailException(
					"send email fail, please send it by manual. The email address is "
							+ emailAddresses + "/n" + "email subject is "
							+ title + "/n" + "content is " + content + "/n");
		}
	}

	
}
