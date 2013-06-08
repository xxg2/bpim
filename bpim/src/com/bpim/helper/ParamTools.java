package com.bpim.helper;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.bpim.common.Constants;

public class ParamTools {

	/**
	 * <p>
	 * 从请求中取得指定名称的boolean型变量值，如果请求中没有则赋予缺省值
	 * </p>
	 * 
	 * @param request
	 * @param param
	 *            变量名
	 * @param defaultvalue
	 *            缺省值
	 * @return
	 */
	public static boolean getBoolParameter(HttpServletRequest request,
			String param, boolean defaultvalue) {
		String value = request.getParameter(param);
		if (null == value) {
			return defaultvalue;
		}
		if ("0".equals(value) || "false".equals(value.toLowerCase())) {
			return false;
		}
		return true;
	}

	/**
	 * <p>
	 * 从请求中取得指定名称的java.util.Date型变量值，如果请求中没有则赋予缺省值
	 * </p>
	 * 
	 * @param request
	 * @param param
	 *            变量名
	 * @param defaultValue
	 *            变量名
	 * @return
	 */
	public static java.util.Date getDateParameter(HttpServletRequest request,
			String param, java.util.Date defaultValue) {
		String value = request.getParameter(param);
		if (null == value) {
			return defaultValue;
		}
		SimpleDateFormat formator = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date result;
		try {
			result = formator.parse(value);
		} catch (Exception e) {
			try {
				formator = null;
				formator = new SimpleDateFormat("yyyy-MM-dd");
				result = formator.parse(value);
			} catch (Exception e2) {
				result = defaultValue;
			}
		}
		return result;
	}

	/**
	 * <p>
	 * 从请求中取得指定名称的java.util.Date型变量值，如果请求中没有则赋予缺省值
	 * </p>
	 * 
	 * @param request
	 * @param param
	 * @param defaultValue
	 * @return
	 */
	public static java.util.Date getDateParameter(HttpServletRequest request,
			String param, String defaultValue) {
		return getDateParameter(request, param, StringTools.string2date(defaultValue));
	}

	/**
	 * <p>
	 * 从请求中取得指定名称的java.util.Date型变量值，如果请求中没有则返回null
	 * </p>
	 * 
	 * @param request
	 * @param param
	 * @return
	 */
	public static java.util.Date getDateParameter(HttpServletRequest request,
			String param) {
		String value = request.getParameter(param);
		
		if (null == value) {
			return null;
		}
		java.text.SimpleDateFormat formator = new java.text.SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		java.util.Date result;
		try {
			result = formator.parse(value);
		} catch (Exception e) {
			result = null;
		}
		return result;
	}

	/**
	 * <p>
	 * 从请求中取得指定名称的变量值，如果请求中没有则赋予缺省值
	 * </p>
	 * 
	 * @param request
	 * @param param
	 * @param defaultValue
	 * @return
	 */
	public static String getParameter(HttpServletRequest request, String param,
			String defaultValue) {
		String value = request.getParameter(param);
		if (value == null)
			return defaultValue;
		else
			return value;
	}

	/**
	 * <p>
	 * 从请求中取得指定名称的long[]型变量值，如果请求中没有则赋予缺省值填充的long[]
	 * </p>
	 * 
	 * @param request
	 * @param name
	 * @param defaultNum
	 * @return
	 */
	public static long[] getLongParameters(HttpServletRequest request,
			String name, long defaultNum) {
		String[] paramValues = request.getParameterValues(name);
		if (paramValues == null) {
			return null;
		}
		if (paramValues.length < 1) {
			return new long[0];
		}
		long[] values = new long[paramValues.length];
		for (int i = 0; i < paramValues.length; i++) {
			try {
				values[i] = Long.parseLong(paramValues[i]);
			} catch (Exception e) {
				values[i] = defaultNum;
			}
		}
		return values;
	}

	/**
	 * <p>
	 * 从请求中取得指定名称的long型变量值，如果请求中没有则赋予缺省值
	 * </p>
	 * 
	 * @param request
	 * @param name
	 * @param defaultNum
	 * @return
	 */
	public static long getLongParameter(HttpServletRequest request,
			String name, long defaultNum) {
		String temp = request.getParameter(name);
		if (temp != null && !temp.equals("")) {
			long num = defaultNum;
			try {
				num = Long.parseLong(temp);
			} catch (Exception ignored) {
			}
			return num;
		} else {
			return defaultNum;
		}
	}

