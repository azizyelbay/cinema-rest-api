package com.example.cinemarestapi.service;

import com.example.cinemarestapi.dto.*;
import com.example.cinemarestapi.dto.converter.MovieSessionDtoConverter;
import com.example.cinemarestapi.exception.MovieNotFoundException;
import com.example.cinemarestapi.exception.MovieSessionNotFoundException;
import com.example.cinemarestapi.model.*;
import com.example.cinemarestapi.repository.MovieSessionRepository;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieSessionService {

    private final MovieSessionRepository movieSessionRepository;
    private final MovieSessionDtoConverter converter;
    private final MovieService movieService;
    private final SaloonService saloonService;

    public MovieSessionService(MovieSessionRepository movieSessionRepository, MovieSessionDtoConverter converter, MovieService movieService, SaloonService saloonService) {
        this.movieSessionRepository = movieSessionRepository;
        this.converter = converter;
        this.movieService = movieService;
        this.saloonService = saloonService;
    }

    public MovieSessionDto createMovieSession(CreateMovieSessionRequest createMovieSessionRequest){
        Movie movie = movieService.findMovieById(createMovieSessionRequest.getMovieId());
        Saloon saloon = saloonService.findSaloonById(createMovieSessionRequest.getSaloonId());

        MovieSession movieSession = new MovieSession();
        movieSession.setStartDate(createMovieSessionRequest.getStartDate());
        movieSession.setMovie(movie);
        movieSession.setSaloon(saloon);
        List<Seat> seats = new ArrayList<>();
        for(int i = 0; i < saloon.getTotalSeat(); i++) {
                Seat seat = new Seat();
                seat.setMovieSession(movieSession);
                seat.setNumber(i + 1);
                seat.setSeatStatus(SeatStatus.AVAILABLE);

                seats.add(seat);
        }
        movieSession.setSeats(seats);
        movieSession.setPrice(createMovieSessionRequest.getPrice());

        return converter.convert(movieSessionRepository.save(movieSession));
    }

    public List<MovieSessionDto> getAllMovieSessions() {
        return movieSessionRepository.findAll()
                .stream()
                .map(converter :: convert)
                .collect(Collectors.toList());
    }

    public MovieSessionDto getMovieSessionById(String movieSessionId) {
        return converter.convert(findMovieSessionById(movieSessionId));
    }

    public MovieSession findMovieSessionById(String id) {
        return movieSessionRepository.findById(id)
                .orElseThrow(
                        () -> new MovieSessionNotFoundException("Movie Session could not find by id: " + id));
    }

    public void deleteMovieSession(String movieSessionId) {
        findMovieSessionById(movieSessionId);
        movieSessionRepository.deleteById(movieSessionId);
    }
}
