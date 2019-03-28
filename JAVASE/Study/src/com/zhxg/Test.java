package com.zhxg;
import java.util.Scanner;
import javax.swing.text.View;
import com.zhxg.exception.AddStundentException;
import com.zhxg.exception.ChangeStudentException;
import com.zhxg.exception.DeleteStudentException;
import com.zhxg.exception.LoginException;
import com.zhxg.pojo.Admin;
import com.zhxg.pojo.Student;
import com.zhxg.view.StudentView;
import com.zhxg.view.impl.StudentViewImpl;
public class Test {
	static StudentView view = new StudentViewImpl();
	public static void main(String[] args){
		welcome();
		select1();
		login();
		list(); 
		select2();
}
			public static void welcome(){
				System.out.println("--------------------欢迎登陆学生信息管理系统--------------------------"
			+"\r\n"+"1.登陆"+"    "+"2.退出"+"\r\n"
			+"----------------------------------------------------------------------");
			}
			public static void select1(){
				Scanner sc=new Scanner(System.in); 
          String str = "" ;
          System.out.print("请选择:");
          str=sc.next();
         if(str.equals("1")) {
			System.out.println("欢迎登陆!"+"\r\n");  
          }
		  else if(str.equals("2")){
			  System.out.println("程序结束"); 
				System.exit(0);			
		  }else{
			  System.out.println("输入有误，请重新输入"); 
				select1();
		  }
			}
			public static void login(){

				try {
					view.login();
				} catch (LoginException e) {
					String msg=e.getMessage();
					System.out.print(msg);
					login();
				}
			}
			public static void list(){
				System.out.println("\r\n"+"**********************请选择要操作的信息对应数字******************************"
			+"\r\n"+"1.查看学生信息"+"    "+"2.添加学生信息"+"    "+"3.删除学生信息"+"    "+"4.修改学生信息"+"    "+"5.退出"+"\r\n"
			+"**********************************************************************");
			}
			public static void select2(){
		Scanner sc1=new Scanner(System.in); 
          String str1 = "" ;
          System.out.print("请选择:");
          str1=sc1.next();
			if(str1.equals("1")){
				viewStudent();
			}else if(str1.equals("2")){
				addStudent();
			}else if(str1.equals("3")){
				deleteStudent();
			}else if(str1.equals("4")){
				changeStudent();
			}else if(str1.equals("5")){
				System.exit(0);
			}
			else{
				System.out.println("尚未构建此功能");
				select2();
			}
			}
			public static void viewStudent(){
				
				view.viewStudent();
	
			list();
			select2();
			}
			public static void addStudent() {
				try {
					view.addStudent();
				} catch (AddStundentException e) {
					String msg=e.getMessage();
					System.out.print(msg);
					addStudent();
				}
				list();
				select2();
			}
			public static void deleteStudent() {
				try {view.deleteStudent();
				} catch (DeleteStudentException e) 
					{
					String msg=e.getMessage();
					System.out.print(msg);
					deleteStudent();
					}
				list();
				select2();
			}
			public static void changeStudent() {
				try {
					view.changeStudent();
				} catch (ChangeStudentException e) {
					String msg=e.getMessage();
					System.out.print(msg);
					changeStudent();
				}
				list();
				select2();
				}
			}