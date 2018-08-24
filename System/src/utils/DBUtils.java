package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

public class DBUtils {
	
	private DBUtils(){}
	
	private static Connection connection;
	
	/**
	 * 用以获取数据库连接
	 * @return 返回值为连接对象
	 * @throws Exception
	 */
	public static Connection getConnection() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/first_mysql_test?characterEncoding=utf8&useSSL=true", "root", "Aaa950114");
		return connection;
	}
	
	/**
	 * 用于查询表中的特定信息
	 * @param sql 格式化的sql语句
	 * @param value 参数列表
	 * @return
	 */
	public static ResultSet query(String sql, String... value){
		PreparedStatement pstmt;
		ResultSet rs;
		try {
			pstmt = (PreparedStatement)getConnection().prepareStatement(sql);
			for(int x = 0;x < value.length;x ++){
				pstmt.setString(x + 1, value[x]);
			}
			rs = pstmt.executeQuery();
			pstmt.close();
			closeConnect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 使用Statement关键字进行数据库的查询
	 * @param sql
	 * @return
	 */
	public static ResultSet query(String sql){
		
		try {
			Statement sta = getConnection().createStatement();
			ResultSet rs = sta.executeQuery(sql);
			
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 执行数据库的更新操作
	 * @param sql 格式化数据库语句
	 * @param values 参数
	 * @return
	 */
	public static int update(String sql, String...values){
		PreparedStatement pstmt;
		int i = 0;
		try {
			pstmt = (PreparedStatement)getConnection().prepareStatement(sql);
			i = pstmt.executeUpdate();
			pstmt.close();
			closeConnect();
			return i;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
	/**
	 * 使用Statement方式进行数据的添加
	 * @param sql
	 * @return
	 */
	public static int insert(String sql){
		Statement st;
		try {
			st = getConnection().createStatement();
			return st.executeUpdate(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	
	/**
	 * 删除格式化sql语句
	 * @param sql sql语句  e.g. String sql = "delete from students where Name='" + name + "'";
	 * @return
	 */
	public static int delete(String sql){
		PreparedStatement pstmt;
		int i = 0;
		try {
			pstmt = (PreparedStatement) connection.prepareStatement(sql);
			i = pstmt.executeUpdate();
			pstmt.close();
			closeConnect();
			return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
	/**
	 * 关闭数据库连接
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
