<!--PasserMCQListe.jsp  -->

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="tag" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
  
  <base
	href="<%=request.getScheme() + "://"
			+ request.getServerName() + ":"
			+ request.getServerPort()
			+ request.getContextPath() + "/"
			%>" />
			
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">  
    <title>PasserMCQListe</title>
    <meta name="description" content="">
    <meta name="author" content="templatemo">
    <!-- 
    Visual Admin Template
    https://templatemo.com/tm-455-visual-admin
    -->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,400italic,700' rel='stylesheet' type='text/css'>
    <link href="resources/css/font-awesome.min.css" rel="stylesheet">
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="resources/css/templatemo-style.css" rel="stylesheet">
         <link rel="shortcut icon" href="resources/images/favicon.ico">
    
    
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

  </head>
  <body>  
    <!-- Left column -->
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
                
            <%@ include file='sources/PasserMCQListe.jsp' %>
       
        </div>  <!-- fin de la div zone de travail principale -->
      </div>  <!-- fin de la div partie gauche de la page -->
   </div> 
    
    <!-- JS -->
    <script type="text/javascript" src="resources/js/jquery-1.11.2.min.js"></script>      <!-- jQuery -->
    <script type="text/javascript" src="resources/js/templatemo-script.js"></script>      <!-- Templatemo Script -->
    <script>
      $(document).ready(function(){
        // Content widget with background image
        var imageUrl = $('img.content-bg-img').attr('src');
        $('.templatemo-content-img-bg').css('background-image', 'url(' + imageUrl + ')');
        $('img.content-bg-img').hide();        
      });
    </script>
  </body>
</html>