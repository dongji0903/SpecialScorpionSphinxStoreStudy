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
	$("#country").change(function() {
		var code = $("#country").val();
		
		$("#code").val(code);
		$("#phoneNum").focus();
	});
});
</script>
<script type="text/javascript">
$(function() {
	$("#join").click(function() {
		var birth = $("#birthday");
		if (birth.val().length < 8) {
			var chk = document.getElementById('chkbirth');
				chk.innerHTML = '';
			birth.css("display", "none");
			birth.val("1000-01-01");
			birth.attr("readonly", true);
		}
		var form = $("#editfrm");
		if ($("#name").val().length < 2) {
			alert('이름을 입력해주세요.');
			return;
		} else if ($("#phoneNum").val().length < 5) {
			alert('전화번호를 입력해주세요.');
			return;
		} else {
			alert('수정이 완료되었습니다.');
			form.submit();
		}
	})
})
</script>
<script type="text/javascript">
$(function() {
	var box = $("#phoneNum");
	var pattern = /[^(0-9)]/gi; // 숫자이외는 제거
		/* 텍스트에 문자를 입력할경우 특수문자가 있으면 지워주는 jquery */
		box.keyup(function() {
			var birth = box.val();
			
			box.val(birth.replace(pattern, ""));
		});
});
</script>
<script type="text/javascript">
var nowDate = '${nowDate}'
var nowY = nowDate.substr(0, 4);
var nowM = nowDate.substr(5, 2);
var nowD = nowDate.substr(8, 2);
$(function() {
	var box = $("#birthday");
	var pattern = /[^(0-9)]/gi; // 숫자이외는 제거
		/* 텍스트에 문자를 입력할경우 특수문자가 있으면 지워주는 jquery */
		box.keyup(function() {
			var birth = box.val();
			
			box.val(birth.replace(pattern, ""));
		});
		
		/* 생년월일을 모두 입력하였으나 변경하려고 마우스로 텍스트박스 클릭시 '-'를 제거시켜줌' */
		box.click(function() {
			if (typeof box.attr("readonly") == "undefined") {
				var birth = box.val();
		
				box.val(birth.replace(pattern, ""));
			}
		});
		
		/* 커서가 텍스트 박스를 벗어날경우 텍스트 벨류의 길이를 체크해서 8자면 '-'를 삽입시켜줌' */
		box.focusout(function() {
			if (typeof box.attr("readonly") == "undefined") {
				var size = box.val().length;
			 	birth = box.val();
			 	var chk = document.getElementById('chkbirth');
				chk.style.color = 'red';
				if (size >= 8) {
					var y = birth.substr(0, 4).replace(pattern, "");
				    var m = birth.substr(4, 2).replace(pattern, "");
				    var day = birth.substr(6, 2).replace(pattern, "");
				    
				    if (y < (parseInt(nowY - 88)) || y > (parseInt(nowY - 10))) {
				    	chk.innerHTML = "회원가입은 "+ (parseInt(nowY - 88)) +"년 ~ "+ (parseInt(nowY - 10)) +"년 출생자만 가능합니다.";
				    	return;
				    } else if (m > 12 || m < 1) {
				    	chk.innerHTML = "정확한 '월'을 입력해주세요.";
				    	return;
				    } else {
				    	var date = 0;
				    	if (parseInt(m) == 2) {
					        if (y % 4 == 0) {
					            date = 29;
					        } else {
					            date = 28;
					        }
					    } else if (m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12) {
					        date = 31;
					    } else {
					        date = 30;
					    }
				    	
				    	if (day > date || day < 1) {
				    		chk.innerHTML = "정확한 '일'을 입력해주세요.";
					    	return;
				    	}
				    }
				    var date = y +"-"+ m +"-" + day;
				    if (date.length == 10) {
				    	box.val(date);
					    chk.innerHTML = '';
				    } else {
				    	box.val(box.val().replace(pattern, ""));
				    	chk.innerHTML = '생년월일 8자리를 정확히 입력해주세요.';
				    	return;
				    }
				} else {  
					chk.innerHTML = '생년월일 8자리를 정확히 입력해주세요.';
				}
			}
		});
});
</script>
</head>
<body class="page1" id="top">
<%@include file="/WEB-INF/views/header.jsp"%>
<section class="content">
	
