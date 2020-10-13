<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

	<div class="container mt-5  d-flex justify-content-center">
		<div class="col-md-5">
	
	<form action="/CommerceWeb/AddProduct" method="POST">
        <div class="card d-flex justify-content-center">
				<div class="card-header">
                    <h5>Add new product</h5>  
                </div>
     <div class="card-body">

	    <div class="form-group">
           Name: <input type="text" name="name" class="form-control"/><br>
        </div> 
        <div class="form-group">
           Description: <input type="text" name="descr" class="form-control"/><br>
        </div>       
        <div class="form-group">
           Image: <input type="text" name="img" class="form-control"/><br>
        </div>  
        <div class="form-group">
           Price: <input type="text" name="price" class="form-control"/><br>
        </div>
        <div class="form-group">
           Select a Category:
			   <select name="category" class="form-control">
			   	<option value="-1">--</option>
			       <c:forEach items="${listCategory}" var="category">
			           <option value="${category.getCateogrieId()}">${category.getCategorieNom()}</option>
			        </c:forEach>
			    </select>
			    <br/><br/>
        </div>
        
   
     </div>
     		<div class="card-footer">
            <div class="form-group">
            <button type="submit" class="btn btn-primary float-right"> Add </button>
     </div>
     </div>
     </div>
        </form>
     </div>
     </div>
	
</body>
</html>