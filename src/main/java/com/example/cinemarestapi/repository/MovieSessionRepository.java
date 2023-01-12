package com.example.cinemarestapi.repository;

import com.example.cinemarestapi.model.MovieSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieSessionRepository extends JpaRepository<MovieSession, String> {
}
