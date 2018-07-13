<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Gestion des plannings - Projet</title>
</head>
<body>
	<h1>Menu principal - ${project.name }</h1>

	<table id="phaseTable">
		<caption>Phases</caption>
		<thead>
			<tr>
				<th>Nom</th>
				<th>Prérequis</th>
				<th>Semaine de début</th>
				<th>Semaine de fin</th>
				<th>Evènement de début</th>
				<th>Evènement de fin</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${project.phases}" var="phase">
				<tr>
					<td><c:out value="${phase.name }" /></td>
					<%-- 							<c:forEach items="${phase.prerequisites}" var="prerequisite"> --%>
					<!-- 								TODO: vérifier la mise en forme de la ligne suivante -->
					<%-- 								<c:out value="${prerequisite }" /> --%>
					<%-- 							</c:forEach> --%>
					<td><c:out value="${phase.startDate }" /></td>
					<td><c:out value="${phase.endDate }" /></td>
					<td><c:out value="${phase.startEvent }" /></td>
					<td><c:out value="${phase.endEvent }" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<table id="chargesTimeTable">
		<caption>Récapitulatif des charges (temps)</caption>
		<thead>
			<tr>
				<th>Phase / Mois</th>
				<th>Avril 2018</th>
				<th>Mai 2018</th>
				<th>Juin 2018</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${project.phases}" var="phase">
				<tr>
					<td><c:out value="${phase.name }" /></td>
					<c:forEach items="${phase.charges}" var="charge">
						<td><c:out value="${charge.numberOfDaysEstim }" />jours / <c:out
								value="${charge.numberOfDaysReal }" />jours</td>
					</c:forEach>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<table id="chargesBudgetTable">
		<caption>Récapitulatif des charges (budget)</caption>
		<thead>
			<tr>
				<th>Phase / Mois</th>
				<th>Avril 2018</th>
				<th>Mai 2018</th>
				<th>Juin 2018</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${project.phases}" var="phase">
				<tr>
					<td><c:out value="${phase.name }" /></td>
					<c:forEach items="${phase.charges}" var="charge">
						<td><c:out value="${charge.expenseEstim }" /> EUR / <c:out
								value="${charge.expenseReal }" /> EUR</td>
					</c:forEach>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>