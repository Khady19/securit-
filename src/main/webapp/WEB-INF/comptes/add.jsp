<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/Add" method="post">
  <div class="form-group">
    <input type="text" value="" class="form-control" id="username" placeholder="User Name" name="username" required>
  </div>
  <div class="form-group">
    <input type="text" value="" class="form-control" id="password" placeholder="Password"
    name="password" required><span toggle="#password-field" class="fa fa-fw fa-eye field-icon toggle-password"></span>
  </div>
  <div class="form-group">
    <button type="submit" class="form-control btn btn-primary submit px-3">Enregistrer</button>
  </div>
</form>
</body>
</html>