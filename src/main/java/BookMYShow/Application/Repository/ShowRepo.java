package BookMYShow.Application.Repository;

import BookMYShow.Application.Model.Show;
import BookMYShow.Application.Model.Show_SeatType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ShowRepo extends JpaRepository<Show,Integer> {
    @Query("select e.showSeatTypes from event e where id = ?1")
    public List<Show_SeatType> findAllSeatTypesById(Integer showId);
}
