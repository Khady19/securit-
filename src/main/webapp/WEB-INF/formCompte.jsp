<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" type="text/css" rel="stylesheet"/>
<link href="css/style.css" type="text/css" rel="stylesheet"/>
<link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.0.1/mdb.min.css" rel="stylesheet"/>
</head>
<body>
<div class="container-sm">
      <div class="row">
       
        <div class="col-12 mt-2 py-2">
              
    <div class="panel panel-primary">
      <div class="panel-heading text-center"><h2>Liste des comptes</h2></div>
        <div class="panel-body" align="center">
         <form action="/comptes/edit" method="post">
         <input type="hidden" name="id" value="<c:out value="${compte.id}" />" />
					<div class="form-group">
				<input type="text" value="<c:out value="${compte.username}" />"
             class="form-control" id="username" placeholder="User Name"
             name="username" required>		      	
             	</div>
	            <div class="form-group">
			<input type="text" value="<c:out value="${compte.password}" />" class="form-control" id="password" placeholder="Password"
             name="password" required><span toggle="#password-field" class="fa fa-fw fa-eye field-icon toggle-password"></span>
	            </div>
	            <div class="form-group">
	            	<button type="submit" class="form-control btn btn-primary submit px-3">Sign In</button>
	            </div>
	            
	            
	          </form>
        </div>
    
              
         </div>
        </div>
      </div>
</div>
</body>
</html>