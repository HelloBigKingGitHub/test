<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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