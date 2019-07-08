package org.cvs.ctreate;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *创建cvs文件
 */
public class CreateCVS {

	public static String filepath = "f:/CvsProject/";// 文件名称
	public static String filename = "student.csv";// 文件路径

	public static void createCVS(int dataNum) {
		// 表格头
		Object[] head = { "id", "name", "age", "profession", "sclass", "qq", "wechat", "phone", "home", "hobby" };
		List<Object> headList = Arrays.asList(head);

		// 数据
		List<List<Object>> dataList = new ArrayList<List<Object>>();
		List<Object> rowList = null;
		for (int i = 1; i <= dataNum; i++) {
			rowList = new ArrayList<Object>();
			rowList.add(i);
			rowList.add("张三" + i);
			rowList.add((int) ((Math.random() + 2) * 10));
			rowList.add("软件工程" + i);
			rowList.add(i + "班");
			rowList.add((int) (Math.random() * 100000000));
			rowList.add((int) (Math.random() * 100000000));
			rowList.add((int) (Math.random() * 100000000));
			rowList.add("广州" + i);
			rowList.add("游泳" + i);
			dataList.add(rowList);
		}

		File csvFile = null;
		BufferedWriter csvWtriter = null;
		try {
			csvFile = new File(filepath + filename);
			File parent = csvFile.getParentFile();
			if (parent != null && !parent.exists()) {
				parent.mkdirs();
			}
			csvFile.createNewFile();

			// GB2312使正确读取分隔符","
			csvWtriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(csvFile), "utf-8"), 1024);
			int num = headList.size() / 2;
			StringBuffer buffer = new StringBuffer();
			for (int i = 0; i < num; i++) {
				buffer.append(" ,");
			}
			// 写入文件头部
			writeRow(headList, csvWtriter);

			// 写入文件内容
			for (List<Object> row : dataList) {
				writeRow(row, csvWtriter);
			}
			csvWtriter.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				csvWtriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 写一行数据
	 */
	private static void writeRow(List<Object> row, BufferedWriter csvWriter) throws IOException {
		for (Object data : row) {
			StringBuffer sb = new StringBuffer();
			String rowStr = sb.append(data).append(",").toString();
			csvWriter.write(rowStr);
		}
		csvWriter.newLine();
	}

}
