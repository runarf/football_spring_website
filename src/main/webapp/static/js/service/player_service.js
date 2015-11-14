'use strict';

App.factory('PlayerService', ['$http', '$q', function($http, $q) {
	return {
		fetchAllPlayers: function() {
			return $http.get('http://localhost:8080/football/player/')
			.then(
					function(response) {
						return response.data;
					},
					function(errResponse) {
						console.error('Error while fetching players');
						return $q.reject(errResponse);
					}
			);
		},

		createPlayer: function(player) {
			return $http.post('http://localhost:8080/football/player', player)
			.then(
					function(response) {
						return response.data;
					},
					function(errResponse) {
						console.error('Error while creating player');
						return $q.reject(errResponse);
					}
			);
		}
	};
}]);