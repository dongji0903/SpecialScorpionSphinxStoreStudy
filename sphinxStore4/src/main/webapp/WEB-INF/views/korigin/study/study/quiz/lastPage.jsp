<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">

#animate
{
	min-width:100px;
    position: relative;
    animation-duration:4s;
    animation-name:move;
    animation-iteration-count: infinite;
    animation-timing-function: ease;
}
#animate:hover{

 	background: blue; 
}

@keyframes move{
0%{left:-150px;top:0px}
25%{left:150px;top:0px}
50%{left:150px;top:20px}
75%{left:-150px;top:20px}
100%{left:-150px;top:0px}
}
</style>
<title>로그아웃!</title>
</head>
<body>
		<div style="min-height: 400px;border: 1px solid #797979;  background-image: linear-gradient(45deg,yellowgreen,white)">
			<div id="animate"><font size="8">수고하셨습니다!</font></div>
			<br> 채점결과) 정답 수 : ${requestScope.trueCount } / 총문제 : ${totalNumOfQuestion }
			<br> 적립된 포인트 : ${point} / 총 잔여 포인트 : ${totalPoint}
			<br> 적립된 Exp : ${exp} / 총 누적 Exp : ${totalExp}
			<br>
			<c:if test="${requestScope.trueCount*2 <totalNumOfQuestion }">
			<img src="<%=request.getContextPath() %>/upload/geukhyum.gif" width="200" height="270"><br>
			<font size="5">어우 극혐!</font>
			</c:if>
				<div align="center" style="position:relative;bottom: 0px">
				<a href="<%=request.getContextPath() %>/study/index.do" style=" border: 1px solid #797979;  background-color: #F9F9F9;">학습메뉴로</a>
				<a href="<%=request.getContextPath() %>/main.do" style="border: 1px solid #797979;  background-color: #F9F9F9;">첫화면으로</a>
				</div>
			</div>
</body>
</html>