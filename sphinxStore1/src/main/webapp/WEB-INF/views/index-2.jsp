<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- 1. Link to jQuery (1.8 or later), -->

<script type="text/javascript">
$(function() {
	$(".chkOption").change(function() {
		var aa = document.getElementsByClassName("chkOption");
		var chk = 0;
		for (var x = 0; x < aa.length; x++) {
			if (aa[x].value == 0) {
				chk ++;
			}
		}
		
		if (chk == 0) {
			var name = null;
			for (var x = 0; x < aa.length; x++) {
				if (name == null) {
					name = aa[x].value;
				} else {
					name = name + "/" + aa[x].value;
				}
			}
				var div = $("#optiondiv");
				var divchk = document.getElementById(name);
				
				if (divchk != null) {
					alert("이미 선택한 옵션입니다.");
				} else {
					
					var count = null;
					var hidden = document.getElementsByClassName("hi");
					
					if (hidden != null) {
						for (var x = 0; x < hidden.length; x++) {
							count = parseInt(hidden[x].getAttribute("id"));
						}
					} else {
						count = 0;
					}
					
					
					var text = ""+
								"<div style='margin-top: 20px;' id = '"+name+"'>"+
								"<input type='text' name='optionValue' style='border:none; margin-right:5px; text-align:center; height:30px; width:100px;'"+
								"readonly=true value='"+name+"'>"+
								"<div style='display: inline-block;'>"+
								"<label style='margin-left:10px; margin-top: 2px;'>수량</label>"+
								"<img id='m"+(count+1)+"' onclick='minus(this)' class='minus' src='<%=request.getContextPath()%>/resources/images/icon/minus.png'"+ 
								"style='cursor:pointer; padding-top:8px; width: 10px; margin-left: 5px;'>"+
								"<input name='quantity' onkeyup='chkText(this)' onblur='chkText(this)' id='q"+(count+1)+"' class='quantity' type='text' style=' text-align:center; height: 22px; width: 25px;' value='1'>"+ 
								"<img id='p"+(count+1)+"' onclick='plus(this)' class='plus' src='<%=request.getContextPath()%>/resources/images/icon/plus.png'"+ 
								"style='cursor:pointer; padding-top:8px; width: 10px;'>"+
								"<img onclick='removeDetail(this);'"+
								"style='cursor:pointer; padding-top:7px; margin-left:20px; width:10px;'"+
								"src='<%=request.getContextPath()%>/resources/images/icon/delete.png'>"+
								"<input type='hidden' class='hi' id='"+(count+1)+"' value='"+(count+1)+"'>"+
								"</div>"+
								"</div>";
								
					$("#optiondiv").append(text);
				}
				
				for (var x = 0; x < aa.length; x++) {
					optont = aa[x].options.length;
					for (var i=0; i< optont; i++) {
						if (aa[x].options[i].value == "0") {
							aa[x].options[i].selected = true;
							break;
						}
					}
				}
		}
		
	});

});
</script>
<script type="text/javascript">
function chkText(box) {
	var pattern = /[^(0-9)]/gi; // 숫자이외는 제거
	box.value = box.value.replace(pattern, "");
	
	if (box.value > 99) {
		box.value = 99;
	}
}
function minus(box) {
	var quantity = box.getAttribute("id");
	quantity = quantity.substring(1, quantity.length);
	
	
	var inputbox = document.getElementById("q"+quantity);
	var value = parseInt(inputbox.value) - 1;
	if (value < 1) {
		inputbox.value = 1;
	} else if (isNaN(value)) {
		inputbox.value = 1;		
	} else {
		inputbox.value = value;
	}
}

function removeDetail(btn) {
	var parent = $(btn).parent();
	var parents = $(parent).parent();
	parents.remove();
}

function plus(box) {
	var quantity = box.getAttribute("id");
	quantity = quantity.substring(1, quantity.length);
	
	
	var inputbox = document.getElementById("q"+quantity);
	var value = parseInt(inputbox.value) + 1;
	if (value > 99) {
		inputbox.value = 99;
	} else if (isNaN(value)) {
		inputbox.value = 1;		
	} else {
		inputbox.value = value;
	}
}

