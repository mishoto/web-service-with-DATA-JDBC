package dev.mihail.Exceptions;

public class UserNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 3591518762764266414L;

    public UserNotFoundException(Long id) {
        super("User not found with this ID: " + id);
    }

    public UserNotFoundException(String email) {
        super("User not found with this email: " + email);
    }
}
