/**
 * 校验用户名是否存在
 */
//function nameBlur() {
//	var name = $("#name").val();
//	$.ajax({
//		type : "post",
//		data : {
//			name : name
//		},
//		url : "check.action",
//		success : function(result) {
//			if (result == "true") {
//				$("#name_exit").html("名字可以使用");
//			} else {
//				$("#name_exit").html("名字已存在");
//			}
//		},
//		dataType : "text"
//	});
//}
/**
 * 校验用户名是否存在
 */
$(function() {
	$("#name").blur(function() {
		var name = $("#name").val();
		$.ajax({
			type : "post",
			data : {
				name : name
			},
			url : "check.action",
			success : function(result) {
				if (result == "true") {
					$("#name_exit").html("名字可以使用");
				} else {
					$("#name_exit").html("名字已存在");
				}
			},
			dataType : "text"
		});
	});
});

/**
 * 查省
 */
$(function() {
	$.post("pca.action", {type:1}, function(result) {
		var html = "<option value='0'>-prov-</option>";
		$.each(result.list,function(i,data){
			html += "<option value='"+data.provinceID+"'>"+data.province+"</option>";
		});
		$("#provincedId").html(html);
	}, "json");
});

/**
 * 查市
 */
function showCity(pid){
	$.post("pca.action",{type:2,provinceId:pid},function(result){
		var html = "<option value='0'>-city-</option>";
		$.each(result.list,function(i,data){
			html += "<option value='"+data.cityID+"'>"+data.city+"</option>";
		});
		$("#cityId").html(html);
	},"json");
	showArea(0);
}

/**
 * 查区县
 */
function showArea(cid) {
	$.post("pca.action",{type:3,cityId:cid},function(result){
		var html = "<option value='0'>-area-</option>";
		$.each(result.list,function(i,data){
			html += "<option value='"+data.areaID+"'>"+data.areas+"</option>";
		});
		$("#areaId").html(html);
	},"json");
}
























