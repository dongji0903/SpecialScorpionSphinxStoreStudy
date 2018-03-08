<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function resizeWin(win) {
	var wid=win.document.body.offsetWidth+200;
	var hei=win.document.body.offsetHeight+100;
	win.resizeTo(wid,hei);
}
function putCategory() {
	var qCat=opener.document.getElementById('qCat');
	var cat = document.getElementById('selectCat');
	var catId = cat.value;
	for(var i = 0;i < qCat.childNodes.length; i++){
		if(catId == qCat.childNodes[i].value){
			alert('already added');
			return false;
		}
	}
	var catTitle = cat.options[cat.selectedIndex].text;
	var catTxt = document.createElement('input');
	catTxt.type = 'button';
	catTxt.value = catTitle;
	catTxt.name = 'myCategory';
	var hidCat = document.createElement('input');
	hidCat.type = 'hidden';
	hidCat.name = 'hiddenCategory';
	hidCat.value = catId
	catTxt.onclick = function(){this.parentElement.removeChild(hidCat);this.parentElement.removeChild(this);}
	qCat.appendChild(catTxt);
	qCat.appendChild(hidCat);
	self.close();
}
</script>
</head>
<body onload="resizeWin(this)">
<select id="selectCat" size="5" style="width: auto;" >

<!-- 	if(opener.document.getElementById('qCat').lastChild.id==null){
		catTxt.id='QC1';
	}else{
		var oldId=opener.document.getElementById('qCat').lastChild.id;
		
	catTxt.id='QC'+(parseInt(opener.document.getElementById('qCat').lastChild.id.substring(2))+1);
	} -->
<!-- 	opener.document.getElementById('qCat').innerHTML="<input type="button" "; -->
<c:if test="${applicationScope.categoryMap!=null }">
<c:forEach items="${applicationScope.categoryMap}" var="category"><option value="${category.key}">[${category.key}]${category.value.title }</option>
</c:forEach>
</c:if>
</select>
<input type="hidden" name="catChoice">
<div style="padding: 20px">
<a href="#" onclick="putCategory()" style="text-decoration: none;border: 1px solid #777777;border-radius: 4px;"><font color="blue">확인</font></a>
<a href="#" onclick="self.close()" style="text-decoration: none;border: 1px solid #777777;border-radius: 4px;"><font color="red">취소</font></a>
</div>
</body>
</html>