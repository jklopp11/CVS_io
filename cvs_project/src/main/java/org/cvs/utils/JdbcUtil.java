package org.cvs.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;
/**
 * 使用了Druid连接池
 */
public class JdbcUtil {
	private static Properties p = new Properties();
	private static DataSource ds;
	static {
		try {
			
			//1.获取类加载器
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			//2.读取配置文件返回输入流
			InputStream inputStream = classLoader.getResourceAsStream("db.properties");
			
			//3.使用p对象加载 输入流
			p.load(inputStream);
			
			//使用工厂创建Druid连接池对象
			ds = DruidDataSourceFactory.createDataSource(p);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		try {
			//使用连接池获取连接对象
			return ds.getConnection();
			//return DriverManager.getConnection(p.getProperty("url"),p.getProperty("username"), p.getProperty("password"));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("警告：获取数据库连接对象失败!!");
		}
	}

	public static void close(Connection conn, Statement ps, ResultSet rs) {
		// 5.释放资源(先开后关原则)
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
