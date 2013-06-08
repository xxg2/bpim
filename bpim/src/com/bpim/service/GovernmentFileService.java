package com.bpim.service;

import java.io.File;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.bpim.entity.GovernmentFile;
import com.bpim.form.SearchDataCondition;
import com.bpim.helper.PageTools;

/**
 * author Delgado
 */
public interface GovernmentFileService {

	List<GovernmentFile> searchGovernmentFile(SearchDataCondition condition,
			PageTools page) throws SQLException;

	String importGovernmentFile(String fileType, String fileSubType,
			String provice, File importGovernmentFile) throws ParseException, SQLException;

	String viewGovernmentFile(Long id) throws SQLException;

}

