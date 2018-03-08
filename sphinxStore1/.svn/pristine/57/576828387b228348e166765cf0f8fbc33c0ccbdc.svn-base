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
	$("#deletecu").click(function() {
		var chk = document.getElementById('chk');
		var form = $("#deletefrm");
		if (chk.checked == false) {
			alert('정보 삭제에 동의해 주십시오.');
			return;
		} else {
			msg = "정말로 회원탈퇴를 하시겠습니까?";
			if (confirm(msg) != 0) {
				form.submit();
			} else {
				return;
			}
		}
	})
})
</script>
</head>
<body class="page1" id="top">
<%@include file="/WEB-INF/views/header.jsp"%>
<section class="content">
<div class="container" align="center">
<form id="deletefrm" action="<%=request.getContextPath()%>/mypage/withdrow" method="post">
	<div class="table" style="margin-top: 50px;">
		<div class="tr">
			<div class="td">
				<hr style="width: 20%;" color="#aaccaa">
				<font size="3">
				회원탈퇴
				</font>
			</div>
		</div>
		<div class="tr">
			<div class="td">
				<font size="2">
				모든 정보는 즉시 삭제되어 탈퇴처리 됩니다.
				</font>
			</div>
		</div>
		<div class="tr">
			<div class="td">
				<div class="table" style="margin-top: 20px; border: solid 0.2px gray;">
					<div class="tr">
						<div class="td" align="right" style="width: 60px;">
						탈퇴사유
						</div>
						<div class="td">
							<input type="radio" id="1" name="why" value="1"/>배송주문 불만족
							<input type="radio" name="why" value="2"/>사이트 이용 불편
							<input type="radio" name="why" value="3"/>상품품질 불만족
							<input type="radio" name="why" value="4"/>서비스 불만족
							<input type="radio" name="why" value="5"/>기타
						</div>
					</div>
					<div class="tr">
						<div class="td" align="right">
							내용
						</div>
						<div class="td">
							<input type="text" name="detail" style="width: 90%; height: 25px;">
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="tr">
			<div class="td" align="left">
				<font size="2">
					개인정보, 주문내역, 적립금 등 회원님의 모든 정보가 삭제됩니다.
				</font>
			</div>
		</div>
		<div class="tr">
			<div class="td" align="left" style="padding-top:0">
				정보 삭제에 동의합니다.<input class="checkbox-style" value="1" type="checkbox" id="chk"/>  
				<label for="chk"></label>
			</div>
		</div>
		<div class="tr">
			<div class="td">
				<input type="button" id="deletecu" value="탈퇴" class="btn"/>
			</div>
		</div>
	</div>
	</form>
	
</div>
</section>
<%@include file="/WEB-INF/views/footer.jsp"%> 
</body>
</html>