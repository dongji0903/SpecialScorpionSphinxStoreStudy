<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/dug_Korea.css">
<script type="text/javascript" src="<%=request.getContextPath()%>/SmartEditer/js/service/HuskyEZCreator.js" charset="utf-8"></script>


</head>
<body>


			<div id="main">
				<jsp:include page="index.jsp" />
			</div>

			<div id="container" style="text-align: left;">
				<h1>게시글 수정</h1>
				<form name="frm" method="post" enctype="multipart/form-data"
					action="<%=request.getContextPath() %>/board/updateBoard.do">
					<input type="hidden" name="category" value="${sessionScope.category}">
					<input type="hidden" name="num" value="${board.num}"> <input
						type="hidden" name="name" value="${board.nickName}"> <input
						type="hidden" name="email" value="${board.email}">

					<table>
						<tr>
							<th>제목</th>
							<td><input type="text" name="title" value="${board.title}"></td>
						</tr>
						<c:if test="${sessionScope.category!= '자료실' }">
							<tr>
								<th>사진첨부</th>
								<td><input type="file" name="url"></td>
							</tr>
						</c:if>
						<c:if test="${sessionScope.category == '자료실' }">
							<tr>
								<th>파일올리기</th>
								<td><input type="file" name="url"></td>
							</tr>
						</c:if>
						<tr>
							<th>내용</th>
							<td><textarea rows="15" cols="70" name="content" id="content">${board.content}</textarea></td>
						</tr>

					</table>
					
						<script type="text/javascript">
					 var oEditors = [];

					 nhn.husky.EZCreator.createInIFrame({

					 oAppRef: oEditors,

					 elPlaceHolder: "content", //textarea에서 지정한 id와 일치해야 합니다.

					 sSkinURI: "<%=request.getContextPath()%>/SmartEditer/SmartEditor2Skin.html",

					 fCreator: "createSEditor2"

					 });
					 function submitContents() {

						 if (document.frm.title.value.length == 0) {
								alert("제목을 입력하세요.");
								return false;
							}
						 
						 oEditors.getById["content"].exec("UPDATE_CONTENTS_FIELD", []); // 에디터의 내용이 textarea에 적용됨

					return true;

					}

				</script>
					<br>
					<br>
					<div style="text-align: center;">
						<input type="submit" value="등 록" onclick="return submitContents()">
						&nbsp;&nbsp;&nbsp;&nbsp; <input type="reset" value="복 원">&nbsp;&nbsp;&nbsp;
						<input type="button" value="목 록"
							onclick="location.href='<%=request.getContextPath() %>/board/getList.do?category=${sessionScope.category}'">
					</div>
				</form>
			</div>


</body>
</html>