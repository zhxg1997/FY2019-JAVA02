package com.zhxg.studentservice.impl;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import com.zhxg.pojo.Student;
import com.zhxg.studentservice.StudentBiz;

public class StudentBizImpl implements StudentBiz{
	
	public static StudentBizImpl studentBizImpl; 
	
		 private Map<Integer,Student> map = new HashMap<Integer,Student>();

	private StudentBizImpl() {
		
	}
	public synchronized static StudentBizImpl getStudentBizImpl() {
		if(studentBizImpl == null) {
			studentBizImpl = new StudentBizImpl();
		}
			return studentBizImpl;	
	}
	 public HashMap<Integer, Student> viewStudent() {
			
			return (HashMap<Integer, Student>) map;	
	 }
		public boolean isidrepeat(int id) {
			
			return map.containsKey(id);	
		}
		public int  changeStudent(int id,int age,String name,String sex,String class1,int scores,String date1,String date2)  {
				if(isidrepeat(id)) {
					Student student = new Student(id, age, name, sex, class1, scores, date1,date2);
					map.put(id, student);
					return 1;    //修改成功
				}else {
					return 2;    //id不存在
				}				
		}
	 public int addStudent(int id,int age,String name,String sex,String class1,int scores,String date1,String date2) {
		 if(isidrepeat(id)) {
				return 1;    //id已存在
			}else {
				Student student = new Student(id, age, name, sex, class1, scores, date1, date2);
				map.put(id, student);
				return 2;    //添加成功
			}
	}
	public boolean deleteStudent(int id)  {
		 if(isidrepeat(id)) {
			 	map.remove(id);
				return true;    //删除成功
			}else {

				return false;    //删除失败
			}
	}
	public void write() {
		OutputStream os = null;
		ObjectOutputStream oos = null;
		try {
			os = new FileOutputStream("D:/practice/text1.txt");
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
	public HashMap<Integer, Student> read() {
		InputStream is = null;
		ObjectInputStream ois = null;
		
		try {
			is = new FileInputStream("D:/practice/text1.txt");
			ois = new ObjectInputStream(is);
				Object o;
					o = ois.readObject();
					if(o instanceof Map) {
						@SuppressWarnings("unchecked")
						Map<Integer,Student> s = (Map<Integer, Student>)o;
						map = s;
						return (HashMap<Integer, Student>) map;
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
		public boolean view(int id) {
			 if(isidrepeat(id)) {
				 	
					return true;    
				}else {

					return false;    
				}
		}
}
