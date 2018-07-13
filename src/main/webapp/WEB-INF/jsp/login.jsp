<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel='stylesheet' href='<c:url value="/webjars/bootstrap/3.2.0/css/bootstrap.min.css"/>'>
</head>
<body>


<div class="container">
	<h3 class="page-header">Passer en mode ${rightvalue=='admin' ? 'administrateur': 'super-administrateur'}</h3>
	<c:if test="${isFalsePassword}"> <div class="panel panel-danger"><div class="panel-heading"> Le mot de passe est incorrect</div></div></c:if>
	<form class="form-inline" method="POST" action="<c:url value="/login" />">
		<input type="hidden" name="right" value="${rightvalue }"/>
		<div class="form-group">	
			<label class="control-label">Mot de passe :</label>
			<input type="password" name="password" class="form-control" placeholder="Entrez le mot de passe"/>
		</div>
		<div class="form-group">
        	<button id="submitForm" type="submit" class="btn btn-primary">Passer en mode ${rightvalue=='admin' ? 'administrateur': 'super-administrateur'}</button>
		</div>
	</form>
</div>

<div class="container" style="padding-top: 20px;">
	<a href="<c:url value="/"/>" class="btn btn-default" role="button">Retour au menu principal</a>
</div>

<!-- Scripts Library -->
<script type="text/javascript" src="<c:url value ="/webjars/jquery/2.1.1/jquery.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/webjars/bootstrap/3.2.0/js/bootstrap.min.js"/>"></script>
</body>
</html>