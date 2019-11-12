<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8" />
<title></title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<link href="css/style.css" rel="stylesheet" />
</head>

<body>
	<!-- 引入导航栏 -->
	<c:import url="header.jsp"></c:import>
	<!-- 内容模块1 -->
	<div class="d2 allwidth">
		<h1>博客列表</h1>
		<table class="table table-hover">
			<caption>基本的表格布局</caption>
			<tr>
				<th>作者</th>
				<th>标题</th>
				<th>类型</th>
				<th>发表时间</th>
				<th>浏览量</th>
			</tr>
			<c:forEach items="${blogVoList }" var="blogVO">
				<tr>
					<td><a href="personblogschemalist.action?uid=${blogVO.uid }">作者：${blogVO.userName }</a></td>
					<td><a href="bloginfo.action?id=${blogVO.id }">标题：${blogVO.title }</a></td>
					<td><a href="#">${blogVO.blogKindName }</a></td>
					<td>${blogVO.datetime }</td>
					<td>${blogVO.clicks }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
	<!-- 脚部 -->
	<c:import url="footer.jsp"></c:import>
	<!-- 脚部结束 -->
</body>

</html>