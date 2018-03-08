<%@page import="java.util.Map"%>
<%@page import="com.sphinx.beautea.category.domain.Category"%>
<%@page import="java.util.List"%>
<%@page import="com.sphinx.beautea.category.service.impl.CategoryServiceImpl"%>
<%@page import="com.sphinx.beautea.category.service.CategoryService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/stuck.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/touchTouch.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/checkbox.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/table.css">
<script src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery-migrate-1.1.1.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/script.js"></script> 
<script src="<%=request.getContextPath()%>/resources/js/superfish.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery.equalheights.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery.mobilemenu.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery.easing.1.3.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/tmStickUp.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery.ui.totop.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/touchTouch.jquery.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css">
<script>
 $(document).ready(function(){

  $().UItoTop({ easingType: 'easeOutQuart' });
  $('#stuck_container').tmStickUp({});
  $('.gallery .gall_item').touchTouch();

  }); 
</script>
<!--[if lt IE 9]>
 <div style=' clear: both; text-align:center; position: relative;'>
   <a href="http://windows.microsoft.com/en-US/internet-explorer/products/ie/home?ocid=ie6_countdown_bannercode">
     <img src="http://storage.ie6countdown.com/assets/100/<%=request.getContextPath()%>/resources/images/banners/warning_bar_0000_us.jpg" border="0" height="42" width="820" alt="You are using an outdated browser. For a faster, safer browsing experience, upgrade for free today." />
   </a>
</div>
<script src="js/html5shiv.js"></script>
<link rel="stylesheet" media="screen" href="<%=request.getContextPath()%>/resources/css/ie.css">


<![endif]-->
<script type="text/javascript">
$(function() {
	$("body").css('display', 'none');
	$("body").fadeIn(300);
	$("body").css('min-height', '680px');
	
});
</script>
</head>
<body>
<!--==============================
              header
=================================-->
<header>
<!--==============================
            Stuck menu
=================================-->
  <section id="stuck_container">
    <div class="container">
      <div class="row">
        <div class="grid_12">
        <h1>
          <a href="<%=request.getContextPath()%>/">
            <img src="<%=request.getContextPath()%>/resources/images/logo.png" style="width: 240px;" alt="Logo alt">
          </a>
        </h1>  
          <div class="navigation">
            <nav>
              <ul class="sf-menu">
               <li><a href="<%=request.getContextPath()%>/admin">
               <img src="<%=request.getContextPath()%>/resources/images/icon/admin.png">
               admin
               </a></li>
               <li class="current"><a href="<%=request.getContextPath()%>/" style="font-size: 20px;">home</a></li>
               <li><a href="<%=request.getContextPath()%>/menu">menu</a></li>
               <%-- <li><a href="<%=request.getContextPath()%>/menu">board</a></li> --%>
               <li><a href="<%=request.getContextPath()%>/cart" style="display: inline;">cart</a>
               <font color="#aaccaa" id="cartCount">
               <c:if test="${!empty cart}">
               (${cart.countCartItem()})
               </c:if>
               </font>
               </li>
               <c:if test="${empty customer}">
               <li><a href="<%=request.getContextPath()%>/login">login</a></li>
               <li><a href="<%=request.getContextPath()%>/join">join</a></li>
               </c:if>
               <c:if test="${!empty customer}">
               <li><a href="<%=request.getContextPath()%>/mypage">mypage</a></li>
               <li><a href="<%=request.getContextPath()%>/logout">logout</a></li>
               </c:if>
             </ul>
            </nav>        
            <div class="clear"></div>
          </div>
        </div>
      </div>
    </div>
  </section> 
</header>      
</body>
</html>