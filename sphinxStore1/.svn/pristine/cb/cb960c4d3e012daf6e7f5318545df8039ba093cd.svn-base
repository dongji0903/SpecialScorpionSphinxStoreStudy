<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function view(id) {
	location.href = '<%=request.getContextPath()%>/admin/product/edit?productId=' + id + '&categoryId=${category.categoryId}';
}
</script>
</head>
<body class="page1" id="top">
<%@include file="/WEB-INF/views/header.jsp"%>
<section class="content gallery pad1">
<%@include file="/WEB-INF/views/admin/product/edit/category_menubar.jsp"%>
  <div class="container">
	<div class="row">
	    <!-- 메뉴를 선택했는데 등록된 상품이 없을경우. -->
	    <c:if test="${empty productList}">
			<c:forEach begin="0" end="2">
		      <div class="grid_4">
		        <div class="gall_block">
		          <div class="maxheight">
		            <div class="fotorama" style="margin-top:15px; max-height: 350px;" align="center">
					  	<img src="<%=request.getContextPath()%>/resources/img/ready.png">
					</div>
		            <div class="gall_bot">
		            <div class="text1"><a href="#">상품 준비중</a></div>
		           	해당 메뉴는 상품을 준비중입니다.
		            <br><br>
		            <font style="float:right; font-size: medium; color: black;">0원</font><br>
		            </div>
		          </div>
		        </div>
		      </div>
			</c:forEach>
	    </c:if>
	    <!-- 상품이 있는경우 -->
		<c:forEach var="product" items="${productList}">
			<div class="grid_4" style="margin-bottom: 20px;">
		        <div class="gall_block">
		          <div class="maxheight">
					<div class="fotorama">
						<c:forEach var="image" items="${product.fileName}">
						  <img src="<%=request.getContextPath()%>/resources/img/${image}">
						</c:forEach>
					</div>
		            <div class="gall_bot">
			            <div class="text1">
			            	<a style="cursor: pointer;" onclick="view('${product.productId}')" class="view">
			            		${product.productName}
			            	</a>
			            </div>
		         	    ${product.comment}
		            	<br><br>
			            <font style="float:right; font-size: medium; color: black;">
			            	${product.price}원
			            </font>
			            <br>
			            <a style="cursor: pointer;" onclick="view('${product.productId}')" class="btn view">
			            	수정
			            </a>
		            </div>
		          </div>
		        </div>
			</div>
		</c:forEach>
	</div>
	
	<!-- -------------------------------------------------------------
	------------------------------페이징------------------------------
	--------------------------------------------------------------- -->
	<div id="pageSection" align="center" style="margin-top: 50px; margin-bottom: 30px;">
		<a href="<%=request.getContextPath()%>/admin/product/edit/choiceproduct?page=1&categoryId=${category.categoryId}">
			<< 
		</a>
		&nbsp;&nbsp;
		<font size="3">
		<c:forEach var="p" items="${pageList}">
			<a href="<%=request.getContextPath()%>/admin/product/edit/choiceproduct?page=${p}&categoryId=${category.categoryId}">
			<c:if test="${page == p}">
				<font color="#aaccaa" style="font-weight: bold;">
				&nbsp;${p}&nbsp;
				</font>
			</c:if>
			<c:if test="${page != p}">
				&nbsp;${p}&nbsp;
			</c:if>
			</a>
		</c:forEach>
		</font>
		&nbsp;&nbsp;
		<a href="<%=request.getContextPath()%>/admin/product/edit/choiceproduct?page=${maxPage}&categoryId=${category.categoryId}">
			 >>
		</a>
	</div>
	<!-- -------------------------------------------------------------
	------------------------------페이징 끝----------------------------
	--------------------------------------------------------------- -->
	</div>
</section>
<%@include file="/WEB-INF/views/footer.jsp"%> 
</body>
</html>