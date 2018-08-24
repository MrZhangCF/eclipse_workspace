package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//此类用于对数据库中进行查询和更新的操作
public class DBUtils {
	public static String INFORMATION = "infomation";
	private static Connection connection;
	
	private static Connection getConnection() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/first_mysql_test?characterEncoding=utf8&useSSL=true", "root", "Aaa950114");
		return connection;
	}
	
	/**
	 * 执行对数据库的插入、更新、删除操作
	 * @param sql 对应的sql语句
	 * @return
	 */
	public static int Insert(String sql){
		try {
			Statement st = getConnection().createStatement();
			return st.executeUpdate(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
	
	public static ResultSet query(String sql){
		Statement st;
		try {
			st = getConnection().createStatement();
			return st.executeQuery(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 执行数据库连接的关闭操作
	 */
	public static void closeConnect(){
		if(connection != null){
			try {
				connection.close();
				connection = null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
