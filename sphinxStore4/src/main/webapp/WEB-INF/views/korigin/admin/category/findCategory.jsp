<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>카테고리 찾기</title>
<script type="text/javascript">
function setCategory() {
	opener.frm.categoryId.value = '${searchCategory.categoryId }';
	opener.frm.superId.value = '${searchCategory.superId }';
	opener.frm.categoryName.value = '${searchCategory.categoryName }';
	self.close();
}
</script>
</head>
<body>
	<form name="findfrm" action="<%=request.getContextPath()%>/admin/category/findCategory"
		method="post">
		<label>검색기준</label> <select name="searchValue">
			<option value="name">이름</option>
			<option value="id">ID</option>
		</select> <br> 내용 : <input type="text" name="search" /> <br> <input
			type="submit" value="검색" /> <br>
	</form>
	<c:if test="${searchCategory != null }">
		카테고리 ID : ${searchCategory.categoryId } <br>
		상위 카테고리 ID : ${searchCategory.superId } <br>
		카테고리 명 : ${searchCategory.categoryName } <br>
		<input type="button" value="선택" onclick="setCategory()"/> <br>
	</c:if>
</body>
</html>