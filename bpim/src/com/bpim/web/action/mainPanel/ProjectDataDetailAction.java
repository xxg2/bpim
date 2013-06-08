package com.bpim.web.action.mainPanel;

import java.sql.SQLException;

import com.bpim.entity.UserProjectUploadData;
import com.bpim.service.UserProjectDataOperatingService;
import com.bpim.service.UserProjectDataOperatingServiceImpl;
import com.bpim.web.action.ActionSupportBase;

/**
 * author Delgado
 */
public class ProjectDataDetailAction extends ActionSupportBase{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3328804218927642531L;
	UserProjectUploadData data = new UserProjectUploadData();
	UserProjectDataOperatingService service = new UserProjectDataOperatingServiceImpl();
	
	public String viewProjectDataDetail() {
		String id = request.getParameter("id");
		try {
			data = service.viewProjectDataDetail(id);
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
	public UserProjectUploadData getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(UserProjectUploadData data) {
		this.data = data;
	}
	
	
}

