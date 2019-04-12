package com.zhxg.adminservice;
import java.util.HashMap;
import com.zhxg.pojo.Admin;

public interface  AdminBiz {
	 public boolean isusernameexists(String username);
	 public  int login(String username,String password);
	 public void write1();
	 public HashMap<String, Admin> read1();
	 public int register(String username,String password);
	 
}
