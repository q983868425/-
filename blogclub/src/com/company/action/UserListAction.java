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
 * @category 用户列表控制器
 */
@WebServlet("/userlist.action")
public class UserListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserListAction() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 安全验证
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("current_user");
		if (obj != null) {
			User user = (User) obj;
			if (user.getId() == 1) {
				// 创建用户业务逻辑
				IUserService userService = new UserServiceImpl();
				// 获取用户列表，不包含管理员本身
				List<User> userList = userService.findUserList();
				// 将用户列表放入作用域中
				request.setAttribute("userList", userList);
				// 转发
				request.getRequestDispatcher("userlist.jsp").forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
