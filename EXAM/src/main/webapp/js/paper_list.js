$(function(){
	//给试卷李彪页面中的开始考试按钮添加点击事件
	$(".start_test").on("click",function(){
		//alert("onclick");
		var pid = $(this).children("p").attr("data-pid");
		//alert(pid);
		//通过ajax想后端发起请求
		$.ajax({
			contentType:"application/json;charset=utf-8",
			type:"GET",
			url:"test_start.action",
			data:{"pid":pid},
		    dataType:"TEXT",
		    success:function(result){
		    	//alert(result);
		    	window.location.href="/EXAM"+result;
		    }
		});
	});
	
});