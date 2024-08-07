package BookMYShow.Application.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.TimeZone;

@Getter
@Setter
public class TicketResponseDTO {
    private Integer ticketNumber;
    private Double amount;
    private TimeZone showStartTime;
    private TimeZone showEndTime;
    private String userName;
    private String showName;
    private List<Integer> seatList;
}
