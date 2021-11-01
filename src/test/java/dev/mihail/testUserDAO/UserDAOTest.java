package dev.mihail.testUserDAO;

import dev.mihail.DAO.UserDAOImpl;
import dev.mihail.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class UserDAOTest {

    @Test
    public void whenInjectInMemoryDataSource_thenReturnCorrectUserCount() {
        DataSource dataSource = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:/schema.sql")
                .addScript("classpath:/data.sql")
                .build();

        UserDAOImpl userDAO = new UserDAOImpl();
        userDAO.setDataSource(dataSource);

        List<User> userList = userDAO.getAllUsers();

        assertEquals(4, userDAO.getCountOfUsers());
        assertEquals(4, userDAO.getAllUsers().size());
        assertNotEquals(userList.get(1), userDAO.getUserByEmail("Knuth_USA@site.us"));
    }
}
