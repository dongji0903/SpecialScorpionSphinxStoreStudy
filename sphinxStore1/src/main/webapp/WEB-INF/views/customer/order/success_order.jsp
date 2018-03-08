<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body class="page1" id="top" style="color : #424242;">
<%@include file="/WEB-INF/views/header.jsp"%>
<section class="content">
<div class="container" align="center">
	<h2>결제가 완료되었습니다.</h2>
	<div class="table" style="margin-top: 10px;">
		<div class="tr">
			<div id="OrderInfoSection" class="td" align="center" style="padding: 0; padding-bottom: 10px;">
				<hr width="100%" color="#aaccaa">
				<div>
					<c:forEach var="orderItem" items="${orderItems}" varStatus="status">
					<div align="center" style="overflow: hidden; margin-bottom: 15px;">
					<div align="left" style="padding: 0; float: left; max-width: 270px; width: 270px;">
						<div class="table" style="width: 100%;">
							<div class="tr">
								<div class="td" style="width: 70px; padding:5px; vertical-align: middle;">
									<!-- 사진 -->
									<img src="<%=request.getContextPath()%>/resources/img/${orderItem.getProduct().getFileName().get(0)}" width="50px" height="50px">
								</div>
								<div class="td">
									<!-- 상품명 -->
									<font size="2">${orderItem.product.productName}</font>
								</div>
							</div>
						</div>
					</div>
					<div align="left" style="padding: 0; float: left; max-width: 270px; width: 270px; background: #E6E6E6;">
						<div class="table" style="width: 100%;">
							<div class="tr">
								<div class="td" align="left" style="width: 50px; padding: 1px;">
									<font style="font-weight: bold;">옵션</font>
								</div>
								<div class="td" align="left" style=" padding: 1px;">
									<c:forEach var ="option" items="${orderItem.product.optionList}" varStatus="status">
										<c:if test="${status.first != true}">
										/
										</c:if>
										<c:forEach var = "value" items="${option.optionValueMap.keySet()}">
											${value}
										</c:forEach>
									</c:forEach>	
								</div>
							</div>
							<div class="tr">
								<div class="td" align="left" style=" padding: 1px;">
									<font style="font-weight: bold;">수량</font>
								</div>
								<div class="td" align="left" style=" padding: 1px;" id="${orderItem.orderItemId}">
									${orderItem.quantity}
								</div>
							</div>
							<div class="tr">
								<div class="td" align="left" style=" padding: 1px;">
									<font style="font-weight: bold;">총 가격</font>
								</div>
								<div class="td" align="left" style=" padding: 1px;">
									<!-- 한 상품의 총 가격 -->
									${orderItem.getPrice()}
								</div>
							</div>
						</div>
					</div>
					</div>
					</c:forEach>
				</div>
				<hr width="100%" color="#aaccaa">
				<div class="table" style="width: 90%;">
					<c:if test="${empty customer}">
					<div class="tr">
						<div class="td" align="left" style="padding-left: 0; padding-right: 0;">
							<font size="3">
							비회원 주문번호
							</font>
						</div>
						<div class="td" align="right" style="padding-left: 0; padding-right: 0;">
							<font size="3" color="#0B6138" style="font-weight: bold;">
							${orderId}
							</font>
						</div>
					</div>
					</c:if>
					<div class="tr">
						<div class="td" align="left" style="padding-left: 0; padding-right: 0;">
							<font size="3">
							결제한 금액
							</font>
						</div>
						<div class="td" align="right" style="padding-left: 0; padding-right: 0;">
							<font size="3" color="#0B6138" style="font-weight: bold;">
							${totalPrice}
							</font>
							<b>원</b>
						</div>
					</div>
				</div>
				<hr width="100%" color="#aaccaa">
			</div>
		</div>
		<div class="tr">
			<div id="buttonSection" class="td" style="padding: 0; padding-bottom: 30px;">
				<div class="table" style="width: 100%;">
					<div class="tr">
						<div class="td" style="padding:0;">
							<a href="<%=request.getContextPath()%>/" class="btn">Main</a>
						</div>
						<c:if test="${!empty customer}">
						<div class="td" style="padding:0;">
							<a href="<%=request.getContextPath()%>/mypage/lookup" class="btn">Confirm</a>
						</div>
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</div>
	
</div>
</section>
<%@include file="/WEB-INF/views/footer.jsp"%> 
</body>
</html>