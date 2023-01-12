package com.example.cinemarestapi.dto.converter;

import com.example.cinemarestapi.dto.MovieSessionDto;
import com.example.cinemarestapi.model.MovieSession;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionDtoConverter {
    public MovieSessionDto convert(MovieSession from){
        return new MovieSessionDto(
                from.getId(),
                from.getStartDate(),
                from.getMovie(),
                from.getSaloon(),
                from.getSeats(),
                from.getPrice()
        );
    }
}
