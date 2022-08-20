package com.example.helloworldapi.controller;

import com.example.helloworldapi.model.Drinks;
import com.example.helloworldapi.service.DrinksService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/drinks")
@AllArgsConstructor
public class DrinksController {

    private DrinksService drinksService;

    @GetMapping(value = "")
    public List<Drinks> getAll(
            @RequestParam("page") int page,
            @RequestParam("size") int size
    ) {
        return drinksService.findAllDrinks(page, size);
    }
}
