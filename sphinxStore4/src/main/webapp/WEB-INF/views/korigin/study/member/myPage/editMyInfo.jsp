<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>정 보 수 정 </title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/dug_Korea.css">

<script type="text/javascript">

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
		<div id="mian">
			<jsp:include page="index.jsp" />
		</div>

		<div id="container">
			회원 정보 수정
			<form action="<%=request.getContextPath()%>/myPage/editMemberInfo.do" method="post" name="frm1">
				<table style="width: 600px;">
					<tr>
						<th width="167px">Id</th>
						<td> ${member.id}</td>
					</tr>

					<tr>
						<th>별명</th>
						<td>${member.nickName}</td>
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
						<th>이름</th>
						<td>${member.name}</td>
					</tr>
					<tr>
						<th>생년월일</th>
						<td>${member.birth}</td>
					</tr>
					<tr>
						<th>E-mail</th>
						<td><input type="text"
							pattern="[a-zA-Z0-9]+@[a-zA-Z0-9]+\.[a-zA-Z0-9]+$"
							title="이메일 형식에 맞춰 입력하세요." required="required" size="20"
							name="userEmail" value="${member.email}" /></td>
					</tr>
					<tr>
						<th>주소 </th>
						<td><input required="required" type="text" name="userAddr"
							style="margin: 1px" value="${member.address}" /> &nbsp;&nbsp;&nbsp; <input type="button"
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
					 <input type="submit" onclick="return submitCheck()" value="수정">
				</div>
				<input type="hidden" name="userId" value="${member.id}">
			</form>
		</div>
</body>
</html>