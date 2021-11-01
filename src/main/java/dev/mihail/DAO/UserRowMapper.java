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
                userFromDB.setU_id(rs.getLong("u_id"));
                userFromDB.setU_f_name(rs.getString("u_f_name"));
                userFromDB.setU_l_name(rs.getString("u_l_name"));
                userFromDB.setU_email(rs.getString("u_email"));
                return userFromDB;
    }


}
