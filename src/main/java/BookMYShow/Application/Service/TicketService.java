package BookMYShow.Application.Service;

import BookMYShow.Application.DTOs.TicketResponseDTO;
import BookMYShow.Application.Exception.InvalidSeat;

import java.util.List;
import java.util.TimeZone;

public interface TicketService {
    public TicketResponseDTO generateTicket(Integer userId, Integer showId, TimeZone startTime, TimeZone endTime, List<Integer> showSeatId) throws Exception;
}
