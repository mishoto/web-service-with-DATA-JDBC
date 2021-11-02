package dev.mihail.DAOTest;

import dev.mihail.DAO.UserDAOImpl;
import dev.mihail.model.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import javax.sql.DataSource;


import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;



public class UserDAOImplTest {

    private static final UserDAOImpl userDAOImplMock = new UserDAOImpl();
    @Autowired
    private static JdbcTemplate jdbcTemplate;

    @BeforeAll
    static void setup() {
        DataSource dataSourceH2 = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:/schema.sql")
                .addScript("classpath:/data.sql")
                .build();


        userDAOImplMock.setDataSource(dataSourceH2);
        jdbcTemplate = new JdbcTemplate(dataSourceH2);
    }

    @Test
    void  shouldReturnAllUsersBy_SQL_COUNT() {
        assertEquals(4, userDAOImplMock.getCountOfUsers());
    }
    @Test
    void shouldReturnAllUsersBy_SQL_SELECT_ALL() {
        assertEquals(4, userDAOImplMock.getAllUsers().size());
    }
    @Test
    void shouldCompare_getUserById_and_getUserByEmail_Returning_Same_Result() {
        assertEquals(userDAOImplMock.getUserById(2L).getU_id(),
                     userDAOImplMock.getUserByEmail("Knuth_USA@site.us").getU_id());
    }
    @Test
    void shouldInsertNewUserInDB() {
        User user = new User(7L, "Josh", "Long", "josh@email.us");
        int rowsAffected = userDAOImplMock.createUser(user);
       assertEquals(1, rowsAffected);
        assertEquals(5, userDAOImplMock.getAllUsers().size());
    }
    @Test
    void should_UpdateUser_Using_PreparedStatement() throws NoSuchFieldException {
        User userFromDB = userDAOImplMock.getUserById(1L);
        assertNotNull(userFromDB);
        userFromDB.setU_l_name("Peter");
        userFromDB.setU_f_name("Norton");
        String query = UserDAOImpl.class.getDeclaredField("SQL_UPDATE_USER_BY_ID").toString();
        jdbcTemplate.execute(query, (PreparedStatementCallback<Boolean>) ps -> {
            ps.setLong(4, userFromDB.getU_id());
            ps.setString(1, userFromDB.getU_f_name());
            ps.setString(2, userFromDB.getU_l_name());
            ps.setString(3, userFromDB.getU_email());
            return ps.execute();
        });
        User updatedUser = userDAOImplMock.getUserById(1L);
        assertThat("Peter").isEqualTo(updatedUser.getU_f_name());
    }

    @Test
    public void should_Check_Delete_By_Id_In_DB() {
        int userListSize = userDAOImplMock.getAllUsers().size();
        int rowsAffected = userDAOImplMock.deleteUserById(1L);
        assertEquals(userListSize-rowsAffected, userDAOImplMock.getAllUsers().size());
    }

}