	/**
	 * <p>
	 * 从请求中取得指定名称的long型变量值
	 * </p>
	 * 
	 * @param request
	 * @param param
	 * @return
	 * @throws NumberFormatException
	 */
	public static long getLongParameter(HttpServletRequest request, String param)
			throws NumberFormatException {
		try {
			long value = Long.parseLong(request.getParameter(param));
			return value;
		} catch (NumberFormatException ex) {
			throw new NumberFormatException();
		}

	}

	/**
	 * <p>
	 * 从请求中取得指定名称的int[]型变量值，如果请求中没有则赋予缺省值填充的int[]
	 * </p>
	 * 
	 * @param request
	 * @param name
	 * @param defaultNum
	 * @return
	 */
	public static int[] getIntParameters(HttpServletRequest request,
			String name, int defaultNum) {
		String[] paramValues = request.getParameterValues(name);
		if (paramValues == null) {
			return null;
		}
		if (paramValues.length < 1) {
			return new int[0];
		}
		int[] values = new int[paramValues.length];
		for (int i = 0; i < paramValues.length; i++) {
			try {
				values[i] = Integer.parseInt(paramValues[i]);
			} catch (Exception e) {
				values[i] = defaultNum;
			}
		}
		return values;
	}

	/**
	 * <p>
	 * 从请求中取得指定名称的int型变量值，如果请求中没有则赋予缺省值
	 * </p>
	 * 
	 * @param request
	 * @param name
	 * @param defaultNum
	 * @return
	 */
	public static int getIntParameter(HttpServletRequest request, String name,
			int defaultNum) {

		String temp = request.getParameter(name);
		if (temp != null && !temp.equals("")) {
			int num = defaultNum;
			try {
				num = Integer.parseInt(temp);
			} catch (Exception ignored) {
			}
			return num;
		} else {
			return defaultNum;
		}
	}

	/**
	 * <p>
	 * 从请求中取得指定名称的int型变量值
	 * </p>
	 * 
	 * @param request
	 * @param param
	 * @return
	 * @throws NumberFormatException
	 */
	public static int getIntParameter(HttpServletRequest request, String param)
			throws NumberFormatException {
		try {
			int value = Integer.parseInt(request.getParameter(param));
			return value;
		} catch (NumberFormatException ex) {
			throw new NumberFormatException();
		}

	}

	/**
	 * <p>
	 * 从请求中取得指定名称的double型变量值，如果请求中没有则赋予缺省值
	 * </p>
	 * 
	 * @param request
	 * @param name
	 * @param defaultNum
	 * @return
	 */
	public static double getDoubleParameter(HttpServletRequest request,
			String name, double defaultNum) {
		String temp = request.getParameter(name);
		if (temp != null && !temp.equals("")) {
			double num = defaultNum;
			try {
				num = Double.parseDouble(temp);
			} catch (Exception ignored) {
			}
			return num;
		} else {
			return defaultNum;
		}
	}

	/**
	 * <p>
	 * 从会话中取得指定名称的变量值，如果请求中没有则赋予缺省值
	 * </p>
	 * 
	 * @param session
	 * @param attribute
	 * @param defaultValue
	 * @return
	 */
	public static String getSessionValue(HttpSession session, String attribute,
			String defaultValue) {
		String svalue = null;
		try {
			svalue = (String) session.getAttribute(attribute);
		} catch (Exception e) {
			svalue = null;
			e.printStackTrace();
		}

		if (svalue == null)
			return defaultValue;
		else
			return svalue;
	}

	/**
	 * <p>
	 * 从会话中取得指定名称的long型变量值，如果请求中没有则赋予缺省值
	 * </p>
	 * 
	 * @param session
	 * @param attribute
	 * @param defaultValue
	 * @return
	 */
	public static long getLongSessionValue(HttpSession session,
			String attribute, long defaultValue) {
		String svalue = getSessionValue(session, attribute, null);
		if (svalue != null) {
			try {
				long value = Long.parseLong(svalue);
				return value;
			} catch (NumberFormatException ex) {
				return defaultValue;
			}
		} else {
			return defaultValue;
		}
	}

	/**
	 * <p>
	 * 从会话中取得指定名称的long型变量值
	 * </p>
	 * 
	 * @param session
	 * @param attribute
	 * @return
	 * @throws NumberFormatException
	 */
	public static long getLongSessionValue(HttpSession session, String attribute)
			throws NumberFormatException {
		try {
			long value = Long.parseLong((String) session
					.getAttribute(attribute));
			return value;
		} catch (NumberFormatException ex) {
			throw new NumberFormatException();
		}
	}
	
	public static String getProperty(HttpServletRequest request, String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream in = new FileInputStream(
				request.getRealPath("")
						+ Constants.PROPERTIES_FILE_PATH);
		prop.load(in);
		return (String) prop.getProperty(key);
	}

	public static void main(String[] args) {

	}
}
