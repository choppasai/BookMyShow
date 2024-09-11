package BookMYShow.Application.Repository;

import BookMYShow.Application.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {
    public Optional<Movie> findMovieById(Integer movieId);
    public Movie save(Movie movie);
    public List<Movie> findAll();
    public void deleteAll();
}
