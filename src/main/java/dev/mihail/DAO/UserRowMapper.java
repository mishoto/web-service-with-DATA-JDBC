package dev.mihail.DAO;


import dev.mihail.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {


    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new User(
                rs.getLong("u_id"),
                rs.getString("u_f_name"),
                rs.getString("u_l_name"),
                rs.getString("u_email")
        );
    }
}
