package dev.mihail.DAO;


import dev.mihail.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDAO<T, ID> {

    int createUser(T u);

    Optional<T> getUserById(ID u_id);

    List<User> getAllUsers();

    Optional<T> updateUserById(ID u_id);

    User updateUserByEmail(String u_email);

    Optional<T> deleteUserById(ID u_id);

    void deleteUserByEmail(String u_email);
}
