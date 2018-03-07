<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	Date date = new Date();
	request.setAttribute("date", date);
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판</title>

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/dug_Korea.css">
<script type="text/javascript" src="<%=request.getContextPath()%>/SmartEditer/js/service/HuskyEZCreator.js" charset="utf-8"></script>

<script>
	function boardCheck() {

		if (document.frm.title.value.length == 0) {
			alert("제목을 입력하세요.");
			return false;
		}
		return true;
	}
</script>
</head>
<body>

			<div id="main">
				<jsp:include page="index.jsp" />
			</div>

			<div id="container">
				<h1>게시글 등록</h1>
				<div style="width: 700px">
					<form name="frm" method="post" enctype="multipart/form-data"
						action="<%=request.getContextPath()%>/board/writeBoard.do">
						<input type="hidden" name="category"
							value="${sessionScope.category}"> <input type="hidden"
							name="name" value="${nickName}"> <input type="hidden"
							name="email" value="${email}">
						<table>

							<tr>
								<th>제목</th>
								<td><input type="text" size="70" name="title"></td>
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
								<td><textarea cols="80" rows="15" id="content"
										name="content"></textarea></td>

							</tr>

						</table>
						
				<script type="text/javascript">

					 var oEditors = [];

					 nhn.husky.EZCreator.createInIFrame({

					 oAppRef: oEditors,

					 elPlaceHolder: "content", //textarea에서 지정한 id와 일치해야 합니다.

					 sSkinURI: "<%=request.getContextPath()%>/SmartEditer/SmartEditor2Skin.html",

					 htParams : {

						// 툴바 사용 여부 (true:사용/ false:사용하지 않음)

						bUseToolbar : true,

						// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)

						bUseVerticalResizer :true,

						// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)

						bUseModeChanger : true,

						fOnBeforeUnload : function() {	}

						},

					 fCreator: "createSEditor2"

					 });
					 
					 function submitContents() {

						oEditors.getById["content"].exec("UPDATE_CONTENTS_FIELD", []); // 에디터의 내용이 textarea에 적용됨

					return true;

					}

				</script>

						<br> <br> <input type="submit" value="등 록" onclick="return submitContents()">
						<input type="button" value="목 록"
							onclick="location.href='<%=request.getContextPath() %>/board/getList.do?category=${sessionScope.category}'">
					</form>
				</div>
			</div>
			
</body>
</html>