<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상품 입력</title>
</head>
<body>
<form action="<%=request.getContextPath() %>/admin/product/addProduct" name="frm" method="post">
<label>카테고리 선택</label> <input type="button" value="선택"
 onclick="window.open('../category/findCategory','_blank_1','toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=450, height=200');"><br>
카테고리 ID : <input type="text" name="categoryId" readonly="readonly"> <br>
카테고리 이름 : <input type="text" name="categoryName" readonly="readonly"> <br>
<input type="hidden" name="superId">
<br>
상품명 : <input type="text" name="productName"> <br>
판매가 : <input type="text" name="price"> <br>
상세설명 : <input type="text" name="content"> <br>
코멘트 : <input type="text" name="comment"> <br>
첨부파일 : <input type="text" name="fileName"> <br>
<input type="submit" value="생성">

</form>
</body>
</html>