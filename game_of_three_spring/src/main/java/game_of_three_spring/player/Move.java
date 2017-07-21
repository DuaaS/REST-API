package game_of_three_spring.player;

public class Move {
	private String player;
	private Integer number;
	private Integer nextNumber;
	private Integer added;
	private boolean gameFinished;
	public Move(String player, Integer number, Integer nextNumber, Integer added, boolean gameFinished) {
		this.player = player;
		this.number = number;
		this.nextNumber = nextNumber;
		this.added = added;
		this.gameFinished = gameFinished;
	}

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getNextNumber() {
		return nextNumber;
	}

	public void setNextNumber(Integer nextNumber) {
		this.nextNumber = nextNumber;
	}

	public Integer getAdded() {
		return added;
	}

	public void setAdded(Integer added) {
		this.added = added;
	}

	public boolean isGameFinished() {
		return gameFinished;
	}

	public void setGameFinished(boolean gameFinished) {
		this.gameFinished = gameFinished;
	}

}
