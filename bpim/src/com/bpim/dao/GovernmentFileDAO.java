package com.bpim.dao;

import java.sql.SQLException;
import java.util.List;

import com.bpim.entity.GovernmentFile;
import com.bpim.form.SearchDataCondition;

/**
 * author Delgado
 */
public interface GovernmentFileDAO {

	int searchGovernmentFileCount(SearchDataCondition condition) throws SQLException;

	List<GovernmentFile> searchGovernmentFile(SearchDataCondition condition) throws SQLException;

	void importGovernmentFile(GovernmentFile data) throws SQLException;

	String viewGovernmentFile(Long id) throws SQLException;

}

