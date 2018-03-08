<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> Welcome!!! Bro !! </title>
<script type="text/javascript">
function linker(i) {
	if(i==1){
		document.mainPage.url.value = "welcome2.jsp";
		document.mainPage.submit();
	}else if(i==2){
		document.mainPage.url.value = "history.jsp";
		document.mainPage.submit();
	}else if(i==3){
		document.mainPage.url.value = "teacherList.jsp";
		document.mainPage.submit();
		
	}else{
		document.mainPage.url.value = "teacherList.jsp";
		document.mainPage.submit();
	}
}


</script>
</head>
<body>
<div id="wrap" align="center">

		<div id="header">
			<jsp:include page="/form/header_Form.jsp" />
		</div>
		
	<div style="background-color: white; height: 500px;" >
		<div id="main">
	<table height="200px" style="margin: 5px;">
	<tr><td><a href="#" onclick="linker(1)"> 개 요 </a></td></tr>
	<tr><td><a href="#" onclick="linker(2)"> 연 혁 </a></td></tr>
	<tr><td><a href="#" onclick="linker(3)"> 선생님 소개 </a></td></tr>
	<tr><td><a href="#" onclick="linker(4)"> 위 인 들 </a></td></tr>
	<tr><td><a href="#" onclick="linker(5)"> 오시는 길  </a></td></tr>
	</table>
			
		</div>
		
		<form action="introduce.jsp" name="mainPage">
			<div id="container">
			<%-- 	<jsp:include page="${param.url}" />
					<input type="hidden" name="url" value="welcome.jsp">
			--%>
			</div>
		</form>
		</div>
		
		<div id="footer">
			<div
				style="background-color: maroon; min-height: 4px; margin-bottom: 4px;"></div>
			<jsp:include page="/form/footer_Form.jsp" />
		</div>
		</div>

</body>
</html>
