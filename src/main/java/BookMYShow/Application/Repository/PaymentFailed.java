package BookMYShow.Application.Repository;

public class PaymentFailed extends Exception{
    public PaymentFailed(String message){
        super(message);
    }
}
