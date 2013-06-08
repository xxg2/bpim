package com.bpim.entity;

import java.sql.Timestamp;

/**
 * author Delgado
 */
public class UserProjectUploadData {
	private Long id;
	private String area;
	private Timestamp projectDate;
	private Long userInfoId;
	private String dataType;
	private String projectName;
	private String projectSubName;
	private String governmentQuotaNum ;
	private String governmentQuotaName;
	private String governmentQuotaType;
	private String governmentQuotaUnit;
	private Double governmentQuotaPrice;
	private Double governmentQuotaGross;
	private Double governmentQuotaTotalPrice;
	private String recordName;
	private String recordNum ;
	private String recordType;
	private String recordUnit;
	private Double recordPrice;
	private Double recordTotalGross;
	private Double recordTotalPrice;
	private Timestamp recordImportDate;
	private Timestamp recordModifyDate;
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
	 * @return the projectDate
	 */
	public Timestamp getProjectDate() {
		return projectDate;
	}
	/**
	 * @param projectDate the projectDate to set
	 */
	public void setProjectDate(Timestamp projectDate) {
		this.projectDate = projectDate;
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
	 * @return the projectName
	 */
	public String getProjectName() {
		return projectName;
	}
	/**
	 * @param projectName the projectName to set
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	/**
	 * @return the projectSubName
	 */
	public String getProjectSubName() {
		return projectSubName;
	}
	/**
	 * @param projectSubName the projectSubName to set
	 */
	public void setProjectSubName(String projectSubName) {
		this.projectSubName = projectSubName;
	}
	/**
	 * @return the governmentQuotaNo
	 */
	public String getGovernmentQuotaNum() {
		return governmentQuotaNum;
	}
	/**
	 * @param governmentQuotaNo the governmentQuotaNo to set
	 */
	public void setGovernmentQuotaNum(String governmentQuotaNum) {
		this.governmentQuotaNum = governmentQuotaNum;
	}
	/**
	 * @return the governmentQuotaName
	 */
	public String getGovernmentQuotaName() {
		return governmentQuotaName;
	}
	/**
	 * @param governmentQuotaName the governmentQuotaName to set
	 */
	public void setGovernmentQuotaName(String governmentQuotaName) {
		this.governmentQuotaName = governmentQuotaName;
	}
	/**
	 * @return the governmentQuotaType
	 */
	public String getGovernmentQuotaType() {
		return governmentQuotaType;
	}
	/**
	 * @param governmentQuotaType the governmentQuotaType to set
	 */
	public void setGovernmentQuotaType(String governmentQuotaType) {
		this.governmentQuotaType = governmentQuotaType;
	}
	/**
	 * @return the governmentQuotaGross
	 */
	public Double getGovernmentQuotaGross() {
		return governmentQuotaGross;
	}
	/**
	 * @param governmentQuotaGross the governmentQuotaGross to set
	 */
	public void setGovernmentQuotaGross(Double governmentQuotaGross) {
		this.governmentQuotaGross = governmentQuotaGross;
	}
	/**
	 * @return the governmentQuotaTotalPrice
	 */
	public Double getGovernmentQuotaTotalPrice() {
		return governmentQuotaTotalPrice;
	}
	/**
	 * @param governmentQuotaTotalPrice the governmentQuotaTotalPrice to set
	 */
	public void setGovernmentQuotaTotalPrice(Double governmentQuotaTotalPrice) {
		this.governmentQuotaTotalPrice = governmentQuotaTotalPrice;
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
	 * @return the recordNo
	 */
	public String getRecordNum() {
		return recordNum;
	}
	/**
	 * @param recordNo the recordNo to set
	 */
	public void setRecordNum(String recordNum) {
		this.recordNum = recordNum;
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
	 * @return the recordPrice
	 */
	public Double getRecordPrice() {
		return recordPrice;
	}
	/**
	 * @param recordPrice the recordPrice to set
	 */
	public void setRecordPrice(Double recordPrice) {
		this.recordPrice = recordPrice;
	}
	/**
	 * @return the recordTotalGross
	 */
	public Double getRecordTotalGross() {
		return recordTotalGross;
	}
	/**
	 * @param recordTotalGross the recordTotalGross to set
	 */
	public void setRecordTotalGross(Double recordTotalGross) {
		this.recordTotalGross = recordTotalGross;
	}
	/**
	 * @return the recordTotalPrice
	 */
	public Double getRecordTotalPrice() {
		return recordTotalPrice;
	}
	/**
	 * @param recordTotalPrice the recordTotalPrice to set
	 */
	public void setRecordTotalPrice(Double recordTotalPrice) {
		this.recordTotalPrice = recordTotalPrice;
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
	 * @return the dataType
	 */
	public String getDataType() {
		return dataType;
	}
	/**
	 * @param dataType the dataType to set
	 */
	public void setDataType(String dataType) {
		this.dataType = dataType;
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
	 * @return the governmentQuotaUnit
	 */
	public String getGovernmentQuotaUnit() {
		return governmentQuotaUnit;
	}
	/**
	 * @param governmentQuotaUnit the governmentQuotaUnit to set
	 */
	public void setGovernmentQuotaUnit(String governmentQuotaUnit) {
		this.governmentQuotaUnit = governmentQuotaUnit;
	}
	/**
	 * @return the governmentQuotaPrice
	 */
	public Double getGovernmentQuotaPrice() {
		return governmentQuotaPrice;
	}
	/**
	 * @param governmentQuotaPrice the governmentQuotaPrice to set
	 */
	public void setGovernmentQuotaPrice(Double governmentQuotaPrice) {
		this.governmentQuotaPrice = governmentQuotaPrice;
	}
	
}

