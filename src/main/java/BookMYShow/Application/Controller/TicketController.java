package BookMYShow.Application.Controller;

import BookMYShow.Application.DTOs.ShowDTO;
import BookMYShow.Application.DTOs.TicketRequestDTO;
import BookMYShow.Application.DTOs.TicketResponseDTO;
import BookMYShow.Application.Exception.InvalidSeat;
import BookMYShow.Application.Exception.PaymentFailed;
import BookMYShow.Application.Exception.ShowNotFoundException;
import BookMYShow.Application.Exception.UserNotFoundException;
import BookMYShow.Application.Service.Implementations.TicketServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
public class TicketController {
    private final TicketServiceImpl ticketServiceImpl;
    public TicketController(TicketServiceImpl ticketServiceImpl){
        this.ticketServiceImpl = ticketServiceImpl;
    }
    @GetMapping("/generate")
    public ResponseEntity<TicketResponseDTO> generateTicket(TicketRequestDTO ticketRequestDTO){
        ShowDTO showDTO = ticketRequestDTO.getShow();
        TicketResponseDTO ticketResponseDTO = null;
        try{
            ticketServiceImpl.generateTicket(ticketRequestDTO.getUserId(),
                    showDTO.getShowId(),showDTO.getShowStartTime(),showDTO.getShowEndTime(),
                    ticketRequestDTO.getShowSeatTypes());
        }
        catch (InvalidSeat | PaymentFailed | UserNotFoundException | ShowNotFoundException e){
            e.getMessage();
        }
        return ResponseEntity.ok(ticketResponseDTO);
    }
}