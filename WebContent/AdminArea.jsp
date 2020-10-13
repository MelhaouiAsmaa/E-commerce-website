<%@page import="com.commerce.model.bo.Categorie"%>
<%@page import="com.commerce.model.bo.Produit"%>
<%@page import="java.util.ArrayList"%>
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
		<div class="container mt-2">
			<div class="row">
		    	<div class="col text-center">
		<a class="btn btn-outline-primary " href="AddProduct" role="button"> Add Product</a>
		<a class="btn btn-outline-primary " href="AddCategory" role="button"> Add Category</a>
		</div>
		</div>
		</div>
		
		<div class="container mt-2">
			<div class="row">
		    	<div class="col text-center">
			<span class="badge badge-primary"> Product Table</span>
			</div>
			</div>
			</div>
	<table class="table">
  <thead>
    <tr>
      <th scope="col">Product</th>
      <th scope="col">Name</th>
      <th scope="col">Price</th>
      <th scope="col">Description</th>
      <th scope="col">Action 1</th>
      <th scope="col">Action 2</th>
    </tr>
  </thead>
  <tbody>
	<%ArrayList<Produit> prds = (ArrayList<Produit>)request.getAttribute("Produits");  %>
		<% for(Produit prd : prds){ %>
		<tr>
	
		<td><img src="<%=prd.getImage()%>" width="100" height="100"/></td>
		<td><%=prd.getProdNom() %></td>  <td>(<%=prd.getPrix() %>dh)</td>
		<td><%=prd.getDescription() %></td>
		
		<td><a class="btn btn-outline-success " href="UpdatePrd?PrdId=<%= prd.getProduitId() %>" role="button"> Update</a></td>
		<td><a class="btn btn-outline-danger " href="DeletePrd?PrdId=<%= prd.getProduitId() %>" role="button"> Delete</a></td>
	
		</tr>
		<%} %>
	</tbody>
	</table>
	
		<div class="container mt-2">
			<div class="row">
		    	<div class="col text-center">
			<span class="badge badge-danger">Category Table</span>
			</div>
			</div>
			</div>
	<table class="table">
  <thead>
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Name</th>
      <th scope="col">Action 1</th>
      <th scope="col">Action 2</th>
    </tr>
  </thead>
  <tbody>
		
	<%ArrayList<Categorie> cats = (ArrayList<Categorie>) request.getAttribute("Categories"); %>
		<% for(Categorie cat: cats){ %>
		
		<tr>
		<td><%=cat.getCateogrieId() %></td>
		<td><%=cat.getCategorieNom() %></td>
		
		<td><a class="btn btn-outline-success " href="UpdateCat?CatId=<%= cat.getCateogrieId() %>" role="button"> Update</a></td>
		<td><a class="btn btn-outline-danger " href="DeleteCat?CatId=<%= cat.getCateogrieId() %>" role="button"> Delete</a></td>
		</tr>
		<%} %>
	  </tbody>
</table>
</body>
</html>