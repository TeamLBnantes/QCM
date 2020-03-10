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
<body>
	<h1>Home, sweet home !</h1>

	${ message }<br/>
<br/>
<c:if test="${!isDesigner}">
<br/>
	<a href="inscription/designer">inscription Designer</a>
</c:if>
<c:if test="${isDesigner}">
<br/>
	<a href="modificationUserInformations/update">Modifications des informations personnelles</a>
<br/>
	<a href="ManagementQuestionsDesigner">Gestion Questions</a>
<br/>
	<a href="ManagementMCQDesigner">Gestion QCM</a>
</c:if>
<br/>

	<a href="index.jsp">Déconnexion</a>
</body>
</html>