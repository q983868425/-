package com.company.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.company.bean.Blog;
import com.company.bean.Comment;
import com.company.dao.ICityDao;
import com.company.dao.ICommentDao;
import com.company.service.ICommentService;
import com.company.util.VOUtil;
import com.company.vo.BlogVO;
import com.company.vo.CommentVO;

public class CommentServiceImpl implements ICommentService {
	//ICommentDao commentdao = new CommentDaoImpl();
	ICommentDao commentdao = DataConnetor.getSqlSession().getMapper(ICommentDao.class);

	@Test
	public void test() {
		System.out.println(save(4, 4, "asdf", "sadf"));
	}

	@Override
	public boolean save(int uid, int bid, String content, String ip) {
		Comment comment = new Comment(uid, bid, ip, new Timestamp(System.currentTimeMillis()), content);
		return commentdao.save(comment) > 0 ? true : false;
	}

	@Override
	public boolean delete(int id) {

		return commentdao.delete(id) > 0 ? true : false;
	}

	@Override
	public List<CommentVO> find(int blogId) {
		List<CommentVO> list = new ArrayList<CommentVO>();
		List<Comment> comments = commentdao.find(blogId);
		list = VOUtil.getCommentVO(comments);
		return list;
	}

}
