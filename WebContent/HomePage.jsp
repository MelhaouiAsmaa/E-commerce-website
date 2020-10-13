<%@page import="java.util.ArrayList"%>
<%@page import="com.commerce.model.bo.Produit"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" />
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		
		<a class="btn btn-outline-success float-right" href="/CommerceWeb/AuthAdmin.jsp" role="button">Admin access</a>
		
			<form action="/CommerceWeb/" method="post">
			<div class="row">
			<div class="col-md-5">
			<div class="card-body">
			<div class="form-group"> 
			   Select a Category:
			   <select name="category" class="form-control">
			       <c:forEach items="${listCategory}" var="category">
  				<option value="${category.getCateogrieId()}">${category.getCategorieNom()}</option>
			        </c:forEach>
			    </select>
			</div>				
            <div class="form-group"> 
			    <input type="submit" value="Search" class="btn btn-primary " />
			</div>    		
     		</div>
     		</div>
     		</div>
			</form>
			
		<table class="table">
		<tbody>
    
    <tr>
		
		<%ArrayList<Produit> prds = (ArrayList<Produit>)request.getAttribute("produits");  %>
		<% for(Produit prd : prds){ %>
		<td>
		<div>
		<table class="table table-hover">
		<tbody>
    
    	<tr>
    	<td>
		<img src="<%=prd.getImage()%>" width="100" height="100"/>
		<%=prd.getProdNom() %> <p class="font-italic">(<%=prd.getPrix() %>dh)</p>
		<p class="font-weight-light"><%=prd.getDescription() %>
		 <%=prd.getCategId().getCategorieNom()%></p>
		</td>
		<td>
		<a class="btn btn-outline-primary " href="AddPanier?action=buy&PrdId=<%= prd.getProduitId() %>" role="button">Buy</a>	
		</td>
		</tr>
		</tbody>
		</table>
		</div>
	</td>
		<%} %>
		
	 </tr>
  </tbody>
</table>
		
		
	

</body>
</html>