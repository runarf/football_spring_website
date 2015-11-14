package football.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import football.model.Player;

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
	
	public void upvotePlayer(Player player) {
		long votes = player.getVotes();
		player.setVotes(votes + 1);
	}


	public void downvotePlayer(Player player) {
		long votes = player.getVotes();
		player.setVotes(votes - 1);
	}
	
	public void deletePlayerById(long id) {
		for (Iterator<Player> iterator = players.iterator(); iterator.hasNext(); ) {
			Player player = iterator.next();
			if(player.getId() == id) {
				iterator.remove();
			}
		}
	}
	
	public boolean isPlayerExist(Player player) {
		return findByName(player.getName()) != null;
	}
	
	private static List<Player> populateDummyPlayers() {
		List<Player> players = new ArrayList<Player>();
		players.add(new Player(counter.incrementAndGet(), "Wayne Rooney", "Manchester United", "English", "http://static.independent.co.uk/s3fs-public/thumbnails/image/2014/09/27/16/Wayne_Rooney-2.jpg"));
		players.add(new Player(counter.incrementAndGet(), "Christiano Ronaldo", "Real Madrid", "Portuguis", "http://i1.mirror.co.uk/incoming/article6129031.ece/ALTERNATES/s1227b/Manchester-City-vs-Real-Madrid.jpg"));
		players.add(new Player(counter.incrementAndGet(), "Lionel Messi", "Barcelona", "Argentinian", "http://images.performgroup.com/di/library/GOAL_INTERNATIONAL/2d/4b/lionel-messi-thomas-muller-barcelona-bayern-munich-champions-league-06052015_1dzp64uc807ve19p95c28l0daq.jpg?t=718739109&w=620&h=430" ));
		return players;
	}

	

}
