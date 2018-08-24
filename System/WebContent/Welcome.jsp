<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="data.Information, bean.InformationBean, java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<table border="0" align="center">
		<tr>
			<th width="300">姓名</th>
		</tr>
		<%
			InformationBean infoBean = new InformationBean();
			List<Information> infos = infoBean.findAll();
			Iterator<Information> it = infos.iterator();
			while(it.hasNext()){
				Information info = (Information)it.next();
		%>
		<tr> 
			<td align="center">
				<a href="information.jsp?name=<%=info.getName() %>&phonenumber=<%=info.getPhonenumber() %>" >
					<%= info.getName() %>
				</a>
			</td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>