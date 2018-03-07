
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Please wait</title>
</head>
<body>

	<% 
		request.setCharacterEncoding("UTF-8");
		String user_Id = request.getParameter("userId");
		String user_nic = request.getParameter("nicName");
		String user_Pass = request.getParameter("userPass");
		String user_Pass2 = request.getParameter("userPass2");
		String user_Name = request.getParameter("userName");
		String user_Birth = request.getParameter("userBirth");
		String user_Email2 = request.getParameter("userEmail2");
		String user_Addr = request.getParameter("userAddr");
		String user_PhoneNum1 = request.getParameter("userPhoneNum1");
		String user_PhoneNum2 = request.getParameter("userPhoneNum2");

	

		if (user_Id == null || user_Id == "") {
	%>
	 <script type="text/javascript">
		alert("아이디를 입력하세요.")
		history.go(-1)
	 </script>
	 	<%
		}else if (user_Pass == null ||user_Pass == "" ||user_Pass2 == "" || user_Pass2 == null || !user_Pass.equals(user_Pass2)) {
	%>
	<script type="text/javascript">
		alert("비밀번호를 확인하세요.")
		history.go(-1)
	</script>


	<%
		}
		else if (user_Name == null || user_Name == "") {
	%>
	<script type="text/javascript">
		alert("이름을 입력 하세요.")
		history.go(-1)
	</script>

	<%
		}
		else if (user_Birth == null || user_Birth == "") {
	%>
	<script type="text/javascript">
		alert("생년월일을 입력하세요.")
		history.go(-1)
	</script>

	<%
		}
		else if (user_Email2 == null || user_Email2 == "") {
	%>
	<script type="text/javascript">
		alert("이메일 주소를 입력하세요.")
		history.go(-1)
	</script>

	<%
		}
		else if (user_Addr == null || user_Addr == "") {
	%>
	<script type="text/javascript">
		alert("주소를 입력하세요.")
		history.go(-1)
	</script>

	<%
		}
		else if (user_PhoneNum1 == null || user_PhoneNum1 == "") {
	%>
	<script type="text/javascript">
		alert("휴대폰 번호를 입력하세요.")
		history.go(-1)
	</script>

	<%
		}
		else if (user_PhoneNum2 == null || user_PhoneNum2 == "") {
	%>
	<script type="text/javascript">
		alert("휴대폰 번호를 입력하세요.")
		history.go(-1)
	</script>
	<%
		}
		else if (user_nic == null || user_nic == "") {
	%>
	<script type="text/javascript">
		alert("닉네임을 입력하세요.")
		history.go(-1)
	</script>
	<%
		}
		else{
		RequestDispatcher dispatcher = request.getRequestDispatcher("/join.new");
		dispatcher.forward(request, response);
		}
	%>

</body>
</html>