<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원관리</title>
<script type="text/javascript">
	function delMember() {

		var list = document.getElementsByName("delList");
		var result = 0;
		for (var i = 0; i < list.length; i++) {
			if (list[i].checked) {
				result = 1;
			}
		}
		if (result == 1) {
			return true;
		} else {
			alert('false');
			return false;
		}
	}
</script>
</head>
<body>
	<c:if test="${memberList!=null }">
		<form action="<%=request.getContextPath() %>/admin/deleteMember.do" method="post">
			<table>
				<tr>
					<th>선택</th>
					<th>ID</th>
					<th>이름</th>
					<th>구분</th>
				</tr>
				<c:forEach items="${memberList }" var="member">
					<tr>
						<td><input type="checkbox" name="delList" value=${member.id }>
						<td>${member.id }</td>
						<td>${member.name }</td>
						<td>${member.memberType }</td>
					</tr>
				</c:forEach>
				<tr>
					<td><input type="submit" onclick="return delMember()"
						value="잘가요" /></td>
				</tr>
			</table>
		</form>
	</c:if>
</body>
</html>