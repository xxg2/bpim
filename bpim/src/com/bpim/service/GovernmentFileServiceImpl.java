package com.bpim.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.bpim.common.DBConnUtil;
import com.bpim.dao.GovernmentFileDAO;
import com.bpim.dao.GovernmentFileDAOImpl;
import com.bpim.entity.GovernmentFile;
import com.bpim.entity.UserProjectUploadData;
import com.bpim.form.SearchDataCondition;
import com.bpim.helper.PageTools;

/**
 * author Delgado
 */
public class GovernmentFileServiceImpl implements GovernmentFileService {
	GovernmentFileDAO dao = new GovernmentFileDAOImpl();

	public List<GovernmentFile> searchGovernmentFile(
			SearchDataCondition condition, PageTools page) throws SQLException {
		DBConnUtil.getConnection();
		if (page != null) {
			if (page.getRecordCount() == 0) {
				int count = dao.searchGovernmentFileCount(condition);
				page.setRecordCount(count);
			}
			condition.setStartRow(page.getPageStartRow());
			condition.setPageSize(page.getPageSize());
		}
		List<GovernmentFile> datas = dao.searchGovernmentFile(condition);
		DBConnUtil.close();
		return datas;
	}

	public String importGovernmentFile(String fileType, String fileSubType,
			String provice, File file) throws ParseException, SQLException {
		String fileName = file.getName();
		GovernmentFile data = new GovernmentFile();
		data.setFileType(fileType);
		data.setFileSubType(fileSubType);
		data.setArea(provice);
		data.setEffective(true);
		setAttr(data, fileName);
		data.setSourceCode(compileCode(readHtml(file.getAbsolutePath())));
		DBConnUtil.getConnection();
		DBConnUtil.startTransaction(false);
		dao.importGovernmentFile(data);

		DBConnUtil.endTransaction();
		DBConnUtil.close();
		return "导入成功";
	}

	public String readHtml(String filePath) {
		BufferedReader br = null;
		StringBuffer sb = new StringBuffer();
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(
					filePath), "UTF-8"));
			String temp = null;
			while ((temp = br.readLine()) != null) {
				sb.append(temp);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	private void setAttr(GovernmentFile data, String fileName)
			throws ParseException {
		int dotIndex = fileName.indexOf(".");
		fileName = fileName.substring(0, dotIndex).trim();

		int blankIndex = fileName.lastIndexOf(" ");
		String effectiveDateString = fileName.substring(blankIndex,
				fileName.length());
		fileName = fileName.substring(0, blankIndex).trim();
		String publishDateString = "";
		String fileTitle = "";
		if (fileName.endsWith("无")) {
			publishDateString = effectiveDateString;
			fileTitle = fileName.substring(0, fileName.length() - 1);
		} else if (fileName.endsWith("1") || fileName.endsWith("2")
				|| fileName.endsWith("3") || fileName.endsWith("4")
				|| fileName.endsWith("5") || fileName.endsWith("6")
				|| fileName.endsWith("7") || fileName.endsWith("8")
				|| fileName.endsWith("9") || fileName.endsWith("0")) {
			publishDateString = fileName.substring(fileName.length() - 10,
					fileName.length());
			fileTitle = fileName.substring(0, fileName.length() - 10);
		} else if (!fileName.endsWith("无") && !fileName.endsWith(" ")) {
			publishDateString = effectiveDateString;
			fileTitle = fileName.substring(0, fileName.length());
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date filePublishDime = sdf.parse(publishDateString);
		Date fileEffectiveDate = sdf.parse(effectiveDateString);

		data.setFileTitle(fileTitle);
		data.setFilePublishDate(new Timestamp(filePublishDime.getTime()));
		data.setFileEffectiveDate(new Timestamp(fileEffectiveDate.getTime()));
	}

	static final String mbs = "&amp;#(\\d+);"; // like "ロ"

	private String compileCode(String paramStr) {
		Pattern p = Pattern.compile("&#.*?;");
		Matcher m = p.matcher(paramStr);
		boolean rs = m.find();
		while (rs) {
			String aa = m.group();
			String str = aa.replaceAll("&#", ",").replaceAll(";", "");
			String[] s2 = str.split(",");
			String s1 = "";
			for (int i = 1; i < s2.length; i++) {
				int v = Integer.parseInt(s2[i], 10);
				s1 = s1 + (char) v;
				paramStr = paramStr.replace(aa, s1);
			}
			rs = m.find();
		}
		paramStr = paramStr.replace("7.0000pt", "12.0000pt");
		paramStr = paramStr.replace("8.0000pt", "12.0000pt");
		// System.out.println(paramStr);
		return paramStr;
	}

	public String viewGovernmentFile(Long id) throws SQLException {
		DBConnUtil.getConnection();
		String sourceCode = dao.viewGovernmentFile(id);
		DBConnUtil.close();
		return sourceCode;
	}

}
