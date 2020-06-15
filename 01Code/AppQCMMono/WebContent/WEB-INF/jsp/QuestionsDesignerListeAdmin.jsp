<!-- Page QuestionDesignerListe.jsp  -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="tag" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<base
	href="<%=request.getScheme() + "://"
			+ request.getServerName() + ":"
			+ request.getServerPort()
			+ request.getContextPath() + "/"
			%>" />
			
<!-- mise en forme via bootstrap -->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,400italic,700' rel='stylesheet' type='text/css'>
    <link href="resources/css/font-awesome.min.css" rel="stylesheet">
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="resources/css/templatemo-style.css" rel="stylesheet">
         <link rel="shortcut icon" href="resources/images/favicon.ico">
    
    
    
<title>QuizizSkillz Management Question by Designer</title>
</head>
<body>
<div class="templatemo-flex-row">
      <div class="templatemo-sidebar">    <!--div barre de navigation de gauche -->
       
       		<%@ include file='sources/navigateur.jsp' %>
       
      </div> <!--div de fin barre de navigation du haut -->
      <!-- Main content --> 
      <div class="templatemo-content col-1 light-gray-bg">
        <div class="templatemo-top-nav-container"> <!--div barre de navigation du haut -->

			<%@ include file='sources/barreNavigation.jsp' %>

        </div>   <!-- fin de la div barre navigation du haut -->
        <div class="templatemo-content-container"> <!--div zonne de travail principale  -->
                
            <%@ include file='sources/QuestionsDesignerListeAdmin.jsp' %>
       
        </div>  <!-- fin de la div zone de travail principale -->
      </div>  <!-- fin de la div partie gauche de la page -->
   </div> 
    
    <!-- JS -->
    <script type="text/javascript" src="resources/js/jquery-1.11.2.min.js"></script>      <!-- jQuery -->
    <script type="text/javascript" src="resources/js/templatemo-script.js"></script> 
    <script src="https://kit.fontawesome.com/ee94e8f5a2.js" crossorigin="anonymous"></script>     <!-- Templatemo Script -->
    <script>
      $(document).ready(function(){
        // Content widget with background image
        var imageUrl = $('img.content-bg-img').attr('src');
        $('.templatemo-content-img-bg').css('background-image', 'url(' + imageUrl + ')');
        $('img.content-bg-img').hide();        
      });
    </script>
    
    <script type="text/javascript" src="resources/js/QuestionsDesignerListe.js"></script>
  </body>
</html>