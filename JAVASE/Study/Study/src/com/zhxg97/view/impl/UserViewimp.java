package com.zhxg97.view.impl;

import java.util.Scanner;

import com.zhxg97.exception.LoginException;
import com.zhxg97.exception.RegisterException;
import com.zhxg97.service.UserBiz;
import com.zhxg97.service.impl.UserBizimp;
import com.zhxg97.view.UserView;

public class UserViewimp implements UserView{
	UserBiz a = new UserBizimp(); 
	public void login() throws LoginException {
		Scanner s=new Scanner(System.in); 
        System.out.print("请输入用户名:");
        String str1=s.next();
        System.out.print("请输入密码:");
        String str2=s.next();
		a.login(str1,str2);
	}


	public void register() throws RegisterException {
		Scanner s=new Scanner(System.in); 
        System.out.print("请添用户名:");
        String str1=s.next();
        System.out.print("请添加密码:");
        String str2=s.next();
        System.out.print("重复密码:");
        String str3=s.next(); 
        System.out.print("请添加姓名:");
        String str4=s.next();
        System.out.print("请添加邮箱:");
        String str5=s.next();

		a.register(str1, str2, str3, str4, str5);
		
	}

}
