
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>회 원 가 입</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/dug_Korea.css">

<script type="text/javascript">

function idCheck(){
 if(document.frm1.userId.value== "" || document.frm1.userId.value == null){
	 
	 alert('아이디를 입력하여 주십시오.');
	 document.frm1.userId.focus();
	 return;
 }
 var url=<%=request.getContextPath() %>+"/idCheck.do?userId=" + document.frm1.userId.value;
 window.open(url,"_blank_1","toolbar=no,menubar=no,scrollbars=yes,resizable=no, width=450, height=200" );
}

function nicCheck(){
	
	 if(document.frm1.nicName.value == ""){
		 alert('별명을 입력하여 주십시오.');
		 document.frm1.nicName.focus();
		 return;
	 }
 var url=<%=request.getContextPath() %>+"/nicCheck.do?nicName=" + document.frm1.nicName.value;
 window.open(url,"_blank_1","toolbar=no,menubar=no,scrollbars=yes,resizable=no, width=450, height=200" );
}

function emailSelect(){
	if(document.frm1.userEmail2.value == "other"){
		document.frm1.userEmail3.value = "";
		document.frm1.userEmail3.focus();
	}else{
		document.frm1.userEmail3.value = document.frm1.userEmail2.value;
		document.frm1.userEmail3.focus();
	}
}


function joinCheck() {
	if(document.frm1.userId.value.length == 0){
		alert("아이디를 입력하세요");
		frm1.userId.focus();
		return false;
	}
}
</script>

</head>

<body >
<div id="wrap" align="center">

		<div id="header">
			<jsp:include page="/form/header_Form.jsp" />
		</div>
		
<div id="middle">
	<h1>Join MemberShip</h1>
		
	<form action="checkJoin.jsp" method="post" name="frm1">
		<table style="width: 600px;">
			<tr>
				<th>Id<font style="color: red">*</font></th>
				<td>
				{user.userId}		
				</td>
			</tr>
	
			<tr>
				<th>별명<font style="color: red">*</font></th>
				<td>
				{user.nicName}	
				</td>
			</tr>
			<tr>
				<th>Password<font style="color: red">*</font></th>
				<td><input type="password" value="${user.pass}" name="userPass" style="margin: 1px" ></td>
			</tr>
			<tr>
				<th >RetypePassword<font style="color: red">*</font></th>
				<td ><input
					type="password" name="userPass2" style="margin: 1px" /></td>
			</tr>
			<tr>
				<th >이름<font
					style="color: red">*</font></th>
				<td ><input type="text"
					name="userName" value="${user.userName}" style="margin: 1px" /></td>
			</tr>
			<tr>
				<th >생년월일<font
					style="color: red">*</font></th>
				<td >${user.birth} </td>
			</tr>
			
			<tr>
				<th >E-mail</th>
				<td ><input type="text"
					size="7" name="userEmail1" /> @ <input type="text" size="7" name="userEmail3">
					 <select name="userEmail2" >
						<option value="other"onclick="emailSelect()">직접입력</option>
						<option value="gogle.com" onclick="emailSelect()"> gogle.com </option>
						<option value="hanmail.com" onclick="emailSelect()"> hanmail.com</option>
						<option value="paran.com" onclick="emailSelect()"> paran.com</option>
						
						
				</select></td>
			</tr>
			<tr>
				<th >주소<font
					style="color: red">*</font></th>
				<td ><input type="text"	name="userAddr" style="margin: 1px" />
				&nbsp;&nbsp;&nbsp; <input type="button"
					 value="검색"></td>
			</tr>
			<tr>
				<th>전화번호<font
					style="color: red">*</font></th>
				<td ><input
					type="radio" name="userPhone" style="margin: 1px" checked />SKT <input
					type="radio" name="userPhone" />LGT <input type="radio"
					name="userPhone" />KTF <br> <Select name="userPhoneNum0">
						<option value="011">011</option>
						<option value="016">016</option>
						<option value="019">019</option>
				</Select>- <input type="text" size="5" maxlength="4" name="userPhoneNum1" />
					- <input type="text" size="5" maxlength="4" name="userPhoneNum2" /></td>

			</tr>
			<tr>
				<th >취미</th>
				<td ><input
					type="checkbox" name="userHobby" value="수영" />수영 <input
					type="checkbox" name="userHobby" value="배구" />배구 <input
					type="checkbox" name="userHobby" value="프로그래밍" />프로그래밍 <input
					type="checkbox" name="userHobby" value="독서" />독서 <br> <input
					type="checkbox" name="userHobby" value="자바" />자바 <input
					type="checkbox" name="userHobby" value="라면먹기" />라면먹기 <input
					type="checkbox" name="userHobby" value="낮잠" />낮잠 <br> <input
					type="checkbox" name="userHobby" />기타 <input
					type="text" name="userOtherHobby"/></td>
			</tr>
		</table>

		<div align="center">
		<br>
			 <input	type="button" value="뒤로가기"
				style="margin: 1px; background-color: buttonhighlight;" onclick="location.href='<%=request.getContextPath() %>/Form/main_Form.jsp'">
				&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="submit" value="회원가입"
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