<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ajouter un utilisateur</title>
<link rel='stylesheet'
	href='<c:url value="/webjars/bootstrap/3.2.0/css/bootstrap.min.css"/>'>
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css"
	rel="stylesheet" />
</head>

<body>
	<div id="user" class="container">
		<h3 class="page-header">Ajouter un utilisateur</h3>

		<form:form id="userForm" class="form-horizontal" method="POST"
			action="user" modelAttribute="user">
			<div class="form-group">
				<form:label path="firstName" class="control-label col-sm-2">Prénom de l'utilisateur :</form:label>
				<div class="col-sm-3">
					<form:input path="firstName" name="firstName" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<form:label path="lastName" class="control-label col-sm-2">Nom de l'utilisateur :</form:label>
				<div class="col-sm-3">
					<form:input path="lastName" name="lastName" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<form:label path="profile" class="control-label col-sm-2">Profil de l'utilisateur :</form:label>
				<div class="col-sm-3">
					<form:select path="profile" name="profile" class="form-control"
						placeholder="test">
						<form:option disabled="true" selected="true" value="">--- Sélectionnez un profil ---</form:option>
						<c:forEach items="${profileList}" var="profileItem">
							<form:option value="${profileItem.id}">${profileItem.name}</form:option>
						</c:forEach>
					</form:select>
				</div>
			</div>
			<div class="form-group">
				<form:label path="rightsStatus" class="control-label col-sm-2">Droits de l'utilisateur :</form:label>
				<div class="col-sm-3">
					<form:select path="rightsStatus" name="rightsStatus"
						class="form-control" placeholder="test">
						<form:option disabled="true" selected="true" value="">--- Sélectionnez une règle de droits ---</form:option>
						<form:option value="BASIC_USER">Simple utilisateur</form:option>
						<form:option value="ADMIN">Administrateur</form:option>
						<form:option value="SUPER_ADMIN">Super administrateur</form:option>
					</form:select>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button id="submitForm" type="submit" class="btn btn-primary">Ajouter</button>
				</div>
			</div>
		</form:form>
	</div>

	<div id=footer class="container">
		<a href="<c:url value="/options/"/>" class="btn btn-default">Retour
			au menu options</a>
	</div>

	<!-- SCRIPTS LIBRARY -->
	<script type="text/javascript"
		src="<c:url value ="/webjars/jquery/2.1.1/jquery.min.js"/>"></script>
	<script type="text/javascript"
		src="<c:url value="/webjars/bootstrap/3.2.0/js/bootstrap.min.js"/>"></script>
	<script
		src="http://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js"></script>

	<!-- SCRIPTS -->
	<script type="text/javascript">
		$(document)
				.ready(
						function() {

							$("#submitForm")
									.click(
											function() {

												var form = document.forms["userForm"];

												var id = form["id"].value;
												var fname = form["firstName"].value;
												var lname = form["lastName"].value;

												var profile = form["profile"].value;

												toastr.options = {
													"positionClass" : "toast-bottom-full-width"
												}

												//alert(id);
												if (fname == "") {
													toastr
															.error(
																	"Veuillez entrer un prénom pour l'utilisateur",
																	"Prénom Manquant");
													return false
												}
												if (lname == "") {
													toastr
															.error(
																	"Veuillez entrer un nom pour l'utilisateur",
																	"Nom Manquant");
													return false
												}
												if (profile == "") {
													toastr
															.error(
																	"Veuillez sélectionner un profil pour l'utilisateur",
																	"Profil manquant");
													return false
												}
												;
											});
						});
	</script>

</body>
</html>