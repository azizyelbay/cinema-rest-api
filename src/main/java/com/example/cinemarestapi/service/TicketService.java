package com.example.cinemarestapi.service;

import com.example.cinemarestapi.dto.RezerveTicketRequest;
import com.example.cinemarestapi.dto.TicketDto;
import com.example.cinemarestapi.dto.converter.TicketDtoConverter;
import com.example.cinemarestapi.model.*;
import com.example.cinemarestapi.repository.TicketRepository;
import com.example.cinemarestapi.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    private final MovieSessionService movieSessionService;
    private final UserRepository userRepository;
    private final TicketRepository ticketRepository;
    private final TicketDtoConverter converter;

    public TicketService(MovieSessionService movieSessionService, UserRepository userRepository, TicketRepository ticketRepository, TicketDtoConverter converter) {
        this.movieSessionService = movieSessionService;
        this.userRepository = userRepository;
        this.ticketRepository = ticketRepository;
        this.converter = converter;
    }

    public TicketDto rezerveTicket(RezerveTicketRequest rezerveTicketRequest){
        MovieSession movieSession = movieSessionService.findMovieSessionById(rezerveTicketRequest.getMovieSessionId());
        List<Seat> seatList = movieSession.getSeats();
        Seat seat = seatList.get(rezerveTicketRequest.getSeatNumber()-1);
        if(seat.getSeatStatus() == SeatStatus.AVAILABLE){
            seat.setSeatStatus(SeatStatus.REZERVED);
            seatList.set(rezerveTicketRequest.getSeatNumber()-1, seat);
            movieSession.setSeats(seatList);
            User user = userRepository.findById(rezerveTicketRequest.getUserId()).orElseThrow();
            Ticket ticket = new Ticket();
            ticket.setSeat(seat);
            ticket.setUser(user);
            ticket.setMovieSession(movieSession);

            return converter.convert(ticketRepository.save(ticket));
        }else{
            return new TicketDto();// düzenlenecek
        }

    }
}