function moveCartController() {	
	var quantity = document.getElementsByClassName('quantity');
	
	for (var i = 0; i < quantity.length; i++) {
		if (quantity[i].value.length < 1) {
			alert('수량을 모두 입력해주세요.');
			return;
		}
	}
	
	if (quantity == null || quantity.length == 0) {
		alert('옵션을 선택해주세요.')
		return;
	}

	formSubmit();
}
</script>
<script type="text/javascript">
function formSubmit() {
    var params = $("#frm").serialize(); // serialize() : 입력된 모든Element(을)를 문자열의 데이터에 serialize 한다.
    $.ajax({
        url: '<%=request.getContextPath()%>/shopping/cart/addcart',
        type: 'POST',
        data: params,
        contentType: 'application/x-www-form-urlencoded; charset=UTF-8', 
        dataType: 'html',
        success: function (data) {
        	if (data > 0) {
	        	if (confirm('상품이 장바구니에 추가되었습니다.\n장바구니로 이동하시겠습니까?')) {
	        		location.href = '<%=request.getContextPath()%>/cart';
	        	} else {
	        		$("#cartCount").html("("+ data +")");
	        		
	        	}
        	}
        }
    });
}
</script>
<!-- 1. Link to jQuery (1.8 or later), -->
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script> <!-- 33 KB -->
<!-- fotorama.css & fotorama.js. -->
<link  href="http://cdnjs.cloudflare.com/ajax/libs/fotorama/4.6.4/fotorama.css" rel="stylesheet"> <!-- 3 KB -->
<script src="http://cdnjs.cloudflare.com/ajax/libs/fotorama/4.6.4/fotorama.js"></script> <!-- 16 KB -->
</head>
<body>
	<%@include file="/WEB-INF/views/header.jsp"%>
	<!--=====================
          Content
======================-->
<form id="frm" name="frm">
	<input type="hidden" value="${product.productId}" name="productId">
	<section class="content">
	<div class="container" align="center" style="width: 100%;">
		<div class="row" style="width: 99%;">
			<div class="grid_8" style="width: 98%; margin-top: 50px;">
			<div class="table discriptionSection">
				<div class="tr">
				<div class="td">
				<div align="center" style="margin-bottom: 15px; display: inline-block;">
					<div class="fotorama" style="max-width: 333px; max-height: auto;">
						<c:forEach var="image" items="${product.fileName}">
						  <img src="<%=request.getContextPath()%>/resources/img/${image}">
						</c:forEach>
					</div>
				</div>
				<div class="extra_wrapper" align="right" style="padding-right: 10px; display: inline-block; width: 300px;">
					<font size="5" color="#6E6E6E" style="line-height:200%; padding: 0;">${product.productName}</font>
					<div class="text1 tx__1">
						<a href="#">${product.price}원 </a>
					</div>
					<p style="margin-top: 20px;">${product.comment}</p>
					<div id="optiondiv"
						style="margin-bottom: 20px; min-width: 190px; max-width: 80%; padding-bottom: 10px;">
						<table>
							<c:forEach var="option" items="${product.optionList}" varStatus="status">
								<tr>
									<td style="padding-right: 7px; padding-bottom: 5px;">
										${option.optionName} 
									</td>
									<td style="padding-bottom: 5px;">
										<select class="chkOption" id="sel${status.index}"
											style="height: 30px; min-width: 40%; max-width: 180px; width: 150px;">
											<option value="0">옵션 선택</option>
											<c:forEach var="optionvalue"
												items="${option.optionValueMap.keySet()}">
												<c:if test="${option.optionValueMap.get(optionvalue) >= 1}">
													<option value="${optionvalue}">${optionvalue} + ${option.optionValueMap.get(optionvalue)}원</option>
												</c:if>
												<c:if test="${option.optionValueMap.get(optionvalue) < 1}">
													<option value="${optionvalue}">${optionvalue}</option>
												</c:if>
											</c:forEach>
										</select>
									</td>
								</tr>
							</c:forEach>
						</table>
						
					</div>
					<div align="center">
						<!-- 버튼 -->
						<a href="<%=request.getContextPath()%>"> <img
							src="<%=request.getContextPath()%>/resources/images/icon/buy.png"
							onmouseover="this.src='<%=request.getContextPath()%>/resources/images/icon/buy2.png'"
							onmouseout="this.src='<%=request.getContextPath()%>/resources/images/icon/buy.png'"
							width="50px;" height="50px;">
						</a> &nbsp;&nbsp; <a style="cursor: pointer;" onclick="moveCartController();" id="addcart"> <img
							src="<%=request.getContextPath()%>/resources/images/icon/cart.png"
							onmouseover="this.src='<%=request.getContextPath()%>/resources/images/icon/cart2.png'"
							onmouseout="this.src='<%=request.getContextPath()%>/resources/images/icon/cart.png'"
							width="50px;" height="50px;">
						</a> &nbsp;&nbsp; <a href="<%=request.getContextPath()%>"> <img
							src="<%=request.getContextPath()%>/resources/images/icon/wish.png"
							onmouseover="this.src='<%=request.getContextPath()%>/resources/images/icon/wish2.png'"
							onmouseout="this.src='<%=request.getContextPath()%>/resources/images/icon/wish.png'"
							width="50px;" height="50px;">
						</a>
					</div>
					
				</div>
				</div>
				</div>
			</div>
				<div class="clear" style="margin-top: 50px;"></div>
				<hr style="border: 0.5px solid gray; margin-bottom: 50px;">
				<pre>${product.content}</pre>
				<br>
			</div>
		</div>
	</div>
	</section>
	<!--==============================
              footer
=================================-->
</form>
	<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>