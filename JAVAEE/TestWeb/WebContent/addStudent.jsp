<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
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
    </style>
</head>
<body>
	
    <form id="formId" action="/TestWeb/adminlogin/AddServlet">
	<div class="big">
       <div class="small">
            <span>id</span><input type="text" name="id">
       </div>
       
       <div class="small">
            <span>姓名</span><input type="text" name="name">
       </div>
       <div class="small">
            <span>性别</span><input type="text" name="sex">
       </div>
       <div class="small">
            <span>年龄</span><input type="text" name="age">
       </div>
       <div class="small">
            <span>班级</span><input type="text" name="class1">
       </div>
       <div class="small">
            <span>分数</span><input type="text" name="scores">
       </div>
		<div class="small">
       <div  style="font-size:1em;color:green">${msg1}</div>
       </div>
       <div class="small">
       	 <div  style="font-size:1em;color:red">${msg}</div>
       </div>

       <div class="small">
       <button type = "submit" class="btn">添加</button><a href="/TestWeb/main.jsp">返回</a>
       </div>
	</div>


    </form>
</body>
</html>