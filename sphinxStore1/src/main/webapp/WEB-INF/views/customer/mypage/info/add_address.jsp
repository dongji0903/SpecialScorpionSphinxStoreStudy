<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/table.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
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
<script type="text/javascript">
$(function() {
	$("#addAddress").click(function() {
		var form = $("#addressfrm");
		if ($("#sample4_postcode").val().length < 1) {
			alert('정확한 주소를 입력해주세요.');
			return;
		} else if ($("#sample4_roadAddress").val().length < 1) {
			alert('정확한 주소를 입력해주세요.');
			return;
		} else {
			alert('주소 등록이 완료되었습니다.');
			form.submit();
		}
	})
})
</script>
</head>
<body class="page1" id="top">
<%@include file="/WEB-INF/views/header.jsp"%>
<section class="content">
	
<div class="container" align="center">
	<form id="addressfrm" action="<%=request.getContextPath()%>/mypage/address" method="post">
	<div class="table" align="left" style="margin-top: 30px; margin-bottom: 50px; max-width: 500px;">
		<div class="tr">
			<div class="td" align="center">
				<hr style="width: 20%;" color="#aaccaa">기본배송지 등록
			</div>
		</div>
		<div class="tr">
			<div class="td">
				<input type="text" name="post" value="${post}" id="sample4_postcode" readonly="readonly" placeholder="우편번호" style="height: 25px;">
				<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기" style="height: 30px; color: gray; background: white; border: solid 0.2px #aaccaa;">
			</div>
		</div>
		<div class="tr">
			<div class="td">
				<input type="text" name="area1" value="${address1}" id="sample4_roadAddress" readonly="readonly"  style="height: 25px; width: 92%;" placeholder="도로명주소"> 
			</div>
		</div> 
		<div class="tr">
			<div class="td">		
				<input type="text" name="area2" value="${address2}" style="height: 25px; width: 92%;" placeholder="상세주소"> 
				<br>
				<font size="2" color="gray">
				* 상품 수령을 위해 정확한 주소를 입력해주세요.
				</font>
				<span id="guide" style="color: #999"></span>
			</div>
		</div>	
		<div class="tr">
			<div class="td">
			<input type="button" id="addAddress" value="주소 등록" class="btn" style="width: 90%; height: 35px;"/>
			</div>
		</div>
	</div>
	</form>
</div>

</section>
<%@include file="/WEB-INF/views/footer.jsp"%> 
</body>
</html>