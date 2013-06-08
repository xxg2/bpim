/**
 * Created on 2007-8-14 ����05:25:56
 * Title: PageTools.java <br/>
 * Description: <br/>
 * Copyright: Copyright (c) 2007 <br/>
 * @author Zongming.Zhong
 * @version Revision: 1.0 
 */
package com.bpim.helper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zongming.Zhong
 * 
 */
public class PageTools {
	private static final long serialVersionUID = 7504283456444302067L;

	private static final int PAGE_SIZE_DEFAULT = 10;

	private static final int PAGE_SIZE_MAX = 100;

	private boolean init;

	private boolean lastPage;

	private int pageNo;

	private int pageSize;

	private int recordCount;

	private int pageCount;

	private int pageStartRow;
	
	private List<Integer> pageList = new ArrayList<Integer>();

	public PageTools() {
		init = false;
		lastPage = false;
		pageNo = 1;
		pageSize = PAGE_SIZE_DEFAULT;
		recordCount = 0;
		pageCount = 0;
		pageStartRow = 0;
	}

	public PageTools(int pageNo, int pageSize) {
		init = false;
		lastPage = false;
		this.pageNo = pageNo < 1 ? 1 : pageNo;
		this.pageSize = pageSize < 1 ? PAGE_SIZE_DEFAULT : pageSize;
		recordCount = 0;
		pageCount = 0;
		pageStartRow = 0;
	}

	public PageTools(int recordCount, int pageNo, int pageSize) {
		init = false;
		lastPage = false;
		pageCount = 0;
		this.pageNo = pageNo < 1 ? 1 : pageNo;
		this.pageSize = pageSize < 1 ? PAGE_SIZE_DEFAULT : pageSize;
		this.recordCount = recordCount < 1 ? 0 : recordCount;
		pageStartRow = 0;
		initialize();
	}

	protected void initialize() {
		if (pageSize > PAGE_SIZE_MAX) {
			pageSize = PAGE_SIZE_MAX;
		}

		if (recordCount % pageSize == 0) {
			pageCount = recordCount / pageSize;
		} else {
			pageCount = recordCount / pageSize + 1;
		}
		
		for (int i=1; i<=pageCount; i++) {
			pageList.add(i);
		}
		
		if (pageNo >= pageCount) {
			pageNo = pageCount;
			lastPage = true;
		} else if (pageNo < 1) {
			pageNo = 1;
		}

		pageStartRow = (pageNo - 1) * pageSize;

		init = true;
	}

	public boolean isLastPage() {
		return lastPage;
	}

	public int getPageStartRow() {
		if (!init)
			initialize();
		return pageStartRow < 1 ? 0 : pageStartRow;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
		init = false;
		initialize();
	}

	public int getPageCount() {
		return pageCount;
	}

	public int getPageNo() {
		return pageNo;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// PageTools pt = new PageTools(101, 4, 20);
	}

	/**
	 * @return the pageList
	 */
	public List<Integer> getPageList() {
		return pageList;
	}

	/**
	 * @param pageList the pageList to set
	 */
	public void setPageList(List<Integer> pageList) {
		this.pageList = pageList;
	}

}
