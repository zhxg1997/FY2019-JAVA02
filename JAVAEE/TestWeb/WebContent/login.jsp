<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
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
			top: 200px;
			width: 80px;
			height: 40px;
			font-size:18px;
		}
    </style>
</head>
<body>
	
    <form id="formId" action="/TestWeb/AdminServlet">
        <input type="hidden" name="method" value="login">
	<div class="big">
	<div class="small">
            <h1 >管理员登录</h1>
       </div>
       <div class="small">
            <span>用户名</span><input type="text" name="username">
       </div>
       <div class="small">
            <span>密码</span><input type="password" name="password">
       </div>
       <div class="small">
       	 <div  style="font-size:1em;color:red">${msg}</div>
       </div>
       <button type = "submit" class="btn">登录</button>
	</div>


    </form>
</body>
</html>