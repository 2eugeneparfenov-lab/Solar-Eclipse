package gamestudio.game.lightsoff.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@NamedQueries({
        @NamedQuery(name = "Rating.getAverageRating",
                query = "SELECT AVG(r.rating) FROM Rating r WHERE r.game=:game"),
        @NamedQuery(name = "Rating.getRating",
                query = "SELECT r.rating FROM Rating r WHERE r.game=:game and r.player=:player"),
        @NamedQuery(name = "Rating.getIdent",
                query = "SELECT r.ident FROM Rating r WHERE r.game=:game and r.player=:player")
})
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ident;

    private String player;
    private String game;
    private int rating;

    @Temporal(TemporalType.TIMESTAMP)
    private Date ratedOn;

    public Rating() {}

    public Rating(String player, String game, int rating, Date ratedOn) {
        this.player = player;
        this.game = game;
        this.rating = rating;
        this.ratedOn = ratedOn;
    }

    public int getIdent() { return ident; }
    public void setIdent(int ident) { this.ident = ident; }

    public String getPlayer() { return player; }
    public void setPlayer(String player) { this.player = player; }

    public String getGame() { return game; }
    public void setGame(String game) { this.game = game; }

    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }

    public Date getRatedOn() { return ratedOn; }
    public void setRatedOn(Date ratedOn) { this.ratedOn = ratedOn; }
}
