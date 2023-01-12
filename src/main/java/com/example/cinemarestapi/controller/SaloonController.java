package com.example.cinemarestapi.controller;

import com.example.cinemarestapi.dto.*;
import com.example.cinemarestapi.service.SaloonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/saloon")
public class SaloonController {

    private final SaloonService saloonService;

    public SaloonController(SaloonService saloonService) {
        this.saloonService = saloonService;
    }

    @PostMapping
    public ResponseEntity<SaloonDto> createSaloon(@RequestBody CreateSaloonRequest createSaloonRequest){
        return ResponseEntity.ok(saloonService.createSaloon(createSaloonRequest));
    }

    @GetMapping
    public ResponseEntity<List<SaloonDto>> getAllSaloons(){
        return ResponseEntity.ok(saloonService.getAllSaloons());
    }

    @GetMapping("/{saloonId}")
    public ResponseEntity<SaloonDto> getSaloonById(@PathVariable String saloonId){
        return ResponseEntity.ok(saloonService.getSaloonById(saloonId));
    }

    @PutMapping("/{saloonId}")
    public ResponseEntity<SaloonDto> updateSaloon(@PathVariable String saloonId,
                                                @RequestBody UpdateSaloonRequest updateSaloonRequest){

        return ResponseEntity.ok(saloonService.updateSaloon(saloonId, updateSaloonRequest));
    }

    @DeleteMapping("/{saloonId}")
    public ResponseEntity<Void> deleteSaloon(@PathVariable String saloonId){
        saloonService.deleteSaloon(saloonId);
        return ResponseEntity.ok().build();
    }
}
