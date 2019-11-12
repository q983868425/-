package com.company.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.company.bean.BlogKind;
import com.company.service.IBlogKindService;
import com.company.service.impl.BlogKindServiceImpl;

/**
 * Application Lifecycle Listener implementation class KindListener
 *
 */
@WebListener
public class KindListener implements ServletContextListener {

	public KindListener() {
	}

	public void contextDestroyed(ServletContextEvent event) {
	}

	public void contextInitialized(ServletContextEvent event) {
		// 创建业务逻辑对象
		IBlogKindService blogKindService = new BlogKindServiceImpl();
		// 获取application
		ServletContext application = event.getServletContext();
		// 获取博客类型集合列表
		List<BlogKind> blogKindList = blogKindService.findList();
		// 将博客列表放入application作用域中
		application.setAttribute("blogKindList", blogKindList);
	}

}
