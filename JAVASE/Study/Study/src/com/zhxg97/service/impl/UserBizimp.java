package com.zhxg97.service.impl;
import java.util.Scanner;


import com.zhxg.pojo.Student;
import com.zhxg97.exception.LoginException;
import com.zhxg97.exception.RegisterException;
import com.zhxg97.pojo.User;
import com.zhxg97.service.UserBiz;
public class UserBizimp implements UserBiz{
	
	
		User[] a = new User[20];
		public UserBizimp(){
    	User x1 = new User("admin","admin","Administrator","admin@123.com");
    	User x2 = new User("tom","cat","tomcat","tomcat@cat.com");
    	a[0] = x1;
    	a[1] = x2;
		}
	public void register(String username, String password, String password2, String name, String email)
			throws RegisterException {


		User x =new User(username,password,name,email);

		for( int i=0;i<a.length;i++) {
			if(a[i] != null) {
				continue;
			}else{ 
					a[i] = x  ;
					break;}
		}


	}

	public void login(String username, String password) throws LoginException {
		

       for(int i = 0;i < a.length;i++) {
   		if(a[i] != null) {
    	   if(username.equals(a[i].username) && password.equals(a[i].password)) {
    		   System.out.println("登录成功");
    		   break;
    	   }else continue;
       }else {
    	   throw new LoginException("用户名与密码不匹配"); 
       }
       }
	}


}
