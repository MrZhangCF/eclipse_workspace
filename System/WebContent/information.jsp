<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="data.Information, bean.InformationBean, utils.DBUtils, java.util.*, java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<%
		String name = request.getParameter("name");
		String phonenumber = request.getParameter("phonenumber");
		
		String sql = "select * from userinformation where name='" + name +"' and phonenumber='" + phonenumber +"';";
		ResultSet rs = DBUtils.query(sql);
		
		Information info = new Information();
		String gender = null;
		if(rs.next()){
			info.setName(name);
			info.setGender(rs.getInt("gender"));
			info.setUrladdress(rs.getString("urladdress"));
			info.setPhonenumber(phonenumber);
			info.setNumber(rs.getInt("number"));
		}
		if(info.getGender() == 1){
			gender = "男";
		}else{
			gender = "女";
		}
	%>
	<table align="center">
		<tr>
			<td>
				<table border="1">
					<tr>
						<td width="300" align="center">姓名</td>
						<td width="300" align="center"><%=info.getName() %></td>
					</tr>
					<tr>
						<td width="300" align="center">性别</td>
						<td width="300" align="center"><%=gender %></td>
					</tr>
					<tr>
						<td width="300" align="center">电话</td>
						<td width="300" align="center"><%=info.getPhonenumber() %></td>
					</tr>
				</table>
			</td>
			<%
				for(int x=1;x<=info.getNumber();x++){
			%>
			<td><img src="/upload/<%= info.getUrladdress() %>(<%=x %>).jpg"></td>
			<%
				}
			%>
		</tr>
	</table>

</body>
</html>