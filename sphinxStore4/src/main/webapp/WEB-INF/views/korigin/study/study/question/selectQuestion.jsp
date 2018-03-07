<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>문제 선택</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/dug_Korea.css">
<script type="text/javascript">
function resizeWin(win) {
	var wid=win.document.body.scrollWidth+100;
	var hei=win.document.body.scrollHeight+100;
	win.resizeTo(wid,hei);
}
function selected() {
	var qList=opener.document.getElementById("qList");
	var allQ=document.getElementsByName('checkedQuestions');
	var oldQList=opener.document.getElementsByName('question');
	var q=[];
	for(var i=0;i<allQ.length;i++){
		if(allQ[i].checked){
			q.push(allQ[i].value);
			for(var j=0;j<oldQList.length;j++){
				if(allQ[i].value==oldQList[j].value){
					alert(allQ[i].value+' already added');
					return false;
				}
			}
		}
	}
	for(var k=0;k<q.length;k++){
		var qItem=document.createElement('li');
		
		var qIdField=document.createElement('input');
		qIdField.type='text';
		qIdField.readOnly='readonly';
		qIdField.value=q[k];
		qIdField.name='question';
		
		qItem.appendChild(qIdField);
		
		var qDelBtn=document.createElement('input');
		qDelBtn.type='button';
		qDelBtn.value='삭제';
		qDelBtn.onclick=function(){this.parentElement.remove();};
		
		qItem.appendChild(qDelBtn);
		
		qList.appendChild(qItem);
		
	}
	self.close();
}
</script>
</head>
<body onload="resizeWin(this)"><div>
	<form action="<%=request.getContextPath() %>/ExamServlet" name="frm">
		<table border="2" style="width: 700px">
			<tr>
				<th>번호</th>
				<th>ID</th>
				<th style="word-break:break-all">문제</th>
				<th>문제형식</th>
				<th>선택</th>
			</tr>
			<c:forEach var="question" items="${selectQuestions }" varStatus="status">
				<tr>
					<td>${status.count }</td>
					<td>${question.qid }</td>
					<td style="word-break:">${question.text }</td>
					<td><c:if test="${question.qtype=='o' }"><font color="red" size="3">객관식</font></c:if> 
					<c:if test="${question.qtype=='s' }"><font color="blue" size="3">주관식</font></c:if>
					</td>
					<td><input type="checkbox" name="checkedQuestions" value="${question.qid }" /></td>
				</tr>
			</c:forEach>
		</table>
		<a href="#" onclick="selected()" style="text-decoration: none;border: 1px solid #777777;border-radius: 4px;"><font color="blue">확인</font></a>
<a href="#" onclick="self.close()" style="text-decoration: none;border: 1px solid #777777;border-radius: 4px;"><font color="red">취소</font></a>
		<input type="hidden" name="command" value="select_question_action"/>
	</form>
	</div>
</body>
</html>