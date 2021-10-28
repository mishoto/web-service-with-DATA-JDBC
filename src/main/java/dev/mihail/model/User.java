package dev.mihail.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {

    @NotNull
    private Long id;
    @NotNull(message = "first name cannot be empty")
    @Size(min = 2, max = 20, message = "first name must be between 2 and 20 characters")
    private String firstName;
    @NotNull(message = "first name cannot be empty")
    @Size(min = 2, max = 20, message = "last name must be between 2 and 20 characters")
    private String lastName;
    @NotNull(message = "email cannot be empty")
    @Email
    private String email;

    public User() {}

    public User(Long id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
                ", userFirstName='" + firstName + '\'' +
                ", userLastName='" + lastName + '\'' +
                ", userEmail='" + email + '\'' +
                '}';
    }
}
