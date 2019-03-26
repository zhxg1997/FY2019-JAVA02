package com.zhxg97;

class User{
 public String username;
 public String password;
 public String name;
 public String email;
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public User(String username,String password,String name,String email){
	this.username = username;
    this.password = password;
	this.name = name;
	this.email = email;
}
public User(String username,String password,String password2,String name,String email) {
	this.username = username;
    this.password = password;
    this.password = password2;
    this.name = name;
	this.email = email;
}

 
}
