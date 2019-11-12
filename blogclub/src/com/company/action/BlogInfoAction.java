package com.company.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.bean.Blog;
import com.company.service.IBlogService;
import com.company.service.impl.BlogServiceImpl;

/**
 * @category 博客详情控制器
 */
@WebServlet("/bloginfo.action")
public class BlogInfoAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BlogInfoAction() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 创建业务逻辑对象
		IBlogService blogService = new BlogServiceImpl();
		Blog blog = null;
		// 接收博客id
		String idStr = request.getParameter("id");
		// 调用业务逻辑对象的方法根据博客id查询博客
		if (!idStr.equals("") && idStr != null) {
			int id = Integer.valueOf(idStr);
			blog = blogService.find(id);
		}
		// 将返回结果放入作用域
		request.setAttribute("blog", blog);
		// 转发
		request.getRequestDispatcher("bloginfo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
