<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
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
animation-duration:10s;
animation-name:stop;
animation-delay:0s;
}

@keyframes move{
0%{right:10px;}
100%{right:600px;}
}

#gorilla {
	top: 50px;
	left: 200px;
	width: 100px;
	height: 200px;
	background-image:
		url("<%=request.getContextPath()%>/upload/damaged.gif");
	background-size:contain;
	background-repeat:no-repeat;
	position: absolute;
	animation-delay: 0.3s;
	animation-duration: 0.5s;
	animation-fill-mode: forwards; 
	animation-name: hitted;
	animation-timing-function: ease;
}
@keyframes hitted {
0%{left: 200px;}
50%{left: 180px;}
100%{left: 200px;}
}

#tree {
	top: -100px;
	left: 250px;
	width: 100px;
	height: 100px;
	background-image:
		url("<%=request.getContextPath()%>/upload/통나무1.png");
	background-size:contain;
	background-repeat:no-repeat;
	position: relative;
	animation-duration: 0.5s;
	animation-delay: 0s;
	animation-fill-mode: forwards; 
	animation-name: attack;
	animation-timing-function: ease;
}

@keyframes attack {
0%{left: 250px;}
50%{left: 200px;}
100%{left: 250px; }
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