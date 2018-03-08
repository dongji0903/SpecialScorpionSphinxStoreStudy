<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>옵션생성</title>
<script type="text/javascript">
var count = 0;
var count2 = 0;
	//div안에서 input을 동적으로 생성 및 삭제
	function appendOption() {
	count++;
	var newOption = document.createElement('div');
	newOption.setAttribute('id','option_'+count); //div id
	var HTML = '옵션 명 : <input type = "text" name = "option_' + count + '" />' +
		'<input type = "button" value = "옵션 값 추가" onclick = "createOptionValue(' + count + ')" />' + 
		'<input type = "button" value = "삭제" onclick= "removeOption(' + count + ')" />'; 
	newOption.innerHTML = HTML; //div에 삽입
	
	var optionBox = document.getElementById('optionBox');
	optionBox.appendChild(newOption);
	}
	
	function removeOption(idCount) {
		var option = document.getElementById('option_' + idCount);
		if(option != null) {
			option.parentNode.removeChild(option);
		}
	}
	
	function createOptionValue(count) {
		count2++;
		var newOptionValue = document.createElement('div'); //div id
		newOptionValue.setAttribute('id','optionValue_' + count);
		var HTML = '옵션 값 : <input type = "text" name = "key_' + count + '_' + count2 + '" /> <br>' + 
		'추가 가격 : <input type = "text" name = "value_' + count  + '_' + count2 + '" />' + 
		'<input type = "button" value = "삭제" onclick= "removeOptionValue(' + count + ')" />';
		newOptionValue.innerHTML = HTML;
		
		var option = document.getElementById('option_' + count);
		option.appendChild(newOptionValue);
	}
	
	function removeOptionValue(idCount) {
		var optionValue = document.getElementById('optionValue_' + idCount);
		if(optionValue != null) {
			optionValue.parentNode.removeChild(optionValue);
		}
	}
</script>
</head>
<body>
<form action="<%=request.getContextPath() %>/admin/product/addOption" name="frm" method="post">
옵션 추가 상품 선택<input type="button" value="선택" onclick="window.open('findProduct','_blank_1','toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=450, height=200');"> <br>
상품 ID : <input type="text" name="productId" readonly="readonly"> <br>
상품 명 : <input type="text" name="productName" readonly="readonly"> <br>
<input type="button" value="옵션생성하기" onclick="appendOption()"/> <br>
<div id="optionBox"></div>
<input type="submit" value="추가">
</form>
</body>
</html>