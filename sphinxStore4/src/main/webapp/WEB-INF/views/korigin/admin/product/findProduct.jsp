<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상품 검색</title>
<script type="text/javascript">
function setProduct() {
	opener.frm.productId.value = '${searchProduct.productId }';
	opener.frm.productName.value = '${searchProduct.productName }';
	self.close();
}
</script>
</head>
<body>
	<form name="findfrm" action="<%=request.getContextPath()%>/admin/product/findProduct"
		method="post">
		<label>검색기준</label> <select name="searchValue">
			<option value="name">이름</option>
			<option value="id">ID</option>
		</select> <br> 내용 : <input type="text" name="search" /> <br> <input
			type="submit" value="검색" /> <br>
	</form>
	<c:if test="${searchProduct != null }">
		상품 ID : ${searchProduct.productId } <br>
		상품 명 : ${searchProduct.productName } <br>
		<input type="button" value="선택" onclick="setProduct()"/> <br>
	</c:if>
</body>
</html>