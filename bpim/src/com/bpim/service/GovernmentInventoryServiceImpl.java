package com.bpim.service;

import java.sql.SQLException;
import java.util.List;

import com.bpim.common.DBConnUtil;
import com.bpim.dao.GovernmentInventoryDAO;
import com.bpim.dao.GovernmentInventoryDAOImpl;
import com.bpim.entity.GovernmentInventory;
import com.bpim.form.SearchDataCondition;
import com.bpim.helper.PageTools;

/**
 * author Delgado
 */
public class GovernmentInventoryServiceImpl implements GovernmentInventoryService
{
    
    GovernmentInventoryDAO dao = new GovernmentInventoryDAOImpl();
    
    public List<GovernmentInventory> searchGovernmentInventory(SearchDataCondition condition, PageTools page)
        throws SQLException
    {
        DBConnUtil.getConnection();
        if (page != null)
        {
            if (page.getRecordCount() == 0)
            {
                int count = dao.countSearchGovernmentInventory(condition);
                page.setRecordCount(count);
            }
            condition.setStartRow(page.getPageStartRow());
            condition.setPageSize(page.getPageSize());
        }
        List<GovernmentInventory> list = dao.searchGovernmentInventory(condition);
        DBConnUtil.close();
        return list;
    }
    
}
