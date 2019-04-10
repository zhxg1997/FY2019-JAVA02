package com.zhxg.adminservice.impl;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import com.zhxg.adminservice.AdminBiz;
import com.zhxg.pojo.Admin;

public class AdminBizImpl implements AdminBiz{
	public static AdminBizImpl adminBizImpl; 
	private	Map<String, Admin> map=new HashMap<String,Admin>();
	 private AdminBizImpl() {
		 	Admin admin1=new Admin("admin","admin");
			
			map.put(admin1.username,admin1);
	 }
	 public synchronized static AdminBizImpl getAdminBizImpl() {
			if(adminBizImpl == null) {
				adminBizImpl = new AdminBizImpl();
			}
				return adminBizImpl;	
		}

	 public boolean isusernameexists(String username)  {
			
			
			return map.containsKey(username);
			
		}
	 
		public int login(String username, String password){
		if(username==null||username.equals("")) {
			return 1;
		}
		
		if(password==null||password.equals("")) {
			return 1;
		}
			if(isusernameexists(username)) {
				
		Admin admin=map.get(username);
		String _username=admin.username;
		String _password=admin.password;
		if(_username.equals(username)) {
			
			if(password.equals(_password)) {
				
				return 2;
				
			}else {
				return 3;
				
			}
		}
	
	}else {
		
		return 4;
		
	}
			return 0;	
	}

	@Override
	public void write1() {
		OutputStream os = null;
		ObjectOutputStream oos = null;
		
		try {
			os = new FileOutputStream("D:/practice/text2.txt");
			oos = new ObjectOutputStream(os);
			oos.writeObject(map);
			}catch (FileNotFoundException e) {
				// TODO: handle exception
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					if (oos != null) {
						oos.close();
					}
					if (oos != null) {
						os.close();
					}
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			}

	public HashMap<String, Admin> read1() {
		InputStream is = null;
		ObjectInputStream ois = null;	
		try {
			is = new FileInputStream("D:/practice/text2.txt");
			ois = new ObjectInputStream(is);
				Object o;
					o = ois.readObject();
					if(o instanceof Map) {
						@SuppressWarnings("unchecked")
						Map<String, Admin> s = (Map<String, Admin>)o;
						map = s;
						return (HashMap<String, Admin>) map;
					}
					} catch (FileNotFoundException e) {
					// TODO: handle exception
					e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					 }catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
			}finally {
				try {
					if (ois != null) {
						ois.close();
					}
					if (is != null) {
						is.close();
					}
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		return null;
	}
	@Override
	 public int register(String username,String password) {
		
		if(username==null||username.equals("")) {
			return 1;	//用户名或密码不能为空
		}
		
		if(password==null||password.equals("")) {
			return 1;	//用户名或密码不能为空
		}
			if(isusernameexists(username)) {
				return 2;	//用户名已存在
			}else {
				Admin admin = new Admin(username, password);
				map.put(username, admin);	
						return 3;  //注册成功
		}	 
	 }
}
