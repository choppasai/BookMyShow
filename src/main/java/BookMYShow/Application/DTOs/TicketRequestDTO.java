package BookMYShow.Application.DTOs;

import BookMYShow.Application.Model.Show;
import BookMYShow.Application.Model.Show_Seat;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TicketRequestDTO {
    private Integer userId;
    private ShowDTO show;
    private List<Integer> showSeatTypes;
}
