package BookMYShow.Application.Repository;

import BookMYShow.Application.Model.Show;
import BookMYShow.Application.Model.Show_SeatType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowRepo extends JpaRepository<Show,Integer> {
    public List<Show_SeatType> findAllSeatTypes(Integer showId);
}
