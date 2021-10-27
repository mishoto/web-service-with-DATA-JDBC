package dev.mihail.DAO;


import dev.mihail.model.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User userFromDB = new User();
                userFromDB.setId(rs.getLong("u_id"));
                userFromDB.setFirstName(rs.getString("u_f_name"));
                userFromDB.setLastName(rs.getString("u_l_name"));
                userFromDB.setEmail(rs.getString("u_email"));
                return userFromDB;
    }
}
