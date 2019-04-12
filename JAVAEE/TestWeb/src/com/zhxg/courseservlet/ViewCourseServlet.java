package com.zhxg.courseservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zhxg.courseservice.CourseBiz;
import com.zhxg.courseservice.impl.CourseBizImpl;
import com.zhxg.pojo.Admin;
import com.zhxg.studentservice.StudentBiz;
import com.zhxg.studentservice.impl.StudentBizImpl;

/**
 * Servlet implementation class ViewCourseServlet
 */
@WebServlet("/ViewCourseServlet")
public class ViewCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewCourseServlet() {
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
		
		CourseBiz courseBiz = CourseBizImpl.getCourseBizImpl();
		request.setAttribute("key",courseBiz.read());
		request.setAttribute("course",courseBiz.viewCourse()); 
		request.getRequestDispatcher("/viewCourse.jsp").forward(request,response);

	}

}
