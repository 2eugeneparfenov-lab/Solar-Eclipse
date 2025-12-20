package gamestudio.game.lightsoff.service;

import gamestudio.game.lightsoff.entity.Rating;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Service
@Transactional
public class RatingServiceJPA implements RatingService {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void setRating(Rating rating) {
        int id = getPlayerId(rating.getGame(), rating.getPlayer());
        if (id != -1) {
            rating.setIdent(id);
            entityManager.merge(rating);
        } else {
            entityManager.persist(rating);
        }
    }

    @Override
    public double getAverageRating(String game) {
        try {
            Double avg = (Double) entityManager.createNamedQuery("Rating.getAverageRating")
                    .setParameter("game", game)
                    .getSingleResult();
            return avg != null ? avg : 0.0;
        } catch (NoResultException e) {
            return 0.0;
        }
    }

    @Override
    public int getRating(String game, String player) {
        try {
            Number rating = (Number) entityManager.createNamedQuery("Rating.getRating")
                    .setParameter("game", game)
                    .setParameter("player", player)
                    .getSingleResult();
            return rating.intValue();
        } catch (NoResultException e) {
            return -1;
        }
    }

    public int getPlayerId(String game, String player) {
        try {
            Number id = (Number) entityManager.createNamedQuery("Rating.getIdent")
                    .setParameter("game", game)
                    .setParameter("player", player)
                    .getSingleResult();
            return id.intValue();
        } catch (NoResultException e) {
            return -1;
        }
    }
}
