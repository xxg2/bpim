package com.bpim.web.action.mainPanel;

import java.util.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.bpim.entity.CustomAndGuideData;
import com.bpim.service.CustomAndGuideDataService;
import com.bpim.service.CustomAndGuideDataServiceImpl;
import com.bpim.web.action.ActionSupportBase;

/**
 * author Delgado
 */
public class ModifyCustomDataAction extends ActionSupportBase{
	
	private static final long serialVersionUID = -7378102065744956075L;
	CustomAndGuideData data = new CustomAndGuideData();
	String recordDate;
	CustomAndGuideDataService service = new CustomAndGuideDataServiceImpl();
	String msg = "修改成功";
	
	public String modifyCustomData(){
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
			Date date = sdf.parse(recordDate);
			data.setRecordDate(new Timestamp(date.getTime()));
			data.setRecordModifyDate(new Timestamp(new Date().getTime()));
			service.updateCustomData(data);
			data = service.queryCustomDataDetail(data.getId().toString());
		} catch (NumberFormatException e) {
			LOG.error(e);
			msg = "修改失败";
		} catch (SQLException e) {
			LOG.error(e);
			msg = "修改失败";
		} catch (ParseException e) {
			LOG.error(e);
			msg = "日期格式不对";
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

	/**
	 * @return the recordDate
	 */
	public String getRecordDate() {
		return recordDate;
	}

	/**
	 * @param recordDate the recordDate to set
	 */
	public void setRecordDate(String recordDate) {
		this.recordDate = recordDate;
	}
	
	
}

