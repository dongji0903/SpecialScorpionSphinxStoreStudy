<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<style type="text/css">
#itemLine {
	width: 1000px;
	height: 310px;
	border-bottom: thin solid silver;
}

#oneItem {
	width: 210px;
	height: 245px;
	overflow: hidden;
	float: left;
	margin: 10px;
	text-align: left;
}

#item_Box {
	width: 230px;
	height: 290px;
	float: left;
	margin: 10px;
}

#pageNumber {
	height: 50px;
	clear: left;
	font-size: large;
	font-family: fantasy;
}

#price {
	color: blue;
	text-align: left;
	margin-left: 15px;
}

a {
	padding-top: 10px;
	text-decoration: none; /* 링크 밑줄 없애기 */
	color: black; /* 글 색상 */
}

#search_Box {
	background-color: yellowgreen;
	height: 40px;
	width: 500px;
	padding-top: 4px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>S h o p</title>


<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/dug_Korea.css">


</head>
<body>
	<div id="wrap" align="center">
		<div id="header">
			<jsp:include page="/form/header_Form.jsp" />
		</div>

		<div>
			<form action="<%=request.getContextPath()%>/shop/searchItem.do"
				method="get">
				<div id="search_Box">
					<input style="border-color: black; width: 400px; height: 27px;"
						type="text" name="search"> <input type="submit" value="검색">
				</div>
			</form>
			<c:if test="${searchItemList != null }">
				<div style="text-align: left; padding-top: 10px;">
					<font style="font-family: fantasy; font-size: large;">'${name }'</font>&nbsp;에대한
					검색 결과 : 총 ${searchItemSize }건
				</div>
			</c:if>
			<div style="text-align: right; margin: 10px; padding-bottom: 5px;">
				<a href="<%=request.getContextPath()%>/shop/viewCartList.do">장바구니</a>
			</div>
			<c:if test="${isAdmin == 1}">
			<div
				style="text-align: right; margin: 10px; padding-bottom: 5px; border-bottom: thin solid silver;">
				<a href="<%=request.getContextPath()%>/shop/itemMake.jsp">상품
					등록</a>
			</div>
			</c:if>

			<c:if test="${searchItemList == null }">
				<div id="itemTable">
					<%-- 검색어가 어뵤을때 16개씩 출력 --%>
					<div id="itemLine">
						<c:forEach var="item" items="${itemList}" varStatus="status">
							<c:if test="${status.index < 4}">
								<!-- 1 ~ 4 -->
								<div id="item_Box">
									<div id="oneItem">
										<a
											href="<%=request.getContextPath() %>/shop/viewItem.do?num=${item.num}">
											<img src="<%=request.getContextPath() %>/upload/${item.url}"
											width="200px" height="200px"> <br> ${item.name}
										</a>
									</div>
									<div id="price">￦ ${item.price}</div>
								</div>
							</c:if>
						</c:forEach>
					</div>
					<c:if test="${lastNum == 0 || (lastNum > 4 && lastNum < 17)}">
						<div id="itemLine">
							<c:forEach var="item" items="${itemList}" varStatus="status">
								<c:if test="${status.index > 3 && status.index < 8}">
									<!-- 5 ~ 8 -->
									<div id="item_Box">
										<div id="oneItem">
											<a
												href="<%=request.getContextPath() %>/shop/viewItem.do?num=${item.num}">
												<img src="<%=request.getContextPath() %>/upload/${item.url}"
												width="200px" height="200px"> <br> ${item.name}
											</a>
										</div>
										<div id="price">￦ ${item.price}</div>
									</div>
								</c:if>
							</c:forEach>
						</div>
					</c:if>
					<c:if test="${lastNum == 0 || (lastNum > 8 && lastNum < 17)}">
						<div id="itemLine">
							<c:forEach var="item" items="${itemList}" varStatus="status">
								<c:if test="${status.index > 7 && status.index < 12}">
									<!-- 9 ~ 12 -->
									<div id="item_Box">
										<div id="oneItem">
											<a
												href="<%=request.getContextPath() %>/shop/viewItem.do?num=${item.num}">
												<img src="<%=request.getContextPath() %>/upload/${item.url}"
												width="200px" height="200px"> <br> ${item.name}
											</a>
										</div>
										<div id="price">￦ ${item.price}</div>
									</div>
								</c:if>
							</c:forEach>
						</div>
					</c:if>
					<c:if test="${lastNum == 0 || lastNum > 14 && lastNum < 17}">
						<div id="itemLine">
							<c:forEach var="item" items="${itemList}" varStatus="status">
								<c:if test="${status.index > 11 && status.index < 16}">
									<!-- 13 ~ 16 -->
									<div id="item_Box">
										<div id="oneItem">
											<a
												href="<%=request.getContextPath() %>/shop/viewItem.do?num=${item.num}">
												<img src="<%=request.getContextPath() %>/upload/${item.url}"
												width="200px" height="200px"> <br> ${item.name}
											</a>
										</div>
										<div id="price">￦ ${item.price}</div>
									</div>
								</c:if>
							</c:forEach>
						</div>
					</c:if>
				</div>
			</c:if>

			<c:if test="${searchItemList != null }">
				<div id="itemTable">
					<%-- 검색어가 있을때 16개씩 출력 --%>
					<div id="itemLine">
						<c:forEach var="item" items="${searchItemList}" varStatus="status">
							<c:if test="${status.index < 4}">
								<!-- 1 ~ 4 -->
								<div id="item_Box">
									<div id="oneItem">
										<a
											href="<%=request.getContextPath() %>/shop/viewItem.do?num=${item.num}">
											<img src="<%=request.getContextPath() %>/upload/${item.url}"
											width="200px" height="200px"> <br> ${item.name}
										</a>
									</div>
									<div id="price">￦ ${item.price}</div>
								</div>
							</c:if>
						</c:forEach>
					</div>
					<c:if test="${lastNum == 0 || (lastNum > 4 && lastNum < 17)}">
						<div id="itemLine">
							<c:forEach var="item" items="${searchItemList}"
								varStatus="status">
								<c:if test="${status.index > 3 && status.index < 8}">
									<!-- 5 ~ 8 -->
									<div id="item_Box">
										<div id="oneItem">
											<a
												href="<%=request.getContextPath() %>/shop/viewItem.do?num=${item.num}">
												<img src="<%=request.getContextPath() %>/upload/${item.url}"
												width="200px" height="200px"> <br> ${item.name}
											</a>
										</div>
										<div id="price">￦ ${item.price}</div>
									</div>
								</c:if>
							</c:forEach>
						</div>
					</c:if>
					<c:if test="${lastNum == 0 || (lastNum > 8 && lastNum < 17)}">
						<div id="itemLine">
							<c:forEach var="item" items="${searchItemList}"
								varStatus="status">
								<c:if test="${status.index > 7 && status.index < 12}">
									<!-- 9 ~ 12 -->
									<div id="item_Box">
										<div id="oneItem">
											<a
												href="<%=request.getContextPath() %>/shop/viewItem.do?num=${item.num}">
												<img src="<%=request.getContextPath() %>/upload/${item.url}"
												width="200px" height="200px"> <br> ${item.name}
											</a>
										</div>
										<div id="price">￦ ${item.price}</div>
									</div>
								</c:if>
							</c:forEach>
						</div>
					</c:if>
					<c:if test="${lastNum == 0 || lastNum > 14 && lastNum < 17}">
						<div id="itemLine">
							<c:forEach var="item" items="${searchItemList}"
								varStatus="status">
								<c:if test="${status.index > 11 && status.index < 16}">
									<!-- 13 ~ 16 -->
									<div id="item_Box">
										<div id="oneItem">
											<a
												href="<%=request.getContextPath() %>/shop/viewItem.do?num=${item.num}">
												<img src="<%=request.getContextPath() %>/upload/${item.url}"
												width="200px" height="200px"> <br> ${item.name}
											</a>
										</div>
										<div id="price">￦ ${item.price}</div>
									</div>
								</c:if>
							</c:forEach>
						</div>
					</c:if>
				</div>
			</c:if>
		</div>



		<input type="hidden" name="pageNumber" value="${param.pageNumber}">
		<div id="pageNumber" align="center">
			<!-- 검색x  -->
			<c:if test="${searchItemList == null}">
				<c:if test="${prevBlock > 0}">
					<a
						href="<%=request.getContextPath() %>/shop/index.do?pageNumber=${prevBlock}">Prev</a>
				</c:if>
				<c:forEach var="blockNum" items="${blockList}" varStatus="status">
					<a
						href="<%=request.getContextPath() %>/shop/index.do?pageNumber=${blockNum}">${blockNum }</a>
				</c:forEach>
				<c:if test="${nextBlock < totalPageNum}">
					<a
						href="<%=request.getContextPath() %>/shop/index.do?pageNumber=${nextBlock}">Next</a>
				</c:if>
			</c:if>

			<!-- 검색o  -->
			<c:if test="${searchItemList != null}">
				<c:if test="${prevBlock > 0}">
					<a
						href="<%=request.getContextPath() %>/shop/searchItem.do?pageNumber=${prevBlock}">Prev</a>
				</c:if>
				<c:forEach var="blockNum" items="${blockList}" varStatus="status">
					<a
						href="<%=request.getContextPath() %>/shop/searchItem.do?pageNumber=${blockNum}">${blockNum}</a>
				</c:forEach>
				<c:if test="${nextBlock < totalPageNum}">
					<a
						href="<%=request.getContextPath() %>/shop/searchItem.do?pageNumber=${nextBlock}">Next</a>
				</c:if>
			</c:if>
		</div>
		<div id="footer">
			<div
				style="background-color: maroon; min-height: 4px; margin-bottom: 4px;">
				<jsp:include page="/form/footer_Form.jsp" />
			</div>
		</div>
	</div>
</body>
</html>