package BookMYShow.Application.Service;

import BookMYShow.Application.Exception.MovieNotFoundException;
import BookMYShow.Application.Exception.UserNotFoundException;
import BookMYShow.Application.Model.Rating;

public interface RatingsService {
    public Rating rateMovie(int userId, int movieId, int rating) throws UserNotFoundException, MovieNotFoundException;

    public double getAverageRating(int movieId) throws MovieNotFoundException;
}
