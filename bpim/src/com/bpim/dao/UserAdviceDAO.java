package com.bpim.dao;

import java.sql.SQLException;
import java.util.List;

import com.bpim.entity.UserAdvice;
import com.bpim.form.SearchDataCondition;

/**
 * author Delgado
 */
public interface UserAdviceDAO
{
    
    List<UserAdvice> queryUserAdvice(SearchDataCondition condition)
        throws SQLException;
    
    int countQueryUserAdvice(SearchDataCondition condition)
        throws SQLException;
    
    public void insertUserAdvice(UserAdvice userAdvice)
        throws SQLException;
    
}
