package com.bpim.entity;

import java.sql.Timestamp;
import java.util.List;

public class UserInfo extends VoBase {
	private static final long serialVersionUID = -5736014916018823802L;
	private Long id;
	private String userName;
	private String password;
	private Timestamp registerDate;
	private Timestamp expireDate;
	private Timestamp registerDateTmp;
	private Timestamp expireDateTmp;
	private String email;
	private String company;
	private String phone;
	private Timestamp lastPayDate;
	private Long servicePlanId;
	private String pcMac;
	private String mobileIdentify;
	
	public Long getServicePlanId() {
		return servicePlanId;
	}
	public void setServicePlanId(Long servicePlanId) {
		this.servicePlanId = servicePlanId;
	}
	private String question;
	private String answer;
	
	private boolean checkExpire;
	private List<ServicePlan> servicePlans;
	
	public List<ServicePlan> getServicePlans() {
		return servicePlans;
	}
	public void setServicePlans(List<ServicePlan> servicePlans) {
		this.servicePlans = servicePlans;
	}
	public boolean isCheckExpire() {
		return checkExpire;
	}
	public void setCheckExpire(boolean checkExpire) {
		this.checkExpire = checkExpire;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the registerDate
	 */
	public Timestamp getRegisterDate() {
		return registerDate;
	}
	/**
	 * @param registerDate the registerDate to set
	 */
	public void setRegisterDate(Timestamp registerDate) {
		this.registerDate = registerDate;
	}
	/**
	 * @return the expireDate
	 */
	public Timestamp getExpireDate() {
		return expireDate;
	}
	/**
	 * @param expireDate the expireDate to set
	 */
	public void setExpireDate(Timestamp expireDate) {
		this.expireDate = expireDate;
	}
	public Timestamp getRegisterDateTmp() {
		return registerDateTmp;
	}
	public void setRegisterDateTmp(Timestamp registerDateTmp) {
		this.registerDateTmp = registerDateTmp;
	}
	public Timestamp getExpireDateTmp() {
		return expireDateTmp;
	}
	public void setExpireDateTmp(Timestamp expireDateTmp) {
		this.expireDateTmp = expireDateTmp;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}
	/**
	 * @param company the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Timestamp getLastPayDate() {
		return lastPayDate;
	}
	public void setLastPayDate(Timestamp lastPayDate) {
		this.lastPayDate = lastPayDate;
	}
	/**
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}
	/**
	 * @param question the question to set
	 */
	public void setQuestion(String question) {
		this.question = question;
	}
	/**
	 * @return the answer
	 */
	public String getAnswer() {
		return answer;
	}
	/**
	 * @param answer the answer to set
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	/**
	 * @return the pcMac
	 */
	public String getPcMac() {
		return pcMac;
	}
	/**
	 * @param pcMac the pcMac to set
	 */
	public void setPcMac(String pcMac) {
		this.pcMac = pcMac;
	}
	/**
	 * @return the mobileIdentify
	 */
	public String getMobileIdentify() {
		return mobileIdentify;
	}
	/**
	 * @param mobileIdentify the mobileIdentify to set
	 */
	public void setMobileIdentify(String mobileIdentify) {
		this.mobileIdentify = mobileIdentify;
	}
	
	
}

