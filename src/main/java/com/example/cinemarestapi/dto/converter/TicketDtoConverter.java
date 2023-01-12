package com.example.cinemarestapi.dto.converter;

import com.example.cinemarestapi.dto.MovieDto;
import com.example.cinemarestapi.dto.TicketDto;
import com.example.cinemarestapi.model.Movie;
import com.example.cinemarestapi.model.Ticket;
import org.springframework.stereotype.Component;

@Component
public class TicketDtoConverter {
    public TicketDto convert(Ticket from) {
        return new TicketDto(from.getId(),
                from.getUser(),
                from.getSeat(),
                from.getMovieSession()
        );
    }
}
