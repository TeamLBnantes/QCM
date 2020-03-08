<%-- <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

<title>Management QCM by Designer</title>
</head> --%>
<body>
Bienvenu dans la gestion des vos QCM

<div>



<c:if test="${newMcq}">
<!-- formulaire de création d'un nouveau qcm, afficher uniquemlent si on a cliquer sur le bouton ajouter formulaire -->
<!-- Formulaire d'ajout --> <!-- Ajouter required pour la validation des champs -->

<div class="container">
<br>
<h2>creation d'un nouveau QCM</h2>
<br>

<form action="ManagementMCQDesigner/createMCQ" method="post">
<table class="table table-sm">

<tr><td><b>body:</b></td><td><textarea name="body" placeholder="presentation QCM" value="${mcq.body}" required width="900px"/></textarea> </td></tr>
<tr><td><b>theme:</b></td><td><input type="text" name="commentPostAnswer" placeholder="theme" value="${mcq.theme}" width="300px"/></td></tr>
<tr><td><b>status:</b></td><td><input type="text" name="commentPostAnswer" placeholder="status" value="${mcq.status}" width="300px"/></td></tr>
 


</table>

<!-- </div> -->
<tr><td>

			<button type="submit" class="btn btn-primary" name="action" value="valider">
			Valider</button>
		
			</td><td></td></tr>
</table>
<br><br><br>
<h5>vos Qcm existant</h5><br><br>
</form>

</div>
<!-- fin formulaire de création du qcm -->
</c:if>
<c:if test="${!newMcq}">
<a href="ManagementMCQDesigner/new">
<button type="button" class="btn btn-success" name="action" value="chercher">Creer QCM</button>


 </c:if>
 
	
</div>




<!-- Formulaire d'affichage des QCM -->

<div class="container">
<table class="table">
 <thead class="thead-dark">
<tr>
<th scope="col">body</th>
<th scope="col">status</th>
<th scope="col">theme</th>
</thead>
<c:forEach var="qcm" items="${mcqs}">
<tr style = "background-color:gainsboro">
<td>${qcm.body}</td>
<td>${qcm.theme}</td>
<td>${qcm.status}</td>
<c:if test="${!newMcq}">
<td><a href="ManagementMCQDesigner/${qcm.id}"><button type="button" class="btn btn-success">Modifier</button></a>  <a href="ManagementMCQDesigner/delete/${qcm.id}"><button type="button" class="btn btn-danger">Supprimer</button></a></td>
</c:if>
</tr>

</c:forEach>
</table>

</div>








<br>
<a href="home">home</a><br>

</body>
<!-- </html> -->