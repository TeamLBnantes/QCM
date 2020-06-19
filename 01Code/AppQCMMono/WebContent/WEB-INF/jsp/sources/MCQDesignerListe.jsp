
<link href="resources/media/lib/fancybox/dist/jquery.fancybox.min.css"
	rel="stylesheet">
<!-- <link href="resources/media/lib/bootstrap-4.4.1-dist/css/bootstrap.min.css" rel="stylesheet"> -->
<style type="text/css">
.thumb {
	width: 100%;
}

/* pour le texte sur l'image, tmp' */
.container {
	position: relative;
}

.center {
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	font-size: 24px;
	color: red;
}

/* fin pour le texte sur l'image, tmp' */
</style>

<script src="resources/media/lib/jquery-3.3.1.min.js"></script>
<script src="resources/media/lib/fancybox/dist/jquery.fancybox.min.js"></script>




<!-- dossier source : MCQDesignerList.jsp  -->
<body>

	
	
	<div class="container">
		<c:if test="${newMcq}">
			<!-- formulaire de création d'un nouveau qcm, afficher uniquemlent si on a cliquer sur le bouton ajouter formulaire -->
			<!-- Formulaire d'ajout -->
			<!-- Ajouter required pour la validation des champs -->
			<form action="ManagementMCQDesigner/createMCQ" method="post">
				<div class="templatemo-content-widget white-bg">
					<h2 class="text-uppercase">creation d'un nouveau QCM</h2>
					<div class="table-responsive">
						<table
							class="table table-striped table-bordered templatemo-user-table">

							<tr>
								<td><b>Sujet du QCM</b></td>
								<td><textarea name="body" class="form-control"
										placeholder="presentation QCM" required> ${mcq.body} </textarea></td>
							</tr>
							<tr>
								<td><b>Theme(s)</b></td>
								<td><input type="text" class="form-control" name="topic"
									placeholder="theme" value="${mcq.topic}" /></td>
							</tr>
							<tr>   
								<td><b>Statut:</b></td>
								<td><select class="form-control" name="status" id="status">
										<c:forEach items="${ enumStatus }" var="status">
											<option value="${ status }"
												${ mcq.status == status ? 'selected' : '' }>
												<tag:message code="${ status.libelle }"
													text="${status.libelle }" />
											</option>
										</c:forEach>
								</select></td>
							</tr>
							<!-- enum du typ emultimedia -->
							<tr>
								<td><b>Type Multimedia:</b></td>
								<td><select class="form-control" name="multimedia.typeMultimedia" id="typeMultimedia">
										<c:forEach items="${ enumTypeMultimedia }" var="typeMultimedia">
											<option value="${ typeMultimedia }"
												${ mcq.multimedia.typeMultimedia == typeMultimedia ? 'selected' : '' }>
												<tag:message code="${ typeMultimedia.libelle }"
													text="${typeMultimedia.libelle }" />
											</option>
										</c:forEach>
								</select></td>
							</tr>
							<tr>
								<td><b>cible (jpg) Vignette du contenu
							multimedia (audio/video)</b></td>
								<td><input type="text" class="form-control" name="multimedia.adresseVignette"
									placeholder="adresse image" value="${mcq.multimedia.adresseVignette}" /></td>
							</tr>
							<tr>
								<td><b>cible du contenu multimedia</b></td>
								<td><input type="text" class="form-control" name="multimedia.adresseCible"
									placeholder="cible multimedia" value="${mcq.multimedia.adresseCible}" /></td>
							</tr>
							<tr>
								<td><b>legende du contenu multimedia</b></td>
								<td><input type="text" class="form-control" name="multimedia.legende"
									placeholder="legende" value="${mcq.multimedia.legende}" /></td>
							</tr>
						</table>
					</div>
					<!-- </div> -->
					</table>
					<br />
					<button type="submit" class="btn btn-primary " name="action"
						value="valider">Valider</button>
				</div>
			</form>

			<!-- fin formulaire de création du qcm -->
		</c:if>
	</div>
	<div class="container">
		<c:if test="${!newMcq}">
		<div>
			<a href="ManagementMCQDesigner/new">
				<button type="button" class="templatemo-blue-button" name="action"
					value="chercher">Creer QCM</button>
			</a>
			</div>
		</c:if>
	</div>

	<!-- Formulaire d'affichage des QCM -->

	<div class="container">
		<div class="templatemo-content-widget white-bg">
		

			<h2 class="text-uppercase">Vos Qcm existants</h2>
			<div class="table-responsive">
				<table
					class="table table-striped table-bordered templatemo-user-table">
					<thead>
						<tr>
							<th class="white-text templatemo-sort-by" width=55%>Intitulé</th>
							<th class="white-text templatemo-sort-by" width=10%>Statut</th>
							<th class="white-text templatemo-sort-by" width=20%>Theme</th>
							<c:if test="${!newMcq}">
								<th class="white-text templatemo-sort-by" width=15%>Action</th>
							</c:if>
					</thead>
					<c:forEach var="qcm" items="${mcqs}">
						<tr>
							<td>${qcm.body}</td>
							<td>${qcm.status}</td>
							<td>${qcm.topic}</td>
							<c:if test="${!newMcq}">
								<td><a href="ManagementMCQDesigner/${qcm.id}" style="color: #00008B;"><strong>Update</strong></a> / <a href="ManagementMCQDesigner/delete/${qcm.id}" style="color: #FF0000;">Sup</a></td>
							</c:if>
						</tr>

					</c:forEach>
				</table>
			</div>
			
		</div>
		
	</div>				
						<!-- temporaire, lancer les stats -->
	<c:if test="${!newMcq && !stats}">
		<div class="container">
			<a href="ManagementMCQDesigner/statsMcq">
				<button type="button" class="templatemo-blue-button" name="action"
					value="chercher">Afficher les stats</button>
			</a>
		</div>
	</c:if>
	<!-- temporaire, fin lancer les stats -->
	<!-- affichage des stats ==========================================================================-->
	<c:if test="${!newMcq && stats}">

