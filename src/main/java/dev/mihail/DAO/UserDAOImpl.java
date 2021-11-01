package dev.mihail.DAO;

import dev.mihail.model.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDAOImpl implements UserDAO<User, Long> {

    private static final String SQL_CREATE_USER = "INSERT INTO USER (u_f_name, u_l_name, u_email) values (?, ?, ?)";
    private static final String SQL_SELECT_USER_BY_ID = "SELECT u_f_name = ?, u_l_name = ?, u_email = ? FROM USER WHERE u_id = ?";
    private static final String SQL_SELECT_USER_BY_EMAIL = "SELECT u_f_name = ?, u_l_name = ?, u_email = ? FROM USER WHERE u_email = ?";
    private static final String SQL_UPDATE_USER_BY_ID = "UPDATE USER SET u_f_name = ?, u_l_name = ?, u_email = ? WHERE u_id = ?";
    private static final String SQL_UPDATE_USER_BY_EMAIL = "UPDATE USER SET u_f_name = ?, u_l_name = ? WHERE u_email = ?";
    private static final String SQL_DELETE_USER_BY_ID = "DELETE USER WHERE u_id = ?";
    private static final String SQL_DELETE_USER_BY_EMAIL = "DELETE USER WHERE u_email = ?";
    private static final String SQL_SELECT_ALL_USERS = "SELECT * FROM USER";

    private static final Logger log = LoggerFactory.getLogger(UserDAOImpl.class);


    private final JdbcTemplate jdbcTemplate;
    private final UserRowMapper userRowMapper;

    public UserDAOImpl(JdbcTemplate jdbcTemplate, UserRowMapper userRowMapper) {
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
    public User getUserByEmail(String email) {
        return jdbcTemplate.queryForObject(SQL_SELECT_USER_BY_EMAIL, userRowMapper, email);
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
    public User updateUserByEmail(User user) {
        User userFromDB = jdbcTemplate.queryForObject(SQL_SELECT_USER_BY_EMAIL, userRowMapper, user.getEmail());
        if (userFromDB == null){
            throw new RuntimeException("User with that email not found");
        }
        userFromDB.setF_name(user.getF_name());
        userFromDB.setL_name(user.getL_name());
        return jdbcTemplate.queryForObject(SQL_UPDATE_USER_BY_EMAIL,
                                                    new Object[]{userFromDB.getF_name(),userFromDB.getL_name()},
                                                    new int[]{1,2},
                                                    User.class);
    }

    @Override
    public Optional<User> deleteUserById(Long u_id) {
        return Optional.ofNullable(jdbcTemplate.queryForObject(SQL_DELETE_USER_BY_ID, userRowMapper, u_id));
    }

    @Override
    public int deleteUserByEmail(String u_email) {
        return jdbcTemplate.update(SQL_DELETE_USER_BY_EMAIL, userRowMapper, u_email);
    }

    @Override
    public List<User> saveAllUsers(List<User> users) {
        Assert.notNull(users, "Entities must not be null!");
        List<User> resultList = new ArrayList<>();

        for (User user : users) {
            jdbcTemplate.update(SQL_CREATE_USER, new Object[]{user.getF_name(), user.getL_name(), user.getEmail()},
                    new int[]{1, 2, 3});
            System.out.println(user.getEmail());
        }
        return resultList;
    }
}