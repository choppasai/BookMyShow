package BookMYShow.Application.Model;

import BookMYShow.Application.Model.Enums.Features;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Screen extends Base{
    private String name;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<Features> featuresList;

    @OneToMany(mappedBy = "screen")
    private List<Seat> seatList;

    @ManyToOne
    @JoinColumn(name = "theatre_id")
    private Theatre theatre;

    @OneToMany(mappedBy = "screen")
    private List<Show> shows;
}
