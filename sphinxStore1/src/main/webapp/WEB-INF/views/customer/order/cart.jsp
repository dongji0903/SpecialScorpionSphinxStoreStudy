<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/table.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script type="text/javascript">
$(function() {
	$(".quantity").change(function() {
		var id = "frm"+$(this).parent().attr("id");
		var theForm = document.getElementById(id);
		
		theForm.method = "post"; 
		theForm.target = "_self";
		
		
		theForm.action = "<%=request.getContextPath()%>/shopping/cart/product/editquantity";
		
		if ($(this).val() > 99) {
			$(this).val(99);
		} else if ($(this).val() < 1)  {
			$(this).val(1);
		}
		
		theForm.submit();
	});
	

	$("#all").change(function() {
		var box = document.getElementsByClassName("chk");
		for (var i = 0; i < box.length; i++) {
			if (this.checked == true) {
				box[i].checked = true;
			} else {
				box[i].checked = false;
			}
		}
	});
	
	
	var customer  = '${customer.customerId}'; 
	$("#choice").click(function() {
		var box = document.getElementsByClassName("chk");
		var count = 0;
		for (var i = 0; i < box.length; i++) {
			if (box[i].checked == true) {
				count++;
			}
		}
		
		if (count == 0) {
			alert('주문하실 상품을 선택해주세요.');
			return;
		}
		
		var id = "";
		for (var i = 0; i < box.length; i++) {
			if (box[i].checked == true && i != box.length-1) {
				id += box[i].value + "/";
			} else if (box[i].checked == true) {
				id += box[i].value;
			}
		}
		
		if (customer.length < 1) {
			if (!confirm('비회원 주문을 진행하시겠습니까?')) {
				location.href='<%=request.getContextPath()%>/login';
				return;
			}
		}
		
		$("#orderItems").val(id);
		$("#orderItems").parent().submit();
	});
	
	$("#allorder").click(function() {
		if (customer.length < 1) {
			if (!confirm('비회원 주문을 진행하시겠습니까?')) {
				location.href='<%=request.getContextPath()%>/login';
				return;
			}
		}
		$("#orderItems").parent().submit();
	});
});
</script>

