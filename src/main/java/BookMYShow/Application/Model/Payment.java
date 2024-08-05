package BookMYShow.Application.Model;

import BookMYShow.Application.Model.Enums.PaymentMode;
import BookMYShow.Application.Model.Enums.PaymentProvider;
import BookMYShow.Application.Model.Enums.PaymentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Payment extends Base{
    private Long amount;
    private PaymentStatus paymentStatus;
    private PaymentMode paymentMode;
    private Integer referenceID;
    private PaymentProvider paymentProvider;
    @ManyToOne
    @JoinColumn(name = "payment_id")
    private Ticket ticket;
}
