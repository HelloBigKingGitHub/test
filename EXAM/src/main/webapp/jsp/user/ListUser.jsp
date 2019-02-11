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
  </head>
  <body>
    <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    
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
  
 
  </body>
</html>