package com.zhxg.courseservice;

import java.util.HashMap;

import com.zhxg.pojo.Course;

public interface CourseBiz {

	 public int  changeCourse(int cid,String cname);
	 public boolean  isidrepeat(int cid);
	 public int addCourse(int cid,String cname);
	 public boolean  deleteCourse(int cid);
	 public HashMap<Integer, Course> viewCourse();
	 public void write();
	 public HashMap<Integer, Course> read();
}
