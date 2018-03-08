<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://DUG/function/URLDecode" prefix="ud"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>장바구니</title>
</head>
<script type="text/javascript">
	function checkList(i) {
		if(i <= 0) {
			alert('구매할 상품이 없습니다.');
			return false;
		}
		return true;
	}
</script>
<body>
	<div id="wrap" align="center">
		<div id="header">
			<jsp:include page="/form/header_Form.jsp" />
		</div>
		<div id="middle">
			<form action="<%=request.getContextPath()%>/shop/setOrder.do">
				<table>
					<tr>
						<th>상품명</th>
						<th>옵션1</th>
						<th>옵션2</th>
						<th>수량</th>
						<th>가격</th>
					</tr>
					
					<c:forEach var="c" items="${cartList }" varStatus="status">
						<tr>
							<td><a
								href="<%=request.getContextPath() %>/shopping/viewItem.do?num=${itemList[status.index].num }">${itemList[status.index].name}</a>
								&nbsp;&nbsp;<a href="#"
								onclick="window.open('<%=request.getContextPath() %>/shop/deleteCart.do?cartName=${c.cartName }', '_blank_1','toolbar=no,menubar=no,scrollbars=yes,resizable=no, width=600, height=200, top = 200, left =300')">삭제</a>
							</td>
							<td>${itemList[status.index].type1}</td>
							<td>${itemList[status.index].type2}</td>
							<td>${c.count}</td>
							<td>${itemList[status.index].price}</td>
						</tr>
						</c:forEach>
				</table>
				<input type="button" value="쇼핑 더하기"
					onclick="location.href = '<%=request.getContextPath()%>/shop/index.do'">
				<input type="submit" value="결제하기"
					onclick="return checkList(${cartList.size()})">
			</form>
		</div>
		<div id="footer">
			<div
				style="background-color: maroon; min-height: 4px; margin-bottom: 4px;"></div>
			<jsp:include page="/form/footer_Form.jsp" />
		</div>
	</div>

</body>
</html>