<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/table.css">
</head>
<body class="page1" id="top" style="color : #424242;">
<%@include file="/WEB-INF/views/header.jsp"%>
<section class="content">
	
<%@include file="/WEB-INF/views/customer/mypage/mypage_menu.jsp"%>

	<div class="container">
    <div class="row">
      <div class="grid_12" style="margin-top: 50px;">
        <div class="box">
          <div class="row">
            <div class="grid_5 preffix_1">
              <div class="table" style="width: 80%; margin:10px;">
					<div class="tr">
						<div class="td" style="padding-top: 20px;">
							<font color="#893322" size="3" style="font-weight: bold;">
							<b>${customer.name}(${customer.sphinxId})님</b>
							<c:if test="${customer.admin == true}">
								<img src="<%=request.getContextPath()%>/resources/images/icon/crown.png">
							</c:if>
							</font>
						</div>
						<div class="td" align="right"  style="padding-top: 20px; width: 80px;;">
							<font size="2">
							<a href="<%=request.getContextPath()%>/mypage/confirmpassword">▷ 수정</a>
							</font>
						</div>
					</div>
				</div>
				<hr style="border: solid 0.5px #D8D8D8; width: 90%;">	
				<div class="table" style="margin-left: 10px; margin-right: 10px;">
					<div class="tr">
						<div class="td" style="padding-right: 10px; width: 70px;">
						회원등급
						</div>
						<div class="td">
						${customer.level}등급 <img alt="${icon}" style="margin-top: 3px;" src="<%=request.getContextPath()%>/resources/images/icon/${icon}.png">
						</div>
					</div>
					<div class="tr ">
						<div class="td tablepadding"  style="padding-right: 10px;">
						포인트
						</div>
						<div class="td">
						${customer.point}점
						</div>
					</div>
					<div class="tr">
						<div class="td tablepadding">
						이메일
						</div>
						<div class="td">
						${customer.email}
						</div>
					</div>
					<div class="tr">
						<div class="td tablepadding">
						전화번호
						</div>
						<div class="td">
						${customer.phoneNum}
						</div>
					</div>
					<div class="tr">
						<div class="td tablepadding">
						주소
						</div>
						<div class="td">
						<c:if test="${customer.address.equals(\"address\")}">
						등록된 주소가 없습니다.<br> 
						<a href="<%=request.getContextPath()%>/mypage/address">▶ 주소등록</a>
						</c:if>
						<c:if test="${!customer.address.equals(\"address\")}">
						${customer.address}
						</c:if>
						</div>
					</div>
				</div>
            </div>
            <div class="grid_5">
              <div class="table" style="width: 80%; margin: 10px; ">
					<div class="tr">
						<div class="td" style="padding-top: 20px;">
							<font color="#893322" size="3" style="font-weight: bold;">
							<b>O R D E R</b>
							</font>
						</div>
						<div class="td"  style="padding-top: 20px;">
							
						</div>
					</div>
				</div>
				<hr style="border: solid 0.5px #D8D8D8; width: 90%;">	
				<div class="table"  style="margin-left: 10px; margin-right: 10px;">
					<div class="tr">
						<div class="td" style="padding-right: 40px;">
						총 구매금액
						</div>
						<div class="td" align="right">
						${totalPurchase}
						<c:if test="${empty totalPurchase}">0</c:if>
						원
						</div>
					</div>
					<div class="tr ">
						<div class="td tablepadding">
						교환/반품
						</div>
						<div class="td" align="right">
						0 개
						</div>
					</div>
					<div class="tr">
						<div class="td tablepadding">
						할인쿠폰
						</div>
						<div class="td" align="right">
						0 개
						</div>
					</div>
					<div class="tr">
						<div class="td tablepadding">
						장바구니
						</div>
						<div class="td" align="right">
						<a href="<%=request.getContextPath()%>/cart" style="cursor: pointer;">
						${cart.orderItemMap.size()}
						<c:if test="${empty cart}">0</c:if>
						</a>
						개
						</div>
					</div>
					<div class="tr">
						<div class="td tablepadding">
						위시리스트
						</div>
						<div class="td" align="right">
						0 개
						</div>
					</div>
				</div>
			
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