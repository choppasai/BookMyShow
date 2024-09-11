package BookMYShow.Application.Service.Implementations;

import BookMYShow.Application.Exception.MovieNotFoundException;
import BookMYShow.Application.Exception.UserNotFoundException;
import BookMYShow.Application.Model.Movie;
import BookMYShow.Application.Model.Rating;
import BookMYShow.Application.Model.User;
import BookMYShow.Application.Repository.MovieRepository;
import BookMYShow.Application.Repository.RatingRepository;
import BookMYShow.Application.Repository.UserRepository;
import BookMYShow.Application.Service.RatingsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingsServiceImpl implements RatingsService {
    private final UserRepository userRepository;
    private final RatingRepository ratingRepository;
    private final MovieRepository movieRepository;
    public RatingsServiceImpl(UserRepository userRepository,RatingRepository ratingRepository,
                              MovieRepository movieRepository){
        this.movieRepository = movieRepository;
        this.ratingRepository = ratingRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Rating rateMovie(int userId, int movieId, int rating) throws UserNotFoundException, MovieNotFoundException {
        Optional<User> optionalUser = userRepository.findById(userId);
        Optional<Movie> optionalMovie = movieRepository.findById(movieId);
        Optional<Rating> optionalRating = ratingRepository.findRatingByUserAndMovie(userId, movieId);
        if(optionalUser.isEmpty())
            throw new UserNotFoundException("Invalid user id");
        if(optionalMovie.isEmpty())
            throw new MovieNotFoundException("Movie not present");
        Rating movieRating = null;

        if(optionalRating.isEmpty()){
            movieRating = new Rating(optionalUser.get(),optionalMovie.get(),rating);
            ratingRepository.save(movieRating);
        }

        else{
            ratingRepository.updateRatingByMovieId(optionalRating.get().getId(),rating);

        }

        return movieRating;
    }

    @Override
    public double getAverageRating(int movieId) throws MovieNotFoundException {
        Optional<Movie> optionalMovie = movieRepository.findMovieById(movieId);

        if(optionalMovie.isEmpty())
            throw new MovieNotFoundException("Invalid movie");
        List<Rating> movieRatingList = ratingRepository.findRatingByMovieId(movieId);
        double sum = 0.0;
        for(Rating rating : movieRatingList){
            sum+=rating.getRating();
        }
        return sum/movieRatingList.size();
    }

}

