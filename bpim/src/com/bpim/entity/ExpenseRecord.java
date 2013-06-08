package com.bpim.entity;

import java.sql.Timestamp;

/**
 * author Delgado
 */
public class ExpenseRecord extends VoBase {
	private static final long serialVersionUID = 5678064887368241202L;
	private Long id;
	private Long userId;
	private Float money;
	private Timestamp payDate;
	private Timestamp expireDate;
	private UserInfo userInfo;
	private String selection;
	private Timestamp payDateTmp;
	private Timestamp expireDateTmp;
	private ServicePlan device;
	
	public ServicePlan getDevice() {
		return device;
	}
	public void setDevice(ServicePlan device) {
		this.device = device;
	}
	public Timestamp getPayDateTmp() {
		return payDateTmp;
	}
	public void setPayDateTmp(Timestamp payDateTmp) {
		this.payDateTmp = payDateTmp;
	}
	public Timestamp getExpireDateTmp() {
		return expireDateTmp;
	}
	public void setExpireDateTmp(Timestamp expireDateTmp) {
		this.expireDateTmp = expireDateTmp;
	}
	
	public String getSelection() {
		return selection;
	}
	public void setSelection(String selection) {
		this.selection = selection;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	public Timestamp getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(Timestamp expireDate) {
		this.expireDate = expireDate;
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
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * @return the money
	 */
	public Float getMoney() {
		return money;
	}
	/**
	 * @param money the money to set
	 */
	public void setMoney(Float money) {
		this.money = money;
	}
	/**
	 * @return the payDate
	 */
	public Timestamp getPayDate() {
		return payDate;
	}
	/**
	 * @param payDate the payDate to set
	 */
	public void setPayDate(Timestamp payDate) {
		this.payDate = payDate;
	}
	
	
}
