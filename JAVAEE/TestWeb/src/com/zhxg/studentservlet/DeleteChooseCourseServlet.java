package com.zhxg.studentservlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zhxg.pojo.Course;

/**
 * Servlet implementation class DeleChooseServlet
 */
@WebServlet("/DeleteChooseCourseServlet")
public class DeleteChooseCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteChooseCourseServlet() {
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
		String id = request.getParameter("cid");
		try {
			int cid = Integer.parseInt(id);
			for(int i = 0;i< cart.size();i++) {
				if(cart.get(i).cid == cid) {
					cart.remove(i);
					request.setAttribute("msg1", "删除成功");
					request.getRequestDispatcher("/deleteChooseCourse.jsp").forward(request, response);
					break;
				}else {
					continue;
				}
			}
			request.setAttribute("msg", "没有选此课程");
			request.getRequestDispatcher("/deleteChooseCourse.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("msg", "非法输入");
			request.getRequestDispatcher("/deleteChooseCourse.jsp").forward(request, response);
		}
		
	}

}
