package BookMYShow.Application.Repository;

import BookMYShow.Application.Model.Rating;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating,Integer> {
    @Query("select r from Rating r where r.user.id = ?1 and r.movie.id = ?2")
    public Optional<Rating> findRatingByUserAndMovie(int userId,int movieId);
    @Override
    public Rating save(Rating rating);
    @Query("select r from Rating r where r.movie.id = ?1")
    public List<Rating> findRatingByMovieId(int movieId);
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Rating r set r.rating = :newRating where r.id = :id")
    public void updateRatingByMovieId(@Param("id") int ratingId, @Param("newRating") int newRating);
    public List<Rating> findAll();
    public void deleteAll();
}

