<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8" />
<title></title>
<!-- 引入 Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
<script src="js/jquery.js"></script>
<!-- 包括所有已编译的插件 -->
<script src="js/bootstrap.min.js"></script>
<link href="css/style.css" rel="stylesheet" />
</head>

<body>
	<!-- 引入导航栏 -->
	<c:import url="header.jsp"></c:import>
	<!-- 内容模块1 -->
	<div class="d2 allwidth">
		<!--用户信息-->
		<div id="userinfo" class="templatemo-container userinfo">
			<ul>
				<li>
					<span class="glyphicon glyphicon-user">：${user.name}</span>
				</li>
				<li>
					<span class="glyphicon glyphicon-tree-conifer">：</span>
					<c:if test="${user.sex!='f'}">♂</c:if>
					&nbsp;
					<c:if test="${user.sex=='f'}">♀</c:if>
				</li>
				<li>
					<span class="glyphicon glyphicon-circle-arrow-right">：</span>${current_user.age}</li>
				<li>
					<span class="glyphicon glyphicon-earphone">：${current_user.tel}</span>
				</li>
				<c:if test="${current_user != null }">
					<li>
						<a href="showbloglist.action?type=1&uid=${current_user.id }">click me into my blog</a>
					</li>
					<li>
						<a href="blogcreate.jsp">create blog</a>
					</li>
				</c:if>
			</ul>
		</div>
		<!--用户博客概要列表-->
		<div class="schemalist">
			<table class="table table-hover bloglist">
				<tr class="personbloginfo_tr">
					<th style="width: 10%;">作者</th>
					<th>标题</th>
					<th>时间</th>
				</tr>
				<!--要循环的博客概要-->
				<c:forEach items="${blogVoList }" var="blogVO">
					<tr class="personbloginfo_tr">
						<td class="line">
							<a href="showbloglist.action?type=1&uid=${blog.uid }">${blogVO.userName }</a>
						</td>
						<td class="line">
							<span class="schema_title">
								<a href="bloginfo.action?id=${blogVO.id }">${blogVO.title }</a>
							</span>
						</td>
						<td class="line">
							<span class="schema_time">
								时间：
								<fmt:formatDate pattern="yyyy/MM/dd" value="2019-05-15" />
								2019-05-15
							</span>
							<c:if test="${blogVO.uid==current_user.id }">
								<span class="blogedit">
									<a onclick="delete_blog(${blog.id })">删除</a>
									&nbsp;|&nbsp;
									<a href="editblog.action?type=2&id=${blog.id }">编辑</a>
								</span>
							</c:if>
						</td>
					</tr>
					<tr class="personbloginfo_tr">
						<td class="layout" colspan="3">
							<a href="showbloginfo.action?id=${blog.id }"> ${blogVO.schema } </a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<!-- 脚部 -->
	<footer class="footer ">
		<div class="container allwidth">
			<div class="row footer-top">
				<div class="col-md-6 col-lg-6">
					<h3>博客园</h3>
					<p>我们一直致力于为广大开发者提供更多的优质技术文档和辅助开发工具！</p>
				</div>
				<div class="col-md-6  col-lg-5 col-lg-offset-1">
					<div class="row about">
						<div class="col-sm-3">
							<h4>关于</h4>
							<ul class="list-unstyled">
								<li>
									<a href="/about/">关于我们</a>
								</li>
								<li>
									<a href="/ad/">广告合作</a>
								</li>
								<li>
									<a href="/links/">友情链接</a>
								</li>
								<li>
									<a href="/hr/">招聘</a>
								</li>
							</ul>
						</div>
						<div class="col-sm-3">
							<h4>联系方式</h4>
							<ul class="list-unstyled">
								<li>
									<a href="http://weibo.com/bootcss" title="Bootstrap中文网官方微博" target="_blank">新浪微博</a>
								</li>
								<li>
									<a href="mailto:admin@bootcss.com">电子邮件</a>
								</li>
							</ul>
						</div>
						<div class="col-sm-4">
							<h4>旗下网站</h4>
							<ul class="list-unstyled">
								<li>
									<a href="http://www.golaravel.com/" target="_blank">Laravel中文网</a>
								</li>
								<li>
									<a href="http://www.ghostchina.com/" target="_blank">Ghost中国</a>
								</li>
								<li>
									<a href="http://www.bootcdn.cn/" target="_blank">BootCDN</a>
								</li>
								<li>
									<a href="https://pkg.phpcomposer.com/" target="_blank">Packagist中国镜像</a>
								</li>
								<li>
									<a href="https://www.return.net/" target="_blank">燃腾教育</a>
								</li>
							</ul>
						</div>
						<div class="col-sm-2">
							<h4>赞助商</h4>
							<ul class="list-unstyled">
								<li>
									<a href="http://www.maoyun.tv/" target="_blank">猫云</a>
								</li>
								<li>
									<a href="https://www.jdcloud.com/" target="_blank">京东云</a>
								</li>
								<li>
									<a href="https://www.upyun.com" target="_blank">又拍云</a>
								</li>
							</ul>
						</div>
					</div>

				</div>
			</div>
			<hr>
			<div class="row footer-bottom">
				<ul class="list-inline text-center">
					<li>
						<a href="http://www.miibeian.gov.cn/" target="_blank">京ICP备11008151号</a>
					</li>
					<li>京公网安备11010802014853</li>
				</ul>
			</div>
		</div>
	</footer>
	<!-- 脚部结束 -->
</body>

</html>