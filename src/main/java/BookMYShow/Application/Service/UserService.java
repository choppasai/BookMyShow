package BookMYShow.Application.Service;

import BookMYShow.Application.DTOs.UserRequestDTO;
import BookMYShow.Application.DTOs.UserSignUpDTO;
import BookMYShow.Application.Exception.UserAlreadyPresentException;
import BookMYShow.Application.Exception.UserNotFoundException;

public interface UserService {
    public void signIn(UserRequestDTO userRequestDTO) throws Exception;
    public void signUP(UserSignUpDTO userSignUpDTO) throws UserAlreadyPresentException;
}
