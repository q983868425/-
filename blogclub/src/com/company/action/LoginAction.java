package com.company.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.bean.User;
import com.company.service.IUserService;
import com.company.service.impl.UserServiceImpl;

/**
 * @category 登录控制器
 */
@WebServlet("/login.action")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginAction() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		IUserService userService = new UserServiceImpl();

		// 接收用户输入的验证码
		String captcha = request.getParameter("captcha");
		// 判断验证码是否正确
		String sessionCaptcha = request.getSession().getAttribute("simpleCaptcha").toString();
		if (captcha.equals(sessionCaptcha)) {
			String name = request.getParameter("name");
			String pass = request.getParameter("pass");
			User user = userService.findByName(name, pass);
			if (user != null) {
				HttpSession session = request.getSession();
				session.setAttribute("current_user", user);
				session.setMaxInactiveInterval(60 * 10);
				response.sendRedirect("index.html");
			} else {
				response.sendRedirect("login.jsp");
			}
		}else{
			System.out.println("验证码错误");
			String mess = "验证码错误";
			request.setAttribute("mess", mess);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
