package com.example.cinemarestapi.repository;

import com.example.cinemarestapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
