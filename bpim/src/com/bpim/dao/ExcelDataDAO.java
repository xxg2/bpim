package com.bpim.dao;

import java.sql.SQLException;
import java.util.List;

import com.bpim.entity.CustomAndGuideData;
import com.bpim.entity.UserProjectUploadData;


/**
 * author Delgado
 */
public interface ExcelDataDAO {

	void importUserProjectDataToDB(List<UserProjectUploadData> dataList) throws SQLException;

	void importCustomProjectDataToDB(List<CustomAndGuideData> dataList, String type) throws SQLException;



}

