package com.zhxg.studentservice;
import java.util.HashMap;
import com.zhxg.pojo.Student;

public interface StudentBiz {

	 public int  changeStudent(int id,int age,String name,String sex,String class1,int scores,String date1,String date2);
	 public boolean  isidrepeat(int id);
	 public int addStudent(int id,int age,String name,String sex,String class1,int scores,String date1,String date2);
	 public boolean  deleteStudent(int id);
	 public HashMap<Integer, Student> viewStudent();
	 public void write();
	 public HashMap<Integer, Student> read();
	public   int login(String username, String password);
	public int register(String username,String password);
	public void write1();
	public HashMap<String, Student> read1();
}