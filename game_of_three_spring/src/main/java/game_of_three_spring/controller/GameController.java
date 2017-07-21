package game_of_three_spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import game_of_three_spring.service.GameService;


	@Controller
	@RequestMapping("/playGame")
	public class GameController {

		@Autowired
		GameService gameService;

		@RequestMapping()
		public String index() {
			return "index";
		}

		@RequestMapping(value = "sendNumber", method = RequestMethod.POST)
		public @ResponseBody String sendNumber(@RequestParam String playerId,
				@RequestParam String number) {
			return gameService.sendNumber( playerId, number);
		}
}
