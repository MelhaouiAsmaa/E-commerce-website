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

	<div class="container mt-5  d-flex justify-content-center">
		<div class="col-md-5">
	
	<form action="/CommerceWeb/AddCategory" method="POST">
        <div class="card d-flex justify-content-center">
				<div class="card-header">
                    <h5>Add new category</h5>  
                </div>
     <div class="card-body">
    
	    <div class="form-group">
           Category name: <input type="text" name="name" class="form-control"/><br>
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