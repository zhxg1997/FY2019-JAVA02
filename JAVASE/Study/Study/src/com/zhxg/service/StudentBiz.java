package com.zhxg.service;

import com.zhxg.exception.AddStundentException;
import com.zhxg.exception.ChangeStudentException;
import com.zhxg.exception.DeleteStudentException;
import com.zhxg.exception.LoginException;

public interface StudentBiz {

	 public void  changeStudent(int id,int age,String name,String sex,String _class,int scores)throws ChangeStudentException;
	 public void  changeStudent(int id)throws ChangeStudentException;
	 public void addStudent(int id,int age,String name,String sex,String _class,int scores);
	 public void addStudent(int id) throws AddStundentException;
	 public void  deleteStudent(int id)throws DeleteStudentException;
	 public void login(String username,String password)throws LoginException;
	 public void viewStudent();
}