<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>实现分页展示用户的页面</title>
    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
  </head>
  <body>
    <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    
    <div id="show">
      <table class="table table-hover">
	    <tr>
	       <th>USERID</th>
	       <th>ROLEID</th>
	       <th>USERNAME</th>
	       <th>USERPWD</th>
	       <th>USERTRUENAME</th>
	       <th>USERSTATE</th>
	     </tr>
	     <c:forEach items="${Userinfos}" var="user" varStatus="index">
	       <c:choose>
	         <c:when test="${ index.count % 3 == 0 }">
		       <tr class="active">
		         <td>${user.userid}</td>
		         <td>${user.roleid}</td>
		         <td>${user.usertel}</td>
		         <td>${user.userpwd}</td>
		         <td>${user.usertruename}</td>
		         <td>${user.userstate}</td>
		       </tr>
		     </c:when>
		       
		     <c:when test="${ index.count % 3 == 1 }">
		       <tr class="success">
		         <td>${user.userid}</td>
		         <td>${user.roleid}</td>
		         <td>${user.usertel}</td>
		         <td>${user.userpwd}</td>
		         <td>${user.usertruename}</td>
		         <td>${user.userstate}</td>
		       </tr>
		     </c:when>
		     
		     <c:when test="${ index.count % 3 == 2 }">
		       <tr class="warning">
		         <td>${user.userid}</td>
		         <td>${user.roleid}</td>
		         <td>${user.usertel}</td>
		         <td>${user.userpwd}</td>
		         <td>${user.usertruename}</td>
		         <td>${user.userstate}</td>
		       </tr>
		     </c:when> 
	       </c:choose>
	     </c:forEach>
	  </table>
    </div>
	<!-- 分页栏标签 -->
    <nav aria-label="Page navigation">
	  <ul class="pagination">
	    <li>
	      <a href="javascript:0" aria-label="Previous">
	        <span aria-hidden="true">&laquo;</span>
	      </a>
	    </li>
	      <a class="hidden" id="pageCount">${count}</a>
	      <li id="frist_li"><a href="javascript:0">1</a></li>
	      <li id="scend_li"><a href="javascript:0">2</a></li>
	    <li>
	      <a href="javascript:0" aria-label="Next">
	        <span aria-hidden="true">&raquo;</span>
	      </a>
	    </li>
	  </ul>
	</nav>
 
  </body>
  <script type="text/javascript">
    $(function(){
    	/*******************实现具有伸缩效果的分页栏**************************/
    	//进行一步请求实现局部刷新表格数据
    	var count = $("#pageCount").text();
    	var flag = 1;
    	//给下一个分页栏按钮添加点击事件 如果现在显示的时1,2页。按下按钮后就行显示3,4页
    	$("a[aria-label='Next']").on("click",function(){
    		flag = flag + 1;
    		if(flag>count/2+1){
    			flag = flag - 1;
    		}
    		console.info(flag);
    		$("#frist_li > a").text(flag*2-1);
    		//数据合理化处理
    		if((flag*2)>count){
    			$("#scend_li > a").hide();
    		}else{
    			$("#scend_li > a").show();
    			$("#scend_li > a").text(flag*2);
    		}
    		
    	});
    	//给上一个分页栏按钮添加点击事件
    	$("a[aria-label='Previous']").on("click",function(){
    		flag = flag - 1;
    		if(flag<1){
    			flag = 1;
    		}
    		console.info(flag);
    		$("#frist_li > a").text(flag*2-1);
    		$("#scend_li > a").show();
    		$("#scend_li > a").text(flag*2);
    	});
    	
    	/**************************************************/
    	
    	/************给分页栏上的页脚标签绑定点击事件**************/
    	$("li[id$='_li']>a").on("click",function(){
    		//alert("页脚被点击了")
    		var pageNumStr = $(this).text();
    		//alert(pageNumStr);
    		//发送ajax请求到后端,局部刷新数据
    		$.ajax({
    			Type:"POST",
    			url:"/EXAM/ListPageUserUpdata.action",
    			data:{"pageNumStr":pageNumStr},
    			dataType:"HTML",
    			success:function(result){
    				//alert(result)
    				$("#show").html(result);
    			}
    		});
    		
    	});
    	
    	/**************************************************/
    	
    })
  </script>
</html>