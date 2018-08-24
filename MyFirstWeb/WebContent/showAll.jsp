<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="demo.Information, utils.InformationBean, java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>所有信息</title>
</head>
<body>
	<h2>所有信息如下：</h2>
	<table border="1" width=600>
		<tr>
			<th width="300">id</th>
			<th width="300">账号</th>
			<th width="300">密码</th>
		</tr>
		<%
			InformationBean infoBean = new InformationBean();
			List<Information> infos = infoBean.findAllInformation();
			Iterator<Information> it = infos.iterator();
			while(it.hasNext()){
				Information info = (Information)it.next();
		%>
		<tr>
			<td align="center"><%= info.getUserId() %></td>
			<td align="center"><%= info.getUserAccount() %></td>
			<td align="center"><%= info.getUserPassword() %></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>