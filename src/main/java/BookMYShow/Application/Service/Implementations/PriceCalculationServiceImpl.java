package BookMYShow.Application.Service.Implementations;

import BookMYShow.Application.Model.Show_Seat;
import BookMYShow.Application.Model.Show_SeatType;
import BookMYShow.Application.Repository.ShowRepo;
import BookMYShow.Application.Service.PriceCalculationService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PriceCalculationServiceImpl implements PriceCalculationService {
    private final ShowRepo showRepo;
    public PriceCalculationServiceImpl(ShowRepo showRepo){
        this.showRepo = showRepo;
    }
    @Override
    public Double totalCost(List<Show_Seat> seatList, Integer showId) {
        Double amount = 0.0;
        int gst = 18;
        List<Show_SeatType> seatTypes = showRepo.findAllSeatTypes(showId);
        for(Show_Seat seat : seatList){
            for(Show_SeatType seatType : seatTypes){
                if(seat.getSeat().getSeatType().equals(seatTypes)){
                    Double price = seatType.getPrice();
                    amount+= price +0.18*price;
                }
            }
        }
        return amount;
    }
}
