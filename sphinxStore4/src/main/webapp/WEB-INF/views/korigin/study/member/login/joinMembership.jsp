<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>회 원 가 입</title>
<script type="text/javascript">
function findId() {
	if(idCheck()){
		var url= "<%=request.getContextPath()%>/member/idCheck?userId=" + document.frm1.userId.value;
		 window.open(url,"_blank_1","toolbar=no,menubar=no,scrollbars=yes,resizable=no, width=450, height=200" );
	}
}
function findNick() {
	if(nickCheck()){
		var url= "<%=request.getContextPath()%>/member/nickCheck?nickName=" + document.frm1.nickName.value;
		window.open(url,"_blank_1","toolbar=no,menubar=no,scrollbars=yes,resizable=no, width=450, height=200" );
	}
}
function idCheck(){
	if(document.frm1.userId.value== "" || document.frm1.userId.value == null){
		alert('아이디를 입력하여 주십시오.');
		document.frm1.userId.focus();
		return false;
	}else{
		return true;
	}
}
function nickCheck(){
	alert('nicCheck');
	 if(document.frm1.nickName.value == "" || document.frm1.nickName.value == null){
		 alert('별명을 입력하여 주십시오.');
		 document.frm1.nickName.focus();
		 return false;
	 }else{
		 return true;
	 }
}
function findAddress() {
	window.open("<%=request.getContextPath()%>/login/findAddress.jsp","_blank_1",
						"toolbar=no,menubar=no,scrollbars=yes,resizable=no, width=450, height=200");
}
function checkPass() {
	if ((frm1.userPass2.value == null||frm1.userPass2.value =="") && (frm1.userPass.value == null||frm1.userPass.value =="")) {
		document.getElementById('isEqual').innerHTML = '<font color="red"> 비밀번호를 입력하세요.</font>';
		return false;
	} else {
		if (frm1.userPass.value != frm1.userPass2.value) {
			document.getElementById('isEqual').innerHTML = '<font color="red"> 불일치</font>';
			return false;
		} else {
			document.getElementById('isEqual').innerHTML = '<font color="blue"> 일치</font>';
			return true;
		}
	}
}
function submitCheck() {
	if(!checkPass()){
		alert('띠용');
		return false;
	}else if(frm1.idChecked.value=="false"){
		alert('아이디 중복 확인을 해주세요.');
		frm1.userId.focus();
		return false;
	}else if(frm1.nickChecked.value=="false"){
		alert('별명 중복 확인을 해주세요.');
		frm1.nickChecked.focus();
		return false;
	}
	return true;
	
}
	
</script>

</head>

<body>
			<h1>Join MemberShip</h1>
			<div style="text-align: left; padding-left: 200px">
				<font style="color: red">*</font>필수입력정보입니다.
			</div>
			<form action="<%=request.getContextPath()%>/member/join" method="post" name="frm1">
				<table style="width: 600px;">
					<tr>
						<th width="167px">Id<font style="color: red">*</font></th>
						<td><input type="hidden" name="idChecked" value="false">
							<input required="required" type="text" name="userId"
							style="margin: 1px">&nbsp;&nbsp;&nbsp; <input
							type="button" value="아이디체크" onclick="findId()"></td>
					</tr>

					<tr>
						<th>별명<font style="color: red">*</font></th>
						<td><input type="hidden" name="nickChecked" value="false">
							<input required="required" type="text" name="nickName"
							style="margin: 1px"> &nbsp;&nbsp;&nbsp; <input
							type="button" value="중복검사" onclick="findNick()"></td>
					</tr>
					<tr>
						<th>Password<font style="color: red">*</font></th>
						<td><input onkeyup="checkPass()" required="required"
							type="password" name="userPass" style="margin: 1px"></td>
					</tr>
					<tr>
						<th>RetypePassword<font style="color: red">*</font></th>
						<td><input onkeyup="checkPass()" required="required"
							type="password" name="userPass2" style="margin: 1px" /><span
							id="isEqual"></span></td>
					</tr>
					<tr>
						<th>이름<font style="color: red">*</font></th>
						<td><input type="text" required="required" name="userName"
							style="margin: 1px" /></td>
					</tr>
					<tr>
						<th>생년월일<font style="color: red">*</font></th>
						<td><input required="required" type="date" name="userBirth"
							style="margin: 1px" /></td>
					</tr>
					<tr>
						<th>성별</th>
						<td><input type="radio" name="gender" style="margin: 1px"
							checked />남 <input type="radio" name="gender"
							style="margin: 1px" />여</td>
					</tr>
					<tr>
						<th>E-mail</th>
						<td><input type="text"
							pattern="[a-zA-Z0-9]+@[a-zA-Z0-9]+\.[a-zA-Z0-9]+$"
							title="이메일 형식에 맞춰 입력하세요." required="required" size="20"
							name="userEmail" /></td>
					</tr>
					<tr>
						<th>주소<font style="color: red">*</font></th>
						<td><input required="required" type="text" name="userAddr"
							style="margin: 1px" /> &nbsp;&nbsp;&nbsp; <input type="button"
							value="검색" onclick="findAddress()"></td>
					</tr>
					<tr>
						<th>전화번호</th>
						<td><input type="radio" name="userPhone" style="margin: 1px"
							checked />SKT <input type="radio" name="userPhone" />LGT <input
							type="radio" name="userPhone" />KTF <br> <Select
							name="userPhoneNum0">
								<option value="011">011</option>
								<option value="016">016</option>
								<option value="019">019</option>
						</Select>- <input type="text" size="5" maxlength="4" name="userPhoneNum1" />
							- <input type="text" size="5" maxlength="4" name="userPhoneNum2" /></td>

					</tr>
				</table>

				<div align="center">
					<br> <input type="button" value="뒤로가기"
						style="margin: 1px; background-color: buttonhighlight;"
						onclick="location.href='<%=request.getContextPath()%>/Form/main_Form.jsp'">
					&nbsp;&nbsp;&nbsp;&nbsp; <input type="submit"
						onclick="return submitCheck()" value="회원가입"
						style="margin: 1px; background-color: buttonhighlight;">
				</div>
			</form>

</body>
</html>