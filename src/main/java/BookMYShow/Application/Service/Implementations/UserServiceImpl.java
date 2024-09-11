package BookMYShow.Application.Service.Implementations;

import BookMYShow.Application.Exception.UserNotFoundException;
import BookMYShow.Application.Model.User;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import BookMYShow.Application.Repository.UserRepository;
import BookMYShow.Application.Service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
    public UserServiceImpl(UserRepository userRepository
//            ,BCryptPasswordEncoder bCryptPasswordEncoder
    ){
        this.userRepository = userRepository;
//        this.bCryptPasswordEncoder = bCryptPasswordEncoder;

    }
    @Override
    public void signIn(String userName, String password) throws UserNotFoundException{
        Optional<User> user = userRepository.findByName(userName);
        if(user.isEmpty())
            throw new UserNotFoundException("user not found! please sign up");
    }
    @Override
    public void signUP(String userName, String password,String confirmPassword){
        User user = new User();
        user.setName(userName);
        user.setPassword(password);
//        user.setPassword(bCryptPasswordEncoder.encode(password));
        userRepository.save(user);
    }
}
