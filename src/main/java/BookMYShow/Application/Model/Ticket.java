package BookMYShow.Application.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Ticket extends Base{
    private Integer ticketNumber;
    private Long amount;
    @ManyToOne
    private User user;
    @ManyToOne
    private Show show;
    @OneToMany
    private List<Seat> seatList;
    @OneToMany(mappedBy = "ticket")
    private List<Payment> paymentList;
}

