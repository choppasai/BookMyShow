package BookMYShow.Application.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.sql.Time;
import java.util.Date;

@Entity
@Data
public class Token extends Base{
    private String value;
    private Date expiryAt;
    @ManyToOne
    private User user;

}
