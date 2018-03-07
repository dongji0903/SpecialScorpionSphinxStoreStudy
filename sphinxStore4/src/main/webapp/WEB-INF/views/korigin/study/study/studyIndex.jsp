<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>일반 사용자 페이지</title>

<script type="text/javascript">
if(${userId == null}) {
	alert('로그인 하세요.');
	location.href="<%=request.getContextPath()%>/";
}
</script>
</head>

<body>
		<div style="float: left;"><img src="<%=request.getContextPath() %>/resources/images/AW401669_02.gif" width="150" height="150"></div>
	
	
		<div style="margin-left: 270px; margin-bottom: 20px;">
			<h1 style="color: black;">
				지금부터 시험을 시작하도록 하지!
				</h1>
				<hr>
		</div>
				 <div style="margin-left: 300px;">
					 <div id="menu_Link" >
					 <a href="<%=request.getContextPath() %>/study/getFirstCategory.do">Quiz</a>
					 </div>
					 <div id="menu_Link" >	 
					 <a href="<%=request.getContextPath() %>/study/getAllTest.do">Take Test</a>
					 </div>
					 <div id="menu_Link" >	 
					 <a href="<%=request.getContextPath() %>/study/examIndex.do">Take Exam</a>
					 </div>
					 <hr align="left" width="400px">
					 <div id="menu_Link" >
					 <a href="<%=request.getContextPath() %>/study/inputQuestion.do">Make Question</a>
					 </div>
					 <div id="menu_Link" >
					 <a href="<%=request.getContextPath() %>/study/setTest.do">Make Test</a><br>
					 </div>
					 <div id="menu_Link" >
					 <a href="<%=request.getContextPath() %>/study/initExamForm.do">Make Exam</a>
					 </div>
					 <div id="menu_Link" >
					 <a href="<%=request.getContextPath() %>/study/setExamForm.do">Make ExamForm</a>
					 </div>
			   </div>
			
</body>
</html>