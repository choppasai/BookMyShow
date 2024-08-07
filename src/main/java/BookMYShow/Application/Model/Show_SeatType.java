package BookMYShow.Application.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Show_SeatType extends Base{
    @ManyToOne
    private Show show;
    @ManyToOne
    private SeatType seatType;
    private Double price;
}
