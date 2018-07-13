<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Projet ajouté !</title>
<link rel='stylesheet'
	href='<c:url value="/webjars/bootstrap/3.2.0/css/bootstrap.min.css"/>'>
</head>

<body>
	<div class="container">
		<h2>Informations sur le projet créé</h2>
		<table>
			<tr>
				<td>Nom :</td>
				<td>${name}</td>
			</tr>
<!-- 			<tr> -->
<!-- 				<td>ID :</td> -->
<%-- 				<td>${id}</td> --%>
<!-- 			</tr> -->
			<tr>
				<td>Administrateur :</td>
				<td>${adminId}</td>
			</tr>
			<tr>
				<td>Budget :</td>
				<td>${budget}</td>
			</tr>
		</table>


		<h2 class="page-header">Phases du projet</h2>
		<table id="phaseTable" class="table table-hover">
			<thead>
				<tr>
					<th>Nom</th>
					<th>Prérequis</th>
					<th>Semaine de début</th>
					<th>Semaine de fin</th>
					<th>Evènement de début</th>
					<th>Evènement de fin</th>
					<th>Contributeurs</th>
					<th>Suppression</th>
					<th>Edition</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${phaseList}" var="phase">
					<tr>
						<td><c:out value="${phase.name }" /></td>
						<td><c:forEach items="${phase.prerequisites}"
								var="prerequisite">
								<c:out value="${prerequisite.name }" />
								</br>
							</c:forEach></td>
						<fmt:formatDate var="startyear" value="${phase.startDate}"
							pattern="yyyy" />
						<fmt:formatDate var="startweek" value="${phase.startDate}"
							pattern="ww" />
						<td>S${startweek} - ${startyear-1900}</td>
						<fmt:formatDate var="endyear" value="${phase.endDate}"
							pattern="yyyy" />
						<fmt:formatDate var="endweek" value="${phase.endDate}"
							pattern="ww" />
						<td>S${endweek} - ${endyear-1900}</td>
						<td><c:out value="${phase.startEvent }" /></td>
						<td><c:out value="${phase.endEvent }" /></td>
						<td><c:forEach items="${phase.charges}"
								var="contributor">
								<c:out value="${contributor.key.firstName} ${contributor.key.lastName}" />
								</br>
							</c:forEach></td>
						<!-- TODO: Liens vers les méthodes suppression/édition à faire -->
						<td><span class="glyphicon glyphicon-trash"></span></td>
						<td><span class="glyphicon glyphicon-pencil"></span></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<a href="<c:url value="/project/add/${id}/addPhase"/>"
			class="btn btn-primary pull-right"> Ajouter une phase</a>
	</div>

	<div class="container">
		<a href="<c:url value="/project/add/${id}/attributeCharges"/>"
			class="btn btn-default pull-right">Assigner les charges</a>
	</div>
	<div class="container">
		<a href="<c:url value="/"/>"
			class="btn btn-default">Retour au menu principal</a>
	</div>
	<!-- SCRIPTS LIBRARY -->
	<script type="text/javascript"
		src="<c:url value ="/webjars/jquery/2.1.1/jquery.min.js"/>"></script>
	<script type="text/javascript"
		src="<c:url value="/webjars/bootstrap/3.2.0/js/bootstrap.min.js"/>"></script>
	<script
		src="http://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js"></script>

</body>
</html>