<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">

#background_frame{
width: 500px;
height: 200px;
overflow: hidden;
}

#background{
width: 2000px;
height: 150px;
background-image:url("<%=request.getContextPath()%>/upload/열대3.png");
position: relative;
animation-timing-function: linear;
animation-fill-mode: forwards; 
animation-duration:2s;
animation-name:move;
animation-delay:0s;
}

@keyframes move{
0%{right:10px;}
100%{right:600px;}
}

#gorilla {
	top: 50px;
	width: 100px;
	height: 200px;
	background-image:
		url("<%=request.getContextPath()%>/upload/run.gif");
	background-size:contain;
	background-repeat:no-repeat;
	position: absolute;
	animation-duration: 2s;
	animation-fill-mode: forwards; 
	animation-name: run;
	animation-timing-function: ease;
}

@keyframes run {
0%{left: -100px;}
100%{left: 200px;}
}

#tree {
	top: -100px;
	left: 600px;
	width: 100px;
	height: 100px;
	background-image:
		url("<%=request.getContextPath()%>/upload/통나무1.png");
	background-size:contain;
	background-repeat:no-repeat;
	position: relative;
	animation-duration: 2s;
	animation-delay: 0s;
	animation-fill-mode: forwards; 
	animation-name: runs;
	animation-timing-function: ease;
}

@keyframes runs {
0%{left: 600px;}
100%{left: 250px;}
}

</style>
</head>
<body>

	<div id="background_frame">
		<div id="background">
		</div>
		<div id="tree" ></div>
		<div id="gorilla" style="position: absolute;"></div>
	</div>
	
</body>
</html>