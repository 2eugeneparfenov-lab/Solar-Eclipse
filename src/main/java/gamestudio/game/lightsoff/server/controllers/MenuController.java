package gamestudio.game.lightsoff.server.controllers;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.WebApplicationContext;

@Controller
@Scope(WebApplicationContext.SCOPE_SESSION)
public class MenuController {
    public MenuController() {
    }

    @GetMapping("/lightsoff/menu")
    public String menu(){
        return "menu";
    }
}
