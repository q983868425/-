package com.company.service.impl;

import java.util.List;

import org.junit.Test;

import com.company.bean.Blog;
import com.company.bean.User;
import com.company.dao.IBlogDao;
import com.company.dao.ICommentDao;
import com.company.dao.IUserDao;
import com.company.service.IUserService;
import com.sun.swing.internal.plaf.basic.resources.basic;

public class UserServiceImpl implements IUserService {
	IUserDao userDaoMyBatis = DataConnetor.getSqlSession().getMapper(IUserDao.class);
	IBlogDao blogdaoMyBatis = DataConnetor.getSqlSession().getMapper(IBlogDao.class);
	ICommentDao commentDao = DataConnetor.getSqlSession().getMapper(ICommentDao.class);

	@Test
	public void test() {
		System.out.println(delete("4"));
	}

	@Override
	public User find(String id, String pass) {
		User user = null;
		if (id != null && pass != null) {
			user = userDaoMyBatis.find(Integer.valueOf(id), pass);
		}
		return user;
	}

	@Override
	public User findByName(String name, String pass) {
		User user = null;
		if (name != null && pass != null) {
			user = userDaoMyBatis.findByNamePass(name, pass);
		}
		return user;
	}

	@Override
	public boolean add(User user) {

		return userDaoMyBatis.add(user) > 0 ? true : false;
	}

	@Override
	public List<User> findUserList() {

		return userDaoMyBatis.findUserList();
	}

	@Override
	public boolean delete(String id) {
		boolean flag = false;
		if (id != null && !id.equals("")) {
			int userId = Integer.valueOf(id);
			// 根绝userID得到所有该用户 的所有博客
			List<Blog> blogs = blogdaoMyBatis.findListByUserId(userId);
			for (Blog blog : blogs) {
				// 删除博客下的所有评论
				commentDao.deleteByBlogId(blog.getId());
				// 删除博客
				blogdaoMyBatis.delete(blog.getId());
			}
			// 删除该用户所有的评论
			commentDao.deleteByUserId(userId);

			int i = userDaoMyBatis.delete(Integer.valueOf(id));
			if (i > 0) {
				flag = true;
			}
		}
		return flag;
	}

	@Override
	public User find(String id) {

		return userDaoMyBatis.findById(Integer.valueOf(id));
	}

	@Override
	public boolean update(User user) {

		return userDaoMyBatis.update(user) > 0 ? true : false;
	}

	@Override
	public boolean findByUserName(String name) {
		if (userDaoMyBatis.findByUserName(name) == null) {
			return true;
		} else
			return false;
	}
}
