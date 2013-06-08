package com.bpim.form;

import java.sql.Timestamp;

import com.bpim.entity.VoBase;

/**
 * author Delgado
 */
public class SearchDataCondition extends VoBase
{
    private static final long serialVersionUID = -430479037028855658L;
    
    private Long userInfoId = (long)0;
    
    private Timestamp dataDateAfter;
    
    private Timestamp dataDateBefore;
    
    private String inventoryType = "";
    
    private String projectSuperClassNum = "";
    
    private String projectClassNum = "";
    
    private String projectNum = "";
    
    private String projectName = "";
    
    private String recordType = "";
    
    private String quotaClass = "";
    
    private String quotaNum = "";
    
    private String quotaName = "";
    
    private String recordModel = "";
    
    private String recordName = "";
    
    private String recordUnit = "";
    
    private String dataType = "";
    
    private String fromYear = "";
    
    private String fromMonth = "";
    
    private String toYear = "";
    
    private String toMonth = "";
    
    private String priceSourceType = "";
    
    private String recordCode = "";
    
    private String provice = "";
    
    private String city = "";
    
    private String area = "";
    
    private String fileType = "";
    
    private String fileSubType = "";
    
    private String filePublishYear = "";
    
    private String filePublishMonth = "";
    
    private String fileEffectiveYear = "";
    
    private String fileEffectiveMonth = "";
    
    private String fileName = "";
    
    private String keyword = "";
    
    private Timestamp filePublishDateFrom;
    
    private Timestamp filePublishDateTo;
    
    private Timestamp fileEffectiveDateFrom;
    
    private Timestamp fileEffectiveDateTo;
    
    /**
     * @return the userInfoId
     */
    public Long getUserInfoId()
    {
        return userInfoId;
    }
    
    /**
     * @param userInfoId
     *            the userInfoId to set
     */
    public void setUserInfoId(Long userInfoId)
    {
        this.userInfoId = userInfoId;
    }
    
    /**
     * @return the projectDateAfter
     */
    public Timestamp getDataDateAfter()
    {
        return dataDateAfter;
    }
    
    /**
     * @param projectDateAfter
     *            the projectDateAfter to set
     */
    public void setProjectDateAfter(Timestamp projectDateAfter)
    {
        this.dataDateAfter = projectDateAfter;
    }
    
    /**
     * @return the projectDateBefore
     */
    public Timestamp getDataDateBefore()
    {
        return dataDateBefore;
    }
    
    /**
     * @param projectDateBefore
     *            the projectDateBefore to set
     */
    public void setProjectDateBefore(Timestamp projectDateBefore)
    {
        this.dataDateBefore = projectDateBefore;
    }
    
    /**
     * @return the projectName
     */
    public String getProjectName()
    {
        return projectName;
    }
    
    /**
     * @param projectName
     *            the projectName to set
     */
    public void setProjectName(String projectName)
    {
        this.projectName = projectName;
    }
    
    /**
     * @return the recordType
     */
    public String getRecordType()
    {
        return recordType;
    }
    
    /**
     * @param recordType
     *            the recordType to set
     */
    public void setRecordType(String recordType)
    {
        this.recordType = recordType;
    }
    
    /**
     * @return the quotaNum
     */
    public String getQuotaNum()
    {
        return quotaNum;
    }
    
    /**
     * @param quotaNum
     *            the quotaNum to set
     */
    public void setQuotaNum(String quotaNum)
    {
        this.quotaNum = quotaNum;
    }
    
    /**
     * @return the quotaName
     */
    public String getQuotaName()
    {
        return quotaName;
    }
    
    /**
     * @param quotaName
     *            the quotaName to set
     */
    public void setQuotaName(String quotaName)
    {
        this.quotaName = quotaName;
    }
    
    /**
     * @return the recordName
     */
    public String getRecordName()
    {
        return recordName;
    }
    
    /**
     * @param recordName
     *            the recordName to set
     */
    public void setRecordName(String recordName)
    {
        this.recordName = recordName;
    }
    
    /**
     * @return the recordUnit
     */
    public String getRecordUnit()
    {
        return recordUnit;
    }
    
    /**
     * @param recordUnit
     *            the recordUnit to set
     */
    public void setRecordUnit(String recordUnit)
    {
        this.recordUnit = recordUnit;
    }
    
