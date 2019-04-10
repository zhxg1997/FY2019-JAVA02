package com.zhxg.servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zhxg.adminservice.AdminBiz;
import com.zhxg.adminservice.impl.AdminBizImpl;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
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
		AdminBiz adminBiz = AdminBizImpl.getAdminBizImpl();
		request.setAttribute("key",adminBiz.read1());
		String username = request.getParameter("username");
		String password = request.getParameter("password");

			if(adminBiz.login(username, password) == 2) {
				Cookie username_cookie = new Cookie("username", username);
				username_cookie.setMaxAge(7*24*3600);
				response.addCookie(username_cookie);
				Cookie password_cookie = new Cookie("password", password);
				password_cookie.setMaxAge(7*24*3600);
				response.addCookie(password_cookie);
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
				session.setAttribute("password", password);
				request.getRequestDispatcher("/main.html").forward(request, response);
				
			}else if(adminBiz.login(username, password) == 3){
				request.setAttribute("msg", "用户名或密码不匹配，请重新输入");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}else if(adminBiz.login(username, password) == 1){
				request.setAttribute("msg", "用户名或密码不能为空");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
			


	}
	public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminBiz adminBiz = AdminBizImpl.getAdminBizImpl();
		request.setAttribute("key",adminBiz.read1());
		String username = request.getParameter("username");
		String password = request.getParameter("password");

	
		int issucess = adminBiz.register(username, password);
			if(issucess == 3) {
				request.setAttribute("msg1", "注册成功");
				request.getRequestDispatcher("/register.jsp").forward(request, response);
				
			}else if(issucess == 1){
				request.setAttribute("msg", "用户名或密码不能为空");
				request.getRequestDispatcher("/register.jsp").forward(request, response);
			}else if(issucess == 2){
				request.setAttribute("msg", "用户名已存在");
				request.getRequestDispatcher("/register.jsp").forward(request, response);
			}
			
		adminBiz.write1();
	}

}
