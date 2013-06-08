package com.bpim.web.action.mainPanel;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import com.bpim.entity.UserProjectUploadData;
import com.bpim.service.UserProjectDataOperatingService;
import com.bpim.service.UserProjectDataOperatingServiceImpl;
import com.bpim.web.action.ActionSupportBase;

/**
 * author Delgado
 */
public class ModifyProjectDataAction extends ActionSupportBase{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2776195968833467736L;
	UserProjectUploadData data = new UserProjectUploadData();
	String msg = "修改成功";
	UserProjectDataOperatingService service = new UserProjectDataOperatingServiceImpl();
	
	public String modifyProjectData() {
		data.setRecordModifyDate(new Timestamp(new Date().getTime()));
		try {
			service.modifyProjectData(data);
			data = service.viewProjectDataDetail(data.getId().toString());
		} catch (NumberFormatException e) {
			LOG.error(e);
			msg = "数据错误";
		} catch (SQLException e) {
			LOG.error(e);
			msg = "数据错误";
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

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}

