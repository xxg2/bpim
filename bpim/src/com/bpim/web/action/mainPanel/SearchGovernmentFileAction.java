package com.bpim.web.action.mainPanel;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bpim.common.Constants;
import com.bpim.entity.GovernmentFile;
import com.bpim.form.SearchDataCondition;
import com.bpim.helper.PageTools;
import com.bpim.helper.ParamTools;
import com.bpim.service.GovernmentFileService;
import com.bpim.service.GovernmentFileServiceImpl;
import com.bpim.web.action.ActionSupportBase;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

/**
 * author Delgado
 */
public class SearchGovernmentFileAction extends ActionSupportBase {

	SearchDataCondition condition = new SearchDataCondition();
	GovernmentFileService service = new GovernmentFileServiceImpl();
	List<GovernmentFile> datas = new ArrayList<GovernmentFile>();
	String sourceCode = "";
	private PageTools page;

	public PageTools getPage() {
		return page;
	}

	public void setPage(PageTools page) {
		this.page = page;
	}

	public String viewGovernmentFile() {
		Long id = Long.valueOf(request.getParameter("id"));
		String keyword = request.getParameter("keyword");
		try {
			sourceCode = service.viewGovernmentFile(id);
		} catch (SQLException e) {
			LOG.error(e);
		}
		PrintWriter pw = null;
		try {
			pw = response.getWriter();
		} catch (IOException e) {
			LOG.error(e);
		}
		if (!StringUtils.isBlank(keyword)) {
			keyword = keyword.replace("\5", "&#");
			sourceCode = sourceCode.replace(keyword,
					"<span style='background:yellow'>" + keyword + "</span>");
		}
		pw.println(sourceCode);
		pw.println("</body></html>");
		return SUCCESS;
	}

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
		return paramStr;
	}

	public String searchGovernmentFile() {
		try {
			int pageNo = ParamTools.getIntParameter(request,
					Constants.PARA_PAGE_NO, 1);
			int pageSize = ParamTools.getIntParameter(request,
					Constants.PARA_PAGE_SIZE, 0);
			PageTools page = new PageTools(pageNo, pageSize);
			condition.setRowCount(pageNo);
			condition.setPageSize(pageSize);
			condition.setKeyword(toUnicode(condition.getKeyword()));
			setQueryDate(condition);
			datas = service.searchGovernmentFile(condition, page);
			condition.setKeyword(compileCode(condition.getKeyword()));
			if (datas != null && datas.size() > 0) {
				this.page = page;
			} else {
				super.addNotFoundErrorMsg();
				return SUCCESS;
			}
		} catch (ParseException e) {
			LOG.error(e);
		} catch (SQLException e) {
			LOG.error(e);
		}
		return SUCCESS;
	}

	public static String toUnicode(String s) {
		String as[] = new String[s.length()];
		String s1 = "";
		String result = "";
		for (int i = 0; i < s.length(); i++) {
			as[i] = Integer.toHexString(s.charAt(i) & 0xffff);
			int i1 = Integer.parseInt(as[i], 16);
			s1 = String.valueOf(i1);
			result = result + "&#" + s1 + ";";
		}

		return result;
	}

	private void setQueryDate(SearchDataCondition condition)
			throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		if (!"0".equals(condition.getFilePublishYear())) {
			Date filePublishDateFrom;
			Date filePublishDateTo;
			if (!"0".equals(condition.getFilePublishMonth())) {
				filePublishDateFrom = sdf.parse(condition.getFilePublishYear()
						+ "-" + condition.getFilePublishMonth());
				filePublishDateTo = sdf
						.parse(condition.getFilePublishYear()
								+ "-"
								+ (Integer.valueOf(condition
										.getFilePublishMonth()) + 1));
			} else {
				filePublishDateFrom = sdf.parse(condition.getFilePublishYear()
						+ "-" + "1");
				filePublishDateTo = sdf.parse((Integer.valueOf(condition
						.getFilePublishYear()) + 1) + "-" + "1");
			}
			condition.setFilePublishDateFrom(new Timestamp(filePublishDateFrom
					.getTime()));
			condition.setFilePublishDateTo(new Timestamp(filePublishDateTo
					.getTime()));
		}

		if (!"0".equals(condition.getFileEffectiveYear())) {
			Date fileEffectiveDateFrom;
			Date fileEffectiveDateTo;
			if (!"0".equals(condition.getFileEffectiveMonth())) {
				fileEffectiveDateFrom = sdf.parse(condition
						.getFileEffectiveYear()
						+ "-"
						+ condition.getFileEffectiveMonth());
				fileEffectiveDateTo = sdf
						.parse(condition.getFileEffectiveYear()
								+ "-"
								+ (Integer.valueOf(condition
										.getFileEffectiveMonth()) + 1));
			} else {
				fileEffectiveDateFrom = sdf.parse(condition
						.getFileEffectiveYear() + "-" + "1");
				fileEffectiveDateTo = sdf.parse((Integer.valueOf(condition
						.getFileEffectiveYear()) + 1) + "-" + "1");
			}
			condition.setFileEffectiveDateFrom(new Timestamp(
					fileEffectiveDateFrom.getTime()));
			condition.setFileEffectiveDateTo(new Timestamp(fileEffectiveDateTo
					.getTime()));
		}

	}

	/**
	 * @return the condition
	 */
	public SearchDataCondition getCondition() {
		return condition;
	}

	/**
	 * @param condition
	 *            the condition to set
	 */
	public void setCondition(SearchDataCondition condition) {
		this.condition = condition;
	}

	/**
	 * @return the datas
	 */
	public List<GovernmentFile> getDatas() {
		return datas;
	}

	/**
	 * @param datas
	 *            the datas to set
	 */
	public void setDatas(List<GovernmentFile> datas) {
		this.datas = datas;
	}

	/**
	 * @return the sourceCode
	 */
	public String getSourceCode() {
		return sourceCode;
	}

	/**
	 * @param sourceCode
	 *            the sourceCode to set
	 */
	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}

}
