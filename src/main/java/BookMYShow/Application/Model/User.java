package BookMYShow.Application.Model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name =  "users")

public class User extends Base{
    private String name;
    private String password;
    private String email;
    private Integer phoneNumber;
}
