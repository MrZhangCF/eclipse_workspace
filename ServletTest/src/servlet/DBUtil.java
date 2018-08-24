package servlet;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import util.LogUtil;

public class DBUtil {
	// ���ű�
	public static final String TABLE_PASSWORD = "table_user_password";
	public static final String TABLE_USERINFO = "table_user_info";
	
	private static Connection connector;

	// ���ӵ�MySQL���ݿ�
	public static Connection getConnect() {
		if (connector == null) {
			String url = "jdbc:mysql://localhost:3306/first_mysql_test";
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connector = (Connection) DriverManager.getConnection(url, "root", "Aaa950114");
				LogUtil.log("�������ݿ�����");
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
	
	//��ѯ����
	public static ResultSet query(String querySql) throws SQLException{
		Statement statement = (Statement) getConnect().createStatement();
		return statement.executeQuery(querySql);
	}
	
	//���룬���£�ɾ��
	public static int update(String insertSql) throws SQLException{
		Statement statement = (Statement) getConnect().createStatement();
		return statement.executeUpdate(insertSql);
	}
	
	//�ر����ݿ�����
	public static void closeConnect(){
		if(connector != null){
			try {
				connector.close();
				connector = null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				LogUtil.log("���ݿ�ر��쳣�� [" + e.getErrorCode() + "]" + e.getMessage());
			}
			
		}
	}
	
}
