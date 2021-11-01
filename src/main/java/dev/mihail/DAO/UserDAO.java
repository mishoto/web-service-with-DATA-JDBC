package dev.mihail.DAO;


import dev.mihail.model.User;

import java.sql.SQLSyntaxErrorException;
import java.util.List;


public interface UserDAO<T, ID> {


    int createUser(T u) throws SQLSyntaxErrorException;

     User getUserById(ID u_id) throws SQLSyntaxErrorException;

    User getUserByEmail(String email) throws SQLSyntaxErrorException;

    List<User> getAllUsers() throws SQLSyntaxErrorException;

    User updateUserById(T user) throws SQLSyntaxErrorException;

    User updateUserByEmail(T user) throws SQLSyntaxErrorException;

    int deleteUserById(ID u_id) throws SQLSyntaxErrorException;

    int deleteUserByEmail(String u_email) throws SQLSyntaxErrorException;

    List<T> saveAllUsers(List<T> users);
}
