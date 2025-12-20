package gamestudio.game.lightsoff.service;

import gamestudio.game.lightsoff.entity.Players;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@Profile("rest")
public class PlayersServiceRestClient implements PlayersService {

    private final String url = "http://localhost:8080/api/players";
    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public void addPlayer(Players player) {
        restTemplate.postForLocation(url, player);
    }

    @Override
    public void addComment(Players comments) {
        restTemplate.postForLocation(url + "/comments", comments);
    }

    @Override
    public List<Players> getComments(String game) {
        Players[] response = restTemplate.getForObject(url + "/" + game + "/comments", Players[].class);
        return response == null ? List.of() : Arrays.asList(response);
    }

    @Override
    public List<Players> getPlayersByGame(String game) {
        Players[] response = restTemplate.getForObject(url + "/" + game, Players[].class);
        return response == null ? List.of() : Arrays.asList(response);
    }
}
