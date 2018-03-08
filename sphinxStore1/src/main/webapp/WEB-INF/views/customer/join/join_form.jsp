<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/table.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script type="text/javascript">
function privacy() {
	window.open("<%=request.getContextPath()%>/join/privacy", 'width=300px, height=600px');
}
</script>
<!-- 아이디 체크 -->
<script type="text/javascript">
   $(function(){
	   var id = $("#id");
	   var button = $("#join");
	   
	   id.focusout(function() {
		   if(id.val().length > 0) {
			   $.ajax({
	               type: 'POST',
	                url: '/join/idcheck',
	                data: {
	                    "id" : $('#id').val()
	                },
	                success: function(data) {
	                    if(data == false) {
	                        $('#idchk').html('<font color=green>사용가능</font>');
	                        $('#idchked').val('1');
	                    } else {
	                        $('#idchk').html('<font color=red>사용불가능</font>');
	                        $('#idchked').val('0');
	                    }
	                }
	            }); //end ajax     
		   } else {
			   $('#idchk').html('<font color=red>아이디를 입력해주세요.</font>');
               $('#idchked').val('0');
		   }
		   
        }); //end on  
        
    });
</script>
<!-- 비번 체크 -->
<script type="text/javascript">
$(function() {
	var password = $("#password");
	var chk = document.getElementById('chkpw');
	password.keyup(function() {
		if(password.val().length > 0 && password.val().length < 8) {
			chk.innerHTML = "비밀번호를 8자 이상 입력해 주세요.";
			return;
		} else {
			chk.innerHTML = "";
		}	
	});
});
</script>	
<script type="text/javascript">
$(function() {
	var password2 = $("#password2");
	var password = $("#password");
	var chk2 = document.getElementById('chkpw2');
	password2.keyup(function() {
		if(password2.val().length > 0) {
			if(password2.val().length == password.val().length) {
				if(password2.val() != password.val()){
					chk2.innerHTML = "비밀번호를 정확히 입력해 주세요.";
			    	return;
				}
				chk2.innerHTML = "";
			} else {
				chk2.innerHTML = "비밀번호를 정확히 입력해 주세요.";
		    	return;
			}
		}
	});
});
</script>
<!-- 생년월일 -->
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
		var form = $("#joinfrm");
		if ($("#id").val().length < 1) {
			alert('아이디를 입력해주세요.');
			return;
		} else if ($("#idchked").val() != "1") {
			alert('아이디를 다시 확인해 주세요.');
			return;
		} else if ($("#password").val().length < 8) {
			alert('비밀번호를 8자 이상 입력해주세요.');
			return;
		} else if ($("#password2").val() != $("#password").val()) {
			alert('비밀번호를 다시 확인해주세요.');
			return;
		} else if ($("#name").val().length < 1) {
			alert('이름을 입력해주세요.');
			return;
		} else if ($("#phoneNum").val().length < 5) {
			alert('전화번호를 입력해주세요.');
			return;
		} else if ($("#email1").val().length < 1) {
			alert('이메일을 입력해주세요.');
			return;
		} else if ($("#email2").val().length < 1) {
			alert('이메일을 입력해주세요.');
			return;
		} else {
			var birth = $("#birthday");
			
			if (birth.val().length < 8) {
				var chk = document.getElementById('chkbirth');
					chk.innerHTML = '';
				birth.css("display", "none");
				birth.val("1000-01-01");
				birth.attr("readonly", true);
			}
			alert('가입이 완료되었습니다.');
			form.submit();
		}
	});
});
</script>
</head>
<body class="page1" id="top">
<%@include file="/WEB-INF/views/header.jsp"%>
<section class="content">
<div class="container" align="center">
	<form id="joinfrm" action="<%=request.getContextPath()%>/join" method="post">
	<div class="table" align="left" style="margin-top: 30px; margin-bottom: 50px; max-width: 500px;">
		<div class="tr">
			<div class="td" align="center">
			<h2 style="display: inline;">Join BeauTea</h2>
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
			<input type="text" id="id" name="id" style="padding-left: 5%; width: 92%; height: 25px;"/>
			<br><div id="idchk" style="font-size: small;"></div>
			<input type="hidden" id="idchked"/>
			</div>
		</div>
		<div class="tr">
			<div class="td">
			<font size="4">Password</font> &nbsp; &nbsp;(8자 이상)
			<br>
			<input type="password" id="password" name="password" style="padding-left: 5%; width: 92%; height: 25px;"/>
			<br><span id="chkpw" style="color: green; font-size: small;"></span>
			</div>
		</div>
		<div class="tr">
			<div class="td">
			<font size="4">Confirm Password</font>
			<br>
			<input type="password" id="password2" name="password2" style="padding-left: 5%; width: 92%; height: 25px;"/>
			<br><span id="chkpw2" style="color: green; font-size: small;"></span>
			</div>
		</div>
		<div class="tr">
			<div class="td">
			<font size="4">Your Name</font>
			<br>
			<input type="text" id="name" name="name" style="padding-left: 5%; width: 92%; height: 25px;"/>
			</div>
		</div>
		<div class="tr">
			<div class="td" style="padding-bottom: 50px;">
			<font size="4">Email</font>
			<br>
			<input type="text" id="email1" name="email1" style="padding-left: 2%; width: 22%; height: 25px;"/> @
			<input type="text" style="padding-left: 2%; width: 31%; height: 25px;" name="email2" id="email2"/>
			<select onchange="email(this.value)" style="width: 34%; height: 30px;">
				<option value="99">직접입력</option>
				<c:forEach var="e" items="${email}" varStatus="status">
				<option value="${status.count - 1}">${e}</option>
				</c:forEach>
			</select>
			<script type="text/javascript">
				function email(count) {
					var mail = ['naver.com', 'daum.net', 'nate.com', 'hanmail.net', 'gmail.com'];
					var tbox = document.getElementById('email2');
					if (count != 99 && count >= 0) {
						tbox.readOnly = true;
						tbox.value = mail[count];
					} else if (count == 99) {
						tbox.value = "";
						tbox.readOnly = false;
						tbox.placeholder = "직접 입력해주세요.";
					}
				}
			</script>
			</div>
		</div>
		<div class="tr">
			<div class="td">
			<font size="4">Nation</font>
			<br>
			<select name="country" id="country" style="width: 79%; height: 30px;">
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
			<input readonly="readonly" id="code" value="+82" type="text" style="border-right: 0; margin: 0; width: 40px; display:inline; height: 25px;"/><input style="display:inline; border-left: 0; margin: 0; width: 70%; height: 25px;" type="text" id="phoneNum" name="phoneNum"/>
			</div>
		</div>
		<div class="tr">
			<div class="td" align="center">
			<hr style="width: 15%" color="#aaccaa">
			선택사항
			</div>
		</div>
		<div class="tr">
			<div class="td">
			<font size="4">Birthday</font> &nbsp; &nbsp;ex) 19900821
			<br>
			<input id ="birthday" type="text" name="birthDay" maxlength="8" style="padding-left: 5%; width: 93%; height: 25px;"/><br>
			<span id="chkbirth" style="font-size: small;"></span>
			</div>
		</div>
		<div class="tr">
			<div class="td" style="padding-top: 50px;">
			계정 생성 시,
			<a onclick="privacy()" style="color: #aaccaa; cursor: pointer;">개인정보 수집 및 이용약관</a>에
			동의한 것으로 간주합니다.
			</div>
		</div>
		<div class="tr">
			<div class="td" align="center" style="padding-top: 30px;">
				<a style="width: 75%; height: 21px; text-align: center; border: solid 1px #aaccaa;" class="btn" id="join">Create BeauTea Account</a>
			</div>
		</div>
		
		<div class="tr">
			<div class="td">
			이미 BeauTea 계정이 있으신가요?
			<a href="<%=request.getContextPath()%>/login" style="color: #aaccaa; font-weight: bold;"> Log in</a>
			<font size="1">▶</font>
			</div>
		</div>
	</div>
	
		
	</form>
</div>
</section>
<%@include file="/WEB-INF/views/footer.jsp"%> 
</body>
</html>