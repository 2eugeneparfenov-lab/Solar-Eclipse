package gamestudio.game.lightsoff.service;

import gamestudio.game.lightsoff.entity.Rating;
import org.springframework.web.client.RestTemplate;

public class RatingServiceRestClient implements RatingService {
    private final String url = "http://localhost:8080/api/rating";
    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public void setRating(Rating rating) {
        restTemplate.postForEntity(url, rating, Rating.class);
    }

    @Override
    public double getAverageRating(String game){
        return restTemplate.getForObject(url + "/" + game, Integer.class);

    }

    @Override
    public int getRating(String game, String player){
        return restTemplate.getForObject(url + "/" + game + "/" + player, Integer.class);
    }
}
