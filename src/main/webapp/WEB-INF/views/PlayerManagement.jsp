<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Football Players</title>
</head>
<body ng-app="myApp">
	<div ng-controller="PlayerController as ctrl">
		<table>
			<thead>
				<tr>
					<th>ID.</th>
					<th>Name</th>
					<th>Team</th>
					<th>Nationality</th>
				</tr>
			</thead>
			<tbody>
				<tr ng-repeat="p in ctrl.players">
					<td><span ng-bind="p.id"></span></td>
					<td><span ng-bind="p.name"></span></td>
					<td><span ng-bind="p.team"></span></td>
					<td><span ng-bind="p.nationality"></span></td>
				</tr>
			</tbody>
		</table>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
	<script src="<c:url value='/static/js/app.js' />"></script>
	<script src="<c:url value='/static/js/service/player_service.js' />"></script>
	<script
		src="<c:url value='/static/js/controller/player_controller.js' />"></script>
</body>
</html>