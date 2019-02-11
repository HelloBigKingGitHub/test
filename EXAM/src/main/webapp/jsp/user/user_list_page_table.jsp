<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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