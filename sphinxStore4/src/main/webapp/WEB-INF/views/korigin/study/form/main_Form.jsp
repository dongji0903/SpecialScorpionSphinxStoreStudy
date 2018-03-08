<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<html>
<head>
<title>메인 화면</title>
   <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/dug_Korea.css">



</head>
<body >
<div>
	<div id="wrap" align="center">
		<div id="header" >
			<jsp:include page="header_Form.jsp" />
		</div>
		
	<div id="middle" >
			<c:if test="${url!=null }">
			<jsp:include page="${url }"></jsp:include>
			</c:if>
			<c:if test="${url==null }">
			 <jsp:include page="miniBoard.jsp" flush="false"></jsp:include>
			</c:if>
		</div>

	</div>
		<div id="footer">

			<jsp:include page="footer_Form.jsp" />
		</div>
	</div>
</body>
</html>