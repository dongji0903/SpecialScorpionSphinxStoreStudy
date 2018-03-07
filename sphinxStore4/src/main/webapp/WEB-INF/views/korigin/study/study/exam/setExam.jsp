<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>시험출제</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/dug_Korea.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
    $('#tbl1').each(function() {
        var table = this;
        $.each([1,2,3], function(c, v) {
            var tds = $('>tbody>tr>td:nth-child(' + v + ')', table).toArray();
            var i = 0, j = 0;
            for(j = 1; j < tds.length; j ++) {
                if(tds[i].innerHTML != tds[j].innerHTML) {
                    $(tds[i]).attr('rowspan', j - i);
                    i = j;
                    continue;
                }
                $(tds[j]).hide();
            }
            j --;
            if(tds[i].innerHTML == tds[j].innerHTML) {
                $(tds[i]).attr('rowspan', j - i + 1);
            }
        });
    });
});

function selectJongryu(s) {
	var sel=s.options[s.selectedIndex].value;
	location.href='<%=request.getContextPath()%>/study/initExamForm.do?jongryu='+ sel;
}
function regist() {
	if(frm.examTitle.value==""){
		alert('시험명을 입력하세요.')
		frm.examTitle.focus();
		return;
	}
	var qids=document.getElementsByName('questionId');
	for(var i=0;i<qids.length;i++){
		if(qids[i].value.length==0){
			alert((i+1)+'번 문제가 비었습니다.');
			var s='#Q'+(i+1);
			window.location.hash=s;
			return;
		}
	}
	frm.submit();
}
</script>
</head>
<body>
	<form action="<%=request.getContextPath() %>/study/registExam.do" name="frm">
		<div align="left">
			시험 종류 : <select onchange="selectJongryu(this)" name="jongryu">
				<option selected="selected" disabled="disabled">선택하세요</option>
				<option>TOPIK 1</option>
				<option>TOPIK 2</option>
			</select>
			<c:if test="${jongryu!=null }">
			<input type="hidden" name="examformId" value="${requestScope.examform.eid }">
				<script type="text/javascript">
					var sel = document.getElementsByName('jongryu')[0];
					for (var i = 0; i < sel.length; i++) {
						if (sel[i].text == '${jongryu}') {
							sel[i].selected = true;
						}
					}
				</script>
			</c:if>
		</div>
				<c:if test="${requestScope.examform!=null }">
		<table id="tbl1">
			<thead>
		<tr><th colspan="2">시험명</th><td colspan="3"><input required="required" type="text" name="examTitle"></td>
		</tr>
				<tr height="10px"></tr>
				<tr>
				<th colspan="2">출제자</th><td colspan="3">${userName }<input type="hidden" name="examiner" value="${userName }"></td></tr>
				<tr height="10px"></tr>
				<tr>			
				<th colspan="2">제한시간</th><td colspan="3"><input type="number" min=0 name="limitTime" > ※0은 시간제한없음을 뜻합니다.</td></tr>
				<tr height="10px"></tr>
				<c:if test="${requestScope.examform.coverUrl!=null }">
				<tr>
				<td colspan="5" align="center">
				<img alt="" src="<%=request.getContextPath()%>/upload/${requestScope.examform.coverUrl }" width="700px" height="800px">
				</td>
				</tr>
				</c:if>
				<tr>
				<th colspan="2">난이도</th>
				<td colspan="3"> <select name="examDifficulty">
					<option>level 1</option>
					<option>level 2</option>
					<option>level 3</option>
					<option>level 4</option>
					<option>level 5</option>
					</select><tr>
					<th width="100px">영역</th>
					<th width="100px">유형</th>
					<th width="30px">번호</th>
					<th colspan="2">내용</th>
				</tr>
			</thead>
			<tbody>
					<c:set var="questionNum" value="1"></c:set>
					<c:forEach items="${requestScope.examform.gList }" var="groupQuestion" varStatus="groupNum">
				<input type="hidden" name="groupQId" value="${groupQuestion.gid }">
						<tr>
							<td align="center">${groupQuestion.yeongyoeck }</td>
							<td align="center">${groupQuestion.yoohyong }</td>
							<td colspan="3">[${questionNum}~${questionNum+groupQuestion.numOfQuestions-1}] ${groupQuestion.text }</td>
							</tr>
							<c:forEach var="Question" begin="1" end="${groupQuestion.numOfQuestions }">
								<tr>
									<td>${groupQuestion.yeongyoeck }</td>
									<td >${groupQuestion.yoohyong }</td>
									<td align="right">${questionNum }.</td>
									<td ><div id="Q${questionNum }"></div><input required="required" type="hidden" name="questionId"></td>
									<td width="100px"><input value="문제 선택" type="button"
									onclick="window.open('<%=request.getContextPath()%>/study/getYoohyongQuestion.do?Jongryu=${jongryu }&Yeongyoeck=${groupQuestion.yeongyoeck }&Yoohyong=${groupQuestion.yoohyong }&Qnum=${questionNum }','_blank_1','toolbar=no,menubar=no,scrollbars=no,width=10,height=10')"></td>
										</tr>
									<c:set var="questionNum" value="${questionNum+1 }"></c:set>
							</c:forEach>
					</c:forEach>
			</tbody>
		</table>
		<input type="button" value="등록 완료" onclick="regist()">
				</c:if>
	</form>
</body>
</html>