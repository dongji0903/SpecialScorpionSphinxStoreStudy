<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>포인트 사용내역</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/dug_Korea.css">
</head>
<body>
<div style="overflow: visible;">
		<table style="top: 10%; position: relative;" class="list">
			<tr>
				<th>상품주문번호</th>
				<th>상품정보</th>
				<th>상품금액</th>
				<th>배송비/판매자</th>
				<th>진행상태</th>
			</tr>
		<c:forEach items="${pointLog}" var="log" >
			<tr>
					<td>${log.num}</td>
					<td>${log.addPoint}</td>
					<td>${log.reducePoint}</td>
					<td>${log.totalPoint}</td>
					<td>${log.date}</td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<input type="hidden" name="pageNumber"
					value="${param.pageNumber}">
					
							<c:if test="${prevBlock > 0}">
						<a
							href="<%=request.getContextPath() %>/myPage/viewPointLog.do?pageNumber=${prevBlock}">Prev</a>
					</c:if>

					<c:forEach var="blockNum" items="${blockList}">
						<a
							href="<%=request.getContextPath() %>/myPage/viewPointLog.do?pageNumber=${blockNum}">${blockNum}</a>
					</c:forEach>

					<c:if test="${nextBlock < totalPageNum}">
						<a
							href="<%=request.getContextPath() %>/myPage/viewPointLog.do?pageNumber=${nextBlock}">Next</a>
					</c:if>
		
	</div>

</body>
</html>