<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Gestion des plannings - Options</title>
<link rel='stylesheet' href='<c:url value="/webjars/bootstrap/3.2.0/css/bootstrap.min.css"/>'>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.18/datatables.min.css"/>

</head>
<body>
	<div id="users" class="container">
		<h3 class="page-header">Options d'utilisateur</h3>
		<table id="usertable" class="hover">
			<thead>
				<tr>
					<th>Id</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Profile</th>
					<th>Suppression</th>
					<th>Edition</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${userList}" var="user">
					<tr>
						<td><c:out value="${user.id }" /></td>
						<td><c:out value="${user.firstName }" /></td>
						<td><c:out value="${user.lastName }" /></td>
						<td><c:out value="${user.profile.name }" /></td>
						<!-- TODO: Liens vers les méthodes suppression/édition à faire -->
						<td><span class="glyphicon glyphicon-trash"></span></td>
						<td><span class="glyphicon glyphicon-pencil"></span></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<p>
			<a href="<c:url value="/options/user"/>"
				class="btn btn-primary pull-right"><span
				class="glyphicon glyphicon-plus"></span> Ajouter un nouvel
				utilisateur</a>
		</p>
	</div>

	<div id="projects" class="container">
		<h3 class="page-header">Options des projets</h3>

		<table id="projecttable" class="hover">
			<thead>
				<tr>
					<th>Id</th>
					<th>Nom</th>
					<th>Budget</th>
					<th>Administrateur</th>
					<th>Suppression</th>
					<th>Edition</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${projectList}" var="project">
					<tr>
						<td><c:out value="${project.id }" /></td>
						<td><c:out value="${project.name }" /></td>
						<td><c:out value="${project.budget }" /></td>
						<td><c:out
								value="${project.admin.firstName } ${project.admin.lastName }" /></td>
						<!-- TODO: Liens vers les méthodes suppression/édition à faire -->
						<td><span class="glyphicon glyphicon-trash"></span></td>
						<td><span class="glyphicon glyphicon-pencil"></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<div id="profile" class="container">
		<h3 class="page-header">Options de profil</h3>
		<table id="profiletable" class="hover">
			<thead>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>TJM de base</th>
					<th>Suppression</th>
					<th>Edition</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${profileList}" var="profile">
					<tr>
						<td><c:out value="${profile.id }" /></td>
						<td><c:out value="${profile.name }" /></td>
						<td><c:out value="${profile.tjmBase }" /></td>
						<!-- TODO: Liens vers les méthodes suppression/édition à faire -->
						<td><span class="glyphicon glyphicon-trash"></span></td>
						<td><span class="glyphicon glyphicon-pencil"></span></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="<c:url value="/options/profile"/>"
			class="btn btn-primary pull-right"><span
			class="glyphicon glyphicon-plus"></span> Ajouter un nouveau profil</a>
	</div>

	<div class="container">
		<a href="<c:url value="/"/>" class="btn btn-default" role="button">Retour au menu principal</a>
	</div>
	
	<div class="container"> 
	<span>Mode : ${right} </span>
	<a href="<c:url value="/login"/>" class="btn btn-link pull-right" role="button" >Mode administrateur</a>
	</div>

	<!-- SCRIPTS LIBRARIES-->
	<script type="text/javascript" src="<c:url value ="/webjars/jquery/2.1.1/jquery.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/webjars/bootstrap/3.2.0/js/bootstrap.min.js"/>"></script>
	<script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.18/datatables.min.js"></script>
	<script type="text/javascript" src="https://cdn.datatables.net/1.10.18/js/dataTables.bootstrap.min.js"></script>

	<!-- Scripts page -->
	<script>
		jQuery(document).ready(function() {
			$('#usertable').DataTable({
				columnDefs : [ {
					targets : [ -1, -2 ],
					orderable : false
				}, {
					targets : '_all',
					className : 'dt-center'
				} ]
			});
			$('#projecttable').DataTable({
				columnDefs : [ {
					targets : [ -1, -2 ],
					orderable : false
				}, {
					targets : '_all',
					className : 'dt-center'
				} ]
			});
			$('#profiletable').DataTable({
				columnDefs : [ {
					targets : [ -1, -2 ],
					orderable : false
				}, {
					targets : '_all',
					className : 'dt-center'
				} ]
			});
		});
	</script>
</body>
</html>