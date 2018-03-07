<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>문제 조회</title>
<script type="text/javascript">
function resizeWin(win) {
	var wid=win.document.body.offsetWidth+200;
	var hei=win.document.body.offsetHeight+100;
	win.resizeTo(wid,hei);
}
function changeCat() {
	var cid=document.getElementById('selCat')[document.getElementById('selCat').selectedIndex].value;
	location.href="<%=request.getContextPath()%>/study/getQuestion.do?selectCategory="+cid;
	
}
</script>
</head>
<body onload="resizeWin(this)">
카테고리를 선택하시오.<br>
<select id="selCat" onchange="changeCat()" size="5">
<c:forEach items="${categoryMap }" var="category">
<option value="${category.key }">[${category.key }]${category.value.title }</option>
</c:forEach>
</select>
<c:if test="${selectCategory!=null }">

</c:if>
</body>
</html>