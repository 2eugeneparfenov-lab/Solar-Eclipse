package gamestudio.game.lightsoff.server.controllers;

import gamestudio.game.lightsoff.entity.Players;
import gamestudio.game.lightsoff.service.PlayersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.Date;

@Controller
@SessionAttributes("playerName")
public class CommController {

    @Autowired
    private PlayersService playersService;

    // Показуємо форму
    @GetMapping("/lightsoff/makeComm")
    public String commForm() {
        return "commGame"; // це HTML-шаблон (наприклад, commGame.html)
    }

    // Обробляємо відправку форми
    @PostMapping("/lightsoff/makeComm")
    public String submitComment(@RequestParam String username,
                                @RequestParam String comments,
                                Model model) {
        Players newComment = new Players();
        newComment.setUsername(username);
        newComment.setComments(comments);
        newComment.setGame("Solar Eclipse");
        newComment.setCreatedAt(new Date());
        newComment.setPassword(""); // якщо не використовуєш тут — можеш залишити пустим

        playersService.addComment(newComment);

        return "redirect:/lightsoff/comments"; // перенаправлення до сторінки з коментарями
    }
}
