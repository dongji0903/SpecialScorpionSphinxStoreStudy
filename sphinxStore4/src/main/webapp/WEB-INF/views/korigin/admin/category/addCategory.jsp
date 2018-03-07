<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>카테고리 추가</title>
</head>
<body>
<form action="<%=request.getContextPath() %>/admin/category/addCategory" method="post">
	카테고리 명 : <input type="text" name="categoryName"> <br>
	상위 카테고리 : <input type="text" name="superId"> <br>
	<!-- 상위카테고리를 지정할 수 있도록 목록 불러오기 -->
	<input type="submit" value="넣어">
	</form>
	<c:if test="${msg != null }">${msg }</c:if>
	
</body>
</html>