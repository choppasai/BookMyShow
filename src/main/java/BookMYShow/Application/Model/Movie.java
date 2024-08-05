package BookMYShow.Application.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Movie extends Base{
    private String name;
    private List<String> castAndCrew;
    @OneToMany(mappedBy = "movie")
    private List<Show> show;
}
