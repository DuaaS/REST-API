package game_of_three_spring.player;

public enum Player {
	PLAYER_1("P1"), PLAYER_2("P2");

	private final String playerId;

	Player(String playerId) {
		this.playerId = playerId;
	}

	public String getPlayerId() {
		return playerId;
	}

}
