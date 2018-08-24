<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="data.Information, bean.InformationBean, java.util.*" %>
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
			<th width="300">姓名</th>
			<th width="300">性别</th>
			<th width="300">url地址</th>
			<th width="300">电话号码</th>
		</tr>
		<%
			InformationBean infoBean = new InformationBean();
			List<Information> infos = infoBean.findAll();
			Iterator<Information> it = infos.iterator();
			while(it.hasNext()){
				Information info = (Information)it.next();
		%>
		<tr>
			<td align="center"><%= info.getId() %></td>
			<td align="center"><%= info.getName() %></td>
			<td align="center"><%= info.getGender() %></td>
			<td align="center"><%= info.getUrladdress() %></td>
			<td align="center"><%= info.getPhonenumber() %></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>