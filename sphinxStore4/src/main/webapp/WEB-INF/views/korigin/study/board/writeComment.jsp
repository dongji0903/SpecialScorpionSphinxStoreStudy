<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>덧글</title>
<script type="text/javascript">
function click() {
	if(content.value == null){
		alert("내용을 입력하세요");
		return false;
	}else{
		return true;
	}

}
</script>
</head>
<body>
<form action="<%=request.getContextPath() %>/board/writeComment.do">
<table>
<tr>
<th>댓글작성</th>
<td><textarea cols="80" rows="2" name="content"></textarea>
<input type="submit" value="등록" onclick="return click()">
<input type="hidden" value="${param.num}" name="num">
<input type="hidden" value="${sessionScope.nickName}" name="name">
<input type="hidden" value="${sessionScope.category}" name="category">
</td>

</table>
</form>
</body>
</html>