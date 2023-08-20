package hu.project.mapper;

import hu.project.domain.User;
import hu.project.dto.userCreate.UserCreateRequest;
import hu.project.dto.userCreate.UserCreateResponse;
import hu.project.dto.userGet.LoginResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );

    UserCreateResponse mapToCreateResponse(User user);
    User mapToCreateEntity(UserCreateRequest userCreateRequest);

    LoginResponse mapToGetResponse(User user);
    User maptoGetEntity(UserCreateRequest user);
}
