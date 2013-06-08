package com.bpim.service;

import java.sql.SQLException;
import java.util.List;

import com.bpim.common.DBConnUtil;
import com.bpim.dao.UserAdviceDAO;
import com.bpim.dao.UserAdviceDAOImpl;
import com.bpim.entity.UserAdvice;
import com.bpim.form.SearchDataCondition;
import com.bpim.helper.PageTools;

/**
 * author Delgado
 */
public class UserAdviceServiceImpl implements UserAdviceService
{
    
    UserAdviceDAO dao = new UserAdviceDAOImpl();
    
    public List<UserAdvice> searchUserAdvice(SearchDataCondition condition, PageTools page)
        throws SQLException
    {
        DBConnUtil.getConnection();
        if (page != null)
        {
            if (page.getRecordCount() == 0)
            {
                int count = dao.countQueryUserAdvice(condition);
                page.setRecordCount(count);
            }
            condition.setStartRow(page.getPageStartRow());
            condition.setPageSize(page.getPageSize());
        }
        List<UserAdvice> list = dao.queryUserAdvice(condition);
        DBConnUtil.close();
        return list;
    }
    
    @Override
    public void addUserAdvice(UserAdvice userAdvice)
        throws SQLException
    {
        DBConnUtil.getConnection();
        dao.insertUserAdvice(userAdvice);
        DBConnUtil.close();
        
    }
    
}
