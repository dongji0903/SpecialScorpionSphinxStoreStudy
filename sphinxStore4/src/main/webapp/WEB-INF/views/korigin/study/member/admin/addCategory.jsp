<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>카테고리</title>
<script>
</script>

</head>

<body>
	 <div style="height: 600px; text-align: left;">
		<form name="frm1" action="<%=request.getContextPath() %>/admin/registCategory.do" method="post">
			<div>
			<div style="float: left;">
				새 카테고리 등록<br><br>
				카테고리 이름:<input type="text" name="title">
			</div>
			<div style="float: left; margin-left: 30px;">
				<input type="submit" value="등록" style="width: 100px; height: 65px;">
			</div>
			</div>
			<div style="clear: left;"><c:if test="${parent!=null }">
				<br> 상위 카테고리:<br>
				ID:<input type="text" name="parentIds"
					value="${parent!=null?parent.cid:null}"
					readonly="readonly"> 이름:<input name="parentName"
					type="text"
					value="${parent!=null?parent.title:null}"
					readonly="readonly">
					</c:if>
			</div>
		</form>
	</div>
</body>
</html>