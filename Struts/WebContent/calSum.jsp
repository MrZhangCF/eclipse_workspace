<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>输入操作数</title>
</head>
<body>
	求和<br/>
	<s:form action="calSum">
		<s:textfield name="num1" label="数1"></s:textfield>
		<s:textfield name="num2" label="数2"></s:textfield>
		<s:submit value="求和"></s:submit>
	</s:form>
</body>
</html>