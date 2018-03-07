<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>관리자</title>
<c:if test="${isAdmin!=1 }">
	<script type="text/javascript">
		alert("잘못된 접근입니다.");
		history.go(-1);
	</script>
</c:if>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/dug_Korea.css">
	<style type="text/css">
.m_over {	background : orange;	color : white;	}
.m_out {	background : white;	color : black;	}
.act {	background : green;	color : white;	}
</style>
<script type="text/javascript">
function over(obj){ 
	if(obj.className != "act") {
	obj.className = "m_over";
	}
	} 
	// 롤아웃 
	function out(obj){ 
	if(obj.className != "act") {
	obj.className = "m_out";
	}
	} 
	// 클릭 
	function clicks(obj){ 
	var divs = document.getElementById("tab").getElementsByTagName("div"); 
	for(var i=0; i<divs.length; i++){ 
	divs[i].className = "m_out";
	}
	obj.className = "act";
	}
</script>
</head>
<body>
	<div id="wrap" align="center">
		<div id="header">
			<jsp:include page="/form/header_Form.jsp" />
		</div>
	<div style="height: 600px;">
		<div style="padding-left: 300px">
			<div id="menu_Link" >
				<a onmouseover="over(this)" onmouseout="out(this)" onclick="clicks(this)" id="1"
					href="<%=request.getContextPath()%>/admin/getAllMember.do">회원
					관리</a> 
			</div>
			<div id="menu_Link">
				<a onmouseover="over(this)" onmouseout="out(this)" onclick="clicks(this)" id="2"
					href="<%=request.getContextPath()%>/admin/getAllCategory.do">카테고리
					관리</a>
			</div>
			<div style="border: 1px solid">
				<c:if test="${mgmtURL!=null }">
					<jsp:include page="${mgmtURL }"></jsp:include>
				</c:if>
			</div>
			</div>
		</div>
		<div id="footer">
			<div
				style="background-color: maroon; min-height: 4px; margin-bottom: 4px;"></div>
			<jsp:include page="/form/footer_Form.jsp" />
		</div>

	</div>
</body>
</html>