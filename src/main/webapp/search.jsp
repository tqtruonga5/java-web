<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
     <% if(session!=null && session.getAttribute("username") != null){ %>
     <h3><%= session.getAttribute("username") %>,<a href="logout">Log Out</a></h3>
     <%}%>
     <h1>Search Page:</h1>
     <hr/>
     <%@ include file="./WEB-INF/searchForm.jsp"%>
</body>
</html>