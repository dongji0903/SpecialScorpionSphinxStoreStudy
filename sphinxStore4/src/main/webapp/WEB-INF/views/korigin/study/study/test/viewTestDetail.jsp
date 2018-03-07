<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
	<div style="width: 400px;border: 1px solid red;">
	해당 회차의<br>
	최저점 : ${sheetRecord.minScore }점<br>
	최고점 : ${sheetRecord.maxScore }점<br>
	평균 : ${sheetRecord.avgScore }점<br>
	</div>
		<div align="center"
			style="min-height: 400px; width: 400px; text-align: left; border: 1px solid #797979; background-color: #F9F9F9;">
			<c:if test="${asheet!=null }">
점수: ${asheet.totalScore }점.  시험날짜: ${asheet.testDate }<br>
				<br>
				<c:forEach items="${asheet.OMRCard }" var="answer" varStatus="stat">
					<div id="" style="margin-bottom: 10px;">
						<div class="ox" >
							<c:if test="${answer.isCorrect==true }">
								<font color="blue">○</font>
							</c:if>
							<c:if test="${answer.isCorrect==false }">
								<font color="red">Ⅹ</font>
							</c:if>
							${answer.questionNum }.${qList[stat.index].text }</div>
						<div style="margin-left: 30px">
							<c:if test="${qList[stat.index].distractorList!=null }">
								<c:forEach var="dis"
									items="${qList[stat.index].distractorList }" varStatus="stat2">
					${stat2.count }.${dis.text }<br>
								</c:forEach>
							</c:if>
						</div>
						<div style="margin-left: 20px;margin-top: 10px;margin-right: 20px">
						<div style="border: solid 1px yellow;width: contain;">${soList[stat.index].text }</div>
							<c:if test="${soList[stat.index].fileUrl!=null }">
								<img alt=""
									src="<%=request.getContextPath() %>/upload/${soList[stat.index].fileUrl}"
									width="400px" height="auto">
								<br>
							</c:if>
						</div>
					</div>
				</c:forEach>
			</c:if>
		</div>
		<div>
			<a id="menu_link"
				style="border: 1px solid #797979; background-color: #F9F9F9;"
				href="<%=request.getContextPath() %>/study/getTestResult.do?examListPageNum=${pageNo}">목록
				보기</a>
		</div>
	</div>
</body>
</html>