<div class="container" align="center">
	<form id="editfrm" action="<%=request.getContextPath()%>/mypage/editinfo" method="post">
	<div class="table" align="left" style="margin-top: 30px; margin-bottom: 50px; max-width: 500px;">
		<div class="tr">
			<div class="td" align="center" style="padding-bottom: 30px;">
			<font size="5" style="font-weight: bold;">회원정보 수정</font>
			</div>
		</div>
		<div class="tr">
			<div class="td" align="center">
			<hr style="width: 15%;" color="#aaccaa">필수사항
			</div>
		</div>
		<div class="tr">
			<div class="td">
			<font size="4">Id</font>
			<br>
			${customer.sphinxId}
			</div>
		</div>
		<div class="tr" ><!-- 비번 변경 -->
			<div class="td">
			<font size="4">Password</font> &nbsp; &nbsp;(8자 이상)
				<input type="password" id="password" name="password" style="padding-left: 5%; width: 92%; height: 25px;"/>
			<font size="3">Confirm Password</font>
			<br>
				<input type="password" id="password2" name="password2" style="padding-left: 5%; width: 92%; height: 25px;"/>
			<br>
			</div>
		</div>
		<div class="tr">
			<div class="td">
			<font size="4">Your Name</font>
			<br>
			<input type="text" value="${customer.name}" id="name" name="name" style="padding-left: 5%; width: 92%; height: 25px;"/>
			</div>
		</div>
		<div class="tr">
			<div class="td">
			<font size="4">Email</font>
			<br>
			${customer.email}
			</div>
		</div>
		<div class="tr">
			<div class="td">
			<font size="4">Nation</font>
			<br>
			<select name="country" id="country" style="width: 93%; height: 30px;">
				<option value="+82">Republic of Korea (대한민국) [+82]</option>
				<c:forEach var="e" items="${keys}">
				<option value="${codelist.get(e)}">${e} [${codelist.get(e)}]</option>
				</c:forEach>
			</select>
			</div>
		</div>
		<div class="tr">
			<div class="td">
			<font size="4">Phone Number</font> &nbsp; &nbsp;ex) 01011112222
			<br>
			<input readonly="readonly" id="code" value="+82" type="text" style="border-right: 0; margin: 0; width: 40px; display:inline; height: 25px;"/><input style="display:inline; border-left: 0; margin: 0; width: 78%; height: 25px;" type="text" id="phoneNum" value="${customer.phoneNum}" name="phoneNum"/>
			</div>
		</div>
		<div class="tr">
			<div class="td" align="center" style="padding-top: 50px;">
			<hr style="width: 15%" color="#aaccaa">
			선택사항
			</div>
		</div>
		<div class="tr">
			<div class="td">
			<font size="4">Birthday</font> &nbsp; &nbsp;ex) 19900821
			<br>
			<c:if test="${customer.birthday.equals(\"1000-01-01\")}">
			<input id ="birthday" type="text" name="birthDay" maxlength="8" style="padding-left: 5%; width: 93%; height: 25px;"/>
			</c:if>
			<c:if test="${!customer.birthday.equals(\"1000-01-01\")}">
			<input id ="birthday" value="${customer.birthday}" type="text" name="birthDay" maxlength="8" style="padding-left: 5%; width: 93%; height: 25px;"/>
			</c:if>
			<br>
			<span id="chkbirth" style="font-size: small;"></span>
			</div>
		</div>
		<div class="tr">
			<div class="td" align="center">
				<a style="width: 75%; height: 20px; text-align: center; border: solid 1px #aaccaa;" class="btn" id="join">Edit My Info.</a> 
			</div>
		</div>
	</div>
	
		
	</form>
</div>
</section>
<%@include file="/WEB-INF/views/footer.jsp"%> 
</body>
</html>