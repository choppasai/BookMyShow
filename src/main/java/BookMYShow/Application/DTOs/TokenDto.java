package BookMYShow.Application.DTOs;

import BookMYShow.Application.Model.User;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class TokenDto {
    private String value;
    private User user;
    private Date expiryAt;
}
