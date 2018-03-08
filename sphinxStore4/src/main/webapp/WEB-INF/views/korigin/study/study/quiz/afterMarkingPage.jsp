<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/dug_Korea.css">
	<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/animation.css">
<title>시험보기</title>
<script type="text/javascript">
function listenPlay(o,s) {
	document.getElementById("s"+s).play();
}
function toNext() {
	frm1.next.disabled='disabled';
	setTimeout(function() {
		frm1.submit();
	}, 2000);
	if(${isRight}){
		document.getElementById('background_attack').id='background_clear';
		document.getElementById('gorilla_attack').id='gorilla_clear';
		document.getElementById('tree_attack').id='tree_clear';
	}else{
		document.getElementById('background_hitted').id='background_clear';
		document.getElementById('gorilla_hitted').id='gorilla_clear';
		document.getElementById('tree_hitted').id='tree_clear';
	}
}
</script>
</head>
<body>
	<!-- <h1 style="color: black;">&nbsp;&nbsp;&nbsp;Quiz</h1> -->
	<div>
		<div style="float: left;">
		<div id="background_frame">
		<c:if test="${isRight == true }">
			<div id="background_attack"></div>
			<div id="gorilla_attack"></div>
			<div id="tree_attack"></div>
		</c:if>
		<c:if test="${isRight == false }">
			<div id="background_hitted"></div>
			<div id="gorilla_hitted"></div>
			<div id="tree_hitted"></div>
		</c:if>
	</div>
			<c:if test="${trueCount==null || trueCount==0 }">
				<img src="<%=request.getContextPath()%>/upload/QuizStarter.gif"
					width="150" height="150">
			</c:if>
			<c:if test="${trueCount!=null && trueCount==1 }">
				<img src="<%=request.getContextPath()%>/upload/QuizHigh.gif"
					width="150" height="150">
			</c:if>
			<c:if test="${trueCount!=null && trueCount>=2 }">
				<img src="<%=request.getContextPath() %>/upload/QuizMaster.gif"
					width="${trueCount*20+150 }" height="${trueCount*20+150 }">
			</c:if>

		</div>
		<div align="center"
			style="position: relative; text-align: left; width: 500px">
			<form
				action="<%=request.getContextPath()%>/study/continuePlaying.do"
				method="post" name="frm1">
				${questionNum} / ${totalNumOfQuestion}<br> [출처:
				${question.source }]<br>
				${questionNum}.${question.text}.<${question.score }점 > <input
					type="hidden" name="quid" value="${question.qid }"> <input
					type="hidden" name="qType" value="${question.qtype }">
				<c:if test="${question.fileUrl!=null }">
					<br>
					<audio id="s${stat.count }" src="upload/${question.fileUrl}"
						type="audio/mp3" hidden="hidden"></audio>
					<div
						style="background-image: url('<%=request.getContextPath() %>/upload/vovo.jpg'); background-size:150px;width:150px;height:59px"
						onclick="listenPlay(this,'${stat.count}')"></div>
				</c:if>
				<c:if test="${question.qtype =='o' }">(택${question.numOfAnswer } )<br>
					<c:forEach var="distractor" varStatus="dnum"
						items="${question.distractorList }">
						<input type="checkbox" name="selects" value="${dnum.count }">${dnum.count }.${distractor.text }<br>
					</c:forEach>
				</c:if>
				<c:if test="${question.qtype=='s' }">
					<br>
						정답 입력 <input border="1" type="text" name="typed"
						disabled="disabled" value="${myAnswer }">
				</c:if>
				<input type="hidden" name="pageInfo" value="${kindOfPage}">
				<br>
				<script type="text/javascript">
						for(var i=0;i<document.frm1.selects.length;i++){
							document.frm1.selects[i].disabled=true;
						}
						</script>
				<c:forEach var="oneOfMyAnswer" items="${myAnswer }">
					<script type="text/javascript">
								document.frm1.selects[${oneOfMyAnswer}-1].checked=true;
								</script>
				</c:forEach>
				<c:if test="${isRight==true }">
					<font size="20pt" color="blue"> Right Answer!</font>
					<c:set var="gcount" value="0" scope="request"></c:set>
				</c:if>
				<c:if test="${isRight==false }">
					<font size="20pt" color="red"> Wrong Answer..</font>
				</c:if>
				<br> <font color="green">Correct Answer:</font> <br>
				<div id="foc" style="border: 3px solid; background-color: #FFFFFF">
					<c:if test="${question.qtype=='s' }">${correctAnswer }</c:if>
					<c:if test="${question.qtype=='o' }">
						<c:forEach items="${correctAnswer }" var="oneOfCorrectAnswer">${oneOfCorrectAnswer }&nbsp
						</c:forEach>
					</c:if>
					<br>${explanation }</div>
				<br> <br> <input type="button" name="next" value="다음" onclick="toNext()" >
				<input type="hidden" name="point" value="${point}"> <input
					type="hidden" name="exp" value="${exp}"> <input
					type="hidden" name="hp" value="${hp}">
			</form>
		</div>
	</div>


</body>
</html>