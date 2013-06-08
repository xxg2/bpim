package com.bpim.entity;


public class ServicePlan extends VoBase {
	private static final long serialVersionUID = -5358042196544022521L;
	
	private Long id;
	private Long userInfoID;
	private String serviceName;
	private Float money;
	private Integer payDate;
	private String remark;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserInfoID() {
		return userInfoID;
	}
	public void setUserInfoID(Long userInfoID) {
		this.userInfoID = userInfoID;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public Float getMoney() {
		return money;
	}
	public void setMoney(Float money) {
		this.money = money;
	}
	public Integer getPayDate() {
		return payDate;
	}
	public void setPayDate(Integer payDate) {
		this.payDate = payDate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
