<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="vn.kms.lp.model.ProductModel"%>
<%@ page import="vn.kms.lp.web.utils.CategoryConfiguration"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Product:</h2>
    <form action="ProductServlet" method="POST">
        <table>
            <tr>
                <td><label hidden='true'>id</label></td>
                <td><input hidden='true' type='number' name='id' value='${product.id}'></td>
            </tr>
            <tr>
                <td><label>Name</label></td>
                <td><input type='text' id='name' name='name' value='${product.name}'></td>
            </tr>
            <tr>
                <td><label>By Category</label></td>
                <td><select name="category">
                
                    <%for(String item : CategoryConfiguration.getAllCategories()) {%>
                    <%pageContext.setAttribute("currentCategory",item); %>
                        <option value="<%=item%>" 
                                <c:if test="${product.category == currentCategory}"> selected='true'</c:if>>
                        <%= item %>
                        </option>
                    
                    <%} %>
                </select></td>
            </tr>
            <tr>
                <td><label>Description</label></td>
                <td><input type='text'  name='description' value='${product.description}'></td>
            </tr>
            <tr>
                <td><label>Price</label></td>
                <td><input type="number" name='price' value='${product.price }'></td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td><input type='submit' value='${action}'></td>
            </tr>
        </table>
    </form>

</body>
</html>