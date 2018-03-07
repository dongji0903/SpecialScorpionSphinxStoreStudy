<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>아이디 중복확인</title>
<script>

function upCheck() {
	opener.frm1.userId.value=document.frm.userId.value;
	opener.frm1.idChecked.value="true";
	self.close();
}

</script>
</head>
<body>
<h3> 아이디 중복 확인</h3>
<form action ="/DUG/member/idCheck.do" method="post" name="frm">
아이디 <input type="text" name= "userId" value="${userId}">
<input type = "submit" value="중복 체크">
<br>

<c:if test ="${result == 1}">
<script type="text/javascript">
opener.document.frm1.userId.value="";
</script>

${userId}는 이미 사용 중인 아이디 입니다.
</c:if>

<c:if test="${result == -1}">
${userId}는 사용 가능한 아이디 입니다.
<input type="button" onclick="upCheck()" value="사용">
</c:if>

</form>

</body>
</html>