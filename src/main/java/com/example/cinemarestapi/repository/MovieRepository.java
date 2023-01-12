package com.example.cinemarestapi.repository;

import com.example.cinemarestapi.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, String> {
}
