<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>문제 저장</title>
<script type="text/javascript">
		var i=1;
	function selectType(s) {
		if (s == 's') {
			document.getElementById("dis").style.display = "none";
			document.getElementById("ans").style.display = "";
		} else if (s == 'o') {
			document.getElementById("dis").style.display = "";
			document.getElementById("ans").style.display = "none";
		}
	}
	function setJYY(s) {
		if(s=='T'){
			document.getElementById("JYY").style.display = "";
		}else if(s=='F'){
			document.getElementById("JYY").style.display = "none";
		}
	}
	function checkInfo() {
		
		if (document.frm1.hiddenCategory != null) {
			return true;
		} else {
			alert('입력을 하세요 님아');
			return false;
		}
	}
	function putDis() {
		var disList = document.getElementById('disList');
		var disItem = document.createElement('li');
		var disTxt = document.createElement('input');
		disTxt.type = 'text';
		disTxt.name = 'dis';
		disItem.appendChild(disTxt);
		var truDis=document.createElement('input');
		truDis.type='checkbox';
		truDis.name='ansDis';
		truDis.value=i++;
		disItem.appendChild(truDis);
		var delDis = document.createElement('input');
		delDis.type = 'button';
		delDis.value = '삭제';
		delDis.onclick = function() {
			disList.removeChild(disItem);
			for(var j=0;j<document.getElementsByName("ansDis").length;j++){
				document.getElementsByName("ansDis")[j].value=j;
				i=j+1;
			}
		};
		disItem.appendChild(delDis);
		disList.appendChild(disItem);
	}
	function continuously() {
		if(checkInfo()){
			document.frm1.action='<%=request.getContextPath()%>/study/registAndinputQuestion.do';
			document.frm1.submit();
		}
	}
</script>
</head>
<body>
	<div id="container" style="padding-left: 150px">
		<form action="<%=request.getContextPath() %>/study/registQuestion.do" method="post" name="frm1"
			enctype="multipart/form-data">
			<input type="hidden" name="command" value="reg_question">
			
			<div align="left" style="width: 700px"><div style="float: left;margin-bottom: 5px"><input type="button"
				onclick="location.href='<%=request.getContextPath()%>/study/index.do'" value="뒤로"></div><div style="float: right;width: 400px" align="left">문제 기입</div></div><br>
			<table border="1" style="width: 700px; height: 200px">
			<tr>
			<th colspan="2">문제</th>
			</tr>
				<tr>
					<th width="100px">문제종류</th>
					<td><input size="10" type="radio" name="Qtype" value="s"
						id="typeS" onclick="selectType('s')" checked="checked" /><label
						for="typeS">주관식</label> <input size="10" type="radio" name="Qtype"
						value="o" id="typeO" onclick="selectType('o')" /><label
						for="typeO">객관식</label></td>
				</tr>
				<tr>
					<th>문제텍스트</th>
					<td><textarea cols="60" name="Question" required="required"></textarea></td>
				</tr>
				<tr>
					<th>파일첨부</th>
					<td><input type="file" name="fileUrl" value="${fileUrl }"></td>
					<tr>
					<th>파일 유형</th>
					<td><input type="radio" name="fileType" value="음성" checked="checked">음성
					<input type="radio" name="fileType" value="동영상">동영상
					<input type="radio" name="fileType" value="사진">사진
					</td>
					</tr>
				<tr>
					<th>포인트 배점</th>
					<td><input required="required" type="text" name="Score"
						value="${score}" /></td>
				</tr>
				<tr>
					<th>출처</th>
					<td><input required="required" type="text" name="Source"
						value="${source }" /></td>
				</tr>
				<tr>
					<th>카테고리분류</th>
					<td id="qCat"><input type="button" name="viewCategory"
						value="카테고리 추가"
						onclick="window.open('<%=request.getContextPath()%>/study/question/selectCategory.jsp','_blank_1','toolbar=no,menubar=no,scrollbars=no,width=10,height=10')">
						추가된 카테고리를 다시 클릭하면 제외됩니다.<br>
					</td>
				</tr>
				<tr id="ans">
					<th>정 답</th>
					<td>
					<input type="text" name="ansTxt">
					</td>
				</tr>
				<tr id="dis" style="display:none">
					<th id="disSet">보기설정</th>
					<td id="disNum">
					정답인 보기는 체크해주세요.
						<ol id="disList">
							<li><input type="text" name="dis" /><input type="checkbox" name="ansDis" value='0'><input type="button"
								value="보기 추가" onclick="putDis()">
						</ol>
					</td>

				</tr>
				<tr>
				<th>시험 분류</th><td><input type="radio" checked="checked" onclick="setJYY('F')" name="btJYY">없음<input name="btJYY" type="radio" onclick="setJYY('T')">지정</td></tr>
				<tr id="JYY" style="display: none;">
				<th>시험 분류 상세</th>
				<td>종류:
				<select required="required" name="jongryu">
				<c:forEach items="${jongryuList }" var="jongryuOpt">
				<option value="${jongryuOpt }">${jongryuOpt}</option>
				</c:forEach>
				</select> 영역: <select name="yeongyoeck" required="required">
				<c:forEach items="${yeongyukList }" var="yeongyukOpt">
				<option value="${yeongyukOpt }">${yeongyukOpt}</option>
				</c:forEach>
				</select> 유형: <select name="yoohyong" required="required">
				<c:forEach items="${yuhyeongList }" var="yuhyeongOpt">
				<option value="${yuhyeongOpt }">${yuhyeongOpt}</option>
				</c:forEach>
				</select></td></tr>
				<tr>
				<th colspan="2">해설</th>
				</tr>
				<tr>
				<th>설명</th><td><textarea name="solText" required="required" rows="4" cols="60"></textarea></td>
				</tr>
				<tr>
				<th>첨부사진</th><td><input name="solFile" type="file"></td>
				</tr>
				
			</table><br>
			<input type="submit" onclick="return checkInfo()" value="입력완료">
			<input style="margin-left: 10px" type="submit" onclick="continuously()" value="계속해서 입력">
			<input type="hidden" required="required" name="selectCategory"
				value="${currentCategory.cid }" />
			<%-- <c:set var="selectCategory" value="${currentCategory }" scope="request"></c:set> --%>
		</form>

	</div>
</body>
</html>