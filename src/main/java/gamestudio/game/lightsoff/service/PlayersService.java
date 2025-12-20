package gamestudio.game.lightsoff.service;

import gamestudio.game.lightsoff.entity.Players;

import java.util.List;

public interface PlayersService {
    void addPlayer(Players player);
    List<Players> getPlayersByGame(String game);
    void addComment(Players comments);
    List<Players> getComments(String game);
}
