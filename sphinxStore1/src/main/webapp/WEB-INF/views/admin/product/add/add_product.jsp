<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script type="text/javascript">
$(function() {
	$("#upplus").click(function() {
		var result = ""+ (Math.floor(Math.random() * 1000) + 1);
		var text= "<div class='file_input' style='margin-top:15px;'>"+
		"<label for='"+result+"'>File Upload"+
		"<input type='file' name='fileNm' id='"+result+"' class='1000' onchange='change("+ result +", this.value);'>"+
		"</label><label style='border-left: solid 0.5px white;' class='remove'>삭제</label>"+
		"<label id='"+result+"p' onclick='preview(this.id)' style='border-left: solid 0.5px white; width: 25%;' id='upplus'>미리보기</label>"+
		"<input type='text' style='padding-left: 10px;' readonly='readonly' id='"+ result +"text'/></div>";
			$("#uploader").append(text);
	});
	
	$(document).on("click", ".remove", function() {
		  $(this).parent().remove();
	});
});

function change(id, val) {
	var text = document.getElementById(id+"text");
	text.value = val;
	preview(id);
}

function preview(id) {
	id = parseInt(id);
	var file = document.getElementById(id);
	var fileList = file.files;
    // 읽기
    var reader = new FileReader();
    try {
    	reader.readAsDataURL(fileList[0]);
    } catch (exception) {
    	alert('이미지를 먼저 업로드 해주세요.');
    	return;
    }
    //로드 한 후
    reader.onload = function() {
        //로컬 이미지를 보여주기
        document.getElementById('preview').style.display = '';
        document.getElementById('preview').src = reader.result;
    };
}

function detailOption(id) {
	id = parseInt(id);
	
	var text = "";
	text += "<div><input type='text' style='width:40%' name='detailoption"+id+"' class='detailoption' placeholder='상세옵션의 명칭을 입력해주세요.'>";
	text += "<input type='text' style='margin-left:5px; width:40%' name='amount"+id+"' class='amount' placeholder='추가액을 입력해주세요.'>"+
			"<img onclick='removeDetail(this);' style='cursor:pointer; padding-top:5px; width:10px;' src='<%=request.getContextPath()%>/resources/images/icon/delete.png'></div>"
	
	$("#div"+id).append(text);
}

function addOption() {
	var result = document.getElementsByClassName('option').length;
	var text = ""+
				"<input type='hidden' name='chkOption' value='"+result+"'>"+
				"<div id='div"+result+"' style='border: 0.5px solid #BDBDBD; padding: 10px;'>"+
				"<p style='cursor: pointer; border-bottom: 0.5px solid #BDBDBD;' onclick='removeDetail(this)'>옵션 삭제</p>"+
				  	"<p style='float: right; cursor: pointer;' onclick='detailOption(this.id)' id='"+result+"op'>상세옵션 추가</p>"+
				  	"옵션명 <input type='text' class='option' id='"+result+"' name='optionName' placeholder='옵션의 명칭을 입력해주세요.'"+
				  	"style='width: 80%; height: 20px; padding-left:5px; padding-right:5px; font-size: 13px;'><br>"+
				"</div>";			
				
	$("#detailoption").append(text);
}

function removeDetail(id) {
	var parent = $(id).parent();
	parent.remove();
}

function movePage(number) {
	if (number == 1) {
		var file = document.getElementsByClassName('1000');
		var i = 0;
		for (var x = 0; x < file.length; x++) {
			if (file[x].value.length >= 1) {
				i++
			}
		}
		
		if (i == 0) {
			alert('대표이미지를 1개이상 등록해주세요.');
			return;
		}
	} else if (number == 2) {
		if ($("#name").val().length < 1 || $("#price").val().length < 1 || $("#comment").val().length < 1) {
			alert('상품의 주요 속성들을 모두 입력해주세요.');
			return;
		}
	} else if (number == 3) {
		var option = document.getElementsByClassName('option');
		var detailoption = document.getElementsByClassName('detailoption');
		var amount = document.getElementsByClassName('amount');
		
		var x = 0;
		
		for (var i = 0; i < option.length; i++) {
			if (option[i].value.length < 1) {
				x++;
			}
		}
		
		
		if (detailoption.length != 0) {
			for (var i = 0; i < detailoption.length; i++) {
				if (detailoption[i].value.length < 1) {
					x++;
				}
			}
		}
		
		if (amount.length != 0) {
			for (var i = 0; i < amount.length; i++) {
				if (amount[i].value.length < 1) {
					x++;
				}
			}
		}
		
		if (x != 0) {
			alert('옵션 혹은 상세옵션의 빈칸은 허용되지 않습니다.');
			return;
		}
	} else {
		
	}
	
	$("#page"+ number).css('display', 'none');
	$("#page"+ (number+1)).slideDown("2000");
}

