<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- 주문자정보와 동일 -->
<script type="text/javascript">
	$(function(){
		$("#info").change(function(){
			var name = "${customer.name}";
			var ph = "${customer.phoneNum}";
			var address = "${customer.address}";
			var post = "${customer.post}";
			
			var box = document.getElementById("info");
			
			if(box.checked == true){
				$("#recipient").val(name);
				$("#recipient2").val(ph);
				if(address == "address") {
					$("#sample4_roadAddress").val("");
					$("#area2").val("");
					$("#sample4_postcode").val("");
				} else {
					$("#sample4_roadAddress").val(address.split('/')[0]);
					$("#area2").val(address.split('/')[1]);
					$("#sample4_postcode").val(post);
				}
			} else {
				$("#recipient").val("");
				$("#recipient2").val("");
				$("#sample4_postcode").val("");
				$("#sample4_roadAddress").val("");
				$("#area2").val("");
			}
		});
	});
</script>
<script type="text/javascript">
$(function(){
	$("#customerInfo").change(function(){
		var name = $("#name");
		var ph = $("#phoneNum");
		var box = document.getElementById("customerInfo");
		
		if(box.checked == true){
			$("#recipient").val(name.val());
			$("#recipient2").val(ph.val());
		} else {
			$("#recipient").val("");
			$("#recipient2").val("");
		}
	});
});
</script>
<!-- 폼 서브밋 -->
<script type="text/javascript">
	$(function() {
		$("#payment").click(function() {
			var theForm = document.getElementById('payfrm');
			if ($("#recipient").val().length < 1) {
				alert('상품수령을 위한 이름을 입력해주세요.');
				return;
			} else if ($("#recipient2").val().length < 1) {
				alert('상품수령을 위한 전화번호를 입력해주세요.');
				return;
			} else if ($("#sample4_postcode").val().length < 1) {
				alert('정확한 주소를 입력해주세요.');
				return;
			} else if ($("#sample4_roadAddress").val().length < 1) {
				alert('정확한 주소를 입력해주세요.');
				return;
			} else {
				var memo = $("#memo");
				
				if (memo.val().length < 1) {
					memo.css("display", "none");
					memo.val("---");
					memo.attr("readonly", true);
				}
				theForm.submit();
			}
		});
	});
</script>
<!-- 장바구니로 -->
<script type="text/javascript">
	function cart() {
		location.href = "<%=request.getContextPath()%>/cart";
	}
</script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
//본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
	function sample4_execDaumPostcode() {
		new daum.Postcode(
			{
				oncomplete : function(data) {
					// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
					// 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
					// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
					var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
					var extraRoadAddr = ''; // 도로명 조합형 주소 변수

					// 법정동명이 있을 경우 추가한다. (법정리는 제외)
					// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
					if (data.bname !== ''
							&& /[동|로|가]$/g
									.test(data.bname)) {
						extraRoadAddr += data.bname;
					}
					// 건물명이 있고, 공동주택일 경우 추가한다.
					if (data.buildingName !== ''
								&& data.apartment === 'Y') {
						extraRoadAddr += (extraRoadAddr !== '' ? ', '
								+ data.buildingName
								: data.buildingName);
					}
					// 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
					if (extraRoadAddr !== '') {
						extraRoadAddr = ' ('
								+ extraRoadAddr
								+ ')';
					}
					// 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
					if (fullRoadAddr !== '') {
						fullRoadAddr += extraRoadAddr;
					}
					// 우편번호와 주소 정보를 해당 필드에 넣는다.
					document.getElementById('sample4_postcode').value = data.zonecode; //5자리 새우편번호 사용
					document.getElementById('sample4_roadAddress').value = fullRoadAddr;
					//document.getElementById('sample4_jibunAddress').value = data.jibunAddress;
						// 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
					if (data.autoRoadAddress) {
						//예상되는 도로명 주소에 조합형 주소를 추가한다.
						var expRoadAddr = data.autoRoadAddress
								+ extraRoadAddr;
						document.getElementById('guide').innerHTML = '(예상 도로명 주소 : '
								+ expRoadAddr + ')';
						} else if (data.autoJibunAddress) {
						var expJibunAddr = data.autoJibunAddress;
						document.getElementById('guide').innerHTML = '(예상 지번 주소 : '
								+ expJibunAddr
							+ ')';
					} else {
					document.getElementById('guide').innerHTML = '';
					}
				}
		}).open();
	}
