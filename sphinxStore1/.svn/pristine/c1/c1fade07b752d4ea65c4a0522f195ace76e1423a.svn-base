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
$(function(){
	$("#parent").change(function() {
		$('#showCate').fadeIn("fast");
	});
});

function delcheck() {
	msg = "정말로 선택한 카테고리를 삭제하시겠습니까?";
	var dd = document.getElementById('parent').value;
	if (confirm(msg) != 0) {
		
		document.getElementById("frm").submit();
	} else {
		return;
	}
}

</script>
</head>
<body class="page1" id="top" style="display: none;">
<%@include file="/WEB-INF/views/header.jsp"%>
<!--=====================
          Content
======================-->
<form id="frm" action="<%=request.getContextPath()%>/admin/category/delete/choicesub" method="post">
<section class="content"><div class="ic"></div>
  <div class="container">
    <div class="row">
      <div class="grid_12" style="margin-top: 50px;">
        <div class="box">
          <div class="row">
            <div class="grid_5 preffix_1">
              <h2>카테고리 선택</h2>
              	삭제할 카테고리를 선택해 주세요.<br><br>
              	<select name="categoryId" size="10" style="width: 90%; overflow-x:auto;" id="parent">
              	<c:forEach var="cate" items="${subcate}" varStatus="status">
              	<c:if test="${cate.parentId.length() > 2}">
              		<option value="${cate.categoryId}">
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
              	<a href="<%=request.getContextPath()%>/admin/category/delete" class="btn">이전</a>
            </div>
            <div class="grid_5" id="conten">
              <h2>카테고리 삭제</h2>
              	<br><br>
              	<div style="display: none;" id="showCate">
              	<font color="red">
              	삭제 시 해당하는 하위카테고리와 카테고리 안의 모든 상품들이 삭제됩니다.
              	<br>
              	계속 진행하려면 아래의 '삭제' 버튼을 눌러주세요.
              	</font>
              	<br><br>
              	<a onclick="delcheck()" style="cursor: pointer;" class="btn">삭제</a>              		
              	</div>
            </div>
          </div>
        </div>
      </div>
       <div align="center">
      <span id="warnn" style="color: red;"></span><br>
      </div>
      <input type="hidden" value="${id}" name="ret">
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