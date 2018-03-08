<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>카테고리</title>

<script type="text/javascript">
	function editCat() {
		var url = "<%=request.getContextPath()%>/admin/getSuperCategory.do?selectId="
				+ document.frm1.cid.value;
		location.href=url;
	}
	function addCat() {
		var url="<%=request.getContextPath()%>/admin/addCategory.do?superCid="+document.frm1.cid.value;
		location.href=url;
	}

</script>
</head>
<body>
	<div style="height: 600px; text-align: left;">
		<form name="frm1" action="<%=request.getContextPath()%>/admin/editCategory.do" method="post">
			<div style="width: 400px;">
			<div style="float: left;">
				<span style="display: inline-block;width:90px;text-align: right;"> 카테고리 ID:</span><input name="cid" type="text"
					value="${categoryMap.get(param.selectId).cid }" readonly="readonly"><br>
				<span style="display: inline-block;width:90px;text-align: right;"> 이름:</span><input type="text" name="title"
					value="${categoryMap.get(param.selectId).title }">
			</div>
			<div style="float: left; margin-left: 30px;">
				<input type="submit" value="수정" style="width: 100px; height: 65px;">
			</div>
			</div>
			<div style="clear: left;">
				<br>상위 카테고리:<br>
				<c:set var="currentCategory" value="${categoryMap.get(param.selectId) }"></c:set>
				
					<c:if test="${param.hiddenName!=null}">
					ID:<input type="text" name="parentIds" value="${param.cid}"
					readonly="readonly"> 이름:
					<input name="parentName" type="text" value="${param.hiddenName}">
					</c:if>
					<c:if test="${param.hiddenName==null}">
					ID:<input type="text" name="parentIds" value="${currentCategory.parent!=null?currentCategory.parent:null }"
					readonly="readonly"> 이름:
					<input name="parentName"
					type="text" value="${currentCategory.parent!=null?categoryMap.get(currentCategory.parent).title:null}"
					readonly="readonly">
					</c:if>
					<input type="button" value="변경" onclick="editCat()" />
			</div>

			
			<div style="position: relative; top: 20px">
		
					<input type="button" value="하위 카테고리 추가" onclick="addCat()">
			</div>
		</form>
	</div>
</body>
</html>