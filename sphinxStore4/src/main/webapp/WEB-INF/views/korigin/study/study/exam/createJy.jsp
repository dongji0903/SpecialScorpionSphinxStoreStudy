
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Please Wait</title>
<script type="text/javascript">

if(${result == 1}){
	alert("DB에 성공적으로 접속하여 시험종류를 생성하는데 성공하였읍니다. 오랜시간 기다려주신 고객님께 감사의 인사를 드리며 앞으로도 꾸준한 이용 부탁드립니다. 사용하다가 불편하신 점이 있다면 000-0000으로 연락주시고 부족한 프로그램을 사용하여주셔서 다시한번 감사의 말씀 전합니다.");
	}else if(${result == -1}){
		alert('이미 생성되어 있쪙');
	}
opener.location.reload();
self.close();

</script>
</head>
<body>
</body>
</html>
