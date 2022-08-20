package com.example.helloworldapi.service;

import com.example.helloworldapi.model.Drinks;
import com.example.helloworldapi.repository.DrinksRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class DrinksService {
    private DrinksRepository drinksRepository;

    public List<Drinks> findAllDrinks(int page, int size) {
        return drinksRepository.findAll(PageRequest.of(page, size)).toList();
    }
}
