package BookMYShow.Application.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.List;
@Entity
@Data
public class Role extends Base{
    private String roleName;
    @ManyToMany
    private List<User> userList;
}
