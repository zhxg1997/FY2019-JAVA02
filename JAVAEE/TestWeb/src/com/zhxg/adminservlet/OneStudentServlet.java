package com.zhxg.adminservlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.javafx.collections.MappingChange.Map;
import com.zhxg.pojo.Admin;
import com.zhxg.studentservice.impl.StudentBizImpl;

/**
 * Servlet implementation class OneStudentServlet
 */
@WebServlet("/adminlogin/OneStudentServlet")
public class OneStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OneStudentServlet() {
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

		StudentBizImpl studentBiz = StudentBizImpl.getStudentBizImpl();
		request.setAttribute("key",studentBiz.read());
		String str = request.getParameter("id");
try {
	int id = Integer.parseInt(str);

	if(studentBiz.view(id) == false) {
		request.setAttribute("msg", "此id不存在,重新输入");
		request.getRequestDispatcher("/viewStudent1.jsp").forward(request, response);
	}else {
		request.setAttribute("list",studentBiz.viewStudent().get(id));
		request.getRequestDispatcher("/viewStudent1.jsp").forward(request, response);
	}
}catch ( NumberFormatException e) {
	request.setAttribute("msg", "非法输入");
	request.getRequestDispatcher("/viewStudent1.jsp").forward(request, response);
}

	}

}