function moveBefore(number) {
	$("#page"+ number).css('display', 'none');
	$("#page"+ (number-1)).slideDown("2000");
}
</script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/se2/js/HuskyEZCreator.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/se2/photo_uploader/plugin/hp_SE2M_AttachQuickPhoto.js" charset="utf-8"></script>
<script type="text/javascript">
var oEditors = [];
$(function(){
      nhn.husky.EZCreator.createInIFrame({
          oAppRef: oEditors,
          elPlaceHolder: "ir1", //textarea에서 지정한 id와 일치해야 합니다. 
          //SmartEditor2Skin.html 파일이 존재하는 경로
          sSkinURI: "<%=request.getContextPath()%>/resources/se2/SmartEditor2Skin.html",  
          htParams : {
              // 툴바 사용 여부 (true:사용/ false:사용하지 않음)
              bUseToolbar : true,             
              // 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
              bUseVerticalResizer : true,     
              // 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
              bUseModeChanger : true,         
              fOnBeforeUnload : function(){
                   
              }
          }, 
          fOnAppLoad : function(){
              //기존 저장된 내용의 text 내용을 에디터상에 뿌려주고자 할때 사용
              oEditors.getById["ir1"].exec("PASTE_HTML", [""]);
          },
          fCreator: "createSEditor2"
      });
      
      //저장버튼 클릭시 form 전송
      $("#save").click(function(){
          oEditors.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", []);
      if (document.getElementById("ir1").value.length <= 100000) {
    			$("#frm").submit();
      } else {
    	  alert('최대 5000자를 초과 하였습니다.\n현재 글자수 : '+ document.getElementById("ir1").value.length +"자");
      }
      });    
});

// textArea에 이미지 첨부
function pasteHTML(filepath){
	var path = '<%=request.getContextPath()%>/resources'
    var sHTML = '<img src="'+ path +'/img/'+filepath+'">';
    oEditors.getById["ir1"].exec("PASTE_HTML", [sHTML]);
}
 

 
</script>
<style type="text/css">
.file_input label {
    position:relative;
    cursor:pointer;
    display:inline-block;
    vertical-align:middle;
    overflow:hidden;
    width:20%;
    height:30px;
    background:#777;
    color:#fff;
    text-align:center;
    line-height:30px;
}
.file_input label input {
    position:absolute;
    width:0;
    height:0;
    overflow:hidden;
}
.file_input input[type=text] {
    vertical-align:middle;
    display:inline-block;
    width:70%;
    height:28px;
    line-height:28px;
    font-size:11px;
    padding:0;
    border:0;
    border:1px solid #777;
}
</style>
</head>
<body class="page1" id="top" style="display: none;">
<%@include file="/WEB-INF/views/header.jsp"%>
<!--=====================
          Content
======================-->
<form id="frm" action="<%=request.getContextPath()%>/admin/product/createproduct" method="post"  enctype="multipart/form-data">
<section class="content">
  <div class="container" id="page1">
    <div class="row">
      <div class="grid_12" style="margin-top: 50px;">
        <div class="box">
          <div class="row">
            <div class="grid_5 preffix_1">
              <h2>#STEP 1</h2>
              <p>상품의 대표 이미를 등록하는 페이지입니다. 여러장의 대표이미지를 등록하여 해당 상품의 이목을 집중시켜보세요!
              <br>
            </div>
            <div class="grid_5" id="conten">
              <h2>대표 이미지</h2>
              	여러개의 대표 이미지를 등록하고자 한다면 '추가'버튼을 눌러보세요!<br><br>
              	<div id="uploader">
              	<div class="file_input">
              	<img alt="" src="" style="display:none; max-width: 30%;" id="preview"><br><br>
				    <label for="1000">
				        File Upload
				        <input type="file" name="fileNm" onchange="change('1000', this.value);" class="1000" id="1000" accept="image/*">
				    </label><label style="border-left: solid 0.5px white;" id="upplus">추가</label><label id="1000p" onclick="preview(this.id)" 
				    style="border-left: solid 0.5px white; width: 25%;" id="upplus">미리보기</label>
				    <input type="text" style="padding-left: 10px;" readonly="readonly" title="File Route" id="1000text">
				</div>
				</div>
            </div>
          </div> 
        </div>
      </div>
      <div align="center">
      <span id="warnn" style="color: red;"></span><br>
      	<a class="btn" id="sub" onclick="movePage(1)" style="cursor: pointer;">다음</a>
      </div>
    </div>
  </div>
