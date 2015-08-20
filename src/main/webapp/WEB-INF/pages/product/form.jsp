<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
     pageEncoding="ISO-8859-1"%>
<%@ page import="vn.kms.lp.model.ProductModel"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
     <form action="ProductServlet/${status}" method="POST">
          <table>
               <tr>
                    <td><label>id</label></td>
                    <td><input type='number' name='id'
                         value='${model.id}'></td>
               </tr>
               <tr>
                    <td><label>Name</label></td>
                    <td><input type='text' id='name' name='name'
                         value='${model.name}'></td>
               </tr>
               <tr>
                    <td><label>By Category</label></td>
                    <td><select name="category">
                              <option value="category1" <c:if test="${model.category==category1}" >checked="true"</c:if> > Category1</option>
                              <option value="category2" <c:if test="${model.category==category2}" >checked="true"</c:if>>Category2</option>
                              <option value="category3" <c:if test="${model.category==category3}" >checked="true"</c:if>>Category3</option>
                              <option value="category4" <c:if test="${model.category==category4}" >checked="true"</c:if>>Category4</option>
                    </select></td>
               </tr>
               <tr>
                    <td><label>Price Range </label></td>
                    <td><input type="number" id='from' name='price' value='${model.price }'></td>
               </tr>
               <tr>
                    <td>&nbsp;</td>
                    <td><input type='submit' value='submit'></td>
               </tr>
          </table>
     </form>

</body>
</html>