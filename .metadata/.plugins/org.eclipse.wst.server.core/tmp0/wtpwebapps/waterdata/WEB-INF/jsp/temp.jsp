<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<table>
		<tr>
			<td>DATE</td>
			<td>MAX</td>
			<td>MIN</td>
		</tr>
		<c:forEach items="${temps }" var="item">
			<tr>
				<td>${item.getDATE() }</td>
				<td>${item.getMAX() }</td>
				<td>${item.getMIN() }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>