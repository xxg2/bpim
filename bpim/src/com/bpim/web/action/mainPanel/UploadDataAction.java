package com.bpim.web.action.mainPanel;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bpim.common.Constants;
import com.bpim.service.ExcelDataService;
import com.bpim.service.ExcelDataServiceImpl;
import com.bpim.web.action.ActionSupportBase;
import com.bpim.web.action.LoginAction;

public class UploadDataAction extends ActionSupportBase {
	private static final long serialVersionUID = -1781372665512868821L;

	private String msg;

	private File uploadUserProjectData;
	private String uploadUserProjectDataYear;
	private String uploadUserProjectDataMonth;
	private String uploadUserProjectDataProvice;
	private String uploadUserProjectDataCity;
	private String uploadUserProjectDataType;
	private String uploadUserProjectDataInput;

	private long maxLength = 1024 * 1024;

	private static final Log LOG = LogFactory.getLog(LoginAction.class);

	private ExcelDataService service = new ExcelDataServiceImpl();

	public String uploadUserProjectData() {
		if (!valdate(uploadUserProjectData, uploadUserProjectDataInput)) {
			return SUCCESS;
		}
		Long userId = (Long) session.get(Constants.LOGIN_USER_ID);

		String area = getArea();

		try {
			Timestamp projectDate = getProjectDate();
			msg = service.processUserProjectData(uploadUserProjectData, area,
					projectDate, uploadUserProjectDataType,
					uploadUserProjectDataInput, userId);
		} catch (IOException e) {
			LOG.error(e);
			msg = "出错了，请联系管理员";
		} catch (ParseException e) {
			LOG.error(e);
			msg = "出错了，请联系管理员";
		} catch (Exception e) {
			LOG.error(e);
			msg = "出错了，请将excel重新保存一次再试";
		}
		return SUCCESS;
	}

	private String getArea() {
		if (null == uploadUserProjectDataCity
				|| "0".equals(uploadUserProjectDataCity)
				|| "".equals(uploadUserProjectDataCity)) {
			return uploadUserProjectDataProvice;
		}
		return uploadUserProjectDataProvice + " " + uploadUserProjectDataCity;
	}

	private Timestamp getProjectDate() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		Date tempProjectDate = sdf.parse(uploadUserProjectDataYear + "-"
				+ uploadUserProjectDataMonth);
		return new Timestamp(tempProjectDate.getTime());
	}

	private boolean valdate(File file, String fileName) {
		if (uploadUserProjectData == null) {
			msg = "未找到文件，如果您上传了文件，请更换浏览器再试";
			return false;
		}
		if (!fileName.toLowerCase().endsWith("xls")
				&& !fileName.toLowerCase().endsWith("xlsx")) {
			msg = "请上传excel文件";
			return false;
		} else if (file.length() > maxLength) {
			msg = "文件太大，请重新修改";
			return false;
		}
		if (uploadUserProjectDataProvice == "0"
				&& uploadUserProjectDataCity == "0") {
			msg = "请选择地区";
			return false;
		}
		return true;
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
	 * @return the uploadUserProjectData
	 */
	public File getUploadUserProjectData() {
		return uploadUserProjectData;
	}

	/**
	 * @param uploadUserProjectData
	 *            the uploadUserProjectData to set
	 */
	public void setUploadUserProjectData(File uploadUserProjectData) {
		this.uploadUserProjectData = uploadUserProjectData;
	}

	/**
	 * @return the uploadUserProjectDataYear
	 */
	public String getUploadUserProjectDataYear() {
		return uploadUserProjectDataYear;
	}

	/**
	 * @param uploadUserProjectDataYear
	 *            the uploadUserProjectDataYear to set
	 */
	public void setUploadUserProjectDataYear(String uploadUserProjectDataYear) {
		this.uploadUserProjectDataYear = uploadUserProjectDataYear;
	}

	/**
	 * @return the uploadUserProjectDataMonth
	 */
	public String getUploadUserProjectDataMonth() {
		return uploadUserProjectDataMonth;
	}

	/**
	 * @param uploadUserProjectDataMonth
	 *            the uploadUserProjectDataMonth to set
	 */
	public void setUploadUserProjectDataMonth(String uploadUserProjectDataMonth) {
		this.uploadUserProjectDataMonth = uploadUserProjectDataMonth;
	}

	/**
	 * @return the uploadUserProjectDataProvice
	 */
	public String getUploadUserProjectDataProvice() {
		return uploadUserProjectDataProvice;
	}

	/**
	 * @param uploadUserProjectDataProvice
	 *            the uploadUserProjectDataProvice to set
	 */
	public void setUploadUserProjectDataProvice(
			String uploadUserProjectDataProvice) {
		this.uploadUserProjectDataProvice = uploadUserProjectDataProvice;
	}

	/**
	 * @return the uploadUserProjectDataCity
	 */
	public String getUploadUserProjectDataCity() {
		return uploadUserProjectDataCity;
	}

	/**
	 * @param uploadUserProjectDataCity
	 *            the uploadUserProjectDataCity to set
	 */
	public void setUploadUserProjectDataCity(String uploadUserProjectDataCity) {
		this.uploadUserProjectDataCity = uploadUserProjectDataCity;
	}

	/**
	 * @return the uploadUserProjectDataType
	 */
	public String getUploadUserProjectDataType() {
		return uploadUserProjectDataType;
	}

	/**
	 * @param uploadUserProjectDataType
	 *            the uploadUserProjectDataType to set
	 */
	public void setUploadUserProjectDataType(String uploadUserProjectDataType) {
		this.uploadUserProjectDataType = uploadUserProjectDataType;
	}

	/**
	 * @return the uploadUserProjectDataInput
	 */
	public String getUploadUserProjectDataInput() {
		return uploadUserProjectDataInput;
	}

	/**
	 * @param uploadUserProjectDataInput
	 *            the uploadUserProjectDataInput to set
	 */
	public void setUploadUserProjectDataInput(String uploadUserProjectDataInput) {
		this.uploadUserProjectDataInput = uploadUserProjectDataInput;
	}

}