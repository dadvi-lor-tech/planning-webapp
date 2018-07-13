<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ajouter une phase</title>
<link rel='stylesheet'
	href='<c:url value="/webjars/bootstrap/3.2.0/css/bootstrap.min.css"/>'>
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css"
	rel="stylesheet" />
</head>

<body>
	<div id="phase" class="container">
		<h3 class="page-header">Ajouter une phase</h3>

		<form:form id="phaseForm" method="POST" action="addPhase" modelAttribute="phase" class="form-horizontal">
			<div class="form-group">
				<form:label path="name" class="control-label col-sm-2">Nom :</form:label>
				<div class="col-sm-3">
					<form:input path="name" name="name" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<form:label path="prerequisites" class="control-label col-sm-2">Prérequis :</form:label>
				<div class="col-sm-3">
					<form:select path="prerequisites" name="prerequisites"
						class="form-control" multiple="true">
						<form:option disabled="true" selected="true" value="">--- Sélectionnez les prérequis ---</form:option>
						<c:forEach items="${project.phases}" var="phaseItem">
							<form:option value="${phaseItem.id}">${phaseItem.name}</form:option>
						</c:forEach>
					</form:select>
				</div>
			</div>
			<div class="form-group">
				<form:label path="startDate" class="control-label col-sm-2">Semaine de début :</form:label>
				<div class="col-sm-3">
					<form:input path="startDate" name="startDate" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<form:label path="endDate" class="control-label col-sm-2">Semaine de fin :</form:label>
				<div class="col-sm-3">
					<form:input path="endDate" name="endDate" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<form:label path="startEvent" class="control-label col-sm-2">Evènement de début :</form:label>
				<div class="col-sm-3">
					<form:input path="startEvent" name="startEvent"
						class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<form:label path="endEvent" class="control-label col-sm-2">Evènement de fin :</form:label>
				<div class="col-sm-3">
					<form:input path="endEvent" name="endEvent" class="form-control" />
				</div>
			</div>
<!-- 			<div class="form-group"> -->
<%-- 				<form:label path="contributors" class="control-label col-sm-2">Contributeurs :</form:label> --%>
<!-- 				<div class="col-sm-3"> -->
<%-- 					<form:select path="charges.key"  --%>
<%-- 						class="form-control" multiple="true"> <!--  path="contributors" name="contributors" --> --%>
<%-- 						<form:option disabled="true" selected="true" value="">--- Sélectionnez les contributeurs ---</form:option> --%>
<%-- 						<c:forEach items="${userList}" var="userItem"> --%>
<%-- 							<form:option value="${userItem}">${userItem.firstName} ${userItem.lastName}</form:option> --%>
<%-- 						</c:forEach> --%>
<%-- 					</form:select> --%>
<!-- 				</div> -->
<!-- 			</div> -->
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button id="submitForm" type="submit" class="btn btn-primary">Ajouter
						cette phase</button>
				</div>
			</div>
		</form:form>
	</div>

	<div id=footer class="container">
		<a href="<c:url value="/project/add"/>" class="btn btn-default">Retour
			au projet</a>
	</div>

	<!-- SCRIPTS LIBRARY -->
	<script type="text/javascript" src="<c:url value ="/webjars/jquery/2.1.1/jquery.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/webjars/bootstrap/3.2.0/js/bootstrap.min.js"/>"></script>
	<script src="http://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js"></script>

	<!-- SCRIPTS -->
	<script type="text/javascript">
		$(document).ready(function() {
			
			$("#submitForm").click(function() {

				var form = document.forms["phaseForm"];
				
				var name = form["name"].value;
				var startDate = form["startDate"].value;
				var endDate = form["endDate"].value;
				
				
				toastr.options = { "positionClass": "toast-bottom-full-width" }
				
				if (name == ""){
					toastr.error("Veuillez entrer un nom pour la phase", "Nom Manquant");
					return false
					}
				//TODO: Stardatae ERScfhgcxduuyglbv
			});
		});
	</script>
</body>
</html>