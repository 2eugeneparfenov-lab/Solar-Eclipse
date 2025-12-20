package gamestudio.game.lightsoff.server.webservice;

import gamestudio.game.lightsoff.entity.Players;
import gamestudio.game.lightsoff.service.PlayersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayersServiceRest {

    @Autowired
    private PlayersService playersService;

    @GetMapping("/{game}")
    public List<Players> getPlayersByName(@PathVariable String game) {
        return playersService.getPlayersByGame(game);
    }

    @PostMapping
    public void addPlayer(@RequestBody Players players) {
        playersService.addPlayer(players);
    }
}