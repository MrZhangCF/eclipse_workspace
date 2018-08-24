<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
</head>
<body>
	<form name = "login" action="./action/IndexAction" method = "POST">
	<table align="center">
		<tr>
			<td> 用户名：</td>
			<td><input type="text" name="username" id="username" /></td>
		</tr>
		<tr>
			<td>密&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
			<td><input type="password" name="password" id="password" /></td>
		</tr>
	</table>
	<table align="center">
		<tr>
		<td colospan="2" align="center">
			<input type="submit" name="logon" value="登陆" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="reset" name="reset" value="重置" />
		</td>
	</tr>
	</table>
	
</form>

<form name="showAll" action="./fuck" method="POST">
	<table align="center">
		<tr>
			<td align="center">
				<input type="submit" name="logon" value="展示全部" />
			</td>
		</tr>
	</table>
</form>
</body>
</html>