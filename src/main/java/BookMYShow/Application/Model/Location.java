package BookMYShow.Application.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long locationId;
    private Long longitude;
    private Long latitude;
    @JoinColumn(name = "city_id")
    @OneToOne
    private City city;
}
