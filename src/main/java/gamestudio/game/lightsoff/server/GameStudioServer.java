package gamestudio.game.lightsoff.server;

import gamestudio.game.lightsoff.service.PlayersService;
import gamestudio.game.lightsoff.service.PlayersServiceJPA;
import gamestudio.game.lightsoff.service.RatingService;
import gamestudio.game.lightsoff.service.RatingServiceJPA;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication(scanBasePackages = {"gamestudio"})
@Configuration
@EntityScan("gamestudio.game.lightsoff.entity")
public class GameStudioServer {
    public static void main(String[] args) {
        SpringApplication.  run(GameStudioServer.class, args);
    }

    @Bean
    public PlayersService playersService() {
        return new PlayersServiceJPA();
    }

    @Bean
    public RatingService ratingService() {
        return new RatingServiceJPA();
    }
}