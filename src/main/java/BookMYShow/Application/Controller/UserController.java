package BookMYShow.Application.Controller;

import BookMYShow.Application.DTOs.TokenDto;
import BookMYShow.Application.DTOs.UserRequestDTO;
import BookMYShow.Application.DTOs.UserSignUpDTO;
import BookMYShow.Application.Exception.PasswordIncorrect;
import BookMYShow.Application.Exception.UserAlreadyPresentException;
import BookMYShow.Application.Exception.UserNotFoundException;
import BookMYShow.Application.Service.Implementations.UserServiceImpl;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UserController {
    private final UserServiceImpl userServiceImpl;
    public UserController(UserServiceImpl userServiceImpl){
        this.userServiceImpl = userServiceImpl;
    }

    @PostMapping("/sign-up")
    public ResponseEntity<String> signUp(@RequestBody UserSignUpDTO userSignUpDTO){

        try{
            userServiceImpl.signUP(userSignUpDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("Successfully signed in");
        }
        catch (UserAlreadyPresentException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User already exists");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserRequestDTO userRequestDTO){
        try{
            userServiceImpl.signIn(userRequestDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("login successfull");
        }
        catch (UserNotFoundException e){
            e.getMessage();
//            UserSignUpDTO userSignUpDTO = new UserSignUpDTO();
//            userSignUpDTO.setUserName(userRequestDTO.getName());
//            userSignUpDTO.setEmail(userRequestDTO.getEmail());
//            userSignUpDTO.setPassword(userRequestDTO.getPassword());
//            userSignUpDTO.setConfirmPassword(userRequestDTO.getPassword());
//            signUp(userSignUpDTO);
            return ResponseEntity.status(HttpStatus.CONFLICT).body("user not found");
        }
        catch (PasswordIncorrect e){
            System.out.println("incorrect pass");
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Incorrect password");
        }

    }



    @PostMapping("/logout")
    public void logout(@RequestBody TokenDto tokenDto){

    }
}
