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
		if ($("#cate_name").val().length < 1) {
			span.html("적절하지않은 카테고리명입니다.");
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
<script type="text/javascript">
$(function(){
	var name = $("#cate_name");
	var id = $("#cate_id");
	
	$("#parent").change(function() {
		var value = this.value;
		var real_id = value.split("/")[0];
		var real_name = value.split("/")[1];
		
		id.val(real_id);
		name.val(real_name);
		
		$('#showCate').fadeIn("fast");
	});
});
</script>
</head>
<body class="page1" id="top" style="display: none;">
<%@include file="/WEB-INF/views/header.jsp"%>
<!--=====================
          Content
======================-->
<form id="frm" action="<%=request.getContextPath()%>/admin/category/sucedit" method="post">
<section class="content"><div class="ic"></div>
  <div class="container">
    <div class="row">
      <div class="grid_12" style="margin-top: 50px;">
        <div class="box">
          <div class="row">
            <div class="grid_5 preffix_1">
              <h2>카테고리 선택</h2>
              	Root카테고리 선택시 변경가능한 카테고리의 리스트가 표시됩니다.<br><br>
              	<select size = "10"  style=" width: 90%; overflow-x:auto; "id="parent">
              	<c:forEach var="cate" items="${subcate}" varStatus="status">
              	<c:if test="${cate.parentId.length() > 2}">
              		<option value="${cate.categoryId}/${cate.categoryName}">

              		<c:if test="${cate.parentId.length() > 2}">
							<c:forEach var="parent" items="${parents.get(cate.categoryId)}">
								${parent.categoryName} > 
							</c:forEach>
					</c:if>
							${cate.categoryName}
					</option>
				</c:if>
              	</c:forEach>
              	</select><br>
              	<a href="<%=request.getContextPath()%>/admin/category/edit" class="btn">이전</a>
            </div>
            <div class="grid_5" id="conten">
              <h2>카테고리 변경</h2>
              	좌측에서 변경하고자하는 카테고리 선택시 변경 메뉴가 표시됩니다.<br><br>
              	<div style="display: none;" id="showCate">
              	카테고리 이동을 원한다면 부모 카테고리를 선택해주세요.<br>
              	<select style="width: 90%; height: 30px;" name="parentId">
              	<option value="999">-- 부모 카테고리 --</option>
              	<c:forEach var="cate" items="${all}" varStatus="status">
              		<option value="${cate.categoryId}">

              	<c:if test="${cate.parentId.length() > 2}">
						<c:forEach var="parent" items="${parents.get(cate.categoryId)}">
							${parent.categoryName} > 
						</c:forEach>

				</c:if>
							${cate.categoryName}
					</option>
              	</c:forEach>
              	</select><br><br>
              	카테고리의 유형을 변경하고자 할 경우 유형을 선택해주세요.<br>
				<select style="width: 90%; height: 30px;" name="type">
					<option value="999">---카테고리 타입---</option>
					<option value="0">쇼핑몰 타입</option>
					<option value="1">게시판 타입</option>
				</select>              	<br><br>
				카테고리의 이름을 변경하고자 할 경우 이름을 입력해주세요.<br>
              		명칭 : <input type="text" id="cate_name" name="categoryName" style="width: 70%; height: 25px;"><br>
              		<input type="hidden" id="cate_id" name="categoryId">
              		<a id="sub" style="cursor: pointer;" class="btn">저장</a>              		
              	</div>
            </div>
          </div>
        </div>
      </div>
       <div align="center">
      <span id="warnn" style="color: red;"></span><br>
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