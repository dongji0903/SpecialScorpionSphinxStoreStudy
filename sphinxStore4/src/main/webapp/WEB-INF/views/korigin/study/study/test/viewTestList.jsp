<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body><div style="padding-left: 300px;text-align: left;">
시험지 목록보기화면<div align="center">
<c:forEach items="${testList}" var="oneSheet" varStatus="stat">
<div id="menu_Link">${stat.count }. <a href="<%=request.getContextPath() %>/study/getTestSheet.do?sid=${oneSheet.sid }">${oneSheet.title }</a></div>
</c:forEach>
</div>
</div>
</body>
</html>