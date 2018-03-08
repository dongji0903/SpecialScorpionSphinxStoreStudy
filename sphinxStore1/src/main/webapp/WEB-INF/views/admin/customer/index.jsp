<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/table.css">
</head>
<body class="page1" id="top">
<%@include file="/WEB-INF/views/header.jsp"%>
<!--=====================
          Content
======================-->
<section class="content"><div class="ic"></div>
  <div class="container">
    <div class="row">
  	  <div class="grid_12" style="margin-top: 50px;">
        <div class="box">
          <div class="row">
            <div class="grid_5 preffix_1">
              <h2>Administer</h2>
              	관리자 조회 및 임명제외를 할 수 있습니다.
              <br>
              <a href="<%=request.getContextPath()%>/admin/customer/admin" class="btn">관리자</a>
            </div>
            <div class="grid_5">
              <h2>Customer</h2>
              	회원 관리 및 관리자 임명을 할 수 있습니다.
              <br>
              <a href="<%=request.getContextPath()%>/admin/customer/customer" class="btn">회원 관리</a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
<!--==============================
              footer
=================================-->
<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>