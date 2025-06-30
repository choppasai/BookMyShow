package BookMYShow.Application.Service.Implementations;


import BookMYShow.Application.DTOs.TicketResponseDTO;

import BookMYShow.Application.Exception.*;
import BookMYShow.Application.Model.Enums.PaymentStatus;
import BookMYShow.Application.Model.Enums.SeatStatus;
import BookMYShow.Application.Model.Payment;
import BookMYShow.Application.Model.Show;
import BookMYShow.Application.Model.Show_Seat;
import BookMYShow.Application.Model.User;

import BookMYShow.Application.Repository.ShowRepo;
import BookMYShow.Application.Repository.Show_SeatRepo;
import BookMYShow.Application.Repository.UserRepository;
import BookMYShow.Application.Service.TicketService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
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
    private final GlobalExceptionHandler globalExceptionHandler;

    public TicketServiceImpl(UserRepository userRepository, Show_SeatRepo showSeatRepo, ShowRepo showRepo,GlobalExceptionHandler globalExceptionHandler) {
        this.userRepository = userRepository;
        this.showSeatRepo = showSeatRepo;
        this.showRepo = showRepo;
        this.globalExceptionHandler = globalExceptionHandler;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED,
                    rollbackFor = {PaymentFailed.class,UserNotFoundException.class,ShowNotFoundException.class})
    public TicketResponseDTO generateTicket(Integer userId, Integer showId, TimeZone startTime, TimeZone endTime, List<Integer> showSeatId)
            throws InvalidSeat,PaymentFailed,UserNotFoundException,ShowNotFoundException,SeatLimitExceed{
        Optional<User> user = userRepository.findById(userId);
        Optional<Show> show = showRepo.findById(showId);
        if(user.isEmpty())
            throw new UserNotFoundException("invalid user id");
        if(show.isEmpty())
            throw new ShowNotFoundException("invalid show id");
        if(showSeatId.size()>5)
            throw globalExceptionHandler.seatLimitExceeded("only 5 seats can be booked at a time");

        List<Integer> seatIds = new ArrayList<>();
        List<Show_Seat> showSeat = showSeatRepo.findAllShowSeatID(showId, showSeatId);

            for(Show_Seat seat : showSeat){
                if(seat.getSeatStatus().equals(SeatStatus.AVAILABLE)){
                    seat.setSeatStatus(SeatStatus.BLOCKED);
                    seatIds.add(seat.getId());
                }
                else{
                    throw new InvalidSeat("Seat is already booked/blocked");
                }
                showSeatRepo.saveAll(showSeat);
            }

//        payments will takes place here

//        lets think payment is success.
            Payment payment = new Payment();

            if(payment.getPaymentStatus().equals(PaymentStatus.SUCCESS)){
                for(Show_Seat seat : showSeat){
                    seat.setSeatStatus(SeatStatus.BOOKED);
                }
                showSeatRepo.saveAll(showSeat);
            }
            else
                throw new PaymentFailed("Payment failed");

        TicketResponseDTO ticketResponseDTO = new TicketResponseDTO();
        ticketResponseDTO.setUserName(user.get().getName());
        ticketResponseDTO.setShowName(show.get().getName());
        ticketResponseDTO.setShowStartTime(show.get().getShowStartTime());
        ticketResponseDTO.setShowEndTime(show.get().getShowEndTime());
        Double amount = priceCalculationService.totalCost(showSeat,showId);
        ticketResponseDTO.setAmount(amount);
        ticketResponseDTO.setSeatList(seatIds);
        return ticketResponseDTO;
    }
}
