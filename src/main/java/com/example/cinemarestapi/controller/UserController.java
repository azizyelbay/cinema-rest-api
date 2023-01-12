package com.example.cinemarestapi.controller;

import com.example.cinemarestapi.model.User;
import com.example.cinemarestapi.repository.UserRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/v1/user")
public class UserController {
// ********************* WEB SECURITY EKLENIP DUZENLENECEK***********/////////////////////////////////////
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public void createUser(){
        User user = new User();
        user.setUserName("aziz594");
        user.setPassword("denenme594");
        user.setDigitalCurrencyLoan(1000);
        userRepository.save(user);
    }
}
