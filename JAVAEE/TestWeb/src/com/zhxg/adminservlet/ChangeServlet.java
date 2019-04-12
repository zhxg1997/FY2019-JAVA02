package com.zhxg.adminservlet;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zhxg.pojo.Admin;
import com.zhxg.studentservice.StudentBiz;
import com.zhxg.studentservice.impl.StudentBizImpl;

/**
 * Servlet implementation class ChangeServlet
 */
@WebServlet("/adminlogin/ChangeServlet")
public class ChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeServlet() {
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
		try {
			String str = request.getParameter("id");
			int id = Integer.parseInt(str);
			String name = request.getParameter("name");
			String sex = request.getParameter("sex");
			String str1 = request.getParameter("age");
			int age = Integer.parseInt(str1);
			String class1 = request.getParameter("class1");
			String str2 = request.getParameter("scores");
			int scores = Integer.parseInt(str2);
			Date date = new Date(System.currentTimeMillis());
	        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        String date2  = format.format(date);
	        String date1 = studentBiz.viewStudent().get(id).date1;
				if(studentBiz.changeStudent(id, age, name, sex, class1, scores,date1, date2) == 2) {
					request.setAttribute("msg", "id不存在，重新输入");
					request.getRequestDispatcher("/changeStudent.jsp").forward(request, response);
				}else {
					studentBiz.changeStudent(id, age, name, sex, class1, scores,date1, date2);
					request.setAttribute("msg1", "修改成功");
					request.getRequestDispatcher("/changeStudent.jsp").forward(request, response);
				}
		} catch (NumberFormatException e) {
			request.setAttribute("msg", "非法输入");
			request.getRequestDispatcher("/changeStudent.jsp").forward(request, response);
		}
		

		studentBiz.write();
	}

}
