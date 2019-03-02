<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    
    <title>My JSP 'log_reg.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="css/log_reg.css" rel="stylesheet" type="text/css">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/font-awesome.css" rel="stylesheet" type="text/css">
	<link rel="icon" href="/EXAM/images/logo.png">
	<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/log_reg.js"></script>
	

</head>

<body>
	<!-- 模态框的页面代码 -->
	<div class="modal fade" id="log_reg_Modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">错误信息</h4>
	      </div>
	      <div class="modal-body">
	             错误信息
	      </div>
	    </div>
	  </div>
	</div>
    <!-- 登录注册页前端代码 -->
	<div class="header">
		<a href="#"><img alt="" src="images/logobig.png" /></a>
	</div>

	<div class="banner">
		<div class="login-banner-bg"></div>

		<div class="log_reg">
			<ul>
				<li ><a id="log_selected" href="#">用户登录</a></li>
				<li ><a id="reg_selected" href="#">用户注册</a></li>
			</ul>
			<form id="log" >
				<div class="user-tel">
					<label for="tel">
						<i class="fa fa-mobile fa-2x" aria-hidden="true"></i>
					</label>
					<input type="text" name="tel" id="tel" placeholder="请输入电话号码">
                </div>
                <div class="user-password">
					<label for="password">
						<i class="fa fa-lock fa-2x" aria-hidden="true" ></i> 
					</label>
					<input type="password" name="password" id="password" placeholder="请输入密码">
                </div>
                <div class="user-code">
					<label for="code">
						<i class=" fa fa-code-fork fa-2x" aria-hidden="true" ></i>
					</label>
					<input type="text" name="code" id="code" placeholder="请输入验证码">
					<a href="#" id="changeImg"><img src="${pageContext.request.contextPath}/user_code.action"></a>
                </div>
                <div class="log-meg">
                	<samp style="color: red">错误信息</samp>
                </div>
                <div class="btn">
                    <input type="button" name="btn_log" value="登录">					
                </div>					
               
			</form>
			<form id="reg" style="">
				<div class="reg-tel">
					<label for="reg_tel">
						<i class="fa fa-mobile fa-2x" aria-hidden="true"></i>
					</label>
					<input title="错误信息"
                           data-container="body" data-toggle="popover" data-placement="right"
                           data-content="请输入正确格式的手机号码" 
					       type="text" name="reg_tel" id="reg_tel" placeholder="请输入电话号码">
                </div>
                <div class="reg-password">
					<label for="reg_password">
						<i class="fa fa-lock fa-2x" aria-hidden="true" ></i> 
					</label>
					<input title="错误信息"
                           data-container="body" data-toggle="popover" data-placement="right"
                           data-content="请输入6-20位字符" 
					       type="password" name="reg_password" id="reg_password" placeholder="请输入密码">
                </div>

                <div class="reg-password-en">
					<label for="reg_password_en">
						<i class="fa fa-lock fa-2x" aria-hidden="true" ></i> 
					</label>
					<input title="错误信息"
                           data-container="body" data-toggle="popover" data-placement="right"
                           data-content="两次密码不一致" type="password" name="reg_password_en" id="reg_password_en" placeholder="请再次输入密码" >
                </div>

                <div class="reg-code">
					<label for="reg_code">
						<i class=" fa fa-code-fork fa-2x" aria-hidden="true" ></i>
					</label>
					<input type="text" name="reg_code" id="reg_code" placeholder="请输入手机验证码">
					<input type="button" name="btn_reg_code" value="发送">
                </div>
                
                <div class="reg-meg">
                	<samp ></samp>
                </div>
                <div class="btn">
                    <input type="button" name="btn_reg" value="注册">					
                </div>					
				
			</form>
		</div>
			
    </div>

    <div class="footer ">
						<div class="footer-hd ">
							<p>
								<a href="# ">恒望科技</a>
								<b>|</b>
								<a href="# ">网站首页</a>
								<b>|</b>
								<a href="# ">腾讯课堂</a>
								<b>|</b>
								<a href="# ">湖南科技大学</a>
							</p>
						</div>
						<div class="footer-bd ">
							<p>
								<a href="# ">关于黄亮</a>
								<a href="# ">合作伙伴</a>
								<a href="# ">联系我们</a>
								<a href="# ">网站地图</a>
								<em>© 2015-2025 手写网页前端很累如需引用请备注来源（黄亮手写） 版权所有.  </em>
							</p>
						</div>
	</div>

</body>
</html>
