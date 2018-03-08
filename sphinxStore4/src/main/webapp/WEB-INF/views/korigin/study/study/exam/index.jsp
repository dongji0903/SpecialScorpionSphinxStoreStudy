<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index</title>
</head>
<body>
시험목록
<c:forEach items="${examList}" var="oneSheet" varStatus="stat">
<div id="menu_Link">${stat.count }. <a href="<%=request.getContextPath() %>/study/getExamSheet.do?sid=${oneSheet.sid }">${oneSheet.title }</a></div>
</c:forEach>

</body>
</html>