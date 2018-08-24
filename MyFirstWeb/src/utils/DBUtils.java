package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//�������ڶ����ݿ��н��в�ѯ�͸��µĲ���
public class DBUtils {
	public static String INFORMATION = "infomation";
	private static Connection connection;
	
	private static Connection getConnection() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/first_mysql_test?characterEncoding=utf8&useSSL=true", "root", "Aaa950114");
		return connection;
	}
	
	/**
	 * ִ�ж����ݿ�Ĳ��롢���¡�ɾ������
	 * @param sql ��Ӧ��sql���
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
	 * ִ�����ݿ����ӵĹرղ���
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
