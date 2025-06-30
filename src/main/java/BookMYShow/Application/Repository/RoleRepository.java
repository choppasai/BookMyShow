package BookMYShow.Application.Repository;

import BookMYShow.Application.Model.Enums.RoleType;
import BookMYShow.Application.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    @Query("select r from Role r where r.roleName = ?1")
    public Optional<Role> findByRoleName(Enum roleType);
}