<div class="container">
		<div class="templatemo-content-widget white-bg">
		

			<h2 class="text-uppercase">les Stats de vos QCM</h2>
			<div class="table-responsive">
				<table
					class="table table-striped table-bordered templatemo-user-table">
					<thead>
						<tr><th class="white-text templatemo-sort-by" width=5%>detail</th>
							<th class="white-text templatemo-sort-by" width=35%>Intitulé</th>
							<th class="white-text templatemo-sort-by" width=10%>nb Q</th>
							<th class="white-text templatemo-sort-by" width=10%>nb play</th>
							<th class="white-text templatemo-sort-by" width=10%>tx parcours</th>
							<th class="white-text templatemo-sort-by" width=10%>nb final</th>
							<th class="white-text templatemo-sort-by" width=10%>tx Réussite</th>
							<th class="white-text templatemo-sort-by" width=10%>date Last</th>

					</thead>
					<c:forEach var="statsMCQdto" items="${statsMCQdtos}" varStatus="countQCM">
						<tr>
						 <!-- fin de la ligne du stat du qcm  -->
						 <!-- je vais mettre un lien sur la ligne vers affichage des detail dans une fancyBox -->
						 <td>
				<a data-fancybox="hello"
				data-src="#hello${countQCM.count}" href="javascript:;"> détail </a>
				
					<form id="hello${countQCM.count}" action="" method="post"
									style="display: none; width: 80%; ">
									<h4 class="mb-3">Détail des Stats du QCM</h4>
									<br />
						<!-- Stats dans la fancybox ==============================================================-->
						id du QCM : ${statsMCQdto.id}<br>
						titre du QCM : ${statsMCQdto.qcmBody}<br>
						nombre de question de QCM : ${statsMCQdto.nbQuestionUsed}<br>
						nombre de joueur de ce QCM (ayant jouer au moins 1 des questions, depuis webApp): ${statsMCQdto.nbPlayeur}<br>
						taux de parcours des questions : <fmt:formatNumber type = "number" 
         								pattern = ".## %" value = "${statsMCQdto.tauxDeParcourQuestion}" /><br>
						nombre de joueur ayant finalisé le QCM : ${statsMCQdto.nbPlayComplete}<br>
						taux de réussite global : <fmt:formatNumber type = "number" 
         									pattern = ".## %" value = "${statsMCQdto.tauxDeReussite}" /><br>
						(si un joueur n'a pas parcouru une question, elle est considerée comme fausse)<br>
						Date du dernier passage : <fmt:parseDate value="${statsMCQdto.dateLast}" pattern="yyyy-MM-dd" var="myDate"/>
							<fmt:formatDate value="${myDate}" pattern="dd-MMM-yy"/><br>
						<br>
						<!-- affichage stats QuestionUsed dans fancyboxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx -->
						<br>
						 <div class="container">
							<div class="templatemo-content-widget grey-bg">
								<h2 class="text-uppercase">Stats sur les Questions de ce QCM</h2>
								<div class="table-responsive">
									<table
										class="table table-striped table-bordered templatemo-user-table">
										<thead>
											<tr><th class="white-text templatemo-sort-by" width=10%>id Q</th>
											<th class="white-text templatemo-sort-by" width=70%>body</th>
											    <th class="white-text templatemo-sort-by" width=10%>nb reponses</th>
												<th class="white-text templatemo-sort-by" width=10%>nb bonnes reponse</th>
															
										</thead>
										<c:forEach var="questionUsed" items="${statsMCQdto.questionsUsed}">
											<tr>
											 <td>${questionUsed.question.id}</td>
											 <td>${questionUsed.question.body}</td>
											 <td>${questionUsed.nbAnswered}</td>
											 <td>${questionUsed.nbCorrect}</td>
											 </tr>
										</c:forEach>
									 </table>
									 </div>
									 </div>
									 </div>
									 <br>
						
						<!-- affichage stats QuestionUsed dans fancyboxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx -->
						
						 <!-- affichage mcqsPassed dans fancyboxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx -->
						<br>
						 <div class="container">
							<div class="templatemo-content-widget grey-bg">
								<h2 class="text-uppercase">Suivi des jeux de ce QCM</h2>
								<div class="table-responsive">
									<table
										class="table table-striped table-bordered templatemo-user-table">
										<thead>
											<tr><th class="white-text templatemo-sort-by" width=10%>nb bonne rep</th>
											    <th class="white-text templatemo-sort-by" width=10%>finalisé</th>
												<th class="white-text templatemo-sort-by" width=5%>nb Q rep</th>
												<th class="white-text templatemo-sort-by" width=5%>nb Q Totale</th>
												<th class="white-text templatemo-sort-by" width=10%>date</th>
												<th class="white-text templatemo-sort-by" width=50%>mail_declaré</th>
												<th class="white-text templatemo-sort-by" width=10%>signature</th>			
										</thead>
										<c:forEach var="MCQpassed" items="${statsMCQdto.mcqsPassed}">
											<tr>
											 <td>${MCQpassed.result}</td>
											 <td>${MCQpassed.finalise}</td>
											 <td>${MCQpassed.nbQuestionRep}</td>
											 <td>${MCQpassed.nbQuestionTotal}</td>
											 <td><fmt:parseDate value="${MCQpassed.date}" pattern="yyyy-MM-dd" var="myDate1"/>
							<fmt:formatDate value="${myDate1}" pattern="dd-MMM-yy"/></td>
											 <td>${MCQpassed.mailDeclaratifWebApp}</td>
											 <td>${MCQpassed.signatureAutentification}</td>
											 </tr>
										</c:forEach>
									 </table>
									 </div>
									 </div>
									 </div>
									 <br>
						<!-- fin affichage mcqsPassed dans fancyboxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx -->

						<!-- fin Stats dans la fancybox =============================================================-->
									<br />
									
									<p class="mb-0 text-right">
										<input data-fancybox-close type="button"
											class="templatemo-edit-btn" value="Fermer" />
									</p>
								</form>  <!-- fin de la fancybox ============================================ -->
								</td>
							<td>${statsMCQdto.qcmBody}</td>
							<td>${statsMCQdto.nbQuestionUsed}</td>
							<td>${statsMCQdto.nbPlayeur}</td>
							<td><fmt:formatNumber type = "number" 
         pattern = ".## %" value = "${statsMCQdto.tauxDeParcourQuestion}" /></td>
							<td>${statsMCQdto.nbPlayComplete}</td>
							<td><fmt:formatNumber type = "number" 
         pattern = ".## %" value = "${statsMCQdto.tauxDeReussite}" /></td>
							<td>
							<fmt:parseDate value="${statsMCQdto.dateLast}" pattern="yyyy-MM-dd" var="myDate"/>
							<fmt:formatDate value="${myDate}" pattern="dd-MMM-yy"/></td>
						
						
						

						
						<!-- fin de la ligne du stat du qcm  -->
						</tr>

					</c:forEach>
				</table>
			</div>
			
		</div>
		
	</div>				







	</c:if>
	<!-- fin affichage des stats========================================================================== -->	

	
		
</body>
<footer class="text-right">
	<p>Copyright &copy; 2020 QuizizSkillz | Design: Template Mo</p>
</footer>
<!-- </html> -->