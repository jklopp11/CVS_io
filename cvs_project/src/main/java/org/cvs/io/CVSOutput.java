package org.cvs.io;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.cvs.pojo.Student;
import org.cvs.utils.JdbcUtil2;

public class CVSOutput {
	public static void writeOut(List<Student> stuList,int batchSize) {
		String sql = "insert into student (name, age, profession,sclass,qq,wechat,phone,home,hobby) values (?,?,?,?,?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement pstmt = null;
        int count = 0;
        try{
            conn = JdbcUtil2.getConnection();
            pstmt = conn.prepareStatement(sql);
            for (Student student : stuList) {
            	 pstmt.setString(1,student.getName());
            	 pstmt.setInt(2,student.getAge());
            	 pstmt.setString(3,student.getProfession());
            	 pstmt.setString(4,student.getSclass());
            	 pstmt.setString(5,student.getQq());
            	 pstmt.setString(6,student.getWechat());
            	 pstmt.setInt(7,student.getPhone());
            	 pstmt.setString(8,student.getHome());
            	 pstmt.setString(9,student.getHobby());
            	 pstmt.addBatch();
            	 //小批量提交
                 if(++count % batchSize == 0) {
                     pstmt.executeBatch();
                 }
			}
            pstmt.executeBatch(); //提交剩余的数据
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JdbcUtil2.close(conn, pstmt, null);
        }
	}
}
