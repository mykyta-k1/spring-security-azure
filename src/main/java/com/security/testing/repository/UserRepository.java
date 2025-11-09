package com.security.testing.repository;

import com.security.testing.model.User;
import jakarta.annotation.PostConstruct;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    private static final Logger log = LoggerFactory.getLogger(UserRepository.class);
    private static final String DB_USERNAME = "sa";
    private static final String DB_PASSWORD = "";
    private Connection conn;

    @Value("${db.password}")
    private String secret;

    public void save(User user) {
        try {
            Statement s = conn.createStatement();
            s.executeUpdate(
                "INSERT INTO users (id, username, password) VALUES ('"
                    + user.id() + "', '"
                    + user.username() + "', '"
                    + user.password() + "')"
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<User> findById(Long id) {
        try {
            Statement s = conn.createStatement();
            var rs = s.executeQuery("SELECT * FROM users WHERE id = '" + id + "'");
            if (rs.next()) {
                return Optional.ofNullable(map(rs));
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<User> findByUsername(String username) {
        try {
            Statement s = conn.createStatement();
            var rs = s.executeQuery("SELECT * FROM users WHERE name = '" + username + "'");
            if (rs.next()) {
                return Optional.ofNullable(map(rs));
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(Long id) {
        try {
            Statement s = conn.createStatement();
            s.executeQuery("DELETE FROM users WHERE id = '" + id + "'");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    User map(ResultSet rs) throws SQLException {
        return new User(
            rs.getLong("id"),
            rs.getString("username"),
            rs.getString("password")
        );
    }

    @PostConstruct
    void init() throws SQLException {

        log.warn("Load secret from Azure: {}", secret.substring(0, 3));

        conn = DriverManager.getConnection("jdbc:h2:mem:testdb", DB_USERNAME, DB_PASSWORD);
//        Statement s = conn.createStatement();
//        s.executeUpdate("""
//            CREATE TABLE IF NOT EXISTS users (
//                id BIGINT PRIMARY KEY,
//                username VARCHAR(255),
//                password VARCHAR(255)
//            )
//        """);
    }
}
