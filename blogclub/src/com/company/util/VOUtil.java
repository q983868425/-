package com.company.util;

import java.lang.Character.UnicodeBlock;
import java.util.ArrayList;
import java.util.List;

import com.company.bean.Blog;
import com.company.bean.BlogKind;
import com.company.bean.Comment;
import com.company.bean.User;
import com.company.dao.IBlogDao;
import com.company.dao.IBlogKindDao;
import com.company.dao.IUserDao;
import com.company.service.impl.DataConnetor;
import com.company.vo.BlogVO;
import com.company.vo.CommentVO;

/**
 * @author 张延龙 @category
 */
public class VOUtil {
	static IBlogDao blogdaoMyBatis = DataConnetor.getSqlSession().getMapper(IBlogDao.class);
	//static IUserDao userDao = new UserDaoImpl();
	static IUserDao userDaoMyBatis = DataConnetor.getSqlSession().getMapper(IUserDao.class);
	static IBlogKindDao blogKindDaoMyBatis = DataConnetor.getSqlSession().getMapper(IBlogKindDao.class);
	public static List<BlogVO> getBlogVO(List<Blog> blogs) {
		List<BlogVO> list = new ArrayList<BlogVO>();
		for (Blog blog : blogs) {
			BlogVO blogVO = new BlogVO();
			blogVO.setId(blog.getId());
			blogVO.setKid(blog.getKid());
			blogVO.setUid(blog.getUid());
			blogVO.setTitle(blog.getTitle());
			blogVO.setSchema(blog.getSchema());
			blogVO.setContent(blog.getContent());
			blogVO.setClicks(blog.getClicks());
			blogVO.setDatetime(blog.getDatetime());
			User user = userDaoMyBatis.findById(blog.getUid());
			blogVO.setUserName(user.getName());
			BlogKind blogKind = blogKindDaoMyBatis.find(blog.getKid());
			blogVO.setBlogKindName(blogKind.getName());
			list.add(blogVO);
		}
		return list;
	}

	public static List<CommentVO> getCommentVO(List<Comment> comments) {
		List<CommentVO> list = new ArrayList<CommentVO>();
		for (Comment comment : comments) {
			Blog blog = blogdaoMyBatis.find(comment.getBid());
			User user = userDaoMyBatis.findById(comment.getUid());
			CommentVO commentVO = new CommentVO(comment.getId(), comment.getUid(), comment.getBid(), comment.getIp(),
					comment.getDatetime(), comment.getContent(), user.getName(), blog.getTitle());
			list.add(commentVO);
		}
		return list;
	}
}
