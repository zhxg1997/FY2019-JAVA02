package com.zhxg.courseservice.impl;

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
import com.zhxg.courseservice.CourseBiz;
import com.zhxg.pojo.Course;
public class CourseBizImpl implements CourseBiz{

	public static CourseBizImpl courseBizImpl; 
	private	Map<Integer, Course> map=new HashMap<Integer, Course>();
	 private CourseBizImpl() {
		 	
	 }
	 public synchronized static CourseBizImpl getCourseBizImpl() {
			if(courseBizImpl == null) {
				courseBizImpl = new CourseBizImpl();
			}
				return courseBizImpl;	
		}
	@Override
	public int changeCourse(int cid, String cname) {
		// TODO Auto-generated method stub
		if(isidrepeat(cid)) {
			Course course = new Course(cid, cname);
			map.put(cid, course);
			return 1;    //修改成功
		}else {
			return 2;    //id不存在
		}
	}
	@Override
	public boolean isidrepeat(int cid) {
		// TODO Auto-generated method stub
		return map.containsKey(cid);	
	}
	@Override
	public int addCourse(int cid, String cname) {
		// TODO Auto-generated method stub
		if(isidrepeat(cid)) {
			return 1;    //id已存在
		}else {
			Course course = new Course(cid, cname);
			map.put(cid, course);
			return 2;    //添加成功
		}
	}
	@Override
	public boolean deleteCourse(int cid) {
		// TODO Auto-generated method stub
		if(isidrepeat(cid)) {
		 	map.remove(cid);
			return true;    //删除成功
		}else {

			return false;    //删除失败
		}
	}
	@Override
	public HashMap<Integer, Course> viewCourse() {
		// TODO Auto-generated method stub
		 return (HashMap<Integer, Course>) map;
	}
	@Override
	public void write() {
		OutputStream os = null;
		ObjectOutputStream oos = null;
		try {
			os = new FileOutputStream("D:/practice/text3.txt");
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
	@Override
	public HashMap<Integer, Course> read() {
		InputStream is = null;
		ObjectInputStream ois = null;
		
		try {
			is = new FileInputStream("D:/practice/text3.txt");
			ois = new ObjectInputStream(is);
				Object o;
					o = ois.readObject();
					if(o instanceof Map) {
						@SuppressWarnings("unchecked")
						Map<Integer,Course> s = (Map<Integer, Course>)o;
						map = s;
						return (HashMap<Integer, Course>) map;
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
	 
	 
	 
	 
}
