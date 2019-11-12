/**
 * 评论js
 */
var current_user_id;

$(function() {
	current_user_id = $("#current_user_id").val();// 取到登录用户，用于判断
	// 调用查询评论方法
	comment_get();
});

/**
 * 查询该博客的所有评论
 */

function comment_get() {
	// ajax预加载评论
	var bid_param = $("#blog_id").val(); // 获取当前博客的id
	// ajax向评论控制器请求数据
	$
			.getJSON(
					"comment.action",
					{
						type : 1,
						bid : bid_param
					},
					function(result) {
						// 将获取到的数据遍历绘制在页面中
						var html = "";
						// 如果没有评论则绘制抢沙发
						if (result.list.length == 0) {
							html += "<div class='comment_author'>还没有人评论</div>";
							html += "<div class='comment_text'>快来抢沙发</div></div>";
						} else {
							$
									.each(
											result.list,
											function(i, data) {
												html += "<div class='comment_author'><span>"
														+ (i + 1)
														+ "楼</span><span>"
														+ data.userName
														+ "</span><span>2016/12/23</span></div>";
												if (current_user_id != null
														&& current_user_id == data.uid) {
													html += "&nbsp;&nbsp;<span class ='comment_delete' style='cursor:pointer' onClick='comment_delete("
															+ data.id
															+ ")'>删除</span>";
												}
												html += "</div>";
												html += "<div class='comment_text'>"
														+ data.content
														+ "</div></div>";
											});
						}
						$("#comment").html(html);
					});
}

/**
 * 发表评论前检查
 */
function check() {
	var input_area = $("#input_area").val();
	if (input_area == "") {
		alert("评论不能为空");
		return false;
	} else {
		return true;
	}

}

/**
 * 发表评论
 */
function comment_submit() {
	var bid_param = $("#blog_id").val();
	var uid_param = current_user_id;
	var comment_content = $("#input_area").val();
	// 保存评论
	if (check()) {
		$.getJSON("comment.action", {
			type : 2,
			bid : bid_param,
			uid : uid_param,
			content : comment_content
		}, function(result) {
			if (result.flag) {
				// 调用查看所有评论方法展示评论
				comment_get();
			}
		});
	}
	// 清空输入区
	$("#input_area").val("");
}

/**
 * 删除评论
 */
function comment_delete(cid_param) {
	$.getJSON("comment.action", {
		type : 3,
		cid : cid_param
	}, function(result) {
		if (result.flag) {
			comment_get();
		}
	});
}
