package com.zhxg.studentservlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zhxg.adminservice.AdminBiz;
import com.zhxg.adminservice.impl.AdminBizImpl;
import com.zhxg.pojo.Admin;
import com.zhxg.pojo.Course;
import com.zhxg.pojo.Student;
import com.zhxg.studentservice.StudentBiz;
import com.zhxg.studentservice.impl.StudentBizImpl;

/**
 * Servlet implementation class Student1Servlet
 */
@WebServlet("/Student1Servlet")
public class Student1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Student1Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String method=request.getParameter("method");
		if("regist".equals(method)){
			//调用注册功能
			this.register(request, response);
		}else if("login".equals(method)){
			//调用登录功能
			this.login(request, response);
		}
	}
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentBiz studentBiz = StudentBizImpl.getStudentBizImpl();
		request.setAttribute("key",studentBiz.read1());
		String username = request.getParameter("username");
		String password = request.getParameter("password");

			if(studentBiz.login(username, password) == 2) {
				
				HttpSession session = request.getSession();
				session.getId();
				Student student = new Student(username, password);
				session.setAttribute("user1", student);
				session.setAttribute("cart" ,new ArrayList<Course>());
				request.getRequestDispatcher("/main1.jsp").forward(request, response);
			}else if(studentBiz.login(username, password) == 3){
				request.setAttribute("msg", "用户名或密码不匹配，请重新输入");
				request.getRequestDispatcher("/login1.jsp").forward(request, response);
			}else if(studentBiz.login(username, password) == 1){
				request.setAttribute("msg", "用户名或密码不能为空");
				request.getRequestDispatcher("/login1.jsp").forward(request, response);
			}else {
				request.setAttribute("msg", "用户名不存在");
				request.getRequestDispatcher("/login1.jsp").forward(request, response);
			}
	}
	public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentBiz studentBiz = StudentBizImpl.getStudentBizImpl();
		request.setAttribute("key",studentBiz.read1());
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		int issucess = studentBiz.register(username, password);
			if(issucess == 3) {
				request.setAttribute("msg1", "注册成功");
				request.getRequestDispatcher("/register1.jsp").forward(request, response);
				
			}else if(issucess == 1){
				request.setAttribute("msg", "用户名或密码不能为空");
				request.getRequestDispatcher("/register1.jsp").forward(request, response);
			}else if(issucess == 2){
				request.setAttribute("msg", "用户名已存在");
				request.getRequestDispatcher("/register1.jsp").forward(request, response);
			}
			
		studentBiz.write1();
	}

}
