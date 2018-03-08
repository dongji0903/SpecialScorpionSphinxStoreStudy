<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>문제가져오기</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/dug_Korea.css">
<script type="text/javascript">
function resizeWin(win) {
	var wid=700;
	var hei=win.document.body.offsetHeight+100;
	win.resizeTo(wid,hei);
}
function expand(i,i2) {
	var child=i.firstChild.nextSibling.nextSibling;
	if(child.style.display=="none"){
		child.style.display="";
		i.firstChild.style.backgroundColor="yellowgreen";
	}else{
		child.style.display="none";
		i.firstChild.style.backgroundColor="white";
	}
}
function putThisQ(s,i) {
	var qTextContent=i.parentElement.firstChild.nextSibling.nextSibling.nextSibling.firstChild.textContent;
	var qText=opener.document.getElementById('Q${param.Qnum}');
	qText.textContent=qTextContent;
	qText.nextSibling.value=s;
	self.close();
}
</script>
</head>
<body onload="resizeWin(this)">
<c:if test="${requestScope.qList!=null && not empty requestScope.qList }">
<table width="700px">
<tr>
<th>No</th><th width="300px">내용</th><th width="100px">주/객관식</th><th>출처</th><th>선택</th>
</tr>
<c:forEach items="${requestScope.qList }" var="question" varStatus="stat">
<tr>
<td>${stat.count }</td>
<td onclick="expand(this,'${stat.index}')" width="300px" height="50px" style="overflow: hidden;"><div>${question.text }</div>
<div style="display: none;">
<hr>첨부파일:(${qestion.fileType })${question.fileUrl }
<hr>카테고리:<c:forEach items="${question.categories }" var="category">${category.title }.</c:forEach>
<c:if test="${question.distractorList!=null }">
<hr><c:forEach items="${question.distractorList }" var="dis" varStatus="stat2">${stat2.count }.${dis.text }<br></c:forEach>
</c:if>
</div>
</td><td>${question.qtype }</td><td>${question.source }</td>
<td id="btn${stat.count }">
<script type="text/javascript">
var alreadyAddedQuestions=opener.document.getElementsByName('questionId');
var added=0;
for(var i=0;i<alreadyAddedQuestions.length;i++){
	if(alreadyAddedQuestions[i].value=='${question.qid}'){
		btn${stat.count}.textContent='입력됨';
		added=1;
	}
}
if(added==0){
	var btn=document.createElement('input');
	btn.type='button';
	btn.onclick=function(){putThisQ('${question.qid}',btn${stat.count})};
	btn.value='선택';
	btn${stat.count}.appendChild(btn);
}
</script></td>
<%-- <button onclick="putThisQ('${question.qid}',this)">선택</button> --%>
</tr>
</c:forEach>
</table>
</c:if>
</body>
</html>