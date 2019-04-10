package com.zhxg.servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhxg.studentservice.StudentBiz;
import com.zhxg.studentservice.impl.StudentBizImpl;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
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
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		StudentBiz studentBiz = StudentBizImpl.getStudentBizImpl();
		request.setAttribute("key",studentBiz.read());
		try {
			String str = request.getParameter("id");
			int id = Integer.parseInt(str);
			boolean a = studentBiz.deleteStudent(id);
			if(a) {
				request.setAttribute("msg1", "删除陈功");
				request.getRequestDispatcher("/deleteStudent.jsp").forward(request, response);
			}else {
				request.setAttribute("msg", "此id不存在,删除失败");
				request.getRequestDispatcher("/deleteStudent.jsp").forward(request, response);
			}
		} catch (NumberFormatException e) {
			request.setAttribute("msg", "非法输入");
			request.getRequestDispatcher("/deleteStudent.jsp").forward(request, response);
		}

			studentBiz.write();
	}
	
}
