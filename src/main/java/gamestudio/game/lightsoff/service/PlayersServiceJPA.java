package gamestudio.game.lightsoff.service;

import gamestudio.game.lightsoff.entity.Players;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@Profile("jpa")
public class PlayersServiceJPA implements PlayersService {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addPlayer(Players player) {
        entityManager.persist(player);
    }

    @Override
    public void addComment(Players comments) {
        entityManager.persist(comments);
    }

    @Override
    public List<Players> getComments(String game) {
        return entityManager.createNamedQuery("Players.getLatestComments", Players.class)
                .setParameter("game", game)
                .setMaxResults(8)
                .getResultList();
    }

    @Override
    public List<Players> getPlayersByGame(String game) {
        return entityManager.createNamedQuery("Players.getPlayers", Players.class)
                .setParameter("game", game)
                .setMaxResults(10)
                .getResultList();
    }
}
