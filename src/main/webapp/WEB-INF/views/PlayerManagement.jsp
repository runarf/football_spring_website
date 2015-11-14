<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Football Players</title>
</head>
<body ng-app="myApp">
	<div ng-controller="PlayerController as ctrl">
	
	<form ng-submit="ctrl.submit()" name="myForm">
		<input type="hidden" ng-model="ctrl.player.id" />
		<label>Name</label>
		<input type="text" ng-model="ctrl.player.name" name="pname" placeholder="Enter the players name" required ng-minlength="3"/>
		<br>
		<label>Team</label>
		<input type="text" ng-model="ctrl.player.team" placeholder="Enter the team of the player" required ng-minlength="3" />
		<br>
		<label>Nationality</label>
		<input type="text" ng-model="ctrl.player.nationality" placeholder="Enter nationality of the player" required ng-minlength="3" />
		<br>
		<label>Image URL</label>
		<input type="text" ng-model="ctrl.player.image" placeholder="Enter a URL with an image of the player" required />
		<br>
		<input type="submit" value="Add" ng-disabled="myForm.$invalid">
		<button type="button" ng-click="ctrl.reset()" ng-disabled="myForm.$pristine">Reset Form</button>
	</form>
		<table>
			<thead>
				<tr>
					<th>ID.</th>
					<th>Name</th>
					<th>Team</th>
					<th>Nationality</th>
					<th>Image</th>
				</tr>
			</thead>
			<tbody>
				<tr ng-repeat="p in ctrl.players">
					<td><span ng-bind="p.id"></span></td>
					<td><span ng-bind="p.name"></span></td>
					<td><span ng-bind="p.team"></span></td>
					<td><span ng-bind="p.nationality"></span></td>
					<td><img src="{{p.image}}" height="100"></td>
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