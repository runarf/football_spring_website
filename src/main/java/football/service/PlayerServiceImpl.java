package football.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.Player;

@Service("playerService")
@Transactional
public class PlayerServiceImpl implements PlayerService {
	private static final AtomicLong counter = new AtomicLong();
	private static List<Player> players;
	
	static{
		players = populateDummyPlayers();
	}
	
	public List<Player> findAllPlayers() {
		return players;
	}
	
	public Player findById(long id) {
		for (Player player : players) {
			if(player.getId() == id) {
				return player;
			}
		}
		return null;
	}
	
	public Player findByName(String name) {
		for(Player player : players) {
			if(player.getName().equalsIgnoreCase(name)) {
				return player;
			}
		}
		return null;
	}
	
	public void savePlayer(Player player) {
		player.setId(counter.incrementAndGet());
		players.add(player);
	}
	
	public boolean isPlayerExist(Player player) {
		return findByName(player.getName()) != null;
	}
	
	private static List<Player> populateDummyPlayers() {
		List<Player> players = new ArrayList<Player>();
		players.add(new Player(counter.incrementAndGet(), "Rooney", "Manchester United", "English"));
		players.add(new Player(counter.incrementAndGet(), "Christiano Ronaldo", "Real Madrid", "Portuguis"));
		players.add(new Player(counter.incrementAndGet(), "Lionel Messi", "Barcelona", "Argentinian"));
		return players;
	}
}
