package BookMYShow.Application.Exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    public SeatLimitExceed seatLimitExceeded(String message) {
        return new SeatLimitExceed(message);
    }
}
