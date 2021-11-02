package dev.mihail.DAOTest;


import dev.mihail.model.User;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.data.jdbc.core.JdbcAggregateTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@DataJdbcTest
public class UserRepositoryTest {

    @Autowired
    JdbcAggregateTemplate jdbcAggregateTemplate;

    @BeforeAll
    static void setup() {
        DataSource dataSourceH2 = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:/schema.sql")
                .addScript("classpath:/data.sql")
                .build();
    }

    @Test
    public void testForUpdatingUser(){
        User userBefore = new User();
        userBefore.setU_id(3L);
        userBefore.setU_f_name("John");
        userBefore.setU_l_name("Dow");
        userBefore.setU_email("ex@foo.com");

        User userAfter = jdbcAggregateTemplate.update(userBefore);
        assertThat(userAfter).isNotNull();
    }
    @Test
    public void shouldTestBeforeUpdate_And_AfterUpdate_Field(){
        User userFromDB = jdbcAggregateTemplate.findById(1L, User.class);
        assertNotNull(userFromDB);
        userFromDB.setU_f_name("Peter");
        userFromDB.setU_l_name("Norton");
        User userUpdated = jdbcAggregateTemplate.update(userFromDB);
        assertThat(userUpdated.getU_f_name()).isEqualTo("Peter");
        assertThat(userUpdated.getU_l_name()).isEqualTo("Norton");

    }
}
