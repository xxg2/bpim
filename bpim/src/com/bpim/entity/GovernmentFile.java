package com.bpim.entity;

import java.sql.Timestamp;

/**
 * author Delgado
 */
public class GovernmentFile {

	private Long id;
	private String fileTitle = "";
	private String fileType = "";
	private String fileSubType = "";
	private String area = "";
	private String sourceCode = "";
	private Timestamp filePublishDate;
	private Timestamp fileEffectiveDate;
	private Boolean effective;
	/**
	 * @return the fileTitle
	 */
	public String getFileTitle() {
		return fileTitle;
	}
	/**
	 * @param fileTitle the fileTitle to set
	 */
	public void setFileTitle(String fileTitle) {
		this.fileTitle = fileTitle;
	}
	/**
	 * @return the fileType
	 */
	public String getFileType() {
		return fileType;
	}
	/**
	 * @param fileType the fileType to set
	 */
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	/**
	 * @return the fileSubType
	 */
	public String getFileSubType() {
		return fileSubType;
	}
	/**
	 * @param fileSubType the fileSubType to set
	 */
	public void setFileSubType(String fileSubType) {
		this.fileSubType = fileSubType;
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
	 * @return the filePublishDate
	 */
	public Timestamp getFilePublishDate() {
		return filePublishDate;
	}
	/**
	 * @param filePublishDate the filePublishDate to set
	 */
	public void setFilePublishDate(Timestamp filePublishDate) {
		this.filePublishDate = filePublishDate;
	}
	/**
	 * @return the fileEffectiveDate
	 */
	public Timestamp getFileEffectiveDate() {
		return fileEffectiveDate;
	}
	/**
	 * @param fileEffectiveDate the fileEffectiveDate to set
	 */
	public void setFileEffectiveDate(Timestamp fileEffectiveDate) {
		this.fileEffectiveDate = fileEffectiveDate;
	}
	/**
	 * @return the effective
	 */
	public Boolean getEffective() {
		return effective;
	}
	/**
	 * @param effective the effective to set
	 */
	public void setEffective(Boolean effective) {
		this.effective = effective;
	}
	/**
	 * @return the sourceCode
	 */
	public String getSourceCode() {
		return sourceCode;
	}
	/**
	 * @param sourceCode the sourceCode to set
	 */
	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
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
	
	
}

