<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My first Web application</title>
</head>
<body>
    <h2>Hello World</h2>
    <br>
    <h3>
        Today is:
        <%=new Date()%></h3>

    <%@ include file="./WEB-INF/login.jsp"%>
</body>
</html>