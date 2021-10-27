package dev.mihail.DAO;

import dev.mihail.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserDAOService implements UserDAO<User, Long> {

    private static final String SQL_CREATE_USER = "INSERT INTO USER (u_f_name, u_l_name, u_email) values (?, ?, ?)";
    private static final String SQL_SELECT_USER_BY_ID = "SELECT u_id FROM USER WHERE u_id = ?";
    private static final String SQL_SELECT_ALL_USERS = "SELECT * FROM USER";
    private static final String SQL_UPDATE_USER_BY_ID = "UPDATE USER SET u_f_name = ?, u_l_name = ?, u_email = ? WHERE u_id = ?";
    private static final String SQL_UPDATE_USER_BY_EMAIL = "UPDATE USER SET u_f_name = ?, u_l_name = ?, u_email = ? WHERE u_email = ?";
    private static final String SQL_DELETE_USER_BY_ID = "DELETE USER WHERE u_id = ?";
    private static final String SQL_DELETE_USER_BY_EMAIL = "DELETE USER WHERE u_email = ?";

    private static final Logger log = LoggerFactory.getLogger(UserDAOService.class);
    private final JdbcTemplate jdbcTemplate;
    private final UserRowMapper userRowMapper;

    public UserDAOService(JdbcTemplate jdbcTemplate, UserRowMapper userRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.userRowMapper = userRowMapper;
    }

    @Override
    public int createUser(User u) {
        return jdbcTemplate.update(SQL_CREATE_USER);
    }

    @Override
    public Optional<User> getUserById(Long u_id) {
        return Optional.ofNullable(jdbcTemplate.queryForObject(SQL_SELECT_USER_BY_ID, userRowMapper, u_id));
    }

    @Override
    public List<User> getAllUsers() {
        return jdbcTemplate.query(SQL_SELECT_ALL_USERS, userRowMapper);
    }

    @Override
    public Optional<User> updateUserById(Long u_id) {
        return Optional.ofNullable(jdbcTemplate.queryForObject(SQL_UPDATE_USER_BY_ID, userRowMapper, u_id));
    }

    @Override
    public User updateUserByEmail(String u_email) {
        return jdbcTemplate.queryForObject(SQL_UPDATE_USER_BY_EMAIL, userRowMapper, u_email);
    }

    @Override
    public Optional<User> deleteUserById(Long u_id) {
        return Optional.ofNullable(jdbcTemplate.queryForObject(SQL_DELETE_USER_BY_ID, userRowMapper, u_id));
    }

    @Override
    public void deleteUserByEmail(String u_email) {
        jdbcTemplate.queryForObject(SQL_DELETE_USER_BY_EMAIL, userRowMapper, u_email);
    }
}
