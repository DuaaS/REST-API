package game_of_three_spring.service;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

@Service
public class GameService {
	public static final String SEND_NUMBER_SERVICE_URL = "http://localhost:8080/game";

	public String sendNumber(String playerId, String number) {
		try {
			//String gameId="G1";
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.exchange(SEND_NUMBER_SERVICE_URL + "/" + playerId + "/" + number,
					HttpMethod.POST, null, Object.class);
			return null;
		} catch (HttpStatusCodeException e) {
			String errorpayload = e.getResponseBodyAsString();
			return errorpayload;
		}
	}
}
