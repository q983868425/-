<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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

<link rel="stylesheet" href="kindeditor/themes/default/default.css" />
<script charset="utf-8" src="kindeditor/kindeditor-min.js"></script>
<script charset="utf-8" src="kindeditor/lang/zh_CN.js"></script>
<script>
	var editor;
	KindEditor.ready(function(K) {
		editor = K.create('textarea[name="c1"]', {
			allowFileManager : true
		});
	});

	function check() {
		var title = $("#title").val();
		var schema = $("#schema").val();
		var content = editor.html();
		if (title.trim() == "") {
			alert("title must be not null");
			return;
		}
		if (schema.trim() == "") {
			alert("schema must be not null");
			return;
		}
		if (content.trim() == "") {
			alert("content must be not null");
			return;
		}
		$("#c2").val(content);
		if (confirm("save this blog, are you sure?")) {
			$("#form1").submit();
		}
	}
</script>

<link href="css/style.css" rel="stylesheet" />
</head>

<body>
	<!-- 引入导航栏 -->
	<c:import url="header.jsp"></c:import>

	<!--中间内容部分开始-->
	<div class="container allwidth">
		<div class="create">
			<h1>创建博客</h1>
			<form id="form1" action="createblog.action" method="post">
				<input type="hidden" name="type" value="2" />
				<table class="templatemo-container">
					<tr>
						<td>title:<input id="title" type="text" class="form-control"
							name="title" />
						</td>
					</tr>
					<tr>
						<td>kind:<br /> <select class="form-control" id="kind"
							name="kind">
								<c:forEach items="${blogKindList }" var="kind">
									<option value="${kind.id }">${kind.name }</option>
								</c:forEach>
						</select>
						</td>
					</tr>
					<tr>
						<td>schema:<br /> <textarea class="form-control" id="schema"
								name="schema" style="width: 1024px; resize: none;"></textarea>
						</td>
					</tr>
					<tr>
						<td>content:<br /> <textarea class="form-control" id="c1"
								name="c1" style="width: 1024px; resize: none;" rows="30"></textarea><br />
							<input name="content" id="c2" type="hidden" />
						</td>
					</tr>
					<tr>
						<td align="center"><button type="button" onclick="check()"
								class="btn btn-success">submit</button></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<!--内容部分结束-->

	<!-- 脚部 -->
	<footer class="footer">
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
								<li><a href="/about/">关于我们</a></li>
								<li><a href="/ad/">广告合作</a></li>
								<li><a href="/links/">友情链接</a></li>
								<li><a href="/hr/">招聘</a></li>
							</ul>
						</div>
						<div class="col-sm-3">
							<h4>联系方式</h4>
							<ul class="list-unstyled">
								<li><a href="http://weibo.com/bootcss"
									title="Bootstrap中文网官方微博" target="_blank">新浪微博</a></li>
								<li><a href="mailto:admin@bootcss.com">电子邮件</a></li>
							</ul>
						</div>
						<div class="col-sm-4">
							<h4>旗下网站</h4>
							<ul class="list-unstyled">
								<li><a href="http://www.golaravel.com/" target="_blank">Laravel中文网</a>
								</li>
								<li><a href="http://www.ghostchina.com/" target="_blank">Ghost中国</a>
								</li>
								<li><a href="http://www.bootcdn.cn/" target="_blank">BootCDN</a>
								</li>
								<li><a href="https://pkg.phpcomposer.com/" target="_blank">Packagist中国镜像</a>
								</li>
								<li><a href="https://www.return.net/" target="_blank">燃腾教育</a>
								</li>
							</ul>
						</div>
						<div class="col-sm-2">
							<h4>赞助商</h4>
							<ul class="list-unstyled">
								<li><a href="http://www.maoyun.tv/" target="_blank">猫云</a>
								</li>
								<li><a href="https://www.jdcloud.com/" target="_blank">京东云</a>
								</li>
								<li><a href="https://www.upyun.com" target="_blank">又拍云</a>
								</li>
							</ul>
						</div>
					</div>

				</div>
			</div>
			<hr>
			<div class="row footer-bottom">
				<ul class="list-inline text-center">
					<li><a href="http://www.miibeian.gov.cn/" target="_blank">京ICP备11008151号</a>
					</li>
					<li>京公网安备11010802014853</li>
				</ul>
			</div>
		</div>
	</footer>
	<!-- 脚部结束 -->
</body>

</html>