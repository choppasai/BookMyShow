package BookMYShow.Application.Controller;

import BookMYShow.Application.DTOs.UserRequestDTO;
import BookMYShow.Application.DTOs.UserSignUpDTO;
import BookMYShow.Application.Exception.UserNotFoundException;
import BookMYShow.Application.Service.Implementations.UserServiceImpl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/User")
public class UserController {
    private UserServiceImpl userServiceImpl;
    public UserController(UserServiceImpl userServiceImpl){
        this.userServiceImpl = userServiceImpl;
    }
    @GetMapping("/signIn")
    public void signIn(@RequestBody UserRequestDTO userRequestDTO){
        try{
            userServiceImpl.signIn(userRequestDTO.getUserName(),userRequestDTO.getPassword());
        }
        catch (UserNotFoundException e){
            e.getMessage();
            UserSignUpDTO userSignUpDTO = new UserSignUpDTO();
            userSignUpDTO.setUserName(userRequestDTO.getUserName());
            userSignUpDTO.setPassword(userRequestDTO.getPassword());
            userSignUpDTO.setConfirmPassword(userRequestDTO.getPassword());
            signUp(userSignUpDTO);
        }

    }
    @GetMapping("")
    public String sme(){
        return "success";
    }
    @PostMapping("/signUp")
    public ResponseEntity<String> signUp(@RequestBody UserSignUpDTO userSignUpDTO){
        System.out.println("entered");
        userServiceImpl.signUP(userSignUpDTO.getUserName(),userSignUpDTO.getPassword(),userSignUpDTO.getConfirmPassword());
        return ResponseEntity.ok("registration done");
    }
}
