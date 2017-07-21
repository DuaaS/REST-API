package game_of_three_spring.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import game_of_three_spring.dto.PlayerDTO;
import game_of_three_spring.player.Move;
import game_of_three_spring.service.GameRestService;


	@RestController
	@RequestMapping(value = "/game")
	public class GameRestController {

		@Autowired
		GameRestService gameRestService;

		@RequestMapping(method = RequestMethod.POST, value = "/player", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<PlayerDTO> registerPlayer() throws IOException {
			PlayerDTO game = gameRestService.registerPlayer();
			return new ResponseEntity<PlayerDTO>(game, HttpStatus.OK);
		}

		@RequestMapping(method = RequestMethod.GET, value = "/{playerId}")
		public SseEmitter registerGame(@PathVariable String playerId) throws IOException {
			SseEmitter sseEmitter = gameRestService.registerGame(playerId);
			return sseEmitter;
		}

		@RequestMapping(method = RequestMethod.POST, value = "/{playerId}/{number}", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<?> sendNumber(@PathVariable String playerId,
				@PathVariable Integer number)
				throws IOException {
			Move move = gameRestService.nextMove(playerId, number);
			return new ResponseEntity<Move>(move, HttpStatus.OK);
		}

		/*@ExceptionHandler(AppException.class)
		public ResponseEntity<ErrorDTO> handleAppException(AppException appException) {
			ErrorDTO errorDTO = new ErrorDTO(appException.getErrorCode());
			return new ResponseEntity<ErrorDTO>(errorDTO, appException.getHttpStatus());
		}*/

}
