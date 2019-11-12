package com.company.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.service.IBlogService;
import com.company.service.impl.BlogServiceImpl;
import com.company.vo.BlogVO;

@WebServlet("/bloglist.action")
public class BlogListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BlogListAction() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 创建业务逻辑对象
		IBlogService blogService = new BlogServiceImpl();
		//接收博客类型id
		String kidStr = request.getParameter("kid");
		//创建查询结果集合
		List<BlogVO> blogVoList = null;
		//判断博客类型id是否为空，如果为空则查询所有类型，否则根据博客类型id查询
		if (kidStr == null) {
			// 调用业务逻辑对象查询数据
			blogVoList = blogService.findList();
		} else {
			int kid = Integer.valueOf(kidStr);
			blogVoList = blogService.findKindList(kid);
		}
		// 将返回值放入作用域中
		request.setAttribute("blogVoList", blogVoList);
		// 转发
		request.getRequestDispatcher("bloglist.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
