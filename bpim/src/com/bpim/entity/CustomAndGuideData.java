package com.bpim.entity;

import java.sql.Timestamp;

/**
 * author Delgado
 */
public class CustomAndGuideData {
	private Long id=(long)0;
	private String area = "";
	private Long userInfoId = (long)0;
	private String quotaClass = "";
	private String recordName = "";
	private String recordNum = "";
	private String recordModel = "";
	private String recordType = "";
	private String recordUnit= "";
	private double recordPrice= 0.00;
	private double recordGross= 0.00 ;
	private double recordTotalPrice= 0.00;
	private double recordPercent= 0.00;
	private Timestamp recordDate;
	private Timestamp recordImportDate;
	private Timestamp recordModifyDate;
	private String recordSource = "";
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
	 * @return the area
	 */
	public String getArea() {
		return area;
	}
	/**
	 * @param area the area to set
	 */
	public void setArea(String area) {
		this.area = area;
	}
	/**
	 * @return the userInfoId
	 */
	public Long getUserInfoId() {
		return userInfoId;
	}
	/**
	 * @param userInfoId the userInfoId to set
	 */
	public void setUserInfoId(Long userInfoId) {
		this.userInfoId = userInfoId;
	}
	/**
	 * @return the recordName
	 */
	public String getRecordName() {
		return recordName;
	}
	/**
	 * @param recordName the recordName to set
	 */
	public void setRecordName(String recordName) {
		this.recordName = recordName;
	}
	/**
	 * @return the recordNum
	 */
	public String getRecordNum() {
		return recordNum;
	}
	/**
	 * @param recordNum the recordNum to set
	 */
	public void setRecordNum(String recordNum) {
		this.recordNum = recordNum;
	}
	/**
	 * @return the recordModel
	 */
	public String getRecordModel() {
		return recordModel;
	}
	/**
	 * @param recordModel the recordModel to set
	 */
	public void setRecordModel(String recordModel) {
		this.recordModel = recordModel;
	}
	
	/**
	 * @return the recordType
	 */
	public String getRecordType() {
		return recordType;
	}
	/**
	 * @param recordType the recordType to set
	 */
	public void setRecordType(String recordType) {
		this.recordType = recordType;
	}
	/**
	 * @return the recordUnit
	 */
	public String getRecordUnit() {
		return recordUnit;
	}
	/**
	 * @param recordUnit the recordUnit to set
	 */
	public void setRecordUnit(String recordUnit) {
		this.recordUnit = recordUnit;
	}
	
	/**
	 * @return the recordPrice
	 */
	public double getRecordPrice() {
		return recordPrice;
	}
	/**
	 * @param recordPrice the recordPrice to set
	 */
	public void setRecordPrice(double recordPrice) {
		this.recordPrice = recordPrice;
	}
	/**
	 * @return the recordGross
	 */
	public double getRecordGross() {
		return recordGross;
	}
	/**
	 * @param recordGross the recordGross to set
	 */
	public void setRecordGross(double recordGross) {
		this.recordGross = recordGross;
	}
	/**
	 * @return the recordTotalPrice
	 */
	public double getRecordTotalPrice() {
		return recordTotalPrice;
	}
	/**
	 * @param recordTotalPrice the recordTotalPrice to set
	 */
	public void setRecordTotalPrice(double recordTotalPrice) {
		this.recordTotalPrice = recordTotalPrice;
	}
	/**
	 * @return the recordPercent
	 */
	public double getRecordPercent() {
		return recordPercent;
	}
	/**
	 * @param recordPercent the recordPercent to set
	 */
	public void setRecordPercent(double recordPercent) {
		this.recordPercent = recordPercent;
	}
	/**
	 * @return the recordDate
	 */
	public Timestamp getRecordDate() {
		return recordDate;
	}
	/**
	 * @param recordDate the recordDate to set
	 */
	public void setRecordDate(Timestamp recordDate) {
		this.recordDate = recordDate;
	}
	/**
	 * @return the recordImportDate
	 */
	public Timestamp getRecordImportDate() {
		return recordImportDate;
	}
	/**
	 * @param recordImportDate the recordImportDate to set
	 */
	public void setRecordImportDate(Timestamp recordImportDate) {
		this.recordImportDate = recordImportDate;
	}
	/**
	 * @return the recordModifyDate
	 */
	public Timestamp getRecordModifyDate() {
		return recordModifyDate;
	}
	/**
	 * @param recordModifyDate the recordModifyDate to set
	 */
	public void setRecordModifyDate(Timestamp recordModifyDate) {
		this.recordModifyDate = recordModifyDate;
	}
	/**
	 * @return the recordSource
	 */
	public String getRecordSource() {
		return recordSource;
	}
	/**
	 * @param recordSource the recordSource to set
	 */
	public void setRecordSource(String recordSource) {
		this.recordSource = recordSource;
	}
	public String getQuotaClass() {
		return quotaClass;
	}
	public void setQuotaClass(String quotaClass) {
		this.quotaClass = quotaClass;
	}
	
	
}

