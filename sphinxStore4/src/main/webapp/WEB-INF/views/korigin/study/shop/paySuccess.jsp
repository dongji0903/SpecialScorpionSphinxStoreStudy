<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>결제 확인</title>
</head>
<body>
	<div id="wrap" align="center">

		<div id="header">
			<jsp:include page="/form/header_Form.jsp" />
		</div>

		<div style="width: 750px; margin-left: 250px; text-align: left;">
			<div style="width: 750px;">
				<h1>결제확인창</h1>
				<hr>
			</div>
			<c:choose>
				<c:when test="${paymentAlert != null }">
				결제오류 : ${paymentAlert }
			</c:when>
				<c:when test="${point != null }">
			잔액 포인트 : ${point }
			</c:when>
			</c:choose>
		</div>
		<c:if test="${point != null }">
			<div>
				<h1>결제상품내역</h1>
			</div>
			<div id="order_Box">
				<table>
					<tr>
						<th>상품내용</th>
						<th>옵션1</th>
						<th>옵션2</th>
						<th>수량</th>
						<th>가격</th>
					</tr>
					<c:if test="${order != null}">
						<c:forEach var="orderItem" items="${order.orderItemList}">
							<tr>
								<td><a
									href="<%=request.getContextPath() %>/shop/viewItem.do?num=${orderItem.cart.item.num}">${orderItem.cart.item.name}</a>
								</td>
								<td>${orderItem.cart.detailType}</td>
								<td>${orderItem.cart.detailType2}</td>
								<td>${orderItem.cart.count}</td>
								<td>${orderItem.price}</td>
							</tr>
						</c:forEach>
					</c:if>
				</table>
				<hr>
			</div>
		</c:if>
		<div align="center" style="height: 100px;">
			<br> <input type="button" value="확 인"
				style="margin: 1px; background-color: buttonhighlight;"
				onclick="location.href='<%=request.getContextPath()%>/shop/index.do'">
		</div>


		<div id="footer">
			<div
				style="background-color: maroon; min-height: 4px; margin-bottom: 4px;"></div>
			<jsp:include page="/form/footer_Form.jsp" />
		</div>
	</div>

</body>
</html>