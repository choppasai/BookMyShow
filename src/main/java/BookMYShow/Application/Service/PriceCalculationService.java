package BookMYShow.Application.Service;

import BookMYShow.Application.Model.Show;
import BookMYShow.Application.Model.Show_Seat;

import java.util.List;

public interface PriceCalculationService {
    Double totalCost(List<Show_Seat> seatList, Integer showId);

}
