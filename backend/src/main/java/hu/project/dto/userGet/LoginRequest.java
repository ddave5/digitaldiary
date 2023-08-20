package hu.project.dto.userGet;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {

    @Size(min = 1, max = 63, message = "A felhasználónév hossza nem megfelelő")
    private String user;

    @Size(min = 1, max = 200, message = "A password hossza nem megfelelő")
    private String password;

}
