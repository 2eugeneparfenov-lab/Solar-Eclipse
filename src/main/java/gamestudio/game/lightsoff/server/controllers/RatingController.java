package gamestudio.game.lightsoff.server.controllers;

import gamestudio.game.lightsoff.entity.Rating;
import gamestudio.game.lightsoff.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;

@Controller
@Scope(WebApplicationContext.SCOPE_SESSION)
@RequestMapping("/lightsoff")
public class RatingController {

    private final RatingService ratingService;

    @Autowired
    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @GetMapping("/setRating")
    public String showRatingForm(Model model,
                                 @RequestParam(required = false) String success) {
        model.addAttribute("rating", new Rating());
        double avg = ratingService.getAverageRating("Solar Eclipse");
        model.addAttribute("avgRating", avg);
        model.addAttribute("success", success != null);
        return "setRating"; // ім'я HTML-шаблону без .html
    }

    @PostMapping("/setRating")
    public String submitRating(@ModelAttribute("rating") Rating rating,
                               RedirectAttributes redirectAttributes) {
        rating.setGame("Solar Eclipse");
        rating.setRatedOn(new Date());
        ratingService.setRating(rating);

        redirectAttributes.addAttribute("success", "true");
        return "redirect:/lightsoff/setRating";
    }
}
