package dev.mihail.Exceptions;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(Long id) {
        super("User not found with this ID: " + id);
    }

    public UserNotFoundException(String email) {
        super("User not found with this email: " + email);
    }
}
