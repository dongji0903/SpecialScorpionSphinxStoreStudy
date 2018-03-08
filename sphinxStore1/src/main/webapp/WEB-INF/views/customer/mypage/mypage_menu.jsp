<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">
	.menubar {
		align-content: center;
	}
	
	.menubar ul{
		list-style:none;
		margin:0;
		padding:0;
		
	}
	
	.menubarli{
		display:inline-block;
		padding:15px;
		margin:0;
		align-content: 
	}
	
	.menubar li a{
		display:block;
		margin:0px;
		padding:0px;
		text-decoration:none;
	}
	
	.menubar li a:hover, .menubar ul li:hover a{
		text-decoration:none;
	}

	.menubar li ul {
		background: white;
		display:none;  /* 평상시에는 서브메뉴가 안보이게 하기 */
		height:auto;
		padding-top:8px;
		padding-bottom:8px;
		margin:0px;
		border:0px;
		position:absolute;
		width:148px;
		z-index:200;
		color:brown;
		border: solid 1px brown;
	}
	
	.menubar li:hover ul {
		display:block;   /* 마우스 커서 올리면 서브메뉴 보이게 하기 */
	}
</style>
</head>
<body>
<div class="container">
	<div class="row">
		<div class="grid_12" style="padding-top: 30px;">
			<div class="menubar" align="center">
			<ul>
				<li class="menubarli">
	               	<img src="<%=request.getContextPath()%>/resources/images/icon/user/order1.png"
					onmouseover="this.src='<%=request.getContextPath()%>/resources/images/icon/user/order2.png'"
					onmouseout="this.src='<%=request.getContextPath()%>/resources/images/icon/user/order1.png'">
					<ul>
						<li><a href="<%=request.getContextPath()%>/mypage/lookup">주문/배송 조회</a>
						<li><a href="<%=request.getContextPath()%>/cart">장바구니</a>
						<li><a href="<%=request.getContextPath()%>#">위시리스트</a>
						<li><a href="<%=request.getContextPath()%>#">반품/교환 내역</a>
					</ul>
				<li class="menubarli">
	               	<img src="<%=request.getContextPath()%>/resources/images/icon/user/benefit1.png"
					onmouseover="this.src='<%=request.getContextPath()%>/resources/images/icon/user/benefit2.png'"
					onmouseout="this.src='<%=request.getContextPath()%>/resources/images/icon/user/benefit1.png'">
					<ul>
						<li><a href="<%=request.getContextPath()%>#">적립금</a>
						<li><a href="<%=request.getContextPath()%>#">쿠폰</a>
					</ul>
				<li class="menubarli">
	               	<img src="<%=request.getContextPath()%>/resources/images/icon/user/board.png"
					onmouseover="this.src='<%=request.getContextPath()%>/resources/images/icon/user/board2.png'"
					onmouseout="this.src='<%=request.getContextPath()%>/resources/images/icon/user/board.png'">
					<ul>
						<c:forEach var="category" items="${boardcateList}">
							<li><a href="<%=request.getContextPath()%>/mypage/myqna?categoryId=${category.categoryId}">${category.name}</a>
						</c:forEach>
					</ul>
				<li class="menubarli">
	               	<img src="<%=request.getContextPath()%>/resources/images/icon/user/myinfo1.png"
					onmouseover="this.src='<%=request.getContextPath()%>/resources/images/icon/user/myinfo2.png'"
					onmouseout="this.src='<%=request.getContextPath()%>/resources/images/icon/user/myinfo1.png'">
					<ul>
						<li><a href="<%=request.getContextPath()%>/mypage/confirmpassword">회원정보수정</a>
						<li><a href="<%=request.getContextPath()%>/mypage/address">주소 등록/수정</a>
						<li><a href="<%=request.getContextPath()%>/mypage/withdrow">탈퇴</a>
					</ul>
			</ul>
         	</div>
		</div>
	</div>
</div>
</body>
</html>