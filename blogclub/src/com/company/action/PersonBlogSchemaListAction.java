package com.company.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.bean.User;
import com.company.service.IBlogService;
import com.company.service.IUserService;
import com.company.service.impl.BlogServiceImpl;
import com.company.service.impl.UserServiceImpl;
import com.company.vo.BlogVO;

/**
 * Servlet implementation class PersonBlogSchemaListAction
 */
@WebServlet("/personblogschemalist.action")
public class PersonBlogSchemaListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PersonBlogSchemaListAction() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 创建业务逻辑对象
		IBlogService blogService = new BlogServiceImpl();
		IUserService userService = new UserServiceImpl();
		// 获取博客作者ID
		String uidStr = request.getParameter("uid");
		if (uidStr != null && !uidStr.equals("")) {
			User user = userService.find(uidStr);
			// 调用业务逻辑对象查询数据
			List<BlogVO> blogVoList = blogService.findListByUserId(user.getId());
			if (user != null) {
				// 将返回值放入作用域中
				request.setAttribute("blogVoList", blogVoList);
				request.setAttribute("user", user);
				// 转发
				request.getRequestDispatcher("personblogschemalist.jsp").forward(request, response);
			} else {
				response.sendRedirect("404.jsp");
			}

		} else {
			response.sendRedirect("404.jsp");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
