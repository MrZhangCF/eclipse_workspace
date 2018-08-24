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
	 * ���Ի�ȡ���ݿ�����
	 * @return ����ֵΪ���Ӷ���
	 * @throws Exception
	 */
	public static Connection getConnection() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/first_mysql_test?characterEncoding=utf8&useSSL=true", "root", "Aaa950114");
		return connection;
	}
	
	/**
	 * ���ڲ�ѯ���е��ض���Ϣ
	 * @param sql ��ʽ����sql���
	 * @param value �����б�
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
	 * ʹ��Statement�ؼ��ֽ������ݿ�Ĳ�ѯ
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
	 * ִ�����ݿ�ĸ��²���
	 * @param sql ��ʽ�����ݿ����
	 * @param values ����
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
	 * ʹ��Statement��ʽ�������ݵ����
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
	 * ɾ����ʽ��sql���
	 * @param sql sql���  e.g. String sql = "delete from students where Name='" + name + "'";
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
	 * �ر����ݿ�����
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
