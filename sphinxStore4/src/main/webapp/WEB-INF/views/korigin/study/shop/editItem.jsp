<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/dug_Korea.css">
<title>판매글 수정</title>
<script>
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
			<div style="width: 700px">
				<form action="<%=request.getContextPath()%>/shop/updateItem.do"
					name="frm3" method="post" enctype="multipart/form-data">
					<table>
						<tr>
							<th>상품명</th>
							<td><input required="required" type="text" size="70"
								name="name" value="${item.name}"></td>
						</tr>
						<tr>
							<th>사진첨부</th>
							<td><input type="file" name="url"></td>
						</tr>
						<tr>
							<th>가격 변경</th>
							<td><input required="required" type="text" name="price"
								value="${item.price}"></td>
						</tr>
						<tr>
						<tr>
							<th>재고 변경</th>
							<td><input required="required" type="text" name="stock"
								value="${stock}"></td>
						</tr>
						<tr>
							<th>옵션 설정</th>
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
							<th>상세 정보</th>
							<td><textarea cols="80" rows="15" id="content"
									required="required" name="content"></textarea></td>
						</tr>
					</table>
					<input type="button" value="취 소"
						onclick="location.href = '<%=request.getContextPath()%>/shop/index.do'">
					<input type="submit" value="수 정"> <input type="hidden"
						name="num" value="${item.num }">
				</form>
			</div>
		</div>

		<div id="footer">
			<div
				style="background-color: maroon; min-height: 4px; margin-bottom: 4px;"></div>
			<jsp:include page="/form/footer_Form.jsp" />
		</div>
	</div>
</body>
</html>