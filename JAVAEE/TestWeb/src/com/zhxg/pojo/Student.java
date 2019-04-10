package com.zhxg.pojo;

import java.io.Serializable;

public class Student implements Comparable<Student>,Serializable{

	public int id;
	public  int age;
	public String name;
	public String sex;
	public String class1;
	public int scores;
	public String date1;
	public String date2;

	public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
	public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
	public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
	public String getClass1() {
        return class1;
    }
    public void setClass(String class1) {
        this.class1 = class1;
    }
    public int getScores() {
        return scores;
    }
    public void setScores(int scores) {
        this.scores = scores;
    }
    public String getDate1() {
        return date1;
    }
    public void setDate1(String date1) {
        this.date1 = date1;
    }
    public String getDate2() {
        return date2;
    }
    public void set_Date1(String date2) {
        this.date2 = date2;
    }

	public Student(int id,int age,String name,String sex,String class1,int scores,String date1,String date2){
		this.id = id;
        this.age = age;
		this.name = name;
		this.sex = sex;
		this.class1 = class1;
		this.scores = scores;
		this.date1 = date1;
		this.date2 = date2;
	}
	public Student(int id,int age,String name,String sex,String class1,int scores,String date2){
		this.id = id;
        this.age = age;
		this.name = name;
		this.sex = sex;
		this.class1 = class1;
		this.scores = scores;

		this.date2 = date2;
	}


	//重写Comparable接口的方法
	public int compareTo(Student o) {
		
		if(o == null) {
			return 1;
		}
		
		return this.scores-o.scores;
	}
}
