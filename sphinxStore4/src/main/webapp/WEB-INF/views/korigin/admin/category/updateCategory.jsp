<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>카테고리명 변경</title>
</head>
<body>
	<form name="frm"
		action="<%=request.getContextPath()%>/admin/category/updateCategory"
		method="post">
		변경할 카테고리 : <input type="text" name="categoryId"><input type="button" value="찾기"
			onclick="window.open('findCategory','_blank_1','toolbar=no,menubar=no,scrollbars=yes,resizable=no, width=450, height=200');"> <br>
		<input type="hidden" name="superId" value="${superId }">
		현재 카테고리 명 : <input type="text" name="categoryName" value="${categoryName }" readonly="readonly"> <br>
	 	바꿀 카테고리 명 : <input type="text" name="updateCategoryName"> <br>
	 	 <input type="submit" value="바꿔">
	</form>
	<c:if test="${msg != null }">${msg }</c:if>


</body>
</html>