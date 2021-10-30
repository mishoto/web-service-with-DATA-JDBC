package dev.mihail.DAO;


import dev.mihail.model.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

@Configuration
public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User userFromDB = new User();
                userFromDB.setId(rs.getLong("id"));
                userFromDB.setF_name(rs.getString("f_name"));
                userFromDB.setL_name(rs.getString("l_name"));
                userFromDB.setEmail(rs.getString("email"));
                return userFromDB;
    }
}
