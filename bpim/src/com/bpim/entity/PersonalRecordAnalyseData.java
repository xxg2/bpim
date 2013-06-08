package com.bpim.entity;
/**
 * author Delgado
 */
public class PersonalRecordAnalyseData {

	private String recordName;//工料机名
	private String recordModel;//规格
	private String recordUnit;//单位
	
	private Double userRecordAvg;//历史数据平均价
	private Double userRecordMax;//历史数据最高价
	private Double userRecordMin;//历史数据最低价
	private Double userRecordGrossAvg;//历史数据平均量
	
	private Double totalPriceOfProjcetPrice;//历史数据平均价*历史数据平均量
	
	private Double recordGrossOfGovernmentQuota;//国家定额工料机量
	private Double totalPriceOfGovernmentQuota;//国家定额工料机量*历史数据平均价
	
	private Double totalPriceOfGuidePrice;//政府指导平均价*历史数据平均量
	
	private Double totalPriceOfCustomPrice;//自定义平均价*历史数据平均量
	
	private Double governmentGuideAvg;//政府指导平均价
	private Double governmentGuideMax;//政府指导最高价
	private Double governmentGuideMin;//历史数据最低价
	private Double userCustomAvg;//自定义平均价
	private Double userCustomMax;//自定义最高价
	private Double userCustomMin;//自定义最低价
	
	
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
	 * @return the userRecordAvg
	 */
	public Double getUserRecordAvg() {
		return userRecordAvg;
	}
	/**
	 * @param userRecordAvg the userRecordAvg to set
	 */
	public void setUserRecordAvg(Double userRecordAvg) {
		this.userRecordAvg = userRecordAvg;
	}
	/**
	 * @return the userRecordMax
	 */
	public Double getUserRecordMax() {
		return userRecordMax;
	}
	/**
	 * @param userRecordMax the userRecordMax to set
	 */
	public void setUserRecordMax(Double userRecordMax) {
		this.userRecordMax = userRecordMax;
	}
	/**
	 * @return the userRecordMin
	 */
	public Double getUserRecordMin() {
		return userRecordMin;
	}
	/**
	 * @param userRecordMin the userRecordMin to set
	 */
	public void setUserRecordMin(Double userRecordMin) {
		this.userRecordMin = userRecordMin;
	}
	/**
	 * @return the governmentGuideAvg
	 */
	public Double getGovernmentGuideAvg() {
		return governmentGuideAvg;
	}
	/**
	 * @param governmentGuideAvg the governmentGuideAvg to set
	 */
	public void setGovernmentGuideAvg(Double governmentGuideAvg) {
		this.governmentGuideAvg = governmentGuideAvg;
	}
	/**
	 * @return the governmentGuideMax
	 */
	public Double getGovernmentGuideMax() {
		return governmentGuideMax;
	}
	/**
	 * @param governmentGuideMax the governmentGuideMax to set
	 */
	public void setGovernmentGuideMax(Double governmentGuideMax) {
		this.governmentGuideMax = governmentGuideMax;
	}
	/**
	 * @return the governmentGuideMin
	 */
	public Double getGovernmentGuideMin() {
		return governmentGuideMin;
	}
	/**
	 * @param governmentGuideMin the governmentGuideMin to set
	 */
	public void setGovernmentGuideMin(Double governmentGuideMin) {
		this.governmentGuideMin = governmentGuideMin;
	}
	/**
	 * @return the userCustomAvg
	 */
	public Double getUserCustomAvg() {
		return userCustomAvg;
	}
	/**
	 * @param userCustomAvg the userCustomAvg to set
	 */
	public void setUserCustomAvg(Double userCustomAvg) {
		this.userCustomAvg = userCustomAvg;
	}
	/**
	 * @return the userCustomMax
	 */
	public Double getUserCustomMax() {
		return userCustomMax;
	}
	/**
	 * @param userCustomMax the userCustomMax to set
	 */
	public void setUserCustomMax(Double userCustomMax) {
		this.userCustomMax = userCustomMax;
	}
	/**
	 * @return the userCustomMin
	 */
	public Double getUserCustomMin() {
		return userCustomMin;
	}
	/**
	 * @param userCustomMin the userCustomMin to set
	 */
	public void setUserCustomMin(Double userCustomMin) {
		this.userCustomMin = userCustomMin;
	}
	/**
	 * @return the userRecordGrossAvg
	 */
	public Double getUserRecordGrossAvg() {
		return userRecordGrossAvg;
	}
	/**
	 * @param userRecordGrossAvg the userRecordGrossAvg to set
	 */
	public void setUserRecordGrossAvg(Double userRecordGrossAvg) {
		this.userRecordGrossAvg = userRecordGrossAvg;
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
	 * @return the recordGrossOfGovernmentQuota
	 */
	public Double getRecordGrossOfGovernmentQuota() {
		return recordGrossOfGovernmentQuota;
	}
	/**
	 * @param recordGrossOfGovernmentQuota the recordGrossOfGovernmentQuota to set
	 */
	public void setRecordGrossOfGovernmentQuota(Double recordGrossOfGovernmentQuota) {
		this.recordGrossOfGovernmentQuota = recordGrossOfGovernmentQuota;
	}
	/**
	 * @return the totalPriceOfGovernmentQuota
	 */
	public Double getTotalPriceOfGovernmentQuota() {
		return totalPriceOfGovernmentQuota;
	}
	/**
	 * @param totalPriceOfGovernmentQuota the totalPriceOfGovernmentQuota to set
	 */
	public void setTotalPriceOfGovernmentQuota(Double totalPriceOfGovernmentQuota) {
		this.totalPriceOfGovernmentQuota = totalPriceOfGovernmentQuota;
	}
	/**
	 * @return the totalPriceOfGuidePrice
	 */
	public Double getTotalPriceOfGuidePrice() {
		return totalPriceOfGuidePrice;
	}
	/**
	 * @param totalPriceOfGuidePrice the totalPriceOfGuidePrice to set
	 */
	public void setTotalPriceOfGuidePrice(Double totalPriceOfGuidePrice) {
		this.totalPriceOfGuidePrice = totalPriceOfGuidePrice;
	}
	/**
	 * @return the totalPriceOfCustomPrice
	 */
	public Double getTotalPriceOfCustomPrice() {
		return totalPriceOfCustomPrice;
	}
	/**
	 * @param totalPriceOfCustomPrice the totalPriceOfCustomPrice to set
	 */
	public void setTotalPriceOfCustomPrice(Double totalPriceOfCustomPrice) {
		this.totalPriceOfCustomPrice = totalPriceOfCustomPrice;
	}
	/**
	 * @return the totalPriceOfProjcetPrice
	 */
	public Double getTotalPriceOfProjcetPrice() {
		return totalPriceOfProjcetPrice;
	}
	/**
	 * @param totalPriceOfProjcetPrice the totalPriceOfProjcetPrice to set
	 */
	public void setTotalPriceOfProjcetPrice(Double totalPriceOfProjcetPrice) {
		this.totalPriceOfProjcetPrice = totalPriceOfProjcetPrice;
	}
	
	
}

