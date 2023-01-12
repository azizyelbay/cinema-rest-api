package com.example.cinemarestapi.repository;

import com.example.cinemarestapi.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, String> {
}
