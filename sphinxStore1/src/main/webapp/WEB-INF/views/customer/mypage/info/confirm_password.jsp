<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/table.css">
</head>
<body class="page1" id="top">
<%@include file="/WEB-INF/views/header.jsp"%>
<section class="content">
<div class="container" align="center">
	<form id="editfrm" action="<%=request.getContextPath()%>/mypage/confirmpassword" method="post">
	<div class="table" align="center" style="margin-top: 30px; margin-bottom: 50px; max-width: 500px;">
		<div class="tr">
			<div class="td">
			비밀번호
			</div>
		</div>
		<div class="tr">
			<div class="td">
			<input type="password" name="password" style="padding-left: 5%; width: 92%; height: 25px;"/>
			</div>
		</div>
		<div class="tr">
			<div class="td">
			<input type="submit" value="확인" class="btn" style="width: 92%; height: 30px;"/>			
			</div>
		</div>
	</div>
	</form>
</div>
</section>
<%@include file="/WEB-INF/views/footer.jsp"%> 
</body>
</html>