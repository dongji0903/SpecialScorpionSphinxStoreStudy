<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>수고!</title>
</head>
<body>
	수고하셨습메!!
	<form action="<%=request.getContextPath()%>/main.do">
		<input type="submit" value="첫 화면으로">
	</form>
	<img src="<%=request.getContextPath()%>/upload/AW401669_02.gif"
		width="150" height="150">
</body>
</html>