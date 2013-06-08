package com.bpim.entity;

/**
 * author Delgado
 */
public class GovernmentInventory
{
    
    private Long id;
    
    private String governmentInventoryType;
    
    private String projectClassLevel1Num;
    
    private String projectClassLevel2Num;
    
    private String projectNum;
    
    private String projectName;
    
    private String projectNameFeature;
    
    private String unit;
    
    private Double amount;
    
    private String detail;
    
    private String comments;
    
    /**
     * @return the id
     */
    public Long getId()
    {
        return id;
    }
    
    /**
     * @param id the id to set
     */
    public void setId(Long id)
    {
        this.id = id;
    }
    
    /**
     * @return the projectNum
     */
    public String getProjectNum()
    {
        return projectNum;
    }
    
    /**
     * @param projectNum the projectNum to set
     */
    public void setProjectNum(String projectNum)
    {
        this.projectNum = projectNum;
    }
    
    /**
     * @return the projectName
     */
    public String getProjectName()
    {
        return projectName;
    }
    
    /**
     * @param projectName the projectName to set
     */
    public void setProjectName(String projectName)
    {
        this.projectName = projectName;
    }
    
    /**
     * @return the projectNameFeature
     */
    public String getProjectNameFeature()
    {
        return projectNameFeature;
    }
    
    /**
     * @param projectNameFeature the projectNameFeature to set
     */
    public void setProjectNameFeature(String projectNameFeature)
    {
        this.projectNameFeature = projectNameFeature;
    }
    
    /**
     * @return the unit
     */
    public String getUnit()
    {
        return unit;
    }
    
    /**
     * @param unit the unit to set
     */
    public void setUnit(String unit)
    {
        this.unit = unit;
    }
    
    /**
     * @return the amount
     */
    public Double getAmount()
    {
        return amount;
    }
    
    /**
     * @param amount the amount to set
     */
    public void setAmount(Double amount)
    {
        this.amount = amount;
    }
    
    /**
     * @return the detail
     */
    public String getDetail()
    {
        return detail;
    }
    
    /**
     * @param detail the detail to set
     */
    public void setDetail(String detail)
    {
        this.detail = detail;
    }
    
    /**
     * @return the comments
     */
    public String getComments()
    {
        return comments;
    }
    
    /**
     * @param comments the comments to set
     */
    public void setComments(String comments)
    {
        this.comments = comments;
    }
    
    public String getProjectClassLevel1Num()
    {
        return projectClassLevel1Num;
    }
    
    public void setProjectClassLevel1Num(String projectClassLevel1Num)
    {
        this.projectClassLevel1Num = projectClassLevel1Num;
    }
    
    public String getProjectClassLevel2Num()
    {
        return projectClassLevel2Num;
    }
    
    public void setProjectClassLevel2Num(String projectClassLevel2Num)
    {
        this.projectClassLevel2Num = projectClassLevel2Num;
    }
    
    public String getGovernmentInventoryType()
    {
        return governmentInventoryType;
    }
    
    public void setGovernmentInventoryType(String governmentInventoryType)
    {
        this.governmentInventoryType = governmentInventoryType;
    }
    
}
