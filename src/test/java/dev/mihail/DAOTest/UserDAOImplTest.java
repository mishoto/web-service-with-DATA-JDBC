package dev.mihail.DAOTest;

import dev.mihail.DAO.UserDAOImpl;
import dev.mihail.model.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import javax.sql.DataSource;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;


public class UserDAOImplTest {

    private static final UserDAOImpl userDAOImplMock = new UserDAOImpl();

    @BeforeAll
    static void setup() {
        DataSource dataSourceH2 = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:/schema.sql")
                .addScript("classpath:/data.sql")
                .build();


        userDAOImplMock.setDataSource(dataSourceH2);
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
    void should_Check_If_User_IsUpdated_In_InDB() {
        User userFromDB = userDAOImplMock.getUserById(1L);

        userFromDB.setU_f_name("Peter");
        userFromDB.setU_l_name("Norton");
        userFromDB.setU_email(userFromDB.getU_email());
        userDAOImplMock.updateUserById(userFromDB);
        User userUpdated = userDAOImplMock.getUserById(1L);
        assertNotEquals("J", String.valueOf(userUpdated.getU_f_name().indexOf(0)));
    }

    @Test
    public void should_Check_Delete_By_ID_In_DB() {
        int userListSize = userDAOImplMock.getAllUsers().size();
        int rowsAffected = userDAOImplMock.deleteUserById(1L);
        assertEquals(userListSize-rowsAffected, userDAOImplMock.getAllUsers().size());
    }

}
