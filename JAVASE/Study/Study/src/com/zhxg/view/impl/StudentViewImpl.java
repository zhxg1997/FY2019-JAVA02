package com.zhxg.view.impl;

import java.util.Scanner;

import javax.lang.model.type.NullType;

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
		 Scanner s=new Scanner(System.in); 
         System.out.print("请输入要修改的学生的id:");
         int int11=s.nextInt();
         biz.changeStudent(int11); 
         System.out.print("请添加年龄:");
         int int2=s.nextInt();
         System.out.print("请添加姓名:");
         String str3=s.next();
         System.out.print("请添加性别:");
         String str4=s.next();
         System.out.print("请添加年级:");
         String str5=s.next();
       System.out.print("请添加成绩:");
         int int6=s.nextInt();
         biz.changeStudent(int11, int2, str3, str4,str5, int6);
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
         System.out.print("请添加成绩:");
         int int6=s.nextInt();
         biz.addStudent(int1, int2, str3, str4, str5, int6);
	 }
	 public void  deleteStudent()throws DeleteStudentException{
		 Scanner sc1=new Scanner(System.in); 
         int int1;
         System.out.print("请输入要删除的学生的id:");
         int1=sc1.nextInt();
         biz.deleteStudent(int1);
	 }
}
