<!-- Dossier source : QuestionDesignerListe  -->
<body>

	<!-- Formulaire de recherche -->
	<!-- 
	<div class="templatemo-content-widget white-bg">
		<form action="ManagementQuestionsDesigner/search" method="post">
			<table>
				<tr>
					<td>Mot clé:</td>
					<td><input type="text" class="form-control" name="motCle" /></td>
					<td><button type="submit" class="templatemo-white-button"
							name="action" value="chercher">Chercher</button></td>
			</table>
		</form>
		<table>
			<td>--------------------------</td>

			<td>
			 -->
	<a href="ManagementQuestionsDesigner/new">
		<button type="button" class="templatemo-blue-button form-group text-center" name="action"
			value="chercher">Creer Question</button>
	</a>
	<!-- 

			</tr>
		</table>
	</div>

						</td>
							 -->
	<br />
	<br />



	<!-- Formulaire d'affichage des Questions -->

	<div class="templatemo-content-widget white-bg">
		<h2 class="text-uppercase">Liste de vos questions</h2>
		<div class="table-responsive">
			<table
				class="table table-striped table-bordered templatemo-user-table">
								<c:forEach var="question" items="${questions}">
				
				<thead>
					<tr>
						<th class="white-text templatemo-sort-by "width=40%>Intitulé</th>
						<th class="white-text templatemo-sort-by "width=10%>Statut</th>
						<th class="white-text templatemo-sort-by "width=10%>Theme</th>
						<th class="white-text templatemo-sort-by " width=30%>Commentaire</th>
						<th class="white-text templatemo-sort-by " width=10%>Actions</th>
					</tr>
				</thead>
					<tr>
						<td>${question.body}</td>
						<td>${question.status}</td>
						<td>${question.theme}</td>
						<td>${question.commentPostAnswer}</td>
						<td><a href="ManagementQuestionsDesigner/${question.id}"><button
									type="button" class="templatemo-blue-button">
									<i class="far fa-edit"></i>
								</button></a> <a href="ManagementQuestionsDesigner/delete/${question.id}"><button
									type="button" class="templatemo-white-button">
									<i class="far fa-trash-alt" style="color: #ff4a4a"></i>
								</button></a></td>
					</tr>
					<c:if test="${question.answers != null}">
						<tr>
							<td colspan="5">

								<table
									class="table table-striped table-bordered templatemo-user-table">
									<thead>
										<tr>
											<th class="grey-bg templatemo-sort-by" width=90%>Réponse</th>
											<th class="grey-bg templatemo-sort-by" width=10%>Véracité</th>

										</tr>
									</thead>
									<c:forEach var="answer" items="${question.answers}">
										<tr class="light-gray-bg">
											<td class="light-gray-bg blue-text">${answer.body}</td>
											<td class="light-gray-bg"><c:if
													test="${answer.expectedAnswer}">
													<i class="fa fa-check"></i>
												</c:if> <c:if test="${!answer.expectedAnswer}">
													<i class="fa fa-times-circle" style="color: #ff4a4a"></i>
												</c:if></td>
										</tr>
									</c:forEach>
								</table>
							</td>
						</tr>
					</c:if>
				</c:forEach>
			</table>
		</div>

	</div>

	<br>
</body>
<footer class="text-right">
	<p>Copyright &copy; 2020 QuizizSkillz | Design: Template Mo</p>
</footer>
</html>