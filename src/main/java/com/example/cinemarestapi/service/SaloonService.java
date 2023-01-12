package com.example.cinemarestapi.service;

import com.example.cinemarestapi.dto.CreateSaloonRequest;
import com.example.cinemarestapi.dto.SaloonDto;
import com.example.cinemarestapi.dto.UpdateSaloonRequest;
import com.example.cinemarestapi.dto.converter.SaloonDtoConverter;
import com.example.cinemarestapi.exception.SaloonNotFoundException;
import com.example.cinemarestapi.model.Saloon;
import com.example.cinemarestapi.repository.SaloonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SaloonService {

    private final SaloonRepository saloonRepository;
    private final SaloonDtoConverter converter;

    public SaloonService(SaloonRepository saloonRepository, SaloonDtoConverter converter) {
        this.saloonRepository = saloonRepository;
        this.converter = converter;
    }

    public SaloonDto createSaloon (CreateSaloonRequest createSaloonRequest){
        Saloon saloon = new Saloon();
        saloon.setName(createSaloonRequest.getName());
        saloon.setTotalSeat(createSaloonRequest.getTotalSeat());

        return converter.convert(saloonRepository.save(saloon));
    }

    public List<SaloonDto> getAllSaloons() {
        return saloonRepository.findAll()
                .stream()
                .map(converter :: convert)
                .collect(Collectors.toList());
    }


    public SaloonDto getSaloonById(String saloonId) {
        return converter.convert(findSaloonById(saloonId));
    }

    protected Saloon findSaloonById(String id) {
        return saloonRepository.findById(id)
                .orElseThrow(
                        () -> new SaloonNotFoundException("Saloon could not find by id: " + id));

    }


    public SaloonDto updateSaloon(String saloonId, UpdateSaloonRequest updateSaloonRequest) {
        Saloon saloon = findSaloonById(saloonId);


        saloon.setName(updateSaloonRequest.getName());
        saloon.setTotalSeat(updateSaloonRequest.getTotalSeat());

        return converter.convert(saloonRepository.save(saloon));
    }

    public void deleteSaloon(String saloonId) {
        findSaloonById(saloonId);
        saloonRepository.deleteById(saloonId);
    }
}
