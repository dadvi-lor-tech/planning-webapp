<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Profil ajouté !</title>
</head>

<body>
	<h2>Informations sur le profil créé</h2>
	<table>
		<tr>
			<td>Nom :</td>
			<td>${name}</td>
		</tr>
		<tr>
			<td>ID :</td>
			<td>${id}</td>
		</tr>
		<tr>
			<td>TJM de base du profil :</td>
			<td>${tjmBase}</td>
		</tr>
	</table>

	<div id=footer>
		<a href="<c:url value="/options/"/>">Retour au menu options</a>
	</div>
</body>
</html>