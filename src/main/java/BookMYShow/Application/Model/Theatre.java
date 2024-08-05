package BookMYShow.Application.Model;


import BookMYShow.Application.Model.Base;
import BookMYShow.Application.Model.City;
import BookMYShow.Application.Model.Location;
import BookMYShow.Application.Model.Screen;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Theatre extends Base {
    private String name;
    @OneToOne
    private Location location;
    @OneToMany(mappedBy = "theatre")
    private List<Screen> screens;
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
}

