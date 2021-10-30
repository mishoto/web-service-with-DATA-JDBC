package dev.mihail.DTO;

import dev.mihail.DAO.UserDAOImpl;
import dev.mihail.model.User;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Service
public class UserDTOService implements UserDTOStructMapper{

    @Autowired
    private final UserDAOImpl userDAOImpl;

    public UserDTOService(UserDAOImpl userDAOImpl) {
        this.userDAOImpl = userDAOImpl;
    }


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
        int rowsAffected = userDAOImpl.deleteUserByEmail(user.getEmail());
        return "User Successfully deleted, number of rows affected: " + rowsAffected;
    }

    @Override
    public UserDTO toUserDto(User user) {
        UserDTO.UserDTOBuilder userDTOBuilder = new UserDTO.UserDTOBuilder();
//        userDTOBuilder.withUUID(user.getEmail());
        userDTOBuilder.withF_name(user.getF_name());
        userDTOBuilder.withL_name(user.getL_name());
        userDTOBuilder.withE_mail(user.getEmail());
        return userDTOBuilder.build();
    }

    @Override
    public User toUser(UserDTO userDTO) {
        User user = new User();
        user.setF_name(userDTO.getF_name());
        user.setL_name(userDTO.getL_name());
        user.setEmail(userDTO.getE_mail());
        return user;
    }
}
