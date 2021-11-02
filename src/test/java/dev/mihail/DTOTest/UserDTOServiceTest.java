package dev.mihail.DTOTest;

import dev.mihail.DTO.UserDTO;
import dev.mihail.DTO.UserDTOService;
import dev.mihail.model.User;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class UserDTOServiceTest {

    UserDTOService userDTOService = new UserDTOService();

    @Test
    public void shouldCheck_StructMapper_Field_Value_UserDTO(){

        UserDTO userDTO = new UserDTO("John", "Dow", "john@email.eu");
        assertThat("John").isEqualTo(userDTOService.toUser(userDTO).getU_f_name());
    }
    @Test
    public void shouldCheck_StructMapper_Returning_Correct_User_Field_Values_From_UserDTO(){
        User user = new User("John", "Dow", "john@email.eu");
        UserDTO userDTO = new UserDTO("John", "Dow", "john@email.eu");
        User userFromStructMapper = userDTOService.toUser(userDTO);
        assertThat(user.getU_email()).isEqualTo(userFromStructMapper.getU_email());
    }
}
