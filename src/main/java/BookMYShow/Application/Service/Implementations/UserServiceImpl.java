package BookMYShow.Application.Service.Implementations;

import BookMYShow.Application.DTOs.TokenDto;
import BookMYShow.Application.DTOs.UserRequestDTO;
import BookMYShow.Application.DTOs.UserSignUpDTO;
import BookMYShow.Application.Exception.PasswordIncorrect;
import BookMYShow.Application.Exception.UserAlreadyPresentException;
import BookMYShow.Application.Exception.UserNotFoundException;
import BookMYShow.Application.Model.User;
import BookMYShow.Application.Repository.UserRepository;
import BookMYShow.Application.Service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    public UserServiceImpl(UserRepository userRepository
            ,BCryptPasswordEncoder bCryptPasswordEncoder
    ){
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;

    }
    @Override
    public void signUP(UserSignUpDTO userSignUpDTO) throws UserAlreadyPresentException{
        if(!userRepository.findByEmail(userSignUpDTO.getEmail()).isEmpty())
            throw new UserAlreadyPresentException(userSignUpDTO.getEmail() + "is already registered user");
        User user = new User();
        user.setName(userSignUpDTO.getUserName());
        user.setEmail(userSignUpDTO.getEmail());
        user.setPassword(bCryptPasswordEncoder.encode(userSignUpDTO.getPassword()));
        userRepository.save(user);
    }

    @Override
    public void signIn(UserRequestDTO userRequestDTO) throws UserNotFoundException,PasswordIncorrect{
        Optional<User> user = userRepository.findByEmail(userRequestDTO.getEmail());
        if(user.isEmpty())
            throw new UserNotFoundException("user not found! please sign up");
        if(!bCryptPasswordEncoder.matches(userRequestDTO.getPassword(),user.get().getPassword()))
            throw new PasswordIncorrect("provided password is incorrect. please check password once");

    }


//    @Override
//    public void logout(TokenDto tokenDto){
//        User user = tokenDto.getUser();
//        user.set
//    }
}
