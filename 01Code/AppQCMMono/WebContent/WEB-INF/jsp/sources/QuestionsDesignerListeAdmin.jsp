<!-- Dossier source : QuestionDesignerListe  -->
<!-- <body> -->


	<div class="templatemo-content-widget white-bg">
			 

	<!-- 

			</tr>
		</table>
	</div>

						</td>
							 -->
	<br />
	
		<!-- Formulaire de recherche -->
	 

		<!-- <form action="" method="post"> -->
		<form name="recherche">
			<table>
				<tr>
					<td>Filtrer avec le mot clef  :  </td>
					<td width=400px><input type="text" id="motCle" class="form-control" name="motCle" /></td>
<!-- 					<td>
							<button class="templatemo-white-button" onclick="chercher()" >Chercher</button></td>
					<td><button type="reset" class="templatemo-white-button"
							name="action" value="chercher">reset</button></td> -->		
			</table>
		</form>
	<!-- 	<table> -->
	<!--fin  Formulaire de recherc -->



	<!-- Formulaire d'affichage des Questions -->

	<div class="templatemo-content-widget white-bg">
		<h2 class="text-uppercase">Liste des questions</h2>
						<div class="table-responsive">
 
 
			 <c:forEach var="question" items="${questions}"> 
			
			<!-- 	<span  class="question">  -->
			<table
				class="table table-striped table-bordered templatemo-user-table question">
					<thead>
						<tr>
													<th class="white-text templatemo-sort-by "width=5%>id</th>
							<th class="white-text templatemo-sort-by "width=40%>Intitulé</th>

							<th class="white-text templatemo-sort-by "width=10%>Theme</th>
							<th class="white-text templatemo-sort-by " width=20%>designer mail</th>
							<th class="white-text templatemo-sort-by " width=10%>reponses</th>
							<th class="white-text templatemo-sort-by " width=15%>Actions</th>
						</tr>
					</thead>


					<!-- <tbody > -->

					<tr>
											<td class="zoneRecherche">${question.id}</td>
						<td class="zoneRecherche">${question.body}</td>

						<td class="zoneRecherche">${question.topic}</td>
						<td class="zoneRecherche">${question.designer.user.email}</td>
						<%-- <td><button onclick="javascript:visibilite(repQ${question.id}); return false;" >afficher/masquer</button></td> --%>
						<td><button class="templatemo-blue-button" onclick="visibilite(`repQ${question.id}`)" >Aff./Masq.</button></td>
						<td>
								<a href="ManagementQuestionsDesigner/${question.id}" style="color: #00008B;">Update</a> / 
								<a href="ManagementQuestionsDesigner/delete/${question.id}" style="color: #FF0000;">Sup</a></td>
					</tr>

					<c:if test="${question.answers != null}">
						<tr id="repQ${question.id}" style="display:none">
							<td colspan="6">

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

					<!-- </tbody> -->
				<!--	</span>  fi de la dic class=question -->
			</table> 
				</c:forEach> 

		
		</div>

	</div>

	<br>
</body>
<footer class="text-right">
	<p>Copyright &copy; 2020 QuizizSkillz | Design: Template Mo</p>
</footer>
</html>