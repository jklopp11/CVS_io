package org.cvs.test;

import static org.junit.Assert.*;

import java.util.List;

import org.cvs.ctreate.CreateCVS;
import org.cvs.io.CVSInput;
import org.cvs.io.CVSOutput;
import org.cvs.pojo.Student;
import org.cvs.utils.DeleteDataUtil;
import org.junit.Test;

public class PartTest {
	/**
	 *测试创建CVS文件 
	 */
	@Test
	public void testCreate() throws Exception {
		CreateCVS.createCVS(10036);
	}
	
	/**
	 * 测试读取CVS文件
	 */
	@Test
	public void testRead() throws Exception {
		CVSInput.ReadIn();
	}
	
	/**
	 * 测试写入数据库
	 */
	@Test
	public void testWrite() throws Exception {
		List<Student> stuList = CVSInput.ReadIn();
		DeleteDataUtil.deleteData();
		CVSOutput.writeOut(stuList, 100);
	}
}
