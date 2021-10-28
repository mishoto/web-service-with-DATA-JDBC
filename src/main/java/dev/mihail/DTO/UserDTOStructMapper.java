package dev.mihail.DTO;

import dev.mihail.model.User;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public interface UserDTOStructMapper {

    @Mapping(target = "uuid", source = "email")
    @Mapping(target = "l_name", source = "lastName")
    @Mapping(target = "f_name", source = "firstName")
    @Mapping(target = "e_mail", source = "email")
    UserDTO toUserDto(User user);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "firstName", source = "f_name")
    @Mapping(target = "lastName", source = "l_name")
    @Mapping(target = "email", source = "e_mail")
    User toUser(UserDTO userDTO);
}
