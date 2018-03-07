<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>카테고리</title>

<style>
a{	
	text-decoration: none; /* 링크 밑줄 없애기 */
	color:black; /* 글 색상 */
	font-family: fantasy;
}

a:hover {
	text-decoration: none;/*밑 줄*/
	color: green; /* 글색상*/
}
</style>

<script type="text/javascript">
function putName(i) {
	document.frm2.hiddenName.value=i;
}
</script>
</head>
<body>
	<form name="frm2" action="<%=request.getContextPath()%>/admin/categoryEdit.jsp">
		<input type="hidden" name="hiddenName">
		<div>
			변경할 상위 카테고리를 선택하세요 <br>(현재 상위 카테고리:
			<c:if test="${presentSuper!=null }">[${presentSuper.cid }]${presentSuper.title })</c:if>
		</div>
		<br>
		<c:forEach items="${availableCategories}" var="category"
			varStatus="stat">
			<div>
			<a href="<%=request.getContextPath()%>/admin/categoryEdit.jsp?selectId=${param.selectId}&hiddenName=${category.title}&cid=${category.cid }">
			[${category.cid}]  ${category.title }</a>		
			</div>
		</c:forEach>

	</form>
</body>
</html>