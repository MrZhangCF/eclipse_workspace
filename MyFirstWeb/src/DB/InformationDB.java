package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import demo.Information;

public class InformationDB {
//	public Connection getConnection() throws Exception{
//		
//		return connection;
//	}
	
	public List<Information> findAll() throws Exception{
		//Connection connection = getConnection();
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/first_mysql_test?characterEncoding=utf8&useSSL=true", "root", "Aaa950114");
		String sql = "select userId,userAccount,userPassword from table_user_password";
		Statement sta = connection.createStatement();
		ResultSet rs = sta.executeQuery(sql);
		List<Information> infos = new ArrayList<>();
		while(rs.next()){
			Information info = new Information();
			info.setUserId(rs.getInt("userId"));
			info.setUserAccount(rs.getString("userAccount"));
			info.setUserPassword(rs.getString("userPassword"));
			infos.add(info);
		}
		connection.close();
		return infos;
	}
}
