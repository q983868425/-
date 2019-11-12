package com.company.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.service.ICityService;
import com.company.service.ICommentService;
import com.company.service.impl.CommentServiceImpl;
import com.company.vo.BlogVO;
import com.company.vo.CommentVO;

import net.sf.json.JSONObject;

/**
 * 评论控制器 type 1 查询 2 保存 3删除
 */
@WebServlet("/comment.action")
public class CommentAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CommentAction() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 创建业务逻辑对象
		ICommentService commentService = new CommentServiceImpl();
		// 接收博客id，type
		String type = request.getParameter("type");
		String bidStr = request.getParameter("bid");
		// 创建json
		JSONObject json = new JSONObject();
		boolean flag = false;
		// 判断type
		if (type.equals("1")) {
			// 调用业务逻辑对象的方法根据博客id查询此博客的评论
			List<CommentVO> list = commentService.find(Integer.valueOf(bidStr));
			// 将返回集合放入json
			json.put("list", list);
		} else if (type.equals("2")) {
			String uid = request.getParameter("uid");
			String content = request.getParameter("content");
			String ip = request.getRemoteAddr();
			flag = commentService.save(Integer.valueOf(uid), Integer.valueOf(bidStr), content, ip);
			// 将返回值放入json
			json.put("flag", flag);
		} else {
			String id = request.getParameter("cid");
			// 调用业务逻辑对象的方法根据博客id删除此博客的评论
			flag = commentService.delete(Integer.valueOf(id));
			// 将返回值放入json
			json.put("flag", flag);
		}
		// 将json传出
		response.getWriter().print(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
