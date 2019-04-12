<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
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
			height: 100px;
			position: absolute;
			left:800px;
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
			position: absolute;
			left:50px;
			top: 300px;
			width: 80px;
			height: 40px;
			font-size:18px;
		}
    </style>
</head>
<body>
	
    <form id="formId" action="/TestWeb/Student1Servlet">
        <input type="hidden" name="method" value="regist">
	<div class="big">
	<div class="small">
            <h1 >管理员注册</h1>
       </div>
       <div class="small">
            <span>填写用户名</span><input type="text" name="username">
       </div>
       <div class="small">
            <span>填写密码</span><input type="password" name="password">
       </div>
       <div class="small">
       	 <div  style="font-size:1em;color:red">${msg}</div>
       	 <div  style="font-size:1em;color:green">${msg1}</div>
       </div>
              <div class = "small">
       <div  style="font-size:1em">${regist}</div>
       </div>
       <button type = "submit" class="btn">注册</button><a href="login.jsp">返回登录</a>

	</div>
	     
    </form>

</body>
</html>