<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/table.css">

<title>Insert title here</title>
</head>
<body>
<div align="center">
<div class="table" align="center" style="margin-top: 30px; margin-bottom: 30px; min-width: 600px;">
		<div class="tr">
			<div class="td">
				<font size="3">이용약관</font>
			</div>
		</div>
		<div class="tr">
			<div class="td">
				<textarea id="useability" name="useability" disabled="disabled" style="width: 90%; height: 200px; resize: horizontal;">
<c:forEach var="ability" items="${useability}">
${ability}
</c:forEach>
				</textarea>
			</div>
		</div>
		<div class="tr">
			<div class="td" style="padding-top: 50px;">
				<font size="3">개인정보 수집 및 이용에관한 동의</font>
			</div>
		</div>
		<div class="tr">
			<div class="td">
				<textarea id="agreePrivacy" name="agreePrivacy" disabled="disabled" style="width: 90%; height: 200px; resize: horizontal;">
<c:forEach var="privacy" items="${agreePrivacy}">
${privacy}
</c:forEach>				
				</textarea>
			</div>
		</div>
	</div>
	</div>
</body>
</html>