package dev.mihail.DTO;


import java.util.Optional;

public interface UserDAO<T, ID> {

    String create(T u);

    Optional<T> getById(ID u_id);

    Optional<T> updateById(ID u_id);

    String update(T u);

    Optional<T> deleteById(ID u_id);

    String delete(T u);
}
