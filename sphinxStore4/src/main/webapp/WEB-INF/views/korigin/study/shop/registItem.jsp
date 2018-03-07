<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>판매상품 생성</title>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/dug_Korea.css">
<script>
	function Check() {
		if (document.frm.title.value.length == 0) {
			alert("이름을 입력하세요.");
			return false;
		}
		return true;
	}

	function AddItem(i) {
		var opt1 = i.parentNode;
		var divItem = document.createElement('div');
		var txtItem = document.createElement('input');
		txtItem.type = 'text';
		txtItem.name = opt1.id + 'Val';
		divItem.appendChild(txtItem);
		var delItem = document.createElement('input');
		delItem.type = 'button';
		delItem.value = '삭제';
		delItem.onclick = function() {
			divItem.remove()
		};
		divItem.appendChild(delItem);
		opt1.appendChild(divItem);
	}
</script>

</head>
<body>
	<div id="wrap" align="center">
		<div id="header">
			<jsp:include page="/form/header_Form.jsp" />
		</div>

		<div id="middle">
			<div>
				<h1>상품 등록</h1>
				<div style="width: 700px">
					<form name="frm" method="post" enctype="multipart/form-data"
						action="<%=request.getContextPath()%>/shop/registItem.do ">
						<table>
							<tr>
								<th>상품명</th>
								<td><input required="required" type="text" size="70" name="name"></td>
							</tr>
							<tr>
								<th>사 진</th>
								<td><input type="file" name="url"></td>
							</tr>
							<tr>
								<th>가 격</th>
								<td><input required="required" type="text" name="price"></td>
							</tr>
							<tr>
							<tr>
								<th>재 고</th>
								<td><input required="required" type="text" name="stock"></td>
							</tr>
							<tr>
								<th>옵 션</th>
								<td>
									<div>
										<div id="option1" style="float: left;">
											<input type="text" name="option1Val" value="옵션1"> <input
												type="button" value="추가" onclick="AddItem(this)">
											<div id="option1"></div>
										</div>
										<div id="option2" style="float: left; margin-left: 10px;">
											<input type="text" name="option2Val" value="옵션2"> <input
												type="button" value="추가" onclick="AddItem(this)">
											<div id="option2"></div>
										</div>
									</div>
								</td>
							</tr>
							<tr>
								<th>상세정보</th>
								<td><textarea required="required" cols="80" rows="15" id="content"
										name="content"></textarea></td>
							</tr>
						</table>
						<br> <br> <input type="submit" value="생 성"
							onclick="return Check()"> <input type="button"
							value="취 소"
							onclick="location.href='<%=request.getContextPath()%>/shop/index.do'">
					</form>
				</div>
			</div>

			<div id="footer">
				<div
					style="background-color: maroon; min-height: 4px; margin-bottom: 4px;"></div>
				<jsp:include page="/form/footer_Form.jsp" />
			</div>
		</div>
	</div>
</body>
</html>