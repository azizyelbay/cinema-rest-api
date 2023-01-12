package com.example.cinemarestapi.controller;

import com.example.cinemarestapi.dto.*;
import com.example.cinemarestapi.model.MovieSession;
import com.example.cinemarestapi.service.MovieSessionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/movie-session")
public class MovieSessionController {

    private final MovieSessionService movieSessionService;

    public MovieSessionController(MovieSessionService movieSessionService) {
        this.movieSessionService = movieSessionService;
    }

    @PostMapping
    public ResponseEntity<MovieSessionDto> createMovieSession(@RequestBody CreateMovieSessionRequest createMovieSessionRequest){
        return ResponseEntity.ok(movieSessionService.createMovieSession(createMovieSessionRequest));
    }

    @GetMapping
    public ResponseEntity<List<MovieSessionDto>> getAllMovieSessions(){
        return ResponseEntity.ok(movieSessionService.getAllMovieSessions());
    }

    @GetMapping("/{movieSessionId}")
    public ResponseEntity<MovieSessionDto> getMovieSessionById(@PathVariable String movieSessionId){
        return ResponseEntity.ok(movieSessionService.getMovieSessionById(movieSessionId));
    }

    @DeleteMapping("/{movieSessionId}")
    public ResponseEntity<Void> deleteMovieSession(@PathVariable String movieSessionId){
        movieSessionService.deleteMovieSession(movieSessionId);
        return ResponseEntity.ok().build();
    }
}
