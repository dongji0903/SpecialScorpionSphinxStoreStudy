<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>index</title>
</head>
<body>
<div id="main">
	<table height="200px" style="margin: 5px;font-family: fantasy;" >
	<tr style="background-color: red;"><td><a href="<%=request.getContextPath() %>/board/getList.do?category=공지사항" > 공지사항 </a></td></tr>
	<tr style="background-color: yellow;"><td><a href="<%=request.getContextPath() %>/board/getList.do?category=공연게시판" > 공연게시판 </a></td></tr>
	<tr style="background-color: green;"><td><a href="<%=request.getContextPath() %>/board/getList.do?category=묻고답하기" > 묻고답하기 </a></td></tr>
	<tr style="background-color: blue;"><td><a href="<%=request.getContextPath() %>/board/getList.do?category=자료실" > 자료실 </a></td></tr>
	</table>
	</div>
</body>
</html>