package BookMYShow.Application.Service;

import BookMYShow.Application.Exception.UserNotFoundException;

public interface UserService {
    public void signIn(String userName, String password) throws Exception;
    public void signUP(String userName, String password,String confirmPassword);
}
