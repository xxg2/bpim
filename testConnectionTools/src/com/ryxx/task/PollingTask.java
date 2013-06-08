/**
 * 
 */
package com.ryxx.task;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.commons.mail.EmailException;
import org.apache.log4j.Logger;

import com.ryxx.bean.Domain;
import com.ryxx.bean.ParamBean;
import com.ryxx.constants.AllConstants;
import com.ryxx.tools.Config;
import com.ryxx.tools.EmailTools;
import com.ryxx.tools.HttpTestConnection;

/**
 * @author Delgado Ding
 * 
 */
public class PollingTask {

	private static Logger logger = Logger.getLogger(PollingTask.class);
	private static Timer timer = new Timer();
	private HttpTestConnection connection = new HttpTestConnection();
	private EmailTools emailTools = new EmailTools();

	/**
	 * 
	 */
	public void startPolling() {
		int startDelay = Integer.valueOf(Config.config
				.getString(AllConstants.TIME_START_DELAY));
		int intervalDelay = Integer.valueOf(Config.config
				.getString(AllConstants.TIME_INTERVAL_DELAY));
		final List<Domain> domainList = getDomainsFromProperties();
		final List<ParamBean> params = new ArrayList<ParamBean>();
		final String title = Config.config
				.getString(AllConstants.MAIL_TITLE);
		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				if (domainList != null && domainList.size() > 0) {
					for (Domain domain : domainList) {
						try {
							logger.info("start connect to:"
									+ domain.getDomainName());
							connection.getResult(domain.getDomainName(), params);
						} catch (Exception e) {
							logger.error(e);
							if (domain.getMainAdresses() != null
									&& domain.getMainAdresses().size() > 0) {
								List<String> emailAddresses = getAddresses(domain);
								try {
									emailTools
											.send(emailAddresses,
													title,
													domain.getDisplayName()
															+ AllConstants.MAIL_CONTENT2
															+ e);
								} catch (EmailException e1) {
									logger.error(e1);
									logger.error("发送邮件失败");
								}
							}
						}
					}
				}
			}
		}, startDelay, intervalDelay);
	}

	private List<String> getAddresses(Domain domain) {
		List<String> addresses = new ArrayList<String>();
		for (String address : domain.getMainAdresses()) {
			addresses.add(address);
		}
		return addresses;
	}

	/**
	 * @return
	 */
	private List<Domain> getDomainsFromProperties() {
		String domainList = Config.config
				.getString(AllConstants.DOMAIN_LIST);
		String[] domainsArray = domainList.split(";");
		String[] mailArray;
		String domainName;
		String displayName;
		String mailAdresses;
		List<String> mailList;
		List<Domain> returnList = new ArrayList<Domain>();

		if (domainsArray != null && domainsArray.length > 0) {
			for (int i = 0; i < domainsArray.length; i++) {
				domainName = domainsArray[i];
				displayName = domainName.substring(domainName.indexOf("("),
						domainName.length());
				domainName = domainName.substring(0, domainName.indexOf("("));
				mailAdresses = Config.config.getString(domainName);
				Domain domain = new Domain();
				domain.setDomainName("http://" + domainName);
				domain.setDisplayName(displayName);
				mailList = new ArrayList<String>();
				mailArray = mailAdresses.split(";");
				if (mailArray != null && mailArray.length > 0) {
					for (int j = 0; j < mailArray.length; j++) {
						mailList.add(mailArray[j].replace(";", ""));
					}
					domain.setMainAdresses(mailList);
				}
				if (domain.getDomainName() != null
						&& !"".equals(domain.getDomainName())
						&& domain.getMainAdresses() != null
						&& domain.getMainAdresses().size() > 0) {
					returnList.add(domain);
				}
			}
		}
		return returnList;
	}

}
