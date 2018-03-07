<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>인증</title>
<c:choose>

	<c:when test="${result == 0}">
		<script type="text/javascript">
			alert("해당하는 아이디가 없습니다.")
			history.go(-1)
		</script>
	</c:when>
	<c:when test="${result == -1}">
		<script type="text/javascript">
			alert("비밀번호가 일치하지 않습니다.")
			history.go(-1)
		</script>
	</c:when>

	<c:otherwise>
	<jsp:forward page="/main.do"></jsp:forward>
	</c:otherwise>

</c:choose>

</head>
<body>

</body>
</html>