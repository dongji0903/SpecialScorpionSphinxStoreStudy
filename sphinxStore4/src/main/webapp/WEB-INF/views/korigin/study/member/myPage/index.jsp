<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index</title>
</head>
<body>

	<div id="main">
	<table height="200px" style="margin: 5px;font-family: fantasy;" >
	<tr style="background-color: red;"><td><a href="<%=request.getContextPath() %>/myPage/getMemberDetail.do" > 회원정보수정 </a></td></tr>
	<tr style="background-color: yellow;"><td><a href="<%=request.getContextPath() %>/board/getList.do?category=공연게시판" > 주문내역 </a></td></tr>
	<tr style="background-color: green;"><td><a href="<%=request.getContextPath() %>/board/getList.do?category=묻고답하기" > 쪽지함 </a></td></tr>
	<tr style="background-color: blue;"><td><a href="<%=request.getContextPath() %>/myPage/viewPointLog.do" > 포인트내역조회 </a></td></tr>
	<tr style="background-color: blue;"><td><a href="<%=request.getContextPath() %>/study/getTestResult.do" > 시험결과조회 </a></td></tr>
	</table>
	</div>
</body>
</html>