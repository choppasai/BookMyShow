package BookMYShow.Application.Model;

import BookMYShow.Application.Model.Enums.SeatStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Show_Seat extends Base{
    @ManyToOne
    @JoinColumn(name = "showSeatId")
    private Show show;
    @ManyToOne
    private Seat seat;
    private SeatStatus seatStatus;
}
