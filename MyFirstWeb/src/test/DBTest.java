package test;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.DBUtils;

public class DBTest extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	
	public DBTest() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		Map<String, String[]> params = req.getParameterMap();
		String[] account = params.get("account");
		String[] password = params.get("password");
		
		String sql = "INSERT INTO table_user_password(userAccount,userPassword) VALUE('" + account[0] + "','" + password[0] + "')";
		DBUtils.Insert(sql);
		DBUtils.closeConnect();
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("../showAll.jsp");
	}
	
}
