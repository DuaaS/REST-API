package game_of_three_spring.player;

import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;


public class Game {
	private SseEmitter player1;
	private SseEmitter player2;
	private Player nextMovePlayer;
	private Move lastMove;

	
	public Game() {
		this.setPlayer1(new SseEmitter(-1L));
		this.setPlayer2(new SseEmitter(-1L));
	}

	

	public SseEmitter getPlayer1() {
		return player1;
	}

	public void setPlayer1(SseEmitter player1) {
		this.player1 = player1;
	}

	public SseEmitter getPlayer2() {
		return player2;
	}

	public void setPlayer2(SseEmitter player2) {
		this.player2 = player2;
	}

	public Player getNextMovePlayer() {
		return nextMovePlayer;
	}

	public void setNextMovePlayer(Player nextMovePlayer) {
		this.nextMovePlayer = nextMovePlayer;
	}

	public Move getLastMove() {
		return lastMove;
	}

	public void setLastMove(Move lastMove) {
		this.lastMove = lastMove;
	}

}
