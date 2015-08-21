<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
     pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="vn.kms.lp.model.ProductModel"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
     <h2>Product - List</h2>
     <a href="add">Add New Product</a>
     <hr>
     <table>
          <tr>
               <th>ID</th>
               <th>Name</th>
               <th>Category</th>
               <th>Description</th>
               <th>Price</th>
               <th>&nbsp;</th>
               <th>&nbsp;</th>
          </tr>
          <c:forEach var="entry" items="${products}">
               <tr>
                    <td><c:out value="${entry.id}" /></td>
                    <td><c:out value="${entry.name}" /></td>
                    <td><c:out value="${entry.category}" /></td>
                    <td><c:out value="${entry.description}" /></td>
                    <td><c:out value="${entry.price}" /></td>
                    <td><a href='update?id=${entry.id}'>Edit</a></td>
                    <td><a href='delete?id=${entry.id}'>Delete</a></td>
               </tr>
          </c:forEach>
     </table>
</body>
</html>