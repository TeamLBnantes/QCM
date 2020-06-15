
<header class="templatemo-site-header">
	<img src="resources/images/QrotatedInCircle.png" alt="QuizizSkillz Logo" width="50px"
		class="img-responsive"/>
	<h1>${sessionScope.user.getFirstName()}</h1>
	<script src="https://kit.fontawesome.com/ee94e8f5a2.js"
		crossorigin="anonymous"></script>
</header>
<div class="profile-photo-container">
	<img src="resources/images/QuizizSkillzInWhite.png"  alt="QuizizSkillz Logo"
		class="img-responsive"/>
	
</div>


<div class="mobile-menu-icon">
	<i class="fa fa-bars"></i>
</div>
<nav class="templatemo-left-nav">
	<ul>
		<li><a href="home"><i class="fa fa-home fa-fw"></i>Accueil</a></li>
		<c:if test="${isNotDesigner}">
			<br />
			<li><a href="inscription/designer"><i class="fa fa-user-cog"></i>Inscription Designer</a></li>
		</c:if>
		<c:if test="${!isNotDesigner}">

			<li><a href="ManagementQuestionsDesigner"><i
					class="fa fa-question-circle fa-fw"></i>Gestion des questions</a></li>
			<li><a href="ManagementMCQDesigner"><i
					class="fa fa-list-alt fa-fw"></i>Gestion des QCM</a></li>
		</c:if>

		<li><a href="modificationUserInformations/update"><i
				class="fa fa-user-edit fa-fw"></i>Modifications du profil</a></li>
		<c:if test="${sessionScope.user.isAdmin()}">
		<li><a href="home"><i class="fa fa-user-edit fa-fw"></i>Administration</a>
				

					<ul>
<!-- 						<li style="padding-left: 60px;"><a href="home">Admin Users</a></li> -->
						<li style="padding-left: 60px;"><a href="admin/qcm">Admin QCMs</a></li>
						<li style="padding-left: 60px;"><a href="admin/qcm/stats">Stats All QCMs</a></li>
						<li style="padding-left: 60px;"><a href="admin/question">Admin Questions</a></li>
						<li style="padding-left: 60px;"><a href="admin/question/stats">Stats All Questions</a></li>
<!-- 						<li style="padding-left: 60px;"><a href="home">Param Admin</a></li> -->
					</ul>

		
		
		</li>
		</c:if>		
		<li><a href="login/out"><i class="fa fa-eject fa-fw"></i>Déconnexion</a></li>

	</ul>
</nav>
