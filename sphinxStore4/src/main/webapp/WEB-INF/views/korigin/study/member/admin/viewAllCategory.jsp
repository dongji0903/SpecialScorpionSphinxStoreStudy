<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>카테고리</title>
</head>
<body><div style="padding-left:300px; text-align: left;">
<hr>
<a style="border: 1px solid #797979;  background-color: #F9F9F9;" href="#" onclick="window.open('<%=request.getContextPath()%>/admin/addCategory.jsp', '_blank_1','toolbar=no,menubar=no,scrollbars=yes,resizable=no, width=600, height=200, top = 200, left =300')">새로운 최상위 카테고리 등록</a>
<ul>
<c:if test="${applicationScope.categoryMap!=null }">
<c:forEach items="${applicationScope.categoryMap}" var="category"><li><a href="#"onclick="window.open('<%=request.getContextPath()%>/admin/categoryEdit.jsp?selectId=${category.key}', '_blank_1','toolbar=no,menubar=no,scrollbars=yes,resizable=no, width=600, height=600, top = 50, left =400')" >${category.value.title }</a></li>
</c:forEach>
</c:if>
</ul> 
</div>
</body>
</html>