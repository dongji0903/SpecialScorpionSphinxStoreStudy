<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/dug_Korea.css">
<script type="text/javascript">
function resizeWin(win) {
	var wid=700;
	var hei=win.document.body.offsetHeight+100;
	win.resizeTo(wid,hei);
}
function putG(id,text) {
	if(id!=null){
	var o = opener.document.getElementById('${param.hnum}');
	var tr1=document.createElement('tr');
	var td1=document.createElement('td');
	var hidden=document.createElement('input');
	hidden.type='hidden';
	hidden.value=id;
	hidden.name='gnum';
	td1.textContent=text;
	td1.appendChild(hidden);
	var btn=document.createElement('input');
	btn.type='button';
	btn.onclick=function(){tr1.remove();};
	btn.value='삭제';
	td1.appendChild(btn);
	tr1.appendChild(td1);
	o.appendChild(tr1);

	self.close();
	}
}
</script>
</head>
<body onload="resizeWin(this)">
<table>
<tr>
<th>지문</th><th>문제수</th><th>선택</th>
</tr>
<c:forEach items="${groupQuestions }" var="groupQ">
<tr>
<td>${groupQ.text }</td>
<td>${groupQ.numOfQuestions }</td>
<td><input name="selects" type="button" value="선택" onclick="putG('${groupQ.gid }','${groupQ.text }')"></td>
</tr>
</c:forEach>
</table>
<input type="button" value="확인" onclick="putG()"><input type="button" value="취소" onclick="self.close()">
</body>
</html>