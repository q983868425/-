package com.company.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.bean.User;
import com.company.dao.IBlogDao;
import com.company.service.IBlogService;
import com.company.service.impl.BlogServiceImpl;

/**
 * @category 创建博客控制器
 */
@WebServlet("/createblog.action")
public class CreateBlogAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CreateBlogAction() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 创建业务逻辑对象
		IBlogService blogService = new BlogServiceImpl();
		// 接收前端数据
		String kidStr = request.getParameter("kind");
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("current_user");
		String title = request.getParameter("title");
		String schema = request.getParameter("schema");
		String content = request.getParameter("content");
		// 调用业务逻辑对象的方法存储数据
		if (obj != null) {
			User user = (User) obj;
			int uid = user.getId();
			int kid = Integer.valueOf(kidStr);
			boolean flag = blogService.saveBlog(kid, uid, title, schema, content);
			if (flag) {
				request.getRequestDispatcher("bloglist.action").forward(request, response);
			} else {
				request.getRequestDispatcher("404.jsp").forward(request, response);
			}
		} else {
			request.getRequestDispatcher("blogcreate.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
