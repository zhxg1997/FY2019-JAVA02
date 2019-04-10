<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>所有学生信息</title>
<script language="JavaScript" src="js/jquery-1.11.3.js"></script>
<script type="text/javascript">
</script>
<style>
	td{
		text-align:center;
		padding:15px;
		border:1px solid red;
	}

</style>
</head>
<body>


<table  cellspacing=0>
<tr><td>id</td><td>年龄</td><td>姓名</td><td>性别</td><td>班级</td><td>分数</td><td>注册日期</td><td>修改日期</td></tr>
<c:forEach items="${user}" var="user">

	<tr>
		<td>${user.value.id}</td>
		<td>${user.value.age}</td>
		<td>${user.value.name}</td>
		<td>${user.value.sex}</td>
		<td>${user.value.class1}</td>
		<td>${user.value.scores}</td>
		<td>${user.value.date1}</td>
		<td>${user.value.date2}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>