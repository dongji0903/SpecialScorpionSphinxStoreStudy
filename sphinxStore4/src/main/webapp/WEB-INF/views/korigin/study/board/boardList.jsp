<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page import="java.util.List"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판</title>

<%
	if (session.getAttribute("userName") == null) {
%>
<script type="text/javascript">
	alert("로그인을 핫세요")
	history.go(-1)
</script>
<%
	}
%>


<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/dug_Korea.css">


</head>
<body>

			<div id="main">
				<jsp:include page="index.jsp" />
			</div>

			<div id="container">

				<table class="list">
					<c:if test="${category == '공지사항' && isAdmin == 1}">
					<tr>
						<td colspan="5" style="border: white; text-align: right"><a
							href="<%=request.getContextPath()%>/board/writePage.do">글
								쓰기</a></td>
					<tr>
					</c:if>
					
					<c:if test="${category == '공지사항' && isAdmin == 0}">
					<tr>
						<td colspan="5" style="border: white; text-align: right">공지사항</td>
					<tr>
					</c:if>
					
					<c:if test="${category != '공지사항'}">
					<tr>
						<td colspan="5" style="border: white; text-align: right"><a
							href="<%=request.getContextPath()%>/board/writePage.do?category=${param.category}">글
								쓰기</a></td>
					<tr>
					</c:if>
					
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>조회</th>
					</tr>
					<c:if test="${searchBoardList != null}">
						<%-- 검색어가 있을때 12개씩 출력 --%>
						<c:forEach var="board" items="${searchBoardList}">
							<tr class="record">
								<td>${board.num}</td>
								<td><a
									href="<%=request.getContextPath() %>/board/getDetail.do?num=${board.num}&category=${param.category}">
										${board.title} </a></td>
								<td>${board.nickName}</td>
								<td><fmt:formatDate value="${board.writedate}" /></td>
								<td>${board.readcount}</td>
							</tr>
						</c:forEach>
					</c:if>


					<c:if test="${searchBoardList == null}">
						<%-- 검색어가 없을때 12개씩 출력 --%>
						<c:forEach var="board" items="${boardList}">
							<tr class="record">
								<td>${board.num}</td>
								<td><a
									href="<%=request.getContextPath() %>/board/getDetail.do?num=${board.num}&category=${param.category}">
										${board.title} </a></td>
								<td>${board.nickName}</td>
								<td><fmt:formatDate value="${board.writedate}" /></td>
								<td>${board.readcount}</td>
							</tr>
						</c:forEach>
					</c:if>

				</table>

				<form action="<%=request.getContextPath()%>/board/searchBoard.do"
					method="get">
					<select name="searchSelect">
						<option value="제목">제목</option>
						<option value="작성자">작성자</option>
						<option value="내용">내용</option>
					</select> <input type="text" name="search" size="10"> <input
						type="submit" value="검색">
				</form>
				<br> <br> <input type="hidden" name="pageNumber"
					value="${param.pageNumber}">

				<!-- 검색x  -->
				<c:if test="${searchBoardList == null}">
					<c:if test="${prevBlock > 0}">
						<a
							href="<%=request.getContextPath() %>/board/getList.do?pageNumber=${prevBlock}&category=${param.category}">Prev</a>
					</c:if>

					<c:forEach var="blockNum" items="${blockList}" varStatus="status">
						<a
							href="<%=request.getContextPath() %>/board/getList.do?pageNumber=${blockNum}&category=${param.category}">${blockNum}</a>
					</c:forEach>

					<c:if test="${nextBlock < totalPageNum}">
						<a
							href="<%=request.getContextPath() %>/board/getList.do?pageNumber=${nextBlock}&category=${param.category}">Next</a>
					</c:if>
				</c:if>

				<!-- 검색o  -->

				<c:if test="${searchBoardList != null}">
					<c:if test="${prevBlock > 0}">
						<a
							href="<%=request.getContextPath() %>/board/searchBoard.do?pageNumber=${prevBlock}&category=${param.category}">Prev</a>
					</c:if>

					<c:forEach var="blockNum" items="${blockList}" varStatus="status">
						<a
							href="<%=request.getContextPath() %>/board/searchBoard.do?pageNumber=${blockNum}&category=${param.category}">${blockNum}</a>
					</c:forEach>

					<c:if test="${nextBlock < totalPageNum}">
						<a
							href="<%=request.getContextPath() %>/board/searchBoard.do?pageNumber=${nextBlock}&category=${param.category}">Next</a>
					</c:if>

				</c:if>
			</div>
	

</body>
</html>