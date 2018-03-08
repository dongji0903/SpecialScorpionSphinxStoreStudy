<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>유형 가져오기</title>

<script>
if(${result == 1}){
	alert("DB에 성공적으로 접속하여 시험종류를 생성하는데 성공하였읍니다. 오랜시간 기다려주신 고객님께 감사의 인사를 드리며 앞으로도 꾸준한 이용 부탁드립니다. 사용하다가 불편하신 점이 있다면 000-0000으로 연락주시고 부족한 프로그램을 사용하여주셔서 다시한번 감사의 말씀 전합니다.");
	}else if(${result == -1}){
		alert('이미 생성되어 있쪙');
	}
	
function create(){
		var text =  document.frm.yoohyongText.value;
		var url = "<%=request.getContextPath()%>/study/createYh.do?text="+text+"&type=yoohyong&Jyp=yh";
		window.open(url, '_blank_1','toolbar=no,menubar=no,scrollbars=yes,resizable=no, width=600, height=400, top = 50, left =400');
		}
		
</script>

</head>
<body>
	<form action="<%=request.getContextPath()%>/study/splitYh.do" name="frm">
	<input type="text" name="yoohyongText" > <input type="button" value="생성" onclick="create()" ><br>
	<input type="submit" value="선 택"><br>
		<c:forEach items="${yuhyeongList}" var="c">
			<a href="#" onclick="opener.formform.toList.value+='${c}/';self.close();">${c }</a> <br>
		</c:forEach>
		
		<input type="hidden" value="${checkedList}" name="checkedList">
		
	<script type="text/javascript">
	if(${checkedList != null}) {
		opener.formform.yuhyeong.value = document.frm.checkedList.value;	
		opener.formform.toList.value = document.frm.checkedList.value;
		 self.close(); 
	}
	</script>
	</form>
</body>
</html>