    /**
     * @return the dataType
     */
    public String getDataType()
    {
        return dataType;
    }
    
    /**
     * @param dataType
     *            the dataType to set
     */
    public void setDataType(String dataType)
    {
        this.dataType = dataType;
    }
    
    /**
     * @return the fromYear
     */
    public String getFromYear()
    {
        return fromYear;
    }
    
    /**
     * @param fromYear
     *            the fromYear to set
     */
    public void setFromYear(String fromYear)
    {
        this.fromYear = fromYear;
    }
    
    /**
     * @return the fromMonth
     */
    public String getFromMonth()
    {
        return fromMonth;
    }
    
    /**
     * @param fromMonth
     *            the fromMonth to set
     */
    public void setFromMonth(String fromMonth)
    {
        this.fromMonth = fromMonth;
    }
    
    /**
     * @return the toYear
     */
    public String getToYear()
    {
        return toYear;
    }
    
    /**
     * @param toYear
     *            the toYear to set
     */
    public void setToYear(String toYear)
    {
        this.toYear = toYear;
    }
    
    /**
     * @return the toMonth
     */
    public String getToMonth()
    {
        return toMonth;
    }
    
    /**
     * @param toMonth
     *            the toMonth to set
     */
    public void setToMonth(String toMonth)
    {
        this.toMonth = toMonth;
    }
    
    /**
     * @return the priceSourceType
     */
    public String getPriceSourceType()
    {
        return priceSourceType;
    }
    
    /**
     * @param priceSourceType
     *            the priceSourceType to set
     */
    public void setPriceSourceType(String priceSourceType)
    {
        this.priceSourceType = priceSourceType;
    }
    
    /**
     * @return the recordCode
     */
    public String getRecordCode()
    {
        return recordCode;
    }
    
    /**
     * @param recordCode
     *            the recordCode to set
     */
    public void setRecordCode(String recordCode)
    {
        this.recordCode = recordCode;
    }
    
    /**
     * @return the provice
     */
    public String getProvice()
    {
        return provice;
    }
    
    /**
     * @param provice
     *            the provice to set
     */
    public void setProvice(String provice)
    {
        this.provice = provice;
    }
    
    /**
     * @param dataDateAfter
     *            the dataDateAfter to set
     */
    public void setDataDateAfter(Timestamp dataDateAfter)
    {
        this.dataDateAfter = dataDateAfter;
    }
    
    /**
     * @param dataDateBefore
     *            the dataDateBefore to set
     */
    public void setDataDateBefore(Timestamp dataDateBefore)
    {
        this.dataDateBefore = dataDateBefore;
    }
    
    /**
     * @return the quotaClass
     */
    public String getQuotaClass()
    {
        return quotaClass;
    }
    
    /**
     * @param quotaClass
     *            the quotaClass to set
     */
    public void setQuotaClass(String quotaClass)
    {
        this.quotaClass = quotaClass;
    }
    
    /**
     * @return the city
     */
    public String getCity()
    {
        return city;
    }
    
    /**
     * @param city
     *            the city to set
     */
    public void setCity(String city)
    {
        this.city = city;
    }
    
    /**
     * @return the area
     */
    public String getArea()
    {
        return area;
    }
    
    /**
     * @param area
     *            the area to set
     */
    public void setArea(String area)
    {
        this.area = area;
    }
    
    /**
     * @return the recordModel
     */
    public String getRecordModel()
    {
        return recordModel;
    }
    
    /**
     * @param recordModel
     *            the recordModel to set
     */
    public void setRecordModel(String recordModel)
    {
        this.recordModel = recordModel;
    }
    
    /**
     * @return the fileType
     */
    public String getFileType()
    {
        return fileType;
    }
    
    /**
     * @param fileType
     *            the fileType to set
     */
    public void setFileType(String fileType)
    {
        this.fileType = fileType;
    }
    
    /**
     * @return the fileSubType
     */
    public String getFileSubType()
    {
        return fileSubType;
    }
    
    /**
     * @param fileSubType
     *            the fileSubType to set
     */
    public void setFileSubType(String fileSubType)
    {
        this.fileSubType = fileSubType;
    }
    
    /**
     * @return the filePublishYear
     */
    public String getFilePublishYear()
    {
        return filePublishYear;
    }
    
