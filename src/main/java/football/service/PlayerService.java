package football.service;

import java.util.List;

import model.Player;

public interface PlayerService {
	Player findById(long id);
	Player findByName(String name);
	void savePlayer(Player player);
	
	List<Player> findAllPlayers();
	public boolean isPlayerExist(Player player);
}
