package com.company.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.service.IUserService;
import com.company.service.impl.UserServiceImpl;

/**
 * 注册重名校验控制器
 */
@WebServlet("/check.action")
public class CheckAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CheckAction() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 创建业务逻辑对象
		IUserService userService = new UserServiceImpl();
		// 接收ajax传入的用户输入的用户名
		String name = request.getParameter("name");
		// 调用业务逻辑对象的查询方法校验名称是否存在
		boolean flag = userService.findByUserName(name);
		// 将校验结果放入response的输出流中
		response.getWriter().print(flag);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
