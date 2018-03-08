<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>시험출제</title>
<style>
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}

th, td {
	padding: 5px;
}

</style>
<script>
	function makeCheck() {
		if (document.frm.title.value == null
				|| document.frm.title.value == "") {
			alert("시험명을 입력하세요");
			frm.title.focus();
			return false;
		}
		if (document.frm.examinor.value == null
				|| document.frm.examinor.value == "") {
			alert("출제자 이름을 입력하세요");
			frm.examinor.focus();
			return false;
		}
		if(!document.getElementById('qList').hasChildNodes()){
			alert("문제를 추가하세요");
			frm.addBtn.focus();
			return false;
		}
	}
</script>

</head>

<body><div style="padding-left: 200px">
	<form action="<%=request.getContextPath() %>/study/registTest.do" name="frm" method="post">
		<table>
			<tr>
				<th colspan="2" style="background-color: silver;">시험출제</th>
			</tr>
			<tr>
				<th>시험 이름</th>
				<td>
				<input type="text" name="title" />
				</td>
			</tr>
			<tr>
				<th>Level 선택</th>
				<td><select name="grade">
						<option>starter</option>
						<option>Level 1</option>
						<option>Level 2</option>
						<option>Level 3</option>
						<option>Level 4</option>
						<option>Level 5</option>
				</select>
			</tr>
			<tr>
			<th>출제자</th>
			<td><input type="text" name="examinor"></td>
			</tr>
			<tr>
			<th>제한시간(초)<br>(0 : 제한없음)</th>
			<td><input type="number" min=0 name="limitTime" value=0></td>
			</tr>
			<tr>
			<th style="vertical-align: top;">문제</th>
			<td>
							<input name="addBtn" type="button"
								value="문제 추가" onclick="window.open('<%=request.getContextPath()%>/study/question/getQuestion.jsp','_blank_1','toolbar=no,menubar=no,scrollbars=no,width=10px,height=10px')">
			<ol id="qList" compact="compact" style="padding: 10px"></ol>
			
			</td>
			</tr>
		</table>
		<input type="submit" value="등록 완료" onclick="return makeCheck()">
	</form>
	</div>
</body>
</html>