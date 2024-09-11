package BookMYShow.Application.Exception;

public class MovieNotFoundException extends Exception{
    public MovieNotFoundException(String message) {
        super(message);
    }
}
