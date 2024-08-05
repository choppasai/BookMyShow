package BookMYShow.Application.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class City extends Base{
    private String name;
    @OneToOne(mappedBy = "city")
    private Location location;
    @OneToMany(mappedBy = "city")
    private List<Theatre> theatreList;



    /*
    city - location -> 1: 1
    threatre - > city
        1        1
        m          1

     */
}
