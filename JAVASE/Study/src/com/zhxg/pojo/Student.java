package com.zhxg.pojo;

public class Student {

	public int id;
	public int age;
	public String name;
	public String sex;
	public String _class;

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
	public String get_Class() {
        return _class;
    }
    public void set_Class(String _class) {
        this._class = _class;
    }


	public Student(int id,int age,String name,String sex,String _class){
		this.id = id;
        this.age = age;
		this.name = name;
		this.sex = sex;
		this._class = _class;
	}
}
