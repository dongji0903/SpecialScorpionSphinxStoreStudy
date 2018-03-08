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
	var theForm = $("#categoryfrm");
	$("#choiceCate").change(function(){
		theForm.submit();
	});
});
</script>
</head>
<body>
  <div class="container">
    <div class="row">
      <div class="grid_12">
        <div class="box">
          <div class="row">
            <form id="categoryfrm" action="<%=request.getContextPath()%>/admin/product/edit/choiceproduct" method="get">
            <div class="grid_5 preffix_1" style="margin-top: 20px;">
             	<select style="width: 90%; height: 30px; overflow-x:auto;" name="categoryId" id="choiceCate">
              		<option value="${category.categoryId}">
              			<c:if test="${category.parentId.length() > 2}">
							<c:forEach var="parent" items="${parentCategoryMap.get(category.categoryId)}">
								${parent.categoryName} > 
							</c:forEach>
						</c:if>
						${category.categoryName}
              		</option>
              	<c:forEach var="root" items="${shoppingCategory}" varStatus="status">
              		<c:forEach var="sub" items="${subCategoryMap.get(root.categoryId)}">
	              		<c:if test="${sub.parentId.length() > 2 && sub.categoryId != category.categoryId}">
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
            </div>
            </form>
            <div class="grid_5" >
				<!-- 내용없음 -->
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>
</html>