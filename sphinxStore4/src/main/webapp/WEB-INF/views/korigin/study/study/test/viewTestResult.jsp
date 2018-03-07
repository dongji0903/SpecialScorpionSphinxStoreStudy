<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	function setShowCount(i) {
		location.href =
<%=request.getContextPath()%>
	+ "/study/getTestResult.do?command=examList&examListPageNum=${examListPageNum}&showCount="
				+ i;
	}
</script>
</head>
<body>
	페이지당 표시건수: ${showCount }
	<div style="overflow: visible;">
	<div style="border: 1px solid red;width: 500px">
	나으 시험 정보<br>
	최저 : ${myRecord.get("min") }점<br>
	최고 : ${myRecord.get("max") }점<br>
	평균 : ${myRecord.get("avg") }점<br>
	</div>
		<table style="top: 10%; position: relative;" class="list">
			<tr>
				<th>번호</th>
				<th>시험명</th>
				<th>수험날짜</th>
				<th>점수</th>
			</tr>
			<c:forEach items="${asheets }" var="asheet" varStatus="stat">
				<tr>
					<td>${asheets.size()-stat.index }</td>
					<td><a
						href="<%=request.getContextPath() %>/study/getTestDetail.do?pageNo=${examListPageNum}&num=${asheets.size()-stat.index }">${asheet.title }</a></td>
					<td>${asheet.testDate }</td>
					<td>${asheet.totalScore }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div style="top: 10px;position: relative;height: 22px;padding: 10px 0px 0px 10px; overflow: visible;">
		<c:if test="${examListTotalPage!=null }">
			<c:set var="firstPage" scope="page"
				value="${examListPageNum%10!=0?((examListPageNum-(examListPageNum%10))+1):(examListPageNum-10+1) }"></c:set>
			<c:set var="lastPage" scope="page"
				value="${((firstPage+9)<examListTotalPage)?(firstPage+9):examListTotalPage }"></c:set>
			<c:if test="${firstPage>10 }">
				<a style="border: 1px solid #797979; background-color: #F9F9F9;"
					href="<%=request.getContextPath() %>/study/getTestResult.do?command=examList&examListPageNum=${firstPage-1 }">Prev</a>
			</c:if>
			<c:forEach var="i" begin="${firstPage }" end="${lastPage }">
				<c:if test="${i==examListPageNum }">
					<font style="font-weight: bold;"><a
						style="border: 1px solid #797979; background-color: #F9F9F9;"
						href="<%=request.getContextPath() %>//study/getTestResult.do?command=examList&examListPageNum=${i }">${i }</a></font>
				</c:if>
				<c:if test="${i!=examListPageNum }">
					<a style="border: 1px solid #797979;  background-color: #F9F9F9;padding: 3px 5px 2px 5px;"
						href="<%=request.getContextPath() %>/study/getTestResult.do?command=examList&examListPageNum=${i }">${i }</a>
				</c:if>
			</c:forEach>
		</c:if>
		<c:set var="pageNo" value="${examListPageNum}"></c:set>
		<c:if test="${lastPage<examListTotalPage }">
			<a
				href="<%=request.getContextPath() %>/study/getTestResult.do?command=examList&examListPageNum=${lastPage+1 }">Next</a>
		</c:if>
	</div>
</body>
</html>