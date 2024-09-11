package BookMYShow.Application.Repository;

import BookMYShow.Application.Model.Show_Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Show_SeatRepo extends JpaRepository<Show_Seat,Integer> {
}
