package BookMYShow.Application.Service.Implementations;

import BookMYShow.Application.Exception.UserNotFoundException;
import BookMYShow.Application.Model.User;
import BookMYShow.Application.Repository.UserRepo;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import BookMYShow.Application.Service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserServiceImpl implements UserService {
    private UserRepo userRepo;
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
    public UserServiceImpl(UserRepo userRepo
//            ,BCryptPasswordEncoder bCryptPasswordEncoder
    ){
        this.userRepo = userRepo;
//        this.bCryptPasswordEncoder = bCryptPasswordEncoder;

    }
    @Override
    public void signIn(String userName, String password) throws UserNotFoundException{
        Optional<User> user = userRepo.findByName(userName);
        if(user.isEmpty())
            throw new UserNotFoundException("user not found! please sign up");
    }
    @Override
    public void signUP(String userName, String password,String confirmPassword){
        User user = new User();
        user.setName(userName);
        user.setPassword(password);
//        user.setPassword(bCryptPasswordEncoder.encode(password));
        userRepo.save(user);
    }
}
