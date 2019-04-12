package com.zhxg.studentservlet;

import java.io.IOException;

import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.zhxg.courseservice.CourseBiz;
import com.zhxg.courseservice.impl.CourseBizImpl;
import com.zhxg.pojo.Course;

/**
 * Servlet implementation class chooseCourseServlet
 */
@WebServlet("/ChooseCourseServlet")
public class ChooseCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChooseCourseServlet() {
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
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		ArrayList<Course> cart=(ArrayList<Course>) session.getAttribute("cart");
		String str = request.getParameter("cid");
		try {
			Integer cid = Integer.parseInt(str);
			//验证id是否存在
			CourseBiz courseBiz = CourseBizImpl.getCourseBizImpl();
			request.setAttribute("key",courseBiz.read());
			if(courseBiz.isidrepeat(cid)) {
				Course course = courseBiz.viewCourse().get(cid);
				String cname = course.cname;
				choose(request, response, cid, cname);

			}else {
				request.setAttribute("msg", "id不存在，重新输入");
				request.getRequestDispatcher("/chooseCourse.jsp").forward(request, response);
			}
		} catch (Exception e) {
			request.setAttribute("msg", "非法输入");
			request.getRequestDispatcher("/chooseCourse.jsp").forward(request, response);
		}
		
	}
	protected void choose(HttpServletRequest request, HttpServletResponse response,int cid,String cname) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		ArrayList<Course> cart=(ArrayList<Course>) session.getAttribute("cart");
		int a =1;
		for(int i = 0;i < cart.size();i++) {
			if(cart.get(i).cid == cid) {
				request.setAttribute("msg", "请勿重复选择");
				request.getRequestDispatcher("/chooseCourse.jsp").forward(request, response);
				a = 2;
			}else {
				continue;
			}
		}
		if(a == 1) {
		cart.add(new Course(cid, cname));
		request.setAttribute("msg1", "添加成功");
		request.getRequestDispatcher("/chooseCourse.jsp").forward(request, response);
		}
	}
	
}
