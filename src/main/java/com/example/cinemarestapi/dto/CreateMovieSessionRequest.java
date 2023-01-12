package com.example.cinemarestapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateMovieSessionRequest {

    private String startDate;
    private String movieId;
    private String saloonId;
    private int price;

    public Date getStartDate() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
            return sdf.parse(this.startDate);
        } catch (ParseException e) {
            return new Date();
        }

    }
}
