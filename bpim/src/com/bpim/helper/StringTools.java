package com.bpim.helper;

import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringTools {
	public static int string2int(String value, int defaultVal) {
		try {
			if (value == null || value.length() < 1)
				return defaultVal;
			return Integer.parseInt(value);
		} catch (Exception e) {
			return defaultVal;
		}
	}
	
	public static Integer string2Integer(String value) {
		Integer iv = new Integer(string2int(value, 0));
		return iv;
	}
	
	public static long string2long(String value, long defaultVal) {
		try {
			return Long.parseLong(value);
		} catch (Exception e) {
			return defaultVal;
		}
	}
	
	public static Date string2date(String sDate) {
		return string2date(sDate, "yyyy-MM-dd HH:mm:ss");
	}
	
	public static Date string2date(String sDate, String sFormat) {
		SimpleDateFormat sf = new SimpleDateFormat(sFormat);
		try {
			Date date = sf.parse(sDate);
			return date;
		} catch (Exception ex) {
			return new Date();
		}
	}
	
	public static byte[] string2Byte(String s, int len) {
		byte[] b = new byte[len];
		for (int j = 0; j < len; j++) {
			b[j] = '\0';
		}
		if (s == null) {
			return b;
		}
		if (s.getBytes().length > len) {
			for (int i = 0; i < len; i++) {
				b[i] = s.getBytes()[i];
			}
		} else {
			for (int i = 0; i < s.getBytes().length; i++) {
				b[i] = s.getBytes()[i];
			}
		}
		return b;
	}
	
	public static String md5(String str) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());

			byte[] b = md.digest();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < b.length; i++) {
				int v = (int) b[i];
				v = v < 0 ? 0x100 + v : v;
				String cc = Integer.toHexString(v);
				if (cc.length() == 1)
					sb.append('0');
				sb.append(cc);
			}

			return sb.toString();
		} catch (Exception e) {

		}
		return "";
	}
}
