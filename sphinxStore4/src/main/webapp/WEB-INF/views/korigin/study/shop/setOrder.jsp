
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>상품 주문</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/dug_Korea.css">

<script type="text/javascript">
	function nullCheck() {
		for (var i = 0; i < 14; i++) {
			if (i != 6
					&& (document.frm1.elements[i].value == "" || document.frm1.elements[i].value == null)) {
				alert(document.frm1.elements[i].name + "를 입력하여 주십시오.");
				document.frm1.elements[i].focus();
				return false;
			}
		}

	}
</script>

</head>

<body>
	<div id="wrap" align="center">

		<div id="header">
			<jsp:include page="/form/header_Form.jsp" />
		</div>

		<div style="width: 750px; margin-left: 250px; text-align: left;">
			<div style="width: 750px;">
				<h1>주문/결제</h1>
				<hr>
			</div>

			<form action="<%=request.getContextPath()%>/shop/payment.do"
				method="post" name="frm1">
				<input type="hidden" name="order" value="${order }">
				<div>
					<h1>구매자정보</h1>
				</div>
				<div id="order_Box">
					<table>
						<tr>
							<th style="width: 128px;">주문자</th>
							<td><input required="required" type="text" name="orderName"
								value="${name}" style="margin: 1px">&nbsp;&nbsp;&nbsp;</td>
						</tr>
						<tr>
							<th>이메일</th>
							<td><input required="required" type="text" name="orderEmail"
								value="${email}" style="margin: 1px">&nbsp;&nbsp;&nbsp;</td>
						</tr>
						<tr>
							<th>휴대폰 번호</th>
							<td><input required="required" type="text" name="orderPhone"
								value="${phone}" style="margin: 1px">&nbsp;&nbsp;&nbsp;</td>
						</tr>
					</table>
					<hr>
				</div>
				<div>
					<h1>받는사람정보</h1>
				</div>
				<div id="order_Box">
					<table>
						<tr>
							<th>받는 사람</th>
							<td><input required="required" type="text"
								name="receiverName" value="${name}" style="margin: 1px">&nbsp;&nbsp;&nbsp;</td>
						</tr>
						<tr>
							<th>주소</th>
							<td><input required="required" type="text"
								name="receiverAddr" style="margin: 1px">&nbsp;&nbsp;&nbsp;</td>
						</tr>
						<tr>
							<th>휴대폰 번호</th>
							<td><input required="required" type="number"
								name="receiverPhone" value="${phone}" style="margin: 1px">&nbsp;&nbsp;&nbsp;</td>
						</tr>
						<tr>
							<th>배송 요청사항</th>
							<td><textarea required="required" name="giverWant" rows="10"
									cols="50"></textarea></td>
						</tr>
					</table>
					<hr>
				</div>
				<div>
					<h1>판매자배송상품</h1>
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
						<c:forEach var="c" items="${cartList }" varStatus="status">
							<tr>
								<td><a
									href="<%=request.getContextPath() %>/shopping/viewItem.do?num=${itemList[status.index].num }">${itemList[status.index].name}</a>
								</td>
								<td>${itemList[status.index].type1}</td>
								<td>${itemList[status.index].type2}</td>
								<td>${c.count}</td>
								<td>${itemList[status.index].price}</td>
							</tr>
						</c:forEach>
						<%-- <c:if test="${order != null}">
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
						</c:if> --%>
					</table>
					<hr>
				</div>
				<div>
					<h1>결제정보</h1>
				</div>
				<div id="order_Box">
					<table>
						<tr>
							<th style="width: 128px;">총상품가격</th>
							<td><input type="text" name="totalPrice"
								value="${totalPrice}" style="border: none; margin: 1px;"
								readonly="readonly">&nbsp;&nbsp;&nbsp;</td>
						</tr>
						<tr>
							<th>할인액</th>
							<td>${param.discount}&nbsp;&nbsp;&nbsp;<a href="#"> 쿠폰조회
							</a>
							</td>
						</tr>
						<tr>
							<th>배송비</th>
							<td><input type="text" name="fee" value="${order.deliveryCharge}"
								style="border: none; margin: 1px;" readonly="readonly">&nbsp;&nbsp;&nbsp;</td>
						</tr>
						<tr>
							<th>포인트</th>
							<td><input type="text" name="point" value="${order.buyer.point}"
								style="border: none; margin: 1px;" readonly="readonly">&nbsp;&nbsp;&nbsp;</td>
						</tr>
						<tr>
							<th>결제금액</th>
							<td><input type="text" name="realPrice"
								value="${totalPrice}" style="border: none; margin: 1px;"
								readonly="readonly">&nbsp;&nbsp;&nbsp;</td>
						</tr>
						<tr>
							<th>결제방법</th>
							<td><input type="radio" name="payType" value="포인트"
								checked="checked"> 포인트</td>
						</tr>
					</table>
				</div>

				<div align="center" style="height: 100px;">
					<br> <input type="button" value="취 소"
						style="margin: 1px; background-color: buttonhighlight;"
						onclick="location.href='<%=request.getContextPath()%>/shop/index.do'">
					&nbsp;&nbsp;&nbsp;&nbsp; <input type="submit" value="결제하기"
						style="margin: 1px; background-color: buttonhighlight;">
				</div>
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