<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/table.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/checkbox.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

<script type="text/javascript">
	//삭제할 때 체크박스 board.jsp
	function admincheck() {
		cbox = adminfrm.adminid;
		if (cbox.length) { // 여러 개일 경우
			for (var i = 0; i < cbox.length; i++) {
				cbox[i].checked = adminfrm.all.checked;
			}
		} else { // 한 개일 경우
			cbox.checked = adminfrm.all.checked;
		}
	}
	function admindelcheck() {
		var isChk = false;
		var arr_del = document.getElementsByName("adminid");
		for (var i = 0; i < arr_del.length; i++) {
			if (arr_del[i].checked == true) {
				isChk = true;
				break;
			}
		}

		if (!isChk) {
			alert("제외할 대상을 선택해주세요.");
			return false;
		} else {
			msg = "정말로 선택한 대상을 관리자에서 제외 하시겠습니까?";
			if (confirm(msg) != 0) {
				document.getElementById("amdinfrm").submit();
			} else {
				return;
			}
		}

	}
</script>
</head>
<body class="page1" id="top">
<%@include file="/WEB-INF/views/header.jsp"%>
<!--=====================
          Content
======================-->
<section class="content">
<div class="container">
	<div align="center">
	<form id="adminfrm" action="" method="post">
	<div class="table" align="center" style="margin-top:30px;">
		<div class="tr">
			<div class="td tablecss" style="padding-left:30px;">
			아이디
			</div>
			<div class="td tablecss">
			이름
			</div>
			<div class="td tablecss">
			전화번호
			</div>
			<div class="td tablecss">
			가입일
			</div>
			<div class="td tablecss" style="width:30px;">
			<input class="checkbox-style" type="checkbox" id="all" name="all" onclick="admincheck()"/>
			<label for="all"></label>
			</div>
		</div>
		<c:forEach var="admin" items="${admins}" varStatus="status">
		<div class="tr">
			<div class="td tableline">
			${admin.sphinxId}
			</div>
			<div class="td tableline">
			${admin.name} <img src="<%=request.getContextPath()%>/resources/images/icon/crown.png">
			</div>
			<div class="td tableline">
			${admin.phoneNum}
			</div>
			<div class="td tableline">
			${admin.joinDate}
			</div>
			<div class="td tableline">
			<input class="checkbox-style" type="checkbox" id="adminid${status.count}" name="adminid" value="${admin.customerId}"/>
			<label for="adminid${status.count}"></label>
			</div>
		</div>
		</c:forEach>
		<div class="tr">
			<div class="td">
			</div>
			<div class="td">
			</div>
			<div class="td">
			</div>
			<div class="td">
			</div>
			<div class="td" style="padding: 5px;">
				<a class="btn" onclick="admindelcheck()" style="border: solid 1px #aaccaa; display: inline; padding:0; width:28px; height:20px; cursor: pointer;">
				<font size="2">제외</font>
				</a>
			</div>
		</div>
	</div>
	
	<!-- -------------------------------------------------------------
	------------------------------페이징------------------------------
	--------------------------------------------------------------- -->
	<div style="margin-top: 50px; margin-bottom: 30px;">
		<a href="<%=request.getContextPath()%>/admin/customer/adminpage?page=1">
			<< 
		</a>
		&nbsp;&nbsp;
		<font size="3">
		<c:forEach var="p" items="${pageList}">
			<a href="<%=request.getContextPath()%>/admin/customer/adminpage?page=${p}">
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
		<a href="<%=request.getContextPath()%>/admin/customer/adminpage?page=${maxPage}">
			 >>
		</a>
	</div>
	<!-- -------------------------------------------------------------
	------------------------------페이징 끝----------------------------
	--------------------------------------------------------------- -->
	</form>
	</div>
</div>
</section>
<!--==============================
              footer
=================================-->
<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>