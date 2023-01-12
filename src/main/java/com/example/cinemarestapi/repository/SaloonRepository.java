package com.example.cinemarestapi.repository;

import com.example.cinemarestapi.model.Saloon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaloonRepository extends JpaRepository<Saloon, String> {
}
