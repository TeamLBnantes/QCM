
<body>

<!-- Formulaire de recherche -->

<div class="templatemo-content-widget white-bg">
<form action="ManagementQuestionsDesigner/search" method="post">
<table>
<tr>
<td>Mot clé: </td>
<td><input type="text" class="form-control" name="motCle" /></td>
<td><button type="submit" class="templatemo-white-button" name="action" value="chercher">Chercher</button></td>

</table>
</form>
<table>
<td>     --------------------------  </td>

<td><a href="ManagementQuestionsDesigner/new">
<button type="button" class="templatemo-blue-button" name="action" value="chercher">Creer Question</button></td>

</tr>
</table>
</div><br /><br />



<!-- Formulaire d'affichage des Questions -->

<div class="templatemo-content-widget white-bg">
<table
				class="table table-striped table-bordered templatemo-user-table">
				<thead>
<tr>
<th class="white-text templatemo-sort-by">Intitulé</th>
<th class="white-text templatemo-sort-by">Statut</th>
<th class="white-text templatemo-sort-by">Theme</th>
<th class="white-text templatemo-sort-by">Commentaire</th>
<th class="white-text templatemo-sort-by">Actions</th>
</tr>
</thead>
<c:forEach var="question" items="${questions}">
<tr>
<td>${question.body}</td>
<td>${question.status}</td>
<td>${question.theme}</td>
<td>${question.commentPostAnswer}</td>
<td><a href="ManagementQuestionsDesigner/${question.id}"><button type="button" class="templatemo-blue-button"><i class="far fa-edit"></i></button></a>  <a href="ManagementQuestionsDesigner/delete/${question.id}"><button type="button" class="templatemo-white-button"><i class="far fa-trash-alt" style="color:#ff4a4a"></i></button></a></td>
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