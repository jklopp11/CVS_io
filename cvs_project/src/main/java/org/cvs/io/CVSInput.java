package org.cvs.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.cvs.ctreate.CreateCVS;
import org.cvs.pojo.Student;

public class CVSInput {

	public static List<Student> ReadIn() {
		File csv = new File(CreateCVS.filepath + CreateCVS.filename); // CSV文件路径
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(csv));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String line = "";
		try {
			List<String> allString = new ArrayList<>();
			br.readLine();
			while ((line = br.readLine()) != null) // 读取到的内容给line变量
			{
//				System.out.println(line);
				allString.add(line);
			}
//			System.out.println("csv表格中所有行数：" + allString.size());

			// 将读取出来的结果封装成对象集合
			List<Student> stuList = new ArrayList<Student>();
			for (int i = 0; i < allString.size(); i++) {
				// CSV格式文件为逗号分隔符文件，这里根据逗号切分
				int j = 0;
				String item[] = allString.get(i).split(",");
				if (item[j] != null) {
					Student stu =  new Student();
					stu.setName(item[1]);
					stu.setAge(Integer.parseInt(item[2]));
					stu.setProfession(item[3]);
					stu.setSclass(item[4]);
					stu.setQq(item[5]);
					stu.setWechat(item[6]);
					stu.setPhone(Integer.parseInt(item[7]));
					stu.setHome(item[8]);
					stu.setHobby(item[9]);
					stuList.add(stu);
//					System.out.println(stu);
				}
			}
			return stuList;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
