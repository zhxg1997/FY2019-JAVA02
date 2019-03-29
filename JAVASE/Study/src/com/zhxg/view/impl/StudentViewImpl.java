package com.zhxg.view.impl;

import java.util.Scanner;


import com.zhxg.exception.AddStundentException;
import com.zhxg.exception.ChangeStudentException;
import com.zhxg.exception.DeleteStudentException;
import com.zhxg.exception.LoginException;
import com.zhxg.pojo.Student;
import com.zhxg.service.StudentBiz;
import com.zhxg.service.impl.StudentBizImpl;
import com.zhxg.view.StudentView;

public class StudentViewImpl implements StudentView{
	
	StudentBiz biz = new StudentBizImpl();
	
	 public void login()throws LoginException{
			Scanner sc1=new Scanner(System.in); 
	          String str1;
	          System.out.print("请输入用户名:");
	          str1=sc1.next();
			Scanner sc2=new Scanner(System.in); 
	          String str2;
	          System.out.print("请输入密码:");
	          str2=sc2.next(); 
	          biz.login(str1, str2);
	 }
	 public void viewStudent() {
		 biz.viewStudent();
	 }
	 public void  changeStudent()throws ChangeStudentException{
		 Scanner sc11=new Scanner(System.in); 
         int int11;
         System.out.print("请输入要修改的学生的id:");
         int11=sc11.nextInt();
         biz.changeStudent(int11);
         Scanner sc2=new Scanner(System.in); 
         int int2;
         System.out.print("请添加年龄:");
         int2=sc2.nextInt();
       Scanner sc3=new Scanner(System.in); 
         String str3 = "" ;
         System.out.print("请添加姓名:");
         str3=sc3.next();
       Scanner sc4=new Scanner(System.in); 
         String str4 = "" ;
         System.out.print("请添加性别:");
         str4=sc4.next();
       Scanner sc5=new Scanner(System.in); 
         String str5 = "" ;
         System.out.print("请添加年级:");
         str5=sc5.next();
         biz.changeStudent(int11, int2, str3, str4,str5);
	 }
	 public void addStudent()throws AddStundentException{
		 Scanner s=new Scanner(System.in); 
         int int1;
         System.out.print("请添加id:");
         int1=s.nextInt();
         
         biz.addStudent(int1);

         int int2;
         System.out.print("请添加年龄:");
         int2=s.nextInt();
         String str3;
         System.out.print("请添加姓名:");
         str3=s.next(); 
         String str4;
         System.out.print("请添加性别:");
         str4=s.next();
         String str5;
         System.out.print("请添加年级:");
         str5=s.next();

         biz.addStudent(int1, int2, str3, str4, str5);
	 }
	 public void  deleteStudent()throws DeleteStudentException{
		 Scanner sc1=new Scanner(System.in); 
         int int1;
         System.out.print("请输入要删除的学生的id:");
         int1=sc1.nextInt();
         biz.deleteStudent(int1);
	 }
}
