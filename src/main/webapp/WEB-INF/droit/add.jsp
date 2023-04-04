<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <% if(request.getAttribute("success") != null) {%>
    <div style="background-color: greenyellow; margin-bottom: 30px; text-align: center; border-radius: 30px; padding: 10px; color: black"><%=request.getAttribute("success")%></div>
    <%}%>
<form action="/Droit" method="post">
    <label>Nom Droit</label>
    <input type="text" name="name">
    <input type="submit" value="Enregistrer"> <br>

    <a href="/home">Allez à l'accueil</a>
</form>
</body>
</html>
