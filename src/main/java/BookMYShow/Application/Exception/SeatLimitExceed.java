package BookMYShow.Application.Exception;

public class SeatLimitExceed extends Exception{
    public SeatLimitExceed(String message) {
        super(message);
    }
}
