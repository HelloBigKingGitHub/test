<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>试卷展示页面</title>
    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/font-awesome.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/paper_list.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/base.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/paper_list.js"></script>
  </head>
  <body>
    <jsp:include page="/jsp/common/header.jsp"></jsp:include>
  	<div class="container shadow">
	  	<div class="page-header">
		  <h1>试卷展示页面 <small>选择相应的试卷进行考试</small></h1>
		</div>
		<div class="list shadow">
			<div class="tableheader">
				<span>排序</span>
				<span>发布时间</span>
				<span>考试人数</span>
			</div>
			
			<table class="table table-hover" >
			  <c:forEach items="${papers}" var="p">
				<tr>
					<td>
						<p>${p.pname}</p>
						<span><i class="fa fa-clock-o" aria-hidden="true"></i>2018-12-12</span>
						<span><i class="fa fa-user-o" aria-hidden="true"></i>39</span>
					</td>
					<td>
					  	<div href="#" class="start_test " >
					  		<p class="hidden" data-pid="${p.pid}"></p>
					  		<i class="fa fa-pencil" aria-hidden="true"></i>开始考试
					  	</div>
					  	</td>
				</tr>
			  </c:forEach>
			</table>

		</div>
	</div>
  </body>
</html>