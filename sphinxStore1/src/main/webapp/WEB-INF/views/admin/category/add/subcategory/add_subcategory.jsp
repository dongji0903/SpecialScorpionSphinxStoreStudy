<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title><link rel="icon" href="<%=request.getContextPath()%>/resources/images/favicon.ico">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script type="text/javascript">
$(function() {
	$("#sub").click(function() {
		var form = $("#frm");
		var span = $("#warnn");
		if ($("#cate_type").val() == 0) {
			span.html("Root 카테고리를 선택해주세요.");
			return;
		} else {
			form.submit();
		}
	});
});
</script>
</head>
<body class="page1" id="top" style="display: none;">
<%@include file="/WEB-INF/views/header.jsp"%>
<!--=====================
          Content
======================-->
<form id="frm" action="<%=request.getContextPath()%>/admin/category/addsub/selparent" method="get">
<section class="content"><div class="ic"></div>
  <div class="container">
    <div class="row">
      <div class="grid_12" style="margin-top: 50px;">
        <div class="box">
          <div class="row">
            <div class="grid_5 preffix_1">
              <h2>Sub 카테고리 생성</h2>
              	생성하고자하는 카테고리의 상위 Root카테고리를 선택해주세요.<br><br>
              	<select style="width: 90%; height: 30px;" id="cate_type" name="categoryId">
              	<option value = "0">--카테고리 선택--</option>
              	<c:forEach var="cate" items="${rootcate}">
              		<option value="${cate.categoryId}">${cate.categoryName}</option>
              	</c:forEach>
              	</select><br>
            </div>
            <div class="grid_5" id="conten">
              <h2>Create Sub Category</h2>
              	서브 카테고리를 생성 할 수 있습니다. Root카테고리의 바로 밑에 하위를 1차라고 칭하며 아이템 생성 혹은 게시글 작성은 2차 카테고리에서 가능합니다. Root로 묶고나서도 분류되어있는 카테고리들을
              	 다시 한번 더 묶을 수 있습니다.<br>
            </div>
          </div>
        </div>
      </div>
      <div align="center">
      <span id="warnn" style="color: red;"></span><br>
      	<a style="cursor: pointer;" class="btn" id="sub">다음</a>
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