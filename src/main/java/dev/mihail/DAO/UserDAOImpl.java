package dev.mihail.DAO;

import dev.mihail.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserDAOImpl implements UserDAO<User, Long> {

    private static final Logger log = LoggerFactory.getLogger(UserDAOImpl.class);
    private final JdbcTemplate jdbcTemplate;

    public UserDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public String createUser(User u) {
        return null;
    }

    @Override
    public Optional<User> getUserById(Long u_id) {
        return Optional.empty();
    }

    @Override
    public Optional<User> updateUserById(Long u_id) {
        return Optional.empty();
    }

    @Override
    public String updateUser(User u) {
        return null;
    }

    @Override
    public Optional<User> deleteUserById(Long u_id) {
        return Optional.empty();
    }

    @Override
    public String deleteUser(User u) {
        return null;
    }
}
