<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
#testPage{
font-size: x-large;
}

input[type=checkbox] {  
    display: none;  
}

input[type=checkbox] + label{
    display: inline-block;  
    cursor: pointer;  
    position: relative;  
    padding-left: 25px;  
    margin-right: 15px;
    font-size: 13px;
}

input[type=checkbox]+ label:before {     

    content: "";  
    display: inline-block;  
  
    width: 20px;  
    height: 20px;  
  
    margin-right: 10px;  
    position: absolute;  
    left: 0;  
    bottom: 5px;  
    background-color: #ccc;  
    border-radius: 2px; 
    box-shadow: inset 0px 1px 1px 0px rgba(0, 0, 0, .3), 0px 1px 0px 0px rgba(255, 255, 255, .8);  
}

input[type=checkbox]:checked + label:before { 

    content: "\2713";  /* 체크모양 */
    text-shadow: 1px 1px 1px rgba(0, 0, 0, .2);  
    font-size: 18px; 
    font-weight:800; 
    color: #fff;  
    background:#2f87c1;
    text-align: center;  
    line-height: 18px;  

} 

</style>
<script type="text/javascript">
	var time = ${sheet.limitTime};
	var timer = setInterval(function() {
			time = time - 1;
			document.getElementById("timeLeft").value = time;		
			if(time == 0){
				clearInterval(timer);
				alert('제한시간을 초과하여 시험을 종료합니다.');
				document.frm.submit();
			}
	},1000);
	
	var playNumber = 1;
	
	function listenPlay(o,s) {
	var myAudio = document.getElementById("s"+s);
		if(myAudio.paused && playNumber == s){
			alert('한 번만 재생되니 잘 들으세요.');
			myAudio.play();
			o.style.display="none";
			myAudio.addEventListener('ended', function(){
				playNumber++;
			});	
		}else{
			alert('이전문제를 완료하고 푸세요.');
		}
	}
	
	function show(o,v){	
		var myVideo = document.getElementById("v"+v);
				if (myVideo.paused && playNumber == v) { 
					alert('한 번만 재생되니 집중하세요.');
					myVideo.play();
					o.style.display="none";
					myVideo.addEventListener('ended', function(){
						playNumber++;
					});
				}else {
					alert('이전문제를 완료하고 푸세요.');
					//myVideo.pause();
				}
	}

</script>
</head>
<body oncontextmenu="return false" ondragstart="return false" onselectstart="return false">
	<c:if test="${sheet.limitTime != null && sheet.limitTime > 0}">
	<div style="position: fixed; top: 0px; left: 0px">
		<font size="6" >남은 시간:</font>
		<input style="font-size:xx-large;width: 100px;border: infotext;" id="timeLeft" type="text"
			readonly="readonly">
	</div>
	</c:if>
	<div id="testPage" style="margin-left: 30%">
		<h1>시험.</h1>
		<form name="frm" action="<%=request.getContextPath()%>/study/submitTest.do" method="post">
			<c:if test="${sheet!=null && sheet.questionList.size()!=0}">
				<c:forEach items="${sheet.questionList}" var="question"
					varStatus="stat">
						[출처: ${question.source }]<br>
						${stat.count}.${question.text}.<${question.score }점 > <input
						type="hidden" name="qNum" value="${stat.count }">
					<input type="hidden" name="qType" value="${question.qtype }">
					<c:if test="${question.fileUrl != null && question.fileType == '음성'}"><br>
							<audio id="s${stat.count }" src="<%=request.getContextPath() %>/upload/${question.fileUrl}" type="audio/mp3" hidden="hidden"></audio>
						<div style="background-image: url('<%=request.getContextPath() %>/upload/vovo.jpg'); background-size:150px;width:150px;height:59px; cursor:pointer;" onclick="listenPlay(this,'${stat.count}')"></div>
				</c:if>
							<c:if test="${question.fileUrl != null && question.fileType == '동영상'}"><br>
							<video id="v${stat.count }" poster="<%=request.getContextPath() %>/upload/vovo.jpg" width="400" height="350" preload="auto">
						<source src ="<%=request.getContextPath() %>/upload/${question.fileUrl}" type="video/mp4">
						</video>
						<div style="background-image: url('<%=request.getContextPath() %>/upload/vovo.jpg'); background-size:150px; width:150px; height:59px; cursor:pointer;" onclick="show(this,'${stat.count}')"></div>
						</c:if>
							<c:if test="${question.fileUrl != null && question.fileType == '사진'}"><br>
							<img src="<%=request.getContextPath() %>/upload/${question.fileUrl}" width="400" height="350">
						
				</c:if>
					<c:if test="${question.qtype =='o' }">(택${question.numOfAnswer } )<br>
						<c:forEach var="distractor" varStatus="dnum"
							items="${question.distractorList }">
							<input id="bigCheck_${stat.count}${dnum.count}" type="checkbox" name="selects_${stat.count}"
								value="${dnum.count }">
								<label for="bigCheck_${stat.count}${dnum.count}" style="font-size: x-large;">${dnum.count }. ${distractor.text }</label>
								<br>
						</c:forEach>
					</c:if>
					<c:if test="${question.qtype=='s' }">
						<br>
				정답 입력 <input border="1" type="text" name="typed_${stat.count }"
							autocomplete="off">
					</c:if>
					<br>
					<br>
				</c:forEach>
				<input type="submit" name="next" value="제출">
			</c:if>
		</form>
	</div>
</body>
</html>