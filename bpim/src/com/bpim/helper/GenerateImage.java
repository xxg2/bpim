/*
 * Created on 2004-10-15
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.bpim.helper;

import java.util.Random;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * @author
 * 
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 * ImageIO.write(objGen.getImage(), "JPEG", response.getOutputStream())
 */
public class GenerateImage {

	public GenerateImage() {
	}

	public String getRand() {
		return m_sbRand.toString();
	}

	public Color getRandColor(int fc, int bc) { // 给定范围获得随机颜色
		Random random = new Random();
		if (fc > 255)
			fc = 255;
		if (bc > 255)
			bc = 255;
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}

	public BufferedImage creatImage() {
		return creatImage(4); // def
	}

	public BufferedImage creatImage(int size) {
		StringBuffer sbRand = new StringBuffer();
		// 生成随机类
		Random random = new Random();
		// 取随机产生的认证码(size位数字)

		for (int i = 0; i < size; i++)
			sbRand.append(random.nextInt(10));
		return creatImage(sbRand.toString());
	}

	public BufferedImage creatImage(String value) {
		if (value == null) {
			return null;
		}

		int size = value.length();
		m_sbRand = new StringBuffer();
		m_sbRand.append(value);

		// 在内存中创建图象
		int width = 60, height = 20;
		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);

		// 获取图形上下文
		Graphics g = image.getGraphics();

		// 生成随机类
		Random random = new Random();

		// 设定背景色
		g.setColor(getRandColor(200, 250));
		g.fillRect(0, 0, width, height);

		// 设定字体
		g.setFont(new Font("Times New Roman", Font.PLAIN, 18));

		// 画边框
		// g.setColor(new Color());
		// g.drawRect(0,0,width-1,height-1);

		// 随机产生155条干扰线，使图象中的认证码不易被其它程序探测到
		g.setColor(getRandColor(160, 200));
		for (int i = 0; i < 155; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int xl = random.nextInt(12);
			int yl = random.nextInt(12);
			g.drawLine(x, y, x + xl, y + yl);
		}

		// 取随机产生的认证码(4位数字)
		// String rand = request.getParameter("rand");
		// rand = rand.substring(0,rand.indexOf("."));

		for (int i = 0; i < size; i++) {
			String str = String.valueOf(value.charAt(i));
			// 将认证码显示到图象中
			g.setColor(new Color(20 + random.nextInt(110), 20 + random
					.nextInt(110), 20 + random.nextInt(110))); // 调用函数出来的颜色相同，可能是因为种子太接近，所以只能直接生成
			g.drawString(str, 13 * i + 6, 16);
		}
		// 图象生效
		g.dispose();
		return image;
	}

	private StringBuffer m_sbRand;

}