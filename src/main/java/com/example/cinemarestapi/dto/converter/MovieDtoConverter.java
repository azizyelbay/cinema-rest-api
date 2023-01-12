package com.example.cinemarestapi.dto.converter;

import com.example.cinemarestapi.dto.MovieDto;
import com.example.cinemarestapi.model.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieDtoConverter {
    public MovieDto convert(Movie from) {
        return new MovieDto(from.getId(),
                from.getName(),
                from.getGenre(),
                from.getDurationMin()
        );
    }
}
