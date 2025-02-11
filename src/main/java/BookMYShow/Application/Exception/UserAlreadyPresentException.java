package BookMYShow.Application.Exception;

public class UserAlreadyPresentException extends Exception{
    public UserAlreadyPresentException(String message){
        super(message);
    }
}
