<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		if ($("#root").val().length > 3) {
			span.html("카테고리의 유형을 선택해주세요.");
			return;
		} else if ($("#categoryName").val().length < 1) {
			span.html('카테고리의 명칭을 입력해주세요.');
			return;
		} else {
			alert('카테고리 생성이 완료되었습니다.');
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
<form id="frm" action="<%=request.getContextPath()%>/admin/category/sucaddmain" method="post">
<section class="content"><div class="ic">More Website Templates @ TemplateMonster.com - July 30, 2014!</div>
  <div class="container">
    <div class="row">
      <div class="grid_12" style="margin-top: 50px;">
        <div class="box">
          <div class="row">
            <div class="grid_5 preffix_1">
              <h2>Create Root Category</h2>
              <p>Root 카테고리를 생성 할 수 있습니다. Root 카테고리에는 게시글 혹은 상품 등록이 불가능합니다. 여러 분류를 하나로 묶기위해서는 Root 카테고리를 생성 해야합니다.
              <br>
            </div>
            <div class="grid_5" id="conten">
              <h2>Root 카테고리 생성</h2>
              	Root카테고리의 명칭을 입력하고 타입을 선택 해주세요.<br><br>
              	<select style="width: 90%; height: 30px;" id="root" name="type">
              	<option value="none">--게시판 유형 선택--</option>
              	<option value="0">쇼핑몰 타입</option>
              	<option value="1">게시판 타입</option>
              	</select><br>
              	<input type="text" id="categoryName" name="categoryName" style="width: 87%; height: 40px; padding-left:5px; padding-right:5px; font-size: 17px;"><br>
            </div>
          </div>
        </div>
      </div>
      <div align="center">
      <span id="warnn" style="color: red;"></span><br>
      	<a class="btn" id="sub" style="cursor: pointer;">생성하기</a>
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