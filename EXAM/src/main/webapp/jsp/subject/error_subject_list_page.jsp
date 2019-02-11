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
    <title>实现分页展示所有的错题信息</title>
    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
  </head>
  <body>
    <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    
    <div id="show">
      <table class="table table-hover">
	    <tr>
	       <th>ESID</th>
	       <th>USERID</th>
	       <th>EKEY</th>
	       <th>SID</th>
	       <th>SSTATE</th>
	       <th>SCONTENT</th>
	     </tr>
	     <c:forEach items="${errorSubjectList}" var="errorSubject" varStatus="index">
	       <c:choose>
	         <c:when test="${ index.count % 3 == 0 }">
		       <tr class="active">
		         <td>${errorSubject.esid}</td>
		         <td>${errorSubject.userid}</td>
		         <td>${errorSubject.ekey}</td>
		         <td>${errorSubject.subject.sid}</td>
		         <td>${errorSubject.subject.sstate}</td>
		         <td>${errorSubject.subject.scontent}</td>
		       </tr>
		     </c:when>
		       
		     <c:when test="${ index.count % 3 == 1 }">
		       <tr class="success">
		         <td>${errorSubject.esid}</td>
		         <td>${errorSubject.userid}</td>
		         <td>${errorSubject.ekey}</td>
		         <td>${errorSubject.subject.sid}</td>
		         <td>${errorSubject.subject.sstate}</td>
		         <td>${errorSubject.subject.scontent}</td>
		       </tr>
		     </c:when>
		     
		     <c:when test="${ index.count % 3 == 2 }">
		       <tr class="warning">
		         <td>${errorSubject.esid}</td>
		         <td>${errorSubject.userid}</td>
		         <td>${errorSubject.ekey}</td>
		         <td>${errorSubject.subject.sid}</td>
		         <td>${errorSubject.subject.sstate}</td>
		         <td>${errorSubject.subject.scontent}</td>
		       </tr>
		     </c:when> 
	       </c:choose>
	     </c:forEach>
	  </table>
    </div>
	<!-- 分页栏标签 -->
	<a id="count" class="hidden">${count}</a>
    <div id="pageHelper">
    
    </div>
 
  </body>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/pageHelper.js"></script>
  <script type="text/javascript">
    $(function(){
    	//footmarkFun(1,5,"#pageHelper");
    	var count = $("#count").text();
    	pageHelper(count,null,4,"/EXAM/list_error_subject_page_updata.action","#show","#pageHelper")
    })
  </script>
</html>