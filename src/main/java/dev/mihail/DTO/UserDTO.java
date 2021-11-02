package dev.mihail.DTO;

import java.io.Serializable;

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
        public void withF_name (String firstName){
            this.f_name = firstName;
        }
        public void withL_name (String lastName){
            this.l_name = lastName;
        }
        public void withE_mail (String email){
            this.e_mail = email;
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


