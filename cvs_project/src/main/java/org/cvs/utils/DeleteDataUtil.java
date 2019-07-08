package org.cvs.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteDataUtil {
	//清空数据库
		public static void deleteData() { 
			String sql = "truncate table student;";
			Connection conn = null;
	        PreparedStatement pstmt = null;
	        try{
	            conn = JdbcUtil.getConnection();
	            pstmt = conn.prepareStatement(sql);
	            pstmt.executeUpdate();
	            }catch (Exception e) {
	            	e.printStackTrace();
				}finally {
					JdbcUtil.close(conn, pstmt, null);
				}
		}
}
