package com.example.cinemarestapi.dto.converter;

import com.example.cinemarestapi.dto.SaloonDto;
import com.example.cinemarestapi.model.Saloon;
import org.springframework.stereotype.Component;

@Component
public class SaloonDtoConverter {
    public SaloonDto convert(Saloon from) {
        return new SaloonDto(from.getId(),
                from.getName(),
                from.getTotalSeat()
        );
    }
}
