<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ajouter un profil</title>
<link rel='stylesheet' href='<c:url value="/webjars/bootstrap/3.2.0/css/bootstrap.min.css"/>'>
<link href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css" rel="stylesheet" />
</head>

<body>
	<div id="profile" class="container">
		<h3 class="page-header">Nouveau profil</h3>

		<form:form id ="profileForm" name="profileForm" class="form-horizontal" method="POST" action="profile"
			modelAttribute="profile">
			<div class="form-group">
				<form:label path="name" class="control-label col-sm-2">Nom du profil :</form:label>
				<div class="col-sm-3"><form:input path="name" name="name" class="form-control" placeholder="Entrez un nom"/></div>
			</div>
			<div class="form-group">
				<form:label path="tjmBase" class="control-label col-sm-2">TJM de base du profil :</form:label>
				<div class="col-sm-3"><form:input path="tjmBase" name="tjmBase" class="form-control" /></div>
			</div>
			<div class="form-group">        
      			<div class="col-sm-offset-2 col-sm-10">
        		<button id="submitForm" type="submit" class="btn btn-primary">Ajouter</button>
      			</div>
    		</div>
				
<!-- 				<tr> -->
<!-- 					<td><input type="submit" value="Ajouter ce profil" /></td> -->
<!-- 				</tr> -->
			
		</form:form>
	</div>

	<div id=footer class="container">
		<a href="<c:url value="/options/"/>" class="btn btn-default">Retour au menu options</a>
	</div>
	
	<!-- SCRIPTS LIBRARY -->
	<script type="text/javascript" src="<c:url value ="/webjars/jquery/2.1.1/jquery.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/webjars/bootstrap/3.2.0/js/bootstrap.min.js"/>"></script>
	<script src="http://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js"></script>
	
	<!-- SCRIPTS -->
	<script type="text/javascript">
		$(document).ready(function() {
			
			$("#submitForm").click(function() {

				var form = document.forms["profileForm"];
				
				var id = form["id"].value;
				var name = form["name"].value;
				var tjm = form["tjmBase"].value;
				
				toastr.options = {
						"positionClass": "toast-bottom-full-width"
				}
				
				//alert(id);
				if (name == ""){
					toastr.error("Veuillez entrer un nom pour le profil", "Nom Manquant");
					return false
					}
				if(isNaN(tjm) || tjm == ""){
					toastr.error("Veuillez entrer un nombre valide pour le TJM", "TJM invalide");
					return false
					};
			});
		});
	</script>
</body>
</html>