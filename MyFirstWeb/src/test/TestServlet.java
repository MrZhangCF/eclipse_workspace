package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.DBUtils;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/test")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getMethod();
		if("GET".equals(method)){
			//LogUtil.log("请求方法：GET");
			doGet(request, response);
		}else if("POST".equals(method)){
			//LogUtil.log("请求方法：POST");
			doPost(request, response);
		}else{
			//LogUtil.log("请求方法分辨失败！");
			System.out.println("请求方法分辨失败");
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = null;
		String message = null;
		
		String info = request.getParameter("message");
		
		String sqlInsert = "insert into " + DBUtils.INFORMATION + " (info) values('" + info + "')";
		if(DBUtils.Insert(sqlInsert) > 0){
			code= "100";
			message = "入库成功";
		}else{
			code = "202";
			message = "入库失败";
		}
		System.out.println("code: " + code + " message: " + message);
		DBUtils.closeConnect();
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().append("code: ").append(code).append(";\r\nmessage: ").append(message);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
//		String sql = "INSERT INTO table_user_password(userAccount,userPassword) VALUE('" + username + "','" + password + "')";
//		DBUtils.Insert(sql);
//		DBUtils.closeConnect();
		
//		String checkSql = "select userAccount,userPassword from table_user_password";
		String checkSql = "SELECT * FROM table_user_password WHERE userAccount='" + username + "';";
		ResultSet rs = DBUtils.query(checkSql);
		boolean flag = false;
		try {
			while(rs.next()){
				try {
					if(rs.getString("userAccount").equals(username) && rs.getString("userPassword").equals(password)){
						flag = true;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DBUtils.closeConnect();
		
		if(flag == true){
			response.sendRedirect("../Welcome.jsp");
		}else{
			response.sendRedirect("../NoRegister.jsp");
		}
		
//		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
//		out.println("<HTML>");
//		out.println("	<HEAD><TITLE>验证页面</TITLE></HEAD>");
//		out.println("		<BODY>");
//		response.sendRedirect("../Welcome.jsp?username=" + username);
//		out.println("</BODY>");
//		out.println("</HTML>");
//		out.flush();
//		out.close();
	}

}
