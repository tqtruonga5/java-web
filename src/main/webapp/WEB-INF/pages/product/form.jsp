<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="vn.kms.lp.model.ProductModel"%>

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
                        <option value="Smartphone" <c:if test="${product.category == 'Smartphone'}"> selected='true'</c:if>>
                            Smartphone
                        </option>
                        <option value="Laptop" <c:if test="${product.category == 'Laptop'}"> selected</c:if>>Laptop</option>
                        <option value="Motorbike" <c:if test="${product.category == 'Motorbike'}"> selected</c:if>>Motorbike</option>
                        <option value="Mouse" <c:if test="${product.category == 'Mouse'}"> selected</c:if>>Mouse</option>
                        <option value="Headphone" <c:if test="${product.category == 'Headphone'}"> selected</c:if>>Headphone</option>
                        <option value="Music Player" <c:if test="${product.category == 'Music Player'}"> selected</c:if>>Music Player</option>
                        <option value="Supercar" <c:if test="${product.category == 'Supercar'}"> selected</c:if>>Supercar</option>
                </select></td>
            </tr>
            <tr>
                <td><label>Name</label></td>
                <td><input type='text'  name='description' value='${product.description}'></td>
            </tr>
            <tr>
                <td><label>Price</label></td>
                <td><input type="number" name='price' value='${product.price }'></td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td><input type='submit' value='submit'></td>
            </tr>
        </table>
    </form>

</body>
</html>