package com.example.cinemarestapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RezerveTicketRequest {

    private String userId;
    private String movieSessionId;
    private int seatNumber;
}
