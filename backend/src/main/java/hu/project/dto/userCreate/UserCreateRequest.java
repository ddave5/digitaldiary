package hu.project.dto.userCreate;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserCreateRequest {

    @Size(min = 1, max = 63, message = "A felhasználónév hossza nem megfelelő")
    private String username;

    @Size(min = 1, max = 127, message = "Az email cím hossza nem megfelelő")
    private String email;

    @Size(min = 1, max = 200, message = "A password hossza nem megfelelő")
    private String password;

    @Size(min = 1, max = 127, message = "A keresztnév hossza nem megfelelő")
    private String firstName;

    @Size(min = 1, max = 127, message = "A vezetéknév hossza nem megfelelő")
    private String lastName;

    private Date dateOfBirth;

    @Size(min = 1, max = 20, message = "Az avatar hossza nem megfelelő")
    private String avatar;

}
