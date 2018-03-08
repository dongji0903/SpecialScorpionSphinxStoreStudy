<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/table.css">
</head>
<body class="page1" id="top">
<%@include file="/WEB-INF/views/header.jsp"%>
<section class="content">
<%@include file="/WEB-INF/views/customer/mypage/mypage_menu.jsp"%>
<div class="container" align="center">

	<div class="table" style="margin-top: 50px;">
		<div class="tr">
			<div class="td">
				순번
			</div>
			<div class="td">
				문의
			</div>
			<div class="td">
				문의일
			</div>
			<div class="td">
				상태	
			</div>
		</div>
		<c:if test="${boardList.size() < 1}">
		<div class="tr">
			<div class="td">
				
			</div>
			<div class="td">
				문의한 이력이 없습니다.
			</div>
			<div class="td">
				
			</div>
			<div class="td">
					
			</div>
		</div>
		</c:if>
		<c:forEach var="board" items="${boardList}">
		<div class="tr">
			<div class="td">
				
			</div>
			<div class="td">
				<a href="<%=request.getContextPath()%>">
					${board.title}
				</a>
			</div>
			<div class="td">
				${board.writeDate}
			</div>
			<div class="td">
					
			</div>
		</div>
		</c:forEach>
	</div>

	<!-- -------------------------------------------------------------
	------------------------------페이징------------------------------
	--------------------------------------------------------------- -->
	<div id="pageSection" style="margin-top: 50px; margin-bottom: 30px;">
		<a href="<%=request.getContextPath()%>/mypage/myqna?page=1">
			<< 
		</a>
		&nbsp;&nbsp;
		<font size="3">
		<c:forEach var="p" items="${pageList}">
			<a href="<%=request.getContextPath()%>/mypage/myqna?page=${p}">
			<c:if test="${page == p}">
				<font color="#aaccaa" style="font-weight: bold;">
				&nbsp;${p}&nbsp;
				</font>
			</c:if>
			<c:if test="${page != p}">
				&nbsp;${p}&nbsp;
			</c:if>
			</a>
		</c:forEach>
		</font>
		&nbsp;&nbsp;
		<a href="<%=request.getContextPath()%>/mypage/myqna?page=${maxPage}">
			 >>
		</a>
	</div>
	<!-- -------------------------------------------------------------
	------------------------------페이징 끝----------------------------
	--------------------------------------------------------------- -->

</div>
</section>
<%@include file="/WEB-INF/views/footer.jsp"%> 
</body>
</html>