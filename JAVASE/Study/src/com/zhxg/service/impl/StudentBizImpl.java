package com.zhxg.service.impl;

import com.zhxg.exception.AddStundentException;
import com.zhxg.exception.ChangeStudentException;
import com.zhxg.exception.DeleteStudentException;
import com.zhxg.exception.LoginException;
import com.zhxg.pojo.Admin;
import com.zhxg.pojo.Student;
import com.zhxg.service.StudentBiz;

public class StudentBizImpl implements StudentBiz{
	Student[] person =new Student[32];
	Admin[] admins =new Admin[5];
	public StudentBizImpl() {
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
	 public void viewStudent() {
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
	 }
		public void changeStudent(int id)throws ChangeStudentException {
			for( int i=0;i<person.length;i++) {
				if(person[i] != null) {
					if(person[i].id == id) {
						break;
					}else {continue;}
				}else {throw new ChangeStudentException("此id不存在，请重新输入"+"\r\n"); }
				}
			
		}
	public void changeStudent(int id, int age, String name, String sex, String _class)  {
		for( int i=0;i<person.length;i++) {
			if(person[i].id == id) {
				person[i].age = age ;
				person[i].name = name ;
				person[i].sex = sex ;
				person[i]._class = _class ;
				break;
		}
		}
	}

	 public void addStudent(int id) throws AddStundentException {
		 for( int i=0;i<person.length;i++) {
				if(person[i] != null) {
					if(person[i].id != id) {
						continue;
					}else {
					throw new AddStundentException("此id已存在，请重新输入"+"\r\n"); 
					}
				}else {break;}
			
			}
	 }
	public void addStudent(int id, int age, String name, String sex, String _class) {
        

		Student x = new Student(id, age, name, sex,_class);
		for( int i=0;i<person.length;i++) {
			if(person[i] != null) {
				continue;
			}else{ 
					person[i] = x  ;
					break;}
		}
	}

	@Override
	public void deleteStudent(int id) throws DeleteStudentException {
		for( int i=0;i<person.length;i++) {
			if(person[i] != null) {
				if(person[i].id == id) {
					person[i] = null;
					break;
				}else {continue;}
			}else {
				throw new DeleteStudentException("id不存在,请重新输入"+"\r\n"); 
			}
			}
		
	}

	@Override
	public void login(String username, String password) throws LoginException {
		  int a = 1;
		  for(int i = 0;i <5 ;i++){

			  if(username.equals(admins[i].username)&&password.equals(admins[i].password)){

				  System.out.println("登陆成功"+"\r\n"+"欢迎您："+admins[i].username);
				  a = 2;
				  break;
			  }
			  continue;
		  }	
		  if(a == 1){
			  throw new LoginException("用户名与密码不匹配，请重新输入"+"\r\n"); 
			  
		  }
		
		}


}
