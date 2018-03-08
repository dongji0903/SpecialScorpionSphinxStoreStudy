<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login BeauTea</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/table.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script type="text/javascript">
$(function() {
	var form = $("#loginfrm");
	$("#password").keydown(function(key) {
		if (key.keyCode == 13) {
			if ($("#id").val().length < 1) {
				alert('아이디를 입력해주세요.');
				return;
			} else if ($("#password").val().length < 1) {
				alert('비밀번호를 정확히 입력해주세요.');
				return;
			} else {
				form.submit();
			}
		}
	});
	
	$("#login").click(function(){
		if ($("#id").val().length < 1) {
			alert('아이디를 입력해주세요.');
			return;
		} else if ($("#password").val().length < 1) {
			alert('비밀번호를 정확히 입력해주세요.');
			return;
		} else {
			form.submit();
		}
	});
}); 
</script>

</head>
<body class="page1" id="top">
<%@include file="/WEB-INF/views/header.jsp"%>
<section class="content">
<div class="container" align="center">
	<form id="loginfrm" action="<%=request.getContextPath()%>/login" method="post">
		<div style="padding-top: 20px;">
			<c:if test="${error != null}">
				<font color="red" size="2">${error}</font>
			</c:if>
		</div>
		사람인 채용자 공용 로그인 아이디 : saramin 패스워드 : 12345678
	<div class="table" style="width: 250px; margin-top: 30px;"  align="center">
		<div class="tr">
			<div class="td" align="center">
			<input type="text" name="id" id="id" value="${param.id}" style="padding-left: 5%; width: 90%; height: 30px;" placeholder="아이디"/>
			</div>
		</div>	
		<div class="tr">
			<div class="td" align="center">
			<input type="password" name="password" id="password" style="padding-left: 5%; width: 90%; height: 30px;" placeholder="비밀번호"/>
			</div>
		</div>	
		<div class="tr">
			<div class="td" align="center">
			<a style="width: 70%; height: 20px; text-align: center; border: solid 1px #aaccaa;" class="btn" id="login">로그인</a>
			</div>
		</div>	
		<div class="tr">
			<div class="td" align="left">
			BeauTea 계정이 아직 없으신가요?<br>
			<a href="<%=request.getContextPath()%>/join" style="color: #aaccaa; font-weight: bold;">
			회원가입
			</a>
			<font size="1">▶</font>
			</div>
		</div>	
	</div>
	</form>
</div>
</section>
<%@include file="/WEB-INF/views/footer.jsp"%> 
</body>
</html>