package dev.mihail.model;

import org.springframework.data.annotation.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class User {

    @Id
    private Long u_id;
    @NotNull(message = "first name cannot be empty")
    @Size(min = 2, max = 20, message = "first name must be between 2 and 20 characters")
    private String u_f_name;
    @NotNull(message = "first name cannot be empty")
    @Size(min = 2, max = 20, message = "last name must be between 2 and 20 characters")
    private String u_l_name;
    @NotNull(message = "email cannot be empty")
    @Email
    private String u_email;

    public User() {}

    public User(String u_f_name, String u_l_name, String u_email) {

        this.u_f_name = u_f_name;
        this.u_l_name = u_l_name;
        this.u_email = u_email;
    }

    public Long getU_id() {
        return u_id;
    }

    public void setU_id(Long u_id) {
        this.u_id = u_id;
    }

    public String getU_f_name() {
        return u_f_name;
    }

    public void setU_f_name(String u_f_name) {
        this.u_f_name = u_f_name;
    }

    public String getU_l_name() {
        return u_l_name;
    }

    public void setU_l_name(String u_l_name) {
        this.u_l_name = u_l_name;
    }

    public String getU_email() {
        return u_email;
    }

    public void setU_email(String u_email) {
        this.u_email = u_email;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + u_id +
                ", userFirstName='" + u_f_name + '\'' +
                ", userLastName='" + u_l_name + '\'' +
                ", userEmail='" + u_email + '\'' +
                '}';
    }
}
