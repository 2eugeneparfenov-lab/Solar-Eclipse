package gamestudio.game.lightsoff.service;


import gamestudio.game.lightsoff.entity.Rating;

import java.sql.*;

public class RatingServiceJDBC implements RatingService {
    public static final String URL = "jdbc:postgresql://localhost/Slide-a-LamaDB";
    public static final String USER = "postgres";
    public static final String PASSWORD = "Sh73yD11";

    public static final String UPDATE_RATING = "UPDATE rating SET rating = ?, ratedOn = ? WHERE game = ? AND player = ?";
    public static final String INSERT_RATING = "INSERT INTO rating (game, player, rating, ratedOn) VALUES (?, ?, ?, ?)";
    public static final String SELECT_RATING = "SELECT rating FROM rating WHERE game = ? AND player = ?";
    public static final String SELECT_AVG_RATING = "SELECT AVG(rating) FROM rating WHERE game = ?";
    public static final String DELETE_ALL = "DELETE FROM rating";

    @Override
    public void setRating(Rating rating) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            try (PreparedStatement ps = conn.prepareStatement(SELECT_RATING)) {
                ps.setString(1, rating.getGame());
                ps.setString(2, rating.getPlayer());
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        try (PreparedStatement updatePs = conn.prepareStatement(UPDATE_RATING)) {
                            updatePs.setInt(1, rating.getRating());
                            updatePs.setDate(2, new Date(rating.getRatedOn().getTime()));
                            updatePs.setString(3, rating.getGame());
                            updatePs.setString(4, rating.getPlayer());
                            updatePs.executeUpdate();
                        }
                    } else {
                        try (PreparedStatement insertPs = conn.prepareStatement(INSERT_RATING)) {
                            insertPs.setString(1, rating.getGame());
                            insertPs.setString(2, rating.getPlayer());
                            insertPs.setInt(3, rating.getRating());
                            insertPs.setDate(4, new Date(rating.getRatedOn().getTime()));
                            insertPs.executeUpdate();
                        }
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error setting rating", e);
        }
    }

    @Override
    public double getAverageRating(String game) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(SELECT_AVG_RATING)) {
            ps.setString(1, game);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return (int) Math.round(rs.getDouble(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error getting average rating", e);
        }
        return 0;
    }

    @Override
    public int getRating(String game, String player) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(SELECT_RATING)) {
            ps.setString(1, game);
            ps.setString(2, player);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error getting rating", e);
        }
        return 0;
    }
}
