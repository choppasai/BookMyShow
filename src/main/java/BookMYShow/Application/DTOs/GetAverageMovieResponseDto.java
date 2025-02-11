package BookMYShow.Application.DTOs;


import BookMYShow.Application.DTOs.EnumDtos.ResponseStatus;
import lombok.Data;

@Data
public class GetAverageMovieResponseDto {
    private ResponseStatus responseStatus;
    private double averageRating;
}
