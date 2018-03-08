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
	
	function chkForm() {
		var form = $("#frm");
		var span = $("#warnn");
		if ($("#parent").val() == null) {
			span.html("부모 카테고리를 선택해주세요.");
			return;
		} else if ($("#cate_type").val().length > 3) {
			span.html("카테고리의 유형을 선택해주세요.");
			return;
		} else if ($("#categoryName").val().length < 1) {
			span.html('카테고리의 명칭을 입력해주세요.');
			return;
		} else {
			form.submit();
		}
	}
	
	$("#sub").click(function() {
		chkForm();
	});
	
	$('input[type="text"]').keydown(function() {
	    if (event.keyCode === 13) {
	        event.preventDefault();
			chkForm();
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
<form id="frm" action="<%=request.getContextPath()%>/admin/category/sucaddsub" method="post">
<section class="content"><div class="ic"></div>
  <div class="container">
    <div class="row">
      <div class="grid_12" style="margin-top: 50px;">
        <div class="box">
          <div class="row">
            <div class="grid_5 preffix_1">
              <h2>Sub 카테고리 생성</h2>
              <input type="hidden" value="${subcate.get(0).getCategoryId()}" name="ret">
              	생성하고자하는 카테고리의 상위 Root카테고리를 선택해주세요.<br><br>
              	<select style="width: 90%;overflow-x:auto; height: 35px;" id="parent" name="parentId">
              	<c:forEach var="cate" items="${subcate}">
              		<option value="${cate.categoryId}">

              	<c:if test="${cate.parentId.length() > 2}">
						<c:forEach var="parent" items="${parents.get(cate.categoryId)}">
							${parent.categoryName} > 
						</c:forEach>

				</c:if>
							${cate.categoryName}
					</option>
				
              	</c:forEach>
              	</select><br>
              	<select style="width: 90%; height: 30px;" id="cate_type" name="type">
	              	<option value="none">--게시판 유형 선택--</option>
	              	<option value="0">쇼핑몰 타입</option>
	              	<option value="1">게시판 타입</option>
              	</select><br><br>
              	생성하고자하는 카테고리의 명칭을 입력해주세요.<br>
              	<input type="text" id="categoryName" name="categoryName" style="width: 87%;height: 40px; padding-left:5px; padding-right:5px; font-size: 17px;"><br>
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
      	<a class="btn" id="sub">생성</a>
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