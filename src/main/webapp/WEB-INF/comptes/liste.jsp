<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
         <table class="table table-stripe" align="center">
                       <tr class="text-center">
                           <th>ID</th>
                           <th>Username</th>
                           <th>Password</th>
                           <th>Actions</th>
                       </tr>
                       <c:forEach var="compte" items="${listecompte}">
                           <tr class="text-center">
                               <td><c:out value="${compte.id}" /></td>
                               <td><c:out value="${compte.username}" /></td>
                               <td><c:out value="${compte.password}" /></td>
                               <td>

                                <a class="btn btn-primary" href="/comptes/edit?id=<c:out value='${compte.id}'/>">Edit</a>
                                  &nbsp;&nbsp;&nbsp;&nbsp;
                                <a class="btn btn-danger" href="compte?delete?id=<c:out value='${compte.id}'/>">Delete</a>
                                <a class="btn btn-primary" href="/Add">Add</a>
                               </td>
                           </tr>
                       </c:forEach>
         </table>
        </div>
    
              
         </div>
        </div>
      </div>
</div>
</body>

</html>