/**
 * 
 */
package com.ryxx.bean;

import java.util.List;

/**
 * @author Delgado Ding
 *
 */
public class Domain {

	private String domainName;
	private String displayName;
	private List<String> mainAdresses;
	
	
	
	/**
	 * @return the displayName
	 */
	public String getDisplayName() {
		return displayName;
	}
	/**
	 * @param displayName the displayName to set
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	/**
	 * @return the domainName
	 */
	public String getDomainName() {
		return domainName;
	}
	/**
	 * @param domainName the domainName to set
	 */
	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}
	/**
	 * @return the mainAdresses
	 */
	public List<String> getMainAdresses() {
		return mainAdresses;
	}
	/**
	 * @param mainAdresses the mainAdresses to set
	 */
	public void setMainAdresses(List<String> mainAdresses) {
		this.mainAdresses = mainAdresses;
	}
	
	
}
