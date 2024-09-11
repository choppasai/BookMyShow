package BookMYShow.Application.Controller;

import BookMYShow.Application.DTOs.*;
import BookMYShow.Application.Exception.MovieNotFoundException;
import BookMYShow.Application.Exception.UserNotFoundException;
import BookMYShow.Application.Model.Rating;
import BookMYShow.Application.Service.RatingsService;
import org.springframework.stereotype.Controller;

@Controller
public class RatingsController {
    private final RatingsService ratingsService;
    public RatingsController(RatingsService ratingsService){
        this.ratingsService = ratingsService;
    }

    public RateMovieResponseDto rateMovie(RateMovieRequestDto requestDto){
        Rating rating = null;
        RateMovieResponseDto rateMovieResponseDto = new RateMovieResponseDto();
        try{
            rating = ratingsService.rateMovie(requestDto.getUserId(), requestDto.getMovieId(),requestDto.getRating());
            rateMovieResponseDto.setRating(rating);
            rateMovieResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
        }
        catch(MovieNotFoundException | UserNotFoundException e){
            rateMovieResponseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return rateMovieResponseDto;
    }

    public GetAverageMovieResponseDto getAverageMovieRating(GetAverageMovieRequestDto requestDto){
        GetAverageMovieResponseDto responseDto = new GetAverageMovieResponseDto();
        double average = 0.0;
        try{
            average = ratingsService.getAverageRating(requestDto.getMovieId());
            responseDto.setAverageRating(average);
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        }
        catch(MovieNotFoundException e){
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDto;
    }
}

