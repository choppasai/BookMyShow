package BookMYShow.Application.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@Entity
public class Seat extends Base{
    private String seatId;
    @ManyToOne
    private SeatType seatType;
    @ManyToOne
    @JoinColumn(name = "screen_Id")
    private Screen screen;
    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;
}
