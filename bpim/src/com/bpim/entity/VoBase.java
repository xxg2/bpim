/**
 * Created on 2007-8-23 ����11:12:01
 * Title: VoBase.java <br/>
 * Description: ��Ҫ���ڷ�ҳ��ʾ���ò���<br/>
 * Copyright: Copyright (c) 2007 <br/>
 * @author Zongming.Zhong
 * @version Revision: 1.0 
 */
package com.bpim.entity;

import java.io.Serializable;

/**
 * @author Zongming.Zhong
 * 
 */
public class VoBase implements Serializable {
	private static final long serialVersionUID = -3110369113626738202L;

	private int startRow;

	private int pageSize;

	private int rowCount;

	/**
	 * @return the rowCount
	 */
	public int getRowCount() {
		return rowCount;
	}

	/**
	 * @param rowCount
	 *            the rowCount to set
	 */
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize
	 *            the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return the startRow
	 */
	public int getStartRow() {
		return startRow;
	}

	/**
	 * @param startRow
	 *            the startRow to set
	 */
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
}
