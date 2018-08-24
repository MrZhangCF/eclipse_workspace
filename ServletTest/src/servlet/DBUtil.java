package servlet;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import util.LogUtil;

public class DBUtil {
	// 两张表单
	public static final String TABLE_PASSWORD = "table_user_password";
	public static final String TABLE_USERINFO = "table_user_info";
	
	private static Connection connector;

	// 连接到MySQL数据库
	public static Connection getConnect() {
		if (connector == null) {
			String url = "jdbc:mysql://localhost:3306/first_mysql_test";
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connector = (Connection) DriverManager.getConnection(url, "root", "Aaa950114");
				LogUtil.log("创建数据库连接");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				System.out.println("SQLException:" + e.getMessage());
				System.out.println("SQLState:" + e.getSQLState());
				System.out.println("VendorError:" + e.getErrorCode());
			}

		}
		return connector;
	}
	
	//查询操作
	public static ResultSet query(String querySql) throws SQLException{
		Statement statement = (Statement) getConnect().createStatement();
		return statement.executeQuery(querySql);
	}
	
	//插入，更新，删除
	public static int update(String insertSql) throws SQLException{
		Statement statement = (Statement) getConnect().createStatement();
		return statement.executeUpdate(insertSql);
	}
	
	//关闭数据库连接
	public static void closeConnect(){
		if(connector != null){
			try {
				connector.close();
				connector = null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				LogUtil.log("数据库关闭异常： [" + e.getErrorCode() + "]" + e.getMessage());
			}
			
		}
	}
	
}
