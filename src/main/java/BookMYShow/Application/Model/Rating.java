package BookMYShow.Application.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rating extends Base{
    @ManyToOne
    private User user;
    @ManyToOne
    private Movie movie;
    private int rating;
}
