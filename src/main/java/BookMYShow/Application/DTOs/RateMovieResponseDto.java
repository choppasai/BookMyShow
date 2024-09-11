package BookMYShow.Application.DTOs;

import BookMYShow.Application.Model.Rating;
import lombok.Data;

@Data
public class RateMovieResponseDto {
    private ResponseStatus responseStatus;
    private Rating rating;
}