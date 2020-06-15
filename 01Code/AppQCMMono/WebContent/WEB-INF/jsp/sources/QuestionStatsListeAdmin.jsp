
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
		

			<h2 class="text-uppercase">les Stats des Questions</h2>
			<div class="table-responsive">
				<table
					class="table table-striped table-bordered templatemo-user-table">
					<thead>
						<tr>
							<th class="white-text templatemo-sort-by" width=10%>id</th>
							<th class="white-text templatemo-sort-by" width=5%>detail</th>
							<th class="white-text templatemo-sort-by" width=40%>Intitulé</th>
							<th class="white-text templatemo-sort-by" width=15%> mail designer</th>								
							<th class="white-text templatemo-sort-by" width=10%>use in nb QCM</th>
							<th class="white-text templatemo-sort-by" width=10%>nb reponses</th>
							<th class="white-text templatemo-sort-by" width=10%>nb Réussite</th>
					</thead>
					<c:forEach var="statsQuestionDto" items="${statsQuestiondtos}" varStatus="countQuestion">
						<tr>
						 <!-- fin de la ligne du stat du qcm  -->
						 <!-- je vais mettre un lien sur la ligne vers affichage des detail dans une fancyBox -->
						 <td>${statsQuestionDto.id}</td>
						 <td>
						 
						 <!-- gestion fancybox -->
				<a data-fancybox="hello"
				data-src="#hello${countQuestion.count}" href="javascript:;"> détail </a>
				
					<form id="hello${countQuestion.count}" action="" method="post"
									style="display: none; width: 80%; ">
									<h4 class="mb-3">Détail des Stats de  la Question</h4>
									<br />
						<!-- Stats dans la fancybox ==============================================================-->
						id de la question : ${statsQuestionDto.id}<br>
						énnoncé de la question : ${statsQuestionDto.body}<br>
						nombre de QCM utilisant cette question : ${statsQuestionDto.nbUsedByQcms}<br>
						nombre de réponses (global) à cette question: ${statsQuestionDto.nbAnswered}<br>
						nombre de bonnes réponses (tjs sur global)  : ${statsQuestionDto.nbCorrect}<br>
						email designer de cette question : ${statsQuestionDto.designer.user.email}<br>
	
						<br>
						<!-- affichage stats QuestionUsed dans fancyboxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx -->
						<br>
						 <div class="container">
							<div class="templatemo-content-widget grey-bg">
								<h2 class="text-uppercase">Stats de cette question par QCM l'utilisant</h2>
								<div class="table-responsive">
									<table
										class="table table-striped table-bordered templatemo-user-table">
										<thead>
											<tr><th class="white-text templatemo-sort-by" width=10%>id Qcm</th>
											<th class="white-text templatemo-sort-by" width=40%>body</th>
											<th class="white-text templatemo-sort-by" width=15%>theme</th>
											    <th class="white-text templatemo-sort-by" width=10%>nb reponses</th>
												<th class="white-text templatemo-sort-by" width=10%>nb bonnes reponse</th>
												<th class="white-text templatemo-sort-by" width=15%>mail designer</th>			
										</thead>
										<c:forEach var="StatsQuestionUsedDto" items="${statsQuestionDto.questionUsedDtos}">
											<tr>
											 <td>${StatsQuestionUsedDto.idMcq}</td>
											 <td>${StatsQuestionUsedDto.bodyMCQ}</td>
											 <td>${StatsQuestionUsedDto.topicMCQ}</td>
											 <td>${StatsQuestionUsedDto.nbAnswered}</td>
											 <td>${StatsQuestionUsedDto.nbCorrect}</td>
											 <td>${StatsQuestionUsedDto.mailDesignerMcq}</td>
											 </tr>
										</c:forEach>
									 </table>
									 </div>
									 </div>
									 </div>
									 <br>
						
						<!-- affichage stats QuestionUsed dans fancyboxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx -->
						


						<!-- fin Stats dans la fancybox =============================================================-->
									<br />
									
									<p class="mb-0 text-right">
										<input data-fancybox-close type="button"
											class="templatemo-edit-btn" value="Fermer" />
									</p>
								</form>  
								<!-- fin de la fancybox ============================================ -->
								
								
								</td>
							<td>${statsQuestionDto.body}</td>
							<td>${statsQuestionDto.designer.user.email}</td>
							<td>${statsQuestionDto.nbUsedByQcms}</td>
							<td>${statsQuestionDto.nbAnswered}</td>
							<td>${statsQuestionDto.nbCorrect}</td>
			
						
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