<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Grocery Store a Ecommerce Online Shopping Category Flat Bootstrap Responsive Website Template | Households :: w3layouts</title>
</head>
<body>
<!-- header -->
	
<!-- script-for sticky-nav -->
	<script>
	$(document).ready(function() {
		 var navoffeset=$(".agileits_header").offset().top;
		 $(window).scroll(function(){
			var scrollpos=$(window).scrollTop(); 
			if(scrollpos >=navoffeset){
				$(".agileits_header").addClass("fixed");
			}else{
				$(".agileits_header").removeClass("fixed");
			}
		 });
		 
	});
	</script>
<!-- //script-for sticky-nav -->
	
<!-- //header -->
<!-- products-breadcrumb -->
	<div class="products-breadcrumb">
		<div class="container">
			<ul>
				<li><i class="fa fa-home" aria-hidden="true"></i><a href="index.html">Home</a><span>|</span></li>
				<li>Households</li>
			</ul>
		</div>
	</div>
<!-- //products-breadcrumb -->
<!-- banner -->
	<div class="banner">
		<div class="w3l_banner_nav_left">
			<nav class="navbar nav_bottom">
			 <!-- Brand and toggle get grouped for better mobile display -->
			  <div class="navbar-header nav_2">
				  <button type="button" class="navbar-toggle collapsed navbar-toggle1" data-toggle="collapse" data-target="#bs-megadropdown-tabs">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				  </button>
			   </div> 
			   <!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse" id="bs-megadropdown-tabs">
					<ul class="nav navbar-nav nav_1">
					<c:forEach var="category" items="${rootCategories }">
					<c:if test="${category.subCategory!=null }">
					<li class="dropdown mega-dropdown active">
					<a href="<%=request.getContextPath()%>/product/Catalog?categoryId=${category.categoryId}" class="dropdown-toggle" >${category.categoryName}<span class="caret"></span></a>				
							<div class="dropdown-menu mega-dropdown-menu w3ls_vegetables_menu">
								<div class="w3ls_vegetables">
									<ul>	
									<c:forEach var="subCategory" items="${category.subCategory }">
										<li><a href="<%=request.getContextPath()%>/product/Catalog?categoryId=${subCategory.categoryId}">${subCategory.categoryName }</a></li>
									</c:forEach>
									</ul>
								</div>                  
							</div>
							</li>
					</c:if>
					<c:if test="${category.subCategory==null }">
					<li><a href="<%=request.getContextPath()%>/product/Catalog?categoryId=${category.categoryId}">${category.categoryName }</a></li>
					</c:if>
					</c:forEach>
						</ul>
				 </div><!-- /.navbar-collapse -->
			</nav>
		</div>
		<div class="w3l_banner_nav_right">
			<div class="w3l_banner_nav_right_banner4">
				<h3>Best Deals For New Products<span class="blink_me"></span></h3>
			</div>
			<div class="w3ls_w3l_banner_nav_right_grid w3ls_w3l_banner_nav_right_grid_sub">
				<h3>${thisCategory.categoryName }</h3>
				<div class="w3ls_w3l_banner_nav_right_grid1">
				<c:if test="${thisCategory.subCategory!=null }">
				<div>
				<c:forEach items="${thisCategory.subCategory }" var="thisSubCategory">
					<a href="<%=request.getContextPath()%>/product/Catalog?categoryId=${thisSubCategory.categoryId}"><span style="padding: 0.2em;">${thisSubCategory.categoryName}</span></a>
				</c:forEach>
				<div style="background-color: red;height: 2px;margin-bottom: 10px;margin-top: 3px"></div>
				</div>
				</c:if>
				<c:if test="${productList!=null }">
				<c:forEach items="${productList }" var="product">
					<div class="col-md-3 w3ls_w3l_banner_left">
						<div class="hover14 column">
						<div class="agile_top_brand_left_grid w3l_agile_top_brand_left_grid">
							<div class="agile_top_brand_left_grid_pos">
								<img src="<%=request.getContextPath()%>/resources/images/offer.png" alt=" " class="img-responsive" />
							</div>
							<div class="agile_top_brand_left_grid1">
								<figure>
									<div class="snipcart-item block">
										<div class="snipcart-thumb">
											<a href="single.html"><img src="<%=request.getContextPath()%>/resources/images/17.png" alt=" " class="img-responsive" /></a>
											<p>${product.productName }</p>
											<h4>￦${product.price } <span>￦${product.price }</span></h4>
										</div>
										<div class="snipcart-details">
											<form action="상품상세페이지" method="post">
												<fieldset>
													<input type="hidden" name="href" value="제품상세"/>
													<input type="hidden" name="cmd" value="_cart" />
													<div style="display: inline;"><label style="float: left;">Quantity :</label><input style="float: right;width: 50px;margin-left: 5px" type="number" name="add" value="1" /></div>
													<input type="hidden" name="business" value=" " />
													<input type="hidden" name="item_name" value="${product.productName }" />
													<input type="hidden" name="amount" value="${product.price }" />
													<input type="hidden" name="discount_amount" value="0" />
													<input type="hidden" name="currency_code" value="USD" />
													<input type="hidden" name="return" value=" " />
													<input type="hidden" name="cancel_return" value=" " />
													<input type="submit" name="submit" value="Add to cart" class="button" />
												</fieldset>
											</form>
										</div>
									</div>
								</figure>
							</div>
						</div>
						</div>
					</div>
					</c:forEach>
				</c:if>
				<c:if test="${productList==null }"><div align="center"><h1>Sold out!</h1></div></c:if>
					<div class="clearfix"> </div>
				</div>
				
				<div class="w3ls_w3l_banner_nav_right_grid1">
					
					<div class="clearfix"> </div>
				</div>
			</div>
		</div>
		<div class="clearfix"></div>
	</div>
<!-- //banner -->
<!-- newsletter -->
	<!-- <div class="newsletter">
		<div class="container">
			<div class="w3agile_newsletter_left">
				<h3>sign up for our newsletter</h3>
			</div>
			<div class="w3agile_newsletter_right">
				<form action="#" method="post">
					<input type="email" name="Email" value="Email" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Email';}" required="">
					<input type="submit" value="subscribe now">
				</form>
			</div>
			<div class="clearfix"> </div>
		</div>
	</div> -->
<!-- //newsletter -->
<!-- footer -->
	
<!-- //footer -->
<!-- Bootstrap Core JavaScript -->

<!-- here stars scrolling icon -->

<!-- //here ends scrolling icon -->

</body>
</html>