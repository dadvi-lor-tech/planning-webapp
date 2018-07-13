<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Gestion des plannings - Index</title>
<meta name="viewport" content="initial-scale=1, maximum-scale=1">
<link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
</head>
<body>
	<div class="container">
		<header class="page-header">
			<h1>Liste des Projets </h1>
		</header>
		
		<!-- TODO : Ajouter une barre de recherche ici -->
		<div class="panel-group">
		<c:forEach items="${projectList }" var="project">
			<div class="panel panel-default">	
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" href="#collapse${project.id}"><c:out value="${project.name }"/></a>
					</h4>
				</div>
				<div id="collapse${project.id}" class="panel-collapse collapse">
				<ul class="list-group"style="margin-bottom:0px!important">
					<c:forEach items="${project.contributors}" var="contributor"><li class="list-group-item"> 
						<a href="<c:url value="/display/${project.id }/${contributor.key.id}" />" ><c:out value="${contributor.key.firstName } ${contributor.key.lastName }"/></a> 
					</li></c:forEach>
				</ul>
				</div>
			</div>
		</c:forEach>
		</div>
		
		<c:if test="${right=='admin' || right=='sadmin'}"><a href="<c:url value="/project/add"/>" class="btn btn-primary pull-right" role="button" ><span class="glyphicon glyphicon-plus"></span> Creer un nouveau projet </a></c:if>
		<br>
		<c:if test="${right=='sadmin'}"><a href="<c:url value="/options"/>" class="btn btn-default" role="button">Options</a></c:if>	
	</div>
	<div id= "footer" class="container" style="padding-top:4px"> 
		<c:choose>
			<c:when test="${right=='admin' }">
					<p>Mode administrateur | <a href="<c:url value="/logout"/>">Logout</a></p>
					<a href="<c:url value="/slogin"/>" class="pull-right">Passer en mode
						super-administrateur</a>
			</c:when>
			<c:when test="${right=='sadmin' }">
					Mode super-administrateur | <a href="<c:url value="/logout"/>">Logout</a>
			</c:when>
			<c:otherwise>
					<a href="<c:url value="/login"/>" class="pull-right">Passer en mode
						administrateur</a>
			</c:otherwise>
		</c:choose>
	</div>
	
	<!-- SCRIPTS -->
	<script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
	<script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>