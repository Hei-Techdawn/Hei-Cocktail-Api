package com.example.helloworldapi.controller;

import com.example.helloworldapi.model.Drinks;
import com.example.helloworldapi.service.DrinksService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/drinks")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class DrinksController {

    private DrinksService drinksService;

    @GetMapping(value = "")
    public List<Drinks> getAll(
            @RequestParam("page") int page,
            @RequestParam("size") int size,
            @RequestParam(name = "sort", required = false) String sort
    ) {
        return drinksService.findAllDrinks(page, size,sort);
    }

    @PostMapping(value = "")
    public List<Drinks> postDrinks(
            @RequestBody List<Drinks> drinksList
    ) {
        return drinksService.createDrinks(drinksList);
    }

    @GetMapping(value = "/{id}")
    public Drinks getDrinksByCategory(@PathVariable int id) {
        return drinksService.findDrinks(id);
    }

    @PutMapping(value = "/{id}")
    public Drinks putDrinks(
            @PathVariable int id,
            @RequestBody Drinks drinks
    ) {
        return drinksService.updateDrinks(id, drinks);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteDrinks(
            @PathVariable int id
    ) {
        drinksService.removeDrinks(id);
    }

    @GetMapping(value = "/category/{idCategory}")
    public List<Drinks> getByIdCategory(@PathVariable int idCategory) {
        return drinksService.findDrinksByIdCategory(idCategory);
    }
}
