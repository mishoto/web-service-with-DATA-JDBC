package dev.mihail.DAO;


import dev.mihail.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.sql.SQLSyntaxErrorException;
import java.util.List;
import java.util.Optional;


public interface UserDAO<T, ID> extends Repository<User, Long> {


    int createUser(T u) throws SQLSyntaxErrorException;

    Optional<T> getUserById(ID u_id) throws SQLSyntaxErrorException;

    User getUserByEmail(String email) throws SQLSyntaxErrorException;

    List<User> getAllUsers() throws SQLSyntaxErrorException;

    Optional<T> updateUserById(ID u_id) throws SQLSyntaxErrorException;

    User updateUserByEmail(T user) throws SQLSyntaxErrorException;

    Optional<T> deleteUserById(ID u_id) throws SQLSyntaxErrorException;

    int deleteUserByEmail(String u_email) throws SQLSyntaxErrorException;

    List<T> saveAllUsers(List<T> users);
}
