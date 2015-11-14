package football.service;

import java.util.List;

import football.model.Player;

public interface PlayerService {
	Player findById(long id);
	Player findByName(String name);
	void savePlayer(Player player);
	void upvotePlayer(Player player);
	void downvotePlayer(Player player);
	List<Player> findAllPlayers();
	void deletePlayerById(long id);
	public boolean isPlayerExist(Player player);
}
