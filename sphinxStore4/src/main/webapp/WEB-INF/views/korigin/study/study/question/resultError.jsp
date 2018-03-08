<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>문제 입력오류</title>
</head>
<body>
<h3>문제입력에 실패하였습니다! 입력을 위한 정보가 부족(잘못)되었습니다.</h3>
<h4>부족(잘못)된 정보</h4>
<c:forEach var="error" items="${errorList }">
	${error}<br>
</c:forEach>
<h3>필요한 정보를 입력(수정)하여 주시기 바랍니다.</h3>
</body>
<!-- 필요없슴 삭제 -->
</html>