package action;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.DBUtils;

public class IndexAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
//		String checkSql = "SELECT * FROM usernameandpassword WHERE username=?;";
//		ResultSet rs = DBUtils.query(checkSql, null);

		String checkSql = "SELECT * FROM usernameandpassword WHERE username='" + username +"';";
		ResultSet rs = DBUtils.query(checkSql);
		boolean flag = false;
		try {
			while(rs.next()){
				try {
					if(rs.getString("username").equals(username) && rs.getString("password").equals(password)){
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
		
		ServletContext application = this.getServletContext();
		application.setAttribute("index", true);
		
		if(flag == true){
			resp.sendRedirect("../Welcome.jsp");
		}else{
			resp.sendRedirect("../Noregister.jsp");
		}
		
	}
	
	
}
