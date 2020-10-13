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
<script type="text/javascript">
            function validate()
            {
                var a = document.getElementById("First");
                var b = document.getElementById("Last");
                var c = document.getElementById("address");
                var d = document.getElementById("tel");
                var aa = document.getElementById("First").value;
                var bb = document.getElementById("Last").value;
                var dd = document.getElementById("tel").value;
                var valid = true;
                if(a.value.length<=0 || b.value.length<=0 || c.value.length<=0 || d.value.length<=0 )
                    {
                        alert("Please don't leave the field empty!");
                        valid = false;
                    }
                    else
                    {
                        if(isNaN(dd))
                        {
                            alert("Enter a number");
                        	valid = false;
                        }
                    
		                var regName = /^[a-zA-Z]+$/;
		                if(!regName.test(aa) || !regName.test(bb))
		                {
		                    alert('Invalid name given.');
		                    valid = false;
              			}
                	}
              
                return valid;
            };
        </script>
</head>
<body>

		<div class="container mt-5  d-flex justify-content-center">
		<div class="col-md-5">
	
	<form action="/CommerceWeb/" onsubmit="return validate();">
        <div class="card d-flex justify-content-center">
				<div class="card-header">
                    <h5>Shopping form</h5>  
                </div>
     <div class="card-body">
	    <div class="form-group">    
           First name: <input type="text" id="First" class="form-control"/><br>
        </div> 
        <div class="form-group">
           Last name: <input type="text" id="Last" class="form-control"/><br>
        </div>
        
         <div class="form-group">
           Address: <input type="text" id="address" class="form-control"/><br>
          </div>
          
          <div class="form-group">
           Phone number: <input type="number" id="tel" class="form-control"/><br>
          </div>
   
     </div>
     		<div class="card-footer">
            <div class="form-group">
            <button type="submit" onclick="return alert('order sent successfully')" class="btn btn-primary float-right"> Buy </button>
     </div>
     </div>
     </div>
        </form>
     </div>
     </div>
</body>
</html>