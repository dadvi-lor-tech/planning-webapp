<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Création d'un nouveau projet</title>
<link rel='stylesheet'
	href='<c:url value="/webjars/bootstrap/3.2.0/css/bootstrap.min.css"/>'>
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css"
	rel="stylesheet" />
</head>

<body>
	<div id="project" class="container">
		<h3 class="page-header">Création d'un nouveau projet</h3>

		<form:form method="POST" id="projectFormulaire" class="form-horizontal" action="add" modelAttribute="projectForm">
			<div class="form-group">
				<form:label path="name" class="control-label col-sm-2">Nom du projet :</form:label>
				<div class="col-sm-3">
					<form:input path="name" name="name" class="form-control"/>
				</div>
			</div>
			<div class="form-group">
				<form:label path="adminId" class="control-label col-sm-2">Administrateur :</form:label>
				<div class="col-sm-3">
					<form:select path="adminId" name="adminId" class="form-control" placeholder="test">
						<form:option disabled="true" selected="true" value="">--- Sélectionnez un utilisateur ---</form:option>
						<c:forEach items="${admins}" var="adminItem">
							<form:option value="${adminItem.id}">${adminItem.firstName} ${adminItem.lastName}</form:option>
						</c:forEach>
					</form:select>
				</div>
			</div>
			<div class="form-group">
				<form:label path="budget" class="control-label col-sm-2">Budget du projet : </form:label>
				<div class="col-sm-3">
					<form:input path="budget" name="budget" class="form-control"/>
				</div>
			</div>
			
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button id="submitForm" type="submit" class="btn btn-primary">Créer le projet</button>
				</div>
			</div>
		</form:form>
	</div>

	<div id=footer class="container">
		<a href="<c:url value="/"/>" class="btn btn-default">Retour au menu principal</a>
	</div>
	
	<!-- SCRIPTS LIBRARY -->
	<script type="text/javascript" src="<c:url value ="/webjars/jquery/2.1.1/jquery.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/webjars/bootstrap/3.2.0/js/bootstrap.min.js"/>"></script>
	<script src="http://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js"></script>
	
	<!-- SCRIPTS -->
	<script>
	$(document).ready(function() {
		
		$("#submitForm").click(function() {

			var form = document.forms["projectFormulaire"];
			
			
			var name = form["name"].value
			var admin = form["adminId"].value;
			var budget = form["budget"].value;			
			
			
			toastr.options = {"positionClass": "toast-bottom-full-width"}
			
			if (name == ""){
				toastr.error("Veuillez entrer un nom pour le projet", "Nom Manquant");
				return false
				}
			if (admin == ""){
				toastr.error("Veuillez sélectionner un administrateur pour le projet", "Administrateur Manquant");
				return false
				}
			if(isNaN(budget) || budget == ""){
				toastr.error("Veuillez entrer un nombre valide pour le budget", "Budget invalide");
				return false
				};
		});
	});
	
	</script>	
</body>
</html>