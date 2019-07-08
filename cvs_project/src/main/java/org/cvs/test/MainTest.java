package org.cvs.test;

import java.util.List;

import org.cvs.ctreate.CreateCVS;
import org.cvs.io.CVSInput;
import org.cvs.io.CVSOutput;
import org.cvs.pojo.Student;
import org.cvs.utils.DeleteDataUtil;

public class MainTest {
	/**
	 * 程序运行入口
	 */
	public static void main(String[] args) {
		int arrayDataNum[] = {10036,100046,1000056};
		for(int i = 0;i< arrayDataNum.length;i++) {
			mainTest(arrayDataNum[i]);
		}
	}
	
	/**
	 * 测试耗时
	 */
	public static void mainTest(int dataNum) {
		
		System.out.println("测试"+dataNum+"行数据：");
		
		//测试创建CVS文件耗时
		long startCreate = System.currentTimeMillis();
		CreateCVS.createCVS(dataNum);
		long finishCreate = System.currentTimeMillis();
		System.out.println("      创建csv文件所用时间："+(finishCreate-startCreate)+"ms");
		
		//测试读取CVS文件耗时
		long startRead = System.currentTimeMillis();
		List<Student> stuList= CVSInput.ReadIn();
		long finishRead = System.currentTimeMillis();
		System.out.println("      读取csv文件所用时间："+(finishRead-startRead)+"ms");
		
		//测试不同batchSize时将数据入库所用时间
		int arrayBatchSize[] = {100,500,1000};
		for(int i = 0;i < arrayBatchSize.length;i++) {
//			DeleteDataUtil.deleteData();
			long startWrite = System.currentTimeMillis();
			CVSOutput.writeOut(stuList, arrayBatchSize[i]);
			long finishWrite = System.currentTimeMillis();
			System.out.println("      当batchSize为"+arrayBatchSize[i]+"将数据写入数据库所用时间："+(finishWrite-startWrite)+"ms");
		}
	}
}
