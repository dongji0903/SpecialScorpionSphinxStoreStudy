<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BeauTea</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/table.css">
</head>
<body class="page1" id="top">
<%@include file="/WEB-INF/views/header.jsp"%>
<section class="content">
<div class="container" align="center">
	<h2>Welcome!</h2>
	<div class="table" align="center" style="width: 280px;">
		<div class="tr">
		<div class="td" align="center" style="padding:0;">
			<a href="<%=request.getContextPath()%>/" class="btn">Main</a>
		</div>
		<div class="td" align="center" style="padding:0;">
			<a href="<%=request.getContextPath()%>/login" class="btn">Login</a>
		</div>
		</div>
	</div>
</div>
</section>
<%@include file="/WEB-INF/views/footer.jsp"%> 
</body>
</html>