</script>
</head>
<body class="page1" id="top" style="color: #424242;">
<%@include file="/WEB-INF/views/header.jsp"%>
<section class="content">
<div class="container" align="center">

	<!-- 폼 여기있어요 -->
	<form id="payfrm" action="<%=request.getContextPath()%>/order/payment" method="post">

	<div class="table" style="margin-top: 30px;">
		<div class="tr">
			<div class="td" align="center" style="padding-bottom: 30px;">
				<font size="5"  style=" font-weight: bold;">주문결제</font>
			</div>
		</div>
		<div class="tr">
			<div id="itemSection" align="center" class="td">
				<font size="3"  style=" font-weight: bold;">상품 정보</font>
				<hr width="100%" color="#aaccaa">
				<div>
					<c:forEach var="orderItem" items="${orderItemList}" varStatus="status">
					<div align="center" style="overflow: hidden; margin-bottom: 15px;">
					<div align="left" style="padding: 0; float: left; max-width: 270px; width: 270px;">
						<div class="table" style="width: 100%;">
							<div class="tr">
								<div class="td" style="width: 70px; padding:5px; vertical-align: middle;">
									<!-- 사진 -->
									<img src="<%=request.getContextPath()%>/resources/img/${cart.orderItemMap.get(orderItem).product.fileName.get(0)}" width="50px" height="50px">
								</div>
								<div class="td">
									<!-- 상품명 -->
									<font size="2">${cart.orderItemMap.get(orderItem).product.productName}</font>
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
									<c:forEach var ="option" items="${cart.orderItemMap.get(orderItem).product.optionList}" varStatus="status">
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
								<div class="td" align="left" style=" padding: 1px;" id="${cart.orderItemMap.get(orderItem).orderItemId}">
									${cart.orderItemMap.get(orderItem).quantity}
								</div>
							</div>
							<div class="tr">
								<div class="td" align="left" style=" padding: 1px;">
									<font style="font-weight: bold;">총 가격</font>
								</div>
								<div class="td" align="left" style=" padding: 1px;">
									<!-- 한 상품의 총 가격 -->
									${cart.orderItemMap.get(orderItem).getPrice()}
								</div>
							</div>
						</div>
					</div>
					</div>
					</c:forEach>
				</div>
				<hr width="100%" color="#aaccaa">
			</div>
		</div>
		<div class="tr">
			<div id="ordererInfoSection" align="center" class="td" style="padding-top: 30px;">
				<font size="3"  style=" font-weight: bold;">주문자 정보</font>
				<hr width="100%" color="#aaccaa">
				<div>
					<div align="center" style="overflow: hidden; margin-bottom: 15px;">
					<div align="left" style="padding: 0; float: left; max-width: 270px; width: 270px;">
					<c:if test="${empty customer}">
					<div class="table">
						<div class="tr">
							<div class="td" align="left">이름</div>
							<div class="td">
								<input type="text" id="name" name="name" style="width: 85%;"/>
							</div>
						</div>
						<div class="tr">
							<div class="td" align="left">전화번호</div>
							<div class="td">
								<input type="text" id="phoneNum" name="phoneNum" style="width: 85%;"/>
							</div>
						</div>
						<div class="tr">
							<div class="td" align="left">메일</div>
							<div class="td">
								<input type="text" id="email" name="email" style="width: 85%;"/>
							</div>
						</div>
					</div>
					</c:if>
					<c:if test="${!empty customer}">
					<div class="table">
						<div class="tr">
							<div class="td" align="left">이름</div>
							<div class="td">
								<input type="text" name="c_name" style="width: 85%;" value="${customer.name}" readonly="readonly"/>
							</div>
						</div>
						<div class="tr">
							<div class="td" align="left">전화번호</div>
							<div class="td">
								<input type="text" name="c_phoneNum" style="width: 85%;" value="${customer.phoneNum}" readonly="readonly"/>
							</div>
						</div>
						<div class="tr">
							<div class="td" align="left">메일</div>
							<div class="td">
								<input type="text" name="c_email" style="width: 85%;" value="${customer.email}" readonly="readonly"/>
							</div>
						</div>
					</div>
					</c:if>
					</div>
					<div align="left" style="padding: 0; float: left; max-width: 270px; width: 270px; background: #E6E6E6;">
						＊비회원의 배송정보는 이메일로 확인할 수 있습니다.<br>
						＊정확한 이메일과 휴대폰 번호를 입력해 주십시오.
					</div>
					</div>
				</div>
				<hr width="100%" color="#aaccaa">
			</div>
		</div>
		<div class="tr">
			<div id="ShippingInfoSection" class="td" style="padding-top: 30px;">
				<font size="3"  style=" font-weight: bold;">배송 정보</font> 
				<c:if test="${!empty customer}">
					<br>
					(<font size="2">주문자 정보와 동일</font>
					<input type="checkbox" class="chk" id="info"/>
					<label for="info"></label>)
				</c:if>
				<c:if test="${empty customer}">
					<br>
					(<font size="2">주문자 정보와 동일</font>
					<input type="checkbox" class="chk" id="customerInfo"/>
					<label for="customerInfo"></label>)
				</c:if>
				<hr width="100%" color="#aaccaa">
					<div class="table" align="left"  style="width: 100%;">
						<div class="tr">
							<div class="td" style="width: 120px;">받는사람</div>
							<div class="td">
								<input type="text" id="recipient" name="recipient"/>
							</div>
						</div>
						<div class="tr">
							<div class="td" align="left">전화번호</div>
							<div class="td">
								<input type="text" id="recipient2" name="recipient2"/>
							</div>
						</div>
						<div class="tr">
							<div class="td" align="left">주소</div>
							<div class="td">
								<input type="text" name="post" id="sample4_postcode" readonly="readonly" placeholder="우편번호" style="height: 25px;">
								<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기" style="height: 30px; color: gray; background: white; border: solid 0.2px #aaccaa;">
								<br>
								<input type="text" name="area1" value="${address1}" id="sample4_roadAddress" readonly="readonly"  style="height: 25px; width: 92%;" placeholder="도로명주소"> 
								<br>
								<input type="text" name="area2" id="area2" value="${address2}" style="height: 25px; width: 92%;" placeholder="상세주소"> 
								<br>
								<font size="2" color="gray">
								* 상품 수령을 위해 정확한 주소를 입력해주세요.
								</font>
								<span id="guide" style="color: #999"></span>
							</div>
						</div>
						<div class="tr">
							<div class="td" align="left">배송요청사항</div>
							<div class="td">
								<input type="text" id="memo" name="memo" placeholder="택배기사님이 확인하시는 메세지란입니다." style="height: 25px; width: 92%;"/>
							</div>
						</div>
					</div>
				<hr width="100%" color="#aaccaa">
			</div>
		</div>
		<div class="tr">
			<div id="priceSection" class="td" style="padding-top: 30px;">
				<font size="3"  style=" font-weight: bold; vertical-align: 60%">최종 결제금액</font>
				<div class="table" align="left" style="border: solid 2px #aaccaa; width: 100%;">
					<div class="tr">
						<div class="td">총 상품 금액</div>
						<div class="td">${price} 원</div>
					</div>	
					<div class="tr">
						<div class="td">배송비</div>
						<div class="td">+ 2,500 원</div>
					</div>		
					<div class="tr">
						<div class="td">최종 결제금액</div>
						<div class="td">
							<font size="5" style="background: #0B6138;" color="white">
								&nbsp;${price + 2500} 원&nbsp;
							</font>
							<input type="hidden" id="totalPrice" name="totalPrice" value="${price + 2500}"/>
						</div>
					</div>			
				</div>
			</div>
		</div>
		<div class="tr">
			<div id="paymentSection" align="center" class="td" style="padding-top: 30px;">
				<input type="button" id="payment" value="결제하기" class="btn" style="margin-right: 20px; margin-left: 20px; width: 200px; background: #0B6138; color: white; border: solid 1px #0B6138; cursor: pointer;"/>
				<input type="button" onclick="cart()" value="장바구니" class="btn" style="width: 200px; background: white; color: gray; border: solid 1px #0B6138; cursor: pointer;"/>
			</div>
		</div>
	</div>
	</form>
</div>
</section>
<%@include file="/WEB-INF/views/footer.jsp"%> 
</body>
</html>