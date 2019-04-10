<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加学生信息</title>
<script language="JavaScript" src="js/jquery-1.11.3.js"></script>
    <style>

        .small{
        	display:flex;
			justify-content: space-between;
            height: 50px;
            line-height: 25px;
            align-items: center;
            }
		.big{
			width: 350px;
			position: absolute;
			left:200px;
			top:300px;
		}
		 .big .small span{
            height: 25px;
        }
        .big .small input{
            
            height: 25px;
            width: 200px;
        }
        
		.btn{
			
			width: 80px;
			height: 40px;
			font-size:18px;
		}
			td{
		text-align:center;
		padding:15px;
		border:1px solid red;
	}
    </style>
</head>
<body>
<table  cellspacing=0 >
<tr><td>id</td><td>年龄</td><td>姓名</td><td>性别</td><td>班级</td><td>分数</td><td>注册日期</td><td>修改日期</td></tr>
	<tr>
		<td>${list.id}</td>
		<td>${list.age}</td>
		<td>${list.name}</td>
		<td>${list.sex}</td>
		<td>${list.class1}</td>
		<td>${list.scores}</td>
		<td>${list.date1}</td>
		<td>${list.date2}</td>
	</tr>
</table>
    <form id="formId" action="/TestWeb/OneStudentServlet">

	<div class="big">
       <div class="small">
            <span>id</span><input type="text" name="id">
       </div>

       <div class="small">
       	 <div  style="font-size:1em;color:red">${msg}</div>
       </div>

       <div class="small">
       <button type = "submit" class="btn">查看</button><a href="main.html">返回</a>
       </div>
	</div>

    </form>

</body>
</html>