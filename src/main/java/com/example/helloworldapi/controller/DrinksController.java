package com.example.helloworldapi.controller;

import com.example.helloworldapi.model.Drink;
import com.example.helloworldapi.service.DataFormat;
import com.example.helloworldapi.service.DrinkService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/drinks")
@AllArgsConstructor
@CrossOrigin
public class DrinksController {

    private DrinkService drinkService;

    @GetMapping(value = "")
    public DataFormat<Drink> getAll(
            @RequestParam("page") int page,
            @RequestParam("size") int size
    ) {
        return drinkService.findAllDrinks(page - 1, size);
    }

    @PostMapping(value = "")
    public List<Drink> postDrinks(
            @RequestBody List<Drink> drinkList
    ) {
        return drinkService.createDrinks(drinkList);
    }

    @GetMapping(value = "/{id}")
    public Drink getDrinksByCategory(@PathVariable int id) {
        return drinkService.findDrinks(id);
    }

    @PutMapping(value = "/{id}")
    public Drink putDrinks(
            @PathVariable int id,
            @RequestBody Drink drink
    ) {
        return drinkService.updateDrinks(id, drink);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteDrinks(
            @PathVariable int id
    ) {
        drinkService.removeDrinks(id);
    }

    @GetMapping(value = "/category/{idCategory}")
    public List<Drink> getByIdCategory(@PathVariable int idCategory) {
        return drinkService.findDrinksByIdCategory(idCategory);
    }
}
