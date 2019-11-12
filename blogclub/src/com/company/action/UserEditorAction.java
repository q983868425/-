package com.company.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.bean.User;
import com.company.service.IUserService;
import com.company.service.impl.UserServiceImpl;

/**
 * @category 用户删除编辑控制器 type 1 删除 2编辑
 */
@WebServlet("/usereditor.action")
public class UserEditorAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserEditorAction() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 创建业务逻辑对象
		IUserService userService = new UserServiceImpl();
		// 接收type及要删除的用户id或者要编辑的用户详细信息
		String type = request.getParameter("type");
		String idStr = request.getParameter("id");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String age = request.getParameter("age");
		String provinceId = request.getParameter("provinceId");
		
		// 创建flag
		boolean flag = false;
		// 判断type
		if (type.equals("1")) {
			flag = userService.delete(idStr);
			if (flag) {
				response.sendRedirect("userlist.action");
			} else {
				response.sendRedirect("404.jsp");
			}
		} else {
			
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
