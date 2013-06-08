package com.bpim.entity;

import java.sql.Timestamp;

/**
 * author Delgado
 */
public class GovernmentQuota {
	private Long id;
	private String area;
	private String governmentQuotaClass ;
	private String governmentQuotaNum ;
	private String governmentQuotaName;
	private String governmentQuotaType;
	private String governmentQuotaModel;
	private String governmentQuotaUnit;
	private Double governmentQuotaAmount;
	private Double governmentQuotaTotalPrice;
	private String governmentQuotaDesc;
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
	 * @return the governmentQuotaNum
	 */
	public String getGovernmentQuotaNum() {
		return governmentQuotaNum;
	}
	/**
	 * @param governmentQuotaNum the governmentQuotaNum to set
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
	 * @return the governmentQuotaClass
	 */
	public String getGovernmentQuotaClass() {
		return governmentQuotaClass;
	}
	/**
	 * @param governmentQuotaClass the governmentQuotaClass to set
	 */
	public void setGovernmentQuotaClass(String governmentQuotaClass) {
		this.governmentQuotaClass = governmentQuotaClass;
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
	 * @return the governmentQuotaAmount
	 */
	public Double getGovernmentQuotaAmount() {
		return governmentQuotaAmount;
	}
	/**
	 * @param governmentQuotaAmount the governmentQuotaAmount to set
	 */
	public void setGovernmentQuotaAmount(Double governmentQuotaAmount) {
		this.governmentQuotaAmount = governmentQuotaAmount;
	}
	/**
	 * @return the governmentQuotaModel
	 */
	public String getGovernmentQuotaModel() {
		return governmentQuotaModel;
	}
	/**
	 * @param governmentQuotaModel the governmentQuotaModel to set
	 */
	public void setGovernmentQuotaModel(String governmentQuotaModel) {
		this.governmentQuotaModel = governmentQuotaModel;
	}
	/**
	 * @return the governmentQuotaDesc
	 */
	public String getGovernmentQuotaDesc() {
		return governmentQuotaDesc;
	}
	/**
	 * @param governmentQuotaDesc the governmentQuotaDesc to set
	 */
	public void setGovernmentQuotaDesc(String governmentQuotaDesc) {
		this.governmentQuotaDesc = governmentQuotaDesc;
	}
	
}

