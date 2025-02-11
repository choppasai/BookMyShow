package BookMYShow.Application.Model;

import BookMYShow.Application.Model.Enums.Verification;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name =  "users")

public class User extends Base{
    private String name;
    private String password;
    private String email;
    private Integer phoneNumber;
    @ManyToMany
    private List<Role> roleList;
    private Verification isVerified;
}
