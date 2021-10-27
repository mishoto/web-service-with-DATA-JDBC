package dev.mihail.DTO;

import dev.mihail.model.User;

import javax.validation.constraints.NotNull;

public class UserDTO implements UserDTOMapper {

    private Long id;
    private String f_name;
    private String l_name;
    private String e_mail;

    private UserDTO() {
    }

    @Override
    public UserDTO toUserDto(@NotNull User user) {
        UserDTOBuilder userDTOBuilder = new UserDTOBuilder();
        userDTOBuilder.withID(user.getId());
        userDTOBuilder.withF_name(user.getFirstName());
        userDTOBuilder.withL_name(user.getLastName());
        userDTOBuilder.withE_mail(user.getEmail());
        return userDTOBuilder.build();
    }

    @Override
    public UserDTO toUserDtoFNameAndEmail(@NotNull User user) {
        UserDTOBuilder userDTOBuilder = new UserDTOBuilder();
        userDTOBuilder.withF_name(user.getFirstName());
        userDTOBuilder.withE_mail(user.getEmail());
        return userDTOBuilder.build();
    }

    public static class UserDTOBuilder {
        private Long id;
        private String f_name;
        private String l_name;
        private String e_mail;

        public UserDTOBuilder withID (Long id){
            this.id = id;
            return this;
        }
        public UserDTOBuilder withF_name (String firstName){
            this.f_name = firstName;
            return this;
        }
        public UserDTOBuilder withL_name (String lastName){
            this.l_name = lastName;
            return this;
        }
        public UserDTOBuilder withE_mail (String email){
            this.e_mail = email;
            return this;
        }
        public UserDTO build() {
            UserDTO userDTO = new UserDTO();
            userDTO.id = this.id;
            userDTO.f_name = this.f_name;
            userDTO.l_name = this.l_name;
            userDTO.e_mail = this.e_mail;
            return userDTO;
        }
    }
}


