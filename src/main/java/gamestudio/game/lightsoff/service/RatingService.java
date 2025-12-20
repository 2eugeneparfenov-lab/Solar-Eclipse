package gamestudio.game.lightsoff.service;

import gamestudio.game.lightsoff.entity.Rating;

public interface RatingService {
    void setRating(Rating rating);
    double getAverageRating(String game);
    int getRating(String game, String player);
}
