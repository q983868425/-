<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		<h1>用户列表</h1>
		<table class="table table-hover">
			<caption>基本的表格布局</caption>
			<tr>
				<th>编号</th>
				<th>姓名</th>
				<th>性别</th>
				<th>年龄</th>
				<th>电话号码</th>
				<th>地址</th>
				<th>注册时间</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${userList }" var="user">
				<tr>
					<td><a href="#">${user.id }<a></td>
					<td><a href="personblogschemalist.action?uid=${user.id }">作者：${user.name }</a></td>
					<td>${user.sex }</td>
					<td>${user.age }</td>
					<td>${user.tel }</td>
					<td>陕西省-西安市-雁塔区</td>
					<td>${user.inputdate }</td>
					<td><a href="usereditor.action?type=1&id=${user.id }">删除</a>&nbsp;&nbsp;<a href="#">编辑</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<!-- 引入底部信息 -->
	<c:import url="footer.jsp"></c:import>
</body>

</html>