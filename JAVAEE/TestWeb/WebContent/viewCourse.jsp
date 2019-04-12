<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>所有课程信息</title>
<script language="JavaScript" src="js/jquery-1.11.3.js"></script>
<script type="text/javascript">
</script>
<style>
	*{
	text-decoration:none;
	}
	td{
		text-align:center;
		padding:15px;
		border:1px solid red;
	}
	.big{
		width:558px;
		height:300px;
		display:flex;
		justify-content:space-between;
		 align-items: flex-end;
		 font-size:20px;
	}
</style>
</head>
<body>


<table  cellspacing=0>
<tr><td>id</td><td>课程名</td></tr>
<c:forEach items="${course}" var="course">

	<tr>
		<td>${course.value.cid}</td>
		<td>${course.value.cname}</td>

	</tr>
</c:forEach>
</table>

</body>
</html>