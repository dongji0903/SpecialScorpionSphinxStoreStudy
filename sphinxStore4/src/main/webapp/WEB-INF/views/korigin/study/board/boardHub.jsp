<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판</title>
</head>
<body>
<script type="text/javascript">
if(window.name=="update"){
	window.opener.parent.location.href = 
		"<%=request.getContextPath() %>/board/editDetail.do?num=${param.num}";
}else if(window.name == "delete"){
	alert('삭제띙');
	window.opener.location.href = 
		"<%=request.getContextPath() %>/board/deleteBoard.do?num=${param.num}";
}
window.close();
</script>

</body>
</html>