<script type="text/javascript">
var theForm;
$(function() {
	$("#delbutton").click(function() {
		theForm = $(this).parent();
		
		var box = document.getElementsByClassName("chk");
		var count = 0;
		for (var i = 0; i < box.length; i++) {
			if (box[i].checked == true) {
				count++;
			}
		}
		
		if (count == 0) {
			alert('삭제하려는 상품을 선택해주세요.');
			return;
		}
		
		var id = "";
		for (var i = 0; i < box.length; i++) {
			if (box[i].checked == true && i != box.length-1) {
				id += box[i].value + "/";
			} else if (box[i].checked == true) {
				id += box[i].value;
			}
		}
		
		$("#removeItems").val(id);
		
		var text = "'"+ count +"'개의 상품을 삭제 하시겠습니까?";
		
		if(confirm(text)) {
			theForm.submit();
		} else {
			$("#orderItems").val('');
			return;
		}
	});
});
</script>
<style type="text/css">
input[type=number]::-webkit-inner-spin-button {
  opacity: 1;
}
</style>
</head>
<body class="page1" id="top">
<%@include file="/WEB-INF/views/header.jsp"%>
<section class="content">
<div class="container" align="center">
	<div class="table" style="margin-top: 30px;">
		<div class="tr">
			<div class="td">
			<font size="5">장바구니</font>
			</div>
		</div>
		<div class="tr">
			<div class="td">
			장바구니에 담은 상품은 일주일동안 보관됩니다.
			</div>
		</div>
	
		<div class="tr" style="color: #585858;"><!-- 장바구니 -->
			<div class="td" style="padding:0; padding-top: 30px;">
				<c:if test="${!empty cart}">
				<div style="width: 100%" align="left">
					<input type="checkbox" id="all" class="checkbox-style" onclick="check();"/>
					<label for="all"></label>
				<form id="delform" action="<%=request.getContextPath()%>/cart/remove" method="post" style="display: inline;">
					<input type="hidden" name="removeItems" id="removeItems">
					<button type="button" id="delbutton" style="height: 27px; float: right; margin-bottom: 3px; border: solid 0.5px #aaccaa; background: white;">삭제</button>
				</form>
				</div>
				</c:if>
				<hr width="100%" color="#aaccaa">
				
				<c:if test="${empty cart}">장바구니가 비어 있습니다.</c:if>
				<c:forEach var="key" items="${cart.orderItemMap.keySet()}" varStatus="status">
				<form id="frm${cart.orderItemMap.get(key).orderItemId}">
				<div align="center" style="overflow: hidden; margin-bottom: 15px;">
					<div align="left" style="padding: 0; float: left; max-width: 270px; width: 270px;">
						<div class="table" style="width: 100%;">
							<div class="tr">
								<div class="td" align="left" style="padding: 0; max-width: 30px; width: 30px;">
									<!-- 체크박스 -->
									<input type="checkbox" class="chk" name="chkedItem" value="${cart.orderItemMap.get(key).orderItemId}" id="item${status.count}" class="checkbox-style"/>
									<label for="item${status.count}"></label>
									<input type="hidden" name="orderItemId" value="${cart.orderItemMap.get(key).orderItemId}">
									
								</div>
								<div class="td" style="width: 90px; padding:5px; vertical-align: middle;">
									<!-- 사진 -->
									<img src="<%=request.getContextPath()%>/resources/img/${cart.orderItemMap.get(key).product.fileName.get(0)}" width="80px" height="80px">
								</div>
								<div class="td">
									<!-- 상품명 -->
									<a href="<%=request.getContextPath()%>/view/product?productId=${cart.orderItemMap.get(key).product.productId}">
										<font size="3">
										${cart.orderItemMap.get(key).product.productName}
										</font>
									</a>
								</div>
							</div>
							
						</div>
					</div>
					<div align="left" style="padding: 0; float: left; max-width: 270px; width: 270px; background: #E6E6E6;">
						<div class="table" style="width: 100%;">
							<div class="tr">
								<div class="td" align="left" style="width: 50px; padding: 5px;">
									<font style="font-weight: bold;">옵션</font>
								</div>
								<div class="td" align="left" style=" padding: 5px;">
									<c:forEach var ="option" items="${cart.orderItemMap.get(key).product.optionList}" varStatus="status">
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
								<div class="td" align="left" style=" padding: 5px;">
									<font style="font-weight: bold;">수량</font>
								</div>
								<div class="td" align="left" style=" padding: 5px;" id="${cart.orderItemMap.get(key).orderItemId}">
									<input type="number" name="quantity" class="quantity"
									value="${cart.orderItemMap.get(key).quantity}" min="1"
									style="width: 50px;"/>
								</div>
							</div>
							<div class="tr">
								<div class="td" align="left" style=" padding: 5px;">
									<font style="font-weight: bold;">총 가격</font>
								</div>
								<div class="td" align="left" style=" padding: 5px;">
									<!-- 한 상품의 총 가격 -->
									${cart.orderItemMap.get(key).getPrice()}
								</div>
							</div>
						</div>
					</div>
				</div>
				</form>
				</c:forEach>
				<hr width="100%" color="#aaccaa">
			</div>
		</div>
		<c:if test="${!empty cart}">
		<div class="tr"><!-- 총 주문 금액 -->
			<div class="td" align="right" style="color: #585858;">
				<div style="display: inline-block;">상품금액 ${cart.getTotalPrice()}</div>
				<div style="display: inline-block;">+ 배송비 2,500원</div>
				<div style="display: inline-block;">
					=
					<font size="4" color="#610B0B" style="font-weight: bold;">
					합계 ${cart.getTotalPrice() + 2500}원
					</font>
				</div>
			</div>
		</div>
		
		<div class="tr">
			<div class="td">
				<form action="<%=request.getContextPath()%>/order" method="post">
					<a class="btn" id="choice" style="cursor:pointer; width: 130px;">선택상품주문</a>
					<input type="hidden" name="orderItems" id="orderItems">
					<a class="btn" id="allorder" style="cursor:pointer; width: 130px;">전체상품주문</a>
				</form>
			</div>
		</div>
		</c:if>
	</div>
</div>
</section>
<%@include file="/WEB-INF/views/footer.jsp"%> 
</body>
</html>