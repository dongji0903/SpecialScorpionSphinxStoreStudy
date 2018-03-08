<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/menubar/css/reset.css"> <!-- CSS reset -->
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/menubar/css/style.css"> <!-- Resource style -->
	<script src="<%=request.getContextPath()%>/resources/menubar/js/modernizr.js"></script> <!-- Modernizr -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script type="text/javascript">
$(function () {
	$("#searchBox").keydown(function(key) {
		if (key.keyCode == 13) {
			var value = $(this).val();
			if (value.length < 2) {
				alert('검색은 2글자 이상으로만 가능합니다.');
				return false;
			}
			$(this).val('');
			$.ajax({
	               type: 'POST',
	                url: '<%=request.getContextPath()%>/menu/searchByName',
	                data: {
	                    "keyword" : value
	                },
	                success: function(data) {
	                    /* 차후 로직 */
	                    if (data != 'null') {
		                    var products = data.split(":");
			                    for (var i = 0; i < products.length; i++) {
			                    	if (i == 0) {
				                    		$(".cd-divider").html(""+
				                    		"<a style='font-size:small; padding-bottom:0; margin-bottom:0;' href='<%=request.getContextPath()%>/view/product?productId="+ 
				                    		products[i].split("/")[0] +"'>"+
				                    		products[i].split("/")[1] +" - "+
				                    		products[i].split("/")[2] +"원"+
				                    		"</a>"+
				                    		"<br>");
			                    	} else {
				                    		$(".cd-divider").append(""+
				    	                    "<a style='font-size:small; padding-bottom:0; margin-bottom:0;' href='<%=request.getContextPath()%>/view/product?productId="+
				    	                    products[i].split("/")[0] +"'>"+
				                    		products[i].split("/")[1] +" - "+
				                    		products[i].split("/")[2] +"원"+
				                    		"</a>"+
				                    		"<br>");
			                    	}
			                    }
	                    } else {
	                    	$(".cd-divider").html("<font style='font-size:small;'>해당 상품을 찾을 수 없습니다.</font>");
	                    }
	                }
	       }); //end ajax 
	       
	       return false;
		}
	});

})
</script>
</head>
<body>
<div class="cd-dropdown-wrapper" style="margin-left: 0; margin-bottom: 30px; z-index: 999;">
			<a class="cd-dropdown-trigger" href="#" style="background-color: #0B614B; opacity: 0.7;">상세메뉴</a>
			<nav class="cd-dropdown">
				<h2>Title</h2>
				<a href="#" class="cd-close">Close</a>
				<ul class="cd-dropdown-content">
					<li>
						<form class="cd-search">
							<input type="search" id="searchBox" placeholder="검색어 입력 후 Enter...">
						</form>
					</li>
					<!-- 1차메뉴 생성 시작 -->
				<c:forEach var="root" items="${rootcate}">
					<li class="has-children">
						<a href="#">${root.categoryName}</a>

						<ul class="cd-secondary-dropdown is-hidden" style="border: 0.3px solid gray;">
							<li class="go-back"><a href="#0">Menu</a></li>
 							<!-- 여기서부터 2차 메뉴 -->
							<c:forEach var="sub" items="${root.subCategory}" varStatus="status">
								<li class="has-children">
									<a href="#" style="font-size: medium;">${sub.categoryName}</a>
	
									<ul class="is-hidden" style="height: 85%; overflow-y:auto;">
										<li class="go-back"><a href="#">${root.categoryName}</a></li>
										<!-- 여기서부터 3차 메뉴  -->
										<c:if test="${!sub.subCategory.isEmpty()}">
											<c:forEach var = "sub2" items="${sub.subCategory}">
												<li><a style="font-size: small;" href="<%=request.getContextPath()%>/shopping/menu?categoryID=${sub2.categoryId}">${sub2.categoryName}</a></li>
											</c:forEach>
										</c:if>
										<!-- 3차메뉴 종료 -->
									</ul>
								</li>
							</c:forEach>
							<!-- 2차메뉴 종료 부분 -->
							
						</ul> <!-- .cd-secondary-dropdown -->
					</li> <!-- .has-children -->
				</c:forEach>
				<!-- 1차메뉴 생성 종료 -->
				
 				<li class="cd-divider" style="font-size: medium;">
 				</li>
<!--
					<li><a href="http://codyhouse.co/?p=748">Page 1</a></li>
					<li><a href="http://codyhouse.co/?p=748">Page 2</a></li>
					<li><a href="http://codyhouse.co/?p=748">Page 3</a></li> -->
				</ul> <!-- .cd-dropdown-content -->
			</nav> <!-- .cd-dropdown -->
		</div> <!-- .cd-dropdown-wrapper -->
		
<script src="<%=request.getContextPath()%>/resources/menubar/js/jquery-2.1.1.js"></script>
<script src="<%=request.getContextPath()%>/resources/menubar/js/jquery.menu-aim.js"></script> <!-- menu aim -->
<script src="<%=request.getContextPath()%>/resources/menubar/js/main.js"></script> <!-- Resource jQuery -->
</body>
</html>