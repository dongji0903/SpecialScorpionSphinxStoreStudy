<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Exam Time!</title>
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
	var time=${sheet.limitTime};
	var timer=setInterval(function(){
			time = time - 1;
			document.getElementById("timeLeft").value = time;		
			if(time==0){
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
	<c:if test="${sheet.limitTime!=null && sheet.limitTime>0}">
	<div style="position: fixed; top: 0px; left: 0px">
		<font size="6" >남은 시간:</font><input style="font-size:xx-large;width: 100px;border: infotext;" id="timeLeft" type="text"
			readonly="readonly">
	</div>
	</c:if>
	
	<div id="testPage" style="margin-left: 20%;width: 700px" >
		<h1>${sheet.title}</h1>
		<div>
		<div>
		<c:if test="${sheet.examForm.coverUrl!=null }">
		<img alt="" src="<%=request.getContextPath()%>/upload/${sheet.examForm.coverUrl}" width="700px" height="auto">
		</c:if>
		</div>
		<form name="frm" action="<%=request.getContextPath()%>/study/submitExam.do" method="post">
			<c:if test="${sheet!=null && sheet.questionList.size()!=0}">
					<c:set var="gcount" value="0" scope="page"></c:set>
					<c:set var="qcount" value="0" scope="page"></c:set>
					
				<c:forEach items="${sheet.questionList}" var="question" varStatus="stat">	
					<div style="margin: 20px;">
					<c:if test="${qcount == 0}"> <!-- 문제수 초기화된 직후 form출력 -->
					[ ${stat.count} - ${stat.count+ sheet.examForm.gList[gcount].numOfQuestions-1} ] ${sheet.examForm.gList[gcount].text}
							<c:if test="${sheet.examForm.gList[gcount].fileUrl != null }"><br>
							<img src="<%=request.getContextPath() %>/upload/${sheet.examForm.gList[gcount].fileUrl}" width="500" height="auto">
						
				</c:if>
					</c:if>
					</div>
						<div style="margin: 20px;">
						<div style="font-size: large; margin-left: 5px;">
						[출처: ${question.source }]<br>
						</div>
						${stat.count}.${question.text} <input
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
						<%-- s<div style="background-image: url('<%=request.getContextPath() %>/upload/vovo.jpg'); background-size:150px; width:150px; height:59px; cursor:pointer;" onclick="show(this,'${stat.count}')"></div> --%>
						</c:if>
							<c:if test="${question.fileUrl != null && question.fileType == '사진'}"><br>
							<img src="<%=request.getContextPath() %>/upload/${question.fileUrl}" width="500" height="auto">
						
				</c:if>
					<c:if test="${question.qtype =='o' }"><br>
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
				정답 입력 <input border="1" type="text" name="typed_${stat.count }" autocomplete="off">
					</c:if>

					</div>
					<!-- 문제수 증가 -->
					<c:set var="qcount" value="${qcount+1}" scope="page"></c:set>
					<c:if test="${sheet.examForm.gList[gcount].numOfQuestions == qcount}">
					<!-- 문제가 가지고 있는 수만큼 나오면 qcount 초기화 -->
					<c:set var="gcount" value="${gcount+1}" scope="page"></c:set>
					<c:set var="qcount" value="0" scope="page"></c:set>		
					</c:if>
					
				</c:forEach>
				<input type="submit" name="next" value="제출">
			</c:if>
		
		</form>
		</div>
	</div>
</body>
</html>