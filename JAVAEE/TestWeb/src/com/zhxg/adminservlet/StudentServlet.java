package com.zhxg.adminservlet;

import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zhxg.pojo.Student;
import com.zhxg.studentservice.StudentBiz;
import com.zhxg.studentservice.impl.StudentBizImpl;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/adminlogin/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
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
		

			StudentBiz studentBiz = StudentBizImpl.getStudentBizImpl();
			request.setAttribute("key",studentBiz.read());
			request.setAttribute("user",studentBiz.viewStudent()); 
			request.getRequestDispatcher("/viewStudent.jsp").forward(request,response);

	}

}
