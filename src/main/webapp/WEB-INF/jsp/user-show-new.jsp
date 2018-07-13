<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Utilisateur ajouté !</title>
</head>

<body>
	<h2>Informations sur l'utilisateur créé</h2>
	<table>
		<tr>
			<td>ID :</td>
			<td>${id}</td>
		</tr>
		<tr>
			<td>Prénom :</td>
			<td>${firstName}</td>
		</tr>
		<tr>
			<td>Nom :</td>
			<td>${lastName}</td>
		</tr>
		<tr>
			<td>Profil :</td>
			<td>${profile}</td>
		</tr>
		<tr>
			<td>Droits :</td>
			<td>${rightsStatus}</td>
		</tr>
	</table>

	<div id=footer>
		<a href="<c:url value="/options/"/>">Retour au menu options</a>
	</div>
</body>
</html>