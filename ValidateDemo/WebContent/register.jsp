<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
</head>
<body>
	<s:fielderror></s:fielderror>
	<form action="registerAction" validate="true" method="post">
		登陆用户：<input type="text" name="username"><br>
		登陆密码：<input type="text" name="password"><br>
		确认密码：<input type="text" name="confirm"><br>
		邮件地址：<input type="text" name="email"><br>
		手机号码：<input type="text" name="handphone"><br>
		<input type="submit" value="提交">
	</form>
</body>
</html>