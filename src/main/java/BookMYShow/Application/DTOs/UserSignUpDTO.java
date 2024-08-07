package BookMYShow.Application.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSignUpDTO {
    private String userName;
    private String password;
    private String confirmPassword;
}
