<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path1= request.getContextPath();
%>
  <c:if test="${user==null}">
    	<jsp:forward page="${path1}/UserServlet?flag=notLogin"></jsp:forward>
</c:if>
 
