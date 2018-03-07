<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>시험 양식 만들기</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/dug_Korea.css">
<script type="text/javascript">
function openW(url) {
	window.open(url, '_blank_1','toolbar=no,menubar=no,scrollbars=yes,resizable=no, width=600, height=600, top = 50, left =400');
}

function create(type){

	switch (type) {
	case "jongryu":

		var text =  document.formform.jongryuText.value;
		var url = "<%=request.getContextPath()%>/study/createJy.do?text="+text+"&type="+type;
		window.open(url, '_blank_1','toolbar=no,menubar=no,scrollbars=yes,resizable=no, width=600, height=400, top = 50, left =400');
		break;
		
	case "yeongyoeck":
		var text = document.formform.yeongyukText.value;
		var url = "<%=request.getContextPath()%>/study/createJy.do?text="+text+"&type="+type;
		window.open(url ,'_blank_1','toolbar=no,menubar=no,scrollbars=yes,resizable=no, width=600, height=400, top = 50, left =400');
		break;
		
	default:
		break;
	}
	
}

</script>

</head>
<body>
<form name="formform" action="<%=request.getContextPath()%>/study/setGlist.do ">
	
	<table>
	<tr>
	<th> 시험종류 </th>
	<td>
	<input type="text" name="jongryuText"> <input type="button" value="추가" onclick="create('jongryu')"><br>
	<select name="jeongryu">
	<c:forEach var="jongryu" items="${jongryuList}">
	<option value="${jongryu}">${jongryu}</option>
	</c:forEach>
	</select>

	</td>
	</tr>
	<tr>
	<th> 영역 </th>
		<td><input type="text" name="yeongyukText"> <input type="button" value="추가" onclick="create('yeongyoeck')" ><br>
	<select name="yeongyuk">
	<c:forEach var="yongyuk" items="${yeongyukList}">
	<option value="${yongyuk}">${yongyuk}</option>
	</c:forEach>
	</select>
	</td>
	</tr>
	<tr>
	<th>유형 </th><td> <input type="text" name="toList" readonly="readonly">
	<input type="button" value="추가" onclick="openW('<%=request.getContextPath()%>/study/getYh.do?Jyp=yh')"></td>
	</tr>
	</table>
	
	<input type="submit" value="지문 추가하기">
	
</form>
</body>
</html>
