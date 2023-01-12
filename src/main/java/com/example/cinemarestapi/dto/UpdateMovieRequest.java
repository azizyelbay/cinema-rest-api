package com.example.cinemarestapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateMovieRequest {

    private String name;
    private String genre;
    private int durationMin;
}
