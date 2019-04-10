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
 * Servlet implementation class SessionServlet
 */
@WebServlet("/SessionServlet")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionServlet() {
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
		HttpSession session=request.getSession();
		session.getAttribute("username");
		session.getAttribute("password");
		Cookie[] cookies=request.getCookies();
		String username=null;
		String password=null;
		if(cookies!=null) {
			
			for(int i=0;i<cookies.length;i++) {
				Cookie cookie=cookies[i];
				String cookie_name=cookie.getName();
				String cookie_value=cookie.getValue();
				if(cookie_name.equals("username")) {
					username=cookie_value;
				}
				if(cookie_name.equals("password")) {
					password=cookie_value;
				}
				
			}
			
		}
			if(username!=null&&password!=null) {
				AdminBiz adminBiz = AdminBizImpl.getAdminBizImpl();
				request.setAttribute("key",adminBiz.read1());
				int issucess = adminBiz.login(username, password);
				if(issucess == 2) {

					request.getRequestDispatcher("/main.html").forward(request, response);
					
				}else{

					request.getRequestDispatcher("/login.jsp").forward(request, response);
				}

		}else {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}
			

}
