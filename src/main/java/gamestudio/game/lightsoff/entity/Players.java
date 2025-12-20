package gamestudio.game.lightsoff.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "players")
@NamedQueries({
        @NamedQuery(name = "Players.getPlayers",
                query = "SELECT p FROM Players p WHERE p.game = :game ORDER BY p.createdAt DESC"),
        @NamedQuery(name = "Players.getLatestComments",
                query = "SELECT p FROM Players p WHERE p.game = :game ORDER BY p.ident DESC")
})
public class Players {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ident;

    private String username;
    private String password;
    private String game;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    private String comments;

    public Players() {}

    public Players(String username, String password, String game, Date createdAt, String comments) {
        this.username = username;
        this.password = password;
        this.game = game;
        this.createdAt = createdAt;
        this.comments = comments;
    }

    // getters/setters
    public Integer getIdent() { return ident; }
    public void setIdent(Integer ident) { this.ident = ident; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getGame() { return game; }
    public void setGame(String game) { this.game = game; }

    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }

    public String getComments() { return comments; }
    public void setComments(String comments) { this.comments = comments; }
}
