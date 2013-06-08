package com.bpim.web.action.admin;

import java.io.File;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bpim.service.GovernmentFileService;
import com.bpim.service.GovernmentFileServiceImpl;
import com.bpim.web.action.ActionSupportBase;

public class GovernmentFileAction extends ActionSupportBase {
	private static final long serialVersionUID = -1781372665512868821L;

	private String fileType = "";
	private String fileSubType = "";
	private String provice = "";
	private File importGovernmentFile;
	private String importGovernmentFileInput="";
	private String msg="";
	
	private static final Log LOG = LogFactory.getLog(GovernmentFileAction.class);

	private GovernmentFileService service = new GovernmentFileServiceImpl();

	public String importGovernmentFile() {
		if(!"".equals(importGovernmentFileInput)&&!importGovernmentFileInput.endsWith("html")){
			msg = "文件格斯不对";
			return SUCCESS;
		}
		try {
			msg = service.importGovernmentFile(fileType, fileSubType, provice,
					importGovernmentFile);
		} catch (Exception e) {
			LOG.error(e);
			msg = "出错了，请将excel重新保存一次再试";
		}
		return SUCCESS;
	}

	/**
	 * @return the fileType
	 */
	public String getFileType() {
		return fileType;
	}

	/**
	 * @param fileType the fileType to set
	 */
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	/**
	 * @return the fileSubType
	 */
	public String getFileSubType() {
		return fileSubType;
	}

	/**
	 * @param fileSubType the fileSubType to set
	 */
	public void setFileSubType(String fileSubType) {
		this.fileSubType = fileSubType;
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

	/**
	 * @return the importGovernmentFile
	 */
	public File getImportGovernmentFile() {
		return importGovernmentFile;
	}

	/**
	 * @param importGovernmentFile the importGovernmentFile to set
	 */
	public void setImportGovernmentFile(File importGovernmentFile) {
		this.importGovernmentFile = importGovernmentFile;
	}

	/**
	 * @return the importGovernmentFileInput
	 */
	public String getImportGovernmentFileInput() {
		return importGovernmentFileInput;
	}

	/**
	 * @param importGovernmentFileInput the importGovernmentFileInput to set
	 */
	public void setImportGovernmentFileInput(String importGovernmentFileInput) {
		this.importGovernmentFileInput = importGovernmentFileInput;
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
	 * @return the service
	 */
	public GovernmentFileService getService() {
		return service;
	}

	/**
	 * @param service the service to set
	 */
	public void setService(GovernmentFileService service) {
		this.service = service;
	}
	
	
	
	
}