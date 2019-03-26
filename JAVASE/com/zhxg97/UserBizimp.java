package com.zhxg97;
import java.util.Scanner;

import com.zhxg.Student;
public class UserBizimp implements UserBiz{

	public void register(String username, String password, String password2, String name, String email)
			throws RegisterException {
     	User[] a = new User[20];
    	User x1 = new User(" admin","admin","Administrator","admin@123.com");
    	User x2 = new User("tom","cat","tomcat","tomcat@cat.com");
		
		 Scanner sc2=new Scanner(System.in); 
         String str2;
         System.out.print("请添用户名:");
         str2=sc2.next();
       Scanner sc3=new Scanner(System.in); 
         String str3 = "" ;
         System.out.print("请添加密码:");
         str3=sc3.next();
       Scanner sc4=new Scanner(System.in); 
         String str4 = "" ;
         System.out.print("重复密码:");
         str4=sc4.next();
         
       Scanner sc5=new Scanner(System.in); 
         String str5 = "" ;
         System.out.print("请添加姓名:");
         str5=sc5.next();
        Scanner sc6=new Scanner(System.in); 
         String str6 = "" ;
         System.out.print("请添加邮箱:");
         str5=sc5.next();

    	a[0] = x1;
    	a[1] = x2;

		User x = new User(str2, str3, str4, str5,str6);

		for( int i=0;i<a.length;i++) {
			if(a[i] != null) {
				continue;
			}else{ 
					a[i] = x  ;
					break;}
		}
	}

	public void login(String username, String password) throws LoginException {

		
	}

}
