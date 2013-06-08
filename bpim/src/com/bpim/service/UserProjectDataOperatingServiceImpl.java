package com.bpim.service;

import java.sql.SQLException;
import java.util.List;

import com.bpim.common.DBConnUtil;
import com.bpim.common.PropertyConstants;
import com.bpim.dao.UserProjectDataOperatingDAO;
import com.bpim.dao.UserProjectDataOperatingDAOImpl;
import com.bpim.entity.UserInfo;
import com.bpim.entity.UserProjectUploadData;
import com.bpim.form.SearchDataCondition;
import com.bpim.helper.PageTools;


/**
 * author Delgado
 */
public class UserProjectDataOperatingServiceImpl implements
		UserProjectDataOperatingService {
	UserProjectDataOperatingDAO dao = new UserProjectDataOperatingDAOImpl();

	public List<UserProjectUploadData> searchProjectDataByCondition(
			SearchDataCondition condition, PageTools page) throws SQLException {
		DBConnUtil.getConnection();
		if (page != null) {
			if (page.getRecordCount() == 0) {
				int count = dao.getRowCount(condition);
				page.setRecordCount(count);
			}
			condition.setStartRow(page.getPageStartRow());
			condition.setPageSize(page.getPageSize());
		}
		List<UserProjectUploadData> uploadData = dao.searchProjectDataByCondition(condition);
		DBConnUtil.close();
		return uploadData;
	}
	
	public String deleteData(String id){
		String msg = PropertyConstants.DELETESUCCESS;
		try {
			DBConnUtil.getConnection();
			DBConnUtil.startTransaction(true);
			dao.deleteData(id);
			DBConnUtil.close();
		} catch (SQLException e) {
			msg = PropertyConstants.DELETEFAILED;
		}
		return msg;
	}
	public String deleteDatas(String[] ids){
		String msg="删除成功";
		try {
			DBConnUtil.getConnection();
			DBConnUtil.startTransaction(true);
			for(int i=0;i<ids.length;i++){
				dao.deleteData(ids[i]);
			}
			DBConnUtil.close();
		} catch (SQLException e) {
			msg = "删除失败，请联系管理员";
		}
		return msg;
	}

	public UserProjectUploadData viewProjectDataDetail(String id) throws NumberFormatException, SQLException {
		DBConnUtil.getConnection();
		UserProjectUploadData data = dao.viewProjectDataDetail(id);
		DBConnUtil.close();
		return data;
	}

	public void modifyProjectData(UserProjectUploadData data) throws SQLException {
		DBConnUtil.getConnection();
		DBConnUtil.startTransaction(true);
		dao.modifyProjectData(data);
		DBConnUtil.close();
	}

}

