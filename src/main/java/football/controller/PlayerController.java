package football.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import football.service.PlayerService;
import model.Player;

@RestController
public class PlayerController {

	@Autowired
	PlayerService playerService;

	@RequestMapping(value = "/player/", method = RequestMethod.GET)
	public ResponseEntity<List<Player>> listAllPlayers() {
		List<Player> players = playerService.findAllPlayers();
		if (players.isEmpty()) {
			return new ResponseEntity<List<Player>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Player>>(players, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/player/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Player> getPlayer(@PathVariable("id") long id) {
		System.out.println("Fetching player with id " + id);;
		Player player = playerService.findById(id);
		if (player == null) {
			System.out.println("Player with id " + id + " not found");
			return new ResponseEntity<Player>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Player>(player, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/player/", method = RequestMethod.POST)
	public ResponseEntity<Void> createPlayer(@RequestBody Player player, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating player " + player.getName());
		
		if (playerService.isPlayerExist(player)) {
			System.out.println("A player with name " + player.getName() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		
		playerService.savePlayer(player);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/player/{id}").buildAndExpand(player.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/player/{id}/upvote", method = RequestMethod.GET)
	public ResponseEntity<Player> upvotePlayer(@PathVariable("id") long id) {
		Player currentPlayer = playerService.findById(id);
		
		if (currentPlayer == null) {
			System.out.println("Player with id " + id + " not found");
			return new ResponseEntity<Player>(HttpStatus.NOT_FOUND);
		}
		
		playerService.upvotePlayer(currentPlayer);
		return new ResponseEntity<Player>(currentPlayer, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/player/{id}/downvote", method = RequestMethod.GET)
	public ResponseEntity<Player> downvotePlayer(@PathVariable("id") long id) {
		Player currentPlayer = playerService.findById(id);
		
		if (currentPlayer == null) {
			System.out.println("Player with id " + id + " not found");
			return new ResponseEntity<Player>(HttpStatus.NOT_FOUND);
		}
		
		playerService.downvotePlayer(currentPlayer);
		return new ResponseEntity<Player>(currentPlayer, HttpStatus.OK);
	}

}
