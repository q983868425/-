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
<script type="text/javascript" src="js/comment.js"></script>
</head>

<body>
	<!-- 引入导航栏 -->
	<c:import url="header.jsp"></c:import>

	<!--中间内容部分开始-->
	<div class="container allwidth">
		<h1>blog info</h1>
		<div class="templatemo-container bloginfo">
			<h3 style="font-size: 32px;">${blog.title }</h3>
			<div id="content" class="content">
				<!-- schema -->
				<p>摘要</p>
				${blog.schema }
				<!-- sechma -->
			</div>
			<div id="content" class="content">
				<!-- content -->
				<p>正文</p>
				${blog.content }
				<!-- content_end -->
			</div>
			<!-- 评论开始 -->
			<div class="commentboth" id="commentboth">
				<input type="hidden" value="${current_user.id }"
					id="current_user_id"> <input type="hidden"
					value="${blog.id }" id="blog_id">
				<h5 class="comment_title">文章评论</h5>
				<!-- 需要循环的评论内容 -->
				<div class="comment" id="comment"></div>
				<!-- 循环结束 -->
			</div>
			<!-- 评论结束 -->
			<div class="tocomment">
				<c:if test="${current_user!=null }">
					<span>发表评论</span>
					<textarea id="input_area"></textarea>
					<button class="btn btn-success" onclick="comment_submit()">submit</button>
				</c:if>
				<c:if test="${current_user==null }">
					<span><a href="login.jsp">登录</a>后发表评论</span>
				</c:if>
			</div>
		</div>

	</div>
	<!--内容部分结束-->
	<!-- 底部 -->
	<c:import url="footer.jsp"></c:import>
</body>

</html>