package com.bpim.web.action.admin;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bpim.service.ExcelDataService;
import com.bpim.service.ExcelDataServiceImpl;
import com.bpim.web.action.ActionSupportBase;
import com.bpim.web.action.LoginAction;

public class UploadGuideDataAction extends ActionSupportBase {
	private static final long serialVersionUID = -1781372665512868821L;

	private String msg;

	private File uploadUserCustomData;
	private String uploadUserCustomDataProvice;
	private String uploadUserCustomDataCity;
	private String uploadUserCustomDataInput;

	private String type;
	private long maxLength = (long) (1024 * 1024 * 1.5);

	private static final Log LOG = LogFactory.getLog(UploadGuideDataAction.class);

	private ExcelDataService service = new ExcelDataServiceImpl();

	public String uploadGuideData() {
		if (!valdate(uploadUserCustomData, uploadUserCustomDataInput)) {
			return SUCCESS;
		}
		Long userId = (long) 0;
		
		String area = getArea();
		
		try {
			msg = service.processUserCustomData(uploadUserCustomData, area, uploadUserCustomDataInput,
					userId ,type);
		} catch (IOException e) {
			LOG.error(e);
			msg = "出错了，请联系管理员";
		} catch (Exception e) {
			LOG.error(e);
			msg = "出错了，请将excel重新保存一次再试";
		}
		return SUCCESS;
	}
	
	private String getArea() {
		if(null==uploadUserCustomDataCity||"0".equals(uploadUserCustomDataCity)||"".equals(uploadUserCustomDataCity)){
			return uploadUserCustomDataProvice;
		}
		return uploadUserCustomDataProvice+ " " + uploadUserCustomDataCity;
	}

	private boolean valdate(File file, String fileName) {
		if (!fileName.toLowerCase().endsWith("xls")
				&& !fileName.toLowerCase().endsWith("xlsx")) {
			msg = "请上传excel文件";
			return false;
		} else if (file.length() > maxLength) {
			msg = "文件太大，请重新修改";
			return false;
		}
		if (uploadUserCustomDataProvice == "0" && uploadUserCustomDataCity == "0") {
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
	 * @return the uploadUserCustomData
	 */
	public File getUploadUserCustomData() {
		return uploadUserCustomData;
	}

	/**
	 * @param uploadUserCustomData the uploadUserCustomData to set
	 */
	public void setUploadUserCustomData(File uploadUserCustomData) {
		this.uploadUserCustomData = uploadUserCustomData;
	}

	/**
	 * @return the uploadUserCustomDataProvice
	 */
	public String getUploadUserCustomDataProvice() {
		return uploadUserCustomDataProvice;
	}

	/**
	 * @param uploadUserCustomDataProvice the uploadUserCustomDataProvice to set
	 */
	public void setUploadUserCustomDataProvice(String uploadUserCustomDataProvice) {
		this.uploadUserCustomDataProvice = uploadUserCustomDataProvice;
	}

	/**
	 * @return the uploadUserCustomDataCity
	 */
	public String getUploadUserCustomDataCity() {
		return uploadUserCustomDataCity;
	}

	/**
	 * @param uploadUserCustomDataCity the uploadUserCustomDataCity to set
	 */
	public void setUploadUserCustomDataCity(String uploadUserCustomDataCity) {
		this.uploadUserCustomDataCity = uploadUserCustomDataCity;
	}

	/**
	 * @return the uploadUserCustomDataInput
	 */
	public String getUploadUserCustomDataInput() {
		return uploadUserCustomDataInput;
	}

	/**
	 * @param uploadUserCustomDataInput the uploadUserCustomDataInput to set
	 */
	public void setUploadUserCustomDataInput(String uploadUserCustomDataInput) {
		this.uploadUserCustomDataInput = uploadUserCustomDataInput;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	
	
}