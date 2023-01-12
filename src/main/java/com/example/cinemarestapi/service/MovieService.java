package com.example.cinemarestapi.service;

import com.example.cinemarestapi.dto.CreateMovieRequest;
import com.example.cinemarestapi.dto.MovieDto;
import com.example.cinemarestapi.dto.UpdateMovieRequest;
import com.example.cinemarestapi.dto.converter.MovieDtoConverter;
import com.example.cinemarestapi.exception.MovieNotFoundException;
import com.example.cinemarestapi.model.Movie;
import com.example.cinemarestapi.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {

    private final MovieRepository movieRepository;
    private final MovieDtoConverter converter;

    public MovieService(MovieRepository movieRepository, MovieDtoConverter converter) {
        this.movieRepository = movieRepository;
        this.converter = converter;
    }

    public MovieDto createMovie (CreateMovieRequest createMovieRequest){
        Movie movie = new Movie();
        movie.setName(createMovieRequest.getName());
        movie.setGenre(createMovieRequest.getGenre());
        movie.setDurationMin(createMovieRequest.getDurationMin());

        return converter.convert(movieRepository.save(movie));
    }

    public List<MovieDto> getAllMovies() {
        return movieRepository.findAll()
                .stream()
                .map(converter :: convert)
                .collect(Collectors.toList());
    }


    public MovieDto getMovieById(String movieId) {
        return converter.convert(findMovieById(movieId));
    }

    protected Movie findMovieById(String id) {
        return movieRepository.findById(id)
                .orElseThrow(
                        () -> new MovieNotFoundException("Movie could not find by id: " + id));

    }


    public MovieDto updateMovie(String movieId, UpdateMovieRequest updateMovieRequest) {
        Movie movie = findMovieById(movieId);

        Movie updateMovie = new Movie();
        updateMovie.setId(movie.getId());
        updateMovie.setName(updateMovieRequest.getName());
        updateMovie.setGenre(updateMovieRequest.getGenre());
        updateMovie.setDurationMin(updateMovieRequest.getDurationMin());

        return converter.convert(movieRepository.save(updateMovie));
    }

    public void deleteMovie(String movieId) {
        findMovieById(movieId);
        movieRepository.deleteById(movieId);
    }
}
