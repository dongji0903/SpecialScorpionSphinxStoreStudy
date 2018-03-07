<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DUG</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/dug_Korea.css" />
<style type="text/css">
#animate {
	width: 200px;
	height: 200px;
	background-image:
		url("<%=request.getContextPath()%>/resources/images/AW401669_02.gif");
	background-size: 200px;
	position: relative;
	animation-duration: 5s;
	animation-name: move;
	animation-iteration-count: infinite;
	animation-timing-function: ease;
	color: blue;
}

@keyframes move {
0%{left: 0px;}
50%{left:800px;}
100%{left:0px; }
}

#animate:hover {
	background-image:
		url("<%=request.getContextPath()%>/resources/images/AW401669_15.gif");
	animation-play-state: paused;
}
</style>



</head>
<body>
	<div>
		<div align="left"
			style="background-image: url('<%=request.getContextPath()%>/resources/images/아납지.jpg');background-size:contain;height:200px">
			<div id="animate"></div>
		</div>
		<div id="gongJi">

			<div id="info">
				<br> <br> <br>
				<button
					style="height: 100px; font-size: medium; border-radius: 10px"
					onclick="window.open('http://www.topik.go.kr/usr/cmm/subLocation.do?menuSeq=211010201')">
					<font color="red">Null</font>러봐^ㅁ^
				</button>
			</div>

			<div id="notice">
				<h2>공지사항</h2>
				<div align="right">
					<a
						href="<%=request.getContextPath()%>/board/getList.do?category=공지사항">more>></a>
				</div>
				<table>
					<tr>
						<th style="min-height: 1px"></th>
					</tr>
					<c:forEach var="noti" items="${notice}">
						<tr>
							<td><a
								href="<%=request.getContextPath()%>/board/getDetail.do?num=${noti.num}&category=${noti.category}">${noti.title}</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>

			<div id="consert">
				<h2>공연일정</h2>
				<div align="right">
					<a
						href="<%=request.getContextPath()%>/board/getList.do?category=공연게시판">more>></a>
				</div>
				<table>
					<tr>
						<th style="min-height: 1px"></th>
					</tr>
					<c:forEach var="con" items="${consert}">
						<tr>
							<td><a
								href="<%=request.getContextPath()%>/board/getDetail.do?num=${con.num}&category=${con.category}">${con.title}</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>

		<div style="margin-left:auto; margin-right:auto; width: 900px; height: 30px;">--------------Top 5 Sales!!-----------</div>
		<div style="border-top:1px solid silver; height: 300px;">
			<c:if test="${topItemList != null}">
				<c:forEach var="topItem" items="${topItemList }" varStatus="itemCount">
					<div align="left" id="items_Box">
					<div style="font-weight:bold; position:absolute; width: 25px; height: 25px; background-color: yellowgreen; text-align: center">
					<font color="#734f4d">${itemCount.count}</font></div>
					<a href="<%=request.getContextPath() %>/shopping/viewItem.do?num=${topItem.num}"> 
					<img src="<%=request.getContextPath()%>/resources/images/${topItem.url}" width="180px" height="180px">
						<div>${topItem.name }</div>
					</a>
						<div style="color:blue; text-align: left;">￦ ${topItem.price }</div>
					</div>
				</c:forEach>
			</c:if>
		</div>
	</div>

</body>
</html>