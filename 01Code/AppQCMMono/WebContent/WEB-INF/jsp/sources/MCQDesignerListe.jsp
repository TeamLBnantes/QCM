
<body>

	<div class="container">
		<c:if test="${newMcq}">
			<!-- formulaire de cr�ation d'un nouveau qcm, afficher uniquemlent si on a cliquer sur le bouton ajouter formulaire -->
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
								<td><input type="text" class="form-control"
									name="topic" placeholder="theme"
									value="${mcq.topic}" /></td>
							</tr>
							<tr>
								<td><b>Status:</b></td>
								<td><select class="form-control" name="status" id="status">
										<c:forEach items="${ enumStatus }" var="status">
											<option value="${ status }"
												${ question.status == status ? 'selected' : '' }>
												<tag:message code="${ status.libelle }"
													text="${status.libelle }" />
											</option>
										</c:forEach>
								</select></td>
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

			<!-- fin formulaire de cr�ation du qcm -->
		</c:if>
	</div>
	<div class="container">
		<c:if test="${!newMcq}">
			<a href="ManagementMCQDesigner/new">
				<button type="button" class="templatemo-blue-button" name="action"
					value="chercher">Creer QCM</button></a>
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
							<th class="white-text templatemo-sort-by" width=60%>Intitul�</th>
							<th class="white-text templatemo-sort-by" width=10%>Statut</th>
							<th class="white-text templatemo-sort-by" width=10%>Theme</th>
							<c:if test="${!newMcq}">
								<th class="white-text templatemo-sort-by" width=20%>Action</th>
							</c:if>
					</thead>
					<c:forEach var="qcm" items="${mcqs}">
						<tr>
							<td>${qcm.body}</td>
							<td>${qcm.status}</td>
							<td>${qcm.topic}</td>
							<c:if test="${!newMcq}">
								<td><a href="ManagementMCQDesigner/${qcm.id}"><button
											type="button" class="templatemo-blue-button">
											<i class="far fa-edit"></i>
										</button></a> <a href="ManagementMCQDesigner/delete/${qcm.id}"><button
											type="button" class="templatemo-white-button">
											<i class="far fa-trash-alt" style="color: #ff4a4a"></i>
										</button></a></td>
							</c:if>
						</tr>

					</c:forEach>
				</table>
			</div>
		</div>
</body>
<footer class="text-right">
	<p>Copyright &copy; 2020 QuizizSkillz | Design: Template Mo</p>
</footer>
<!-- </html> -->