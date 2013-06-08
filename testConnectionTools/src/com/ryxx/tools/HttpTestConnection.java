/**
 * 
 */
package com.ryxx.tools;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import org.apache.log4j.Logger;

import com.ryxx.bean.ParamBean;

/**
 * @author Delgado Ding
 *
 */
public class HttpTestConnection {
	
	private static Logger logger = Logger.getLogger(HttpTestConnection.class);

	public static String getResult(String urlStr, List<ParamBean> paramList)
			throws Exception {
		URL url = null;
		HttpURLConnection connection = null;
		try {
			url = new URL(urlStr);
			connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setRequestMethod("POST");
			connection.setUseCaches(false);
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < paramList.size(); i++) {
				sb
						.append(URLEncoder.encode(paramList.get(i).getKey(),
								"UTF-8"));
				sb.append("=");
				sb.append(URLEncoder.encode(paramList.get(i).getValue(),
						"UTF-8"));
				if (i == 0 && paramList.size() > 1)
					sb.append("&&");
			}
			connection.connect();
			DataOutputStream out = new DataOutputStream(connection
					.getOutputStream());
			out.write(sb.toString().getBytes("utf-8"));
			out.flush();
			out.close();

			if (connection.getResponseCode() != 200) {
				logger.error(connection.getResponseCode());
				logger.error(connection.getResponseMessage());
				String errorMessage = connection.getResponseMessage();
				throw new Exception(errorMessage);
			}
			return null;
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
	}
}
