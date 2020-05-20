<!-- inscription.jsp  -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="tag"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> QuizizSkillz Formulaire d'Inscription</title>
<base
	href="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					+ request.getContextPath() + "/"%>" />
<script src="resources/js/inscription.js"></script>
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,400italic,700'
	rel='stylesheet' type='text/css'>
<link href="resources/css/font-awesome.min.css" rel="stylesheet">
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/templatemo-style.css" rel="stylesheet">
     <link rel="shortcut icon" href="resources/images/favicon.ico">


</head>
<body>
	<div class="templatemo-content-container">
		<div class="templatemo-content-widget white-bg">
			<form action="inscription"
				method="post">
				<!-- <div class="templatemo-content col-1 light-gray-bg"> -->

				<a href="inscription?lang=fr">fr</a> | <a href="inscription?lang=en">en</a>
				<br />

				<div class="text-center">
					<h1>
						<tag:message code="INSCRIPTION" text="traduction manquante!"></tag:message>
					</h1>
					<br>
					<h2>${message}</h2>
					<br>
					<div class="templatemo-content-container">
						<div class="table-responsive">
							<table class="table ">
								<tr>
									<td><label for="lastName"><tag:message
												code="LASTNAME" text="traduction manquante!"></tag:message></label>
									</td>
									<td><input class="form-control" type="text" id="lastName"
										name="lastName" value="${user.lastName }" required="required" />
									</td>
								</tr>
								<tr>
									<td>
										<div id="displayLastName" class="erreurChamp"></div> 
									</td>
								</tr> 
								<tr>
									<td><label for="firstName"><tag:message
												code="FIRSTNAME" text="traduction manquante!"></tag:message></label>
									</td>
									<td><input class="form-control" type="text" id="firstName"
										name="firstName" value="${user.firstName}" required="required" />
									</td>
								</tr>
								<tr>
									<td>
										<div id="displayFirstName" class="erreurChamp"></div>
									</td>
								</tr>
								<tr>
									<td><label for="email"><tag:message code="EMAIL"
												text="traduction manquante!"></tag:message></label></td>
									<td><input class="form-control" type="email" id="email"
										name="email" value="${user.email}" required="required" /></td>
								</tr>
								<tr>
									<td>
										<div id="displayEmail" class="erreurChamp"></div>
									</td>
								</tr>
								<tr>
									<td><label for="confirmEmail"><tag:message
												code="CONFIRMEMAIL" text="traduction manquante!"></tag:message></label>
									</td>
									<td><input class="form-control" type="email"
										id="confirmEmail" name="confirmEmail" value="${confirmEmail}"
										required="required" /></td>
								</tr>
								<tr>
									<td>
										<div id="displayConfirmEmail" class="erreurChamp"></div>
									</td>
								</tr>
								<tr>
									<td><label for="pseudo"><tag:message code="PSEUDO"
												text="traduction manquante!"></tag:message></label></td>
									<td><input class="form-control" type="text" id="pseudo"
										name="pseudo" value="${user.pseudo}" required="required" /></td>
								</tr>
								<tr>
									<td>
										<div id="displayPseudo" class="erreurChamp"></div>
									</td>
								</tr>
								<tr>
									<td><label for="password"><tag:message
												code="PASSWORD" text="traduction manquante!"></tag:message></label>
									</td>
									<td><input class="form-control" type="password"
										id="password" name="password" value="${user.password}"
										required="required" /></td>
								</tr>
								<tr>
									<td>
										<div id="displayPassword" class="erreurChamp"></div>
									</td>
								</tr>
								<tr>
									<td><label for="confirmPassword"><tag:message
												code="CONFIRMPASSWORD" text="traduction manquante!"></tag:message></label>
									</td>
									<td><input class="form-control" type="password"
										id="confirmPassword" name="confirmPassword"
										value="${confirmPassword}" required="required" /></td>
								</tr>
								<tr>
									<td>
										<div id="displayConfirmPassword" class="erreurChamp"></div>
									</td>
								</tr>
							</table>
						</div>
					</div>

					<div id="displayError" class="erreurChamp"></div>
					<br /> <input type="submit" value="valider" id="valider"
						class="btn-lg btn-primary" />
						<!-- </div> -->
						

			</form>
			</form>
				<!-- </div> -->
				<a href="index.jsp">						</div>
						
						 <input type="submit" value="annuler" id="valider"
						class="btn-lg btn-primary" />
						</div></a>

	</div>


</body>
</html>