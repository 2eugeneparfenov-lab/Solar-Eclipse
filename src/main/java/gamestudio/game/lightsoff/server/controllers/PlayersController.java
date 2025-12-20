package gamestudio.game.lightsoff.server.controllers;

import gamestudio.game.lightsoff.service.PlayersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/players")
public class PlayersController {

    @Autowired
    private PlayersService playersService;

    @GetMapping
    public String players(Model model) {
        updateModel(model);
        return "players";
    }

    @GetMapping("/menu")
    public String menu(Model model) {
        updateModel(model);
        return "menu";
    }

    private void updateModel(Model model) {
        model.addAttribute("players", playersService.getPlayersByGame("Slide-a-Lama"));
    }
}
