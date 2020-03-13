<!-- dossier source : home.jsp  -->

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Welcome home !</title>
	<base href="<%=request.getScheme() + "://"
			+ request.getServerName() + ":"
			+ request.getServerPort()
			+ request.getContextPath() + "/"
			%>" />
</head>
<body >
<br/>
<br/>
<div class="templatemo-content-widget white-bg text-center" >
	<h1>Bienvenue sur</h1>
	<img class="mb-4" src="resources/images/QuizizSkillz.png"
			alt=""  height="125">

	<h2>${ message }</h2>
	<br/>
	
	
<br/>
<div class="panel panel-default margin-10">
                <div class="panel-heading"><h2 class="text-uppercase">Pourquoi QuizizSkillz ?</h2></div>
                <div class="panel-body">
                  <div  class="templatemo-login-form">
                  
                  <h2>Lors du passage d’un QCM, celui qui montre le plus ses compétences, ce n’est pas celui qui passe le questionnaire, mais le créateur de ce QCM.
                  </h2>
                  <h3>Venez montrer vos talents dans des Quiz!</h3><br/>
                  <p >
                    
                    QuizizSkillz est une application Web orientée "création"<br/> <br/>
                    creez vos questions,<br/>
                    générez vos QCM à partir de vos questions ou de celles de la communauté,<br/>
                    améliorez votre travail grace aux commentaires des autres utilisateurs,<br/>
                    et passez les questionnaires des autres !
                 	
                    </p>
                    <img class="mb-4" src="resources/images/QrotatedInCircle.png"
			alt=""  height="125">
                  </div>
                </div>                
              </div>
<%-- <c:if test="${!isNotDesigner}">
<br/>
	<a href="inscription/designer">inscription Designer</a>
</c:if>
<c:if test="${isNotDesigner}"> --%>
<%-- <br/>
	<a href="modificationUserInformations/update">Modifications des informations personnelles</a>
<br/>
	<a href="ManagementQuestionsDesigner">Gestion Questions</a>
<br/>
	<a href="ManagementMCQDesigner">Gestion QCM</a>
</c:if> 
<br/>
	<a href="passerQCM">Passer QCM</a>
<br/>
--%>
<br/>


	<!-- <a href="index.jsp">Déconnexion</a> -->
	</div>

</body>
<footer class="text-right">
	<p>Copyright &copy; 2020 QuizizSkillz | Design: Template Mo</p>
</footer>
</html>