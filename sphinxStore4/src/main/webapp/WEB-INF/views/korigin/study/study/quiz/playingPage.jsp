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
	function listenPlay(o, s) {
		alert('한 번만 재생되니 잘 들으세요.');
		document.getElementById("s" + s).play();
		o.style.display = "none";
	}

	function resizeBar() {
		var hp = ${hp};
		var width = hp;
		document.getElementById("timeBar").style.width = width + '%';
		if (hp <= 0) {
			alert('GameOver!');
			document.frm1.action = '<%=request.getContextPath()%>/study/finishQuiz.do';
			document.frm1.submit();
		}
	}
	
	function setHp() {
		document.frm1.hp.value = width;
	}
	
	 	var hp = ${hp}
	 	var width = hp;
	 	var timer = setInterval(function() {
	 		var elem = document.getElementById("timeBar");  
		 	width -= 1; 
	 		elem.style.width = width + '%'; 
	 		elem.innerHTML = width;
			if (width <= 0){
	 			clearInterval(timer);
				alert('GameOver!');
				document.frm1.action = '<%=request.getContextPath()%>/study/finishQuiz.do';
				document.frm1.submit();
	 		}
	 	}, 1000);

</script>
</head>
<body onload="resizeBar()">
	<!-- <h1 style="color: black;">&nbsp;&nbsp;&nbsp;Quiz</h1> -->
	<div>
		<div style="float: left;">
	<div id="background_frame">
		<div id="background_start"></div>
		<div id="gorilla_start"></div>
		<div id="tree_start"></div>
	</div>
			<div id="timeProgress" style="text-align: center;">
				<div id="lebal"></div>
				<div id="timeBar"></div>
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
					width="150" height="150">
			</c:if>
		</div>
		<div align="center"
			style="position: relative; text-align: left; width: 500px">
			<form action="<%=request.getContextPath()%>/study/getQuizSolution.do"
				method="post" name="frm1">
				${questionNum} / ${totalNumOfQuestion}<br> [출처:
				${question.source }]<br>
				${questionNum}.${question.text}.<${question.score }점 > <input
					type="hidden" name="quid" value="${question.qid }"> <input
					type="hidden" name="qType" value="${question.qtype }">
				<c:if
					test="${question.fileUrl != null && question.fileType == '음성'}">
					<br>
					<audio id="s${stat.count }"
						src="<%=request.getContextPath() %>/upload/${question.fileUrl}"
						type="audio/mp3" hidden="hidden"></audio>
					<div
						style="background-image: url('<%=request.getContextPath() %>/upload/vovo.jpg'); background-size:150px;width:150px;height:59px"
						onclick="listenPlay('${stat.count}')"></div>
				</c:if>
				<c:if
					test="${question.fileUrl != null && question.fileType == '동영상'}">
					<br>
					<video id="v${stat.count }" controls
						poster="<%=request.getContextPath() %>/upload/vovo.jpg"
						width="400" height="350" preload="auto"> <source
						src="<%=request.getContextPath() %>/upload/${question.fileUrl}"
						type="video/mp4"></video>

				</c:if>
				<c:if
					test="${question.fileUrl != null && question.fileType == '사진'}">
					<br>
					<img
						src="<%=request.getContextPath() %>/upload/${question.fileUrl}"
						width="auto" height="auto">
				</c:if>
				<c:if test="${question.qtype =='o' }">(택${question.numOfAnswer } )<br>
					<c:forEach var="distractor" varStatus="dnum"
						items="${question.distractorList }">
						<input type="checkbox" name="selects" value="${dnum.count }">${dnum.count }.${distractor.text }<br>
					</c:forEach>
				</c:if>
				<c:if test="${question.qtype=='s'}">
					<br>
						정답 입력 <input border="1" type="text" name="typed"
						autocomplete="off">
					<br>
				</c:if>
				<input type="hidden" name="pageInfo" value="${kindOfPage}"><br>
				<br> <br> <input type="submit" name="next" value="다음" onclick="setHp()">
				<input type="hidden" name="point" value="${point}"> <input
					type="hidden" name="exp" value="${exp }"> <input
					type="hidden" name="hp">
			</form>
		</div>
	</div>
</body>
</html>