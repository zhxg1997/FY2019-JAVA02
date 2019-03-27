package com.zhxg;
import java.util.Scanner;
public class Test {

	public static void main(String[] args){
		
		welcome();
		select1();
		Admin[] admins =new Admin[5];
		admin(admins);
		login(admins);
		list(); 
		Student[] person =new Student[32];
		select2(person);

         
	
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
			public static void login(Admin[] admins){
		Scanner sc1=new Scanner(System.in); 
          String str1;
          System.out.print("请输入用户名:");
          str1=sc1.next();
		Scanner sc2=new Scanner(System.in); 
          String str2;
          System.out.print("请输入密码:");
          str2=sc2.next(); 
				  			  int a = 1;
		  for(int i = 0;i <5 ;i++){

			  if(str1.equals(admins[i].username)&&str2.equals(admins[i].password)){

				  System.out.println("登陆成功"+"\r\n"+"欢迎您："+admins[i].username);
				  a = 2;
				  break;
			  }
				  continue;
			  	

		  }			if(a == 1){
				login(admins);
		  }
			}
			public static void list(){
				System.out.println("**********************请选择要操作的信息对应数字******************************"
			+"\r\n"+"1.查看学生信息"+"    "+"2.添加学生信息"+"    "+"3.删除学生信息"+"    "+"4.修改学生信息"+"    "+"5.退出"+"\r\n"
			+"**********************************************************************");
			}
			public static void admin(Admin[] admins){
							Admin x1 =new Admin("admin","admin");
							Admin x2 =new Admin("admin1","admin1");
							Admin x3 =new Admin("admin2","admin2");
							Admin x4 =new Admin("admin3","admin3");
							Admin x5 =new Admin("admin4","admin4");
							admins[0] = x1;
							admins[1] = x2;
							admins[2] = x3;
							admins[3] = x4;
							admins[4] = x5;
							

			}
			public static void select2(Student[] person){
		
		Scanner sc1=new Scanner(System.in); 
          String str1 = "" ;
          System.out.print("请选择:");
          str1=sc1.next();
			if(str1.equals("1")){
				viewStudent(person);
			}else if(str1.equals("2")){
				addStudent(person);
			}else if(str1.equals("3")){
				deleteStudent(person);
			}else if(str1.equals("4")){
				changeStudent(person);
			}else if(str1.equals("5")){
				System.exit(0);
			}
			
			else{
				System.out.println("尚未构建此功能");
				select2(person);
			}
		  
			}
			public static void viewStudent(Student[] person){

				System.out.println(" "+"id"+" "+"年龄"+"   "+"姓名"+"   "+"性别"+"  "+"年级"+"\r\n");

				
				for(int i=0;i<person.length;i++){  
					if(person[i] == null) {
						continue;
					}
	            System.out.println(" "+person[i].id+"  "+
				 person[i].age+"  "+
				 person[i].name+"    "+
				 person[i].sex+"    "+
				 person[i]._class);
			}
			list();
			select2(person);
}
			public static void addStudent(Student[] person) {
				Scanner s=new Scanner(System.in); 
		          int int1;
		          System.out.print("请添加id:");
		          int1=s.nextInt();
		          
		          for( int i=0;i<person.length;i++) {
							if(person[i] != null) {
								if(person[i].id != int1) {
									continue;
								}else {
								System.out.println("此id已经存在,请重新来过");
								addStudent(person);}
							}else {break;}
						
						}

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

				Student x = new Student(int1, int2, str3, str4,str5);
				for( int i=0;i<person.length;i++) {
					if(person[i] != null) {
						continue;
					}else{ 
							person[i] = x  ;
							break;}
				}
				list();
				select2(person);
				
			}
			public static void deleteStudent(Student[] person) {
				Scanner sc1=new Scanner(System.in); 
		          int int1;
		          System.out.print("请输入要删除的学生的id:");
		          int1=sc1.nextInt();

				for( int i=0;i<person.length;i++) {
					if(person[i] != null) {
						if(person[i].id == int1) {
							person[i] = null;
							break;
						}else {continue;}
					}else {System.out.println("此id不存在,请重新来过");
					deleteStudent(person);}
					}
				list();
				select2(person);
				
			}
			public static void changeStudent(Student[] person) {
				Scanner sc11=new Scanner(System.in); 
		          int int11;
		          System.out.print("请输入要修改的学生的id:");
		          int11=sc11.nextInt();
		          for( int i=0;i<person.length;i++) {
						if(person[i] != null) {
							if(person[i].id == int11) {
								break;
							}else {continue;}
						}else {System.out.println("此id不存在,请重新来过");
						changeStudent(person);}
						}

						
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
				for( int i=0;i<person.length;i++)
					if(person[i].id == int11) {
						person[i].age = int2 ;
						person[i].name = str3 ;
						person[i].sex = str4 ;
						person[i]._class = str5 ;
						break;
				}
				list();
				select2(person);
				}
			}
