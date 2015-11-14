'use strict';

App.controller('PlayerController', ['$scope', 'PlayerService', function($scope, PlayerService) {
	var self = this;
	self.player = { id: null, name: '', team: '', nationality: ''};
	self.players = [];

	self.fetchAllUsers = function() {
		PlayerService.fetchAllPlayers()
		.then(
				function(d) {
					self.players = d;
				},
				function(errResponse) {
					console.error('Error while fetching players');
				}
		);
	};

	self.createPlayer = function(player) {
		PlayerService.createPlayer(player)
		.then(
				self.fetchAllPlayers,
				function(errResponse) {
					console.error('Error while creating player.');
				}
		);
	};
	
	self.fetchAllUsers();
	
	self.submit = function() {
		if(self.player.id == null) {
			console.log('Saving new player', self.player);
			self.createPlayer(self.player);
		}
		self.reset();
	}
	
	self.reset = function() {
		self.player = { id: null, name: '', team: '', nationality: '' };
		$scope.myForm.$setPristine();
	};
}])