<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="vn.kms.lp.model.TestModel" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test Model List</title>
</head>
<body>
<h2>Test Model - List</h2>
<% List<TestModel> list = (List) request.getAttribute("list"); %>
<ul>
    <c:forEach items="${list}" var="model">
        <li><a href='<c:url value="/testmodel?testModelId=${model.id}"/>'><c:out value="${model.id}"/> - <c:out value="${model.attribute1}"/></a></li>
    </c:forEach>
</ul>
</body>
</html>