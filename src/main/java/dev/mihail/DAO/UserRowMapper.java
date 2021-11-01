package dev.mihail.DAO;


import dev.mihail.model.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Configuration
public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User userFromDB = new User();
                userFromDB.setId(rs.getLong("u_id"));
                userFromDB.setF_name(rs.getString("u_f_name"));
                userFromDB.setL_name(rs.getString("u_l_name"));
                userFromDB.setEmail(rs.getString("u_email"));
                return userFromDB;
    }


}
