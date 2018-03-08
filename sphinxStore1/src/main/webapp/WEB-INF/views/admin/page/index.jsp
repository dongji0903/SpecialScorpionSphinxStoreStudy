<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body class="page1" id="top">
<%@include file="/WEB-INF/views/header.jsp"%>
<!--=====================
          Content
======================-->
<section class="content"><div class="ic"></div>
  <div class="container">
  	<%@include file="/WEB-INF/views/admin/adminmenu.jsp"%>
    <div class="row">
      <div class="grid_4">
        <div class="banner">
		  <div class="gall_block">
          <div class="bann_capt ">
            <div class="maxheight">
              <img style="width: 80px; padding-top: 30px;" src="<%=request.getContextPath()%>/resources/images/icon1.png" alt="">
              <div class="bann_title" style="font-size: 40px;">메인<br>페이지</div>
              <a href="<%=request.getContextPath()%>#">바로가기</a>
            </div>
          </div>
        </div>
	   </div>
      </div>
      <div class="grid_4">
        <div class="banner">
		  <div class="gall_block">
          <div class="bann_capt  bn__1">
            <div class="maxheight">
              <img style="width: 80px; padding-top: 30px;" src="<%=request.getContextPath()%>/resources/images/icon2.png" alt="">
              <div class="bann_title" style="font-size: 40px;">상품<br>페이지</div>
              <a href="#">바로가기</a>
            </div>
          </div>
        </div>
		</div>
      </div>
      <div class="grid_4">
        <div class="banner ">
		  <div class="gall_block">
          <div class="bann_capt  bn__2">
            <div class="maxheight">
              <img style="width: 80px; padding-top: 30px;" src="<%=request.getContextPath()%>/resources/images/icon3.png" alt="">
              <div class="bann_title" style="font-size: 40px;">MY 페이지</div>
              <a href="#">바로가기</a>
            </div>
          </div>
		  </div>
        </div>
      </div>
      <div class="grid_4">
        <div class="banner">
		  <div class="gall_block">
          <div class="bann_capt ">
            <div class="maxheight">
              <img style="width: 80px; padding-top: 30px;" src="<%=request.getContextPath()%>/resources/images/icon1.png" alt="">
              <div class="bann_title" style="font-size: 40px;">꾸힝</div>
              <a href="<%=request.getContextPath()%>#">바로가기</a>
            </div>
          </div>
        </div>
	   </div>
      </div>
      <div class="grid_4">
        <div class="banner">
		  <div class="gall_block">
          <div class="bann_capt  bn__1">
            <div class="maxheight">
              <img style="width: 80px; padding-top: 30px;" src="<%=request.getContextPath()%>/resources/images/icon2.png" alt="">
              <div class="bann_title" style="font-size: 40px;">오힝</div>
              <a href="#">바로가기</a>
            </div>
          </div>
        </div>
		</div>
      </div>
      <div class="grid_4">
        <div class="banner ">
		  <div class="gall_block">
          <div class="bann_capt  bn__2">
            <div class="maxheight">
              <img style="width: 80px; padding-top: 30px;" src="<%=request.getContextPath()%>/resources/images/icon3.png" alt="">
              <div class="bann_title" style="font-size: 40px;">뾰힝</div>
              <a href="#">바로가기</a>
            </div>
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