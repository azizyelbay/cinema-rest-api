package com.example.cinemarestapi.dto;

import com.example.cinemarestapi.model.MovieSession;
import com.example.cinemarestapi.model.Seat;
import com.example.cinemarestapi.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketDto {

    private String id;
    private User user;
    private Seat seat;
    private MovieSession movieSession;
}
