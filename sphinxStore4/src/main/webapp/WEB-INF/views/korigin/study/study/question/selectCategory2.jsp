<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.min.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/js/jstree.js"></script>
<script type="text/javascript">
function resizeWin(win) {
	var wid=win.document.body.offsetWidth+200;
	var hei=win.document.body.offsetHeight+100;
	win.resizeTo(wid,hei);
}
$(function () { 
	$('#jstree_demo').jstree();
	$('#jstree_demo').on("changed.jstree", function (e, data) {
	      console.log(data.selected);
	});
	$('button').on('click', function () {
	      $('#jstree_demo').jstree(true).select_node('child_node_1');
	      $('#jstree_demo').jstree('select_node', 'child_node_1');
	      $.jstree.reference('#jstree_demo').select_node('child_node_1');
	 });
});
</script>
</head>
<body onload="resizeWin(this)">
<div id="jstree_demo">
<ul>
      <li>Root node 1
        <ul>
          <li id="child_node_1">Child node 1</li>
          <li>Child node 2</li>
        </ul>
      </li>
      <li>Root node 2</li>
    </ul>
    </div>
    <button>demo button</button>
<ul id="selectCat" style="width: auto;" >
<c:if test="${applicationScope.firstCategoryList!=null }">
<c:forEach items="${applicationScope.firstCategoryList}" var="category">
<li onclick="alert('뽀잉')">[${category.cid}]${category.title }</li>
<script>expandSub('${category.cid}')</script>
</c:forEach>
</c:if>
</ul>
<input type="hidden" name="catChoice">
<div style="padding: 20px">
<a href="#" onclick="putCategory()" style="text-decoration: none;border: 1px solid #777777;border-radius: 4px;"><font color="blue">확인</font></a>
<a href="#" onclick="self.close()" style="text-decoration: none;border: 1px solid #777777;border-radius: 4px;"><font color="red">취소</font></a>
</div>
</body>
</html>