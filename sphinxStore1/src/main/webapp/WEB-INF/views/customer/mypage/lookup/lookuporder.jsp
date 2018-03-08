<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery.min.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<style type="text/css">
.datebutton {
	background-color: white;
	outline: 0;
	border: #BDBDBD 1px solid;
	color: #8C8C8C;
	cursor: pointer;
	padding-bottom: 3px;
	margin-bottom: 3px;
}

.datepicker {
	border: #BDBDBD 1px solid;
	color: #8C8C8C;
	height: 16px;
}
</style>
<script>
$(function() {
		var windowWidth = $( window ).width();
		if (windowWidth < 750) {
			$("#orderview").css("display", "none");
			$("#mobileview").css("display", "");
			var button = document.getElementsByClassName('datebutton');
			for (var i = 0; i < button.length; i++) {
				button[i].style.display = 'none';
			}
			$(".tab-select-outer").css('display', '');
		} else {
			$("#orderview").css("display", "");
			$("#mobileview").css("display", "none");
			var button = document.getElementsByClassName('datebutton');
			for (var i = 0; i < button.length; i++) {
				button[i].style.display = '';
			}
			$(".tab-select-outer").css('display', 'none');
		}
		
	$( window ).resize(function() {
		var windowWidth = $( window ).width();
		if (windowWidth < 750) {
			$("#orderview").css("display", "none");
			$("#mobileview").css("display", "");
			var button = document.getElementsByClassName('datebutton');
			for (var i = 0; i < button.length; i++) {
				button[i].style.display = 'none';
			}
			$(".tab-select-outer").css('display', '');
		} else {
			$("#orderview").css("display", "");
			$("#mobileview").css("display", "none");
			$("#orderview").rowspan(0);
			var button = document.getElementsByClassName('datebutton');
			for (var i = 0; i < button.length; i++) {
				button[i].style.display = '';
			}
			$(".tab-select-outer").css('display', 'none');
		}
	});
	
	/* 
	 * 
	 * 같은 값이 있는 열을 병합함
	 * 
	 * 사용법 : $('#테이블 ID').rowspan(0);
	 * 
	 */     
	$.fn.rowspan = function(colIdx, isStats) {       
		return this.each(function(){      
			var that;     
			$('tr', this).each(function(row) {      
				$('td:eq('+colIdx+')', this).filter(':visible').each(function(col) {
					
					if ($(this).html() == $(that).html()
						&& (!isStats 
								|| isStats && $(this).prev().html() == $(that).prev().html()
								)
						) {            
						rowspan = $(that).attr("rowspan") || 1;
						rowspan = Number(rowspan)+1;

						$(that).attr("rowspan",rowspan);
						
						// do your action for the colspan cell here            
						$(this).hide();
						
						//$(this).remove(); 
						// do your action for the old cell here
						
					} else {            
						that = this;         
					}          
					
					// set the that if not already set
					that = (that == null) ? this : that;      
				});     
			});    
		});  
	}; 
	
	/* 
	 * 
	 * 같은 값이 있는 행을 병합함
	 * 
	 * 사용법 : $('#테이블 ID').colspan (0);
	 * 
	 */   
	$.fn.colspan = function(rowIdx) {
		return this.each(function(){
			
			var that;
			$('tr', this).filter(":eq("+rowIdx+")").each(function(row) {
				$(this).find('th').filter(':visible').each(function(col) {
					if ($(this).html() == $(that).html()) {
						colspan = $(that).attr("colSpan") || 1;
						colspan = Number(colspan)+1;
						
						$(that).attr("colSpan",colspan);
						$(this).hide(); // .remove();
					} else {
						that = this;
					}
					
					// set the that if not already set
					that = (that == null) ? this : that;
					
				});
			});
		});
	}
	$('#orderview').rowspan(0);
	
	$("#date1").change(function() {
		var date = '${date}';
		var nowDate = new Date(date);
		
		var value = new Date($(this).val());
		var date2 = $('#date2').val();
		
		if (value > nowDate) {
			alert('잘못된 날짜선택입니다.');
			$(this).val('');
			return false;
		} else if (date2.length > 1) {
			var value2 = new Date(date2);
			if (value > value2) {
				alert('잘못된 날짜선택입니다.');
				$(this).val('');
				return false;
			}
		}
	});
	
	$("#date2").change(function() {
		var date1 = $('#date1').val();
		
		var date = '${date}';
		var nowDate = new Date(date);
		
		var value = new Date($(this).val());
		
		if (value > nowDate) {
			alert('잘못된 날짜선택입니다.');
			$(this).val('');
			return false;
		} else if (date1.length < 1) {
			alert('시작일을 먼저 선택해주세요.');
			$(this).val('');
			return false;
		} else {
			var value2 = new Date(date1);
			if (value < value2) {
				alert('잘못된 날짜선택입니다.');
				$(this).val('');
				return false;
			}
		}
		
		
	});
	
	$("#tab-select").change(function() {
		var url = $("#tab-select").val();
		location.href = url;
	});
	
	$(".datebutton").click(function() {
		var value = $(this).val();
		var date = '${date}';
		var nowDate = new Date(date);
		
		var day = date.substring(date.length - 2, date.length);
		var yymm = date.substring(0, date.length - 2);
		
		var nowYear = '' + nowDate.getFullYear();
		var nowMonth = '' + (nowDate.getMonth() + 1);
		var nowDay = '' + nowDate.getDate();
		
		if (nowMonth < 10) {
			nowMonth = '0' + nowMonth;
		} if (nowDay < 10) {
			nowDay = '0' + nowDay;
		}
		
		var now_date = nowYear + "-" + nowMonth + "-" + nowDay;
		
		
			var longtime = nowDate - (86400000 * $(this).val());
			var dd = new Date(longtime);
			
			var Year = '' + dd.getFullYear();
			var Month = '' + (dd.getMonth() + 1);
			var Day = '' + dd.getDate();
			
			if (Month < 10) {
				Month = '0' + Month;
			} if (Day < 10) {
				Day = '0' + Day;
			}
			
			var nDate = Year + "-" + Month + "-" + Day;
			
			$('#date1').val(nDate);
			$('#date2').val(now_date);
	});
	
	$('#searchDate').click(function() {
		$('#DateForm').submit();
	}); $('.names').mouseenter(function() {
		$(this).css('color', 'blue');
	});$('.names').mouseleave(function() {
		$(this).css('color', 'black');
	});
	
	$('.dateilview').mouseenter(function() {
		$(this).attr('src', '<%=request.getContextPath()%>/resources/images/icon/detailview2.png');
	}); $('.dateilview').mouseleave(function() {
		$(this).attr('src', '<%=request.getContextPath()%>/resources/images/icon/detailview.png');
	});
});
</script>
<style type="text/css">
input[type=number]::-webkit-inner-spin-button {
	opacity: 1;
}
</style>

