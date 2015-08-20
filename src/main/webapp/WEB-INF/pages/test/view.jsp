<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="vn.kms.lp.model.TestModel"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test Model Detail</title>
</head>
<body>
    <h2>Test Model - View</h2>
    <%
        TestModel model = (TestModel) request.getAttribute("model");
    %>
    <c:choose>
        <c:when test="${model != null}">
        Attribute1: <%=model.getAttribute1()%><br>
        Attribute2: ${model.attribute2}
    </c:when>
        <c:otherwise>
        Cannot fetch TestModel with ID = <%=request.getParameter("testModelId")%>
        </c:otherwise>
    </c:choose>
</body>
</html>