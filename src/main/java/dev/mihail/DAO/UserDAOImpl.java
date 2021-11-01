package dev.mihail.DAO;

import dev.mihail.model.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import javax.sql.DataSource;
import java.util.ArrayList;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Repository
public class UserDAOImpl implements UserDAO<User, Long> {

    private static final String SQL_CREATE_USER = "INSERT INTO USER (u_id, u_f_name, u_l_name, u_email) values (?, ?, ?, ?)";
    private static final String SQL_SELECT_USER_BY_ID = "SELECT u_id, u_f_name, u_l_name, u_email FROM USER WHERE u_id = ?";
    private static final String SQL_SELECT_USER_BY_EMAIL = "SELECT * FROM USER WHERE user.u_email LIKE ?";
    private static final String SQL_UPDATE_USER_BY_ID = "UPDATE USER SET u_f_name = ?, u_l_name = ?, u_email = ? WHERE u_id = ?";
    private static final String SQL_UPDATE_USER_BY_EMAIL = "UPDATE USER SET u_f_name = ?, u_l_name = ? WHERE u_email = ?";
    private static final String SQL_DELETE_USER_BY_ID = "DELETE USER WHERE u_id = ?";
    private static final String SQL_DELETE_USER_BY_EMAIL = "DELETE USER WHERE u_email = ?";
    private static final String SQL_SELECT_ALL_USERS = "SELECT * FROM USER";

    private static final Logger log = LoggerFactory.getLogger(UserDAOImpl.class);


    private JdbcTemplate jdbcTemplate;

    public UserDAOImpl() {
    }

    public UserDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;

    }

    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public int getCountOfUsers() {
        AtomicReference<Integer> count = new AtomicReference<>(jdbcTemplate.queryForObject("SELECT COUNT(*) FROM USER", Integer.class));
        return count.get();
    }

    @Override
    public int createUser(User u) {
        return jdbcTemplate.update(SQL_CREATE_USER, u.getU_id(), u.getU_f_name(), u.getU_l_name(), u.getU_email());
    }

    @Override
    public User getUserById(Long u_id) {
        return Optional.ofNullable(jdbcTemplate.queryForObject(SQL_SELECT_USER_BY_ID, new UserRowMapper(), u_id)).get();
    }

    @Override
    public User getUserByEmail(String email) {
        return jdbcTemplate.queryForObject(SQL_SELECT_USER_BY_EMAIL, new UserRowMapper(), email);
    }

    @Override
    public List<User> getAllUsers() {
        return jdbcTemplate.query(SQL_SELECT_ALL_USERS, new UserRowMapper());
    }

    @Override
    public Optional<User> updateUserById(Long u_id) {
        return Optional.ofNullable(jdbcTemplate.queryForObject(SQL_UPDATE_USER_BY_ID, new UserRowMapper(), u_id));
    }

    @Override
    public User updateUserByEmail(User user) {
        User userFromDB = jdbcTemplate.queryForObject(SQL_SELECT_USER_BY_EMAIL, new UserRowMapper(), user.getU_email());
        if (userFromDB == null){
            throw new RuntimeException("User with that email not found");
        }
        userFromDB.setU_f_name(user.getU_f_name());
        userFromDB.setU_l_name(user.getU_l_name());
        return jdbcTemplate.queryForObject(SQL_UPDATE_USER_BY_EMAIL,
                                                    new Object[]{userFromDB.getU_f_name(),userFromDB.getU_l_name()},
                                                    new int[]{1,2},
                                                    User.class);
    }

    @Override
    public Optional<User> deleteUserById(Long u_id) {
        return Optional.ofNullable(jdbcTemplate.queryForObject(SQL_DELETE_USER_BY_ID, new UserRowMapper(), u_id));
    }

    @Override
    public int deleteUserByEmail(String u_email) {
        return jdbcTemplate.update(SQL_DELETE_USER_BY_EMAIL, new UserRowMapper(), u_email);
    }

    @Override
    public List<User> saveAllUsers(List<User> users) {
        Assert.notNull(users, "Entities must not be null!");
        List<User> resultList = new ArrayList<>();

        for (User user : users) {
            jdbcTemplate.update(SQL_CREATE_USER, new Object[]{user.getU_f_name(), user.getU_l_name(), user.getU_email()},
                    new int[]{1, 2, 3});
        }
        return resultList;
    }
}
