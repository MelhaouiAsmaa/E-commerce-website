<%@page import="com.commerce.model.bo.Produit"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

		<form action="/CommerceWeb/SelectByCat" method="post">
			   Select a Category:
			   <select name="category" value="selected">
			   	<option value="-1">--</option>
			       <c:forEach items="${listCategory}" var="category">
			           <option value="${category.getCateogrieId()}">${category.getCategorieNom()}</option>
			        </c:forEach>
			    </select>
			    <br/><br/>
			    <input type="submit" value="Submit" />
			</form>
		
		<%ArrayList<Produit> prds = (ArrayList<Produit>)request.getAttribute("produits");  %>
		<% for(Produit prd : prds){ %>
		
		<div>
		<img src="<%=prd.getImage()%>" width="100" height="100"/>
		<%=prd.getProdNom() %> (<%=prd.getPrix() %>dh)
		<%=prd.getDescription() %>
		
		<a class="btn btn-outline-primary " href="AddPanier?action=buy&PrdId=<%= prd.getProduitId() %>" role="button">Ajouter</a>
		
	</div>
		<%} %>
		

</body>
</html>