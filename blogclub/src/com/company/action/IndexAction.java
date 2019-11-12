package com.company.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.bean.BlogKind;
import com.company.service.IBlogKindService;
import com.company.service.IBlogService;
import com.company.service.impl.BlogKindServiceImpl;
import com.company.service.impl.BlogServiceImpl;
import com.company.vo.BlogVO;

/**
 * @author 张延龙
 * @category 首页控制器
 */
@WebServlet("/index.html")
public class IndexAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public IndexAction() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 创建博客及博客类型的业务逻辑
		IBlogService blogService = new BlogServiceImpl();
		
		// 创建接收集合，调用业务逻辑
		List<BlogVO> hotList = blogService.findHotList();
		List<BlogVO> indexList = blogService.findIndexList();
		// 将主页要展示的内容存入request
		request.setAttribute("hotList", hotList);
		request.setAttribute("indexList", indexList);
		// 转发
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
