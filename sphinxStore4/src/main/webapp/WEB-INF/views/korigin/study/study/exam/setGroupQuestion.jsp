<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>지문 설정하기</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/dug_Korea.css">

</head>

<body>
<form action="<%=request.getContextPath() %>/study/registExamForm.do" name="frm" enctype="multipart/form-data">
<table >
<tr><th>시험 명 </th>
<td>${param.jeongryu}</td></tr>
<tr><th>영역  </th>
<td>${param.yeongyuk}</td></tr>
<tr><th>표지</th><td><input name="coverFile" type="file"></td></tr>
<c:forEach items="${toList}" var="yoohyong" varStatus="stat">
<tr><td id="H${stat.count }" colspan="2">

${yoohyong} 
<%-- <c:if test="${stat.count<=30 }">
<c:set var="yeongyuk" scope="page" value="듣기"></c:set>
</c:if>
<c:if test="${stat.count>30 }">
<c:set var="yeongyuk" scope="page" value="읽기"></c:set>
</c:if> --%>
<input  type="button" value="지문추가" onclick="window.open('<%=request.getContextPath()%>/study/getGList.do?yeongyoeck=읽기&yoohyong=${yoohyong }&hnum=H${stat.count }','_blank_1','toolbar=no,menubar=no,scrollbars=no,width=10,height=10')">
</td></tr>
</c:forEach>
</table>
<br>
<br>
<input type="hidden" name="jongryu" value="${param.jeongryu }">
<input type="hidden" value="${toList.size() }">
<input type="submit" value="선 택">
</form>
</body>
</html>