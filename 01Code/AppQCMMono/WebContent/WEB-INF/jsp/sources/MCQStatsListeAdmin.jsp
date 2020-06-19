
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
		<div class="templatemo-content-widget white-bg">
		

			<h2 class="text-uppercase">les Stats des QCMs</h2>
			<div class="table-responsive">
				<table
					class="table table-striped table-bordered templatemo-user-table">
					<thead>
						<tr>
							<th class="white-text templatemo-sort-by" width=5%>id</th>
							<th class="white-text templatemo-sort-by" width=5%>detail</th>
							<th class="white-text templatemo-sort-by" width=30%>Intitulé</th>
							<th class="white-text templatemo-sort-by" width=5%>nb Q</th>
							<th class="white-text templatemo-sort-by" width=10%>nb play</th>
							<th class="white-text templatemo-sort-by" width=15%> pseudo designer</th>
							<th class="white-text templatemo-sort-by" width=10%>nb final</th>
							<th class="white-text templatemo-sort-by" width=10%>tx Réussite</th>
							<th class="white-text templatemo-sort-by" width=10%>date Last</th>

					</thead>
					<c:forEach var="statsMCQdto" items="${statsMCQdtos}" varStatus="countQCM">
						<tr>
						 <!-- fin de la ligne du stat du qcm  -->
						 <!-- je vais mettre un lien sur la ligne vers affichage des detail dans une fancyBox -->
						 <td>${statsMCQdto.id}</td>
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
							<td>${statsMCQdto.pseudoDesigner}</td>
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








	<!-- fin affichage des stats========================================================================== -->	

	
		
</body>
<footer class="text-right">
	<p>Copyright &copy; 2020 QuizizSkillz | Design: Template Mo</p>
</footer>
<!-- </html> -->