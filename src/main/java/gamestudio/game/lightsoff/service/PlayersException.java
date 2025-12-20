package gamestudio.game.lightsoff.service;

public class PlayersException extends RuntimeException {
    public PlayersException(String message) {
        super(message);
    }

    public PlayersException(String message, Throwable cause) {
        super(message, cause);
    }
}
