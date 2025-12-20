package gamestudio.game.lightsoff.server.controllers;

import gamestudio.game.lightsoff.entity.Players;
import gamestudio.game.lightsoff.service.PlayersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.context.annotation.Scope;

import java.util.List;

@Controller
@Scope(WebApplicationContext.SCOPE_SESSION)
public class Comments {

    @Autowired
    private PlayersService playersService;

    @GetMapping("/lightsoff/comments")
    public String comments(Model model){
        List<Players> comments = playersService.getComments("Solar Eclipse");
        model.addAttribute("comments", comments);
        return "comments"; // returns comments.html
    }
}

