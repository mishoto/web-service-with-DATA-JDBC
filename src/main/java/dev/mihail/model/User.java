package dev.mihail.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class User {

    @Id
    @NotNull
    private Long id;
    @Column
    @NotNull(message = "first name cannot be empty")
    @Size(min = 2, max = 20, message = "first name must be between 2 and 20 characters")
    private String f_name;
    @Column
    @NotNull(message = "first name cannot be empty")
    @Size(min = 2, max = 20, message = "last name must be between 2 and 20 characters")
    private String l_name;
    @Column
    @NotNull(message = "email cannot be empty")
    @Email
    private String email;

    public User() {}

    public User(String f_name, String l_name, String email) {

        this.f_name = f_name;
        this.l_name = l_name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + id +
                ", userFirstName='" + f_name + '\'' +
                ", userLastName='" + l_name + '\'' +
                ", userEmail='" + email + '\'' +
                '}';
    }
}
