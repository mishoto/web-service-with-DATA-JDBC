package dev.mihail.DTO;

import dev.mihail.DAO.UserDAOImpl;
import dev.mihail.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserDTOService implements UserDTOStructMapper{

    @Autowired
    private UserDAOImpl userDAOImpl;

    public String saveDTOUser(UserDTO userDTO){
        Optional<User> optionalUser = Optional.ofNullable(userDAOImpl.getUserByEmail(userDTO.getE_mail()));
        if (optionalUser.isPresent()){
            throw new RuntimeException("User already exist");
        }
        User user = toUser(userDTO);
        int rowsAffected = userDAOImpl.createUser(user);
        return "User Successfully saved, number of rows affected: " + rowsAffected;
    }

    public UserDTO getDTOUserByEmail(String email){
        Optional<User> optionalUser = Optional.ofNullable(userDAOImpl.getUserByEmail(email));
        if (optionalUser.isEmpty()){
            throw new RuntimeException("User with this " + email + "don't exist");
        }
        User user = userDAOImpl.getUserByEmail(email);
        return toUserDto(user);
    }

    public UserDTO getDTOUserById(Long id){
        Optional optionalUser = Optional.ofNullable(userDAOImpl.getUserById(id));
        if (optionalUser.isEmpty()){
            throw new RuntimeException("User with this " + id + "don't exist");
        }
        User user = userDAOImpl.getUserById(id);
        return toUserDto(user);
    }

    public UserDTO updateDTOUserByEmail(UserDTO userDTO){
        User user = userDAOImpl.getUserByEmail(userDTO.getE_mail());
        if (user == null){
            throw new RuntimeException("User with this " + userDTO.getE_mail() + "don't exist");
        }
        user = toUser(userDTO);
        userDAOImpl.updateUserByEmail(user);
        return userDTO;
    }

    public String deleteUserDTOByEmail(String email){
        User user = userDAOImpl.getUserByEmail(email);
        if (user == null){
            throw new RuntimeException("User with this " + email + "don't exist");
        }
        int rowsAffected = userDAOImpl.deleteUserByEmail(user.getU_email());
        return "User Successfully deleted, number of rows affected: " + rowsAffected;
    }

    @Override
    public UserDTO toUserDto(User user) {
        UserDTO.UserDTOBuilder userDTOBuilder = new UserDTO.UserDTOBuilder();
//        userDTOBuilder.withUUID(user.getEmail());
        userDTOBuilder.withF_name(user.getU_f_name());
        userDTOBuilder.withL_name(user.getU_l_name());
        userDTOBuilder.withE_mail(user.getU_email());
        return userDTOBuilder.build();
    }

    @Override
    public User toUser(UserDTO userDTO) {
        User user = new User();
        user.setU_f_name(userDTO.getF_name());
        user.setU_l_name(userDTO.getL_name());
        user.setU_email(userDTO.getE_mail());
        return user;
    }
}
