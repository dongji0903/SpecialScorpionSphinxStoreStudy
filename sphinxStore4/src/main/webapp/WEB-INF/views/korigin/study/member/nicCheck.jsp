<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>별명 중복확인</title>
<script>

function upCheck() {
	opener.frm1.nicName.value=document.frm.nicName.value;
	self.close();
}

</script>
</head>
<body>
<h3> 별명 중복 확인</h3>
<form action ="nicCheck.do" method="get" name="frm">
별명 <input type="text" name= "nicName" value="${nicName}">
<input type = "submit" value="중복 체크">
<br>

<c:if test ="${result==1}">
<script type="text/javascript">
opener.document.frm.nicName.value="";
</script>

${nicName}는 이미 사용 중인 별명 입니다.
</c:if>

<c:if test="${result==-1}">
${nicName}는 사용 가능한 별명 입니다.
<input type="button" onclick="upCheck()" value="사용">
</c:if>

</form>

</body>
</html>