</section>
<section class="content">
  <div class="container" id="page2" style="display:none;">
    <div class="row">
      <div class="grid_12" style="margin-top: 50px;">
        <div class="box">
          <div class="row">
            <div class="grid_5 preffix_1">
              <h2>#STEP 2</h2>
              <p>상품의 명칭, 가격 그리고 해당 상품만의 특별한 코멘트를 작성해주세요.
              <br>
            </div>
            <div class="grid_5" id="conten">
              <h2>상품 속성</h2>
              	상품의 주요 속성들을 작성하는 단계입니다.<br><br>
              	카테고리 : 
              	<select name="categoryId" style="height: 25px; width: 80%; overflow-x: auto;">
              		<c:forEach var="category" items="${categoryList}">
              		<c:if test="${parents.get(category.categoryId).size() >= 2}">
	              		<option value="${category.categoryId}">
              				<c:forEach var="parent" items="${parents.get(category.categoryId)}">
              					${parent.categoryName} >
              				</c:forEach>
              					${category.categoryName}
						</option>
					</c:if>
					</c:forEach>
              	</select><br><br>
              	상품명 : 
              	<input type="text" id="name" name="productName" placeholder="상품명을 입력해주세요.";
              	style="width: 80%; height: 20px; padding-left:5px; padding-right:5px; font-size: 13px;"><br>
              	가&nbsp;&nbsp;&nbsp;&nbsp;격 : 
              	<input type="text" id="price" name="price" placeholder="상품의 가격을 입력해주세요.";
              	style="width: 80%; height: 20px; padding-left:5px; padding-right:5px; font-size: 13px;"><br>
              	코멘트 : 
              	<input type="text" id="comment" name="comment" placeholder="해당 상품만의 특별한 코멘트를 입력해주세요.";
              	style="width: 80%; height: 20px; padding-left:5px; padding-right:5px; font-size: 13px;"><br>
            </div>
          </div> 
        </div>
      </div>
      <div align="center">
      <span id="warnn" style="color: red;"></span><br>
      	<a class="btn" id="sub" onclick="moveBefore(2)" style="cursor: pointer;">이전</a> <a class="btn" onclick="movePage(2);" id="sub" style="cursor: pointer;">다음</a>
      </div>
    </div>
  </div>
</section>
<section class="content">
  <div class="container" id="page3" style="display:none;">
    <div class="row">
      <div class="grid_12" style="margin-top: 50px;">
        <div class="box">
          <div class="row">
            <div class="grid_5 preffix_1">
              <h2>#STEP 3</h2>
              <p>상품의 색상,종류 등 고유 옵션을 등록하고 상세옵션에의한 추가금액도 함께 등록해주세요.
              <br>
            </div>
            <div class="grid_5" id="conten">
              <h2>상품 옵션</h2>
              	상품의 옵션을 지정하는 단계입니다. 옵션을 추가하려면 '옵션추가'버튼을 상세옵션을 추가하려면 '상세옵션 추가'버튼을 클릭해주세요.<br><br>
              	<font style="font-weight: bold;">옵션예시 : 옵션명 - 색상, 상세옵션 : 빨간색,추가액 1000원</font><br><br>
              	<div id="detailoption">
              	<div id="div0" style="border: 0.5px solid #BDBDBD; padding: 10px;">
              	<input type="hidden" name="chkOption" value="0">
              	<p style="cursor: pointer; border-bottom: 0.5px solid #BDBDBD;" onclick="addOption()" id="0op">옵션 추가</p>
	              	<p style="float: right; cursor: pointer;" onclick="detailOption(this.id)" id="0op">상세옵션 추가</p>
		              	옵션명 <input type="text" class="option" id="0" name="optionName" placeholder="옵션의 명칭을 입력해주세요."
		              	style="width: 80%; height: 20px; padding-left:5px; padding-right:5px; font-size: 13px;"><br>
		        </div>
	            </div>
            </div>
          </div> 
        </div>
      </div>
      <div align="center">
      <span id="warnn" style="color: red;"></span><br>
      	<a class="btn" id="sub" onclick="moveBefore(3)" style="cursor: pointer;">이전</a> <a class="btn" id="sub" onclick="movePage(3)" style="cursor: pointer;">다음</a>
      </div>
    </div>
  </div>
</section>
<section class="content">
  <div class="container" id="page4" style="display:none;">
    <div class="row">
      <div class="grid_12" style="margin-top: 50px;">
        <div class="box">
          <div class="row">
            <div class="grid_5 preffix_1" style="width: 80%;">
              <h2>#STEP 4</h2>
              <p>상품의 상세 내용을 등록해주세요.
              <br>
              <textarea id="ir1" cols="10" onkeydown="limit(this.form)"
						name="content" class="form-control" style="width: 100%; max-width:260px; height: 300px;">
			  </textarea>
            </div>
          </div> 
        </div>
      </div>
      <div align="center">
      <span id="warnn" style="color: red;"></span><br>
      	<a class="btn" id="sub" onclick="moveBefore(4)" style="cursor: pointer;">이전</a> <a class="btn" id="save" style="cursor: pointer;">상품 등록</a>
      </div>
    </div>
  </div>
</section>
</form>
<!--==============================
              footer
=================================-->
<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>