package com.bpim.web.action.admin;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bpim.service.CustomAndGuideDataService;
import com.bpim.service.CustomAndGuideDataServiceImpl;
import com.bpim.web.action.ActionSupportBase;

public class DeleteGuideDataAction extends ActionSupportBase {
	private static final long serialVersionUID = -1781372665512868821L;

	private String msg = "删除成功";
	private String year;
	private String month;
	private String provice;

	private static final Log LOG = LogFactory.getLog(DeleteGuideDataAction.class);

	private CustomAndGuideDataService service = new CustomAndGuideDataServiceImpl();

	public String deleteGuideData() {
		Timestamp dataDate;
		try {
			dataDate = getDate();
			service.deleteGuideData(dataDate, provice);
		} catch (ParseException e) {
			msg = "删除失败";
			LOG.error(e);
		} catch (SQLException e) {
			msg = "删除失败";
			LOG.error(e);
		}
		
		return SUCCESS;
	}
	
	
	private Timestamp getDate() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		if (!"0".equals(year)&&!"0".equals(month)) {
			Date temp = sdf.parse(year+"-"+month);
			return new Timestamp(temp.getTime());
		}
		return null;
	}


	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg
	 *            the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}


	/**
	 * @return the year
	 */
	public String getYear() {
		return year;
	}


	/**
	 * @param year the year to set
	 */
	public void setYear(String year) {
		this.year = year;
	}


	/**
	 * @return the month
	 */
	public String getMonth() {
		return month;
	}


	/**
	 * @param month the month to set
	 */
	public void setMonth(String month) {
		this.month = month;
	}


	/**
	 * @return the provice
	 */
	public String getProvice() {
		return provice;
	}


	/**
	 * @param provice the provice to set
	 */
	public void setProvice(String provice) {
		this.provice = provice;
	}

}