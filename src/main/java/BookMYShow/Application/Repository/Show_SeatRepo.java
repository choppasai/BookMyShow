package BookMYShow.Application.Repository;

import BookMYShow.Application.Model.Show_Seat;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Show_SeatRepo extends JpaRepository<Show_Seat,Integer> {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select s from Show_Seat s where s.show.id = ?1 and s.id in ?2")
    public List<Show_Seat> findAllShowSeatID(Integer showId, List<Integer> showSeatId);
}
