package com.bpim.web.action;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bpim.common.Constants;
import com.bpim.entity.ExpenseRecord;
import com.bpim.entity.UserInfo;
import com.bpim.helper.PageTools;
import com.bpim.helper.ParamTools;
import com.bpim.service.ExpenseRecordService;
import com.bpim.service.ExpenseRecordServiceImpl;
import com.bpim.service.UserInfoService;

public class ExpenseRecordAction extends ActionSupportBase {
	private static final long serialVersionUID = -5620230655376038210L;

	private static final Log LOG = LogFactory.getLog(LoginAction.class);

	private ExpenseRecordService expenseRecordService = new ExpenseRecordServiceImpl();
	
	private List<ExpenseRecord> expenseRecords;
	private String selection;
	
	public String getSelection() {
		return selection;
	}

	public void setSelection(String selection) {
		this.selection = selection;
	}

	private PageTools page;
	
	public PageTools getPage() {
		return page;
	}

	public void setPage(PageTools page) {
		this.page = page;
	}

	public String listExpenseRecords() {
		try {
			int pageNo = ParamTools.getIntParameter(request,
					Constants.PARA_PAGE_NO, 1);
			int pageSize = ParamTools.getIntParameter(request,
					Constants.PARA_PAGE_SIZE, 0);
			PageTools page = new PageTools(pageNo, pageSize);
			ExpenseRecord expenseRecord = new ExpenseRecord();
			expenseRecord.setSelection(selection);
			expenseRecord.setRowCount(pageNo);
			expenseRecord.setPageSize(pageSize);
			expenseRecords = expenseRecordService.listPage(expenseRecord, page);
			if (expenseRecords != null && expenseRecords.size() > 0) {
				this.page = page;
			} else {
				super.addNotFoundErrorMsg();
				return SUCCESS;
			}
		} catch (Exception ex) {
			LOG.error("UserInfoAction error: ", ex);
			super.addErrorMsg(ex.getMessage());
			ex.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}

	public ExpenseRecordService getExpenseRecordService() {
		return expenseRecordService;
	}

	public void setExpenseRecordService(ExpenseRecordService expenseRecordService) {
		this.expenseRecordService = expenseRecordService;
	}

	public List<ExpenseRecord> getExpenseRecords() {
		return expenseRecords;
	}

	public void setExpenseRecords(List<ExpenseRecord> expenseRecords) {
		this.expenseRecords = expenseRecords;
	}
}
