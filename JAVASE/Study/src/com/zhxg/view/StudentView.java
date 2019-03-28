package com.zhxg.view;

import com.zhxg.exception.AddStundentException;
import com.zhxg.exception.ChangeStudentException;
import com.zhxg.exception.DeleteStudentException;
import com.zhxg.exception.LoginException;

public interface StudentView {

	 public void  changeStudent()throws ChangeStudentException;
	 public void addStudent()throws AddStundentException;
	 public void  deleteStudent()throws DeleteStudentException;
	 public void login()throws LoginException;
	 public void viewStudent();
	
}