package BookMYShow.Application.Security.Models;

import BookMYShow.Application.Model.Role;
import org.springframework.security.core.GrantedAuthority;

public class CustomAuthority implements GrantedAuthority {
    private final Role authority;

    public CustomAuthority(Role authority){
        this.authority = authority;
    }
    @Override
    public String getAuthority() {
        return authority.getRoleName().toString();
    }
}
