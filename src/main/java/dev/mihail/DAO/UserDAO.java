package dev.mihail.DAO;


import java.util.Optional;

public interface UserDAO<T, ID> {

    String createUser(T u);

    Optional<T> getUserById(ID u_id);

    Optional<T> updateUserById(ID u_id);

    String updateUser(T u);

    Optional<T> deleteUserById(ID u_id);

    String deleteUser(T u);
}
