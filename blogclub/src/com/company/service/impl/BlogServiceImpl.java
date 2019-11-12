package com.company.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.junit.Test;

import com.company.bean.Blog;
import com.company.bean.BlogKind;
import com.company.dao.IBlogDao;
import com.company.service.IBlogService;
import com.company.util.VOUtil;
import com.company.vo.BlogVO;
import com.sun.jmx.snmp.Timestamp;

public class BlogServiceImpl implements IBlogService {
	//IBlogDao blogdao = new BlogDaoImpl();
	IBlogDao blogdaoMyBatis = DataConnetor.getSqlSession().getMapper(IBlogDao.class);

	@Test
	public void t1() {
		System.out.println(findList());
	}

	@Override
	public List<BlogVO> findList() {
		List<BlogVO> list = new ArrayList<BlogVO>();
		List<Blog> blogs = blogdaoMyBatis.findList();
		list = VOUtil.getBlogVO(blogs);
		return list;
	}

	@Override
	public List<BlogVO> findHotList() {
		List<BlogVO> list = new ArrayList<BlogVO>();
		List<Blog> blogs = blogdaoMyBatis.findHotList();
		list = VOUtil.getBlogVO(blogs);
		return list;
	}

	@Override
	public List<BlogVO> findIndexList() {
		List<BlogVO> list = new ArrayList<BlogVO>();
		List<Blog> blogs = blogdaoMyBatis.findIndexList();
		list = VOUtil.getBlogVO(blogs);
		return list;
	}

	@Override
	public List<BlogVO> findListByUserId(int uid) {
		List<BlogVO> list = new ArrayList<BlogVO>();
		List<Blog> blogs = blogdaoMyBatis.findListByUserId(uid);
		list = VOUtil.getBlogVO(blogs);
		return list;
	}

	@Override
	public List<BlogVO> findKindList(int kid) {
		List<BlogVO> list = new ArrayList<BlogVO>();
		List<Blog> blogs = blogdaoMyBatis.findKindList(kid);
		list = VOUtil.getBlogVO(blogs);
		return list;
	}

	@Override
	public Blog find(int id) {
		return blogdaoMyBatis.find(id);
	}

	@Override
	public boolean delete(int id) {

		return blogdaoMyBatis.delete(id) > 0 ? true : false;
	}

	@Override
	public boolean update(int id, int kid, int uid, String title, String schema, String content) {
		Blog blog = blogdaoMyBatis.find(id);
		return blogdaoMyBatis.update(blog) > 0 ? true : false;
	}

	@Override
	public boolean saveBlog(int kid, int uid, String title, String schema, String content) {
		Blog blog = new Blog(kid, uid, title, schema, content,new java.sql.Timestamp(System.currentTimeMillis()));
		return blogdaoMyBatis.add(blog) > 0 ? true : false;
	}

}
