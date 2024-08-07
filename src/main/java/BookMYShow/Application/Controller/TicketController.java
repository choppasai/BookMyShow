package BookMYShow.Application.Controller;

import BookMYShow.Application.DTOs.ShowDTO;
import BookMYShow.Application.DTOs.TicketRequestDTO;
import BookMYShow.Application.DTOs.TicketResponseDTO;
import BookMYShow.Application.Exception.InvalidSeat;
import BookMYShow.Application.Repository.PaymentFailed;
import BookMYShow.Application.Service.Implementations.TicketServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {
    private TicketServiceImpl ticketServiceImpl;
    public TicketController(TicketServiceImpl ticketServiceImpl){
        this.ticketServiceImpl = ticketServiceImpl;
    }
    public ResponseEntity<TicketResponseDTO> generateTicket(TicketRequestDTO ticketRequestDTO){
        ShowDTO showDTO = ticketRequestDTO.getShow();
        TicketResponseDTO ticketResponseDTO = null;
        try{
            ticketServiceImpl.generateTicket(ticketRequestDTO.getUserId(),
                    showDTO.getShowId(),showDTO.getShowStartTime(),showDTO.getShowEndTime(),
                    ticketRequestDTO.getShowSeatTypes());
        }
        catch (InvalidSeat | PaymentFailed e){
            e.getMessage();
        }
        return ResponseEntity.ok(ticketResponseDTO);
    }
}