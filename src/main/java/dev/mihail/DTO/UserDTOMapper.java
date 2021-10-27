package dev.mihail.DTO;

import dev.mihail.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserDTOMapper {

    UserDTOMapper INSTANCE = Mappers.getMapper(UserDTOMapper.class);

    @Mapping(target = "userDTO.id", source = "user.id")
    @Mapping(target = "userDTO.f_name", source = "user.firstName")
    @Mapping(target = "userDTO.l_name", source = "user.lastName")
    @Mapping(target = "userDTO.e_mail", source = "user.email")
    UserDTO toUserDto(User user);

    @Mapping(target = "userDTO.f_name", source = "user.firstName")
    @Mapping(target = "userDTO.e_mail", source = "user.email")
    UserDTO toUserDtoFNameAndEmail(User user);
}
