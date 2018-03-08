<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>시험 양식 만들기</title>
<script type="text/javascript">
function selectYeongyoeck(i) {
	var yyText=document.createElement('input');
	yyText.type='text';
	yyText.style.width="100px";
	yyText.id='yeongyoeckText';
	var t=i.parentElement.firstChild;
	if(i[i.selectedIndex].id=='menualYeongyoeck'){
		i.parentElement.insertBefore(yyText,t);
	}else{
		if(t.type=='text'){
			i.parentElement.removeChild(t);
		}
	}
}
function addYeongyoeck() {
	var tr= document.createElement('tr');
	var td1=document.createElement('td');
	var selects=document.getElementById('yeongyoeckSelect');
	if(selects[selects.selectedIndex].id!='menualYeongyoeck'){
		td1.textContent=selects[selects.selectedIndex].textContent;
	}else{
		td1.textContent=document.getElementById('yeongyoeckText').value;
	}
	var delBtn=document.createElement('input');
	delBtn.type='button';
	delBtn.value='x';
	delBtn.onclick=function(){formContext.removeChild(tr);};
	td1.appendChild(delBtn);
	tr.appendChild(td1);
	var td2=document.createElement('td');
	var tr2=document.createElement('tr');
	var yoohyongSelects=document.createElement('select');
	<% 
	List<String> sList=(List<String>)request.getAttribute("yoohyongList");
	for(int i=0;i<sList.size();i++){%>
		var opt=document.createElement('option');
		opt.innerHTML= '<%= sList.get(i)%>';
		opt.id='';
		yoohyongSelects.appendChild(opt);
	<%
	}
	%>
	var opt=document.createElement('option');
	opt.textContent='--직접 입력--';
	opt.id='menualYoohyong';
	yoohyongSelects.appendChild(opt);
	yoohyongSelects.onchange=function(){
		var yyText=document.createElement('input');
		yyText.type='text';
		yyText.style.width="100px";
		yyText.id='yoohyongText';
		var t=yoohyongSelects.parentElement;
		if(yoohyongSelects[yoohyongSelects.selectedIndex].id=='menualYoohyong'){
			yoohyongSelects.parentElement.insertBefore(yyText,yoohyongSelects);
		}else{
			if(yoohyongSelects.parentElement.firstChild.type=='text'){
				yoohyongSelects.parentElement.removeChild(yoohyongSelects.parentElement.firstChild);
			}
		}
	};
	tr2.appendChild(yoohyongSelects);
	var addBtn=document.createElement('input');
	addBtn.type='button';
	addBtn.value='추가';
	addBtn.onclick=function(){
		var tr3=document.createElement('tr');
		var td3=document.createElement('td');
		if(yoohyongSelects[yoohyongSelects.selectedIndex].id!='menualYoohyong'){
			td3.textContent=yoohyongSelects[yoohyongSelects.selectedIndex].textContent;
		}else{
			td3.textContent=document.getElementById('yoohyongText').value;
		}
		var delBtn=document.createElement('input');
		delBtn.type='button';
		delBtn.value='x';
		delBtn.onclick=function(){tr3.remove();};
		td3.appendChild(delBtn);
		tr3.appendChild(td3);
		
		td2.insertBefore(tr3,tr2);
	}
	tr2.appendChild(addBtn);
	td2.appendChild(tr2);
	tr.appendChild(td2);
	formContext.insertBefore(tr,addingNewYeongyoeckRow);
}
</script>
</head>
<body>
<table>
<thead>
<tr><th colspan="2">시험종류</th><td colspan="2"><input name="putJongryu" type="text"></td></tr>
<tr height="10px"></tr>
<tr><th width="100px">영역</th><th width="100px">유형</th><th>지문</th></tr>
</thead>
<tbody id="formContext">
<tr id="addingNewYeongyoeckRow"><td>
<select onchange="selectYeongyoeck(this)" id="yeongyoeckSelect">
<c:forEach items="${requestScope.yeongyoeckList }" var="yeongyoeck">
<option id="">${yeongyoeck }</option>
</c:forEach>
<option id="menualYeongyoeck">--직접 입력--</option>
</select><input type="button" value="추가" onclick="addYeongyoeck()"></td></tr>
</tbody>
</table>
</body>
</html>