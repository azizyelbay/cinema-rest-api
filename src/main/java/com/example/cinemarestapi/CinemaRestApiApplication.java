package com.example.cinemarestapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CinemaRestApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CinemaRestApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("baslatilirken calisir.");
	}
}
