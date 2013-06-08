/**
 * 
 */
package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.zip.ZipOutputStream;

/**
 * @author Delgado Ding
 * 
 */
public class Main {

	static String inputFolderPath = "input/";
	static String outputFolderPath = "output/";
	static String lefthbmPath = "";
	static String encoding = "<meta http-equiv='Content-Type' content='text/html; charset=gb2312' />";
	static String icon = "<link href='../images/logo.ico' rel='SHORTCUT ICON' />";
	static String comments = "- Made by UNREGISTERED version of Easy CHM";
	static PinyinToolkit pinyin = new PinyinToolkit();

	static String lefthtmHeader = "";
	static String lefthtmBody = "";

	public static void main(String[] args) throws Exception {
		addIcon();
		String lefthtm = getLefthtmSource();
		addEncoding(lefthtm);
		removeComments();
		replaceHrefPathAndCacheToMap(lefthtmBody);
		rewriteToFile();
		renameFolderName(inputFolderPath);
		zipFile(inputFolderPath);
	}

	/**
	 * @throws IOException
	 * 
	 */
	private static void addIcon() throws IOException {
		File inputFolder = new File(inputFolderPath);
		File[] files = inputFolder.listFiles();
		String mainPageSource = "";
		String mainPagePath = "";
		for (File subFile : files) {
			if (subFile.isDirectory()) {
				File[] subfiles = subFile.listFiles();
				for (File subFile1 : subfiles) {
					if (subFile1.isFile()
							&& subFile1.getName().endsWith("html")) {
						mainPagePath = subFile1.getAbsolutePath();
						mainPageSource = getStringFromFile(mainPagePath);
					}
				}
			}
		}
		mainPageSource.replace("</HEAD>", icon + "</HEAD>");
		FileOutputStream fis = new FileOutputStream(mainPagePath);
		OutputStreamWriter isr = new OutputStreamWriter(fis, "gb2312");
		// OutputStreamWriter 封装到缓冲流中
		BufferedWriter br = new BufferedWriter(isr);
		br.write(mainPageSource);
		br.close();
	}

	private static void zipFile(String path) throws Exception {
		File rootPath = new File(path);
		for (File filePath : rootPath.listFiles()) {
			zip(outputFolderPath + filePath.getName() + ".zip", filePath);
		}
	}

	private static void zip(String zipFileName, File inputFile)
			throws Exception {
		ZipOutputStream out = new ZipOutputStream(new FileOutputStream(
				zipFileName));
		zip(out, inputFile, "");
		System.out.println("zip done");
		out.close();
	}

	private static void zip(ZipOutputStream out, File f, String base)
			throws Exception {
		if (f.isDirectory()) {
			File[] fl = f.listFiles();
			out.putNextEntry(new org.apache.tools.zip.ZipEntry(base + "/"));
			base = base.length() == 0 ? "" : base + "/";
			for (int i = 0; i < fl.length; i++) {
				zip(out, fl[i], base + fl[i].getName());
			}
		} else {
			out.putNextEntry(new org.apache.tools.zip.ZipEntry(base));
			FileInputStream in = new FileInputStream(f);
			int b;
			System.out.println(base);
			while ((b = in.read()) != -1) {
				out.write(b);
			}
			in.close();
		}
	}

	/**
	 * 
	 */
	private static void renameFolderName(String path) {
		File inputFolder = new File(path);
		File[] files = inputFolder.listFiles();
		String fileName = "";
		String fileRename = "";
		File tempFile = null;
		for (File subFile : files) {
			fileName = subFile.getAbsolutePath();
			fileRename = pinyin.cn2Spell(fileName);
			fileRename = normalFileName(fileRename);
			tempFile = new File(fileRename);
			subFile.renameTo(tempFile);
			if (tempFile.isDirectory()) {
				renameFolderName(fileRename);
			} else if (subFile.isDirectory()) {
				renameFolderName(fileName);
			}
		}
	}

	/**
	 * @param fileRename
	 */
	private static String normalFileName(String fileRename) {
		fileRename = fileRename.replace(".mht", ".htm");
		String[] strs = fileRename.split(":");
		if (strs != null && strs.length == 2) {
			return fileRename;
		} else if (strs != null && strs.length > 2) {
			StringBuilder sb = new StringBuilder("");
			for (int i = 0; i < strs.length; i++) {
				sb.append(strs[i]);
				if (i == 0) {
					sb.append(":");
				}
			}
			return sb.toString();
		}
		return fileRename;
	}

	/**
	 * @throws IOException
	 * 
	 */
	private static void rewriteToFile() throws IOException {
		FileOutputStream fis = new FileOutputStream(lefthbmPath);
		OutputStreamWriter isr = new OutputStreamWriter(fis, "gb2312");
		// OutputStreamWriter 封装到缓冲流中
		BufferedWriter br = new BufferedWriter(isr);
		br.write(lefthtmHeader + lefthtmBody);
		br.close();
	}

	/**
	 * @param lefthtmBody2
	 */
	private static void replaceHrefPathAndCacheToMap(String lefthtmBodyContent) {
		String[] strs = lefthtmBodyContent.split(";");
		StringBuilder sb = new StringBuilder("");
		for (String str : strs) {
			if (str.startsWith("d.add")) {
				str = replacePathAndCacheToMap(str);
			}
			sb.append(str + ";");
		}
		lefthtmBody = sb.toString();
	}

	/**
	 * @param str
	 * @return
	 */
	private static String replacePathAndCacheToMap(String str) {
		StringBuilder sb = new StringBuilder("");
		String[] strs = str.split(",");
		for (int i = 0; i < strs.length; i++) {
			if (strs[i].contains("/") || i == strs.length - 1) {
				String normailStr = pinyin.cn2Spell(strs[i]);
				normailStr = normailStr.replace(":", "");
				sb.append(normailStr);
			} else {
				sb.append(strs[i] + ",");
			}
		}
		return sb.toString();
	}

	/**
	 * 
	 */
	private static void removeComments() {
		lefthtmBody = lefthtmBody.replace(comments, "");
	}

	/**
	 * @param lefthtm
	 * @return
	 */
	private static void addEncoding(String lefthtm) {
		int headerIndex = lefthtm.indexOf("</head>");
		lefthtmHeader = lefthtm.substring(0, headerIndex) + encoding + icon;
		lefthtmBody = lefthtm.substring(headerIndex, lefthtm.length());
	}

	/**
	 * @return
	 * @throws IOException
	 */
	private static String getLefthtmSource() throws IOException {
		File inputFolder = new File(inputFolderPath);
		File[] files = inputFolder.listFiles();
		for (File subFile : files) {
			if (subFile.isDirectory()) {
				File[] subfiles = subFile.listFiles();
				for (File subFile1 : subfiles) {
					for (File subFile2 : subFile1.listFiles()) {
						if (subFile2.isFile()
								&& subFile2.getName().endsWith("htm")) {
							lefthbmPath = subFile2.getAbsolutePath();
							return getStringFromFile(lefthbmPath);
						}
					}
				}
			}
		}
		return null;
	}

	private static String getStringFromFile(String fileName) throws IOException {
		File template = new File(fileName);
		BufferedReader bf = new BufferedReader(new InputStreamReader(
				new FileInputStream(template), "gb2312"));
		String content = "";
		StringBuilder sb = new StringBuilder();
		while (content != null) {
			content = bf.readLine();

			if (content == null) {
				break;
			}
			sb.append(content.trim());
		}
		bf.close();
		return sb.toString();
	}
}
