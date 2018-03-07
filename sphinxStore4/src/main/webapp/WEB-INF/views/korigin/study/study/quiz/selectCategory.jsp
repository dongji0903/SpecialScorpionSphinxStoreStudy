<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Do Test</title>
<script type="text/javascript">
if(${userId == null}) {
	alert('로그인 하세요.');
	history.go(-1);
}
function putCategory(i) {
	document.frm2.hiddenCategory.value = document.frm.selectCategory[i].value;
	document.frm.submit();
}


function checkCount() {
	if(document.frm2.hiddenCategory.value==null||document.frm2.hiddenCategory.value==""){
		alert("시험과목을 선택하세요");
		return false;
	}else if(document.frm2.numOfQuestion.value==null||document.frm2.numOfQuestion.value=="" ||document.frm2.numOfQuestion.value=="0"){
		alert("문제개수를 1 이상 입력하세요.");
		return false;
	}
	return true;
}
</script>
<c:if test="${maxTotalCount != null }">
	<script type="text/javascript">
	alert("해당하는 문제가 없거나 초과입력하였습니다.\n 최대:${maxTotalCount}");
	</script>
</c:if>
</head>

<body>
	<div id="wrap"
		style="text-align: left; padding-left: 270px; width: auto;">
		<a href="<%=request.getContextPath()%>/study/getFirstCategory.do">|←</a><br>
		Select category please:
		<c:if test="${categoryPath!=null }">
			<div id="menu_Link">
				● ${categoryPath }<font color="blue">(selected)</font>
			</div>
		</c:if>
		<c:if test="${categories!=null }">
			<hr>
			<c:forEach varStatus="idx" var="category" items="${categories }">
				<div id="menu_Link">
					<c:if test="${categoryPath!=null }">─ </c:if>
					<a
						href="<%=request.getContextPath()%>/study/selectCategory.do?selectCategory=${category.cid}"
						name="selectCategory">${category.title}</a>
				</div>
			</c:forEach>
		</c:if>
		<form action="<%=request.getContextPath()%>/study/setQuiz.do"
			name="frm2" method="post">
			<div style="margin-top: 10px">
				<input type="hidden" name="hiddenCategory"
					value="${currentCategory.cid }">
				<!-- 문제 개수: <input
					type="number" name="numOfQuestion" min=1 style="width: 70px"
					value="1">  -->
				<input type="submit" value="시험시작" name="start">
			</div>
		</form>
	</div>
</body>
</html>