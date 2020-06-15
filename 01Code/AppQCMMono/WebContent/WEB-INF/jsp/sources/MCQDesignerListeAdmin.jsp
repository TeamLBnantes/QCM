



<!-- dossier source : MCQDesignerList.jsp  -->
<body>



	<!-- Formulaire d'affichage des QCM -->

	<div class="container">
		<div class="templatemo-content-widget white-bg">
		

			<h2 class="text-uppercase">Ensemble des Qcm existants</h2>
			<div class="table-responsive">
				<table
					class="table table-striped table-bordered templatemo-user-table">
					<thead>
						<tr>
							<th class="white-text templatemo-sort-by" width=5%>id</th>
							<th class="white-text templatemo-sort-by" width=55%>Intitulé</th>
							<th class="white-text templatemo-sort-by" width=10%>designer email</th>
							<th class="white-text templatemo-sort-by" width=15%>Theme</th>
							<c:if test="${!newMcq}">
								<th class="white-text templatemo-sort-by" width=15%>Action</th>
							</c:if>
					</thead>
					<c:forEach var="qcm" items="${mcqs}">
						<tr>
							<td>${qcm.id}</td>
							<td>${qcm.body}</td>
							<td>${qcm.designer.user.email}</td>
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
						
	
		
</body>
<footer class="text-right">
	<p>Copyright &copy; 2020 QuizizSkillz | Design: Template Mo</p>
</footer>
<!-- </html> -->