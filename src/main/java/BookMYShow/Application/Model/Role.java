package BookMYShow.Application.Model;

import BookMYShow.Application.Model.Enums.RoleType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Entity
@Data
@AllArgsConstructor
public class Role extends Base{
    @Enumerated(EnumType.STRING)
    private RoleType roleName;
    @ManyToMany
    private List<User> userList;

}
