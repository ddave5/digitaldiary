package hu.project.dto.userCreate;

import jakarta.validation.constraints.Size;

import java.util.Date;

public class UserCreateResponse {

    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String avatar;
}
