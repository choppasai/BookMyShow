package BookMYShow.Application.Model;

import BookMYShow.Application.Model.Enums.Features;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.TimeZone;

@Getter
@Setter
@Entity(name = "event")
public class Show extends Base{
    private String name;
    @ManyToOne
    @JoinColumn(name = "Movie_id")
    private Movie movie;

    private TimeZone showStartTime;
    private TimeZone showEndTime;

    @ElementCollection(targetClass = Features.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "Features", joinColumns = @JoinColumn(name = "show_id"))
    @Column(name = "feature")
    private List<Features> featuresList;

    @ManyToOne
    @JoinColumn(name = "screen_id")
    private Screen screen;

    @OneToMany(mappedBy = "show")
    private List<Show_SeatType> showSeatTypes;
}
