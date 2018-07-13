<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Affectation des charges</title>
</head>
<body>
	<h1>Affectation des charges - ${project.name }</h1>
	<form:form id="projectForm" method="POST" action="attributeCharges"
		modelAttribute="project" class="form-horizontal">

		<table id="tjmTable">
			<caption>Affectation des TJM</caption>
			<thead>
				<tr>
					<th>Utilisateur</th>
					<th>Profil</th>
					<th>TJM de base</th>
					<th>TJM réel</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${project.contributors}"
 					var="contributorItem"> 
					<tr>
 						<td><c:out value="${contributorItem.key.firstName} ${contributorItem.key.lastName}" /></td>
 						<td><c:out value="${contributorItem.key.profile.name}" /></td>
						<td><c:out value="${contributorItem.key.profile.tjmBase }" /></td>
						<!-- TODO: Remplir le path pour permettre la mise à jour -->
 						<td><form:input path=""
 								placeholder="${contributorItem.key.profile.tjmBase}"
 								class="form-control" /></td> 
 					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br>
		<br>

		<!-- Affiche une table pour chaque phase du projet -->
		<c:forEach items="${project.phases}" var="phaseItem">

			<!-- TODO: tester si l'id marche à la ligne suivante -->
			<table id="${phaseItem.id}">
				<!-- TODO: revoir le titre pour afficher le nombre de jours de la phase -->
				<caption>${phaseItem.name}</caption>
				<thead>
					<tr>
						<th>Utilisateur</th>
						<th>Nombre de jours pour cette phase</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${phaseItem.charges}" var="charge" varStatus="usr">
						<tr>
<%-- 							<td><c:out --%>
<%-- 									value="${user.firstName } ${user.lastName }" /></td> --%>
<!-- 							TODO: Remplir le path pour permettre la mise à jour -->
<%-- 							<td><form:input path="contributors[${usr. }]" placeholder="A definir" --%>
<%-- 									class="form-control" /></td> --%>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<br>
		</c:forEach>

		<br>
		<table id="budget">
			<tr>
				<th>Budget initial :</th>
				<td>${project.budget }</td>
			</tr>
			<tr>
				<th>Budget calculé :</th>
				<!-- TODO: faire le calcul -->
				<td>6400</td>
			</tr>
		</table>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button id="submitForm" type="submit" class="btn btn-primary">Valider</button>
			</div>
		</div>
	</form:form>
	
	
</body>
</html>