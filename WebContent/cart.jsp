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
		<c:if test="${!sessionScope.cart.isEmpty()}">	
			<a class="btn btn-outline-primary float-right" href="/CommerceWeb/Commander.jsp" role="button">Order</a>
		</c:if>
		
		<table class="table">
		<tbody>
    
    <tr>
	
		<c:forEach var="item" items="${sessionScope.cart }">
		<td>
		<div>
		<table class="table table-hover">
		<tbody>
    
    	<tr>
    	<td>
		
			
	
			<img src="${item.getProduit().getImage() }" width="100" height="100"/>
			<p>${item.getProduit().getProdNom() }</p>
					
			<p class="font-italic">${item.getProduit().getPrix() } dh</p>
			<p class="font-weight-light">(${item.getQte() })
			(${item.getProduit().getPrix() * item.getQte() } dh)</p>
		</td>
		<td>
			<a class="btn btn-outline-warning" href="AddPanier?action=remove&id=${item.getProduit().getProduitId()}"
						onclick="return confirm('Are you sure?')" role="button">Remove</a>
		</td>
		</tr>
		</tbody>
		</table>
		</div>
		</td>
	</c:forEach>
	 </tr>
  </tbody>
</table>

		<div class="container">
		  <div class="row">
		    <div class="col text-center">
	<a class="btn btn-danger" href="/CommerceWeb/" role="button">Continue Shopping</a>
		</div>
		</div>
		</div>
	
</body>
</html>