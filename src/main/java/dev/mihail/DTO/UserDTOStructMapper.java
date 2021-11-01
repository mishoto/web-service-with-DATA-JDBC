package dev.mihail.DTO;

import dev.mihail.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface UserDTOStructMapper {

//    @Mapping(target = "uuid", source = "email")
    @Mapping(target = "l_name", source = "l_name")
    @Mapping(target = "f_name", source = "f_name")
    @Mapping(target = "e_mail", source = "email")
    UserDTO toUserDto(User user);

    @Mapping(target = "u_id", ignore = true)
    @Mapping(target = "f_name", source = "f_name")
    @Mapping(target = "l_name", source = "l_name")
    @Mapping(target = "u_email", source = "e_mail")
    User toUser(UserDTO userDTO);
}
