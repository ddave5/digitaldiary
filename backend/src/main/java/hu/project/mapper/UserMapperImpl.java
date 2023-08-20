package hu.project.mapper;

import hu.project.domain.User;
import hu.project.dto.userCreate.UserCreateRequest;
import hu.project.dto.userCreate.UserCreateResponse;
import hu.project.dto.userGet.LoginResponse;

public class UserMapperImpl implements UserMapper{

    @Override
    public UserCreateResponse mapToCreateResponse(User user) {
        return null;
    }

    @Override
    public User mapToCreateEntity(UserCreateRequest userCreateRequest) {
        return null;
    }

    @Override
    public LoginResponse mapToGetResponse(User user) {
        LoginResponse response = new LoginResponse();
        response.setAvatar(user.getAvatar());
        response.setEmail(user.getEmail());
        response.setPassword(user.getPassword());
        response.setUsername(user.getUsername());
        response.setFirstName(user.getFirstName());
        response.setLastName(user.getLastName());
        response.setDateOfBirth(user.getDateOfBirth());
        return response;
    }

    @Override
    public User maptoGetEntity(UserCreateRequest user) {
        return null;
    }
}
