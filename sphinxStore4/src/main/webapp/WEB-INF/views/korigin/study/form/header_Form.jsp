<%@page import="sun.rmi.server.Dispatcher"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Form</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/dug_Korea.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/menubar.css">
<style type="text/css">
#topline {
	text-align: right;
	font-size: small;
	vertical-align: top;
	position: relative;
	width: 1004px;
	height: 28px;
	margin-bottom: -10px;
}

#logo {
	margin: 10px;
	width: 230px;
	height: 150px;
}
</style>
<script>
	var hoverCount = 0;
	var clickCount = 0;
	function loginCheck() {
		if (document.frm.UserId.value.length == 0) {
			alert("아이디를 입력하세요");
			frm.userId.focus();
		}
		if (document.frm.Password.value == "") {
			alert("암호를 입력하세요");
			frm.userPassword.focus();
		} else {
			document.frm.submit();
		}
	}
	function enterKey() {
		if (window.event.keyCode == 13) {
			loginCheck();
		}
	}
	function menuOver(i) {
		var menus = document.getElementsByName('menu');
		hoverCount = hoverCount + 1;
		var mcolor;
		for (var k = 0; k < menus.length; k++) {
			if (menus[k] == i) {
				mcolor = 'rgb(' + (k < 3 ? 255 : 0) + ','
						+ (k == 1 ? 165 : k > 1 ? k < 4 ? 255 : 0 : 0) + ','
						+ (k == 4 ? 255 : 0) + ')';
				i.parentElement.style.backgroundColor = mcolor
			}
		}
		for (var k = 0; k < menus.length; k++) {
			menus[k].parentElement.style.borderBottom = 'medium solid '
					+ mcolor;
		}
	}
	function menuOut(i) {
		var menus = document.getElementsByName('menu');
		hoverCount = hoverCount - 1;
		if (hoverCount == 0 && clickCount == 0) {
			i.parentElement.style.backgroundColor = 'white'
			for (var k = 0; k < menus.length; k++) {
				menus[k].parentElement.style.borderBottom = "medium solid silver";
			}
		}
	}

	function mClick(i) {
		clickCount = 1;
	}
</script>
</head>

<body>

	<div id="topline" align="right">
		<c:if test="${userName==null}">
			<form action="<%=request.getContextPath()%>/member/login"
				method="post" name="frm">
				ID : <input onkeyup="enterKey()" type="text" size="14" name="UserId"
					value="${cookie.id.value }"> &nbsp; ID저장<input
					type="checkbox" name="idSave">
				<c:if test="${cookie.id!= null }">
					<script type="text/javascript">
						frm.idSave.checked = 'true'
					</script>
				</c:if>
				PW : <input onkeyup="enterKey()" type="password" size="14"
					name="Password">&nbsp; <a href="#"
					onclick="loginCheck()"> Login </a>&nbsp;&nbsp;&nbsp; <a
					href="<%=request.getContextPath()%>/member/join">
					Join </a>&nbsp;
			</form>

		</c:if>
		<c:if test="${userName!=null}">
			<c:if test="${memberType=='admin' }">
				<a style="border: 1px solid #797979; background-color: hotpink;"
					href="<%=request.getContextPath()%>/admin/adminPage.jsp"><font
					color="white">관리자페이지</font></a>
			</c:if>
    ${userName} 안녕 &nbsp; 
    <a href="<%=request.getContextPath()%>/member/logout"> Logout
				&nbsp; &nbsp;</a>
			<a href="<%=request.getContextPath()%>/myPage/index.do"> Mypage
				&nbsp; &nbsp;</a>
		</c:if>
	</div>

	<%-- <div style="width: 260px; height: 100px; float: left;">
		<div id="logo">
			<button
				onclick="location.href='<%=request.getContextPath()%>/main.do'">D
				U G</button>
			<img src="<%=request.getContextPath() %>/upload/디유지.png" height="100px" width="200px" onclick="location.href='<%=request.getContextPath() %>/Form/main_Form.jsp'">
   
			<div id="linker">
				<a name="menu" href="<%=request.getContextPath()%>/company/index.do"
					onclick="mClick(this)" onmouseover="menuOver(this)"
					onmouseout="menuOut(this)"> 소 개 </a>
			</div>
			<div id="linker">
				<a name="menu" href="<%=request.getContextPath()%>/study/index.do"
					onclick="mClick(this)" onmouseover="menuOver(this)"
					onmouseout="menuOut(this)"> 학습하기 </a>
			</div>
			<div id="linker">
				<a name="menu" href="<%=request.getContextPath()%>/shop/index.do"
					onclick="mClick(this)" onmouseover="menuOver(this)"
					onmouseout="menuOut(this)"> 상 품 </a>
			</div>
			<div id="linker">
				<a name="menu" href="<%=request.getContextPath()%>/board/index.do"
					onclick="mClick(this)" onmouseover="menuOver(this)"
					onmouseout="menuOut(this)"> 게시판</a>
			</div>
		</div>
	</div> --%>
	<div style="width: 260px; height: 100px; float: left;">
		<div id="logo">
			<button
				onclick="location.href='<%=request.getContextPath()%>/'">D
				U G</button>
		</div>
	</div>
	<nav>
	<ul style="width: 700px">
		<li><a name="menu"
			href="<%=request.getContextPath()%>/company/index.do"> 소 개 </a></li>
		<li><a name="menu"
			href="<%=request.getContextPath()%>/study/index"> 학습하기 </a>
			<ul>
				<li>
				<a href="<%=request.getContextPath()%>/study/getFirstCategory.do">Quiz</a>
				<a href="<%=request.getContextPath()%>/study/getAllTest.do">Take Test</a>
				<a href="<%=request.getContextPath()%>/study/examIndex.do">Take Exam</a>
				</li>
			</ul>
		</li>
		<li><a name="menu"
			href="<%=request.getContextPath()%>/shop/index.do"> 상 품 </a></li>
		<li><a name="menu"
			href="<%=request.getContextPath()%>/board/index.do"> 게시판</a>
			<ul>
				<li>
				<a href="<%=request.getContextPath()%>/board/getList.do?category=공지사항"> 공지사항 </a>
				<a href="<%=request.getContextPath()%>/board/getList.do?category=공연게시판"> 공연게시판 </a>
				<a href="<%=request.getContextPath()%>/board/getList.do?category=묻고답하기"> 묻고답하기 </a>
				<a href="<%=request.getContextPath()%>/board/getList.do?category=자료실"> 자료실 </a>
				</li>
			</ul>
		</li>
	</ul>
	</nav>


</body>


</html>