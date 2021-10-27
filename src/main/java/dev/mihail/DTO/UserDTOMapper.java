package dev.mihail.DTO;

import dev.mihail.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserDTOMapper {
    UserDTOMapper INSTANCE = Mappers.getMapper(UserDTOMapper.class);
    UserDTO toUserDto(User user);
    UserDTO toUserDtoFNameAndEmail(User user);
}
