package com.example.cinemarestapi.dto;

import com.example.cinemarestapi.model.Movie;
import com.example.cinemarestapi.model.Saloon;
import com.example.cinemarestapi.model.Seat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieSessionDto {

    private String id;
    private Date startDate;
    private Movie movie;
    private Saloon saloon;
    private List<Seat> seats;
    private int price;
}
