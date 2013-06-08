package com.bpim.service;

import java.sql.SQLException;
import java.util.List;

import com.bpim.entity.UserProjectUploadData;
import com.bpim.form.SearchDataCondition;
import com.bpim.helper.PageTools;

/**
 * author Delgado
 */
public interface UserProjectDataOperatingService {

	List<UserProjectUploadData> searchProjectDataByCondition(
			SearchDataCondition condition, PageTools page) throws SQLException;

	UserProjectUploadData viewProjectDataDetail(String id) throws NumberFormatException, SQLException;

	void modifyProjectData(UserProjectUploadData data) throws SQLException;

}

