<!-- dossier source : modificationUserInformations.jsp  -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="tag"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MODIFICATION INFORMATIONS PERSONNELLES</title>
<base
	href="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					+ request.getContextPath() + "/"%>" />
<script src="resources/js/modificationUserInformations.js"></script>
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,400italic,700'
	rel='stylesheet' type='text/css'>
<link href="resources/css/font-awesome.min.css" rel="stylesheet">
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/templatemo-style.css" rel="stylesheet">
</head>
<body>
	<div class="templatemo-content-container">
		<div class="templatemo-content-widget white-bg">
			<form action="modificationUserInformations/update" method="post">
				<a href="modificationUserInformations/update?lang=fr">fr</a> | <a
					href="modificationUserInformations/update?lang=en">en</a> <br />
				<div class="text-center">
					<h1>
						<tag:message code="UPDATE" text="traduction manquante!"></tag:message>
					</h1>
					<input type="hidden" name="id" value="${ user.id }" />
					<div class="templatemo-content-container">
						<div class="table-responsive">
							<table class="table table-striped table-bordered">
								<tr>
									<td><label for="lastname"><tag:message
												code="LASTNAME" text="traduction manquante!"></tag:message></label></td>
									<td><input class="form-control" type="text"
										required="required" name="lastName" id="lastName"
										value="${sessionScope.user.lastName}" /></td>
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
									<td><input class="form-control" type="text"
										required="required" name="firstName" id="firstName"
										value="${sessionScope.user.firstName}" /></td>
								</tr>
								<tr>
									<td>
										<div id="displayFirstName" class="erreurChamp"></div>
									</td>
								</tr>
								<tr>
									<td><label for="pseudo"><tag:message code="PSEUDO"
												text="traduction manquante!"></tag:message></label></td>
									<td><input class="form-control" type="text"
										required="required" name="pseudo" id="pseudo"
										value="${sessionScope.user.pseudo}" /></td>
								</tr>
								<tr>
									<td>
										<div id="displayPseudo" class="erreurChamp"></div>
									</td>
								</tr>
								<tr>
									<td><label for="mail">Modifier email</label></td>
									<td><input type="button" name="mail" id="mail"/></td>	
								</tr>
								<tr>
									<td><label for="email"><tag:message code="EMAIL"
												text="traduction manquante!"></tag:message></label></td>
									<td><input class="form-control" type="email"
										required="required" name="email" id="email"
										value="${sessionScope.user.email }" /></td>
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
									<td><input class="form-control" type="text"
										required="required" name="confirmeEmail" id="confirmEmail"
										value="${confirmedEmail}" /></td>
								</tr>
								<tr>
									<td>
										<div id="displayEmail" class="erreurChamp"></div>
									</td>
								</tr>
								<tr>
									<td><label for="pwd">Modifier mot de passe</label></td>
									<td><input type="button" name="pwd" id="pwd"/></td>	
								</tr>
								<tr>
									<td>
										<div id="displayPassword" class="erreurChamp"></div>
									</td>
								</tr>
								<tr>
									<td><label for="password"><tag:message
												code="PASSWORD" text="traduction manquante!"></tag:message></label></td>
									<td><input class="form-control" type="password"
										required="required" name="password" id="password"
										value="${sessionScope.user.password }" /></td>	
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
										required="required" name="confirmePassword"
										id="confirmPassword" value="${confirmedPassword }" /></td>
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
					<br /> <input type="submit" value="Mettre à jour"
						class="btn-lg btn-primary" />
				</div>
			</form>
		</div>
	</div>
</body>
</html>