package game_of_three_spring.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import game_of_three_spring.GameManager;
import game_of_three_spring.dto.PlayerDTO;
import game_of_three_spring.player.Move;
import game_of_three_spring.player.PlayerRegistration;


@Service
public class GameRestService {
	@Autowired
	private GameManager gameManager;

	public PlayerDTO registerPlayer() {
		PlayerRegistration gamePlayerRegistration = gameManager.registerGame();
		return new PlayerDTO(gamePlayerRegistration.getPlayer().getPlayerId());
	}

	public SseEmitter registerGame(String playerId) throws IOException {
		return gameManager.getEmitterForPlayer(playerId);
	}

	public Move nextMove(String playerId, Integer number)
			throws IOException{
		return gameManager.nextMove(playerId, number);
	}
}
