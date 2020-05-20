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
<!-- <script src="resources/media/lib/jquery-3.3.1.min.js"></script> -->
    <script type="text/javascript" src="resources/js/jquery-1.11.2.min.js"></script>      <!-- jQuery -->
    <script type="text/javascript" src="resources/js/templatemo-script.js"></script>      <!-- Templatemo Script -->
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,400italic,700'
	rel='stylesheet' type='text/css'>
<link href="resources/css/font-awesome.min.css" rel="stylesheet">
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/templatemo-style.css" rel="stylesheet">
<link href="resources/css/modificationUserInformations.css" rel="stylesheet">

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
		<c:if test="${(messageProblemeChangeEmail != '')}">
		<h4>${messageProblemeChangeEmail}<tag:message code="MAILALREADYUSED" text="traduction manquante!"></tag:message></h4>
		</c:if>
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
<!-- gestion de l'email  -->
							
								<tr>
									<!-- <td><label for="mail">Modifier email</label></td> disabled checked -->
									<td><label for="pwd"><tag:message
												code="CHANGEEMAIL" text="traduction manquante!"></tag:message></label>
									</td>
									<td>
									<!--  <input type="button" name="mail" id="mail" /> -->
									 <input type="checkbox" name="changeMailDemande"
													id="gestionMail" value="false"><label
								for="gestionMail" class="font-weight-400"><span></span></label>
									 </td>	 
								</tr>

<tr>
 	<td  colspan="100%"> 
		<table class="table table-striped table-bordered" id="afficherMail" style="display:none">
		
										<tr>
									<td><label for="email"><tag:message code="EMAIL"
												text="traduction manquante!"></tag:message></label></td>
									<td ><input class="form-control" type="email"
										 name="email" id="email"
										value="${sessionScope.user.email }"/></td>
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
										 name="confirmEmail" id="confirmEmail"
										value="${confirmedEmail}" /></td>
								</tr>
								<tr>
									<td>
										<div id="displayConfirmEmail" class="erreurChamp"></div>
									</td>
								</tr>
         </table>
    </td> 
</tr>
		



<!-- gestion du mot de passe  -->

								<tr><td><label for="pwd"><tag:message
												code="CHANGEPWD" text="traduction manquante!"></tag:message></label>
									</td>
									<!-- <td><label for="pwd">Modifier mot de passe</label></td> -->
									<td><input type="checkbox"  name="changePasswordDemande"
													id="gestionPassword" value="false"><label
								for="gestionPassword" class="font-weight-400"><span></span></label>
									 </td>	 
								</tr>
								
<tr>
 	<td  colspan="100%"> 
		<table class="table table-striped table-bordered" id="afficherPassword" style="display:none">
								
								
								<tr>
									<td><label for="password"><tag:message
												code="NEWPASSWORD" text="traduction manquante!"></tag:message></label></td>
									<td><input class="form-control" type="password"
										name="password" id="password"
										value="" /></td>
										<%-- value="${sessionScope.user.password }" /></td>	 --%>
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
										 name="confirmePassword"
										id="confirmPassword" value="" /></td>
										<%-- id="confirmPassword" value="${confirmedPassword }" /></td> --%>
								</tr>
								<tr>
									<td>
										<div id="displayConfirmPassword" class="erreurChamp"></div>
									</td>
								</tr>
								
		</table>
    </td> 
</tr>
								
								
							</table>
						</div>
					</div>
					<div id="displayError" class="erreurChamp"></div>

					<br /> <input type="submit" id="valider" value="valider"
						class="btn-lg btn-primary" />
				</div>
			</form>
		</div>
	</div>
</body>
</html>