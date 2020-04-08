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
    <title>Visual Admin Dashboard - Manage Users</title>
    <meta name="description" content="">
    <meta name="author" content="templatemo">
    <!-- 
    Visual Admin Template
    https://templatemo.com/tm-455-visual-admin
    
    -->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,400italic,700' rel='stylesheet' type='text/css'>
    <link href="resources/css/font-awesome.min.css" rel="stylesheet">
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
 <link href="resources/css/templatemo-style2.css" rel="stylesheet">
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
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

  </head>
  <body>  
<div class="templatemo-content-container">
<h2>process de communication autour d'une question entre designers et admin si souhait de SIGNALER la question</h2>

<c:if test="${envoyer==true}">
<br/>
<h2>votre email à bien été envoyé</h2>
	<c:if test="${messageErreur!='envoie OK'}">
		
		
		<br/><br/><br/><br/>
		
		
		message de retour : ${messageErreur}
		
		<br/><br/><br/>
	</c:if>
	<c:if test="${messageErreur=='envoie OK'}">
		
		message de retour : ${messageErreur}<br/>
		Vous pouvez fermer la fenetre<br/>
		
		info sur le mail (à mettre n forme car pas de passage à la ligne :-()): <br/><br/>
		${mailDTO.body}
		<br/><br/><br/>
	</c:if>



<!-- remettre le formulaire mais en non modifiable -->
<br/>
</c:if>
</div>
<c:if test="${envoyer==false}">
<div class="templatemo-content-container">
          <div class="templatemo-content-widget white-bg">
           
 <form action="MailEngine" class="templatemo-login-form" method="post" >        
 				<div class="row form-group">
                <div class="col-lg-12 form-group">                   
                    <div class="margin-right-15 templatemo-inline-block">
                      <input type="checkbox" name="mailToAdmin" id="c3" value="true">
                      <label for="c3" class="font-weight-400"><span></span>Admin en destinataire</label>
                    </div>
<%--                     <div class="margin-right-15 templatemo-inline-block">                       --%>
<%--                       <input type="checkbox" name="${mailToQCMDesigner}" id="c4" value="" checked> --%>
<%--                       <label for="c4" class="font-weight-400"><span></span>Concepteur du QCM en destinataire</label> --%>
<%--                     </div> --%> 
                    <div class="margin-right-15 templatemo-inline-block">                      
                      <input type="checkbox" name="mailToQuestionDesigner" id="c1" value="true" checked>
                      <label for="c1" class="font-weight-400"><span></span>Concepteur Question en destinataire</label>
                    </div>
 					<div class="margin-right-15 templatemo-inline-block">
                      <input type="checkbox" name="mailToUser" id="c5" value="true">
                      <label for="c5" class="font-weight-400"><span></span>Trace pour moi</label>                      
                    </div>
                     <div class="margin-right-15 templatemo-inline-block">
                      <input type="checkbox" name="emetteurAnonyme" id="c6" value="true" checked>
                      <label for="c6" class="font-weight-400"><span></span>Rester Anonyme (mais donc pas de réponse possible)</label>                      
                    </div>
                </div>
    	              <div class="row form-group">
                <div class="col-lg-12 has-success form-group">                  
                    <label class="control-label" for="inputWithSuccess">Titre de votre message</label>
                    <input type="text" name="titre" class="form-control" id="inputWithSuccess">
                </div>
                  <div class="row form-group">
                <div class="col-lg-12 form-group">                   
                    <label class="control-label" for="inputNote">Corp de votre mail</label>
                    <textarea class="form-control" name="body" id="inputNote"  rows="3"></textarea>
                </div>
                <input type="hidden" name="cible"  value="${cible}">        <!-- mail portant sur une question, un qcm ou une questionQCM -->
                 <input type="hidden" name="questionId"  value="${question.id}">  
              <div class="form-group text-right">
                <button type="submit" class="templatemo-blue-button">Envoyer</button>
                <button type="reset" class="templatemo-white-button">Reset</button>
                  </div> 
                  </div> 
                  </div> 
               </form> 		
  </div>  
  </div>
  </c:if>  
    <p>
										texte de la Question : <br />
									<h2 class="mb-3">${question.body}</h2>
									<br /> <br /> theme de la Question : <br />
									${question.theme} <br />
									<br /> Commentaire post réponse : <br />
									${question.commentPostAnswer} <br />
									 <br />
									<!--             	###############tableau des reps dans la fancybox########## -->
									<div class="templatemo-content-widget no-padding"> 
										<div class="panel panel-default table-responsive">
											<table
												class="table table-striped table-bordered templatemo-user-table">
												<thead>
													<tr>
														<td width="30px" class="white-text templatemo-sort-by">#
														</td>
														<td class="white-text templatemo-sort-by">Réponses
															proposée</td>
														<td width="100px" class="white-text templatemo-sort-by">Attendue</td>
													</tr>
												</thead>
												<tbody>
													<c:forEach var="answer" items="${question.answers}"
														varStatus="count">
														
														<tr>
															<td>${count.count}</td>
															<td>${answer.body}<br/>comment : ${answer.commentPostAnswer}</td>
															<td>${answer.expectedAnswer}</td>
														</tr>
														
														
															
														
													</c:forEach>
												</tbody>
											</table>
										</div>
									</div>
    
    
    
    
    
    
    
    <!-- JS -->
    <script type="text/javascript" src="resources/js/jquery-1.11.2.min.js"></script>      <!-- jQuery -->
    <script type="text/javascript" src="resources/js/templatemo-script.js"></script>      <!-- Templatemo Script -->
    <script>
/*       $(document).ready(function(){
        // Content widget with background image
        var imageUrl = $('img.content-bg-img').attr('src');
        $('.templatemo-content-img-bg').css('background-image', 'url(' + imageUrl + ')');
        $('img.content-bg-img').hide();        
      }); */
    </script>
  </body>
</html>