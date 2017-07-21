package game_of_three_spring;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import game_of_three_spring.player.Game;
import game_of_three_spring.player.Move;
import game_of_three_spring.player.Player;
import game_of_three_spring.player.PlayerRegistration;



@Component
public class GameManager {
	
	private Map<String,Game> games = new Hashtable<String,Game>();
	private Game lastGame;

	public synchronized PlayerRegistration registerGame() {
		if (lastGame == null) {
			lastGame = new Game();
			lastGame.setNextMovePlayer(Player.PLAYER_1);
			games.put("G1", lastGame);
			return new PlayerRegistration(lastGame, Player.PLAYER_1);
		} else {
			Game game = lastGame;
			lastGame = null;
			return new PlayerRegistration(game, Player.PLAYER_2);
		}
	}

	public SseEmitter getEmitterForPlayer(String playerId) {
		Game game = games.get("G1");
		if (game != null) {
			if (playerId.equals(Player.PLAYER_1.getPlayerId()))
				return game.getPlayer1();
			else {
				return game.getPlayer2();
			}
		}
		return null;
	}

	public Move nextMove(String playerId, Integer number)
			{
		Game game = games.get("G1");
		if (game != null) {
			synchronized (game) {
				if (!isGameFinished(game)) {
					if (!playerId.equals(game.getNextMovePlayer().getPlayerId())) {
						try {
							throw new Exception();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

					if (game.getLastMove() != null && !number.equals(game.getLastMove().getNextNumber())) {
						try {
							throw new Exception();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

					Move move = calculateMove(playerId, number);

					updateNextTurn(playerId, game, move);

					try {
						game.getPlayer1().send(move);
						game.getPlayer2().send(move);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					if (move.isGameFinished()) {
						game.getPlayer1().complete();
						game.getPlayer2().complete();
					}
					return move;
				} else {
					try {
						throw new Exception();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		return null;
	}

	private void updateNextTurn(String playerId, Game game, Move move) {
		if (playerId.equals(Player.PLAYER_1.getPlayerId())) {
			game.setNextMovePlayer(Player.PLAYER_2);
		} else {
			game.setNextMovePlayer(Player.PLAYER_1);
		}
		game.setLastMove(move);
	}

	private Move calculateMove(String playerId, Integer number) {
		Integer nextNumber;
		Integer added;
		if (number % 3 == 0) {
			nextNumber = number / 3;
			added = 0;
		} else if ((number - 1) % 3 == 0) {
			nextNumber = (number - 1) / 3;
			added = -1;
		} else {
			nextNumber = (number + 1) / 3;
			added = 1;
		}
		return new Move(playerId, number, nextNumber, added, nextNumber == 1 ? true : false);
	}

	private boolean isGameFinished(Game game) {
		return game.getLastMove() != null && game.getLastMove().isGameFinished();
	}
}
