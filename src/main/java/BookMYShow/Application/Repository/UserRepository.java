package BookMYShow.Application.Repository;

import BookMYShow.Application.Model.User;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public Optional<User> findUserById(int userId);
    public User save(User user);
    public List<User> findAll();
    public void deleteAll();
    public Optional<User> findByName(String userName);
}