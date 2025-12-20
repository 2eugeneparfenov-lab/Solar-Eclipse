package gamestudio.game.lightsoff;

import gamestudio.game.lightsoff.core.Core;
import gamestudio.game.lightsoff.service.PlayersService;
import gamestudio.game.lightsoff.service.PlayersServiceJPA;
import gamestudio.game.lightsoff.ui.ConsoleUI;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class SpringClient {

    public static void main(String[] args) {
        SpringApplication.run(SpringClient.class, args);
    }

    @Bean
    public CommandLineRunner runner(ConsoleUI ui) {
        return args -> ui.playGame();
    }

    @Bean
    public ConsoleUI consoleUI(Core core) {
        return new ConsoleUI();
    }

    @Bean
    public Core core() {
        return new Core(); // налаштуй під свою гру
    }

    @Bean
    public PlayersService scoreService() {
        return new PlayersServiceJPA();
    }
}
