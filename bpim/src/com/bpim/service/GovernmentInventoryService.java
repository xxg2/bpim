package com.bpim.service;

import java.sql.SQLException;
import java.util.List;

import com.bpim.entity.GovernmentInventory;
import com.bpim.form.SearchDataCondition;
import com.bpim.helper.PageTools;

/**
 * author Delgado
 */
public interface GovernmentInventoryService
{
    List<GovernmentInventory> searchGovernmentInventory(SearchDataCondition condition, PageTools page)
        throws SQLException;
}
