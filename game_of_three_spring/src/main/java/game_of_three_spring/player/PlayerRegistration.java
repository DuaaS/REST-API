package game_of_three_spring.player;



public class PlayerRegistration {
	private Game game;
	private Player player;

	public PlayerRegistration(Game game, Player player) {
		this.game = game;
		this.player = player;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
}
