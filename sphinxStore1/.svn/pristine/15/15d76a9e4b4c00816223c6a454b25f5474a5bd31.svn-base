<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Menu</title>
<style type="text/css">
.tab-button-outer {
  display: none;
}

@media screen and (min-width: 640px) {
  .tab-button-outer {
    display: block;
  }
  .tab-select-outer {
    display: none;
  }
}
</style>
<script type="text/javascript">
$(document).ready(function() {
    var $tabButtonItem = $('#tab-button li'),
        $tabSelect = $('#tab-select'),
        $tabContents = $('.tab-contents'),
        activeClass = 'is-active';

  $tabButtonItem.first().addClass(activeClass);
  $tabContents.not(':first').hide();

  // button
  $tabButtonItem.find('a').on('click', function(e) {
    var target = $(this).attr('href');

    $tabButtonItem.removeClass(activeClass);
    $(this).parent().addClass(activeClass);
    $tabSelect.val(target);
    $tabContents.hide();
    $(target).show();
    e.preventDefault();
  });

  // select
  $tabSelect.on('change', function() {
    var target = $(this).val(),
        targetSelectNum = $(this).prop('selectedIndex');

    $tabButtonItem.removeClass(activeClass);
    $tabButtonItem.eq(targetSelectNum).addClass(activeClass);
    $tabContents.hide();
    $(target).show();
  });
});
</script>
<link rel= "stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/menu.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script type="text/javascript">
$(function() {
	$("#show").click(function() {
		$("#show").css('display', 'none');
		$("#none").fadeIn("fast");
		$("#menubar").slideDown();
	});
	
	$("#none").click(function() {
		$("#menubar").slideUp("fast");
		$("#none").css('display', 'none');
		$("#show").fadeIn("fast");
	});
	
	$("#tab-select").change(function() {
		var url = $(this).val();
		location.href = url;
	});
});
</script>
<!-- 1. Link to jQuery (1.8 or later), -->
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script> <!-- 33 KB -->

<!-- fotorama.css & fotorama.js. -->
<link  href="http://cdnjs.cloudflare.com/ajax/libs/fotorama/4.6.4/fotorama.css" rel="stylesheet"> <!-- 3 KB -->
<script src="http://cdnjs.cloudflare.com/ajax/libs/fotorama/4.6.4/fotorama.js"></script> <!-- 16 KB -->
<script type="text/javascript">
function view(id) {
	location.href = '<%=request.getContextPath()%>/view/product?productId=' + id;
}
</script>
</head>
<body>
<%@include file="/WEB-INF/views/header.jsp"%>
<!--=====================
          Content
======================-->
<section class="content gallery pad1">
  <div class="container">
	<%@include file="/WEB-INF/views/menubar.jsp"%>
	<div class="tab-select-outer" style="margin-top: 0; margin-bottom: 10px;">
    <select id="tab-select" style="width:100%; border: 2px solid black;">
      <option value="<%=request.getContextPath()%>/admin">admin</option>
      <option value="<%=request.getContextPath()%>/">home</option>
      <option value="<%=request.getContextPath()%>/menu">menu</option>
      <%-- <option value="<%=request.getContextPath()%>/menu">board</option> --%>
      <option value="<%=request.getContextPath()%>/cart">cart</option>
      <c:if test="${empty customer}">
      <option value="<%=request.getContextPath()%>/login">login</option>
      <option value="<%=request.getContextPath()%>/join">join</option>
      </c:if>
      <c:if test="${!empty customer}">
      <option value="<%=request.getContextPath()%>/mypage">mypage</option>
      <option value="<%=request.getContextPath()%>/logout">logout</option>
      </c:if>
    </select>
  </div>
    <div class="row">
    <!-- 메뉴를 선택했는데 등록된 상품이 없을경우. -->
    <c:if test="${empty products && !empty categoryID}">
    <c:forEach begin="0" end="2">
    	<div class="grid_4">
        <div class="gall_block">
          <div class="maxheight">
            <div class="fotorama" style="margin-top:15px; max-height: 350px;" align="center">
			  	<img src="<%=request.getContextPath()%>/resources/img/ready.png">
			</div>
            <div class="gall_bot">
            <div class="text1"><a href="#">상품 준비중</a></div>
           	죄송합니다. 해당 메뉴는 상품을 준비중입니다.
            <br><br>
            <%-- <c:forEach var="option" items="${product.optionList}">
            	${option.optionName}
            	<c:forEach var="opvalue" items="${option.optionValueMap.keySet()}">
            		${opvalue}, ${option.optionValueMap.get(opvalue)}
            	</c:forEach>
            </c:forEach> --%>
            <font style="float:right; font-size: medium; color: black;">0원</font><br>
            </div>
          </div>
        </div>
      </div>
      </c:forEach>
    </c:if>
    <!-- 메뉴화면을 처음온 경우.. 임시로 해둿지만 나중에는 관리자가 설정한 상품들이 보이게 할 예정 -->
    <c:if test="${empty categoryID}">
    <c:forEach begin="0" end="2">
    	<div class="grid_4">
        <div class="gall_block">
          <div class="maxheight">
            <div class="fotorama" style="margin-top:15px; max-height: 350px;" align="center">
			  	<img src="<%=request.getContextPath()%>/resources/img/select.png">
			</div>
            <div class="gall_bot">
            <div class="text1"><a href="#">메뉴를 선택해주세요.</a></div>
           	 원하시는 메뉴를 선택하면 상품이 표시됩니다.
            <br><br>
            <%-- <c:forEach var="option" items="${product.optionList}">
            	${option.optionName}
            	<c:forEach var="opvalue" items="${option.optionValueMap.keySet()}">
            		${opvalue}, ${option.optionValueMap.get(opvalue)}
            	</c:forEach>
            </c:forEach> --%>
            </div>
          </div>
        </div>
      </div>
    </c:forEach>
    </c:if>
    <c:forEach var="product" items="${products}">
      <div class="grid_4" style="margin-bottom: 20px;">
        <div class="gall_block">
          <div class="maxheight">
          <!-- 2. Add images to <div class="fotorama"></div>. -->
		<div class="fotorama">
			<c:forEach var="image" items="${product.fileName}">
			  <img src="<%=request.getContextPath()%>/resources/img/${image}">
			</c:forEach>
		</div>
            <div class="gall_bot">
            <div class="text1"><a style="cursor: pointer;" onclick="view('${product.productId}')" class="view">${product.productName}</a></div>
            ${product.comment}
            <br><br>
            <%-- <c:forEach var="option" items="${product.optionList}">
            	${option.optionName}
            	<c:forEach var="opvalue" items="${option.optionValueMap.keySet()}">
            		${opvalue}, ${option.optionValueMap.get(opvalue)}
            	</c:forEach>
            </c:forEach> --%>
            <font style="float:right; font-size: medium; color: black;">${product.price}원</font><br>
            <a style="cursor: pointer;" onclick="view('${product.productId}')" class="btn view">자세히</a></div>
          </div>
        </div>
      </div>
  </c:forEach>
    </div>
  </div>
</section>
<!--==============================
              footer
=================================-->
<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>