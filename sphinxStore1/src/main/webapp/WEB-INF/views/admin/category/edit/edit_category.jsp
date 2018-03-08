<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script type="text/javascript">
$(function() {
	$("#cate_type").change(function() {
		frm.submit();
	});
});
</script>
</head>
<body class="page1" id="top" style="display: none;">
<%@include file="/WEB-INF/views/header.jsp"%>
<!--=====================
          Content
======================-->
<form id="frm" action="<%=request.getContextPath()%>/admin/category/edit/choicesub" method="get">
<section class="content"><div class="ic"></div>
  <div class="container">
    <div class="row">
      <div class="grid_12" style="margin-top: 50px;">
        <div class="box">
          <div class="row">
            <div class="grid_5 preffix_1">
              <h2>Root 카테고리 선택</h2>
              	수정하고자하는 카테고리가 속하는 Root카테고리를 선택해주세요.<br><br>
              	<select style="width: 90%; height: 30px;" id="cate_type" name="categoryId">
              	<option value = "0">--카테고리 선택--</option>
              	<c:forEach var="cate" items="${rootcate}">
              		<option value="${cate.categoryId}">${cate.categoryName}</option>
              	</c:forEach>
              	</select><br>
            </div>
            <div class="grid_5" id="conten">
              <h2>카테고리 변경</h2>
              	Root카테고리 선택시 변경가능한 카테고리의 리스트가 표시됩니다.<br>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
</form>
<!--==============================
              footer
=================================-->
<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>