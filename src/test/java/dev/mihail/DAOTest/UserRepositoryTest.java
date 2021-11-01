package dev.mihail.DAOTest;

import dev.mihail.DAO.UserRepository;
import dev.mihail.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJdbcTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void test(){
        User user = new User();
        user.setU_id(5L);
        user.setU_f_name("John");
        user.setU_l_name("Dow");
        user.setU_email("ex@foo.com");

        User savedUser = userRepository.save(user);

        assertThat(savedUser).isNotNull();
    }
}
