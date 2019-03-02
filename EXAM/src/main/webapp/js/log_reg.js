/*登录注册页面的js控制*/
$(function(){
	//定义有一个全局变量判断所有的输入框是否都符合要求
	var regIsOK = true;

  $("#log_selected").on("click",function () {
  	 $("#reg").hide(600);
     $("#log").show(1000);
  	
  });

   $("#reg_selected").on("click",function () {
   	 $("#log").hide(600);
     $("#reg").show(1000); 
  });
   
   /*给验证码图片添加点击事件，让他更换图片*/
   $("#changeImg").on("click",function(){
	   //alert("图片点击了");
	   var src = $("#changeImg > img").attr("src");
	  // var src = this.child().attr("src");
	  // alert(src);
	   $("#changeImg > img").attr("src",chgUrl(src))
   });
    
    // 时间戳
    // 为了使每次生成图片不一致，即不让浏览器读缓存，所以需要加上时间戳
    function chgUrl(url) {
        //alert(url);
        var timestamp = (new Date()).valueOf();
       
        if ((url.indexOf("&") >= 0)) {
            url = url + "&timestamp=" + timestamp;
        } else {
            url = url + "?timestamp=" + timestamp;
        }
        //alert(url);
        return url;
    }
/*注册页的相关js控制start*/
    /*给手机号码输入框绑定一个失去焦点事件*/
    $("#reg_tel").blur(function(){
    	var phoneNumber = $("#reg_tel").val();
    	var ret = /^[\d]{5,20}$/;
    	if(!ret.test(phoneNumber)){
    		 console.info("手机号码格式不对");
    		 $("#reg_tel").popover('show');
    		 regIsOK = false;
    	}else{
    		console.info("手机号码格式正确");
    		$("#reg_tel").popover('hide');
    		regIsOK = true;
    	}
    });
    /*给密码输入框绑定一个失去焦点的时间判断输入密码是否符合格式 */
    $("#reg_password").blur(function(){
    	var password = $("#reg_tel").val();
    	var ret = /^[\w]{6,20}$/;
    	if(!ret.test(password)){
    		 console.info("密码格式不正确");
    		 regIsOK = false;
    		 $("#reg_password").popover('show');
    	}else{
    		console.info("密码格式正确");
    		$("#reg_password").popover('hide');
    		regIsOK = true;
    	}
    });
    /*给确认密码的输入框绑定一个失去焦点的时间让他判断两次密码输入是否一致*/
    $("input[name='reg_password_en']").blur(function(){
    	console.info("确认密码框失去焦点");
    	var pwden = $("input[name='reg_password_en']").val();
    	var pwd = $("input[name='reg_password']").val()
    	if(pwden!=pwd){
    		console.info("两次密码不一致");
    		//this.popover('show');
    		$("input[name='reg_password_en']").popover('show');
    		regIsOK = false;
    	}else{
    		console.info("两次密码一致");
    		$("input[name='reg_password_en']").popover('hide');
    		regIsOK = true;
    	}
    });
    //控制请求手机验证码的js部分
   var i = 60;//按钮计数器
   var id = 0;//定时器函数id值
   $("input[name='btn_reg_code']").on("click",sendCode);
   //发送验证码的函数
   function sendCode(){
	   //console.log ("按钮点击生效")
	   //1.发送手机验证码请求
	   var phoneNumber = $("#reg_tel").val();
	   console.info(phoneNumber);
	   $.get("user_phoneCode.action",{"phoneNumber":phoneNumber});
	   //2.将按钮设置成灰色，并且移除低级效果。
	   $("input[name='btn_reg_code']").off("click");
	   //3.按钮中的值从60开始倒计时，值为0是按钮回复到初始状态
	   //没隔一秒钟调用一次函数
	   id = setInterval(chgval,1000);
	   //alert("1"); 
   }
   //改变按钮中值的函数
   function chgval(){
	   $("input[name='btn_reg_code']").val("重新发送"+"("+i+")");
	   i--;
	   if(i<0){
		   clearInterval(id);
		   $("input[name='btn_reg_code']").val("发送");
		   //重新给按钮添加点击事件
		   $("input[name='btn_reg_code']").on("click",sendCode);
		   i = 60;
	   }
   }
   //给注册页中的提交按钮绑定点击事件
   $("input[name='btn_reg']").on("click",function(){
	   //1.获取注册页表单中的所有数据符合规格就是可以进行提交
	   if(regIsOK){
		   var phoneNumber = $("#reg_tel").val();
		   var password = $("#reg_password").val();
		   var phoneCode = $("#reg_code").val();
		   $.ajax({
		    	 contentType:"application/json;charset=utf-8",	//指定请求参数的类型是json类型
	             type: "POST",  //请求方式
	             url: "reg.action", //请求路径
	             data: JSON.stringify({"usertel":phoneNumber, "userpwd":password,"phoneCode":phoneCode}),//请求数据
	             dataType: "text",//期望收到的返回数据类型
	             success: function(data){ //回调函数
	            	 if(data=='0'){//验证码输入错误
	            		 //动态的控制模态框的显示，并且修改模态框中body的值
	            		 $(".modal-body").text("您输入的手机验证码，请检查您输入的手机号码是否为本人手机。");
	            		 $("#log_reg_Modal").modal("show");
	            	 }else if(data=='-1'){ //注册失败
	            		 $(".modal-body").text("您输入的手机号码已已经注册过了，请您跟换手机号码重新注册");
	            		 $("#log_reg_Modal").modal("show");
	            	 }else{ //注册成功
	            		 $(".modal-body").text("恭喜您成功注册一考通教无服务账号，请您登录学生首页选择相应的服务");
	            		 $("#log_reg_Modal").modal("show");
	            	 }
	             }
	         });
	   }
	   
   });
   
   /*end*/
   
   /*登录页面的js控制*/
   //给登录按钮绑定点击事件
   $("input[name='btn_log']").on("click",function(){
	   //登录表单中各个输入框中的值
	   var log_tel = $("#tel").val();
	   var log_pwd = $("#password").val();
	   var imgCode = $("#code").val();
	   //发送起步请求
	   $.ajax({
		   contentType:"application/json;charset=utf-8",	//指定请求参数的类型是json类型
           type: "POST",  //请求方式
           url: "login.action", //请求路径
           data: JSON.stringify({"usertel":log_tel, "userpwd":log_pwd,"imgCode":imgCode}),//请求数据
           dataType: "text",//期望收到的返回数据类型
		   success:function(data){
			   /*
			    * 状态码对应的状态
			    * -1：图片验证码错误
			    * 0：正确登录
			    * 1：用户不存在
			    * 2：用户被禁用
			    * 3：登录密码错误
			    * */
			   console.info(data);
			   switch(data)
			   {
			   case "-1":
				 $(".modal-body").text("您的图形验证码输入错误，请确认大小写后重新输入。");
          		 $("#log_reg_Modal").modal("show");
			     break;
			   case "0":
				  var href = window.location.href;
				  var baseUrl = href.split("//")[0]+"//"+href.split("//")[1].split("/")[0]+"/"+href.split("//")[1].split("/")[1];
				  window.location.href = baseUrl+"/index.jsp";//PC网页式跳转
			     break;
			   case "1":
				 $(".modal-body").text("此用户不存在，请您确认账号后再进行登录。");
	          	 $("#log_reg_Modal").modal("show");
				 break;
			   case "2":
				 $(".modal-body").text("此账号因为违规操作已被管理员禁用，请联系管理员进行解封。");
	          	 $("#log_reg_Modal").modal("show");
				 break;
			   case "3":
				 $(".modal-body").text("您输入的密码有误，请重新确认后进行登录。");
	          	 $("#log_reg_Modal").modal("show");
				     break;
			   default:
				 $(".modal-body").text("系统出现不知名错误，相关日志信息已提交，请等待系统管理员整改后再登录");
        		 $("#log_reg_Modal").modal("show");
			   }
		   }
	   });
	   
	   
   });
   
   /*end*/
});