    /**
     * @param filePublishYear
     *            the filePublishYear to set
     */
    public void setFilePublishYear(String filePublishYear)
    {
        this.filePublishYear = filePublishYear;
    }
    
    /**
     * @return the filePublishMonth
     */
    public String getFilePublishMonth()
    {
        return filePublishMonth;
    }
    
    /**
     * @param filePublishMonth
     *            the filePublishMonth to set
     */
    public void setFilePublishMonth(String filePublishMonth)
    {
        this.filePublishMonth = filePublishMonth;
    }
    
    /**
     * @return the fileEffectiveYear
     */
    public String getFileEffectiveYear()
    {
        return fileEffectiveYear;
    }
    
    /**
     * @param fileEffectiveYear
     *            the fileEffectiveYear to set
     */
    public void setFileEffectiveYear(String fileEffectiveYear)
    {
        this.fileEffectiveYear = fileEffectiveYear;
    }
    
    /**
     * @return the fileEffectiveMonth
     */
    public String getFileEffectiveMonth()
    {
        return fileEffectiveMonth;
    }
    
    /**
     * @param fileEffectiveMonth
     *            the fileEffectiveMonth to set
     */
    public void setFileEffectiveMonth(String fileEffectiveMonth)
    {
        this.fileEffectiveMonth = fileEffectiveMonth;
    }
    
    /**
     * @return the fileName
     */
    public String getFileName()
    {
        return fileName;
    }
    
    /**
     * @param fileName
     *            the fileName to set
     */
    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }
    
    /**
     * @return the keyword
     */
    public String getKeyword()
    {
        return keyword;
    }
    
    /**
     * @param keyword
     *            the keyword to set
     */
    public void setKeyword(String keyword)
    {
        this.keyword = keyword;
    }
    
    /**
     * @return the filePublishDateFrom
     */
    public Timestamp getFilePublishDateFrom()
    {
        return filePublishDateFrom;
    }
    
    /**
     * @param filePublishDateFrom
     *            the filePublishDateFrom to set
     */
    public void setFilePublishDateFrom(Timestamp filePublishDateFrom)
    {
        this.filePublishDateFrom = filePublishDateFrom;
    }
    
    /**
     * @return the filePublishDateTo
     */
    public Timestamp getFilePublishDateTo()
    {
        return filePublishDateTo;
    }
    
    /**
     * @param filePublishDateTo
     *            the filePublishDateTo to set
     */
    public void setFilePublishDateTo(Timestamp filePublishDateTo)
    {
        this.filePublishDateTo = filePublishDateTo;
    }
    
    /**
     * @return the fileEffectiveDateFrom
     */
    public Timestamp getFileEffectiveDateFrom()
    {
        return fileEffectiveDateFrom;
    }
    
    /**
     * @param fileEffectiveDateFrom
     *            the fileEffectiveDateFrom to set
     */
    public void setFileEffectiveDateFrom(Timestamp fileEffectiveDateFrom)
    {
        this.fileEffectiveDateFrom = fileEffectiveDateFrom;
    }
    
    /**
     * @return the fileEffectiveDateTo
     */
    public Timestamp getFileEffectiveDateTo()
    {
        return fileEffectiveDateTo;
    }
    
    /**
     * @param fileEffectiveDateTo
     *            the fileEffectiveDateTo to set
     */
    public void setFileEffectiveDateTo(Timestamp fileEffectiveDateTo)
    {
        this.fileEffectiveDateTo = fileEffectiveDateTo;
    }
    
    public String getProjectSuperClassNum()
    {
        return projectSuperClassNum;
    }
    
    public void setProjectSuperClassNum(String projectSuperClassNum)
    {
        this.projectSuperClassNum = projectSuperClassNum;
    }
    
    public String getProjectClassNum()
    {
        return projectClassNum;
    }
    
    public void setProjectClassNum(String projectClassNum)
    {
        this.projectClassNum = projectClassNum;
    }
    
    public String getProjectNum()
    {
        return projectNum;
    }
    
    public void setProjectNum(String projectNum)
    {
        this.projectNum = projectNum;
    }

    public String getInventoryType()
    {
        return inventoryType;
    }

    public void setInventoryType(String inventoryType)
    {
        this.inventoryType = inventoryType;
    }
    
}
