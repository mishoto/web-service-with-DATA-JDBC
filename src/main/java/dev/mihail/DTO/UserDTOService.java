package dev.mihail.DTO;

import dev.mihail.DAO.UserDAOService;
import dev.mihail.model.User;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Service
public class UserDTOService implements UserDTOStructMapper{

    @Autowired
    private final UserDAOService userDAOService;

    public UserDTOService(UserDAOService userDAOService) {
        this.userDAOService = userDAOService;
    }

    @Bean
    public String saveDTOUser(UserDTO userDTO){
        Optional<User> optionalUser = Optional.ofNullable(userDAOService.getUserByEmail(userDTO.getE_mail()));
        if (optionalUser.isPresent()){
            throw new RuntimeException("User already exist");
        }
        User user = toUser(userDTO);
        int rowsAffected = userDAOService.createUser(user);
        return "User Successfully saved, number of rows affected: " + rowsAffected;
    }

    @Bean
    public UserDTO getDTOUserByEmail(String email){
        Optional<User> optionalUser = Optional.ofNullable(userDAOService.getUserByEmail(email));
        if (optionalUser.isEmpty()){
            throw new RuntimeException("User with this " + email + "don't exist");
        }
        User user = userDAOService.getUserByEmail(email);
        return toUserDto(user);
    }

    @Bean
    public UserDTO updateDTOUserByEmail(UserDTO userDTO){
        User user = userDAOService.getUserByEmail(userDTO.getE_mail());
        if (user == null){
            throw new RuntimeException("User with this " + userDTO.getE_mail() + "don't exist");
        }
        user = toUser(userDTO);
        userDAOService.updateUserByEmail(user);
        return userDTO;
    }

    @Bean
    public String deleteUserDTOByEmail(String email){
        User user = userDAOService.getUserByEmail(email);
        if (user == null){
            throw new RuntimeException("User with this " + email + "don't exist");
        }
        int rowsAffected = userDAOService.deleteUserByEmail(user.getEmail());
        return "User Successfully deleted, number of rows affected: " + rowsAffected;
    }

    @Override
    public UserDTO toUserDto(User user) {
        UserDTO.UserDTOBuilder userDTOBuilder = new UserDTO.UserDTOBuilder();
        userDTOBuilder.withUUID(user.getEmail());
        userDTOBuilder.withF_name(user.getFirstName());
        userDTOBuilder.withL_name(user.getLastName());
        userDTOBuilder.withE_mail(user.getEmail());
        return userDTOBuilder.build();
    }

    @Override
    public User toUser(UserDTO userDTO) {
        User user = new User();
        user.setFirstName(userDTO.getF_name());
        user.setLastName(userDTO.getL_name());
        user.setEmail(userDTO.getE_mail());
        return user;
    }
}
