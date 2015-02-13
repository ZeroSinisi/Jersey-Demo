package zero.sinisi;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class Board {

	@Id
	private int					id	= 0;
	@Column(length = -1)
	private ArrayList<Player>	players;

	public Board() {
		players = new ArrayList<Player>();
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void addPlayer(Player player) {
		players.add(player);
	}
}
