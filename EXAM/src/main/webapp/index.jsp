<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>项目搭建测试小用例</title>
    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/user_index.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css">
    <link rel="icon" href="/EXAM/images/logo.png">
    <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/user_index.js"></script>
  </head>
  <body >
  	<!--	页面头部信息-->
  	<div  style="margin:0px;padding:0px">
	 <jsp:include page="/jsp/common/header.jsp"></jsp:include>
    </div>
  

  	<!--	页面主体信息-->
  	<div class="main">
		<div id="myCarousel" class="carousel slide">                        <!--设置轮播器区域样式，设置轮播器滚动样式-->
		    <ol class="carousel-indicators">                                <!--设置轮播器列表区域样式，就是小圆点区域样式-->
		        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>    <!--设置当前列表首选-->
		        <li data-target="#myCarousel" data-slide-to="1"></li>
		        <li data-target="#myCarousel" data-slide-to="2"></li>
		    </ol>
		    <div class="carousel-inner">                                    <!--设置轮播器图片区域-->
		        <div class="item active tp1">                                <!--设置轮播器图片样式-->
		            <a href="#"><img style="width: 100%; height: 300px" src="${pageContext.request.contextPath}/images/slide1.png" alt="第一张"></a>
		        </div>
		        <div class="item tp2">
		            <a href="#"><img style="width: 100%; height: 300px" src="${pageContext.request.contextPath}/images/slide2.png" alt="第二张"></a>
		        </div>
		        <div class="item tp3">
		            <a href="#"><img style="width: 100%; height: 300px"  src="${pageContext.request.contextPath}/images/slide3.png" alt="第三张"></a>
		        </div>
		    </div>		
		</div>
		
	    <!--**************************************************************-->
	    <!-- 首页下部分的页面内容和样式-->
	  	<div class="container">
	  		<!-- 学生和老师管理界面的入口-->
	  		<div class="interface clearfix">
	            <section class="dark-buttons">
				  	<div class="left">
					    <h1 class="light-header">管理界面入口</h1>
					    <a href="${pageContext.request.contextPath}/admin/student_admin.html" class="button darkbg-blue clearfix">
					    	<span>学生入口</span>
						    <div class="icon">
						      <div class="arrow"></div>
						    </div>
					    </a> 
					    <a href="${pageContext.request.contextPath}/admin/teacher_admin.html" class="button darkbg-pink clearfix">
					    	<span>老师入口</span>
						    <div class="icon">
						      <div class="arrow"></div>
						    </div>
					    </a> 
					</div> 
				</section>
				
	  		</div>
	  		
	  	
	  		<!-- 咨询资讯-->
	
		  	<div class="interpellate clearfix">
	
		  		<!-- 学校新闻部分-->
		  		<div class="school_news left">
		  			<!-- 标题部分 -->
		  			<div class="title">
		  				校园资讯
		  				<span class="right"><a href="">更多  »</a></span>
		  			</div>
	
		  			<ul>
		  				<li>
		  					<a href="">教育学院组织党员发展对2134646456546123象开展实践活动</a>
		  					<span class="time right">2018-12-19</span>
		  				</li>
		  				<li>
		  					<a href="">教育学院组织党员发展对象开展实践活动</a>
		  					<span class="time right">2018-2-9</span>
		  				</li>
		  				<li>
		  					<a href="">教育学院组织党员发展对象开展实践活动</a>
		  					<span class="time right">2018-2-9</span>
		  				</li>
		  				<li>
		  					<a href="">教育学院组织党员发展对象开展实践活动</a>
		  					<span class="time right">2018-2-9</span>
		  				</li>
		  				<li>
		  					<a href="">教育学院组织党员发展对象开展实践活动</a>
		  					<span class="time right">2018-2-9</span>
		  				</li>
		  				<li>
		  					<a href="">教育学院组织党员发展对象开展实践活动</a>
		  					<span class="time right">2018-2-9</span>
		  				</li>
		  			</ul>
		  			
		  		</div>
	
		  		<!-- 学习排名信息（包括老师和学生的排名）-->
	
		  		<div class="ranking right">
		  			<!-- 学习积分榜-->
		  			<div class="studay_ranking">
		  				<div class="title">
		  					学习积分榜
		  				</div>
		  				
		  			</div>
		  			<!-- 教师评分榜-->
		  			<div class="teacher_grade">
		  				<div class="title">
		  					教师评分榜
		  				</div>
		  			</div>
		  		</div>
	
		  	</div>
	
		  	<!-- 学习视频推荐部分-->
		  	<div class="video">
		  		<div class="title">
		  			<span>最新开课</span>
		  		</div>
		  		<div class="newestCourseList">
		  			<!-- 一个视频内容-->
		  			<div class="cloumn box">
		  				<p>
		  					<a href="#">
		  						<img src="${pageContext.request.contextPath}/images/1.jpg">
		  					</a>
		  				</p>
		  				<p>
		  					<a href="">从零到一有多远实战篇</a>
		  				</p>
		  				
		  			</div>
	
		  			<div class="cloumn box">
		  				<p>
		  					<a href="#">
		  						<img src="${pageContext.request.contextPath}/images/2.jpg">
		  					</a>
		  				</p>
		  				<p>
		  					<a href="">从零到一有多远实战篇</a>
		  				</p>
		  				
		  			</div>
					
					<div class="cloumn box">
		  				<p>
		  					<a href="#">
		  						<img src="${pageContext.request.contextPath}/images/3.jpg">
		  					</a>
		  				</p>
		  				<p>
		  					<a href="">从零到一有多远实战篇</a>
		  				</p>
		  				
		  			</div>
	
		  			<div class="cloumn box">
		  				<p>
		  					<a href="#">
		  						<img src="${pageContext.request.contextPath}/images/4.jpg">
		  					</a>
		  				</p>
		  				<p>
		  					<a href="">从零到一有多远实战篇</a>
		  				</p>
		  				
		  			</div>
	
		  			<div class="cloumn box">
		  				<p>
		  					<a href="#">
		  						<img src="${pageContext.request.contextPath}/images/5.jpg">
		  					</a>
		  				</p>
		  				<p>
		  					<a href="">从零到一有多远实战篇</a>
		  				</p>
		  				
		  			</div>
	
		  			<div class="cloumn box">
		  				<p>
		  					<a href="#">
		  						<img src="${pageContext.request.contextPath}/images/6.jpg">
		  					</a>
		  				</p>
		  				<p>
		  					<a href="">从零到一有多远实战篇</a>
		  				</p>
		  				
		  			</div>
	
		  			<div class="cloumn box">
		  				<p>
		  					<a href="#">
		  						<img src="${pageContext.request.contextPath}/images/7.jpg">
		  					</a>
		  				</p>
		  				<p>
		  					<a href="">从零到一有多远实战篇</a>
		  				</p>
		  				
		  			</div>
	
		  			<div class="cloumn box">
		  				<p>
		  					<a href="#">
		  						<img src="${pageContext.request.contextPath}/images/8.jpg">
		  					</a>
		  				</p>
		  				<p>
		  					<a href="">从零到一有多远实战篇</a>
		  				</p>
		  				
		  			</div>
	
		  			<div class="cloumn box">
		  				<p>
		  					<a href="#">
		  						<img src="${pageContext.request.contextPath}/images/9.jpg">
		  					</a>
		  				</p>
		  				<p>
		  					<a href="">从零到一有多远实战篇</a>
		  				</p>
		  				
		  			</div>
	
		  			<div class="cloumn box">
		  				<p>
		  					<a href="#">
		  						<img src="${pageContext.request.contextPath}/images/10.jpg">
		  					</a>
		  				</p>
		  				<p>
		  					<a href="">从零到一有多远实战篇</a>
		  				</p>
		  				
		  			</div>
	
		  			<div class="cloumn box">
		  				<p>
		  					<a href="#">
		  						<img src="${pageContext.request.contextPath}/images/11.jpg">
		  					</a>
		  				</p>
		  				<p>
		  					<a href="">从零到一有多远实战篇</a>
		  				</p>
		  				
		  			</div>	
		  		</div>
		  	</div>
	
		  	<!-- 学习课程相关的推荐部分-->
		  	<div class="course">
		  		<div class="title">
		  			<span>免费公开课</span>
		  		</div>
		  		<div class="freeCourseList">
		  			<div class="cloumn box">
		  				<p>
		  					<a href="#">
		  						<img src="${pageContext.request.contextPath}/images/9.jpg">
		  					</a>
		  				</p>
		  				<p>
		  					<a href="">从零到一有多远实战篇</a>
		  				</p>
		  			</div>
	
		  			<div class="cloumn box">
		  				<p>
		  					<a href="#">
		  						<img src="${pageContext.request.contextPath}/images/12.jpg">
		  					</a>
		  				</p>
		  				<p>
		  					<a href="">从零到一有多远实战篇</a>
		  				</p>
		  			</div>
	
		  			<div class="cloumn box">
		  				<p>
		  					<a href="#">
		  						<img src="${pageContext.request.contextPath}/images/11.jpg">
		  					</a>
		  				</p>
		  				<p>
		  					<a href="">从零到一有多远实战篇</a>
		  				</p>
		  			</div>
	
		  			<div class="cloumn box">
		  				<p>
		  					<a href="#">
		  						<img src="${pageContext.request.contextPath}/images/10.jpg">
		  					</a>
		  				</p>
		  				<p>
		  					<a href="">从零到一有多远实战篇</a>
		  				</p>
		  			</div>	
		  		</div>
		  		
		  	</div>
		  	<!--友情链接-->
			<div class="friendship-link">
			  <div class="w1136">
				  <div class="content00">
						<div class="c1">
							<img src="http://hnust.hunbys.com/image/index/i-t-02.png"/>
							<span> <b>累计开课(门)</b> <i class="counter" data=865></i>  </span>
						</div>
						<div class="c1">
							<img src="http://hnust.hunbys.com/image/index/i-t-03.png"/>
							<span> <b>学习人数(人)</b> <i class="counter" data=24379></i>  </span>
						</div>
						<div class="c1">
							<img src="http://hnust.hunbys.com/image/index/i-t-04.png"/>
							<span> <b>视频学习(小时)</b> <i class="counter" data=596523></i> </span>
						</div>
					</div>
			    <p id="friendLinkList">友情链接：
			    
			    </p>
			  </div>
			</div>
			<!--友情链接 end-->
		</div>
  	</div>
  	
  	<div class="footer">
  	  <jsp:include page="/jsp/common/footer.jsp"></jsp:include>
  	
  	</div>
  </body>
</html>