package com.company.vo;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.apache.commons.lang.time.DateUtils;

import com.company.bean.Comment;

public class CommentVO {

	/**
	 * 评论编号
	 */
	private int id;
	/**
	 * 评论人编号
	 */
	private int uid;
	/**
	 * 博客编号
	 */
	private int bid;
	/**
	 * 评论时机器ip
	 */
	private String ip;
	/**
	 * 日期
	 */
	private Timestamp datetime;
	/**
	 * 评论内容
	 */
	private String content;
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 博客名称
	 */
	private String blogName;

	/**
	 * 创建时间字符串类型
	 */
	private String dateStr;
	
	public CommentVO() {
		super();
	}

	public CommentVO(int id, int uid, int bid, String ip, Timestamp datetime, String content, String userName,
			String blogName) {
		super();
		this.id = id;
		this.uid = uid;
		this.bid = bid;
		this.ip = ip;
		this.datetime = datetime;
		this.content = content;
		this.userName = userName;
		this.blogName = blogName;
		this.dateStr = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss").format(datetime.getTime());
	}

	public String getBlogName() {
		return blogName;
	}

	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}

	public String getDateStr() {
		return dateStr;
	}

	public void setDateStr(String dateStr) {
		this.dateStr = dateStr;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Timestamp getDatetime() {
		return datetime;
	}

	public void setDatetime(Timestamp datetime) {
		this.datetime = datetime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	
}
