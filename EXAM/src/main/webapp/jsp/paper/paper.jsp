<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
    <link href="${pageContext.request.contextPath}/css/icheck-bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/paper.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css">
    <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/paper.js"></script>
  </head>
  <body>
  <h1></h1>
  	<!-- 页头信息部分-->
  	<div class="container">
	  	<header>	
	  		<div class="page-header">
	  			<table>
	  				<tr>
	  					<td>
			  				<h2><img src="${pageContext.request.contextPath}/images/logo.png"> 一考通考试</h2>
			  			</td>
			  			<td id="col2">
			  	<!-- 考试做题数目和剩余题目提示功能-->
						  	<div class="subject pull-right">
						  		已做&nbsp;
						  		<span class="green bold">0</span>
						  		&nbsp;题 /  剩&nbsp;<span class="green bold">${fn:length(choseSubjects)}</span>&nbsp题
						  	</div>
						  	<!-- 控制考试时间的部分 -->
						  	<div class="time pull-right">
						  		<div class="time_bg pull-left">
						  			<dl>
						  				<dt><img src="${pageContext.request.contextPath}/images/colock_icon.png" width="26" height="26"></dt>
						  				<dd>
						  					<span id="ExamTime">00:23:00</span>
						  				</dd>
						  			</dl>
						  		</div>
						  		<div class="time_stop pull-left">
						  			<a href="javascript:0"><img src="${pageContext.request.contextPath}/images/t_stop_btn.png" width="44" height="40"></a>
						  		</div>
						  	</div>
			  			</td>
			  		</tr>
			    </table>
			</div>
	  	</header>
	  	<!-- 试题部分-->
	  	<div class="contextss shadow">
	  		<!-- 试卷标题-->
	  		<div class="test_title">
	  			<h2>${paperDetail.paper.pid}.${paperDetail.paper.pname}</h2>
	  		</div>
	  		<!-- 试卷基本信息-->
	  		<div class="test_message">
	  			<p class="wid1">卷面总分：${paperDetail.paggregatescore }分</p>
	  			<p class="wid1">答题时间：${paperDetail.ptime }分钟</p>
	  			<p class="wid1">测试次数：${paperDetail.testdegree }次</p>
	  			<p class="wid1">平均得分：${paperDetail.avescore }分</p>
	  			
	  		</div>
	  		<!-- 试题的主干部分-->
	  		<div class="test_body">
	  			<div class="question_type">
	  				<h3>单向选择题</h3>
	  			</div>
	  			<!--试题的主要内容-->
	  			<div class="test_content">
	  				<c:forEach items="${choseSubjects}" varStatus="index" var="choseSubject">
	  				
		  				<!--问题-->
		  				<div class="question">
		  					<!--问题题干-->
		  					<div class="question_title">
		  						<h4 class="question_num">(${index.count})</h4>
		  						<p>	${choseSubject.scontent }</p>
		  					</div>
		  					<!--题目选项-->
		  					<div class="question_chioce">
		  						<p class="chioce_a">A.${choseSubject.sa }</p>
		  						<p class="chioce_b">B.${choseSubject.sb }</p>
		  						<p class="chioce_c">C.${choseSubject.sc }</p>
		  						<p class="chioce_d">D.${choseSubject.sd }</p>
		  					</div>
		  					<div class="test_answer">
		  						<h5>[选择答案]</h5>
		  						<div class="radio">
		  						<div class="radio icheck-info">
									<input type="radio" id="${choseSubject.sid}answer1" name="${choseSubject.sid}answer" />
									<label for="${choseSubject.sid}answer1">A</label>
								</div>
								<div class="radio icheck-info">
									<input type="radio" id="${choseSubject.sid}answer2" name="${choseSubject.sid}answer" />
									<label for="${choseSubject.sid}answer2">B</label>
								</div>
								<div class="radio icheck-info">
									<input type="radio" id="${choseSubject.sid}answer3" name="${choseSubject.sid}answer" />
									<label for="${choseSubject.sid}answer3">C</label>
								</div>
								<div class="radio icheck-info">
									<input type="radio" id="${choseSubject.sid}answer4" name="${choseSubject.sid}answer" />
									<label for="${choseSubject.sid}answer4">D</label>
								</div>
								</div>
		  					</div>
		  				</div>
	  				</c:forEach>
	  			</div>
	  		</div>
	  		
	  	</div>
	</div>
	<!-- 试卷左侧的答题卡样式-->
	<div id="low_right" class="shadow"> 
       <h4>答题卡</h4> 
       <div class="cbnWrap">
       	  <div >
       	  	<c:forEach items="${choseSubjects}" varStatus="index" var="subject">
       	  	  <span class="ISpan" id="${subject.sid}">${index.count}</span>
       	  	</c:forEach>
       	  </div>
       	
       </div>
       <div class="row">
         <div class="col-md-6">
       	   <span class="ISpan"></span>
       	   <span >未做</span>
         </div>
         <div class="col-md-6">
       	   <span class="ISpan_finish"></span>
       	   <span >已做</span>
         </div>
       </div>
       <div id="test_commit">
       	提交试卷
       </div>
	</div> 

  </body>
</html>