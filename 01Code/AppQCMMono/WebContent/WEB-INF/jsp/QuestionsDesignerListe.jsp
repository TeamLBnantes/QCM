<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="tag" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<base
	href="<%=request.getScheme() + "://"
			+ request.getServerName() + ":"
			+ request.getServerPort()
			+ request.getContextPath() + "/"
			%>" />
			
<!-- mise en forme via bootstrap -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<title>Management Question by Designer</title>
</head>
<body>
<div class="container">
<h3>Gestion des Questions</h3> <b><p align="right">${sessionScope.user.getFirstName()} (<a href="login/out">Déconnexion</a>)</p></b><br /><br />
</div>

<!-- Formulaire de recherche -->

<div class="container">
<form action="ManagementQuestionsDesigner/search" method="post">
<table>
<tr>
<td>Mot clé: </td>
<td><input type="text" name="motCle" /></td>
<td><button type="submit" class="btn btn-dark" name="action" value="chercher">Chercher</button></td>
<td>     --------------------------  </td>
<td><a href="ManagementQuestionsDesigner/new">
<button type="button" class="btn btn-success" name="action" value="chercher">Creer Question</button></td>
</tr>
</table>
</form>
</div><br /><br />



<!-- Formulaire d'affichage des produits -->

<div class="container">
<table class="table">
 <thead class="thead-dark">
<tr>
<th scope="col">body</th>
<th scope="col">status</th>
<th scope="col">theme</th>
<th scope="col">commentPostAnswer</th>
<th scope="col">help</th>
</tr>
</thead>
<c:forEach var="question" items="${questions}">
<tr style = "background-color:gainsboro">
<td>${question.body}</td>
<td>${question.status}</td>
<td>${question.theme}</td>
<td><a href="ManagementQuestionsDesigner/${question.id}"><button type="button" class="btn btn-success">Modifier</button></a>  <a href="ManagementQuestionsDesigner/delete/${question.id}"><button type="button" class="btn btn-danger">Supprimer</button></a></td>
</tr>
<c:forEach var="answer" items="${question.answers}">
<tr style = "background-color:yellow"><th style = "background-color:yellow" >
<td>${answer.body}</td>
<td>${answer.expectedAnswer}</td>
</th></tr>

</c:forEach>
</c:forEach>
</table>

</div>

<a href="home">home</a><br>
</body>
</html>