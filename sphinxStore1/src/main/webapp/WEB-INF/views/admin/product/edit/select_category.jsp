<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#choiceCate").click(function(){
			var theForm = $("#categoryfrm");
			var category = $("#category");
			if(category.val() < 1) {
				alert("카데고리를 선택해주세요.");
			} else {
				theForm.submit();
			}
		});
	});
</script>
</head>
<body class="page1" id="top">
<%@include file="/WEB-INF/views/header.jsp"%>
<!--=====================
          Content
======================-->
<form id="categoryfrm" action="<%=request.getContextPath()%>/admin/product/edit/choiceproduct" method="get">
<section class="content">
  <div class="container">
    <div class="row">
      <div class="grid_12">
        <div class="box">
          <div class="row">
            <div class="grid_5 preffix_1" >
              	<h2>카테고리 선택</h2>
              	카테고리 선택 시, 선택한 카테고리에 해당하는 상품들을 볼 수 있습니다.<br>
              	
            </div>
            <div class="grid_5" style="margin-top: 50px;">
             	<select size="10" style="width: 90%; overflow-x:auto;" name="categoryId" id="category">
              	<c:forEach var="root" items="${shoppingCategory}" varStatus="status">
              		<c:forEach var="sub" items="${subCategoryMap.get(root.categoryId)}">
	              		<c:if test="${sub.parentId.length() > 2}">
	              		<option value="${sub.categoryId}">
            	  			<c:if test="${sub.parentId.length() > 2}">
								<c:forEach var="parent" items="${parentCategoryMap.get(sub.categoryId)}">
									${parent.categoryName} > 
								</c:forEach>
							</c:if>
							${sub.categoryName}
						</option>
						</c:if>
					</c:forEach>
              	</c:forEach>
              	</select><br>
              	<a id="choiceCate" class="btn" style="cursor: pointer;">다음</a>
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