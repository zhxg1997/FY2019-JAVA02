package com.zhxg.courseservlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
 * Servlet implementation class ChangeCourseServlet
 */
@WebServlet("/adminlogin/ChangeCourseServlet")
public class ChangeCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeCourseServlet() {
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
		try {
			String str = request.getParameter("cid");
			int cid = Integer.parseInt(str);
			String cname = request.getParameter("cname");
			
				if(courseBiz.changeCourse(cid, cname) == 2) {
					request.setAttribute("msg", "id不存在，重新输入");
					request.getRequestDispatcher("/changeCourse.jsp").forward(request, response);
				}else {
					courseBiz.changeCourse(cid, cname);
					request.setAttribute("msg1", "修改成功");
					request.getRequestDispatcher("/changeCourse.jsp").forward(request, response);
				}
		} catch (NumberFormatException e) {
			request.setAttribute("msg", "非法输入");
			request.getRequestDispatcher("/changeCourse.jsp").forward(request, response);
		}
		

		courseBiz.write();
	}

}
