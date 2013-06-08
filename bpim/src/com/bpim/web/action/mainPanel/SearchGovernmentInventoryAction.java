package com.bpim.web.action.mainPanel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bpim.common.Constants;
import com.bpim.entity.GovernmentInventory;
import com.bpim.form.SearchDataCondition;
import com.bpim.helper.PageTools;
import com.bpim.helper.ParamTools;
import com.bpim.service.GovernmentInventoryService;
import com.bpim.service.GovernmentInventoryServiceImpl;
import com.bpim.web.action.ActionSupportBase;

/**
 * author Delgado
 */
public class SearchGovernmentInventoryAction extends ActionSupportBase
{
    /**
     * 
     */
    private static final long serialVersionUID = -251531175570040393L;
    
    SearchDataCondition condition = new SearchDataCondition();
    
    List<GovernmentInventory> datas = new ArrayList<GovernmentInventory>();
    
    private PageTools page;
    
    GovernmentInventoryService service = new GovernmentInventoryServiceImpl();
    
    public String searchGovernmentInventory()
    {
        try
        {
            int pageNo = ParamTools.getIntParameter(request, Constants.PARA_PAGE_NO, 1);
            int pageSize = ParamTools.getIntParameter(request, Constants.PARA_PAGE_SIZE, 0);
            PageTools page = new PageTools(pageNo, pageSize);
            condition.setRowCount(pageNo);
            condition.setPageSize(pageSize);
            datas = service.searchGovernmentInventory(condition, page);
            if (datas != null && datas.size() > 0)
            {
                this.page = page;
            }
            else
            {
                super.addNotFoundErrorMsg();
            }
        }
        catch (SQLException e)
        {
            LOG.error(e);
        }
        
        if ("2003".equals(condition.getInventoryType()))
        {
            return "inventory2003";
        }
        else if ("2008".equals(condition.getInventoryType()))
        {
            return "inventory2008";
        }
        else
        {
            return SUCCESS;
        }
        
    }
    
    /**
     * @return the condition
     */
    public SearchDataCondition getCondition()
    {
        return condition;
    }
    
    /**
     * @param condition
     *            the condition to set
     */
    public void setCondition(SearchDataCondition condition)
    {
        this.condition = condition;
    }
    
    public PageTools getPage()
    {
        return page;
    }
    
    public void setPage(PageTools page)
    {
        this.page = page;
    }
    
    public List<GovernmentInventory> getDatas()
    {
        return datas;
    }
    
    public void setDatas(List<GovernmentInventory> datas)
    {
        this.datas = datas;
    }
}
