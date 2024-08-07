package BookMYShow.Application.DTOs;

import BookMYShow.Application.Model.Movie;
import BookMYShow.Application.Model.Screen;
import BookMYShow.Application.Model.Show_SeatType;
import BookMYShow.Application.Model.Theatre;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.TimeZone;
@Getter
@Setter
public class ShowDTO {
    private Integer showId;
    private TimeZone showStartTime;
    private TimeZone showEndTime;

}
