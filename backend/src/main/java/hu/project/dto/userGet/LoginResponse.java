package hu.project.dto.userGet;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class LoginResponse {

    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String avatar;
}
