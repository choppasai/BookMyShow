package BookMYShow.Application.Service.Implementations;


import BookMYShow.Application.DTOs.TicketResponseDTO;

import BookMYShow.Application.Exception.InvalidSeat;
import BookMYShow.Application.Exception.ShowNotFoundException;
import BookMYShow.Application.Exception.UserNotFoundException;
import BookMYShow.Application.Model.Enums.PaymentStatus;
import BookMYShow.Application.Model.Enums.SeatStatus;
import BookMYShow.Application.Model.Payment;
import BookMYShow.Application.Model.Show;
import BookMYShow.Application.Model.Show_Seat;
import BookMYShow.Application.Model.User;

import BookMYShow.Application.Exception.PaymentFailed;
import BookMYShow.Application.Repository.ShowRepo;
import BookMYShow.Application.Repository.Show_SeatRepo;
import BookMYShow.Application.Repository.UserRepository;
import BookMYShow.Application.Service.TicketService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;

@Service
public class TicketServiceImpl implements TicketService {
    private final UserRepository userRepository;
    private final Show_SeatRepo showSeatRepo;

    private final ShowRepo showRepo;
    private PriceCalculationServiceImpl priceCalculationService;

    public TicketServiceImpl(UserRepository userRepository, Show_SeatRepo showSeatRepo, ShowRepo showRepo) {
        this.userRepository = userRepository;
        this.showSeatRepo = showSeatRepo;
        this.showRepo = showRepo;
    }

    public TicketResponseDTO generateTicket(Integer userId, Integer showId, TimeZone startTime, TimeZone endTime, List<Integer> showSeatId)
            throws InvalidSeat,PaymentFailed,UserNotFoundException,ShowNotFoundException{
        Optional<User> user = userRepository.findById(userId);
        Optional<Show> show = showRepo.findById(showId);
        if(user.isEmpty())
            throw new UserNotFoundException("invalid user id");
        if(show.isEmpty())
            throw new ShowNotFoundException("invalid show id");
        List<Show_Seat> showSeat = showSeatRepo.findAllById(showSeatId);

        TicketResponseDTO ticketResponseDTO = new TicketResponseDTO();
        ticketResponseDTO.setUserName(user.get().getName());
        ticketResponseDTO.setShowName(show.get().getName());
        ticketResponseDTO.setShowStartTime(show.get().getShowStartTime());
        ticketResponseDTO.setShowEndTime(show.get().getShowEndTime());
        Double amount = priceCalculationService.totalCost(showSeat,showId);
        ticketResponseDTO.setAmount(amount);

        List<Integer> seatIds = new ArrayList<>();

        synchronized (this){
            for(Show_Seat seat : showSeat){
                if(seat.getSeatStatus() == SeatStatus.AVIALABLE){
                    seat.setSeatStatus(SeatStatus.BLOCKED);
                    showSeatRepo.save(seat);
                    seatIds.add(seat.getId());
                }
                else{
                    throw new InvalidSeat("Seat is already booked/blocked");
                }
            }


//        payments will takes place here

//        lets think payment is success.
            Payment payment = new Payment();
            if(payment.getPaymentStatus() == PaymentStatus.SUCCESS){
                for(Show_Seat seat : showSeat){
                    seat.setSeatStatus(SeatStatus.BOOKED);
                    showSeatRepo.save(seat);
                }
            }
            else{
                for(Show_Seat seat : showSeat){
                    seat.setSeatStatus(SeatStatus.AVIALABLE);
                    showSeatRepo.save(seat);
                    seatIds.remove(seat.getId());
                }
                throw new PaymentFailed("Payment failed");
            }

        }

        ticketResponseDTO.setSeatList(seatIds);
        return ticketResponseDTO;
    }
}
