package com.example.cinemarestapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)

public class MovieSessionNotFoundException extends RuntimeException{
    public MovieSessionNotFoundException(String message) {
        super(message);
    }
}
