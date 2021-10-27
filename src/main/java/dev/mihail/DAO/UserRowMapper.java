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
                userFromDB.setUser_id(rs.getLong("u_id"));
                userFromDB.setUserFirstName(rs.getString("u_f_name"));
                userFromDB.setUserLastName(rs.getString("u_l_name"));
                userFromDB.setUserEmail(rs.getString("u_email"));
                return userFromDB;
    }
}
