package com.example.cinemarestapi.controller;

import com.example.cinemarestapi.dto.RezerveTicketRequest;
import com.example.cinemarestapi.dto.TicketDto;
import com.example.cinemarestapi.service.TicketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/ticket")
public class TicketController {

    private  final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping(path = "/rezerve-ticket")
    public ResponseEntity<TicketDto> rezerveTicket(@RequestBody RezerveTicketRequest rezerveTicketRequest) {
        return ResponseEntity.ok(ticketService.rezerveTicket(rezerveTicketRequest));
    }
}

