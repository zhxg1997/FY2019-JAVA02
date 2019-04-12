<%@ page language="java" contentType="text/html; utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; utf-8">
<title>学生管理系统</title>
</head>
<body>
	<a href="main.jsp">学生管理</a><br>
	<a href="course.jsp">课程管理</a>
	        <div><a href="/TestWeb/ExitServlet">退出登录</a></div>
			<a href="/TestWeb/NumberServlet">查看当前在线人数</a>
			<div  style="font-size:1em">${number}</div>
</body>
</html>