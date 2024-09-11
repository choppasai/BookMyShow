package BookMYShow.Application.Exception;

public class PaymentFailed extends Exception{
    public PaymentFailed(String message){
        super(message);
    }
}
