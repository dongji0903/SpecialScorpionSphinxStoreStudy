<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상세 보기</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/dug_Korea.css">

<script type="text/javascript">
	function put_item() {
		if(document.frm3.count.value <= 0){
			alert("수량을 확인하세요");
			return false;
		}
		
		if(document.frm3.type1.value == null){
			alert("type1를 선택하세요");
			return false;
		}
	
		if(document.frm3.type2.value == null){
			alert("type2을 선택하세요");
			return false;
		}
		document.frm3.submit();
	}
	
	function buy_item(i) {
		if(document.frm3.count.value<=0){
			alert("수량을 확인하세요");
			return false;
		}
		
		if(document.frm3.type1.value == null){
			alert("type1를 선택하세요");
			return false;
		}
		
		if(document.frm3.type2.value == null){
			alert("type2을 선택하세요");
			return false;
		}
		document.frm3.action = '<%=request.getContextPath()%>/shop/directOrder.do';
		document.frm3.submit();
	}
</script>
</head>
<body>

			<div>
				<div align="left" style="margin-bottom: 5px;">
					<input type="button" value="뒤로" align="left"
						onclick="location.href='<%=request.getContextPath()%>/shop/index.do'">
					<c:if test="${isAdmin == 1}">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="button"
							name="edit" value="판매글 수정"
							onclick="location.href='<%=request.getContextPath()%>/shop/viewUpdateItem.do?num=${item.num }'">
						<input type="button" name="delete1" value="판매글 삭제"
							onclick="location.href='<%=request.getContextPath()%>/shop/editItem.do?num=${item.num }'">
					</c:if>
				</div>
				<form action="<%=request.getContextPath()%>/shop/addCart.do"
					name="frm3">
					<table>
						<tr>
							<td rowspan="6" style="width: 500px;"><img
								src="<%=request.getContextPath() %>/upload/${item.url}"
								width="500px" height="500px"></td>
						</tr>
						<tr>
							<td
								style="font-size: 2.5em; border-bottom-color: white; line-height: 32px;">${item.name}</td>

						</tr>
						<tr>
							<td style="font-size: xx-large; text-align: right;">${items[0].price}
								원</td>
						</tr>
						<tr>
							<td>&nbsp;&nbsp;&nbsp; <select name="type1"
								style="width: 300px; height: 40px;">
									<c:forEach var="type1" items="${items}">
										<option>${type1.type1}</option>
									</c:forEach>
							</select>
							</td>
						</tr>
						<tr>
							<td>&nbsp;&nbsp;&nbsp; <select name="type2"
								style="width: 300px; height: 40px;">
									<c:forEach var="type2" items="${items}">
										<option>${type2.type2}</option>
									</c:forEach>
							</select>
							</td>
						</tr>
						<tr>
							<td colspan="3">&nbsp;&nbsp;&nbsp; 수 량 <input type="number"
								name="count" size="1" height="100px" required="required">
								&nbsp;&nbsp;&nbsp; <a href="#" onclick="put_item()">장바구니 추가</a>
								&nbsp;&nbsp;&nbsp; <a href="#" onclick="buy_item()">구매 하기</a>
							</td>
							</tr>
						<tr>
							<th colspan="2">상세내용</th>
						</tr>
						<tr>
							<td colspan="2">${items[0].content}</td>
						</tr>
					</table>
					<input type="hidden" name="num" value="${param.type1}">
				</form>
			</div>


</body>
</html>