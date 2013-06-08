package com.bpim.web.action.mainPanel;

import java.sql.SQLException;

import com.bpim.entity.CustomAndGuideData;
import com.bpim.service.CustomAndGuideDataService;
import com.bpim.service.CustomAndGuideDataServiceImpl;
import com.bpim.web.action.ActionSupportBase;

/**
 * author Delgado
 */
public class CustomDataDetailAction extends ActionSupportBase{

	private static final long serialVersionUID = 7834582567787790738L;
	CustomAndGuideData data = new CustomAndGuideData();
	CustomAndGuideDataService service = new CustomAndGuideDataServiceImpl();
	
	public String viewCustomDataDetail() {
		String id = request.getParameter("id");
		try {
			data = service.queryCustomDataDetail(id);
		} catch (NumberFormatException e) {
			LOG.error(e);
		} catch (SQLException e) {
			LOG.error(e);
		}
		return SUCCESS;
	}

	/**
	 * @return the data
	 */
	public CustomAndGuideData getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(CustomAndGuideData data) {
		this.data = data;
	}
	
}