</head>
<body class="page1" id="top" style="color: #424242;">
	<%@include file="/WEB-INF/views/header.jsp"%>
	<section class="content">
	<div class="container" align="center">
		<div class="tab-select-outer" style="margin-top: 20px; ">
		    <select id="tab-select" style="width:100%; border: 2px solid black;">
		      <option value="<%=request.getContextPath()%>/admin">admin</option>
		      <option value="<%=request.getContextPath()%>/">home</option>
		      <option value="<%=request.getContextPath()%>/menu">menu</option>
		      <%-- <option value="<%=request.getContextPath()%>/menu">board</option> --%>
		      <option value="<%=request.getContextPath()%>/cart">cart</option>
		      <c:if test="${empty customer}">
		      <option value="<%=request.getContextPath()%>/login">login</option>
		      <option value="<%=request.getContextPath()%>/join">join</option>
		      </c:if>
		      <c:if test="${!empty customer}">
		      <option value="<%=request.getContextPath()%>/mypage">mypage</option>
		      <option value="<%=request.getContextPath()%>/logout">logout</option>
		      </c:if>
		    </select>
		  </div>
		<div align="center" style="margin-top: 60px; margin-bottom: 60px; font-size: x-large;">
			주문조회
		</div>
		<c:if test="${empty orders}">
			<div align="left" style="width: 99%; float:left; height:25px;">
				<div id="selection">
				<form id="DateForm" method="post" action="<%=request.getContextPath()%>/mypage/lookup/dateSearch">
				<%@include file="/WEB-INF/views/customer/mypage/lookup/calendar.jsp"%>
					<button class="datebutton" value="0" type="button">오늘</button><button value="7" class="datebutton" type="button">7일</button><button value="30" class="datebutton" type="button">1개월</button><button value="90" class="datebutton" type="button">3개월</button><button class="datebutton" type="button" value="180" style="margin-right: 10px;">6개월</button>
					<input readonly="readonly" name="startDate" type="text" class="datepicker" style="text-align:center; font-size: small; width: 75px;" id="date1"> <label for="date1"><img style="cursor:pointer; margin-top: 5px;" alt="" src="<%=request.getContextPath()%>/resources/images/icon/ico_cal.gif"></label> ~ 
					<input readonly="readonly" name="endDate" type="text" class="datepicker" style="text-align:center; font-size: small; width: 75px;" id="date2"> <label for="date2"><img style="cursor:pointer; margin-top: 5px;" alt="" src="<%=request.getContextPath()%>/resources/images/icon/ico_cal.gif"></label>
					<img id="searchDate" width="30px" style="cursor:pointer; margin-top: 3px;" alt="" src="<%=request.getContextPath()%>/resources/images/icon/btn_search.gif">
				</form>
				</div>
			</div>
			<table style="text-align: center; width: 100%;" id="orderview">
				<tr>
					<td style="width: 15%; border: 0.3px gray solid ; padding-bottom: 5px; margin-bottom: 5px;">
						날짜/번호
					</td>
					<td style="width: 15%; border: 0.3px gray solid ;">
						이미지
					</td>
					<td style="width: 30%; border: 0.3px gray solid ;">
						상품명/옵션
					</td>
					<td style="width: 10%; border: 0.3px gray solid ;">
						수량
					</td>
					<td style="width: 15%; border: 0.3px gray solid ;">
						상품 금액
					</td>
					<td style="width: 15%; border: 0.3px gray solid ;">
						처리 상태
					</td>
				</tr>
				<tr>
					<td colspan="6" align="center" style="padding: 50px; width: 15%; vertical-align: middle; border-bottom: 0.5px gray Dotted ;">
						주문내역이 없습니다.
					</td>
				</tr>
			</table>
			
			<table width="100%" id="mobileview" style="font-size: small;">
					<tr>
						<td align="center" style="padding: 20px; vertical-align: middle; border-bottom: 0.5px gray Dotted; border-top: 0.3px gray solid ; margin-top: 10px;">
							주문내역이 없습니다.
						</td>
					</tr>
			</table>
		</c:if>
		<c:if test="${!empty orders}">
			<div align="left" style="width: 99%; float:left; height:25px;">
				<div id="selection">
				<form id="DateForm" method="post" action="<%=request.getContextPath()%>/mypage/lookup/dateSearch">
				<%@include file="/WEB-INF/views/customer/mypage/lookup/calendar.jsp"%>
					<button class="datebutton" value="0" type="button">오늘</button><button value="7" class="datebutton" type="button">7일</button><button value="30" class="datebutton" type="button">1개월</button><button value="90" class="datebutton" type="button">3개월</button><button class="datebutton" type="button" value="180" style="margin-right: 10px;">6개월</button>
					<input readonly="readonly" name="startDate" type="text" class="datepicker" style="text-align:center; font-size: small; width: 75px;" id="date1"> <label for="date1"><img style="cursor:pointer; margin-top: 5px;" alt="" src="<%=request.getContextPath()%>/resources/images/icon/ico_cal.gif"></label> ~ 
					<input readonly="readonly" name="endDate" type="text" class="datepicker" style="text-align:center; font-size: small; width: 75px;" id="date2"> <label for="date2"><img style="cursor:pointer; margin-top: 5px;" alt="" src="<%=request.getContextPath()%>/resources/images/icon/ico_cal.gif"></label>
					<img id="searchDate" width="30px" style="cursor:pointer; margin-top: 3px;" alt="" src="<%=request.getContextPath()%>/resources/images/icon/btn_search.gif">
				</form>
				</div>
			</div>
			<table style="text-align: center; width: 100%;" id="orderview">
				<tr>
					<td style="width: 15%; border: 0.3px gray solid ; padding-bottom: 5px; margin-bottom: 5px;">
						날짜/번호
					</td>
					<td style="width: 15%; border: 0.3px gray solid ;">
						이미지
					</td>
					<td style="width: 30%; border: 0.3px gray solid ;">
						상품명/옵션
					</td>
					<td style="width: 10%; border: 0.3px gray solid ;">
						수량
					</td>
					<td style="width: 15%; border: 0.3px gray solid ;">
						상품 금액
					</td>
					<td style="width: 15%; border: 0.3px gray solid ;">
						처리 상태
					</td>
				</tr>
				<c:forEach var="order" items="${orders}">
					<c:forEach var="orderItem" items="${order.getOrderItemList()}" varStatus="status">
					<c:if test="${!status.last}">
						<tr>
							<td style="width: 15%; vertical-align: middle; border-bottom: 0.5px gray Dotted ;">
								${order.getOrderDate()} <img class='dateilview' alt="주문정보 상세보기" title="주문정보 상세보기" width="15px;" 
								style="margin-top: 3px; cursor: pointer;" src="<%=request.getContextPath()%>/resources/images/icon/detailview.png"><br>
								[${order.getOrderId().substring(2, order.getOrderId().length())}]
							</td>
							<td align="center" style="max-width: 15%; padding:5px; vertical-align: middle;">
								<img width="50" height="50" alt="상품 이미지" src="<%=request.getContextPath()%>/resources/img/${orderItem.getProduct().getFileName().get(0)}">
							</td>
							<td style="width: 30%; vertical-align: middle;">
								<label class='names' style="cursor: pointer;" onclick="location.href='<%=request.getContextPath()%>/view/product?productId=${orderItem.getProduct().productId}'">${orderItem.getProduct().getProductName()}</label><br>
							</td>
							<td style="width: 10%; vertical-align: middle;">
								${orderItem.getQuantity()}
							</td>
							<td style="width: 15%; vertical-align: middle;">
								${orderItem.getPrice()}
							</td>
							<td style="width: 15%; vertical-align: middle;">
								${orderItem.getState()}
							</td>
						</tr>
					</c:if>
					<c:if test="${status.last}">
						<tr>
							<td style="width: 15%; vertical-align: middle; border-bottom: 0.5px gray Dotted; padding-bottom: 5px; margin-bottom: 5px;">
								${order.getOrderDate()} <img class='dateilview' alt="주문정보 상세보기" title="주문정보 상세보기" width="15px;" 
								style="margin-top: 3px; cursor: pointer;" src="<%=request.getContextPath()%>/resources/images/icon/detailview.png"><br>
								[${order.getOrderId().substring(2, order.getOrderId().length())}]
							</td>
							<td align="center" style="max-width: 15%; padding:5px; vertical-align: middle; border-bottom: 0.5px gray Dotted ;">
								<img width="50" height="50" alt="상품 이미지" src="<%=request.getContextPath()%>/resources/img/${orderItem.getProduct().getFileName().get(0)}">
							</td>
							<td style="width: 30%; vertical-align: middle; border-bottom: 0.5px gray Dotted ;">
								<label class='names' style="cursor: pointer;" onclick="location.href='<%=request.getContextPath()%>/view/product?productId=${orderItem.getProduct().productId}'">${orderItem.getProduct().getProductName()}</label><br>
							</td>
							<td style="width: 10%; vertical-align: middle; border-bottom: 0.5px gray Dotted ;">
								${orderItem.getQuantity()}
							</td>
							<td style="width: 15%; vertical-align: middle; border-bottom: 0.5px gray Dotted ;">
								${orderItem.getPrice()}
							</td>
							<td style="width: 15%; vertical-align: middle; border-bottom: 0.5px gray Dotted ;">
								${orderItem.getState()}
							</td>
						</tr>
					</c:if>
					</c:forEach>
				</c:forEach>
			</table>
			<!-- 모바일 전용 -->
			<table width="100%" id="mobileview" style="font-size: small;">
				<c:forEach var="order" items="${orders}">
					<tr>
						<td style="border-bottom: 0.5px gray Dotted; border-top: 0.3px gray solid ; margin-top: 10px;">
							<font style="float: left">${order.getOrderDate()}</font>
							<font style="float: right">${order.getOrderId().substring(2, order.getOrderId().length())}</font>
						</td>
					</tr>
					<tr>
						<td style="border-bottom: 0.3px gray solid;">
							<font size="1.8em">&#149; 주문상품 : ${order.getOrderItemList().get(0).product.productName} 외 ${order.getOrderItemList().size()-1}개</font><br> 
							<font size="1.8em">&#149; 주문금액 : ${order.getTotalPrice()}원</font><br>
							<font size="1.8em">&#149; 처리상태 : ${order.state}</font>
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>
	</section>
	<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>