<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title><link rel="icon" href="<%=request.getContextPath()%>/resources/images/favicon.ico">
<body class="page1" id="top">
<%@include file="/WEB-INF/views/header.jsp"%>
<!--=====================
          Content
======================-->
<section class="content"><div class="ic">More Website Templates @ TemplateMonster.com - July 30, 2014!</div>
  <div class="container">
    <div class="row">
      <div class="grid_12" style="margin-top: 50px;">
        <div class="box">
          <div class="row">
            <div class="grid_5 preffix_1">
              <h2>Create Root Category</h2>
              <p>Root 카테고리를 생성 할 수 있습니다. Root 카테고리에는 게시글 혹은 상품 등록이 불가능합니다. 여러 분류를 하나로 묶기위해서는 Root 카테고리를 생성 해야합니다.
              <br>
              <a href="<%=request.getContextPath()%>/admin/category/addmain" class="btn">생성하기</a>
            </div>
            <div class="grid_5">
              <h2>Create Sub Category</h2>
              	서브 카테고리를 생성 할 수 있습니다. Root카테고리의 바로 밑에 하위를 1차라고 칭하며 아이템 생성 혹은 게시글 작성은 2차 카테고리에서 가능합니다. Root로 묶고나서도 분류되어있는 카테고리들을
              	 다시 한번 더 묶을 수 있습니다.<br>
              <a href="<%=request.getContextPath()%>/admin/category/addsub" class="btn">생성하기</a>
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