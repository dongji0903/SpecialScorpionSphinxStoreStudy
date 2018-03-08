<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>게시판</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/dug_Korea.css">

<script type="text/javascript">

	function open_win(url, name) {
		window.open(url, name, "width=500, height=230");
	}
	
	function comment() {

		if (document.getElementById("deaYup").style.display == "") {
			document.getElementById("deaYup").style.display = "none";

		} else {
			document.getElementById("deaYup").style.display = "";

		}
	}
	
</script>
</head>

<body>

			<div id="main">
				<jsp:include page="index.jsp" />
			</div>

			<div id="container">

				<div align="left" style="margin-bottom: 5px;">
					<div >
					<div style="float: left;">
					<input type="button" value="뒤로" align="left"
						onclick="location.href='<%=request.getContextPath() %>/board/getList.do?category=${sessionScope.category}'">
					<c:if test="${board.nickName == nickName}">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="button" name="edit" value="게시글 수정"
							onclick="open_win('<%=request.getContextPath() %>/board/boardHub.jsp?num=${board.num}','update')">
						<input type="button" name="delete1" value="게시글 삭제"
							onclick="open_win('<%=request.getContextPath() %>/board/boardHub.jsp?num=${board.num}','delete')">
					</c:if>
					</div>
					<div style="float: right;">게시판상세보기</div>
				
					</div>
				</div>
				<table>
					<tr>
						<th>작성자</th>
						<td>${board.nickName}</td>
						<th>이메일</th>
						<td>${board.email}</td>
					</tr>
					<tr>
						<th>작성일</th>
						<td><fmt:formatDate value="${board.writedate}" /></td>
						<th>조회수</th>
						<td>${board.readcount}</td>
					</tr>
					<c:if test="${sessionScope.category== '자료실' }">
						<tr>
							<th>다운받기</th>
							<td colspan="3">
								<form action="<%=request.getContextPath() %>/board/fileDown.jsp">
									${board.url} <input type="hidden" value="${board.url}"
										name="url">
									<c:if test="${board.url != null}">
										<c:if test="${board.url !=''}">
											<input type="submit" value="다운">
										</c:if>
									</c:if>
								</form>
							</td>
						<tr>
					</c:if>
					<tr>
						<th>제목</th>
						<td colspan="3">${board.title}</td>
					</tr>
					<tr>
						<th>내용</th>
						<td style="text-align: left; vertical-align: top; height: 300px;" colspan="3">
						<c:if test="${sessionScope.category!='자료실'}">
						<c:if test="${board.url != null}">
						<img src="<%=request.getContextPath() %>/upload/${board.url}" width="200px" height="150px">
						<br>
						</c:if>
						</c:if>						
						${board.content}</td>
					</tr>
				</table>
				<div align="left" style="margin: 10px;">
					<a href="#" onclick="comment()"> 댓 글 </a>
				</div>
				<div id="deaYup" style="text-align: left;">
					<table style="padding-top: 10px;">
						<c:forEach var="comm" items="${com}">
							<tr>
								<td>${comm.nickname}&nbsp;&nbsp; ${comm.writedate}
								<c:if test="${comm.nickname==nickName}">
								<a href="<%=request.getContextPath() %>/board/deleteComment.do?number=${comm.num}&num=${board.num}">
								&nbsp;&nbsp;&nbsp; 삭제</a>
								</c:if>
								 <br>
									${comm.content}&nbsp;&nbsp;
									
								</td>
							</tr>
						</c:forEach>
					</table>
					<div style="">
						<jsp:include page="writeComment.jsp">
							<jsp:param name="num" value="${board.num}" />
						</jsp:include>
					</div>
				</div>
			</div>


</body>
</html>