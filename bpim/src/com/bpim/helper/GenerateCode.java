package com.bpim.helper;

/**
 * <p>Title: DB Family</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Huasheng, Hangzhou</p>
 * @author Weijia.Sun
 * @version 0.9
 */
import java.util.Random;

public class GenerateCode {
	public GenerateCode() {
		this(mDEF_WIDTH);
	}

	public GenerateCode(int width) {
		this.setWidth(width);
		m_iToken = 0;
		m_strCoden = new String("");
		this.gen();
	}

	public void setWidth(int width) {
		if (width < 1)
			m_iWidth = mDEF_WIDTH;
		else
			m_iWidth = width;
	}

	public int getWidth() {
		return m_iWidth;
	}

	public void gen() {
		int value;
		int n = 10;
		Random _random = new Random();
		String s = new String("");
		for (int i = 0; i < this.getWidth(); i++) {
			value = _random.nextInt(n);
			s += String.valueOf(value);
		}
		m_iToken = _random.nextInt();
		m_strCoden = s;
		m_blnGen = true;
	}

	public String getCode() {
		if (!m_blnGen)
			this.gen();
		return m_strCoden;
	}

	public String getToken() {
		if (!m_blnGen)
			this.gen();
		return String.valueOf(m_iToken);
	}

	private final static int mDEF_WIDTH = 4;

	private int m_iWidth;

	private int m_iToken;

	private String m_strCoden;

	private boolean m_blnGen;

}