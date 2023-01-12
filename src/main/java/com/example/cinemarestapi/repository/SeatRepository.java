package com.example.cinemarestapi.repository;

import com.example.cinemarestapi.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, String> {
}
