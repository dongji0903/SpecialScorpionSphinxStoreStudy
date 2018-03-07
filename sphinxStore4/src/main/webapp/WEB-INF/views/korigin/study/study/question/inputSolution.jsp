<%@page import="org.apache.derby.tools.sysinfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>보기 입력</title>
</head>
<body>
		<div id="container" style="padding-left: 150px">
			<form method="post" action="<%=request.getContextPath() %>/RegistQuestion.do" name="frm">
				<table border="1" width="700" height="100">
					<tr>
						<c:if test="${qtype=='o' }">
							<th>번호</th>
						</c:if>
						<th>내용</th>
						<c:if test="${qtype=='o' }">
							<th>정답여부</th>
						</c:if>
					</tr>
					<tr>
						<c:forEach var="num" begin="1" end="${numOfDistractor }"
							varStatus="status">
							<tr>
								<c:if test="${qtype=='o' }">
									<td>${status.count }</td>
								</c:if>
								<td><input type="text" name="dis"></td>
								<c:if test="${qtype=='o' }">
									<td>True<input type="checkbox" name="trueDis"
										value="${num-1 }" /></td>
								</c:if>
							</tr>
						</c:forEach>
				</table>
				<input type="submit" value="전송" /> <input type="hidden"
					name="Distractors" value="${numOfDistractor }" /> <input
					type="hidden" name="question" value="${question }" /> <input
					type="hidden" name="source" value="${source }" /> <input
					type="hidden" name="score" value="${score }" /> <input
					type="hidden" name="qtype" value="${qtype }" /> <input
					type="hidden" name="selectCategory" value="${category }" /> <input
					type="hidden" name="fileUrl" value="${fileUrl }" />
			</form>

		</div>
</body>
</html>