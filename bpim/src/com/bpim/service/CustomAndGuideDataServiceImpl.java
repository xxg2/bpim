package com.bpim.service;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.bpim.common.DBConnUtil;
import com.bpim.common.PropertyConstants;
import com.bpim.dao.CustomAndGuideDataDAO;
import com.bpim.dao.CustomAndGuideDataDAOImpl;
import com.bpim.entity.CustomAndGuideData;
import com.bpim.form.SearchDataCondition;
import com.bpim.helper.PageTools;


/**
 * author Delgado
 */
public class CustomAndGuideDataServiceImpl implements CustomAndGuideDataService {
	CustomAndGuideDataDAO dao = new CustomAndGuideDataDAOImpl();

	@SuppressWarnings("unchecked")
	public List<CustomAndGuideData> searchCustomAndGuideData(SearchDataCondition condition, PageTools page) throws SQLException {
		DBConnUtil.getConnection();
		List<CustomAndGuideData> datas = new ArrayList<CustomAndGuideData>();
		int count = 0;
		boolean flag = false;
		if (page != null) {
			if (page.getRecordCount() == 0) {
				flag = true;
//				int count = dao.countSearchBoth(condition)
//				page.setRecordCount(count);
			}
			
		}
		if(PropertyConstants.GOVGUIDEPRICE.equals(condition.getPriceSourceType())){
			if(flag) {
				count = dao.countSearchGovermentGuidePrice(condition);
				page.setRecordCount(count);
			}
			condition.setStartRow(page.getPageStartRow());
			condition.setPageSize(page.getPageSize());
			datas = dao.searchGovermentGuidePrice(condition);
		}else if(PropertyConstants.CUSTDEFINEDPRICE.equals(condition.getPriceSourceType())){
			if(flag) {
				count = dao.countSearchCustomPrice(condition);
				page.setRecordCount(count);
			}
			condition.setStartRow(page.getPageStartRow());
			condition.setPageSize(page.getPageSize());
			datas = dao.searchCustomPrice(condition);
		}else if("0".equals(condition.getPriceSourceType())){
			if(flag) {
				count = dao.countSearchBoth(condition);
				page.setRecordCount(count);
			}
			condition.setStartRow(page.getPageStartRow());
			condition.setPageSize(page.getPageSize());
			datas = dao.searchBoth(condition);
		}
		DBConnUtil.close();
		return datas;
	}
	
	public String deleteCustomData(String id){
		String msg=PropertyConstants.DELETESUCCESS;
		try {
			DBConnUtil.getConnection();
			DBConnUtil.startTransaction(true);
			dao.deleteCustomData(id);
			DBConnUtil.close();
		} catch (SQLException e) {
			msg = PropertyConstants.DELETEFAILED;
		}
		return msg;
	}

	public void deleteGuideData(Timestamp dataDate, String provice) throws SQLException {
		DBConnUtil.getConnection();
		DBConnUtil.startTransaction(true);
		dao.deleteGuideData(dataDate,provice);
		DBConnUtil.close();
	}

	public void updateCustomData(CustomAndGuideData data) throws SQLException {
		DBConnUtil.getConnection();
		DBConnUtil.startTransaction(true);
		dao.updateCustomData(data);
		DBConnUtil.close();
	}

	public CustomAndGuideData queryCustomDataDetail(String id) throws SQLException {
		DBConnUtil.getConnection();
		CustomAndGuideData data = dao.queryCustomDataDetail(id);
		DBConnUtil.close();
		return data;
	}
}

