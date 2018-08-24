package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import util.LogUtil;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet(description = "用于检测新用户注册和老用户登陆", urlPatterns = { "/RegisterServlet" })
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
    	LogUtil.log("RegisterServlet construct...");
    	// TODO Auto-generated constructor stub
    }

    
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String method = request.getMethod();
		if("GET".equals(method)){
			LogUtil.log("请求方法：GET");
			doGet(request, response);
		}else if("POST".equals(method)){
			LogUtil.log("请求方法：POST");
			doPost(request, response);
		}else{
			LogUtil.log("请求方法分辨失败！");
		}
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String code = "";
		String message = "";
		
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		LogUtil.log(account + ";" + password);
		
		Connection connect = DBUtil.getConnect();
		//以下是注册逻辑
		try{
			Statement statement = (Statement)connect.createStatement();			
			String sqlQuery = "select * from " + DBUtil.TABLE_PASSWORD + " where userAccount='" + account +"';";
			LogUtil.log(sqlQuery);
			ResultSet result = statement.executeQuery(sqlQuery);
			if(result.next()){
				code = "100";
				message = "该账户已存在";
			}else{
				String sqlInsertPass = "insert into " + DBUtil.TABLE_PASSWORD + "(userAccount,userPassword) values('"+account+"','"+password+"')";
				LogUtil.log(sqlInsertPass);
				if(statement.executeUpdate(sqlInsertPass) > 0){
					code = "200";
					message = "注册成功";
				}else{
					code = "202";
					message = "注册失败";
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().append("code:").append(code).append(";message:").append(message);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		LogUtil.log("RegisterServlet destory.");
		super.destroy();
	}
	
	

}
