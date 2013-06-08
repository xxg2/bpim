package com.bpim.service;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;

/**
 * author Delgado
 */
public interface ExcelDataService {

	String processUserProjectData(File uploadUserProjectData, String area,
			Timestamp projectDate, String uploadUserProjectDataType,
			String uploadUserProjectDataInput, Long userId) throws IOException;

	String processUserCustomData(File uploadUserCustomData, String area,
			String uploadUserCustomDataInput, Long userId, String type) throws IOException;

}
