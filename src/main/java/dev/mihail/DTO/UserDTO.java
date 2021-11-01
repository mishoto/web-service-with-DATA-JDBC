package dev.mihail.DTO;

import dev.mihail.model.User;
import org.springframework.context.annotation.Bean;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

public class UserDTO implements Serializable {

//    private UUID uuid;
    private String f_name;
    private String l_name;
    private String e_mail;

    private UserDTO() {
    }

    public UserDTO(String f_name, String l_name, String e_mail) {
        this.f_name = f_name;
        this.l_name = l_name;
        this.e_mail = e_mail;
    }

    public static class UserDTOBuilder {
//        private UUID uuid;
        private String f_name;
        private String l_name;
        private String e_mail;

//        public UserDTOBuilder withUUID (String email){
//            this.uuid = UUID.fromString(this.e_mail = email);
//            return this;
//        }
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
//            userDTO.uuid = this.uuid;
            userDTO.f_name = this.f_name;
            userDTO.l_name = this.l_name;
            userDTO.e_mail = this.e_mail;
            return userDTO;
        }
    }

//    public UUID getUuid() {
//        return uuid;
//    }
//
//    public void setUuid(UUID uuid) {
//        this.uuid = uuid;
//    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getL_name() {
        return l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }
}


