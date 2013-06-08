package com.bpim.entity;

import java.sql.Timestamp;

/**
 * author Delgado
 */
public class UserAdvice
{
    
    private Long id;
    
    private Long userID;
    
    private String userName;
    
    private String adviceContent;
    
    private Timestamp adviceDate;
    
    public Long getId()
    {
        return id;
    }
    
    public void setId(Long id)
    {
        this.id = id;
    }
    
    public Long getUserID()
    {
        return userID;
    }
    
    public void setUserID(Long userID)
    {
        this.userID = userID;
    }
    
    public String getUserName()
    {
        return userName;
    }
    
    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    
    public String getAdviceContent()
    {
        return adviceContent;
    }
    
    public void setAdviceContent(String adviceContent)
    {
        this.adviceContent = adviceContent;
    }
    
    public Timestamp getAdviceDate()
    {
        return adviceDate;
    }
    
    public void setAdviceDate(Timestamp adviceDate)
    {
        this.adviceDate = adviceDate;
    }
}
