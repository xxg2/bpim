package com.bpim.service;

import java.sql.SQLException;
import java.util.List;

import com.bpim.entity.UserAdvice;
import com.bpim.form.SearchDataCondition;
import com.bpim.helper.PageTools;

/**
 * author Delgado
 */
public interface UserAdviceService
{
    List<UserAdvice> searchUserAdvice(SearchDataCondition condition, PageTools page)
        throws SQLException;
    
    void addUserAdvice(UserAdvice userAdvice)
        throws SQLException;
}
